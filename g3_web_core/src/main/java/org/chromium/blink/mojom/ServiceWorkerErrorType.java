// ServiceWorkerErrorType.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/service_worker_error_type.mojom
//

package org.chromium.blink.mojom;

public final class ServiceWorkerErrorType {
    private static final boolean IS_EXTENSIBLE = false;

    public static final int NONE = 0;
    public static final int ABORT = 1; // NONE + 1
    public static final int ACTIVATE = 2; // ABORT + 1
    public static final int DISABLED = 3; // ACTIVATE + 1
    public static final int INSTALL = 4; // DISABLED + 1
    public static final int NAVIGATION = 5; // INSTALL + 1
    public static final int NETWORK = 6; // NAVIGATION + 1
    public static final int NOT_FOUND = 7; // NETWORK + 1
    public static final int SCRIPT_EVALUATE_FAILED = 8; // NOT_FOUND + 1
    public static final int SECURITY = 9; // SCRIPT_EVALUATE_FAILED + 1
    public static final int STATE = 10; // SECURITY + 1
    public static final int TIMEOUT = 11; // STATE + 1
    public static final int TYPE = 12; // TIMEOUT + 1
    public static final int UNKNOWN = 13; // TYPE + 1

    public static boolean isKnownValue(int value) {
        return value >= 0 && value <= 13;
    }

    public static void validate(int value) {
        if (IS_EXTENSIBLE || isKnownValue(value)) return;
        throw new org.chromium.mojo.bindings.DeserializationException("Invalid enum value.");
    }

    private ServiceWorkerErrorType() {}
}