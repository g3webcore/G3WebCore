package org.chromium.webview.g3webcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;

import org.chromium.content.common.NativePluginManager;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.webview.WebChromeClient;
import org.chromium.webview.WebView;
import org.chromium.webview.WebViewClient;
import org.chromium.webview.WebViewProvider;

@SuppressWarnings("deprecation")
public class WebViewChromium implements WebViewProvider {

    private G3ContentsClientAdapter mClientAdapter;
    private WebView mWebView;

    G3WebCore mG3WebCore;
    private ContentSettingsAdapter mWebSettings;
    private ViewGroup mContainerView;
    private Context mContext;
    private NativePluginManager mNativePluginManager;

    public WebViewChromium(Context context, ViewGroup containerView, WebView webView) {
        this.mContainerView = containerView;
        this.mContext = context;
        this.mWebView = webView;
        init();
    }

    private ContentSettingsAdapter createWebSettings(Context context) {
        int appTargetSdkVersion = context.getApplicationInfo().targetSdkVersion;
        final boolean isAccessFromFileURLsGrantedByDefault =
                appTargetSdkVersion < Build.VERSION_CODES.JELLY_BEAN;
        final boolean areLegacyQuirksEnabled =
                appTargetSdkVersion < Build.VERSION_CODES.KITKAT;
        final boolean allowEmptyDocumentPersistence =
                appTargetSdkVersion <= Build.VERSION_CODES.M;
        final boolean allowGeolocationOnInsecureOrigins =
                appTargetSdkVersion <= Build.VERSION_CODES.M;
        final boolean doNotUpdateSelectionOnMutatingSelectionRange =
                appTargetSdkVersion <= Build.VERSION_CODES.M;
        G3Settings settings = new G3Settings(context,
                isAccessFromFileURLsGrantedByDefault, areLegacyQuirksEnabled,
                allowEmptyDocumentPersistence, allowGeolocationOnInsecureOrigins,
                doNotUpdateSelectionOnMutatingSelectionRange);
        settings.setPluginEnabled(true);
        return new ContentSettingsAdapter(settings);
    }

    @Override
    public void init() {
        mWebSettings = createWebSettings(mContext);
        mClientAdapter = new G3ContentsClientAdapter(mWebView);
        mG3WebCore = new G3WebCore(mContext, G3BrowserContext.getDefault(), mContainerView, mWebSettings.getG3Settings(), mClientAdapter);
        mNativePluginManager = NativePluginManager.getInstance();
    }

    @Override
    public void destroy() {
        mG3WebCore.destroy();
        ((ViewGroup)mContainerView.getParent()).removeView(mContainerView);
    }

    @Override
    public void loadUrl(String url) {
        mG3WebCore.loadUrl(url);
    }

    @Override
    public void evaluateJavaScript(String script, ValueCallback<String> resultCallback) {
        mG3WebCore.evaluateJavaScript(
                script, CallbackConverter.fromValueCallback(resultCallback));
    }

    @Override
    public void stopLoading() {
        mG3WebCore.stopLoading();
    }

    @Override
    public void reload() {
        mG3WebCore.reload();
    }

    @Override
    public boolean canGoBack() {
        return mG3WebCore.canGoBack();
    }

    @Override
    public void goBack() {
        mG3WebCore.goBack();
    }

    @Override
    public boolean canGoForward() {
        return mG3WebCore.canGoForward();
    }

    @Override
    public void goForward() {
        mG3WebCore.goForward();
    }

    @Override
    public boolean canGoBackOrForward(int steps) {
        return mG3WebCore.canGoBackOrForward(steps);
    }

    @Override
    public void goBackOrForward(int steps) {
        mG3WebCore.goBackOrForward(steps);
    }

    @Override
    public boolean pageUp(boolean top) {
        return false;
    }

    @Override
    public boolean pageDown(boolean bottom) {
        return false;
    }

    @Override
    public String getUrl() {
        return mG3WebCore.getUrl();
    }

    @Override
    public String getOriginalUrl() {
        return mG3WebCore.getOriginalUrl();
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public Bitmap getFavicon() {
        return mG3WebCore.getFavicon();
    }

    @Override
    public void pauseTimers() {
        mG3WebCore.pauseTimers();
    }

    @Override
    public void resumeTimers() {
        mG3WebCore.resumeTimers();
    }

    @Override
    public void onPause() {
        mG3WebCore.onPause();
    }

    @Override
    public void onResume() {
        mG3WebCore.onResume();
    }

    @Override
    public boolean isPaused() {
        return mG3WebCore.isPaused();
    }

    public void clearCache(boolean includeDiskFiles) {
        mG3WebCore.clearCache(includeDiskFiles);
    }

    @Override
    public void clearHistory() {
        mG3WebCore.clearHistory();
    }

    @Override
    public void clearSslPreferences() {
        mG3WebCore.clearSslPreferences();
    }

    @Override
    public void setWebViewClient(WebViewClient client) {
        mClientAdapter.setWebViewClient(client);
    }

    @Override
    public WebViewClient getWebViewClient() {
        return mClientAdapter.getWebViewClient();
    }

    @Override
    public void setWebChromeClient(WebChromeClient client) {
        mWebSettings.getG3Settings().setFullscreenSupported(doesSupportFullscreen(client));
        mClientAdapter.setWebChromeClient(client);
    }

    private boolean doesSupportFullscreen(WebChromeClient client) {
        if (client == null) {
            return false;
        }
        Class<?> clientClass = client.getClass();
        boolean foundShowMethod = false;
        boolean foundHideMethod = false;
        while (clientClass != WebChromeClient.class && (!foundShowMethod || !foundHideMethod)) {
            if (!foundShowMethod) {
                try {
                    clientClass.getDeclaredMethod(
                            "onShowCustomView", View.class, WebChromeClient.CustomViewCallback.class);
                    foundShowMethod = true;
                } catch (NoSuchMethodException e) {
                    // Intentionally empty.
                }
            }

            if (!foundHideMethod) {
                try {
                    clientClass.getDeclaredMethod("onHideCustomView");
                    foundHideMethod = true;
                } catch (NoSuchMethodException e) {
                    // Intentionally empty.
                }
            }
            clientClass = clientClass.getSuperclass();
        }
        return foundShowMethod && foundHideMethod;
    }

    @Override
    public WebChromeClient getWebChromeClient() {
        return mClientAdapter.getWebChromeClient();
    }

    @Override
    public void addJavascriptInterface(Object obj, String interfaceName) {
        mG3WebCore.addJavascriptInterface(obj, interfaceName);
    }

    @Override
    public void removeJavascriptInterface(String interfaceName) {
        mG3WebCore.removeJavascriptInterface(interfaceName);
    }

    @Override
    public WebSettings getSettings() {
        return mWebSettings;
    }

    @Override
    public WebBackForwardList copyBackForwardList() {
        NavigationHistory navHistory = mG3WebCore.getNavigationHistory();
        if (navHistory == null) navHistory = new NavigationHistory();
        return new WebBackForwardListChromium(navHistory);
    }

    @Override
    public NativePluginManager getNativePluginManager() {
        return mNativePluginManager;
    }

}
