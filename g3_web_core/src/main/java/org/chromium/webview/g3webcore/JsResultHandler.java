package org.chromium.webview.g3webcore;


import org.chromium.base.task.PostTask;
import org.chromium.content_public.browser.UiThreadTaskTraits;
import org.chromium.webview.JsResultReceiver;

class JsResultHandler implements JsResultReceiver, JsPromptResultReceiver {
    private G3ContentsClientBridge mBridge;
    private final int mId;

    JsResultHandler(G3ContentsClientBridge bridge, int id) {
        mBridge = bridge;
        mId = id;
    }

    @Override
    public void confirm() {
        confirm(null);
    }

    @Override
    public void confirm(final String promptResult) {
        PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT, () -> {
            if (mBridge != null) mBridge.confirmJsResult(mId, promptResult);
            mBridge = null;
        });
    }

    @Override
    public void cancel() {
        PostTask.runOrPostTask(UiThreadTaskTraits.DEFAULT, () -> {
            if (mBridge != null) mBridge.cancelJsResult(mId);
            mBridge = null;
        });
    }
}
