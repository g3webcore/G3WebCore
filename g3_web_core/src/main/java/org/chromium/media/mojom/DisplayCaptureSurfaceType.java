// DisplayCaptureSurfaceType.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/display_media_information.mojom
//

package org.chromium.media.mojom;

public final class DisplayCaptureSurfaceType {
    private static final boolean IS_EXTENSIBLE = false;

    public static final int MONITOR = 0;
    public static final int WINDOW = 1; // MONITOR + 1
    public static final int APPLICATION = 2; // WINDOW + 1
    public static final int BROWSER = 3; // APPLICATION + 1

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 3;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    private DisplayCaptureSurfaceType() {}
}