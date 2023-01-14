// MediaSessionService_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/media_session/public/mojom/media_session_service.mojom
//

package org.chromium.media_session.mojom;


class MediaSessionService_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<MediaSessionService, MediaSessionService.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<MediaSessionService, MediaSessionService.Proxy>() {

        @Override
        public String getName() {
            return "media_session.mojom.MediaSessionService";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, MediaSessionService impl) {
            return new Stub(core, impl);
        }

        @Override
        public MediaSessionService[] buildArray(int size) {
          return new MediaSessionService[size];
        }
    };


    private static final int BIND_AUDIO_FOCUS_MANAGER_ORDINAL = 0;

    private static final int BIND_AUDIO_FOCUS_MANAGER_DEBUG_ORDINAL = 1;

    private static final int BIND_MEDIA_CONTROLLER_MANAGER_ORDINAL = 2;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements MediaSessionService.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void bindAudioFocusManager(
org.chromium.mojo.bindings.InterfaceRequest<AudioFocusManager> receiver) {

            MediaSessionServiceBindAudioFocusManagerParams _message = new MediaSessionServiceBindAudioFocusManagerParams();

            _message.receiver = receiver;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(BIND_AUDIO_FOCUS_MANAGER_ORDINAL)));

        }


        @Override
        public void bindAudioFocusManagerDebug(
org.chromium.mojo.bindings.InterfaceRequest<AudioFocusManagerDebug> receiver) {

            MediaSessionServiceBindAudioFocusManagerDebugParams _message = new MediaSessionServiceBindAudioFocusManagerDebugParams();

            _message.receiver = receiver;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(BIND_AUDIO_FOCUS_MANAGER_DEBUG_ORDINAL)));

        }


        @Override
        public void bindMediaControllerManager(
org.chromium.mojo.bindings.InterfaceRequest<MediaControllerManager> receiver) {

            MediaSessionServiceBindMediaControllerManagerParams _message = new MediaSessionServiceBindMediaControllerManagerParams();

            _message.receiver = receiver;


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(BIND_MEDIA_CONTROLLER_MANAGER_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<MediaSessionService> {

        Stub(org.chromium.mojo.system.Core core, MediaSessionService impl) {
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
                                MediaSessionService_Internal.MANAGER, messageWithHeader);





                    case BIND_AUDIO_FOCUS_MANAGER_ORDINAL: {

                        MediaSessionServiceBindAudioFocusManagerParams data =
                                MediaSessionServiceBindAudioFocusManagerParams.deserialize(messageWithHeader.getPayload());

                        getImpl().bindAudioFocusManager(data.receiver);
                        return true;
                    }





                    case BIND_AUDIO_FOCUS_MANAGER_DEBUG_ORDINAL: {

                        MediaSessionServiceBindAudioFocusManagerDebugParams data =
                                MediaSessionServiceBindAudioFocusManagerDebugParams.deserialize(messageWithHeader.getPayload());

                        getImpl().bindAudioFocusManagerDebug(data.receiver);
                        return true;
                    }





                    case BIND_MEDIA_CONTROLLER_MANAGER_ORDINAL: {

                        MediaSessionServiceBindMediaControllerManagerParams data =
                                MediaSessionServiceBindMediaControllerManagerParams.deserialize(messageWithHeader.getPayload());

                        getImpl().bindMediaControllerManager(data.receiver);
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
                                getCore(), MediaSessionService_Internal.MANAGER, messageWithHeader, receiver);








                    default:
                        return false;
                }
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                System.err.println(e.toString());
                return false;
            }
        }
    }


    
    static final class MediaSessionServiceBindAudioFocusManagerParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<AudioFocusManager> receiver;

        private MediaSessionServiceBindAudioFocusManagerParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaSessionServiceBindAudioFocusManagerParams() {
            this(0);
        }

        public static MediaSessionServiceBindAudioFocusManagerParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaSessionServiceBindAudioFocusManagerParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaSessionServiceBindAudioFocusManagerParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaSessionServiceBindAudioFocusManagerParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceBindAudioFocusManagerParams(elementsOrVersion);
                    {
                        
                    result.receiver = decoder0.readInterfaceRequest(8, false);
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
            
            encoder0.encode(this.receiver, 8, false);
        }
    }



    
    static final class MediaSessionServiceBindAudioFocusManagerDebugParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<AudioFocusManagerDebug> receiver;

        private MediaSessionServiceBindAudioFocusManagerDebugParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaSessionServiceBindAudioFocusManagerDebugParams() {
            this(0);
        }

        public static MediaSessionServiceBindAudioFocusManagerDebugParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaSessionServiceBindAudioFocusManagerDebugParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaSessionServiceBindAudioFocusManagerDebugParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaSessionServiceBindAudioFocusManagerDebugParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceBindAudioFocusManagerDebugParams(elementsOrVersion);
                    {
                        
                    result.receiver = decoder0.readInterfaceRequest(8, false);
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
            
            encoder0.encode(this.receiver, 8, false);
        }
    }



    
    static final class MediaSessionServiceBindMediaControllerManagerParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public org.chromium.mojo.bindings.InterfaceRequest<MediaControllerManager> receiver;

        private MediaSessionServiceBindMediaControllerManagerParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public MediaSessionServiceBindMediaControllerManagerParams() {
            this(0);
        }

        public static MediaSessionServiceBindMediaControllerManagerParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static MediaSessionServiceBindMediaControllerManagerParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static MediaSessionServiceBindMediaControllerManagerParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            MediaSessionServiceBindMediaControllerManagerParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new MediaSessionServiceBindMediaControllerManagerParams(elementsOrVersion);
                    {
                        
                    result.receiver = decoder0.readInterfaceRequest(8, false);
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
            
            encoder0.encode(this.receiver, 8, false);
        }
    }



}