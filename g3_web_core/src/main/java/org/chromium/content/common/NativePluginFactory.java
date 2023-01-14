package org.chromium.content.common;

public interface NativePluginFactory {
    NativePlugin createNativePlugin(long ptr);
}
