package org.chromium.webview;

public abstract class WebResourceError {

    public abstract int getErrorCode();

    public abstract CharSequence getDescription();

    public WebResourceError() {}
}