package org.chromium.webview.g3webcore;


import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;

import java.lang.ref.WeakReference;

/**
 * This class implements G3GeolocationPermissions.Callback, and will be sent to
 * WebView applications through WebChromeClient.onGeolocationPermissionsShowPrompt().
 */
public class G3GeolocationCallback implements G3GeolocationPermissions.Callback {
    private static final String TAG = "Geolocation";

    private CleanupRunable mCleanupRunable;
    private CleanupReference mCleanupReference;

    private static class CleanupRunable implements Runnable {
        private WeakReference<G3WebCore> mG3Contents;
        private boolean mAllow;
        private boolean mRetain;
        private String mOrigin;

        public CleanupRunable(G3WebCore awContents, String origin) {
            mG3Contents = new WeakReference<G3WebCore>(awContents);
            mOrigin = origin;
        }

        @Override
        public void run() {
            assert ThreadUtils.runningOnUiThread();
            G3WebCore awContents = mG3Contents.get();
            if (awContents == null) return;
            if (mRetain) {
                if (mAllow) {
                    awContents.getGeolocationPermissions().allow(mOrigin);
                } else {
                    awContents.getGeolocationPermissions().deny(mOrigin);
                }
            }
            awContents.invokeGeolocationCallback(mAllow, mOrigin);
        }

        public void setResponse(String origin, boolean allow, boolean retain) {
            mOrigin = origin;
            mAllow = allow;
            mRetain = retain;
        }
    }

    public G3GeolocationCallback(String origin, G3WebCore awContents) {
        mCleanupRunable = new CleanupRunable(awContents, origin);
        mCleanupReference = new CleanupReference(this, mCleanupRunable);
    }

    @Override
    public void invoke(String origin, boolean allow, boolean retain) {
        if (mCleanupRunable == null || mCleanupReference == null) {
            Log.w(TAG, "Response for this geolocation request has been received."
                    + " Ignoring subsequent responses");
            return;
        }
        mCleanupRunable.setResponse(origin, allow, retain);
        mCleanupReference.cleanupNow();
        mCleanupReference = null;
        mCleanupRunable = null;
    }
}
