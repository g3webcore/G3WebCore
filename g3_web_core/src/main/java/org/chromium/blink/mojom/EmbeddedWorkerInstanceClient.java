// EmbeddedWorkerInstanceClient.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/service_worker/embedded_worker.mojom
//

package org.chromium.blink.mojom;


public interface EmbeddedWorkerInstanceClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends EmbeddedWorkerInstanceClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<EmbeddedWorkerInstanceClient, EmbeddedWorkerInstanceClient.Proxy> MANAGER = EmbeddedWorkerInstanceClient_Internal.MANAGER;


    void startWorker(
EmbeddedWorkerStartParams params);



    void stopWorker(
);



    void resumeAfterDownload(
);


}
