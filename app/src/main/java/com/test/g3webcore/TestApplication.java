package com.test.g3webcore;

import android.app.Application;

import org.chromium.webview.g3webcore.G3WebCoreInitializer;

public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        G3WebCoreInitializer.init(this);
    }
}
