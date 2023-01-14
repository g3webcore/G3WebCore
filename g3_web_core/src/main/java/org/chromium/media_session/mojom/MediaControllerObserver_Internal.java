// MediaControllerObserver_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/media_session/public/mojom/media_controller.mojom
//

package org.chromium.media_session.mojom;


class MediaControllerObserver_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<MediaControllerObserver, MediaControllerObserver.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<MediaControllerObserver, MediaControllerObserver.Proxy>() {

        @Override
        public String getName() {
            return "media_session.mojom.MediaControllerObserver";
        }

        @Override
        public int getVersion() {
          return 0;
        }

        @Override
        public Proxy buildProxy(org.chromium.mojo.system.Core core,
                                org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            return new Proxy(core, messageReceiver);
        }

        @Override
        public Stub buildStub(org.chromium.mojo.system.Core core, MediaControllerObserver impl) {
            return new Stub(core, impl);
        }

        @Override
        public MediaControllerObserver[] buildArray(int size) {
          return new MediaControllerObserver[size];
        }
    };


    private static final int MEDIA_SESSION_INFO_CHANGED_ORDINAL = 0;

    private static final int MEDIA_SESSION_METADATA_CHANGED_ORDINAL = 1;

    private static final int MEDIA_SESSION_ACTIONS_CHANGED_ORDINAL = 2;

    private static final int MEDIA_SESSION_CHANGED_ORDINAL = 3;

    private static final int MEDIA_SESSION_POSITION_CHANGED_ORDINAL = 4;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements MediaControllerObserver.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void mediaSessionInfoChanged(
MediaSessionInfo info) {

            MediaControllerObserverMediaSessionInfoChangedParams _message = new MediaControllerObserverMediaSessionInfoChangedParams();

            _message.info = info;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(MEDIA_SESSION_INFO_CHANGED_ORDINAL)));

        }


        @Override
        public void mediaSessionMetadataChanged(
MediaMetadata metadata) {

            MediaControllerObserverMediaSessionMetadataChangedParams _message = new MediaControllerObserverMediaSessionMetadataChangedParams();

            _message.metadata = metadata;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(MEDIA_SESSION_METADATA_CHANGED_ORDINAL)));

        }


        @Override
        public void mediaSessionActionsChanged(
int[] action) {

            MediaControllerObserverMediaSessionActionsChangedParams _message = new MediaControllerObserverMediaSessionActionsChangedParams();

            _message.action = action;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(MEDIA_SESSION_ACTIONS_CHANGED_ORDINAL)));

        }


        @Override
        public void mediaSessionChanged(
org.chromium.mojo_base.mojom.UnguessableToken requestId) {

            MediaControllerObserverMediaSessionChangedParams _message = new MediaControllerObserverMediaSessionChangedParams();

            _message.requestId = requestId;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(MEDIA_SESSION_CHANGED_ORDINAL)));

        }


        @Override
        public void mediaSessionPositionChanged(
MediaPosition position) {

            MediaControllerObserverMediaSessionPositionChangedParams _message = new MediaControllerObserverMediaSessionPositionChangedParams();

            _message.position = position;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(MEDIA_SESSION_POSITION_CHANGED_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<MediaControllerObserver> {

        Stub(org.chromium.mojo.system.Core core, MediaControllerObserver impl) {
            super(core, impl);
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.NO_FLAG)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_OR_CLOSE_PIPE_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRunOrClosePipe(
                                MediaControllerObserver_Internal.MANAGER, messageWithHeader);





                    case MEDIA_SESSION_INFO_CHANGED_ORDINAL: {

                        MediaControllerObserverMediaSessionInfoChangedParams data =
                                MediaControllerObserverMediaSessionInfoChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().mediaSessionInfoChanged(data.info);
                        return true;
                    }





                    case MEDIA_SESSION_METADATA_CHANGED_ORDINAL: {

                        MediaControllerObserverMediaSessionMetadataChangedParams data =
                                MediaControllerObserverMediaSessionMetadataChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().mediaSessionMetadataChanged(data.metadata);
                        return true;
                    }





                    case MEDIA_SESSION_ACTIONS_CHANGED_ORDINAL: {

                        MediaControllerObserverMediaSessionActionsChangedParams data =
                                MediaControllerObserverMediaSessionActionsChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().mediaSessionActionsChanged(data.action);
                        return true;
                    }





                    case MEDIA_SESSION_CHANGED_ORDINAL: {

                        MediaControllerObserverMediaSessionChangedParams data =
                                MediaControllerObserverMediaSessionChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().mediaSessionChanged(data.requestId);
                        return true;
                    }





                    case MEDIA_SESSION_POSITION_CHANGED_ORDINAL: {

                        MediaControllerObserverMediaSessionPositionChangedParams data =
                                MediaControllerObserverMediaSessionPositionChangedParams.deserialize(messageWithHeader.getPayload());

                        getImpl().mediaSessionPositionChanged(data.position);
                        return true;
                    }


                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }

        @Override
        public boolean acceptWithResponder(org.chromium.mojo.bindings.Message message, org.chromium.mojo.bindings.MessageReceiver receiver) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG)) {
                    return false;
                }
                switch(header.getType()) {

                    case org.chromium.mojo.bindings.interfacecontrol.InterfaceControlMessagesConstants.RUN_MESSAGE_ID:
                        return org.chromium.mojo.bindings.InterfaceControlMessagesHelper.handleRun(
                                getCore(), MediaControllerObserver_Internal.MANAGER, messageWithHeader, receiver);












                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class MediaControllerObserverMediaSessionInfoChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaSessionInfo info;

        private MediaControllerObserverMediaSessionInfoChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaControllerObserverMediaSessionInfoChangedParams() {
            this(0);
        }

        public static MediaControllerObserverMediaSessionInfoChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaControllerObserverMediaSessionInfoChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaControllerObserverMediaSessionInfoChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaControllerObserverMediaSessionInfoChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaControllerObserverMediaSessionInfoChangedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                    result.info = MediaSessionInfo.decode(decoder1);
                    }

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            
            encoder0.encode(this.info, 8, true);
        }
    }



    
    static final class MediaControllerObserverMediaSessionMetadataChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaMetadata metadata;

        private MediaControllerObserverMediaSessionMetadataChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaControllerObserverMediaSessionMetadataChangedParams() {
            this(0);
        }

        public static MediaControllerObserverMediaSessionMetadataChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaControllerObserverMediaSessionMetadataChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaControllerObserverMediaSessionMetadataChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaControllerObserverMediaSessionMetadataChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaControllerObserverMediaSessionMetadataChangedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                    result.metadata = MediaMetadata.decode(decoder1);
                    }

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            
            encoder0.encode(this.metadata, 8, true);
        }
    }



    
    static final class MediaControllerObserverMediaSessionActionsChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int[] action;

        private MediaControllerObserverMediaSessionActionsChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaControllerObserverMediaSessionActionsChangedParams() {
            this(0);
        }

        public static MediaControllerObserverMediaSessionActionsChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaControllerObserverMediaSessionActionsChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaControllerObserverMediaSessionActionsChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaControllerObserverMediaSessionActionsChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaControllerObserverMediaSessionActionsChangedParams(elementsOrVersion);
                    {
                        
                    result.action = decoder0.readInts(8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    {
                        for (int i0 = 0; i0 < result.action.length; ++i0) {
                            MediaSessionAction.validate(result.action[i0]);
                        }
                    }
                    }

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            
            encoder0.encode(this.action, 8, org.chromium.mojo.bindings.BindingsHelper.NOTHING_NULLABLE, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
        }
    }



    
    static final class MediaControllerObserverMediaSessionChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo_base.mojom.UnguessableToken requestId;

        private MediaControllerObserverMediaSessionChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaControllerObserverMediaSessionChangedParams() {
            this(0);
        }

        public static MediaControllerObserverMediaSessionChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaControllerObserverMediaSessionChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaControllerObserverMediaSessionChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaControllerObserverMediaSessionChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaControllerObserverMediaSessionChangedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                    result.requestId = org.chromium.mojo_base.mojom.UnguessableToken.decode(decoder1);
                    }

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            
            encoder0.encode(this.requestId, 8, true);
        }
    }



    
    static final class MediaControllerObserverMediaSessionPositionChangedParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public MediaPosition position;

        private MediaControllerObserverMediaSessionPositionChangedParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaControllerObserverMediaSessionPositionChangedParams() {
            this(0);
        }

        public static MediaControllerObserverMediaSessionPositionChangedParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaControllerObserverMediaSessionPositionChangedParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaControllerObserverMediaSessionPositionChangedParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaControllerObserverMediaSessionPositionChangedParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaControllerObserverMediaSessionPositionChangedParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, true);
                    result.position = MediaPosition.decode(decoder1);
                    }

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            org.chromium.mojo.bindings.Encoder encoder0 = encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
            
            encoder0.encode(this.position, 8, true);
        }
    }



}
