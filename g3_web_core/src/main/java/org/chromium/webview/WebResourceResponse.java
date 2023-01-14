package org.chromium.webview;

import androidx.annotation.NonNull;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.Map;

public class WebResourceResponse {
    private String mMimeType;
    private String mEncoding;
    private int mStatusCode;
    private String mReasonPhrase;
    private Map<String, String> mResponseHeaders;
    private InputStream mInputStream;

    public WebResourceResponse(String mimeType, String encoding,
                               InputStream data) {
        mMimeType = mimeType;
        mEncoding = encoding;
        setData(data);
    }

    public WebResourceResponse(String mimeType, String encoding, int statusCode,
                               @NonNull String reasonPhrase, Map<String, String> responseHeaders, InputStream data) {
        this(mimeType, encoding, data);
        setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        setResponseHeaders(responseHeaders);
    }

    public void setMimeType(String mimeType) {
        mMimeType = mimeType;
    }

    public String getMimeType() {
        return mMimeType;
    }

    public void setEncoding(String encoding) {
        mEncoding = encoding;
    }

    public String getEncoding() {
        return mEncoding;
    }

    public void setStatusCodeAndReasonPhrase(int statusCode, @NonNull String reasonPhrase) {
        if (statusCode < 100)
            throw new IllegalArgumentException("statusCode can't be less than 100.");
        if (statusCode > 599)
            throw new IllegalArgumentException("statusCode can't be greater than 599.");
        if (statusCode > 299 && statusCode < 400)
            throw new IllegalArgumentException("statusCode can't be in the [300, 399] range.");
        if (reasonPhrase == null)
            throw new IllegalArgumentException("reasonPhrase can't be null.");
        if (reasonPhrase.trim().isEmpty())
            throw new IllegalArgumentException("reasonPhrase can't be empty.");
        for (int i = 0; i < reasonPhrase.length(); i++) {
            int c = reasonPhrase.charAt(i);
            if (c > 0x7F) {
                throw new IllegalArgumentException(
                        "reasonPhrase can't contain non-ASCII characters.");
            }
        }
        mStatusCode = statusCode;
        mReasonPhrase = reasonPhrase;
    }

    public int getStatusCode() {
        return mStatusCode;
    }

    public String getReasonPhrase() {
        return mReasonPhrase;
    }

    public void setResponseHeaders(Map<String, String> headers) {
        mResponseHeaders = headers;
    }

    public Map<String, String> getResponseHeaders() {
        return mResponseHeaders;
    }

    public void setData(InputStream data) {
        if (data != null && StringBufferInputStream.class.isAssignableFrom(data.getClass())) {
            throw new IllegalArgumentException("StringBufferInputStream is deprecated and must " +
                    "not be passed to a WebResourceResponse");
        }
        mInputStream = data;
    }

    public InputStream getData() {
        return mInputStream;
    }

}
