package org.chromium.webview;

import android.os.Build;

import androidx.annotation.RequiresApi;

import org.chromium.webview.g3webcore.G3ContentsClient;

@RequiresApi(api = Build.VERSION_CODES.M)
public class WebResourceErrorAdapter extends WebResourceError {
    private final G3ContentsClient.G3WebResourceError mError;

    public WebResourceErrorAdapter(G3ContentsClient.G3WebResourceError error) {
        mError = error;
    }

    /* package */ G3ContentsClient.G3WebResourceError getG3WebResourceError() {
        return mError;
    }

    @Override
    public int getErrorCode() {
        return mError.errorCode;
    }

    @Override
    public CharSequence getDescription() {
        return mError.description;
    }
}
