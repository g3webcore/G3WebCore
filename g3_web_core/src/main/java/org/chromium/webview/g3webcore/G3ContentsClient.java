package org.chromium.webview.g3webcore;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Looper;
import android.os.Message;
import android.provider.Browser;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.base.metrics.ScopedSysTraceEvent;
import org.chromium.content_public.common.ContentUrlConstants;
import org.chromium.webview.JsResultReceiver;
import org.chromium.webview.WebChromeClient;

import java.security.Principal;
import java.util.HashMap;

public abstract class G3ContentsClient {
    private static final String TAG = "G3ContentsClient";
    private final G3ContentsClientCallbackHelper mCallbackHelper;

    private int mCachedRendererBackgroundColor = INVALID_COLOR;

    private String mTitle = "";

    private static final int INVALID_COLOR = 0;

    public G3ContentsClient() {
        this(Looper.myLooper());
    }

    public G3ContentsClient(Looper looper) {
        try (ScopedSysTraceEvent e =
                     ScopedSysTraceEvent.scoped("G3ContentsClient.constructorOneArg")) {
            mCallbackHelper = new G3ContentsClientCallbackHelper(looper, this);
        }
    }

    public final G3ContentsClientCallbackHelper getCallbackHelper() {
        return mCallbackHelper;
    }

    final int getCachedRendererBackgroundColor() {
        assert isCachedRendererBackgroundColorValid();
        return mCachedRendererBackgroundColor;
    }

    final boolean isCachedRendererBackgroundColorValid() {
        return mCachedRendererBackgroundColor != INVALID_COLOR;
    }

    final void onBackgroundColorChanged(int color) {
        mCachedRendererBackgroundColor = color == INVALID_COLOR ? 1 : color;
    }

    public static class G3WebResourceRequest {
        public G3WebResourceRequest() {}

        public G3WebResourceRequest(String url, boolean isMainFrame, boolean hasUserGesture,
                                    String method, @Nullable HashMap<String, String> requestHeaders) {
            this.url = url;
            this.isMainFrame = isMainFrame;
            this.hasUserGesture = hasUserGesture;
            this.method = method;
            this.requestHeaders = requestHeaders;
        }

        public G3WebResourceRequest(String url, boolean isMainFrame, boolean hasUserGesture,
                                    String method, @NonNull String[] requestHeaderNames,
                                    @NonNull String[] requestHeaderValues) {
            this(url, isMainFrame, hasUserGesture, method,
                    new HashMap<String, String>(requestHeaderValues.length));
            for (int i = 0; i < requestHeaderNames.length; ++i) {
                this.requestHeaders.put(requestHeaderNames[i], requestHeaderValues[i]);
            }
        }

        public String url;
        public boolean isMainFrame;
        public boolean hasUserGesture;
        public boolean isRedirect;
        public String method;
        public HashMap<String, String> requestHeaders;
    }

    public static class G3WebResourceError {
        public int errorCode = ErrorCodeConversionHelper.ERROR_UNKNOWN;
        public String description;
    }

    public abstract boolean hasWebViewClient();

    public abstract void getVisitedHistory(Callback<String[]> callback);

    public abstract void doUpdateVisitedHistory(String url, boolean isReload);

    public abstract void onProgressChanged(int progress);

    public abstract G3WebResourceResponse shouldInterceptRequest(
            G3WebResourceRequest request);

    public abstract boolean shouldOverrideKeyEvent(KeyEvent event);

    public abstract boolean shouldOverrideUrlLoading(G3WebResourceRequest request);

    public abstract void onLoadResource(String url);

    public abstract void onUnhandledKeyEvent(KeyEvent event);

    public abstract boolean onConsoleMessage(G3ConsoleMessage consoleMessage);

    public abstract void onReceivedSslError(Callback<Boolean> callback, SslError error);

    public abstract void onReceivedClientCertRequest(
            final G3ContentsClientBridge.ClientCertificateRequestCallback callback,
            final String[] keyTypes, final Principal[] principals, final String host,
            final int port);

    public abstract void onReceivedLoginRequest(String realm, String account, String args);

    public abstract void onFormResubmission(Message dontResend, Message resend);

    public abstract void onDownloadStart(String url, String userAgent, String contentDisposition,
                                         String mimeType, long contentLength);

    public final boolean shouldIgnoreNavigation(Context context, String url, boolean isMainFrame,
                                                boolean hasUserGesture, boolean isRedirect) {
        G3ContentsClientCallbackHelper.CancelCallbackPoller poller =
                mCallbackHelper.getCancelCallbackPoller();
        if (poller != null && poller.shouldCancelAllCallbacks()) return false;

        if (hasWebViewClient()) {
            G3WebResourceRequest request =
                    new G3WebResourceRequest(url, isMainFrame, hasUserGesture, "GET", null);
            request.isRedirect = isRedirect;
            return shouldOverrideUrlLoading(request);
        } else {
            return sendBrowsingIntent(context, url, hasUserGesture, isRedirect);
        }
    }

    private static boolean sendBrowsingIntent(Context context, String url, boolean hasUserGesture,
                                              boolean isRedirect) {
        if (!hasUserGesture && !isRedirect) {
            Log.w(TAG, "Denied starting an intent without a user gesture, URI %s", url);
            return true;
        }

        if (url.startsWith(ContentUrlConstants.ABOUT_URL_SHORT_PREFIX)) {
            return false;
        }

        Intent intent;
        try {
            intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
        } catch (Exception ex) {
            Log.w(TAG, "Bad URI %s", url, ex);
            return false;
        }
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setComponent(null);
        Intent selector = intent.getSelector();
        if (selector != null) {
            selector.addCategory(Intent.CATEGORY_BROWSABLE);
            selector.setComponent(null);
        }

        // Pass the package name as application ID so that the intent from the
        // same application can be opened in the same tab.
        intent.putExtra(Browser.EXTRA_APPLICATION_ID, context.getPackageName());

        // Check whether the context is activity context.
        if (ContextUtils.activityFromContext(context) == null) {
            Log.w(TAG, "Cannot call startActivity on non-activity context.");
            return false;
        }

        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException ex) {
            Log.w(TAG, "No application can handle %s", url);
        } catch (SecurityException ex) {
            // This can happen if the Activity is exported="true", guarded by a permission, and sets
            // up an intent filter matching this intent. This is a valid configuration for an
            // Activity, so instead of crashing, we catch the exception and do nothing. See
            // https://crbug.com/808494 and https://crbug.com/889300.
            Log.w(TAG, "SecurityException when starting intent for %s", url);
        }

        return false;
    }

    public static Uri[] parseFileChooserResult(int resultCode, Intent intent) {
        if (resultCode == Activity.RESULT_CANCELED) {
            return null;
        }
        Uri result =
                intent == null || resultCode != Activity.RESULT_OK ? null : intent.getData();

        Uri[] uris = null;
        if (result != null) {
            uris = new Uri[1];
            uris[0] = result;
        }
        return uris;
    }

    public static class FileChooserParamsImpl {
        private int mMode;
        private String mAcceptTypes;
        private String mTitle;
        private String mDefaultFilename;
        private boolean mCapture;

        public FileChooserParamsImpl(int mode, String acceptTypes, String title,
                                     String defaultFilename, boolean capture) {
            mMode = mode;
            mAcceptTypes = acceptTypes;
            mTitle = title;
            mDefaultFilename = defaultFilename;
            mCapture = capture;
        }

        public String getAcceptTypesString() {
            return mAcceptTypes;
        }

        public int getMode() {
            return mMode;
        }

        public String[] getAcceptTypes() {
            if (mAcceptTypes == null) {
                return new String[0];
            }
            return mAcceptTypes.split(",");
        }

        public boolean isCaptureEnabled() {
            return mCapture;
        }

        public CharSequence getTitle() {
            return mTitle;
        }

        public String getFilenameHint() {
            return mDefaultFilename;
        }

        public Intent createIntent() {
            String mimeType = "*/*";
            if (mAcceptTypes != null && !mAcceptTypes.trim().isEmpty()) {
                mimeType = mAcceptTypes.split(",")[0];
            }

            Intent i = new Intent(Intent.ACTION_GET_CONTENT);
            i.addCategory(Intent.CATEGORY_OPENABLE);
            i.setType(mimeType);
            return i;
        }
    }

    public abstract void showFileChooser(
            Callback<String[]> uploadFilePathsCallback, FileChooserParamsImpl fileChooserParams);

    public abstract void onGeolocationPermissionsShowPrompt(
            String origin, G3GeolocationPermissions.Callback callback);

    public abstract void onGeolocationPermissionsHidePrompt();

    public abstract void onPermissionRequest(G3PermissionRequest permissionRequest);

    public abstract void onPermissionRequestCanceled(G3PermissionRequest permissionRequest);

    public abstract void onScaleChangedScaled(float oldScale, float newScale);

    public abstract void handleJsAlert(String url, String message, JsResultReceiver receiver);

    public abstract void handleJsBeforeUnload(String url, String message,
                                              JsResultReceiver receiver);

    public abstract void handleJsConfirm(String url, String message, JsResultReceiver receiver);

    public abstract void handleJsPrompt(String url, String message, String defaultValue,
                                        JsPromptResultReceiver receiver);

    protected abstract boolean onCreateWindow(boolean isDialog, boolean isUserGesture);

    protected abstract void onCloseWindow();

    public abstract void onReceivedTouchIconUrl(String url, boolean precomposed);

    public abstract void onReceivedIcon(Bitmap bitmap);

    public abstract void onReceivedTitle(String title);

    protected abstract void onRequestFocus();

    protected abstract View getVideoLoadingProgressView();

    public abstract void onPageStarted(String url);

    public abstract void onPageFinished(String url);

    public abstract void onPageCommitVisible(String url);

    public final void onReceivedError(G3WebResourceRequest request, G3WebResourceError error) {
        // Only one of these callbacks actually reaches out the client code. The first callback
        // is used on API versions up to and including L, the second on subsequent releases.
        // Below is the calls diagram:
        //
        //                           Old (<= L) glue              Old (<= L) android.webkit API
        //                             onReceivedError --------->   onReceivedError
        //  G3ContentsClient           onReceivedError2 ->X   /
        //   abs. onReceivedError                            /
        //   abs. onReceivedError2                          /
        //                           New (M+) glue         /      New (M+) android.webkit API
        //                             onReceivedError    /     ->  onReceviedError <new>
        //   "->X" = "do nothing"        if (!<M API>) ---     /      if (isMainFrame) -\
        //                               else ->X             /       else ->X          |
        //                             onReceivedError2      /                          V
        //                               if (<M API>) -------       onReceivedError <old>
        //                               else ->X
        if (request.isMainFrame) {
            onReceivedError(error.errorCode, error.description, request.url);
        }
        onReceivedError2(request, error);

        // Record UMA on error code distribution here.
        RecordHistogram.recordSparseHistogram(
                "Android.WebView.onReceivedError.ErrorCode", error.errorCode);
    }

    protected abstract void onReceivedError(int errorCode, String description, String failingUrl);

    protected abstract void onReceivedError2(
            G3WebResourceRequest request, G3WebResourceError error);

    public abstract void onReceivedHttpError(G3WebResourceRequest request,
                                             G3WebResourceResponse response);

    public abstract void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback);

    public abstract void onHideCustomView();

    public abstract void enterFullscreen();

    public abstract void exitFullscreen();

    public abstract Bitmap getDefaultVideoPoster();

    //--------------------------------------------------------------------------------------------
    //                              Other WebView-specific methods
    //--------------------------------------------------------------------------------------------
    //
    public abstract void onFindResultReceived(int activeMatchOrdinal, int numberOfMatches,
                                              boolean isDoneCounting);

    public abstract void onNewPicture(Picture picture);

    public final void updateTitle(String title, boolean forceNotification) {
        if (!forceNotification && TextUtils.equals(mTitle, title)) return;
        mTitle = title;
        mCallbackHelper.postOnReceivedTitle(mTitle);
    }

}
