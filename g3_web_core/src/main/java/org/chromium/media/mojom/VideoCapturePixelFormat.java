// VideoCapturePixelFormat.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/capture/mojom/video_capture_types.mojom
//

package org.chromium.media.mojom;

public final class VideoCapturePixelFormat {
    private static final boolean IS_EXTENSIBLE = false;

    public static final int UNKNOWN = 0;
    public static final int I420 = 1; // UNKNOWN + 1
    public static final int YV12 = 2; // I420 + 1
    public static final int I422 = 3; // YV12 + 1
    public static final int I420A = 4; // I422 + 1
    public static final int I444 = 5; // I420A + 1
    public static final int NV12 = 6; // I444 + 1
    public static final int NV21 = 7; // NV12 + 1
    public static final int YUY2 = 8; // NV21 + 1
    public static final int ARGB = 9; // YUY2 + 1
    public static final int XRGB = 10; // ARGB + 1
    public static final int RGB24 = 11; // XRGB + 1
    public static final int MJPEG = 12; // RGB24 + 1
    public static final int YUV420P9 = 13; // MJPEG + 1
    public static final int YUV420P10 = 14; // YUV420P9 + 1
    public static final int YUV422P9 = 15; // YUV420P10 + 1
    public static final int YUV422P10 = 16; // YUV422P9 + 1
    public static final int YUV444P9 = 17; // YUV422P10 + 1
    public static final int YUV444P10 = 18; // YUV444P9 + 1
    public static final int YUV420P12 = 19; // YUV444P10 + 1
    public static final int YUV422P12 = 20; // YUV420P12 + 1
    public static final int YUV444P12 = 21; // YUV422P12 + 1
    public static final int Y16 = 22; // YUV444P12 + 1
    public static final int ABGR = 23; // Y16 + 1
    public static final int XBGR = 24; // ABGR + 1
    public static final int P016LE = 25; // XBGR + 1
    public static final int XR30 = 26; // P016LE + 1
    public static final int XB30 = 27; // XR30 + 1
    public static final int BGRA = 28; // XB30 + 1

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 28;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    private VideoCapturePixelFormat() {}
}