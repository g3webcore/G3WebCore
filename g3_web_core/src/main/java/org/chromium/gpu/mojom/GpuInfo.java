// GpuInfo.java is auto generated by mojom_bindings_generator.py, do not edit


// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     gpu/ipc/common/gpu_info.mojom
//

package org.chromium.gpu.mojom;


public final class GpuInfo extends org.chromium.mojo.bindings.Struct {

    private static final int STRUCT_SIZE = 176;
    private static final org.chromium.mojo.bindings.DataHeader[] VERSION_ARRAY = new org.chromium.mojo.bindings.DataHeader[] {new org.chromium.mojo.bindings.DataHeader(176, 0)};
    private static final org.chromium.mojo.bindings.DataHeader DEFAULT_STRUCT_INFO = VERSION_ARRAY[0];
    public org.chromium.mojo_base.mojom.TimeDelta initializationTime;
    public boolean optimus;
    public boolean amdSwitchable;
    public GpuDevice gpu;
    public GpuDevice[] secondaryGpus;
    public String pixelShaderVersion;
    public String vertexShaderVersion;
    public String maxMsaaSamples;
    public String machineModelName;
    public String machineModelVersion;
    public String glVersion;
    public String glVendor;
    public String glRenderer;
    public String glExtensions;
    public String glWsVendor;
    public String glWsVersion;
    public String glWsExtensions;
    public int glResetNotificationStrategy;
    public boolean softwareRendering;
    public String directRenderingVersion;
    public boolean sandboxed;
    public boolean inProcessGpu;
    public boolean passthroughCmdDecoder;
    public boolean canSupportThreadedTextureMailbox;
    public VideoDecodeAcceleratorCapabilities videoDecodeAcceleratorCapabilities;
    public VideoEncodeAcceleratorSupportedProfile[] videoEncodeAcceleratorSupportedProfiles;
    public boolean jpegDecodeAcceleratorSupported;
    public ImageDecodeAcceleratorSupportedProfile[] imageDecodeAcceleratorSupportedProfiles;
    public boolean oopRasterizationSupported;
    public boolean subpixelFontRendering;
    public VulkanInfo vulkanInfo;

    private GpuInfo(int version) {
        super(STRUCT_SIZE, version);
    }

    public GpuInfo() {
        this(0);
    }

    public static GpuInfo deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message));
    }

    /**
     * Similar to the method above, but deserializes from a |ByteBuffer| instance.
     *
     * @throws org.chromium.mojo.bindings.DeserializationException on deserialization failure.
     */
    public static GpuInfo deserialize(java.nio.ByteBuffer data) {
        return deserialize(new org.chromium.mojo.bindings.Message(
                data, new java.util.ArrayList<org.chromium.mojo.system.Handle>()));
    }

    @SuppressWarnings("unchecked")
    public static GpuInfo decode(org.chromium.mojo.bindings.Decoder decoder0) {
        if (decoder0 == null) {
            return null;
        }
        decoder0.increaseStackDepth();
        GpuInfo result;
        try {
            org.chromium.mojo.bindings.DataHeader mainDataHeader = decoder0.readAndValidateDataHeader(VERSION_ARRAY);
            final int elementsOrVersion = mainDataHeader.elementsOrVersion;
            result = new GpuInfo(elementsOrVersion);
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(8, false);
                result.initializationTime = org.chromium.mojo_base.mojom.TimeDelta.decode(decoder1);
                }
                {
                    
                result.optimus = decoder0.readBoolean(16, 0);
                }
                {
                    
                result.amdSwitchable = decoder0.readBoolean(16, 1);
                }
                {
                    
                result.softwareRendering = decoder0.readBoolean(16, 2);
                }
                {
                    
                result.sandboxed = decoder0.readBoolean(16, 3);
                }
                {
                    
                result.inProcessGpu = decoder0.readBoolean(16, 4);
                }
                {
                    
                result.passthroughCmdDecoder = decoder0.readBoolean(16, 5);
                }
                {
                    
                result.canSupportThreadedTextureMailbox = decoder0.readBoolean(16, 6);
                }
                {
                    
                result.jpegDecodeAcceleratorSupported = decoder0.readBoolean(16, 7);
                }
                {
                    
                result.oopRasterizationSupported = decoder0.readBoolean(17, 0);
                }
                {
                    
                result.subpixelFontRendering = decoder0.readBoolean(17, 1);
                }
                {
                    
                result.glResetNotificationStrategy = decoder0.readInt(20);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(24, false);
                result.gpu = GpuDevice.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(32, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.secondaryGpus = new GpuDevice[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.secondaryGpus[i1] = GpuDevice.decode(decoder2);
                    }
                }
                }
                {
                    
                result.pixelShaderVersion = decoder0.readString(40, false);
                }
                {
                    
                result.vertexShaderVersion = decoder0.readString(48, false);
                }
                {
                    
                result.maxMsaaSamples = decoder0.readString(56, false);
                }
                {
                    
                result.machineModelName = decoder0.readString(64, false);
                }
                {
                    
                result.machineModelVersion = decoder0.readString(72, false);
                }
                {
                    
                result.glVersion = decoder0.readString(80, false);
                }
                {
                    
                result.glVendor = decoder0.readString(88, false);
                }
                {
                    
                result.glRenderer = decoder0.readString(96, false);
                }
                {
                    
                result.glExtensions = decoder0.readString(104, false);
                }
                {
                    
                result.glWsVendor = decoder0.readString(112, false);
                }
                {
                    
                result.glWsVersion = decoder0.readString(120, false);
                }
                {
                    
                result.glWsExtensions = decoder0.readString(128, false);
                }
                {
                    
                result.directRenderingVersion = decoder0.readString(136, false);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(144, false);
                result.videoDecodeAcceleratorCapabilities = VideoDecodeAcceleratorCapabilities.decode(decoder1);
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(152, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.videoEncodeAcceleratorSupportedProfiles = new VideoEncodeAcceleratorSupportedProfile[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.videoEncodeAcceleratorSupportedProfiles[i1] = VideoEncodeAcceleratorSupportedProfile.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(160, false);
                {
                    org.chromium.mojo.bindings.DataHeader si1 = decoder1.readDataHeaderForPointerArray(org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
                    result.imageDecodeAcceleratorSupportedProfiles = new ImageDecodeAcceleratorSupportedProfile[si1.elementsOrVersion];
                    for (int i1 = 0; i1 < si1.elementsOrVersion; ++i1) {
                        
                        org.chromium.mojo.bindings.Decoder decoder2 = decoder1.readPointer(org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i1, false);
                        result.imageDecodeAcceleratorSupportedProfiles[i1] = ImageDecodeAcceleratorSupportedProfile.decode(decoder2);
                    }
                }
                }
                {
                    
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(168, true);
                result.vulkanInfo = VulkanInfo.decode(decoder1);
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
        
        encoder0.encode(this.initializationTime, 8, false);
        
        encoder0.encode(this.optimus, 16, 0);
        
        encoder0.encode(this.amdSwitchable, 16, 1);
        
        encoder0.encode(this.softwareRendering, 16, 2);
        
        encoder0.encode(this.sandboxed, 16, 3);
        
        encoder0.encode(this.inProcessGpu, 16, 4);
        
        encoder0.encode(this.passthroughCmdDecoder, 16, 5);
        
        encoder0.encode(this.canSupportThreadedTextureMailbox, 16, 6);
        
        encoder0.encode(this.jpegDecodeAcceleratorSupported, 16, 7);
        
        encoder0.encode(this.oopRasterizationSupported, 17, 0);
        
        encoder0.encode(this.subpixelFontRendering, 17, 1);
        
        encoder0.encode(this.glResetNotificationStrategy, 20);
        
        encoder0.encode(this.gpu, 24, false);
        
        if (this.secondaryGpus == null) {
            encoder0.encodeNullPointer(32, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.secondaryGpus.length, 32, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.secondaryGpus.length; ++i0) {
                
                encoder1.encode(this.secondaryGpus[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.pixelShaderVersion, 40, false);
        
        encoder0.encode(this.vertexShaderVersion, 48, false);
        
        encoder0.encode(this.maxMsaaSamples, 56, false);
        
        encoder0.encode(this.machineModelName, 64, false);
        
        encoder0.encode(this.machineModelVersion, 72, false);
        
        encoder0.encode(this.glVersion, 80, false);
        
        encoder0.encode(this.glVendor, 88, false);
        
        encoder0.encode(this.glRenderer, 96, false);
        
        encoder0.encode(this.glExtensions, 104, false);
        
        encoder0.encode(this.glWsVendor, 112, false);
        
        encoder0.encode(this.glWsVersion, 120, false);
        
        encoder0.encode(this.glWsExtensions, 128, false);
        
        encoder0.encode(this.directRenderingVersion, 136, false);
        
        encoder0.encode(this.videoDecodeAcceleratorCapabilities, 144, false);
        
        if (this.videoEncodeAcceleratorSupportedProfiles == null) {
            encoder0.encodeNullPointer(152, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.videoEncodeAcceleratorSupportedProfiles.length, 152, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.videoEncodeAcceleratorSupportedProfiles.length; ++i0) {
                
                encoder1.encode(this.videoEncodeAcceleratorSupportedProfiles[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        if (this.imageDecodeAcceleratorSupportedProfiles == null) {
            encoder0.encodeNullPointer(160, false);
        } else {
            org.chromium.mojo.bindings.Encoder encoder1 = encoder0.encodePointerArray(this.imageDecodeAcceleratorSupportedProfiles.length, 160, org.chromium.mojo.bindings.BindingsHelper.UNSPECIFIED_ARRAY_LENGTH);
            for (int i0 = 0; i0 < this.imageDecodeAcceleratorSupportedProfiles.length; ++i0) {
                
                encoder1.encode(this.imageDecodeAcceleratorSupportedProfiles[i0], org.chromium.mojo.bindings.DataHeader.HEADER_SIZE + org.chromium.mojo.bindings.BindingsHelper.POINTER_SIZE * i0, false);
            }
        }
        
        encoder0.encode(this.vulkanInfo, 168, true);
    }
}