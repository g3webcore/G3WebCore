package com.test.g3webcore.plugin;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;

import com.tencent.tencentmap.mapsdk.maps.MapRenderLayer;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;

import org.chromium.content.common.NativePlugin;

import java.util.Map;

public class MapPlugin extends NativePlugin {

    private MapRenderLayer mapRenderLayer;

    public MapPlugin(Context mContext, long mPtr) {
        super(mContext, mPtr);
    }

    @Override
    public boolean onCreate(SurfaceTexture surfaceTexture, int width, int height, Map<String, String> args) {
        surfaceTexture.setDefaultBufferSize(width, height);
        TencentMapOptions mapOptions = new TencentMapOptions();
        mapOptions.setExtSurface(surfaceTexture);
        mapOptions.setExtSurfaceDimension(width, height);
        mapRenderLayer = new MapRenderLayer(mContext, mapOptions);
        mapRenderLayer.onStart();
        mapRenderLayer.onResume();
        return false;
    }

    @Override
    public void handleInputEvent(MotionEvent motionEvent) {
        mapRenderLayer.onTouchEvent(motionEvent);
    }

    @Override
    public void onDestroy() {
        mapRenderLayer.onPause();
        mapRenderLayer.onStop();
        mapRenderLayer.onDestroy();
    }

}
