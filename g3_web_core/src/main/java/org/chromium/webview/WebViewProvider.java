package org.chromium.webview;

import android.graphics.Bitmap;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebSettings;

import org.chromium.content.common.NativePluginManager;


public interface WebViewProvider {

    void init();

    void destroy();

    void loadUrl(String url);

    void evaluateJavaScript(String script, ValueCallback<String> resultCallback);

    void stopLoading();

    void reload();

    boolean canGoBack();

    void goBack();

    boolean canGoForward();

    void goForward();

    boolean canGoBackOrForward(int steps);

    void goBackOrForward(int steps);

    boolean pageUp(boolean top);

    boolean pageDown(boolean bottom);

    String getUrl();

    String getOriginalUrl();

    String getTitle();

    Bitmap getFavicon();

    void pauseTimers();

    void resumeTimers();

    void onPause();

    void onResume();

    boolean isPaused();

    void clearCache(boolean includeDiskFiles);

    void clearHistory();

    void clearSslPreferences();

    void setWebViewClient(WebViewClient client);

    WebViewClient getWebViewClient();

    void setWebChromeClient(WebChromeClient client);

    WebChromeClient getWebChromeClient();

    void addJavascriptInterface(Object obj, String interfaceName);

    void removeJavascriptInterface(String interfaceName);

    WebSettings getSettings();

    WebBackForwardList copyBackForwardList();

    NativePluginManager getNativePluginManager();

}
