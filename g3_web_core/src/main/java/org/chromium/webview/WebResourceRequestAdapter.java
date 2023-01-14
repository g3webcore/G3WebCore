package org.chromium.webview;


import android.net.Uri;
import android.os.Build;


import androidx.annotation.RequiresApi;

import org.chromium.webview.g3webcore.G3ContentsClient;

import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class WebResourceRequestAdapter implements WebResourceRequest {
    private final G3ContentsClient.G3WebResourceRequest mRequest;

    public WebResourceRequestAdapter(G3ContentsClient.G3WebResourceRequest request) {
        mRequest = request;
    }

    /* package */ G3ContentsClient.G3WebResourceRequest getG3ResourceRequest() {
        return mRequest;
    }

    @Override
    public Uri getUrl() {
        return Uri.parse(mRequest.url);
    }

    @Override
    public boolean isForMainFrame() {
        return mRequest.isMainFrame;
    }

    @Override
    public boolean hasGesture() {
        return mRequest.hasUserGesture;
    }

    @Override
    public String getMethod() {
        return mRequest.method;
    }

    @Override
    public Map<String, String> getRequestHeaders() {
        return mRequest.requestHeaders;
    }

    @Override
    public boolean isRedirect() {
        return mRequest.isRedirect;
    }
}
