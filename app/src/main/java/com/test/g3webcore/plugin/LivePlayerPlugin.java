package com.test.g3webcore.plugin;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;

import org.chromium.content.common.NativePlugin;

import java.util.Map;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class LivePlayerPlugin extends NativePlugin {

    private IjkMediaPlayer mediaPlayer;

    public LivePlayerPlugin(Context mContext, long mPtr) {
        super(mContext, mPtr);
    }

    @Override
    public boolean onCreate(SurfaceTexture surfaceTexture, int width, int height, Map<String, String> args) {
        try {
            mediaPlayer = new IjkMediaPlayer();
            mediaPlayer.setDataSource(args.get("src"));
            mediaPlayer.setSurface(new Surface(surfaceTexture));
            mediaPlayer.prepareAsync();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void handleInputEvent(MotionEvent motionEvent) {
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }

}
