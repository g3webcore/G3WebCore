// Authenticator_Internal.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/blink/public/mojom/webauthn/authenticator.mojom
//

package org.chromium.blink.mojom;


class Authenticator_Internal {

    public static final org.chromium.mojo.bindings.Interface.Manager<Authenticator, Authenticator.Proxy> MANAGER =
            new org.chromium.mojo.bindings.Interface.Manager<Authenticator, Authenticator.Proxy>() {

        @Override
        public String getName() {
            return "blink.mojom.Authenticator";
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
        public Stub buildStub(org.chromium.mojo.system.Core core, Authenticator impl) {
            return new Stub(core, impl);
        }

        @Override
        public Authenticator[] buildArray(int size) {
          return new Authenticator[size];
        }
    };


    private static final int MAKE_CREDENTIAL_ORDINAL = 0;

    private static final int GET_ASSERTION_ORDINAL = 1;

    private static final int IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE_ORDINAL = 2;

    private static final int CANCEL_ORDINAL = 3;


    static final class Proxy extends org.chromium.mojo.bindings.Interface.AbstractProxy implements Authenticator.Proxy {

        Proxy(org.chromium.mojo.system.Core core,
              org.chromium.mojo.bindings.MessageReceiverWithResponder messageReceiver) {
            super(core, messageReceiver);
        }


        @Override
        public void makeCredential(
PublicKeyCredentialCreationOptions options, 
MakeCredentialResponse callback) {

            AuthenticatorMakeCredentialParams _message = new AuthenticatorMakeCredentialParams();

            _message.options = options;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    MAKE_CREDENTIAL_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new AuthenticatorMakeCredentialResponseParamsForwardToCallback(callback));

        }


        @Override
        public void getAssertion(
PublicKeyCredentialRequestOptions options, 
GetAssertionResponse callback) {

            AuthenticatorGetAssertionParams _message = new AuthenticatorGetAssertionParams();

            _message.options = options;


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_ASSERTION_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new AuthenticatorGetAssertionResponseParamsForwardToCallback(callback));

        }


        @Override
        public void isUserVerifyingPlatformAuthenticatorAvailable(

IsUserVerifyingPlatformAuthenticatorAvailableResponse callback) {

            AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams _message = new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams();


            getProxyHandler().getMessageReceiver().acceptWithResponder(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(
                                    IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_EXPECTS_RESPONSE_FLAG,
                                    0)),
                    new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback(callback));

        }


        @Override
        public void cancel(
) {

            AuthenticatorCancelParams _message = new AuthenticatorCancelParams();


            getProxyHandler().getMessageReceiver().accept(
                    _message.serializeWithHeader(
                            getProxyHandler().getCore(),
                            new org.chromium.mojo.bindings.MessageHeader(CANCEL_ORDINAL)));

        }


    }

    static final class Stub extends org.chromium.mojo.bindings.Interface.Stub<Authenticator> {

        Stub(org.chromium.mojo.system.Core core, Authenticator impl) {
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
                                Authenticator_Internal.MANAGER, messageWithHeader);











                    case CANCEL_ORDINAL: {

                        AuthenticatorCancelParams.deserialize(messageWithHeader.getPayload());

                        getImpl().cancel();
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
                                getCore(), Authenticator_Internal.MANAGER, messageWithHeader, receiver);







                    case MAKE_CREDENTIAL_ORDINAL: {

                        AuthenticatorMakeCredentialParams data =
                                AuthenticatorMakeCredentialParams.deserialize(messageWithHeader.getPayload());

                        getImpl().makeCredential(data.options, new AuthenticatorMakeCredentialResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }







                    case GET_ASSERTION_ORDINAL: {

                        AuthenticatorGetAssertionParams data =
                                AuthenticatorGetAssertionParams.deserialize(messageWithHeader.getPayload());

                        getImpl().getAssertion(data.options, new AuthenticatorGetAssertionResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
                        return true;
                    }







                    case IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE_ORDINAL: {

                        AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams.deserialize(messageWithHeader.getPayload());

                        getImpl().isUserVerifyingPlatformAuthenticatorAvailable(new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder(getCore(), receiver, header.getRequestId()));
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
    }


    
    static final class AuthenticatorMakeCredentialParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PublicKeyCredentialCreationOptions options;

        private AuthenticatorMakeCredentialParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AuthenticatorMakeCredentialParams() {
            this(0);
        }

        public static AuthenticatorMakeCredentialParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AuthenticatorMakeCredentialParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AuthenticatorMakeCredentialParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AuthenticatorMakeCredentialParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorMakeCredentialParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.options = PublicKeyCredentialCreationOptions.decode(decoder1);
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
            
            encoder0.encode(this.options, 8, false);
        }
    }



    
    static final class AuthenticatorMakeCredentialResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;
        public MakeCredentialAuthenticatorResponse credential;

        private AuthenticatorMakeCredentialResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AuthenticatorMakeCredentialResponseParams() {
            this(0);
        }

        public static AuthenticatorMakeCredentialResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AuthenticatorMakeCredentialResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AuthenticatorMakeCredentialResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AuthenticatorMakeCredentialResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorMakeCredentialResponseParams(elementsOrVersion);
                    {
                        
                    result.status = decoder0.readInt(8);
                        AuthenticatorStatus.validate(result.status);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.credential = MakeCredentialAuthenticatorResponse.decode(decoder1);
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
            
            encoder0.encode(this.status, 8);
            
            encoder0.encode(this.credential, 16, true);
        }
    }

    static class AuthenticatorMakeCredentialResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final Authenticator.MakeCredentialResponse mCallback;

        AuthenticatorMakeCredentialResponseParamsForwardToCallback(Authenticator.MakeCredentialResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(MAKE_CREDENTIAL_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                AuthenticatorMakeCredentialResponseParams response = AuthenticatorMakeCredentialResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.status, response.credential);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class AuthenticatorMakeCredentialResponseParamsProxyToResponder implements Authenticator.MakeCredentialResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AuthenticatorMakeCredentialResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer status, MakeCredentialAuthenticatorResponse credential) {
            AuthenticatorMakeCredentialResponseParams _response = new AuthenticatorMakeCredentialResponseParams();

            _response.status = status;

            _response.credential = credential;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    MAKE_CREDENTIAL_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class AuthenticatorGetAssertionParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public PublicKeyCredentialRequestOptions options;

        private AuthenticatorGetAssertionParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AuthenticatorGetAssertionParams() {
            this(0);
        }

        public static AuthenticatorGetAssertionParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AuthenticatorGetAssertionParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AuthenticatorGetAssertionParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AuthenticatorGetAssertionParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorGetAssertionParams(elementsOrVersion);
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                    result.options = PublicKeyCredentialRequestOptions.decode(decoder1);
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
            
            encoder0.encode(this.options, 8, false);
        }
    }



    
    static final class AuthenticatorGetAssertionResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 24;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(24, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public int status;
        public GetAssertionAuthenticatorResponse credential;

        private AuthenticatorGetAssertionResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AuthenticatorGetAssertionResponseParams() {
            this(0);
        }

        public static AuthenticatorGetAssertionResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AuthenticatorGetAssertionResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AuthenticatorGetAssertionResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AuthenticatorGetAssertionResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorGetAssertionResponseParams(elementsOrVersion);
                    {
                        
                    result.status = decoder0.readInt(8);
                        AuthenticatorStatus.validate(result.status);
                    }
                    {
                        
                    org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(16, true);
                    result.credential = GetAssertionAuthenticatorResponse.decode(decoder1);
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
            
            encoder0.encode(this.status, 8);
            
            encoder0.encode(this.credential, 16, true);
        }
    }

    static class AuthenticatorGetAssertionResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final Authenticator.GetAssertionResponse mCallback;

        AuthenticatorGetAssertionResponseParamsForwardToCallback(Authenticator.GetAssertionResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(GET_ASSERTION_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                AuthenticatorGetAssertionResponseParams response = AuthenticatorGetAssertionResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.status, response.credential);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class AuthenticatorGetAssertionResponseParamsProxyToResponder implements Authenticator.GetAssertionResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AuthenticatorGetAssertionResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Integer status, GetAssertionAuthenticatorResponse credential) {
            AuthenticatorGetAssertionResponseParams _response = new AuthenticatorGetAssertionResponseParams();

            _response.status = status;

            _response.credential = credential;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    GET_ASSERTION_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams() {
            this(0);
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableParams(elementsOrVersion);

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }



    
    static final class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 16;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(16, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
        public boolean available;

        private AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams() {
            this(0);
        }

        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams(elementsOrVersion);
                    {
                        
                    result.available = decoder0.readBoolean(8, 0);
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
            
            encoder0.encode(this.available, 8, 0);
        }
    }

    static class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback extends org.chromium.mojo.bindings.SideEffectFreeCloseable
            implements org.chromium.mojo.bindings.MessageReceiver {
        private final Authenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse mCallback;

        AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsForwardToCallback(Authenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse callback) {
            this.mCallback = callback;
        }

        @Override
        public boolean accept(org.chromium.mojo.bindings.Message message) {
            try {
                org.chromium.mojo.bindings.ServiceMessage messageWithHeader =
                        message.asServiceMessage();
                org.chromium.mojo.bindings.MessageHeader header = messageWithHeader.getHeader();
                if (!header.validateHeader(IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE_ORDINAL,
                                           org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG)) {
                    return false;
                }

                AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams response = AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams.deserialize(messageWithHeader.getPayload());

                mCallback.call(response.available);
                return true;
            } catch (org.chromium.mojo.bindings.DeserializationException e) {
                return false;
            }
        }
    }

    static class AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder implements Authenticator.IsUserVerifyingPlatformAuthenticatorAvailableResponse {

        private final org.chromium.mojo.system.Core mCore;
        private final org.chromium.mojo.bindings.MessageReceiver mMessageReceiver;
        private final long mRequestId;

        AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParamsProxyToResponder(
                org.chromium.mojo.system.Core core,
                org.chromium.mojo.bindings.MessageReceiver messageReceiver,
                long requestId) {
            mCore = core;
            mMessageReceiver = messageReceiver;
            mRequestId = requestId;
        }

        @Override
        public void call(Boolean available) {
            AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams _response = new AuthenticatorIsUserVerifyingPlatformAuthenticatorAvailableResponseParams();

            _response.available = available;

            org.chromium.mojo.bindings.ServiceMessage _message =
                    _response.serializeWithHeader(
                            mCore,
                            new org.chromium.mojo.bindings.MessageHeader(
                                    IS_USER_VERIFYING_PLATFORM_AUTHENTICATOR_AVAILABLE_ORDINAL,
                                    org.chromium.mojo.bindings.MessageHeader.MESSAGE_IS_RESPONSE_FLAG,
                                    mRequestId));
            mMessageReceiver.accept(_message);
        }
    }



    
    static final class AuthenticatorCancelParams extends org.chromium.mojo.bindings.Struct {

        private static final int STRUCT_SIZE = 8;
        private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(8, 0)};
        private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];

        private AuthenticatorCancelParams(int version) {
            super(STRUCT_SIZE, version);
        }

        public AuthenticatorCancelParams() {
            this(0);
        }

        public static AuthenticatorCancelParams deserialize(org.chromium.mojo.bindings.Message message) {
            return decode(new org.chromium.mojo.bindings.Decoder(message));
        }

        /**
         * Similar to the method above, but deserializes from a |ByteBuffer| instance.
         *
         * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
         */
        public static AuthenticatorCancelParams deserialize(java.nio.ByteBuffer data) {
            return deserialize(new org.chromium.mojo.bindings.Message(
                    data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
        }

        @SuppressWarnings("unchecked")
        public static AuthenticatorCancelParams decode(org.chromium.mojo.bindings.Decoder decoder0) {
            if (decoder0 == null) {
                return null;
            }
            decoder0.increaseStackDepth();
            AuthenticatorCancelParams result;
            try {
                org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
                final int elementsOrVersion = mainDataHeader.elementsOrVersion;
                result = new AuthenticatorCancelParams(elementsOrVersion);

            } finally {
                decoder0.decreaseStackDepth();
            }
            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected final void encode(org.chromium.mojo.bindings.Encoder encoder) {
            encoder.getEncoderAtDataOffset(DEFAULT_STRUCT_INFO);
        }
    }



}