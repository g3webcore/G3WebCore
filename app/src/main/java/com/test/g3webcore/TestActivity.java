package com.test.g3webcore;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import com.test.g3webcore.plugin.CameraPlugin;
import com.test.g3webcore.plugin.LivePlayerPlugin;
import com.test.g3webcore.plugin.MapPlugin;

import org.chromium.content.common.NativePlugin;
import org.chromium.content.common.NativePluginFactory;
import org.chromium.webview.WebChromeClient;
import org.chromium.webview.WebView;
import org.chromium.webview.WebViewClient;

public class TestActivity extends FragmentActivity {

    private WebView webView;

    private static final int PERMISSIONS_CODE = 666;
    private static final String URL = "file:///android_asset/index.html";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        FrameLayout frameLayout = findViewById(R.id.container);
        webView = new WebView(this);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webView.getNativePluginManager().registerNativePlugin("native-plugin/live-player", new NativePluginFactory() {
            @Override
            public NativePlugin createNativePlugin(long ptr) {
                return new LivePlayerPlugin(TestActivity.this, ptr);
            }
        });
        webView.getNativePluginManager().registerNativePlugin("native-plugin/camera", new NativePluginFactory() {
            @Override
            public NativePlugin createNativePlugin(long ptr) {
                return new CameraPlugin(TestActivity.this, ptr);
            }
        });
        webView.getNativePluginManager().registerNativePlugin("native-plugin/map", new NativePluginFactory() {
            @Override
            public NativePlugin createNativePlugin(long ptr) {
                return new MapPlugin(TestActivity.this, ptr);
            }
        });
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        frameLayout.addView(webView,
                new FrameLayout.LayoutParams(
                        FrameLayout.LayoutParams.MATCH_PARENT,
                        FrameLayout.LayoutParams.MATCH_PARENT));

        String[] permissions = {Manifest.permission.CAMERA};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(permissions[0]) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, permissions, PERMISSIONS_CODE);
        } else {
            webView.loadUrl(URL);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSIONS_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                webView.loadUrl(URL);
            } else {
                Toast.makeText(this, "没有摄像头权限", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        webView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (webView != null) {
            webView.destroy();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
