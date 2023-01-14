// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.webview.g3webcore;


import org.chromium.base.task.PostTask;
import org.chromium.content_public.browser.NavigationHandle;
import org.chromium.content_public.browser.UiThreadTaskTraits;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsObserver;
import org.chromium.content_public.common.ContentUrlConstants;
import org.chromium.net.NetError;
import org.chromium.ui.base.PageTransition;

import java.lang.ref.WeakReference;

/**
 * Routes notifications from WebContents to G3ContentsClient and other listeners.
 */
public class G3WebContentsObserver extends WebContentsObserver {
    private final WeakReference<G3WebCore> mG3WebCore;
    private final WeakReference<G3ContentsClient> mG3ContentsClient;

    // Whether this webcontents has ever committed any navigation.
    private boolean mCommittedNavigation;

    // Temporarily stores the URL passed the last time to didFinishLoad callback.
    private String mLastDidFinishLoadUrl;

    public G3WebContentsObserver(
            WebContents webContents, G3WebCore g3WebCore, G3ContentsClient g3ContentsClient) {
        super(webContents);
        mG3WebCore = new WeakReference<>(g3WebCore);
        mG3ContentsClient = new WeakReference<>(g3ContentsClient);
    }

    private G3ContentsClient getClientIfNeedToFireCallback(String validatedUrl) {
        G3ContentsClient client = mG3ContentsClient.get();
        if (client != null) {
            String unreachableWebDataUrl = G3ContentsStatics.getUnreachableWebDataUrl();
            if (unreachableWebDataUrl == null || !unreachableWebDataUrl.equals(validatedUrl)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public void didFinishLoad(long frameId, String validatedUrl, boolean isMainFrame) {
        if (isMainFrame && getClientIfNeedToFireCallback(validatedUrl) != null) {
            mLastDidFinishLoadUrl = validatedUrl;
        }
    }

    @Override
    public void didStopLoading(String validatedUrl) {
        if (validatedUrl.length() == 0) validatedUrl = ContentUrlConstants.ABOUT_BLANK_DISPLAY_URL;
        G3ContentsClient client = getClientIfNeedToFireCallback(validatedUrl);
        if (client != null && validatedUrl.equals(mLastDidFinishLoadUrl)) {
            client.getCallbackHelper().postOnPageFinished(validatedUrl);
            mLastDidFinishLoadUrl = null;
        }
    }

    @Override
    public void loadProgressChanged(float progress) {
        G3ContentsClient client = mG3ContentsClient.get();
        if (client == null) return;
        client.getCallbackHelper().postOnProgressChanged(Math.round(progress * 100));
    }

    @Override
    public void didFailLoad(boolean isMainFrame, @NetError int errorCode, String failingUrl) {
        G3ContentsClient client = mG3ContentsClient.get();
        if (client == null) return;
        String unreachableWebDataUrl = G3ContentsStatics.getUnreachableWebDataUrl();
        boolean isErrorUrl =
                unreachableWebDataUrl != null && unreachableWebDataUrl.equals(failingUrl);
        if (isMainFrame && !isErrorUrl && errorCode == NetError.ERR_ABORTED) {
            client.getCallbackHelper().postOnPageFinished(failingUrl);
        }
    }

    @Override
    public void titleWasSet(String title) {
        G3ContentsClient client = mG3ContentsClient.get();
        if (client == null) return;
        client.updateTitle(title, true);
    }

    @Override
    public void didFinishNavigation(NavigationHandle navigation) {
        String url = navigation.getUrl();
        if (navigation.errorCode() != 0 && !navigation.isDownload()) {
            didFailLoad(navigation.isInMainFrame(), navigation.errorCode(), url);
        }

        if (!navigation.hasCommitted()) return;

        mCommittedNavigation = true;

        if (!navigation.isInMainFrame()) return;

        G3ContentsClient client = mG3ContentsClient.get();
        if (client != null) {
            // OnPageStarted is not called for in-page navigations, which include fragment
            // navigations and navigation from history.push/replaceState.
            // Error page is handled by G3ContentsClientBridge.onReceivedError.
            if (!navigation.isSameDocument() && !navigation.isErrorPage()) {
                client.getCallbackHelper().postOnPageStarted(url);
            }

            boolean isReload = navigation.pageTransition() != null
                    && ((navigation.pageTransition() & PageTransition.CORE_MASK)
                    == PageTransition.RELOAD);
            client.getCallbackHelper().postDoUpdateVisitedHistory(url, isReload);
        }

        // Only invoke the onPageCommitVisible callback when navigating to a different document,
        // but not when navigating to a different fragment within the same document.
        if (!navigation.isSameDocument()) {
            PostTask.postTask(UiThreadTaskTraits.DEFAULT, () -> {
                G3WebCore g3WebCore = mG3WebCore.get();
                if (g3WebCore != null) {
                    g3WebCore.insertVisualStateCallbackIfNotDestroyed(
                            0, new G3WebCore.VisualStateCallback() {
                                @Override
                                public void onComplete(long requestId) {
                                    G3ContentsClient client1 = mG3ContentsClient.get();
                                    if (client1 == null) return;
                                    client1.onPageCommitVisible(url);
                                }
                            });
                }
            });
        }

        if (client != null && navigation.isFragmentNavigation()) {
            // Note fragment navigations do not have a matching onPageStarted.
            client.getCallbackHelper().postOnPageFinished(url);
        }
    }

    public boolean didEverCommitNavigation() {
        return mCommittedNavigation;
    }
}
