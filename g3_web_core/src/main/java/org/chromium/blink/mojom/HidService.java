// HidService.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/hid/hid.mojom
//

package org.chromium.blink.mojom;


public interface HidService extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends HidService, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<HidService, HidService.Proxy> MANAGER = HidService_Internal.MANAGER;


    void getDevices(

GetDevicesResponse callback);

    interface GetDevicesResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<org.chromium.device.mojom.HidDeviceInfo[]> { }



    void requestDevice(
HidDeviceFilter[] filters, 
RequestDeviceResponse callback);

    interface RequestDeviceResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<org.chromium.device.mojom.HidDeviceInfo[]> { }



    void connect(
String deviceGuid, org.chromium.device.mojom.HidConnectionClient client, 
ConnectResponse callback);

    interface ConnectResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<org.chromium.device.mojom.HidConnection> { }


}
