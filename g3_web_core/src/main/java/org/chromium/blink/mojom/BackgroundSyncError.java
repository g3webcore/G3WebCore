// BackgroundSyncError.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/background_sync/background_sync.mojom
//

package org.chromium.blink.mojom;

public final class BackgroundSyncError {
    private static final boolean IS_EXTENSIBLE = false;

    public static final int NONE = 0;
    public static final int STORAGE = 1; // NONE + 1
    public static final int NOT_FOUND = 2; // STORAGE + 1
    public static final int NO_SERVICE_WORKER = 3; // NOT_FOUND + 1
    public static final int NOT_ALLOWED = 4; // NO_SERVICE_WORKER + 1
    public static final int PERMISSION_DENIED = 5; // NOT_ALLOWED + 1
    public static final int MAX = BackgroundSyncError.PERMISSION_DENIED;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 5;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    private BackgroundSyncError() {}
}