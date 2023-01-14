package org.chromium.webview.g3webcore;


import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.FrameLayout;

import org.chromium.base.Callback;
import org.chromium.base.ContentUriUtils;
import org.chromium.base.ThreadUtils;
import org.chromium.base.task.AsyncTask;
import org.chromium.content_public.common.ResourceRequestBody;

/**
 * Adapts the G3WebContentsDelegate interface to the G3ContentsClient interface.
 * This class also serves a secondary function of routing certain callbacks from the content layer
 * to specific listener interfaces.
 */
class G3WebContentsDelegateAdapter extends G3WebContentsDelegate {
    private static final String TAG = "G3WebContentsDelegateAdapter";

    private final G3WebCore mG3WebCore;
    private final G3ContentsClient mContentsClient;
    private final G3Settings mG3Settings;
    private final Context mContext;
    private View mContainerView;

    public G3WebContentsDelegateAdapter(G3WebCore g3WebCore, G3ContentsClient contentsClient,
                                        G3Settings settings, Context context, View containerView) {
        mG3WebCore = g3WebCore;
        mContentsClient = contentsClient;
        mG3Settings = settings;
        mContext = context;
        setContainerView(containerView);
    }

    public void setContainerView(View containerView) {
        mContainerView = containerView;
        mContainerView.setClickable(true);
    }

    @Override
    public void handleKeyboardEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            int direction;
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_DPAD_DOWN:
                    direction = View.FOCUS_DOWN;
                    break;
                case KeyEvent.KEYCODE_DPAD_UP:
                    direction = View.FOCUS_UP;
                    break;
                case KeyEvent.KEYCODE_DPAD_LEFT:
                    direction = View.FOCUS_LEFT;
                    break;
                case KeyEvent.KEYCODE_DPAD_RIGHT:
                    direction = View.FOCUS_RIGHT;
                    break;
                default:
                    direction = 0;
                    break;
            }
            if (direction != 0 && tryToMoveFocus(direction)) return;
        }
        handleMediaKey(event);
        mContentsClient.onUnhandledKeyEvent(event);
    }

    /**
     * Redispatches unhandled media keys. This allows bluetooth headphones with play/pause or
     * other buttons to function correctly.
     */
    private void handleMediaKey(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.KEYCODE_MUTE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
            case KeyEvent.KEYCODE_MEDIA_PLAY:
            case KeyEvent.KEYCODE_MEDIA_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_STOP:
            case KeyEvent.KEYCODE_MEDIA_NEXT:
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
            case KeyEvent.KEYCODE_MEDIA_REWIND:
            case KeyEvent.KEYCODE_MEDIA_RECORD:
            case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:
            case KeyEvent.KEYCODE_MEDIA_CLOSE:
            case KeyEvent.KEYCODE_MEDIA_EJECT:
            case KeyEvent.KEYCODE_MEDIA_AUDIO_TRACK:
                AudioManager am = (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);
                am.dispatchMediaKeyEvent(e);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean takeFocus(boolean reverse) {
        int direction =
                (reverse == (mContainerView.getLayoutDirection() == View.LAYOUT_DIRECTION_RTL))
                        ? View.FOCUS_RIGHT : View.FOCUS_LEFT;
        if (tryToMoveFocus(direction)) return true;
        direction = reverse ? View.FOCUS_BACKWARD : View.FOCUS_FORWARD;
        return tryToMoveFocus(direction);
    }

    private boolean tryToMoveFocus(int direction) {
        View focus = mContainerView.focusSearch(direction);
        return focus != null && focus != mContainerView && focus.requestFocus();
    }

    @Override
    public boolean addMessageToConsole(int level, String message, int lineNumber,
                                       String sourceId) {
        @G3ConsoleMessage.MessageLevel
        int messageLevel = G3ConsoleMessage.MESSAGE_LEVEL_DEBUG;
        switch(level) {
            case LOG_LEVEL_TIP:
                messageLevel = G3ConsoleMessage.MESSAGE_LEVEL_TIP;
                break;
            case LOG_LEVEL_LOG:
                messageLevel = G3ConsoleMessage.MESSAGE_LEVEL_LOG;
                break;
            case LOG_LEVEL_WARNING:
                messageLevel = G3ConsoleMessage.MESSAGE_LEVEL_WARNING;
                break;
            case LOG_LEVEL_ERROR:
                messageLevel = G3ConsoleMessage.MESSAGE_LEVEL_ERROR;
                break;
            default:
                Log.w(TAG, "Unknown message level, defaulting to DEBUG");
                break;
        }
        boolean result = mContentsClient.onConsoleMessage(
                new G3ConsoleMessage(message, sourceId, lineNumber, messageLevel));
        return result;
    }

    @Override
    public void onUpdateUrl(String url) {
        // TODO: implement
    }

    @Override
    public void openNewTab(String url, String extraHeaders, ResourceRequestBody postData,
                           int disposition, boolean isRendererInitiated) {
        // This is only called in chrome layers.
        assert false;
    }

    @Override
    public void closeContents() {
        mContentsClient.onCloseWindow();
    }

    @Override
    @SuppressLint("HandlerLeak")
    public void showRepostFormWarningDialog() {
        // TODO(mkosiba) We should be using something akin to the JsResultReceiver as the
        // callback parameter (instead of WebContents) and implement a way of converting
        // that to a pair of messages.
        final int msgContinuePendingReload = 1;
        final int msgCancelPendingReload = 2;

        // TODO(sgurun) Remember the URL to cancel the reload behavior
        // if it is different than the most recent NavigationController entry.
        final Handler handler = new Handler(ThreadUtils.getUiThreadLooper()) {
            @Override
            public void handleMessage(Message msg) {
                if (mG3WebCore.getNavigationController() == null) return;

                switch(msg.what) {
                    case msgContinuePendingReload: {
                        mG3WebCore.getNavigationController().continuePendingReload();
                        break;
                    }
                    case msgCancelPendingReload: {
                        mG3WebCore.getNavigationController().cancelPendingReload();
                        break;
                    }
                    default:
                        throw new IllegalStateException(
                                "WebContentsDelegateAdapter: unhandled message " + msg.what);
                }
            }
        };

        Message resend = handler.obtainMessage(msgContinuePendingReload);
        Message dontResend = handler.obtainMessage(msgCancelPendingReload);
        mContentsClient.getCallbackHelper().postOnFormResubmission(dontResend, resend);
    }

    @Override
    public void runFileChooser(final int processId, final int renderId, final int modeFlags,
                               String acceptTypes, String title, String defaultFilename, boolean capture) {
        G3ContentsClient.FileChooserParamsImpl params = new G3ContentsClient.FileChooserParamsImpl(
                modeFlags, acceptTypes, title, defaultFilename, capture);

        mContentsClient.showFileChooser(new Callback<String[]>() {
            boolean mCompleted;
            @Override
            public void onResult(String[] results) {
                if (mCompleted) {
                    throw new IllegalStateException("Duplicate showFileChooser result");
                }
                mCompleted = true;
                if (results == null) {
                    G3WebContentsDelegateJni.get().filesSelectedInChooser(
                            processId, renderId, modeFlags, null, null);
                    return;
                }
                GetDisplayNameTask task =
                        new GetDisplayNameTask(mContext, processId, renderId, modeFlags, results);
                task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            }
        }, params);
    }

    @Override
    public boolean addNewContents(boolean isDialog, boolean isUserGesture) {
        return mContentsClient.onCreateWindow(isDialog, isUserGesture);
    }

    @Override
    public void activateContents() {
        mContentsClient.onRequestFocus();
    }

    @Override
    public void navigationStateChanged(int flags) {
    }

    @Override
    public void enterFullscreenModeForTab(boolean prefersNavigationBar) {
        enterFullscreen();
    }

    @Override
    public void exitFullscreenModeForTab() {
        exitFullscreen();
    }

    @Override
    public void loadingStateChanged() {
//        mContentsClient.updateTitle(mG3WebCore.getTitle(), false);
    }

    /**
     * Called to show the web contents in fullscreen mode.
     *
     * <p>If entering fullscreen on a video element the web contents will contain just
     * the html5 video controls. {@link #enterFullscreenVideo(View)} will be called later
     * once the ContentVideoView, which contains the hardware accelerated fullscreen video,
     * is ready to be shown.
     */
    private void enterFullscreen() {
        mG3WebCore.enterFullscreen();
        mContentsClient.enterFullscreen();
    }

    /**
     * Called to show the web contents in embedded mode.
     */
    private void exitFullscreen() {
        mG3WebCore.exitFullscreen();
        mContentsClient.exitFullscreen();
    }

    @Override
    public boolean shouldBlockMediaRequest(String url) {
        return mG3Settings != null
                ? mG3Settings.getBlockNetworkLoads() && URLUtil.isNetworkUrl(url) : true;
    }

    private static class GetDisplayNameTask extends AsyncTask<String[]> {
        final int mProcessId;
        final int mRenderId;
        final int mModeFlags;
        final String[] mFilePaths;

        // The task doesn't run long, so we don't gain anything from a weak ref.
        @SuppressLint("StaticFieldLeak")
        final Context mContext;

        public GetDisplayNameTask(
                Context context, int processId, int renderId, int modeFlags, String[] filePaths) {
            mProcessId = processId;
            mRenderId = renderId;
            mModeFlags = modeFlags;
            mFilePaths = filePaths;
            mContext = context;
        }

        @Override
        protected String[] doInBackground() {
            String[] displayNames = new String[mFilePaths.length];
            for (int i = 0; i < mFilePaths.length; i++) {
                displayNames[i] = resolveFileName(mFilePaths[i]);
            }
            return displayNames;
        }

        @Override
        protected void onPostExecute(String[] result) {
            G3WebContentsDelegateJni.get().filesSelectedInChooser(
                    mProcessId, mRenderId, mModeFlags, mFilePaths, result);
        }

        /**
         * @return the display name of a path if it is a content URI and is present in the database
         * or an empty string otherwise.
         */
        private String resolveFileName(String filePath) {
            if (filePath == null) return "";
            Uri uri = Uri.parse(filePath);
            return ContentUriUtils.getDisplayName(
                    uri, mContext, MediaStore.MediaColumns.DISPLAY_NAME);
        }
    }
}

