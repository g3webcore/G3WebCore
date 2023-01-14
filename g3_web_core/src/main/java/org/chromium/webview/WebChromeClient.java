package org.chromium.webview;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;

import androidx.annotation.Nullable;

import org.chromium.webview.g3webcore.JsPromptResult;

public class WebChromeClient {
    
    public void onProgressChanged(WebView webview, int newProgress) {}

    public void onReceivedTitle(WebView webview, String title) {}

    public void onReceivedIcon(WebView webview, Bitmap icon) {}
    
    public void onReceivedTouchIconUrl(WebView webview, String url,
                                       boolean precomposed) {}

    public interface CustomViewCallback {
        public void onCustomViewHidden();
    }

    @Deprecated
    public void onShowCustomView(View view, CustomViewCallback callback) {};

    @Deprecated
    public void onShowCustomView(View view, int requestedOrientation,
                                 CustomViewCallback callback) {};

    public void onHideCustomView() {}

    public void enterFullscreen() {}

    public void exitFullscreen() {}

    public boolean onCreateWindow(WebView webview, boolean isDialog,
                                  boolean isUserGesture, Message resultMsg) {
        return false;
    }

    public void onRequestFocus(WebView webview) {}

    public void onCloseWindow(WebView window) {}

    public boolean onJsAlert(WebView webview, String url, String message,
                             JsResult result) {
        return false;
    }

    public boolean onJsConfirm(WebView webview, String url, String message,
                               JsResult result) {
        return false;
    }

    public boolean onJsPrompt(WebView webview, String url, String message,
                              String defaultValue, JsPromptResult result) {
        return false;
    }

    public boolean onJsBeforeUnload(WebView webview, String url, String message,
                                    JsResult result) {
        return false;
    }

    @Deprecated
    public void onExceededDatabaseQuota(String url, String databaseIdentifier,
                                        long quota, long estimatedDatabaseSize, long totalQuota,
                                        WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(quota);
    }

    @Deprecated
    public void onReachedMaxAppCacheSize(long requiredStorage, long quota,
                                         WebStorage.QuotaUpdater quotaUpdater) {
        quotaUpdater.updateQuota(quota);
    }

    public void onGeolocationPermissionsShowPrompt(String origin,
                                                   GeolocationPermissions.Callback callback) {}

    public void onGeolocationPermissionsHidePrompt() {}

    public void onPermissionRequest(PermissionRequest request) {
        request.deny();
    }

    public void onPermissionRequestCanceled(PermissionRequest request) {}

    @Deprecated
    public boolean onJsTimeout() {
        return true;
    }

    @Deprecated
    public void onConsoleMessage(String message, int lineNumber, String sourceID) { }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        onConsoleMessage(consoleMessage.message(), consoleMessage.lineNumber(),
                consoleMessage.sourceId());
        return false;
    }

    @Nullable
    public Bitmap getDefaultVideoPoster() {
        return null;
    }

    @Nullable
    public View getVideoLoadingProgressView() {
        return null;
    }

    public void getVisitedHistory(ValueCallback<String[]> callback) {
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
                                     FileChooserParams fileChooserParams) {
        return false;
    }

    public static abstract class FileChooserParams {
        public static final int MODE_OPEN = 0;
        public static final int MODE_OPEN_MULTIPLE = 1;
        public static final int MODE_OPEN_FOLDER = 2;
        public static final int MODE_SAVE = 3;

        @Nullable
        public static Uri[] parseResult(int resultCode, Intent data) {
            return parseFileChooserResult(resultCode, data);
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

        public abstract int getMode();

        public abstract String[] getAcceptTypes();

        public abstract boolean isCaptureEnabled();

        @Nullable
        public abstract CharSequence getTitle();

        @Nullable
        public abstract String getFilenameHint();

        public abstract Intent createIntent();
    }

    @Deprecated
    public void openFileChooser(ValueCallback<Uri> uploadFile, String acceptType, String capture) {
        uploadFile.onReceiveValue(null);
    }
}
