package org.chromium.webview.g3webcore;

import android.webkit.ValueCallback;

import org.chromium.base.Callback;

/**
 * Utility class for converting a {@link android.webkit.ValueCallback} into a
 * {@link org.chromium.base.Callback}.
 */
public final class CallbackConverter {
    public static <T> Callback<T> fromValueCallback(final ValueCallback<T> valueCallback) {
        return valueCallback == null ? null : result -> valueCallback.onReceiveValue(result);
    }

    private CallbackConverter() {}
}
