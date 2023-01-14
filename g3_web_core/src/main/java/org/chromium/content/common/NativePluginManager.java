package org.chromium.content.common;

import android.graphics.SurfaceTexture;

import org.chromium.base.annotations.CalledByNative;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NativePluginManager {

    private static NativePluginManager sInstance = new NativePluginManager();

    private Map<String, NativePluginFactory> nativePluginFactoryHashMap = new HashMap<>();

    private NativePluginManager(){}

    @CalledByNative
    public static NativePlugin createNativePlugin(long nativePtr, String name) {
        NativePluginFactory nativePluginFactory = getInstance().getNativePluginFactory(name);
        if (nativePluginFactory != null) {
            return nativePluginFactory.createNativePlugin(nativePtr);
        }
        return null;
    }

    @CalledByNative
    public static boolean onCreate(NativePlugin nativePlugin, SurfaceTexture surfaceTexture, int width, int height, String args) {
        Map<String, String> argsMap = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(args);
            Iterator<String> iterator = jsonObject.keys();
            while(iterator.hasNext()){
                String key = iterator.next();
                argsMap.put(key, jsonObject.getString(key));
            }
        } catch (JSONException ignored) {
        }
        return nativePlugin.onCreate(surfaceTexture, width, height, argsMap);
    }

    @CalledByNative
    public static void handleInputEvent(NativePlugin nativePlugin, float[] event) {
        nativePlugin.handleInputEvent(nativePlugin.convertToMotionEvent(event));
    }

    @CalledByNative
    public static void onDestroy(NativePlugin nativePlugin) {
        nativePlugin.onDestroy();
    }

    private NativePluginFactory getNativePluginFactory(String name) {
        return nativePluginFactoryHashMap.get(name);
    }

    public static NativePluginManager getInstance() {
        return sInstance;
    }

    public void registerNativePlugin(String name, NativePluginFactory nativePluginFactory) {
        nativePluginFactoryHashMap.put(name, nativePluginFactory);
    }

}
