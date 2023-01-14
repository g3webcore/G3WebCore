package org.chromium.webview;

public interface SslErrorHandler {
    void proceed();

    void cancel();
}
