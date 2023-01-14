// NetworkChangeManager.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_change_manager.mojom
//

package org.chromium.network.mojom;


public interface NetworkChangeManager extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends NetworkChangeManager, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<NetworkChangeManager, NetworkChangeManager.Proxy> MANAGER = NetworkChangeManager_Internal.MANAGER;


    void requestNotifications(
NetworkChangeManagerClient clientRemote);



    void onNetworkChanged(
boolean dnsChanged, boolean ipAddressChanged, boolean connectionTypeChanged, int newConnectionType, boolean connectionSubtypeChanged, int newConnectionSubtype);


}
