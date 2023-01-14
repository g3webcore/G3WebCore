package org.chromium.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.LibraryProcessType;
import org.chromium.content.common.NativePluginManager;
import org.chromium.content_public.browser.BrowserStartupController;
import org.chromium.webview.g3webcore.WebViewChromium;

@JNINamespace("g3webcore")
public class WebView extends FrameLayout {

    static {

        LibraryLoader.getInstance().ensureInitialized();

        BrowserStartupController.get(LibraryProcessType.PROCESS_BROWSER)
                .startBrowserProcessesSync(true);
    }

    private WebViewProvider mWebViewProvider;

    public WebView(@NonNull Context context) {
        this(context, null);
    }

    public WebView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mWebViewProvider = new WebViewChromium(this.getContext(), this, this);
    }

    public void loadUrl(String url) {
        mWebViewProvider.loadUrl(url);
    }

    public WebSettings getSettings() {
        return mWebViewProvider.getSettings();
    }

    public void addJavascriptInterface(Object obj, String interfaceName) {
        mWebViewProvider.addJavascriptInterface(obj, interfaceName);
    }

    public void removeJavascriptInterface(String interfaceName) {
        mWebViewProvider.removeJavascriptInterface(interfaceName);
    }

    public void evaluateJavaScript(String script, ValueCallback<String> resultCallback) {
        mWebViewProvider.evaluateJavaScript(script, resultCallback);
    }

    public void stopLoading() {
        mWebViewProvider.stopLoading();
    }

    public void reload() {
        mWebViewProvider.reload();
    }

    public boolean canGoBack() {
        return mWebViewProvider.canGoBack();
    }

    public void goBack() {
        mWebViewProvider.goBack();
    }

    public boolean canGoForward() {
        return mWebViewProvider.canGoForward();
    }

    public void goForward() {
        mWebViewProvider.goForward();
    }

    public boolean canGoBackOrForward(int steps) {
        return mWebViewProvider.canGoBackOrForward(steps);
    }

    public void goBackOrForward(int steps) {
        mWebViewProvider.goBackOrForward(steps);
    }

    public String getOriginalUrl() {
        return mWebViewProvider.getOriginalUrl();
    }

    public void pauseTimers() {
        mWebViewProvider.pauseTimers();
    }

    public void resumeTimers() {
        mWebViewProvider.resumeTimers();
    }

    public void onPause() {
        mWebViewProvider.onPause();
    }

    public void onResume() {
        mWebViewProvider.onResume();
    }

    public boolean isPaused() {
        return mWebViewProvider.isPaused();
    }

    public void clearCache(boolean includeDiskFiles) {
        mWebViewProvider.clearCache(includeDiskFiles);
    }

    public void clearHistory() {
        mWebViewProvider.clearHistory();
    }

    public void clearSslPreferences() {
        mWebViewProvider.clearSslPreferences();
    }

    public String getUrl() {
        return mWebViewProvider.getUrl();
    }

    public void destroy() {
        mWebViewProvider.destroy();
    }

    public Bitmap getFavicon() {
        return mWebViewProvider.getFavicon();
    }

    public void setWebViewClient(WebViewClient client) {
        mWebViewProvider.setWebViewClient(client);
    }

    public void setWebChromeClient(WebChromeClient client) {
        mWebViewProvider.setWebChromeClient(client);
    }

    public static class WebViewTransport {

        private WebView mWebview;

        public synchronized void setWebView(@Nullable WebView webview) {
            mWebview = webview;
        }

        @Nullable
        public synchronized WebView getWebView() {
            return mWebview;
        }
    }

    public WebBackForwardList copyBackForwardList() {
        return mWebViewProvider.copyBackForwardList();
    }

    public WebViewProvider getWebViewProvider() {
        return mWebViewProvider;
    }

    public NativePluginManager getNativePluginManager() {
        return mWebViewProvider.getNativePluginManager();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
