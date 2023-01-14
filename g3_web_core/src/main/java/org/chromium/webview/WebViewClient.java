package org.chromium.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;

import androidx.annotation.Nullable;

public class WebViewClient {

    @Deprecated
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        return false;
    }

    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return shouldOverrideUrlLoading(view, request.getUrl().toString());
    }

    public void onPageStarted(WebView view, String url, Bitmap favicon) {
    }

    public void onPageFinished(WebView view, String url) {
    }

    public void onLoadResource(WebView view, String url) {
    }

    public void onPageCommitVisible(WebView view, String url) {
    }

    @Deprecated
    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView view,
                                                      String url) {
        return null;
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView view,
                                                      WebResourceRequest request) {
        return shouldInterceptRequest(view, request.getUrl().toString());
    }

    @Deprecated
    public void onReceivedError(WebView view, int errorCode,
                                String description, String failingUrl) {
    }

    public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        if (request.isForMainFrame()) {
            onReceivedError(view,
                    error.getErrorCode(), error.getDescription().toString(),
                    request.getUrl().toString());
        }
    }

    public void onReceivedHttpError(
            WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
    }

    public void onFormResubmission(WebView view, Message dontResend,
                                   Message resend) {
        dontResend.sendToTarget();
    }

    public void doUpdateVisitedHistory(WebView view, String url,
                                       boolean isReload) {
    }

    public void onReceivedSslError(WebView view, SslErrorHandler handler,
                                   SslError error) {
        handler.cancel();
    }

    public void onReceivedClientCertRequest(WebView view, ClientCertRequest request) {
        request.cancel();
    }

    public void onReceivedHttpAuthRequest(WebView view,
                                          HttpAuthHandler handler, String host, String realm) {
        handler.cancel();
    }

    public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return false;
    }

    public void onUnhandledKeyEvent(WebView view, KeyEvent event) {
    }


    public void onScaleChanged(WebView view, float oldScale, float newScale) {
    }

    public void onReceivedLoginRequest(WebView view, String realm,
                                       @Nullable String account, String args) {
    }

    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        return false;
    }
//
//    public void onSafeBrowsingHit(WebView view, WebResourceRequest request,
//                                  @SafeBrowsingThreat int threatType, SafeBrowsingResponse callback) {
//        callback.showInterstitial(/* allowReporting */ true);
//    }
}