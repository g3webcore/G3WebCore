// Copyright 2012 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.webview.g3webcore;

/**
 * This interface is used when the G3ContentsClient offers a JavaScript
 * modal prompt dialog  to enable the client to handle the dialog in their own way.
 * G3ContentsClient will offer an object that implements this interface to the
 * client and when the client has handled the dialog, it must either callback with
 * confirm() or cancel() to allow processing to continue.
 */
public interface JsPromptResultReceiver {
    public void confirm(String result);
    public void cancel();
}
