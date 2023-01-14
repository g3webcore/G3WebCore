package org.chromium.webview.g3webcore;


import org.chromium.webview.JsResult;

public class JsPromptResult extends JsResult {
    private String mStringResult;

    public void confirm(String result) {
        mStringResult = result;
        confirm();
    }

    public JsPromptResult(ResultReceiver receiver) {
        super(receiver);
    }

    public String getStringResult() {
        return mStringResult;
    }
}
