package org.chromium.webview.g3webcore;

import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

@JNINamespace("g3webcore")
public abstract class G3ContentsBackgroundThreadClient {
    private static final String TAG = "G3BgThreadClient";

    public abstract G3WebResourceResponse shouldInterceptRequest(
            G3ContentsClient.G3WebResourceRequest request);

    // Protected methods ---------------------------------------------------------------------------

    @CalledByNative
    private G3WebResourceInterceptResponse shouldInterceptRequestFromNative(String url,
                                                                            boolean isMainFrame, boolean hasUserGesture, String method, String[] requestHeaderNames,
                                                                            String[] requestHeaderValues) {
        try {
            return new G3WebResourceInterceptResponse(
                    shouldInterceptRequest(new G3ContentsClient.G3WebResourceRequest(url,
                            isMainFrame, hasUserGesture, method, requestHeaderNames,
                            requestHeaderValues)),
                    /*raisedException=*/false);
        } catch (Exception e) {
            Log.e(TAG,
                    "Client raised exception in shouldInterceptRequest. Re-throwing on UI thread.");

            ThreadUtils.getUiThreadHandler().post(new Runnable() {
                @Override
                public void run() {
                    Log.e(TAG, "The following exception was raised by shouldInterceptRequest:");
                    throw e;
                }
            });

            return new G3WebResourceInterceptResponse(null, /*raisedException=*/true);
        }
    }
}
