// PushUserVisibleStatus.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/push_messaging/push_messaging_status.mojom
//

package org.chromium.blink.mojom;

public final class PushUserVisibleStatus {
    private static final boolean IS_EXTENSIBLE = false;

    public static final int REQUIRED_AND_SHOWN = 0;
    public static final int NOT_REQUIRED_BUT_SHOWN = 1;
    public static final int NOT_REQUIRED_AND_NOT_SHOWN = 2;
    public static final int REQUIRED_BUT_NOT_SHOWN_USED_GRACE = 3;
    public static final int REQUIRED_BUT_NOT_SHOWN_GRACE_EXCEEDED = 4;

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 4;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    private PushUserVisibleStatus() {}
}