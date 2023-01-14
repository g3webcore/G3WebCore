package org.chromium.webview.g3webcore;


import android.graphics.Bitmap;
import android.webkit.WebHistoryItem;

import org.chromium.content_public.browser.NavigationEntry;


public class WebHistoryItemChromium extends WebHistoryItem {
    private final String mUrl;
    private final String mOriginalUrl;
    private final String mTitle;
    private final Bitmap mFavicon;

    WebHistoryItemChromium(NavigationEntry entry) {
        mUrl = entry.getUrl();
        mOriginalUrl = entry.getOriginalUrl();
        mTitle = entry.getTitle();
        mFavicon = entry.getFavicon();
    }

    @Override
    public String getUrl() {
        return mUrl;
    }

    @Override
    public String getOriginalUrl() {
        return mOriginalUrl;
    }

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public Bitmap getFavicon() {
        return mFavicon;
    }

    private WebHistoryItemChromium(String url, String originalUrl, String title, Bitmap favicon) {
        mUrl = url;
        mOriginalUrl = originalUrl;
        mTitle = title;
        mFavicon = favicon;
    }

    @SuppressWarnings("NoSynchronizedMethodCheck")
    @Override
    public synchronized WebHistoryItemChromium
    clone() {
        return new WebHistoryItemChromium(mUrl, mOriginalUrl, mTitle, mFavicon);
    }
}
