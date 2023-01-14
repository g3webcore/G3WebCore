package org.chromium.webview.g3webcore;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ClientCertRequest;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;

import androidx.annotation.NonNull;

import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.webview.JsResult;
import org.chromium.webview.JsResultReceiver;
import org.chromium.webview.SslErrorHandler;
import org.chromium.webview.WebChromeClient;
import org.chromium.webview.WebResourceErrorAdapter;
import org.chromium.webview.WebResourceRequestAdapter;
import org.chromium.webview.WebResourceResponse;
import org.chromium.webview.WebView;
import org.chromium.webview.WebViewClient;

import java.lang.ref.WeakReference;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class G3ContentsClientAdapter extends G3ContentsClient {

    static final WebViewClient defaultWebViewClient = new WebViewClient();
    static final WebChromeClient defaultWebChromeClient = new WebChromeClient();

    private WebViewClient mWebViewClient = defaultWebViewClient;
    private WebChromeClient mWebChromeClient = defaultWebChromeClient;
    private WebView mWebView;

    private static final int NEW_WEBVIEW_CREATED = 100;
    private Handler mUiThreadHandler;

    public G3ContentsClientAdapter(WebView webView) {
        super();
        if (webView == null) {
            throw new IllegalArgumentException("webView can't be null.");
        }
        this.mWebView = webView;
        mUiThreadHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case NEW_WEBVIEW_CREATED:
                        WebView.WebViewTransport t = (WebView.WebViewTransport) msg.obj;
                        WebView newWebView = t.getWebView();
                        if (newWebView == mWebView) {
                            throw new IllegalArgumentException(
                                    "Parent WebView cannot host its own popup window. Please "
                                            + "use WebSettings.setSupportMultipleWindows(false)");
                        }

                        if (newWebView != null
                                && newWebView.copyBackForwardList().getSize() != 0) {
                            throw new IllegalArgumentException(
                                    "New WebView for popup window must not have been "
                                            + " previously navigated.");
                        }

                        G3WebCore.completeWindowCreation(mWebView, newWebView);
                        break;
                    default:
                        throw new IllegalStateException();
                }
            }
        };
    }

    void setWebViewClient(@NonNull WebViewClient webViewClient) {
        if (webViewClient == null) {
            throw new IllegalArgumentException("webViewClient can't be null.");
        }
        mWebViewClient = webViewClient;
    }

    public WebViewClient getWebViewClient() {
        return mWebViewClient;
    }

    void setWebChromeClient(@NonNull WebChromeClient webChromeClient) {
        if (webChromeClient == null) {
            throw new IllegalArgumentException("webChromeClient can't be null.");
        }
        mWebChromeClient = webChromeClient;
    }

    public WebChromeClient getWebChromeClient() {
        return mWebChromeClient;
    }

    @Override
    public boolean hasWebViewClient() {
        return mWebViewClient != defaultWebViewClient;
    }

    @Override
    public void getVisitedHistory(Callback<String[]> callback) {
        mWebChromeClient.getVisitedHistory(
                callback == null ? null : value -> callback.onResult(value));
    }

    @Override
    public void doUpdateVisitedHistory(String url, boolean isReload) {
        mWebViewClient.doUpdateVisitedHistory(mWebView, url, isReload);
    }

    @Override
    public void onProgressChanged(int progress) {
        mWebChromeClient.onProgressChanged(mWebView, progress);
    }

    @Override
    public G3WebResourceResponse shouldInterceptRequest(G3WebResourceRequest request) {
        WebResourceResponse response = mWebViewClient.shouldInterceptRequest(
                mWebView, new WebResourceRequestAdapter(request));
        if (response == null) return null;
        Map<String, String> responseHeaders = response.getResponseHeaders();
        if (responseHeaders == null) responseHeaders = new HashMap<String, String>();
        return new G3WebResourceResponse(
                response.getMimeType(),
                response.getEncoding(),
                response.getData(),
                response.getStatusCode(),
                response.getReasonPhrase(),
                responseHeaders);
    }

    @Override
    public boolean shouldOverrideKeyEvent(KeyEvent event) {
        return false;
    }

    @Override
    public boolean shouldOverrideUrlLoading(G3WebResourceRequest request) {
        boolean result;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = mWebViewClient.shouldOverrideUrlLoading(mWebView, new WebResourceRequestAdapter(request));
        } else {
            result = mWebViewClient.shouldOverrideUrlLoading(mWebView, request.url);
        }
        return result;
    }

    @Override
    public void onLoadResource(String url) {
        mWebViewClient.onLoadResource(mWebView, url);
    }

    @Override
    public void onUnhandledKeyEvent(KeyEvent event) {

    }

    @Override
    public boolean onConsoleMessage(G3ConsoleMessage consoleMessage) {
        if (mWebChromeClient == defaultWebChromeClient) {
            return false;
        }
        return mWebChromeClient.onConsoleMessage(fromG3ConsoleMessage(consoleMessage));
    }

    private static ConsoleMessage fromG3ConsoleMessage(G3ConsoleMessage value) {
        if (value == null) {
            return null;
        }
        return new ConsoleMessage(value.message(), value.sourceId(), value.lineNumber(),
                fromG3MessageLevel(value.messageLevel()));
    }

    private static ConsoleMessage.MessageLevel fromG3MessageLevel(
            @G3ConsoleMessage.MessageLevel int value) {
        switch (value) {
            case G3ConsoleMessage.MESSAGE_LEVEL_TIP:
                return ConsoleMessage.MessageLevel.TIP;
            case G3ConsoleMessage.MESSAGE_LEVEL_LOG:
                return ConsoleMessage.MessageLevel.LOG;
            case G3ConsoleMessage.MESSAGE_LEVEL_WARNING:
                return ConsoleMessage.MessageLevel.WARNING;
            case G3ConsoleMessage.MESSAGE_LEVEL_ERROR:
                return ConsoleMessage.MessageLevel.ERROR;
            case G3ConsoleMessage.MESSAGE_LEVEL_DEBUG:
                return ConsoleMessage.MessageLevel.DEBUG;
            default:
                throw new IllegalArgumentException("Unsupported value: " + value);
        }
    }

    @Override
    public void onReceivedSslError(Callback<Boolean> callback, SslError error) {
        SslErrorHandler handler = new SslErrorHandler() {
            @Override
            public void proceed() {
                callback.onResult(true);
            }
            @Override
            public void cancel() {
                callback.onResult(false);
            }
        };
        mWebViewClient.onReceivedSslError(mWebView, handler, error);
    }

    private static class ClientCertRequestImpl extends ClientCertRequest {
        private final G3ContentsClientBridge.ClientCertificateRequestCallback mCallback;
        private final String[] mKeyTypes;
        private final Principal[] mPrincipals;
        private final String mHost;
        private final int mPort;

        public ClientCertRequestImpl(
                G3ContentsClientBridge.ClientCertificateRequestCallback callback, String[] keyTypes,
                Principal[] principals, String host, int port) {
            mCallback = callback;
            mKeyTypes = keyTypes;
            mPrincipals = principals;
            mHost = host;
            mPort = port;
        }

        @Override
        public String[] getKeyTypes() {
            // This is already a copy of native argument, so return directly.
            return mKeyTypes;
        }

        @Override
        public Principal[] getPrincipals() {
            // This is already a copy of native argument, so return directly.
            return mPrincipals;
        }

        @Override
        public String getHost() {
            return mHost;
        }

        @Override
        public int getPort() {
            return mPort;
        }

        @Override
        public void proceed(final PrivateKey privateKey, final X509Certificate[] chain) {
            mCallback.proceed(privateKey, chain);
        }

        @Override
        public void ignore() {
            mCallback.ignore();
        }

        @Override
        public void cancel() {
            mCallback.cancel();
        }
    }

    @Override
    public void onReceivedClientCertRequest(G3ContentsClientBridge.ClientCertificateRequestCallback callback, String[] keyTypes, Principal[] principals, String host, int port) {
        final ClientCertRequestImpl request =
                new ClientCertRequestImpl(callback, keyTypes, principals, host, port);
        mWebViewClient.onReceivedClientCertRequest(mWebView, request);
    }

    @Override
    public void onReceivedLoginRequest(String realm, String account, String args) {
        mWebViewClient.onReceivedLoginRequest(mWebView, realm, account, args);
    }

    @Override
    public void onFormResubmission(Message dontResend, Message resend) {
        mWebViewClient.onFormResubmission(mWebView, dontResend, resend);
    }

    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long contentLength) {

    }

    @Override
    public void showFileChooser(Callback<String[]> uploadFileCallback, FileChooserParamsImpl fileChooserParams) {
//        if (mWebChromeClient == null) {
//            uploadFileCallback.onResult(null);
//            return;
//        }
        ValueCallback<Uri[]> callbackAdapter = new ValueCallback<Uri[]>() {
            private boolean mCompleted;
            @Override
            public void onReceiveValue(Uri[] uriList) {
                if (mCompleted) {
                    throw new IllegalStateException(
                            "showFileChooser result was already called");
                }
                mCompleted = true;
                String s[] = null;
                if (uriList != null) {
                    s = new String[uriList.length];
                    for (int i = 0; i < uriList.length; i++) {
                        s[i] = uriList[i].toString();
                    }
                }
                uploadFileCallback.onResult(s);
            }
        };

        // Invoke the new callback introduced in Lollipop. If the app handles
        // it, we're done here.
        if (mWebChromeClient.onShowFileChooser(
                mWebView, callbackAdapter, fromG3FileChooserParams(fileChooserParams))) {
            return;
        }

        // If the app did not handle it and we are running on Lollipop or newer, then
        // abort.
        if (mWebView.getContext().getApplicationInfo().targetSdkVersion >= Build.VERSION_CODES.LOLLIPOP) {
            uploadFileCallback.onResult(null);
            return;
        }

        // Otherwise, for older apps, attempt to invoke the legacy (hidden) API for
        // backwards compatibility.
        ValueCallback<Uri> innerCallback = new ValueCallback<Uri>() {
            private boolean mCompleted;
            @Override
            public void onReceiveValue(Uri uri) {
                if (mCompleted) {
                    throw new IllegalStateException(
                            "showFileChooser result was already called");
                }
                mCompleted = true;
                uploadFileCallback.onResult(uri == null ? null : new String[] {uri.toString()});
            }
        };
        mWebChromeClient.openFileChooser(
                innerCallback,
                fileChooserParams.getAcceptTypesString(),
                fileChooserParams.isCaptureEnabled() ? "*" : "");
    }

    public static WebChromeClient.FileChooserParams fromG3FileChooserParams(
            final G3ContentsClient.FileChooserParamsImpl value) {
        if (value == null) {
            return null;
        }
        return new WebChromeClient.FileChooserParams() {
            @Override
            public int getMode() {
                return value.getMode();
            }

            @Override
            public String[] getAcceptTypes() {
                return value.getAcceptTypes();
            }

            @Override
            public boolean isCaptureEnabled() {
                return value.isCaptureEnabled();
            }

            @Override
            public CharSequence getTitle() {
                return value.getTitle();
            }

            @Override
            public String getFilenameHint() {
                return value.getFilenameHint();
            }

            @Override
            public Intent createIntent() {
                return value.createIntent();
            }
        };
    }

    @Override
    public void onGeolocationPermissionsShowPrompt(String origin, G3GeolocationPermissions.Callback callback) {
        if (!isMethodDeclaredInSubClass(WebChromeClient.class,
                mWebChromeClient.getClass(),
                "onGeolocationPermissionsShowPrompt",
                String.class,
                GeolocationPermissions.Callback.class)) {
            // This is only required for pre-M versions of android.
            callback.invoke(origin, false, false);
            return;
        }
        mWebChromeClient.onGeolocationPermissionsShowPrompt(origin,
                callback == null ? null : (callbackOrigin, allow, retain)
                        -> callback.invoke(callbackOrigin, allow, retain));
    }

    private static <T> boolean isMethodDeclaredInSubClass(Class<T> baseClass,
                                                          Class<? extends T> subClass, String name, Class<?>... parameterTypes) {
        try {
            return !subClass.getMethod(name, parameterTypes).getDeclaringClass().equals(baseClass);
        } catch (SecurityException e) {
            return false;
        } catch (NoSuchMethodException e) {
            return false;
        }
    }

    @Override
    public void onGeolocationPermissionsHidePrompt() {
        mWebChromeClient.onGeolocationPermissionsHidePrompt();
    }

    private WeakHashMap<G3PermissionRequest, WeakReference<PermissionRequestAdapter>>
            mOngoingPermissionRequests;

    public static class PermissionRequestAdapter extends PermissionRequest {

        private static long toG3PermissionResources(String[] resources) {
            long result = 0;
            for (String resource : resources) {
                if (resource.equals(PermissionRequest.RESOURCE_VIDEO_CAPTURE)) {
                    result |= Resource.VIDEO_CAPTURE;
                } else if (resource.equals(PermissionRequest.RESOURCE_AUDIO_CAPTURE)) {
                    result |= Resource.AUDIO_CAPTURE;
                } else if (resource.equals(PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID)) {
                    result |= Resource.PROTECTED_MEDIA_ID;
                } else if (resource.equals(G3PermissionRequest.RESOURCE_MIDI_SYSEX)) {
                    result |= Resource.MIDI_SYSEX;
                }
            }
            return result;
        }

        private static String[] toPermissionResources(long resources) {
            ArrayList<String> result = new ArrayList<String>();
            if ((resources & Resource.VIDEO_CAPTURE) != 0) {
                result.add(PermissionRequest.RESOURCE_VIDEO_CAPTURE);
            }
            if ((resources & Resource.AUDIO_CAPTURE) != 0) {
                result.add(PermissionRequest.RESOURCE_AUDIO_CAPTURE);
            }
            if ((resources & Resource.PROTECTED_MEDIA_ID) != 0) {
                result.add(PermissionRequest.RESOURCE_PROTECTED_MEDIA_ID);
            }
            if ((resources & Resource.MIDI_SYSEX) != 0) {
                result.add(G3PermissionRequest.RESOURCE_MIDI_SYSEX);
            }
            String[] resource_array = new String[result.size()];
            return result.toArray(resource_array);
        }

        private G3PermissionRequest mG3PermissionRequest;
        private final String[] mResources;

        public PermissionRequestAdapter(G3PermissionRequest awPermissionRequest) {
            assert awPermissionRequest != null;
            mG3PermissionRequest = awPermissionRequest;
            mResources = toPermissionResources(mG3PermissionRequest.getResources());
        }

        @Override
        public Uri getOrigin() {
            return mG3PermissionRequest.getOrigin();
        }

        @Override
        public String[] getResources() {
            return mResources.clone();
        }

        @Override
        public void grant(String[] resources) {
            long requestedResource = mG3PermissionRequest.getResources();
            if ((requestedResource & toG3PermissionResources(resources)) == requestedResource) {
                mG3PermissionRequest.grant();
            } else {
                mG3PermissionRequest.deny();
            }
        }

        @Override
        public void deny() {
            mG3PermissionRequest.deny();
        }
    }

    @Override
    public void onPermissionRequest(G3PermissionRequest permissionRequest) {
        if (mOngoingPermissionRequests == null) {
            mOngoingPermissionRequests = new WeakHashMap<G3PermissionRequest,
                    WeakReference<PermissionRequestAdapter>>();
        }
        PermissionRequestAdapter adapter = new PermissionRequestAdapter(permissionRequest);
        mOngoingPermissionRequests.put(
                permissionRequest, new WeakReference<PermissionRequestAdapter>(adapter));
        mWebChromeClient.onPermissionRequest(adapter);
    }

    @Override
    public void onPermissionRequestCanceled(G3PermissionRequest permissionRequest) {
        if (mOngoingPermissionRequests != null) {
            WeakReference<PermissionRequestAdapter> weakRef =
                    mOngoingPermissionRequests.get(permissionRequest);
            if (weakRef != null) {
                PermissionRequestAdapter adapter = weakRef.get();
                if (adapter != null) mWebChromeClient.onPermissionRequestCanceled(adapter);
            }
        }
    }

    @Override
    public void onScaleChangedScaled(float oldScale, float newScale) {
        mWebViewClient.onScaleChanged(mWebView, oldScale, newScale);
    }

    private static class JsPromptResultReceiverAdapter implements JsResult.ResultReceiver {
        private JsPromptResultReceiver mChromePromptResultReceiver;
        private JsResultReceiver mChromeResultReceiver;
        // We hold onto the JsPromptResult here, just to avoid the need to downcast
        // in onJsResultComplete.
        private final JsPromptResult mPromptResult = new JsPromptResult(this);

        public JsPromptResultReceiverAdapter(JsPromptResultReceiver receiver) {
            mChromePromptResultReceiver = receiver;
        }

        public JsPromptResultReceiverAdapter(JsResultReceiver receiver) {
            mChromeResultReceiver = receiver;
        }

        public JsPromptResult getPromptResult() {
            return mPromptResult;
        }

        @Override
        public void onJsResultComplete(JsResult result) {
            if (mChromePromptResultReceiver != null) {
                if (mPromptResult.getResult()) {
                    mChromePromptResultReceiver.confirm(mPromptResult.getStringResult());
                } else {
                    mChromePromptResultReceiver.cancel();
                }
            } else {
                if (mPromptResult.getResult()) {
                    mChromeResultReceiver.confirm();
                } else {
                    mChromeResultReceiver.cancel();
                }
            }
        }
    }

    private boolean showDefaultJsDialog(JsPromptResult res, int jsDialogType, String defaultValue,
                                        String message, String url) {
        Context activityContext = ContextUtils.activityFromContext(mWebView.getContext());
        if (activityContext == null) {
            return false;
        }
        try {
            new JsDialogHelper(res, jsDialogType, defaultValue, message, url)
                    .showDialog(activityContext);
        } catch (WindowManager.BadTokenException e) {
            return false;
        }
        return true;
    }

    @Override
    public void handleJsAlert(String url, String message, JsResultReceiver receiver) {
        final JsPromptResult res =
                new JsPromptResultReceiverAdapter(receiver).getPromptResult();
        if (!mWebChromeClient.onJsAlert(mWebView, url, message, res)) {
            if (!showDefaultJsDialog(res, JsDialogHelper.ALERT, null, message, url)) {
                receiver.cancel();
            }
        }
    }

    @Override
    public void handleJsBeforeUnload(String url, String message, JsResultReceiver receiver) {
        final JsPromptResult res =
                new JsPromptResultReceiverAdapter(receiver).getPromptResult();
        if (!mWebChromeClient.onJsBeforeUnload(mWebView, url, message, res)) {
            if (!showDefaultJsDialog(res, JsDialogHelper.UNLOAD, null, message, url)) {
                receiver.cancel();
            }
        }
    }

    @Override
    public void handleJsConfirm(String url, String message, JsResultReceiver receiver) {
        final JsPromptResult res =
                new JsPromptResultReceiverAdapter(receiver).getPromptResult();
        if (!mWebChromeClient.onJsConfirm(mWebView, url, message, res)) {
            if (!showDefaultJsDialog(res, JsDialogHelper.CONFIRM, null, message, url)) {
                receiver.cancel();
            }
        }
    }

    @Override
    public void handleJsPrompt(String url, String message, String defaultValue, JsPromptResultReceiver receiver) {
        final JsPromptResult res =
                new JsPromptResultReceiverAdapter(receiver).getPromptResult();
        if (!mWebChromeClient.onJsPrompt(mWebView, url, message, defaultValue, res)) {
            if (!showDefaultJsDialog(
                    res, JsDialogHelper.PROMPT, defaultValue, message, url)) {
                receiver.cancel();
            }
        }
    }

    @Override
    protected boolean onCreateWindow(boolean isDialog, boolean isUserGesture) {
        Message m = mUiThreadHandler.obtainMessage(
                NEW_WEBVIEW_CREATED, new WebView.WebViewTransport());
        boolean result;
        if (mWebChromeClient != null) {
            result = mWebChromeClient.onCreateWindow(mWebView, isDialog, isUserGesture, m);
        } else {
            result = false;
        }
        return result;
    }

    @Override
    protected void onCloseWindow() {
        mWebChromeClient.onCloseWindow(mWebView);
    }

    @Override
    public void onReceivedTouchIconUrl(String url, boolean precomposed) {
        mWebChromeClient.onReceivedTouchIconUrl(mWebView, url, precomposed);
    }

    @Override
    public void onReceivedIcon(Bitmap bitmap) {
        mWebChromeClient.onReceivedIcon(mWebView, bitmap);
    }

    @Override
    public void onReceivedTitle(String title) {
        mWebChromeClient.onReceivedTitle(mWebView, title);
    }

    @Override
    protected void onRequestFocus() {

    }

    @Override
    protected View getVideoLoadingProgressView() {
        return mWebChromeClient.getVideoLoadingProgressView();
    }

    @Override
    public void onPageStarted(String url) {
        mWebViewClient.onPageStarted(mWebView, url, mWebView.getFavicon());
    }

    @Override
    public void onPageFinished(String url) {
        mWebViewClient.onPageFinished(mWebView, url);
    }

    @Override
    public void onPageCommitVisible(String url) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mWebViewClient.onPageCommitVisible(mWebView, url);
        }
    }

    @Override
    protected void onReceivedError(int errorCode, String description, String failingUrl) {
        mWebViewClient.onReceivedError(mWebView, errorCode, description, failingUrl);
    }

    @Override
    protected void onReceivedError2(G3WebResourceRequest request, G3WebResourceError error) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mWebViewClient.onReceivedError(mWebView, new WebResourceRequestAdapter(request), new WebResourceErrorAdapter(error));
        }
    }

    @Override
    public void onReceivedHttpError(G3WebResourceRequest request, G3WebResourceResponse response) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String reasonPhrase = response.getReasonPhrase();
            if (reasonPhrase == null || reasonPhrase.isEmpty()) {
                reasonPhrase = "UNKNOWN";
            }
            mWebViewClient.onReceivedHttpError(mWebView, new WebResourceRequestAdapter(request),
                    new WebResourceResponse(response.getMimeType(), response.getCharset(),
                            response.getStatusCode(), reasonPhrase,
                            response.getResponseHeaders(), response.getData()));
        }
    }

    @Override
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {

    }

    @Override
    public void onHideCustomView() {

    }

    @Override
    public void enterFullscreen() {
        mWebChromeClient.enterFullscreen();
    }

    @Override
    public void exitFullscreen() {
        mWebChromeClient.exitFullscreen();
    }

    @Override
    public Bitmap getDefaultVideoPoster() {
        return mWebChromeClient.getDefaultVideoPoster();
    }

    @Override
    public void onFindResultReceived(int activeMatchOrdinal, int numberOfMatches, boolean isDoneCounting) {

    }

    @Override
    public void onNewPicture(Picture picture) {

    }
}
