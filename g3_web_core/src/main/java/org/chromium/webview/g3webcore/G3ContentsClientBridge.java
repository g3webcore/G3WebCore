// Copyright 2013 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.webview.g3webcore;

import android.content.Context;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Handler;
import android.util.Log;

import org.chromium.base.Callback;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.CalledByNativeUnchecked;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeMethods;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.base.task.PostTask;
import org.chromium.content_public.browser.UiThreadTaskTraits;
import org.chromium.net.NetError;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.x500.X500Principal;

@JNINamespace("g3webcore")
public class G3ContentsClientBridge {
    private static final String TAG = "G3ContentsClientBridge";

    private G3ContentsClient mClient;
    private Context mContext;
    // The native peer of this object.
    private long mNativeContentsClientBridge;

    private final ClientCertLookupTable mLookupTable;

    // Used for mocking this class in tests.
    protected G3ContentsClientBridge(ClientCertLookupTable table) {
        mLookupTable = table;
    }

    public G3ContentsClientBridge(Context context, G3ContentsClient client,
            ClientCertLookupTable table) {
        assert client != null;
        mContext = context;
        mClient = client;
        mLookupTable = table;
    }

    public class ClientCertificateRequestCallback {

        private final int mId;
        private final String mHost;
        private final int mPort;
        private boolean mIsCalled;

        public ClientCertificateRequestCallback(int id, String host, int port) {
            mId = id;
            mHost = host;
            mPort = port;
        }

        public void proceed(final PrivateKey privateKey, final X509Certificate[] chain) {
            PostTask.runOrPostTask(
                    UiThreadTaskTraits.DEFAULT, () -> proceedOnUiThread(privateKey, chain));
        }

        public void ignore() {
            PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT, () -> ignoreOnUiThread());
        }

        public void cancel() {
            PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT, () -> cancelOnUiThread());
        }

        private void proceedOnUiThread(PrivateKey privateKey, X509Certificate[] chain) {
            checkIfCalled();

            if (privateKey == null || chain == null || chain.length == 0) {
                Log.w(TAG, "Empty client certificate chain?");
                provideResponse(null, null);
                return;
            }
            // Encode the certificate chain.
            byte[][] encodedChain = new byte[chain.length][];
            try {
                for (int i = 0; i < chain.length; ++i) {
                    encodedChain[i] = chain[i].getEncoded();
                }
            } catch (CertificateEncodingException e) {
                Log.w(TAG, "Could not retrieve encoded certificate chain: " + e);
                provideResponse(null, null);
                return;
            }
            mLookupTable.allow(mHost, mPort, privateKey, encodedChain);
            provideResponse(privateKey, encodedChain);
        }

        private void ignoreOnUiThread() {
            checkIfCalled();
            provideResponse(null, null);
        }

        private void cancelOnUiThread() {
            checkIfCalled();
            mLookupTable.deny(mHost, mPort);
            provideResponse(null, null);
        }

        private void checkIfCalled() {
            if (mIsCalled) {
                throw new IllegalStateException("The callback was already called.");
            }
            mIsCalled = true;
        }

        private void provideResponse(PrivateKey privateKey, byte[][] certChain) {
            if (mNativeContentsClientBridge == 0) return;
            G3ContentsClientBridgeJni.get().provideClientCertificateResponse(
                    mNativeContentsClientBridge, G3ContentsClientBridge.this, mId, certChain,
                    privateKey);
        }
    }

    // Used by the native peer to set/reset a weak ref to the native peer.
    @CalledByNative
    private void setNativeContentsClientBridge(long nativeContentsClientBridge) {
        mNativeContentsClientBridge = nativeContentsClientBridge;
    }

    // If returns false, the request is immediately canceled, and any call to proceedSslError
    // has no effect. If returns true, the request should be canceled or proceeded using
    // proceedSslError().
    // Unlike the webview classic, we do not keep keep a database of certificates that
    // are allowed by the user, because this functionality is already handled via
    // ssl_policy in native layers.
    @CalledByNative
    private boolean allowCertificateError(int certError, byte[] derBytes, final String url,
            final int id) {
        final SslCertificate cert = SslUtil.getCertificateFromDerBytes(derBytes);
        if (cert == null) {
            // if the certificate or the client is null, cancel the request
            return false;
        }
        final SslError sslError = SslUtil.sslErrorFromNetErrorCode(certError, cert, url);
        final Callback<Boolean> callback = value
                -> PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT,
                        () -> proceedSslError(value.booleanValue(), id));
        // Post the application callback back to the current thread to ensure the application
        // callback is executed without any native code on the stack. This so that any exception
        // thrown by the application callback won't have to be propagated through a native call
        // stack.
        new Handler().post(() -> mClient.onReceivedSslError(callback, sslError));

        // Record UMA on ssl error
        // Use sparse histogram in case new values are added in future releases
        RecordHistogram.recordSparseHistogram(
                "Android.WebView.onReceivedSslError.ErrorCode", sslError.getPrimaryError());
        return true;
    }

    private void proceedSslError(boolean proceed, int id) {
        if (mNativeContentsClientBridge == 0) return;
        G3ContentsClientBridgeJni.get().proceedSslError(
                mNativeContentsClientBridge, G3ContentsClientBridge.this, proceed, id);
    }

    // Intentionally not private for testing the native peer of this class.
    @CalledByNative
    protected void selectClientCertificate(final int id, final String[] keyTypes,
            byte[][] encodedPrincipals, final String host, final int port) {
        assert mNativeContentsClientBridge != 0;
        ClientCertLookupTable.Cert cert = mLookupTable.getCertData(host, port);
        if (mLookupTable.isDenied(host, port)) {
            G3ContentsClientBridgeJni.get().provideClientCertificateResponse(
                    mNativeContentsClientBridge, G3ContentsClientBridge.this, id, null, null);
            return;
        }
        if (cert != null) {
            G3ContentsClientBridgeJni.get().provideClientCertificateResponse(
                    mNativeContentsClientBridge, G3ContentsClientBridge.this, id, cert.mCertChain,
                    cert.mPrivateKey);
            return;
        }
        // Build the list of principals from encoded versions.
        Principal[] principals = null;
        if (encodedPrincipals.length > 0) {
            principals = new X500Principal[encodedPrincipals.length];
            for (int n = 0; n < encodedPrincipals.length; n++) {
                try {
                    principals[n] = new X500Principal(encodedPrincipals[n]);
                } catch (IllegalArgumentException e) {
                    Log.w(TAG, "Exception while decoding issuers list: " + e);
                    G3ContentsClientBridgeJni.get().provideClientCertificateResponse(
                            mNativeContentsClientBridge, G3ContentsClientBridge.this, id, null,
                            null);
                    return;
                }
            }

        }

        final ClientCertificateRequestCallback callback =
                new ClientCertificateRequestCallback(id, host, port);
        mClient.onReceivedClientCertRequest(callback, keyTypes, principals, host, port);

        // Record UMA for onReceivedClientCertRequest.
        G3HistogramRecorder.recordCallbackInvocation(
                G3HistogramRecorder.WebViewCallbackType.ON_RECEIVED_CLIENT_CERT_REQUEST);
    }

    @CalledByNative
    private void handleJsAlert(final String url, final String message, final int id) {
        // Post the application callback back to the current thread to ensure the application
        // callback is executed without any native code on the stack. This so that any exception
        // thrown by the application callback won't have to be propagated through a native call
        // stack.
        new Handler().post(() -> {
            JsResultHandler handler = new JsResultHandler(G3ContentsClientBridge.this, id);
            mClient.handleJsAlert(url, message, handler);
        });
    }

    @CalledByNative
    private void handleJsConfirm(final String url, final String message, final int id) {
        // Post the application callback back to the current thread to ensure the application
        // callback is executed without any native code on the stack. This so that any exception
        // thrown by the application callback won't have to be propagated through a native call
        // stack.
        new Handler().post(() -> {
            JsResultHandler handler = new JsResultHandler(G3ContentsClientBridge.this, id);
            mClient.handleJsConfirm(url, message, handler);
        });
    }

    @CalledByNative
    private void handleJsPrompt(
            final String url, final String message, final String defaultValue, final int id) {
        // Post the application callback back to the current thread to ensure the application
        // callback is executed without any native code on the stack. This so that any exception
        // thrown by the application callback won't have to be propagated through a native call
        // stack.
        new Handler().post(() -> {
            JsResultHandler handler = new JsResultHandler(G3ContentsClientBridge.this, id);
            mClient.handleJsPrompt(url, message, defaultValue, handler);
        });
    }

    @CalledByNative
    private void handleJsBeforeUnload(final String url, final String message, final int id) {
        // Post the application callback back to the current thread to ensure the application
        // callback is executed without any native code on the stack. This so that any exception
        // thrown by the application callback won't have to be propagated through a native call
        // stack.
        new Handler().post(() -> {
            JsResultHandler handler = new JsResultHandler(G3ContentsClientBridge.this, id);
            mClient.handleJsBeforeUnload(url, message, handler);
        });
    }

    @CalledByNative
    private void newDownload(String url, String userAgent, String contentDisposition,
            String mimeType, long contentLength) {
        mClient.getCallbackHelper().postOnDownloadStart(
                url, userAgent, contentDisposition, mimeType, contentLength);

        // Record UMA for onDownloadStart.
        G3HistogramRecorder.recordCallbackInvocation(
                G3HistogramRecorder.WebViewCallbackType.ON_DOWNLOAD_START);
    }

    @CalledByNative
    private void newLoginRequest(String realm, String account, String args) {
        mClient.getCallbackHelper().postOnReceivedLoginRequest(realm, account, args);

        // Record UMA for onReceivedLoginRequest.
        G3HistogramRecorder.recordCallbackInvocation(
                G3HistogramRecorder.WebViewCallbackType.ON_RECEIVED_LOGIN_REQUEST);
    }

    @CalledByNative
    private void onReceivedError(
            // WebResourceRequest
            String url, boolean isMainFrame, boolean hasUserGesture, boolean isRendererInitiated,
            String method, String[] requestHeaderNames, String[] requestHeaderValues,
            // WebResourceError
            @NetError int errorCode, String description, boolean safebrowsingHit,
            boolean shouldOmitNotificationsForSafeBrowsingHit) {
        G3ContentsClient.G3WebResourceRequest request = new G3ContentsClient.G3WebResourceRequest(
                url, isMainFrame, hasUserGesture, method, requestHeaderNames, requestHeaderValues);
        G3ContentsClient.G3WebResourceError error = new G3ContentsClient.G3WebResourceError();
        error.errorCode = errorCode;
        error.description = description;

        String unreachableWebDataUrl = G3ContentsStatics.getUnreachableWebDataUrl();
        boolean isErrorUrl =
                unreachableWebDataUrl != null && unreachableWebDataUrl.equals(request.url);

        if ((!isErrorUrl && error.errorCode != NetError.ERR_ABORTED) || safebrowsingHit) {
            error.errorCode = ErrorCodeConversionHelper.convertErrorCode(error.errorCode);
            if (request.isMainFrame) {
                mClient.getCallbackHelper().postOnPageStarted(request.url);
            }
            mClient.getCallbackHelper().postOnReceivedError(request, error);
            if (request.isMainFrame) {
                // Need to call onPageFinished after onReceivedError for backwards compatibility
                // with the classic webview. See also G3WebContentsObserver.didFailLoad which is
                // used when we want to send onPageFinished alone.
                mClient.getCallbackHelper().postOnPageFinished(request.url);
            }
        }
    }

    @CalledByNative
    public void onSafeBrowsingHit(
            // WebResourceRequest
            String url, boolean isMainFrame, boolean hasUserGesture, String method,
            String[] requestHeaderNames, String[] requestHeaderValues, int threatType,
            final int requestId) {
    }

    @CalledByNative
    private void onReceivedHttpError(
            // WebResourceRequest
            String url, boolean isMainFrame, boolean hasUserGesture, String method,
            String[] requestHeaderNames, String[] requestHeaderValues,
            // WebResourceResponse
            String mimeType, String encoding, int statusCode, String reasonPhrase,
            String[] responseHeaderNames, String[] responseHeaderValues) {
        G3ContentsClient.G3WebResourceRequest request = new G3ContentsClient.G3WebResourceRequest(
                url, isMainFrame, hasUserGesture, method, requestHeaderNames, requestHeaderValues);
        Map<String, String> responseHeaders =
                new HashMap<String, String>(responseHeaderNames.length);
        // Note that we receive un-coalesced response header lines, thus we need to combine
        // values for the same header.
        for (int i = 0; i < responseHeaderNames.length; ++i) {
            if (!responseHeaders.containsKey(responseHeaderNames[i])) {
                responseHeaders.put(responseHeaderNames[i], responseHeaderValues[i]);
            } else if (!responseHeaderValues[i].isEmpty()) {
                String currentValue = responseHeaders.get(responseHeaderNames[i]);
                if (!currentValue.isEmpty()) {
                    currentValue += ", ";
                }
                responseHeaders.put(responseHeaderNames[i], currentValue + responseHeaderValues[i]);
            }
        }
        G3WebResourceResponse response = new G3WebResourceResponse(
                mimeType, encoding, null, statusCode, reasonPhrase, responseHeaders);
        mClient.getCallbackHelper().postOnReceivedHttpError(request, response);

        // Record UMA on http response status.
        RecordHistogram.recordSparseHistogram(
                "Android.WebView.onReceivedHttpError.StatusCode", statusCode);
    }

    @CalledByNativeUnchecked
    private boolean shouldOverrideUrlLoading(
            String url, boolean hasUserGesture, boolean isRedirect, boolean isMainFrame) {
        return mClient.shouldIgnoreNavigation(
                mContext, url, isMainFrame, hasUserGesture, isRedirect);
    }

    public void confirmJsResult(int id, String prompt) {
        if (mNativeContentsClientBridge == 0) return;
        G3ContentsClientBridgeJni.get().confirmJsResult(
                mNativeContentsClientBridge, G3ContentsClientBridge.this, id, prompt);
    }

    public void cancelJsResult(int id) {
        if (mNativeContentsClientBridge == 0) return;
        G3ContentsClientBridgeJni.get().cancelJsResult(
                mNativeContentsClientBridge, G3ContentsClientBridge.this, id);
    }

    @NativeMethods
    interface Natives {
        // void takeSafeBrowsingAction(long nativeG3ContentsClientBridge,
        //         G3ContentsClientBridge caller, int action, boolean reporting, int requestId);

        void proceedSslError(long nativeG3ContentsClientBridge, G3ContentsClientBridge caller,
                boolean proceed, int id);
        void provideClientCertificateResponse(long nativeG3ContentsClientBridge,
                G3ContentsClientBridge caller, int id, byte[][] certChain, PrivateKey androidKey);
        void confirmJsResult(long nativeG3ContentsClientBridge, G3ContentsClientBridge caller,
                int id, String prompt);
        void cancelJsResult(
                long nativeG3ContentsClientBridge, G3ContentsClientBridge caller, int id);
    }
}
