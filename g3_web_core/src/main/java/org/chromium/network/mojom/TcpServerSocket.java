// TcpServerSocket.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/tcp_socket.mojom
//

package org.chromium.network.mojom;


public interface TcpServerSocket extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends TcpServerSocket, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<TcpServerSocket, TcpServerSocket.Proxy> MANAGER = TcpServerSocket_Internal.MANAGER;


    void accept(
SocketObserver observer, 
AcceptResponse callback);

    interface AcceptResponse extends org.chromium.mojo.bindings.Callbacks.Callback5<Integer, IpEndPoint, TcpConnectedSocket, org.chromium.mojo.system.DataPipe.ConsumerHandle, org.chromium.mojo.system.DataPipe.ProducerHandle> { }


}
