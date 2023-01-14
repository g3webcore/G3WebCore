package org.chromium.webview.g3webcore;


import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;

import org.chromium.content_public.browser.NavigationHistory;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NoSynchronizedMethodCheck")
public class WebBackForwardListChromium extends WebBackForwardList {
    private final List<WebHistoryItemChromium> mHistroryItemList;
    private final int mCurrentIndex;

    WebBackForwardListChromium(NavigationHistory navHistory) {
        mCurrentIndex = navHistory.getCurrentEntryIndex();
        mHistroryItemList = new ArrayList<WebHistoryItemChromium>(navHistory.getEntryCount());
        for (int i = 0; i < navHistory.getEntryCount(); ++i) {
            mHistroryItemList.add(new WebHistoryItemChromium(navHistory.getEntryAtIndex(i)));
        }
    }

    @Override
    public synchronized WebHistoryItem getCurrentItem() {
        if (getSize() == 0) {
            return null;
        } else {
            return getItemAtIndex(getCurrentIndex());
        }
    }

    @Override
    public synchronized int getCurrentIndex() {
        return mCurrentIndex;
    }

    @Override
    public synchronized WebHistoryItem getItemAtIndex(int index) {
        if (index < 0 || index >= getSize()) {
            return null;
        } else {
            return mHistroryItemList.get(index);
        }
    }

    @Override
    public synchronized int getSize() {
        return mHistroryItemList.size();
    }

    // Clone constructor.
    private WebBackForwardListChromium(List<WebHistoryItemChromium> list, int currentIndex) {
        mHistroryItemList = list;
        mCurrentIndex = currentIndex;
    }

    @Override
    protected synchronized WebBackForwardListChromium clone() {
        List<WebHistoryItemChromium> list = new ArrayList<WebHistoryItemChromium>(getSize());
        for (int i = 0; i < getSize(); ++i) {
            list.add(mHistroryItemList.get(i).clone());
        }
        return new WebBackForwardListChromium(list, mCurrentIndex);
    }
}
