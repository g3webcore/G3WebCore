// AudioLog.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     media/mojo/mojom/audio_logging.mojom
//

package org.chromium.media.mojom;


public interface AudioLog extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends AudioLog, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<AudioLog, AudioLog.Proxy> MANAGER = AudioLog_Internal.MANAGER;


    void onCreated(
AudioParameters params, String deviceId);



    void onStarted(
);



    void onStopped(
);



    void onClosed(
);



    void onError(
);



    void onSetVolume(
double volume);



    void onProcessingStateChanged(
String message);



    void onLogMessage(
String message);


}
