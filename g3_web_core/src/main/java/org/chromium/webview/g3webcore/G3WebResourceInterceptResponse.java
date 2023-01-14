// Copyright 2019 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.webview.g3webcore;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;

/**
 * The response information that is to be returned for a particular resource fetch.
 */
@JNINamespace("g3webcore")
public class G3WebResourceInterceptResponse {
    private G3WebResourceResponse mResponse;
    private boolean mRaisedException;

    public G3WebResourceInterceptResponse(G3WebResourceResponse response, boolean raisedException) {
        mResponse = response;
        mRaisedException = raisedException;
    }

    @CalledByNative
    public G3WebResourceResponse getResponse() {
        return mResponse;
    }

    @CalledByNative
    public boolean getRaisedException() {
        return mRaisedException;
    }
}
