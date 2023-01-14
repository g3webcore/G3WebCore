// MediaSessionService.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/media_session/public/mojom/media_session_service.mojom
//

package org.chromium.media_session.mojom;


public interface MediaSessionService extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends MediaSessionService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<MediaSessionService, MediaSessionService.Proxy> MANAGER = MediaSessionService_Internal.MANAGER;


    void bindAudioFocusManager(
org.chromium.mojo.bindings.InterfaceRequest<AudioFocusManager> receiver);



    void bindAudioFocusManagerDebug(
org.chromium.mojo.bindings.InterfaceRequest<AudioFocusManagerDebug> receiver);



    void bindMediaControllerManager(
org.chromium.mojo.bindings.InterfaceRequest<MediaControllerManager> receiver);


}
