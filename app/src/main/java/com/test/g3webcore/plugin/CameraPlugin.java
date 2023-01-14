package com.test.g3webcore.plugin;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.MotionEvent;

import org.chromium.content.common.NativePlugin;

import java.util.Map;
import java.util.Objects;

public class CameraPlugin extends NativePlugin {

    private CameraV1 mCameraV1;

    public CameraPlugin(Context mContext, long mPtr) {
        super(mContext, mPtr);
    }

    @Override
    public boolean onCreate(SurfaceTexture surfaceTexture, int width, int height, Map<String, String> args) {
        mCameraV1 = new CameraV1();
        int face = Camera.CameraInfo.CAMERA_FACING_BACK;
        if (Objects.equals("front", args.get("facing"))) {
            face = Camera.CameraInfo.CAMERA_FACING_FRONT;
        }
        mCameraV1.openCamera(face);
        mCameraV1.setPreviewTexture(surfaceTexture);
        mCameraV1.startPreview();
        return true;
    }

    @Override
    public void handleInputEvent(MotionEvent motionEvent) {

    }

    @Override
    public void onDestroy() {
        if (mCameraV1 != null) {
            mCameraV1.stopPreview();
            mCameraV1.releaseCamera();
        }
    }

}
