package org.chromium.webview.g3webcore;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;

import org.chromium.base.Callback;
import org.chromium.base.ContextUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeMethods;
import org.chromium.base.metrics.ScopedSysTraceEvent;
import org.chromium.base.task.PostTask;
import org.chromium.components.embedder_support.view.ContentViewRenderView;
import org.chromium.content_public.browser.ContentViewStatics;
import org.chromium.content_public.browser.JavaScriptCallback;
import org.chromium.content_public.browser.JavascriptInjector;
import org.chromium.content_public.browser.LoadUrlParams;
import org.chromium.content_public.browser.NavigationController;
import org.chromium.content_public.browser.NavigationHistory;
import org.chromium.content_public.browser.UiThreadTaskTraits;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsInternals;
import org.chromium.ui.base.ActivityWindowAndroid;
import org.chromium.ui.base.PageTransition;
import org.chromium.ui.base.WindowAndroid;
import org.chromium.webview.WebView;

import java.lang.annotation.Annotation;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

@JNINamespace("g3webcore")
public class G3WebCore {

    private Context mContext;
    private WebContents mWebContents;
    private ViewGroup mContainerView;
    private ContentViewRenderView mContentViewRenderView;
    private G3ContentView mG3ContentView;
    private WindowAndroidWrapper mWindowAndroid;
    private NavigationController mNavigationController;
    private final G3ContentsIoThreadClient mIoThreadClient;
    private final G3Settings mSettings;
    private final G3ContentsBackgroundThreadClient mBackgroundThreadClient;
    private final G3ContentsClient mContentsClient;
    private final DefaultVideoPosterRequestHandler mDefaultVideoPosterRequestHandler;
    private final G3ContentsClientBridge mContentsClientBridge;
    private final G3WebContentsDelegateAdapter mWebContentsDelegate;
    private G3WebContentsObserver mWebContentsObserver;
    private WebContentsInternalsHolder mWebContentsInternalsHolder;
    private G3ViewAndroidDelegate mViewAndroidDelegate;
    private G3BrowserContext mBrowserContext;
    private JavascriptInjector mJavascriptInjector;
    private boolean mHasRequestedVisitedHistoryFromClient;

    private Bitmap mFavicon;

    private boolean mIsDestroyed;

    private long mNativeG3WebCore;
    private boolean mIsPaused;
    private boolean mFullScreen;

    public G3WebCore(Context context, G3BrowserContext browserContext, ViewGroup containerView, G3Settings settings, G3ContentsClient contentsClient) {
        mBrowserContext = browserContext;
        mContext = context;
        mContentsClient = contentsClient;
        mContainerView = containerView;
        mWindowAndroid = getWindowAndroid(mContext);
        mWindowAndroid.getWindowAndroid().restoreInstanceState(null);
        mSettings = settings;
        mDefaultVideoPosterRequestHandler = new DefaultVideoPosterRequestHandler(mContentsClient);
        mSettings.setDefaultVideoPosterURL(mDefaultVideoPosterRequestHandler.getDefaultVideoPosterURL());
        mBackgroundThreadClient = new BackgroundThreadClientImpl();
        mIoThreadClient = new IoThreadClientImpl();
        mContentsClientBridge = new G3ContentsClientBridge(
                mContext, contentsClient, G3ContentsStatics.getClientCertLookupTable());
        mWebContentsDelegate = new G3WebContentsDelegateAdapter(
                this, contentsClient, settings, mContext, mContainerView);
        setNewG3Contents(G3WebCoreJni.get().initNative(this));
    }

    private class BackgroundThreadClientImpl extends G3ContentsBackgroundThreadClient {

        @Override
        public G3WebResourceResponse shouldInterceptRequest(
                G3ContentsClient.G3WebResourceRequest request) {
            String url = request.url;
            G3WebResourceResponse awWebResourceResponse;
            awWebResourceResponse = mDefaultVideoPosterRequestHandler.shouldInterceptRequest(url);
            if (awWebResourceResponse != null) return awWebResourceResponse;

            awWebResourceResponse = mContentsClient.shouldInterceptRequest(request);

            if (awWebResourceResponse == null) {
                mContentsClient.getCallbackHelper().postOnLoadResource(url);
            }

            if (awWebResourceResponse != null) {
                String mimeType = awWebResourceResponse.getMimeType();
                if (mimeType == null) {
                    G3HistogramRecorder.recordMimeType(
                            G3HistogramRecorder.MimeType.NULL_FROM_SHOULD_INTERCEPT_REQUEST);
                } else {
                    G3HistogramRecorder.recordMimeType(
                            G3HistogramRecorder.MimeType.NONNULL_FROM_SHOULD_INTERCEPT_REQUEST);
                }
            }
            if (awWebResourceResponse != null && awWebResourceResponse.getData() == null) {
                mContentsClient.getCallbackHelper().postOnReceivedError(
                        request,
                        new G3ContentsClient.G3WebResourceError());
            }
            return awWebResourceResponse;
        }
    }

    private class IoThreadClientImpl extends G3ContentsIoThreadClient {

        @Override
        public int getCacheMode() {
            return mSettings.getCacheMode();
        }

        @Override
        public G3ContentsBackgroundThreadClient getBackgroundThreadClient() {
            return mBackgroundThreadClient;
        }

        @Override
        public boolean shouldBlockContentUrls() {
            return !mSettings.getAllowContentAccess();
        }

        @Override
        public boolean shouldBlockFileUrls() {
            return !mSettings.getAllowFileAccess();
        }

        @Override
        public boolean shouldBlockNetworkLoads() {
            return mSettings.getBlockNetworkLoads();
        }

        @Override
        public boolean shouldAcceptThirdPartyCookies() {
            return mSettings.getAcceptThirdPartyCookies();
        }

        @Override
        public boolean getSafeBrowsingEnabled() {
            return mSettings.getSafeBrowsingEnabled();
        }
    }

    public NavigationController getNavigationController() {
        return mNavigationController;
    }

    private void setNewG3Contents(long g3WebCorePtr) {

        if (mNativeG3WebCore != 0) {
            destroyNatives();
        }

        mNativeG3WebCore = g3WebCorePtr;
        mWebContents = G3WebCoreJni.get().getWebContents(mNativeG3WebCore, G3WebCore.this);
        mBrowserContext = G3WebCoreJni.get().getBrowserContext(mNativeG3WebCore, G3WebCore.this);
        mNavigationController = mWebContents.getNavigationController();
        Context context = mContext;
        mG3ContentView = G3ContentView.createContentView(context, mWebContents, this);
        mViewAndroidDelegate = new G3ViewAndroidDelegate(mG3ContentView, mContentsClient);
        mWebContentsInternalsHolder = new WebContentsInternalsHolder(this);
        mWebContents.initialize(
                "", mViewAndroidDelegate, mG3ContentView,  mWindowAndroid.getWindowAndroid(), mWebContentsInternalsHolder);
        if (mContainerView.getParent() != null) mWebContents.onShow();
        mContainerView.addView(mG3ContentView,
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));
        mG3ContentView.requestFocus();

        mContentViewRenderView = new ContentViewRenderView(context);
        mContentViewRenderView.onNativeLibraryLoaded(mWindowAndroid.getWindowAndroid(), ContentViewRenderView.MODE_SURFACE_VIEW);
        mContainerView.addView(mContentViewRenderView,
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));
        mContentViewRenderView.setCurrentWebContents(mWebContents);

        if (mWebContentsObserver != null) {
            mWebContentsObserver.destroy();
        }
        mWebContentsObserver = new G3WebContentsObserver(mWebContents, this, mContentsClient);

        mSettings.setWebContents(mWebContents);

        G3WebCoreJni.get().setJavaPeers(mNativeG3WebCore, this, this,
                mWebContentsDelegate, mContentsClientBridge, mIoThreadClient);
        mCleanupReference = new CleanupReference(
                this, new G3ContentsDestroyRunnable(mNativeG3WebCore, mWindowAndroid));
    }

    void requestExitFullscreen() {
        if (!isDestroyed()) mWebContents.exitFullscreen();
    }

    public abstract static class VisualStateCallback {
        public abstract void onComplete(long requestId);
    }

    protected void insertVisualStateCallbackIfNotDestroyed(
            long requestId, VisualStateCallback callback) {
        if (isDestroyed()) return;
        G3WebCoreJni.get().insertVisualStateCallback(
                mNativeG3WebCore, this, requestId, callback);
    }

    boolean isFullScreen() {
        return mFullScreen;
    }

    public void enterFullscreen() {
        mFullScreen = true;
    }

    public void exitFullscreen() {
        mFullScreen = false;
    }

    private boolean isDestroyed() {
        boolean destroyRunnableHasRun =
                mCleanupReference != null && mCleanupReference.hasCleanedUp();
        boolean weakRefsCleared =
                mWebContentsInternalsHolder != null && mWebContentsInternalsHolder.weakRefCleared();
        return mIsDestroyed || destroyRunnableHasRun || weakRefsCleared;
    }

    private WebContentsInternals mWebContentsInternals;
    private static class WebContentsInternalsHolder implements WebContents.InternalsHolder {
        private final WeakReference<G3WebCore> mG3WebCoreRef;

        private WebContentsInternalsHolder(G3WebCore g3WebCore) {
            mG3WebCoreRef = new WeakReference<>(g3WebCore);
        }

        @Override
        public void set(WebContentsInternals internals) {
            G3WebCore g3WebCore = mG3WebCoreRef.get();
            if (g3WebCore == null) {
                throw new IllegalStateException("G3Contents should be available at this time");
            }
            g3WebCore.mWebContentsInternals = internals;
        }

        @Override
        public WebContentsInternals get() {
            G3WebCore g3WebCore = mG3WebCoreRef.get();
            return g3WebCore == null ? null : g3WebCore.mWebContentsInternals;
        }

        public boolean weakRefCleared() {
            return mG3WebCoreRef.get() == null;
        }
    }

    private CleanupReference mCleanupReference;

    private static final class G3ContentsDestroyRunnable implements Runnable {
        private final long mNativeG3Contents;
        private final WindowAndroidWrapper mWindowAndroid;

        private G3ContentsDestroyRunnable(
                long nativeG3Contents, WindowAndroidWrapper windowAndroid) {
            mNativeG3Contents = nativeG3Contents;
            mWindowAndroid = windowAndroid;
        }

        @Override
        public void run() {
            mWindowAndroid.cleanupReference.cleanupNow();
            G3WebCoreJni.get().destroy(mNativeG3Contents);
        }
    }

    private static class WindowAndroidWrapper {
        private final WindowAndroid mWindowAndroid;
        private final CleanupReference cleanupReference;

        private static final class DestroyRunnable implements Runnable {
            private final WindowAndroid mWindowAndroid;
            private DestroyRunnable(WindowAndroid windowAndroid) {
                mWindowAndroid = windowAndroid;
            }
            @Override
            public void run() {
                mWindowAndroid.destroy();
            }
        }

        public WindowAndroidWrapper(WindowAndroid windowAndroid) {
            try (ScopedSysTraceEvent e =
                         ScopedSysTraceEvent.scoped("WindowAndroidWrapper.constructor")) {
                mWindowAndroid = windowAndroid;
                cleanupReference = new CleanupReference(this, new DestroyRunnable(windowAndroid));
            }
        }

        public WindowAndroid getWindowAndroid() {
            return mWindowAndroid;
        }
    }
    private static WindowAndroidWrapper getWindowAndroid(Context context) {
        WindowAndroidWrapper wrapper;
        boolean contextWrapsActivity = ContextUtils.activityFromContext(context) != null;
        if (contextWrapsActivity) {
            ActivityWindowAndroid activityWindow = new ActivityWindowAndroid(context, false);
            wrapper = new WindowAndroidWrapper(activityWindow);
        } else {
            wrapper = new WindowAndroidWrapper(new WindowAndroid(context));
        }
        return wrapper;
    }

    public void loadUrl(String url) {
        LoadUrlParams params = new LoadUrlParams(url, PageTransition.TYPED);
        mWebContents.getNavigationController().loadUrl(params);
        if (!mHasRequestedVisitedHistoryFromClient) {
            mHasRequestedVisitedHistoryFromClient = true;
            requestVisitedHistoryFromClient();
        }
    }

    private void requestVisitedHistoryFromClient() {
        Callback<String[]> callback = value -> {
            if (value != null) {
                for (int i = 0; i < value.length; i++) {
                    if (value[i] == null) value[i] = "";
                }
            }

            PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT, () -> {
                if (!isDestroyed()) {
                    G3WebCoreJni.get().addVisitedLinks(mNativeG3WebCore, this, value);
                }
            });
        };
        mContentsClient.getVisitedHistory(callback);
    }

    public String getUrl() {
        if (isDestroyed()) return null;
        String url = mWebContents.getVisibleUrl();
        if (url == null || url.trim().isEmpty()) return null;
        return url;
    }

    public Bitmap getFavicon() {
        if (isDestroyed()) return null;
        return mFavicon;
    }

    public NavigationHistory getNavigationHistory() {
        return isDestroyed() ? null : mNavigationController.getNavigationHistory();
    }

    public void addJavascriptInterface(Object object, String name) {
        if (isDestroyed()) return;
        Class<? extends Annotation> requiredAnnotation = JavascriptInterface.class;
        getJavascriptInjector().addPossiblyUnsafeInterface(object, name, requiredAnnotation);
    }

    public void removeJavascriptInterface(String interfaceName) {
        if (isDestroyed()) return;
        getJavascriptInjector().removeInterface(interfaceName);
    }

    public void evaluateJavaScript(String script, final Callback<String> callback) {
        if (isDestroyed()) return;
        JavaScriptCallback jsCallback = null;
        if (callback != null) {
            jsCallback = jsonResult -> {
                PostTask.postTask(UiThreadTaskTraits.DEFAULT, () -> callback.onResult(jsonResult));
            };
        }

        mWebContents.evaluateJavaScript(script, jsCallback);
    }

    public void stopLoading() {
        if (!isDestroyed()) mWebContents.stop();
    }

    public void reload() {
        if (!isDestroyed()) mNavigationController.reload(true);
    }

    public boolean canGoBack() {
        return !isDestroyed() && mNavigationController.canGoBack();
    }

    public void goBack() {
        if (!isDestroyed()) mNavigationController.goBack();
    }

    public boolean canGoForward() {
        return !isDestroyed() && mNavigationController.canGoForward();
    }

    public void goForward() {
        if (!isDestroyed()) mNavigationController.goForward();
    }

    public boolean canGoBackOrForward(int steps) {
        return !isDestroyed() && mNavigationController.canGoToOffset(steps);
    }

    public void goBackOrForward(int steps) {
        if (!isDestroyed()) mNavigationController.goToOffset(steps);
    }

    public String getOriginalUrl() {
        if (isDestroyed()) return null;
        NavigationHistory history = mNavigationController.getNavigationHistory();
        int currentIndex = history.getCurrentEntryIndex();
        if (currentIndex >= 0 && currentIndex < history.getEntryCount()) {
            return history.getEntryAtIndex(currentIndex).getOriginalUrl();
        }
        return null;
    }

    public void pauseTimers() {
        if (!isDestroyed()) {
            ContentViewStatics.setWebKitSharedTimersSuspended(true);
        }
    }

    public void resumeTimers() {
        if (!isDestroyed()) {
            ContentViewStatics.setWebKitSharedTimersSuspended(false);
        }
    }

    public void onPause() {
        if (mIsPaused || isDestroyed()) return;
        mIsPaused = true;
        mWebContents.onHide();
    }

    public void onResume() {
        if (!mIsPaused || isDestroyed()) return;
        mIsPaused = false;
        mWebContents.onShow();
    }

    public boolean isPaused() {
        return !isDestroyed() && mIsPaused;
    }

    public void clearCache(boolean includeDiskFiles) {
        if (!isDestroyed()) {
            G3WebCoreJni.get().clearCache(mNativeG3WebCore, this, includeDiskFiles);
        }
    }

    public void clearHistory() {
        if (!isDestroyed()) mNavigationController.clearHistory();
    }

    public void clearSslPreferences() {
        if (!isDestroyed()) mNavigationController.clearSslPreferences();
    }

    static void completeWindowCreation(WebView parent, WebView child) {
        G3WebCore parentG3WebCore = ((WebViewChromium) parent.getWebViewProvider()).mG3WebCore;
        G3WebCore childG3WebCore =
                child == null ? null : ((WebViewChromium) child.getWebViewProvider()).mG3WebCore;
        parentG3WebCore.supplyContentsForPopup(childG3WebCore);
    }

    public void supplyContentsForPopup(G3WebCore newContents) {
        if (isDestroyed()) return;
        long popupNativeG3Contents =
                G3WebCoreJni.get().releasePopupG3Contents(mNativeG3WebCore, this);
        if (popupNativeG3Contents == 0) {
            //Log.w(TAG, "Popup WebView bind failed: no pending content.");
            if (newContents != null) newContents.destroy();
            return;
        }
        if (newContents == null) {
            G3WebCoreJni.get().destroy(popupNativeG3Contents);
            return;
        }

        newContents.receivePopupContents(popupNativeG3Contents);
    }

    private void receivePopupContents(long popupNativeG3Contents) {
        if (isDestroyed()) return;
        final boolean wasPaused = mIsPaused;
        if (!wasPaused) onPause();
        Map<String, Pair<Object, Class>> javascriptInterfaces =
                new HashMap<String, Pair<Object, Class>>();
        if (mWebContents != null) {
            javascriptInterfaces.putAll(getJavascriptInjector().getInterfaces());
        }
        setNewG3Contents(popupNativeG3Contents);
        G3WebCoreJni.get().resumeLoadingCreatedPopupWebContents(mNativeG3WebCore, this);
        if (!wasPaused) onResume();
        for (Map.Entry<String, Pair<Object, Class>> entry : javascriptInterfaces.entrySet()) {
            @SuppressWarnings("unchecked")
            Class<? extends Annotation> requiredAnnotation = entry.getValue().second;
            getJavascriptInjector().addPossiblyUnsafeInterface(
                    entry.getValue().first, entry.getKey(), requiredAnnotation);
        }
    }

    private JavascriptInjector getJavascriptInjector() {
        if (mJavascriptInjector == null) {
            mJavascriptInjector = JavascriptInjector.fromWebContents(mWebContents);
        }
        return mJavascriptInjector;
    }

    public G3GeolocationPermissions getGeolocationPermissions() {
        return mBrowserContext.getGeolocationPermissions();
    }

    @CalledByNative
    private void onReceivedIcon(Bitmap bitmap) {
        mContentsClient.onReceivedIcon(bitmap);
        mFavicon = bitmap;
    }

    @CalledByNative
    private void onReceivedTouchIconUrl(String url, boolean precomposed) {
        mContentsClient.onReceivedTouchIconUrl(url, precomposed);
    }

    @CalledByNative
    public void invokeVisualStateCallback(
            final VisualStateCallback callback, final long requestId) {
        if (isDestroyed()) return;
        // Posting avoids invoking the callback inside invoking_composite_
        // (see synchronous_compositor_impl.cc and crbug/452530).
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, () -> callback.onComplete(requestId));
    }

    @CalledByNative
    private void onGeolocationPermissionsShowPrompt(String origin) {
        if (isDestroyed()) return;
        G3GeolocationPermissions permissions = mBrowserContext.getGeolocationPermissions();
        // Reject if geoloaction is disabled, or the origin has a retained deny
        if (!mSettings.getGeolocationEnabled()) {
            G3WebCoreJni.get().invokeGeolocationCallback(
                    mNativeG3WebCore, this, false, origin);
            return;
        }
        // Allow if the origin has a retained allow
        if (permissions.hasOrigin(origin)) {
            G3WebCoreJni.get().invokeGeolocationCallback(mNativeG3WebCore, this,
                    permissions.isOriginAllowed(origin), origin);
            return;
        }
        mContentsClient.onGeolocationPermissionsShowPrompt(
                origin, new G3GeolocationCallback(origin, this));
    }

    @CalledByNative
    private void onGeolocationPermissionsHidePrompt() {
        mContentsClient.onGeolocationPermissionsHidePrompt();
    }

    @CalledByNative
    private void onPermissionRequest(G3PermissionRequest awPermissionRequest) {
        mContentsClient.onPermissionRequest(awPermissionRequest);
    }

    @CalledByNative
    private void onPermissionRequestCanceled(G3PermissionRequest awPermissionRequest) {
        mContentsClient.onPermissionRequestCanceled(awPermissionRequest);
    }

    @CalledByNative
    private boolean useLegacyGeolocationPermissionAPI() {
        // Always return true since we are not ready to swap the geolocation yet.
        // TODO: If we decide not to migrate the geolocation, there are some unreachable
        // code need to remove. http://crbug.com/396184.
        return true;
    }

    public void invokeGeolocationCallback(boolean value, String requestingFrame) {
        if (isDestroyed()) return;
        G3WebCoreJni.get().invokeGeolocationCallback(
                mNativeG3WebCore, this, value, requestingFrame);
    }

    public void destroy() {
        if (isDestroyed()) return;
        mContentsClient.getCallbackHelper().removeCallbacksAndMessages();
//        if (mIsAttachedToWindow) {
//            Log.w(TAG, "WebView.destroy() called while WebView is still attached to window.");
//            // Need to call detach to avoid leaks because the real detach later will be ignored.
//            onDetachedFromWindow();
//        }

        mIsDestroyed = true;
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, () -> destroyNatives());
    }

    private void destroyNatives() {
        if (mCleanupReference != null) {
            assert mNativeG3WebCore != 0;
            if (mContentViewRenderView != null) {
                mContainerView.removeView(mContentViewRenderView);
                mContentViewRenderView.destroy();
            }
            if (mG3ContentView != null) {
                mContainerView.removeView(mG3ContentView);
            }
            mWebContentsObserver.destroy();
            mWebContentsObserver = null;
            mNativeG3WebCore = 0;
            mWebContents = null;
            mWebContentsInternals = null;
            mNavigationController = null;

            mCleanupReference.cleanupNow();
            mCleanupReference = null;
        }

        assert mWebContents == null;
        assert mNavigationController == null;
        assert mNativeG3WebCore == 0;

    }

    @NativeMethods
    interface Natives {
        long initNative(G3WebCore caller);
        void destroy(long nativeG3WebCore);
        WebContents getWebContents(long nativeG3WebCore, G3WebCore caller);
        G3BrowserContext getBrowserContext(long nativeG3WebCore, G3WebCore caller);
        void setJavaPeers(long nativeG3WebCore, G3WebCore caller, G3WebCore g3WebCore,
                          G3WebContentsDelegate webViewWebContentsDelegate,
                          G3ContentsClientBridge contentsClientBridge,
                          G3ContentsIoThreadClient ioThreadClient);
        void insertVisualStateCallback(long nativeG3WebCore, G3WebCore caller, long requestId,
                                       VisualStateCallback callback);
        void invokeGeolocationCallback(
                long nativeG3WebCore, G3WebCore caller, boolean value, String requestingFrame);
        void addVisitedLinks(long nativeG3WebCore, G3WebCore caller, String[] visitedLinks);
        void clearCache(long nativeG3WebCore, G3WebCore caller, boolean includeDiskFiles);
        long releasePopupG3Contents(long nativeG3WebCore, G3WebCore caller);
        void resumeLoadingCreatedPopupWebContents(long nativeG3WebCore, G3WebCore caller);
    }

}
