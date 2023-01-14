package org.chromium.content.common;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.SystemClock;
import android.view.MotionEvent;

import java.util.Map;

public abstract class NativePlugin {

    protected Context mContext;
    private long mPtr;

    public NativePlugin(Context mContext, long mPtr) {
        this.mContext = mContext;
        this.mPtr = mPtr;
    }

    protected abstract boolean onCreate(SurfaceTexture surfaceTexture, int width, int height, Map<String, String> args);

    protected abstract void handleInputEvent(MotionEvent motionEvent);

    protected abstract void onDestroy();

    private float lastX = 0f;
    private float lastY = 0f;

    MotionEvent convertToMotionEvent(float[] event) {
        if (event.length < 1) {
            return null;
        }
        int action = (int) event[0];
        int pointCount = (event.length - 1) / 2;
        switch ((int) event[0]) {
            case MotionEvent.ACTION_DOWN:
                if (pointCount > 1) {
                    action = MotionEvent.ACTION_POINTER_DOWN;
                }
                lastX = event[1];
                lastY = event[2];
                break;
            case MotionEvent.ACTION_MOVE:
                lastX = event[1];
                lastY = event[2];
                break;
            case MotionEvent.ACTION_UP:
                if (pointCount > 0) {
                    action = MotionEvent.ACTION_POINTER_UP;
                }
                if (event.length >= 3) {
                    lastX = event[1];
                    lastY = event[2];
                }
                break;
        }

        if (pointCount == 0) {
            event = new float[3];
            event[0] = MotionEvent.ACTION_UP;
            event[1] = lastX;
            event[2] = lastY;
            pointCount = 1;
        }
        MotionEvent.PointerCoords[] pointerCoordsArray = new MotionEvent.PointerCoords[pointCount];
        MotionEvent.PointerProperties[] pointerPropertiesArray = new MotionEvent.PointerProperties[pointCount];
        for (int i = 1; i < event.length; i += 2) {
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            pointerCoords.x = event[i];
            pointerCoords.y = event[i + 1];
            int pointIndex = (i - 1) / 2;
            pointerCoordsArray[pointIndex] = pointerCoords;
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerProperties.id = pointIndex;
            pointerProperties.toolType = MotionEvent.TOOL_TYPE_FINGER;
            pointerPropertiesArray[pointIndex] = pointerProperties;
        }

        return MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis() + 1, action,
                pointCount, pointerPropertiesArray, pointerCoordsArray,
                0, 0, 0.0f, 0.f, 0,
                0, 0, 0);
    }

}
