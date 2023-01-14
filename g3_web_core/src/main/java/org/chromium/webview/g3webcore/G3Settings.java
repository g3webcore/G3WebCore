// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.webview.g3webcore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.provider.Settings;
import android.util.Log;
import android.webkit.WebSettings;

import androidx.annotation.IntDef;

import org.chromium.base.ContextUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeMethods;
import org.chromium.content_public.browser.WebContents;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@JNINamespace("g3webcore")
public class G3Settings {

    private static final String TAG = "G3Settings";

    /* See {@link android.webkit.WebSettings}. */
    @Retention(RetentionPolicy.SOURCE)
    @IntDef({LAYOUT_ALGORITHM_NORMAL,
            /* See {@link android.webkit.WebSettings}. */
            LAYOUT_ALGORITHM_SINGLE_COLUMN,
            /* See {@link android.webkit.WebSettings}. */
            LAYOUT_ALGORITHM_NARROW_COLUMNS, LAYOUT_ALGORITHM_TEXT_AUTOSIZING})
    public @interface LayoutAlgorithm {}
    public static final int LAYOUT_ALGORITHM_NORMAL = 0;
    /* See {@link android.webkit.WebSettings}. */
    public static final int LAYOUT_ALGORITHM_SINGLE_COLUMN = 1;
    /* See {@link android.webkit.WebSettings}. */
    public static final int LAYOUT_ALGORITHM_NARROW_COLUMNS = 2;
    public static final int LAYOUT_ALGORITHM_TEXT_AUTOSIZING = 3;

    // This class must be created on the UI thread. Afterwards, it can be
    // used from any thread. Internally, the class uses a message queue
    // to call native code on the UI thread only.

    // Values passed in on construction.
    private final boolean mHasInternetPermission;

    private ZoomSupportChangeListener mZoomChangeListener;
    private double mDIPScale = 1.0;

    // Lock to protect all settings.
    private final Object mG3SettingsLock = new Object();

    @LayoutAlgorithm
    private int mLayoutAlgorithm = LAYOUT_ALGORITHM_NARROW_COLUMNS;
    private int mTextSizePercent = 100;
    private String mStandardFontFamily = "sans-serif";
    private String mFixedFontFamily = "monospace";
    private String mSansSerifFontFamily = "sans-serif";
    private String mSerifFontFamily = "serif";
    private String mCursiveFontFamily = "cursive";
    private String mFantasyFontFamily = "fantasy";
    private String mDefaultTextEncoding = "UTF-8";
    private String mUserAgent;
    private int mMinimumFontSize = 8;
    private int mMinimumLogicalFontSize = 8;
    private int mDefaultFontSize = 16;
    private int mDefaultFixedFontSize = 13;
    private boolean mLoadsImagesAutomatically = true;
    private boolean mImagesEnabled = true;
    private boolean mJavaScriptEnabled;
    private boolean mPluginEnabled;
    private boolean mAllowUniversalAccessFromFileURLs;
    private boolean mAllowFileAccessFromFileURLs;
    private boolean mJavaScriptCanOpenWindowsAutomatically;
    private boolean mSupportMultipleWindows;
    private boolean mAppCacheEnabled;
    private boolean mDomStorageEnabled;
    private boolean mDatabaseEnabled;
    private boolean mUseWideViewport;
    private boolean mZeroLayoutHeightDisablesViewportQuirk;
    private boolean mForceZeroLayoutHeight;
    private boolean mLoadWithOverviewMode;
    private boolean mMediaPlaybackRequiresUserGesture = true;
    private String mDefaultVideoPosterURL;
    private float mInitialPageScalePercent;
    private boolean mSpatialNavigationEnabled;  // Default depends on device features.
    private boolean mEnableSupportedHardwareAcceleratedFeatures;
    private int mMixedContentMode = WebSettings.MIXED_CONTENT_NEVER_ALLOW;
    private boolean mCSSHexAlphaColorEnabled;
    private boolean mScrollTopLeftInteropEnabled;
    private boolean mWillSuppressErrorPage;

    private boolean mOffscreenPreRaster;
    private int mDisabledMenuItems = WebSettings.MENU_ITEM_NONE;

    // Although this bit is stored on G3Settings it is actually controlled via the CookieManager.
    private boolean mAcceptThirdPartyCookies;

    private Boolean mSafeBrowsingEnabled;

    private final boolean mSupportLegacyQuirks;
    private final boolean mAllowEmptyDocumentPersistence;
    private final boolean mAllowGeolocationOnInsecureOrigins;
    private final boolean mDoNotUpdateSelectionOnMutatingSelectionRange;

    private final boolean mPasswordEchoEnabled;

    // Not accessed by the native side.
    private boolean mBlockNetworkLoads;  // Default depends on permission of embedding APK.
    private boolean mAllowContentUrlAccess = true;
    private boolean mAllowFileUrlAccess = true;
    private int mCacheMode = WebSettings.LOAD_DEFAULT;
    private boolean mShouldFocusFirstNode = true;
    private boolean mGeolocationEnabled = true;
    private boolean mAutoCompleteEnabled = Build.VERSION.SDK_INT < Build.VERSION_CODES.O;
    private boolean mFullscreenSupported;
    private boolean mSupportZoom = true;
    private boolean mBuiltInZoomControls;
    private boolean mDisplayZoomControls = true;

    static class LazyDefaultUserAgent{
        // Lazy Holder pattern
        private static final String sInstance = G3SettingsJni.get().getDefaultUserAgent();
    }

    // Protects access to settings global fields.
    private static final Object sGlobalContentSettingsLock = new Object();
    // For compatibility with the legacy WebView, we can only enable AppCache when the path is
    // provided. However, we don't use the path, so we just check if we have received it from the
    // client.
    private static boolean sAppCachePathIsSet;

    // The native side of this object. It's lifetime is bounded by the WebContent it is attached to.
    private long mNativeG3Settings;

    // Custom handler that queues messages to call native code on the UI thread.
    private final EventHandler mEventHandler;

    private static final int MINIMUM_FONT_SIZE = 1;
    private static final int MAXIMUM_FONT_SIZE = 72;

    // Class to handle messages to be processed on the UI thread.
    private class EventHandler {
        // Message id for running a Runnable with mG3SettingsLock held.
        private static final int RUN_RUNNABLE_BLOCKING = 0;
        // Actual UI thread handler
        private Handler mHandler;
        // Synchronization flag.
        private boolean mSynchronizationPending;

        EventHandler() {
        }

        @SuppressLint("HandlerLeak")
        void bindUiThread() {
            if (mHandler != null) return;
            mHandler = new Handler(ThreadUtils.getUiThreadLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    switch (msg.what) {
                        case RUN_RUNNABLE_BLOCKING:
                            synchronized (mG3SettingsLock) {
                                if (mNativeG3Settings != 0) {
                                    ((Runnable) msg.obj).run();
                                }
                                mSynchronizationPending = false;
                                mG3SettingsLock.notifyAll();
                            }
                            break;
                    }
                }
            };
        }

        void runOnUiThreadBlockingAndLocked(Runnable r) {
            assert Thread.holdsLock(mG3SettingsLock);
            if (mHandler == null) return;
            if (ThreadUtils.runningOnUiThread()) {
                r.run();
            } else {
                assert !mSynchronizationPending;
                mSynchronizationPending = true;
                mHandler.sendMessage(Message.obtain(null, RUN_RUNNABLE_BLOCKING, r));
                try {
                    while (mSynchronizationPending) {
                        mG3SettingsLock.wait();
                    }
                } catch (InterruptedException e) {
                    Log.e(TAG, "Interrupted waiting a Runnable to complete", e);
                    mSynchronizationPending = false;
                }
            }
        }

        void maybePostOnUiThread(Runnable r) {
            if (mHandler != null) {
                mHandler.post(r);
            }
        }

        void updateWebkitPreferencesLocked() {
            runOnUiThreadBlockingAndLocked(() -> updateWebkitPreferencesOnUiThreadLocked());
        }

        void updateCookiePolicyLocked() {
            runOnUiThreadBlockingAndLocked(() -> updateCookiePolicyOnUiThreadLocked());
        }

        void updateAllowFileAccessLocked() {
            runOnUiThreadBlockingAndLocked(() -> updateAllowFileAccessOnUiThreadLocked());
        }
    }

    interface ZoomSupportChangeListener {
        public void onGestureZoomSupportChanged(
                boolean supportsDoubleTapZoom, boolean supportsMultiTouchZoom);
    }

    public G3Settings(Context context, boolean isAccessFromFileURLsGrantedByDefault,
            boolean supportsLegacyQuirks, boolean allowEmptyDocumentPersistence,
            boolean allowGeolocationOnInsecureOrigins,
            boolean doNotUpdateSelectionOnMutatingSelectionRange) {
        boolean hasInternetPermission = context.checkPermission(
                android.Manifest.permission.INTERNET,
                Process.myPid(),
                Process.myUid()) == PackageManager.PERMISSION_GRANTED;
        synchronized (mG3SettingsLock) {
            mHasInternetPermission = hasInternetPermission;
            mBlockNetworkLoads = !hasInternetPermission;
            mEventHandler = new EventHandler();
            if (isAccessFromFileURLsGrantedByDefault) {
                mAllowUniversalAccessFromFileURLs = true;
                mAllowFileAccessFromFileURLs = true;
            }

            mUserAgent = LazyDefaultUserAgent.sInstance;

            // Best-guess a sensible initial value based on the features supported on the device.
            mSpatialNavigationEnabled = !context.getPackageManager().hasSystemFeature(
                    PackageManager.FEATURE_TOUCHSCREEN);

            // Respect the system setting for password echoing.
            mPasswordEchoEnabled = Settings.System.getInt(context.getContentResolver(),
                    Settings.System.TEXT_SHOW_PASSWORD, 1) == 1;

            // By default, scale the text size by the system font scale factor. Embedders
            // may override this by invoking setTextZoom().
            mTextSizePercent =
                    (int) (mTextSizePercent * context.getResources().getConfiguration().fontScale);

            mSupportLegacyQuirks = supportsLegacyQuirks;
            mAllowEmptyDocumentPersistence = allowEmptyDocumentPersistence;
            mAllowGeolocationOnInsecureOrigins = allowGeolocationOnInsecureOrigins;
            mDoNotUpdateSelectionOnMutatingSelectionRange =
                    doNotUpdateSelectionOnMutatingSelectionRange;
        }
        // Defer initializing the native side until a native WebContents instance is set.
    }

    @CalledByNative
    private void nativeG3SettingsGone(long nativeG3Settings) {
        assert mNativeG3Settings != 0 && mNativeG3Settings == nativeG3Settings;
        mNativeG3Settings = 0;
    }

    @CalledByNative
    private double getDIPScaleLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDIPScale;
    }

    void setDIPScale(double dipScale) {
        synchronized (mG3SettingsLock) {
            mDIPScale = dipScale;
            // TODO(joth): This should also be synced over to native side, but right now
            // the setDIPScale call is always followed by a setWebContents() which covers this.
        }
    }

    void setZoomListener(ZoomSupportChangeListener zoomChangeListener) {
        synchronized (mG3SettingsLock) {
            mZoomChangeListener = zoomChangeListener;
        }
    }

    public void setWebContents(WebContents webContents) {
        synchronized (mG3SettingsLock) {
            if (mNativeG3Settings != 0) {
                G3SettingsJni.get().destroy(mNativeG3Settings, G3Settings.this);
                assert mNativeG3Settings == 0;
            }
            if (webContents != null) {
                mEventHandler.bindUiThread();
                mNativeG3Settings = G3SettingsJni.get().init(G3Settings.this, webContents);
                updateEverythingLocked();
            }
        }
    }

    private void updateEverythingLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        assert mNativeG3Settings != 0;
        G3SettingsJni.get().updateEverythingLocked(mNativeG3Settings, G3Settings.this);
        onGestureZoomSupportChanged(
                supportsDoubleTapZoomLocked(), supportsMultiTouchZoomLocked());
    }

    public void setBlockNetworkLoads(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (!flag && !mHasInternetPermission) {
                throw new SecurityException("Permission denied - "
                        + "application missing INTERNET permission");
            }
            mBlockNetworkLoads = flag;
        }
    }

    public boolean getBlockNetworkLoads() {
        synchronized (mG3SettingsLock) {
            return mBlockNetworkLoads;
        }
    }

    public void setAcceptThirdPartyCookies(boolean accept) {
        synchronized (mG3SettingsLock) {
            mAcceptThirdPartyCookies = accept;
            mEventHandler.updateCookiePolicyLocked();
        }
    }

    public void setSafeBrowsingEnabled(boolean enabled) {
        synchronized (mG3SettingsLock) {
//            mSafeBrowsingEnabled = enabled;
        }
    }

    public boolean getAcceptThirdPartyCookies() {
        synchronized (mG3SettingsLock) {
            return mAcceptThirdPartyCookies;
        }
    }

    @CalledByNative
    private boolean getAcceptThirdPartyCookiesLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mAcceptThirdPartyCookies;
    }

    public boolean getSafeBrowsingEnabled() {
        synchronized (mG3SettingsLock) {
            return false;
        }
    }

    public void setAllowFileAccess(boolean allow) {
        synchronized (mG3SettingsLock) {
            mAllowFileUrlAccess = allow;
            mEventHandler.updateAllowFileAccessLocked();
        }
    }

    @CalledByNative
    public boolean getAllowFileAccess() {
        synchronized (mG3SettingsLock) {
            return mAllowFileUrlAccess;
        }
    }

    public void setAllowContentAccess(boolean allow) {
        synchronized (mG3SettingsLock) {
            mAllowContentUrlAccess = allow;
        }
    }

    public boolean getAllowContentAccess() {
        synchronized (mG3SettingsLock) {
            return mAllowContentUrlAccess;
        }
    }

    public void setCacheMode(int mode) {
        synchronized (mG3SettingsLock) {
            mCacheMode = mode;
        }
    }

    public int getCacheMode() {
        synchronized (mG3SettingsLock) {
            return mCacheMode;
        }
    }

    public void setShouldFocusFirstNode(boolean flag) {
        synchronized (mG3SettingsLock) {
            mShouldFocusFirstNode = flag;
        }
    }

    public void setInitialPageScale(final float scaleInPercent) {
        synchronized (mG3SettingsLock) {
            if (mInitialPageScalePercent != scaleInPercent) {
                mInitialPageScalePercent = scaleInPercent;
                mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
                    if (mNativeG3Settings != 0) {
                        G3SettingsJni.get().updateInitialPageScaleLocked(
                                mNativeG3Settings, G3Settings.this);
                    }
                });
            }
        }
    }

    @CalledByNative
    private float getInitialPageScalePercentLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mInitialPageScalePercent;
    }

    void setSpatialNavigationEnabled(boolean enable) {
        synchronized (mG3SettingsLock) {
            if (mSpatialNavigationEnabled != enable) {
                mSpatialNavigationEnabled = enable;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    @CalledByNative
    private boolean getSpatialNavigationLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mSpatialNavigationEnabled;
    }

    void setEnableSupportedHardwareAcceleratedFeatures(boolean enable) {
        synchronized (mG3SettingsLock) {
            if (mEnableSupportedHardwareAcceleratedFeatures != enable) {
                mEnableSupportedHardwareAcceleratedFeatures = enable;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    @CalledByNative
    private boolean getEnableSupportedHardwareAcceleratedFeaturesLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mEnableSupportedHardwareAcceleratedFeatures;
    }

    public void setFullscreenSupported(boolean supported) {
        synchronized (mG3SettingsLock) {
            if (mFullscreenSupported != supported) {
                mFullscreenSupported = supported;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    @CalledByNative
    private boolean getFullscreenSupportedLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mFullscreenSupported;
    }

    public boolean shouldFocusFirstNode() {
        synchronized (mG3SettingsLock) {
            return mShouldFocusFirstNode;
        }
    }

    public void setGeolocationEnabled(boolean flag) {
        synchronized (mG3SettingsLock) {
            mGeolocationEnabled = flag;
        }
    }

    boolean getGeolocationEnabled() {
        synchronized (mG3SettingsLock) {
            return mGeolocationEnabled;
        }
    }

    public void setSaveFormData(final boolean enable) {
        synchronized (mG3SettingsLock) {
            if (mAutoCompleteEnabled != enable) {
                mAutoCompleteEnabled = enable;
                mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
                    if (mNativeG3Settings != 0) {
                        G3SettingsJni.get().updateFormDataPreferencesLocked(
                                mNativeG3Settings, G3Settings.this);
                    }
                });
            }
        }
    }

    public boolean getSaveFormData() {
        synchronized (mG3SettingsLock) {
            return getSaveFormDataLocked();
        }
    }

    @CalledByNative
    private boolean getSaveFormDataLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mAutoCompleteEnabled;
    }

    public void setUserAgent(String ua) {
        setUserAgentString(ua);
    }

    public static String getDefaultUserAgent() {
        return LazyDefaultUserAgent.sInstance;
    }

    @CalledByNative
    private static boolean getAllowSniffingFileUrls() {
        // Don't allow sniffing file:// URLs for MIME type if the application targets P or later.
        return ContextUtils.getApplicationContext().getApplicationInfo().targetSdkVersion
                < Build.VERSION_CODES.P;
    }

    public void setUserAgentString(String ua) {
        synchronized (mG3SettingsLock) {
            final String oldUserAgent = mUserAgent;
            if (ua == null || ua.length() == 0) {
                mUserAgent = LazyDefaultUserAgent.sInstance;
            } else {
                mUserAgent = ua;
            }
            if (!oldUserAgent.equals(mUserAgent)) {
                mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
                    if (mNativeG3Settings != 0) {
                        G3SettingsJni.get().updateUserAgentLocked(
                                mNativeG3Settings, G3Settings.this);
                    }
                });
            }
        }
    }

    public String getUserAgentString() {
        synchronized (mG3SettingsLock) {
            return getUserAgentLocked();
        }
    }

    @CalledByNative
    private String getUserAgentLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mUserAgent;
    }

    public void setLoadWithOverviewMode(boolean overview) {
        synchronized (mG3SettingsLock) {
            if (mLoadWithOverviewMode != overview) {
                mLoadWithOverviewMode = overview;
                mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
                    if (mNativeG3Settings != 0) {
                        updateWebkitPreferencesOnUiThreadLocked();
                        G3SettingsJni.get().resetScrollAndScaleState(
                                mNativeG3Settings, G3Settings.this);
                    }
                });
            }
        }
    }

    /**
     * See {@link WebSettings#getLoadWithOverviewMode}.
     */
    public boolean getLoadWithOverviewMode() {
        synchronized (mG3SettingsLock) {
            return getLoadWithOverviewModeLocked();
        }
    }

    @CalledByNative
    private boolean getLoadWithOverviewModeLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mLoadWithOverviewMode;
    }

    /**
     * See {@link WebSettings#setTextZoom}.
     */
    public void setTextZoom(final int textZoom) {
        synchronized (mG3SettingsLock) {
            if (mTextSizePercent != textZoom) {
                mTextSizePercent = textZoom;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getTextZoom}.
     */
    public int getTextZoom() {
        synchronized (mG3SettingsLock) {
            return getTextSizePercentLocked();
        }
    }

    @CalledByNative
    private int getTextSizePercentLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mTextSizePercent;
    }

    /**
     * See {@link WebSettings#setStandardFontFamily}.
     */
    public void setStandardFontFamily(String font) {
        synchronized (mG3SettingsLock) {
            if (font != null && !mStandardFontFamily.equals(font)) {
                mStandardFontFamily = font;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getStandardFontFamily}.
     */
    public String getStandardFontFamily() {
        synchronized (mG3SettingsLock) {
            return getStandardFontFamilyLocked();
        }
    }

    @CalledByNative
    private String getStandardFontFamilyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mStandardFontFamily;
    }

    /**
     * See {@link WebSettings#setFixedFontFamily}.
     */
    public void setFixedFontFamily(String font) {
        synchronized (mG3SettingsLock) {
            if (font != null && !mFixedFontFamily.equals(font)) {
                mFixedFontFamily = font;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getFixedFontFamily}.
     */
    public String getFixedFontFamily() {
        synchronized (mG3SettingsLock) {
            return getFixedFontFamilyLocked();
        }
    }

    @CalledByNative
    private String getFixedFontFamilyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mFixedFontFamily;
    }

    /**
     * See {@link WebSettings#setSansSerifFontFamily}.
     */
    public void setSansSerifFontFamily(String font) {
        synchronized (mG3SettingsLock) {
            if (font != null && !mSansSerifFontFamily.equals(font)) {
                mSansSerifFontFamily = font;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getSansSerifFontFamily}.
     */
    public String getSansSerifFontFamily() {
        synchronized (mG3SettingsLock) {
            return getSansSerifFontFamilyLocked();
        }
    }

    @CalledByNative
    private String getSansSerifFontFamilyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mSansSerifFontFamily;
    }

    /**
     * See {@link WebSettings#setSerifFontFamily}.
     */
    public void setSerifFontFamily(String font) {
        synchronized (mG3SettingsLock) {
            if (font != null && !mSerifFontFamily.equals(font)) {
                mSerifFontFamily = font;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getSerifFontFamily}.
     */
    public String getSerifFontFamily() {
        synchronized (mG3SettingsLock) {
            return getSerifFontFamilyLocked();
        }
    }

    @CalledByNative
    private String getSerifFontFamilyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mSerifFontFamily;
    }

    /**
     * See {@link WebSettings#setCursiveFontFamily}.
     */
    public void setCursiveFontFamily(String font) {
        synchronized (mG3SettingsLock) {
            if (font != null && !mCursiveFontFamily.equals(font)) {
                mCursiveFontFamily = font;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getCursiveFontFamily}.
     */
    public String getCursiveFontFamily() {
        synchronized (mG3SettingsLock) {
            return getCursiveFontFamilyLocked();
        }
    }

    @CalledByNative
    private String getCursiveFontFamilyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mCursiveFontFamily;
    }

    /**
     * See {@link WebSettings#setFantasyFontFamily}.
     */
    public void setFantasyFontFamily(String font) {
        synchronized (mG3SettingsLock) {
            if (font != null && !mFantasyFontFamily.equals(font)) {
                mFantasyFontFamily = font;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getFantasyFontFamily}.
     */
    public String getFantasyFontFamily() {
        synchronized (mG3SettingsLock) {
            return getFantasyFontFamilyLocked();
        }
    }

    @CalledByNative
    private String getFantasyFontFamilyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mFantasyFontFamily;
    }

    /**
     * See {@link WebSettings#setMinimumFontSize}.
     */
    public void setMinimumFontSize(int size) {
        synchronized (mG3SettingsLock) {
            size = clipFontSize(size);
            if (mMinimumFontSize != size) {
                mMinimumFontSize = size;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getMinimumFontSize}.
     */
    public int getMinimumFontSize() {
        synchronized (mG3SettingsLock) {
            return getMinimumFontSizeLocked();
        }
    }

    @CalledByNative
    private int getMinimumFontSizeLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mMinimumFontSize;
    }

    /**
     * See {@link WebSettings#setMinimumLogicalFontSize}.
     */
    public void setMinimumLogicalFontSize(int size) {
        synchronized (mG3SettingsLock) {
            size = clipFontSize(size);
            if (mMinimumLogicalFontSize != size) {
                mMinimumLogicalFontSize = size;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getMinimumLogicalFontSize}.
     */
    public int getMinimumLogicalFontSize() {
        synchronized (mG3SettingsLock) {
            return getMinimumLogicalFontSizeLocked();
        }
    }

    @CalledByNative
    private int getMinimumLogicalFontSizeLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mMinimumLogicalFontSize;
    }

    /**
     * See {@link WebSettings#setDefaultFontSize}.
     */
    public void setDefaultFontSize(int size) {
        synchronized (mG3SettingsLock) {
            size = clipFontSize(size);
            if (mDefaultFontSize != size) {
                mDefaultFontSize = size;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getDefaultFontSize}.
     */
    public int getDefaultFontSize() {
        synchronized (mG3SettingsLock) {
            return getDefaultFontSizeLocked();
        }
    }

    @CalledByNative
    private int getDefaultFontSizeLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDefaultFontSize;
    }

    /**
     * See {@link WebSettings#setDefaultFixedFontSize}.
     */
    public void setDefaultFixedFontSize(int size) {
        synchronized (mG3SettingsLock) {
            size = clipFontSize(size);
            if (mDefaultFixedFontSize != size) {
                mDefaultFixedFontSize = size;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getDefaultFixedFontSize}.
     */
    public int getDefaultFixedFontSize() {
        synchronized (mG3SettingsLock) {
            return getDefaultFixedFontSizeLocked();
        }
    }

    @CalledByNative
    private int getDefaultFixedFontSizeLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDefaultFixedFontSize;
    }

    /**
     * See {@link WebSettings#setJavaScriptEnabled}.
     */
    public void setJavaScriptEnabled(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mJavaScriptEnabled != flag) {
                mJavaScriptEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public void setPluginEnabled(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mPluginEnabled != flag) {
                mPluginEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#setAllowUniversalAccessFromFileURLs}.
     */
    public void setAllowUniversalAccessFromFileURLs(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mAllowUniversalAccessFromFileURLs != flag) {
                mAllowUniversalAccessFromFileURLs = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#setAllowFileAccessFromFileURLs}.
     */
    public void setAllowFileAccessFromFileURLs(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mAllowFileAccessFromFileURLs != flag) {
                mAllowFileAccessFromFileURLs = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#setLoadsImagesAutomatically}.
     */
    public void setLoadsImagesAutomatically(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mLoadsImagesAutomatically != flag) {
                mLoadsImagesAutomatically = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getLoadsImagesAutomatically}.
     */
    public boolean getLoadsImagesAutomatically() {
        synchronized (mG3SettingsLock) {
            return getLoadsImagesAutomaticallyLocked();
        }
    }

    @CalledByNative
    private boolean getLoadsImagesAutomaticallyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mLoadsImagesAutomatically;
    }

    public void setImagesEnabled(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mImagesEnabled != flag) {
                mImagesEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public boolean getImagesEnabled() {
        synchronized (mG3SettingsLock) {
            return mImagesEnabled;
        }
    }

    @CalledByNative
    private boolean getImagesEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mImagesEnabled;
    }

    /**
     * See {@link WebSettings#getJavaScriptEnabled}.
     */
    public boolean getJavaScriptEnabled() {
        synchronized (mG3SettingsLock) {
            return mJavaScriptEnabled;
        }
    }

    @CalledByNative
    private boolean getJavaScriptEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mJavaScriptEnabled;
    }

    
    @CalledByNative
    private boolean getPluginEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mPluginEnabled;
    }

    /**
     * See {@link WebSettings#getAllowUniversalAccessFromFileURLs}.
     */
    public boolean getAllowUniversalAccessFromFileURLs() {
        synchronized (mG3SettingsLock) {
            return getAllowUniversalAccessFromFileURLsLocked();
        }
    }

    @CalledByNative
    private boolean getAllowUniversalAccessFromFileURLsLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mAllowUniversalAccessFromFileURLs;
    }

    /**
     * See {@link WebSettings#getAllowFileAccessFromFileURLs}.
     */
    public boolean getAllowFileAccessFromFileURLs() {
        synchronized (mG3SettingsLock) {
            return getAllowFileAccessFromFileURLsLocked();
        }
    }

    @CalledByNative
    private boolean getAllowFileAccessFromFileURLsLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mAllowFileAccessFromFileURLs;
    }

    /**
     * See {@link WebSettings#setJavaScriptCanOpenWindowsAutomatically}.
     */
    public void setJavaScriptCanOpenWindowsAutomatically(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mJavaScriptCanOpenWindowsAutomatically != flag) {
                mJavaScriptCanOpenWindowsAutomatically = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getJavaScriptCanOpenWindowsAutomatically}.
     */
    public boolean getJavaScriptCanOpenWindowsAutomatically() {
        synchronized (mG3SettingsLock) {
            return getJavaScriptCanOpenWindowsAutomaticallyLocked();
        }
    }

    @CalledByNative
    private boolean getJavaScriptCanOpenWindowsAutomaticallyLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mJavaScriptCanOpenWindowsAutomatically;
    }

    /**
     * See {@link WebSettings#setLayoutAlgorithm}.
     */
    public void setLayoutAlgorithm(@LayoutAlgorithm int l) {
        synchronized (mG3SettingsLock) {
            if (mLayoutAlgorithm != l) {
                mLayoutAlgorithm = l;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getLayoutAlgorithm}.
     */
    @LayoutAlgorithm
    public int getLayoutAlgorithm() {
        synchronized (mG3SettingsLock) {
            return mLayoutAlgorithm;
        }
    }

    /**
     * Gets whether Text Auto-sizing layout algorithm is enabled.
     *
     * @return true if Text Auto-sizing layout algorithm is enabled
     */
    @CalledByNative
    private boolean getTextAutosizingEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mLayoutAlgorithm == LAYOUT_ALGORITHM_TEXT_AUTOSIZING;
    }

    /**
     * See {@link WebSettings#setSupportMultipleWindows}.
     */
    public void setSupportMultipleWindows(boolean support) {
        synchronized (mG3SettingsLock) {
            if (mSupportMultipleWindows != support) {
                mSupportMultipleWindows = support;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#supportMultipleWindows}.
     */
    public boolean supportMultipleWindows() {
        synchronized (mG3SettingsLock) {
            return mSupportMultipleWindows;
        }
    }

    @CalledByNative
    private boolean getSupportMultipleWindowsLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mSupportMultipleWindows;
    }

    @CalledByNative
    private boolean getCSSHexAlphaColorEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mCSSHexAlphaColorEnabled;
    }

    public void setCSSHexAlphaColorEnabled(boolean enabled) {
        synchronized (mG3SettingsLock) {
            if (mCSSHexAlphaColorEnabled != enabled) {
                mCSSHexAlphaColorEnabled = enabled;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    @CalledByNative
    private boolean getScrollTopLeftInteropEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mScrollTopLeftInteropEnabled;
    }

    public void setScrollTopLeftInteropEnabled(boolean enabled) {
        synchronized (mG3SettingsLock) {
            if (mScrollTopLeftInteropEnabled != enabled) {
                mScrollTopLeftInteropEnabled = enabled;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    @CalledByNative
    private boolean getWillSuppressErrorPageLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mWillSuppressErrorPage;
    }

    public boolean getWillSuppressErrorPage() {
        synchronized (mG3SettingsLock) {
            return getWillSuppressErrorPageLocked();
        }
    }

    public void setWillSuppressErrorPage(boolean suppressed) {
        synchronized (mG3SettingsLock) {
            if (mWillSuppressErrorPage == suppressed) return;

            mWillSuppressErrorPage = suppressed;
            updateWillSuppressErrorStateLocked();
        }
    }

    private void updateWillSuppressErrorStateLocked() {
        mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
            assert Thread.holdsLock(mG3SettingsLock);
            assert mNativeG3Settings != 0;
            G3SettingsJni.get().updateWillSuppressErrorStateLocked(
                    mNativeG3Settings, G3Settings.this);
        });
    }

    @CalledByNative
    private boolean getSupportLegacyQuirksLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mSupportLegacyQuirks;
    }

    @CalledByNative
    private boolean getAllowEmptyDocumentPersistenceLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mAllowEmptyDocumentPersistence;
    }

    @CalledByNative
    private boolean getAllowGeolocationOnInsecureOrigins() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mAllowGeolocationOnInsecureOrigins;
    }

    @CalledByNative
    private boolean getDoNotUpdateSelectionOnMutatingSelectionRange() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDoNotUpdateSelectionOnMutatingSelectionRange;
    }

    /**
     * See {@link WebSettings#setUseWideViewPort}.
     */
    public void setUseWideViewPort(boolean use) {
        synchronized (mG3SettingsLock) {
            if (mUseWideViewport != use) {
                mUseWideViewport = use;
                onGestureZoomSupportChanged(
                        supportsDoubleTapZoomLocked(), supportsMultiTouchZoomLocked());
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getUseWideViewPort}.
     */
    public boolean getUseWideViewPort() {
        synchronized (mG3SettingsLock) {
            return getUseWideViewportLocked();
        }
    }

    @CalledByNative
    private boolean getUseWideViewportLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mUseWideViewport;
    }

    public void setZeroLayoutHeightDisablesViewportQuirk(boolean enabled) {
        synchronized (mG3SettingsLock) {
            if (mZeroLayoutHeightDisablesViewportQuirk != enabled) {
                mZeroLayoutHeightDisablesViewportQuirk = enabled;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public boolean getZeroLayoutHeightDisablesViewportQuirk() {
        synchronized (mG3SettingsLock) {
            return getZeroLayoutHeightDisablesViewportQuirkLocked();
        }
    }

    @CalledByNative
    private boolean getZeroLayoutHeightDisablesViewportQuirkLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mZeroLayoutHeightDisablesViewportQuirk;
    }

    public void setForceZeroLayoutHeight(boolean enabled) {
        synchronized (mG3SettingsLock) {
            if (mForceZeroLayoutHeight != enabled) {
                mForceZeroLayoutHeight = enabled;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public boolean getForceZeroLayoutHeight() {
        synchronized (mG3SettingsLock) {
            return getForceZeroLayoutHeightLocked();
        }
    }

    @CalledByNative
    private boolean getForceZeroLayoutHeightLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mForceZeroLayoutHeight;
    }

    @CalledByNative
    private boolean getPasswordEchoEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mPasswordEchoEnabled;
    }

    /**
     * See {@link WebSettings#setAppCacheEnabled}.
     */
    public void setAppCacheEnabled(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mAppCacheEnabled != flag) {
                mAppCacheEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#setAppCachePath}.
     */
    public void setAppCachePath(String path) {
        boolean needToSync = false;
        synchronized (sGlobalContentSettingsLock) {
            // AppCachePath can only be set once.
            if (!sAppCachePathIsSet && path != null && !path.isEmpty()) {
                sAppCachePathIsSet = true;
                needToSync = true;
            }
        }
        // The obvious problem here is that other WebViews will not be updated,
        // until they execute synchronization from Java to the native side.
        // But this is the same behaviour as it was in the legacy WebView.
        if (needToSync) {
            synchronized (mG3SettingsLock) {
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * Gets whether Application Cache is enabled.
     *
     * @return true if Application Cache is enabled
     */
    @CalledByNative
    private boolean getAppCacheEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        if (!mAppCacheEnabled) {
            return false;
        }
        synchronized (sGlobalContentSettingsLock) {
            return sAppCachePathIsSet;
        }
    }

    /**
     * See {@link WebSettings#setDomStorageEnabled}.
     */
    public void setDomStorageEnabled(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mDomStorageEnabled != flag) {
                mDomStorageEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getDomStorageEnabled}.
     */
    public boolean getDomStorageEnabled() {
        synchronized (mG3SettingsLock) {
            return mDomStorageEnabled;
        }
    }

    @CalledByNative
    private boolean getDomStorageEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDomStorageEnabled;
    }

    /**
     * See {@link WebSettings#setDatabaseEnabled}.
     */
    public void setDatabaseEnabled(boolean flag) {
        synchronized (mG3SettingsLock) {
            if (mDatabaseEnabled != flag) {
                mDatabaseEnabled = flag;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getDatabaseEnabled}.
     */
    public boolean getDatabaseEnabled() {
        synchronized (mG3SettingsLock) {
            return mDatabaseEnabled;
        }
    }

    @CalledByNative
    private boolean getDatabaseEnabledLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDatabaseEnabled;
    }

    /**
     * See {@link WebSettings#setDefaultTextEncodingName}.
     */
    public void setDefaultTextEncodingName(String encoding) {
        synchronized (mG3SettingsLock) {
            if (encoding != null && !mDefaultTextEncoding.equals(encoding)) {
                mDefaultTextEncoding = encoding;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getDefaultTextEncodingName}.
     */
    public String getDefaultTextEncodingName() {
        synchronized (mG3SettingsLock) {
            return getDefaultTextEncodingLocked();
        }
    }

    @CalledByNative
    private String getDefaultTextEncodingLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDefaultTextEncoding;
    }

    /**
     * See {@link WebSettings#setMediaPlaybackRequiresUserGesture}.
     */
    public void setMediaPlaybackRequiresUserGesture(boolean require) {
        synchronized (mG3SettingsLock) {
            if (mMediaPlaybackRequiresUserGesture != require) {
                mMediaPlaybackRequiresUserGesture = require;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    /**
     * See {@link WebSettings#getMediaPlaybackRequiresUserGesture}.
     */
    public boolean getMediaPlaybackRequiresUserGesture() {
        synchronized (mG3SettingsLock) {
            return getMediaPlaybackRequiresUserGestureLocked();
        }
    }

    @CalledByNative
    private boolean getMediaPlaybackRequiresUserGestureLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mMediaPlaybackRequiresUserGesture;
    }

    public void setDefaultVideoPosterURL(String url) {
        synchronized (mG3SettingsLock) {
            if ((mDefaultVideoPosterURL != null && !mDefaultVideoPosterURL.equals(url))
                    || (mDefaultVideoPosterURL == null && url != null)) {
                mDefaultVideoPosterURL = url;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public String getDefaultVideoPosterURL() {
        synchronized (mG3SettingsLock) {
            return getDefaultVideoPosterURLLocked();
        }
    }

    @CalledByNative
    private String getDefaultVideoPosterURLLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mDefaultVideoPosterURL;
    }

    private void onGestureZoomSupportChanged(
            final boolean supportsDoubleTapZoom, final boolean supportsMultiTouchZoom) {
        // Always post asynchronously here, to avoid doubling back onto the caller.
        mEventHandler.maybePostOnUiThread(() -> {
            synchronized (mG3SettingsLock) {
                if (mZoomChangeListener != null) {
                    mZoomChangeListener.onGestureZoomSupportChanged(
                            supportsDoubleTapZoom, supportsMultiTouchZoom);
                }
            }
        });
    }

    /**
     * See {@link WebSettings#setSupportZoom}.
     */
    public void setSupportZoom(boolean support) {
        synchronized (mG3SettingsLock) {
            if (mSupportZoom != support) {
                mSupportZoom = support;
                onGestureZoomSupportChanged(
                        supportsDoubleTapZoomLocked(), supportsMultiTouchZoomLocked());
            }
        }
    }

    /**
     * See {@link WebSettings#supportZoom}.
     */
    public boolean supportZoom() {
        synchronized (mG3SettingsLock) {
            return mSupportZoom;
        }
    }

    /**
     * See {@link WebSettings#setBuiltInZoomControls}.
     */
    public void setBuiltInZoomControls(boolean enabled) {
        synchronized (mG3SettingsLock) {
            if (mBuiltInZoomControls != enabled) {
                mBuiltInZoomControls = enabled;
                onGestureZoomSupportChanged(
                        supportsDoubleTapZoomLocked(), supportsMultiTouchZoomLocked());
            }
        }
    }

    /**
     * See {@link WebSettings#getBuiltInZoomControls}.
     */
    public boolean getBuiltInZoomControls() {
        synchronized (mG3SettingsLock) {
            return mBuiltInZoomControls;
        }
    }

    /**
     * See {@link WebSettings#setDisplayZoomControls}.
     */
    public void setDisplayZoomControls(boolean enabled) {
        synchronized (mG3SettingsLock) {
            mDisplayZoomControls = enabled;
        }
    }

    /**
     * See {@link WebSettings#getDisplayZoomControls}.
     */
    public boolean getDisplayZoomControls() {
        synchronized (mG3SettingsLock) {
            return mDisplayZoomControls;
        }
    }

    public void setMixedContentMode(int mode) {
        synchronized (mG3SettingsLock) {
            if (mMixedContentMode != mode) {
                mMixedContentMode = mode;
                mEventHandler.updateWebkitPreferencesLocked();
            }
        }
    }

    public int getMixedContentMode() {
        synchronized (mG3SettingsLock) {
            return mMixedContentMode;
        }
    }

    @CalledByNative
    private boolean getAllowRunningInsecureContentLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mMixedContentMode == WebSettings.MIXED_CONTENT_ALWAYS_ALLOW;
    }

    @CalledByNative
    private boolean getUseStricMixedContentCheckingLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mMixedContentMode == WebSettings.MIXED_CONTENT_NEVER_ALLOW;
    }

    @CalledByNative
    private boolean getAllowMixedContentAutoupgradesLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        // We only allow mixed content autoupgrades (upgrading HTTP subresources to HTTPS in HTTPS
        // sites) when the mixed content mode is set to MIXED_CONTENT_COMPATIBILITY, which keeps it
        // in line with the behavior in Chrome. With MIXED_CONTENT_ALWAYS_ALLOW, we disable
        // autoupgrades since the developer is explicitly allowing mixed content, whereas with
        // MIXED_CONTENT_NEVER_ALLOW, there is no need to autoupgrade since the content will be
        // blocked.
        return mMixedContentMode == WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE;
    }

    public boolean getOffscreenPreRaster() {
        synchronized (mG3SettingsLock) {
            return getOffscreenPreRasterLocked();
        }
    }

    @CalledByNative
    private boolean getOffscreenPreRasterLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mOffscreenPreRaster;
    }

    /**
     * Sets whether this WebView should raster tiles when it is
     * offscreen but attached to window. Turning this on can avoid
     * rendering artifacts when animating an offscreen WebView on-screen.
     * In particular, insertVisualStateCallback requires this mode to function.
     * Offscreen WebViews in this mode uses more memory. Please follow
     * these guidelines to limit memory usage:
     * - Webview size should be not be larger than the device screen size.
     * - Limit simple mode to a small number of webviews. Use it for
     *   visible webviews and webviews about to be animated to visible.
     */
    public void setOffscreenPreRaster(boolean enabled) {
        synchronized (mG3SettingsLock) {
            if (enabled != mOffscreenPreRaster) {
                mOffscreenPreRaster = enabled;
                mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
                    if (mNativeG3Settings != 0) {
                        G3SettingsJni.get().updateOffscreenPreRasterLocked(
                                mNativeG3Settings, G3Settings.this);
                    }
                });
            }
        }
    }

    public int getDisabledActionModeMenuItems() {
        synchronized (mG3SettingsLock) {
            return mDisabledMenuItems;
        }
    }

    public void setDisabledActionModeMenuItems(int menuItems) {
        synchronized (mG3SettingsLock) {
            mDisabledMenuItems = menuItems;
        }
    }

    public void updateAcceptLanguages() {
        synchronized (mG3SettingsLock) {
            mEventHandler.runOnUiThreadBlockingAndLocked(() -> {
                if (mNativeG3Settings != 0) {
                    G3SettingsJni.get().updateRendererPreferencesLocked(
                            mNativeG3Settings, G3Settings.this);
                }
            });
        }
    }

    @CalledByNative
    private boolean supportsDoubleTapZoomLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mSupportZoom && mBuiltInZoomControls && mUseWideViewport;
    }

    private boolean supportsMultiTouchZoomLocked() {
        assert Thread.holdsLock(mG3SettingsLock);
        return mSupportZoom && mBuiltInZoomControls;
    }

    boolean supportsMultiTouchZoom() {
        synchronized (mG3SettingsLock) {
            return supportsMultiTouchZoomLocked();
        }
    }

    boolean shouldDisplayZoomControls() {
        synchronized (mG3SettingsLock) {
            return supportsMultiTouchZoomLocked() && mDisplayZoomControls;
        }
    }

    private int clipFontSize(int size) {
        if (size < MINIMUM_FONT_SIZE) {
            return MINIMUM_FONT_SIZE;
        } else if (size > MAXIMUM_FONT_SIZE) {
            return MAXIMUM_FONT_SIZE;
        }
        return size;
    }

    @CalledByNative
    private boolean getRecordFullDocument() {
        assert Thread.holdsLock(mG3SettingsLock);
        return G3ContentsStatics.getRecordFullDocument();
    }

    @CalledByNative
    private void updateEverything() {
        synchronized (mG3SettingsLock) {
            updateEverythingLocked();
        }
    }

    @CalledByNative
    private void populateWebPreferences(long webPrefsPtr) {
        synchronized (mG3SettingsLock) {
            assert mNativeG3Settings != 0;
            G3SettingsJni.get().populateWebPreferencesLocked(
                    mNativeG3Settings, G3Settings.this, webPrefsPtr);
        }
    }

    private void updateWebkitPreferencesOnUiThreadLocked() {
        assert mEventHandler.mHandler != null;
        ThreadUtils.assertOnUiThread();
        if (mNativeG3Settings != 0) {
            G3SettingsJni.get().updateWebkitPreferencesLocked(mNativeG3Settings, G3Settings.this);
        }
    }

    private void updateCookiePolicyOnUiThreadLocked() {
        assert mEventHandler.mHandler != null;
        ThreadUtils.assertOnUiThread();
        if (mNativeG3Settings != 0) {
            G3SettingsJni.get().updateCookiePolicyLocked(mNativeG3Settings, G3Settings.this);
        }
    }

    private void updateAllowFileAccessOnUiThreadLocked() {
        assert mEventHandler.mHandler != null;
        ThreadUtils.assertOnUiThread();
        if (mNativeG3Settings != 0) {
            G3SettingsJni.get().updateAllowFileAccessLocked(mNativeG3Settings, G3Settings.this);
        }
    }

    @NativeMethods
    interface Natives {
        long init(G3Settings caller, WebContents webContents);
        void destroy(long nativeG3Settings, G3Settings caller);
        void populateWebPreferencesLocked(
                long nativeG3Settings, G3Settings caller, long webPrefsPtr);
        void resetScrollAndScaleState(long nativeG3Settings, G3Settings caller);
        void updateEverythingLocked(long nativeG3Settings, G3Settings caller);
        void updateInitialPageScaleLocked(long nativeG3Settings, G3Settings caller);
        void updateUserAgentLocked(long nativeG3Settings, G3Settings caller);
        void updateWebkitPreferencesLocked(long nativeG3Settings, G3Settings caller);
        String getDefaultUserAgent();
        void updateFormDataPreferencesLocked(long nativeG3Settings, G3Settings caller);
        void updateRendererPreferencesLocked(long nativeG3Settings, G3Settings caller);
        void updateOffscreenPreRasterLocked(long nativeG3Settings, G3Settings caller);
        void updateWillSuppressErrorStateLocked(long nativeG3Settings, G3Settings caller);
        void updateCookiePolicyLocked(long nativeG3Settings, G3Settings caller);
        void updateAllowFileAccessLocked(long nativeG3Settings, G3Settings caller);
    }
}
