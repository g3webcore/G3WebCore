package org.chromium.webview.g3webcore;

import android.content.Context;
import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewStructure;

import org.chromium.components.embedder_support.view.ContentView;
import org.chromium.content_public.browser.WebContents;
import org.chromium.content_public.browser.WebContentsAccessibility;

public class G3ContentView extends ContentView {

    private G3WebCore mG3WebCore;
    
    public static G3ContentView createContentView(Context context, WebContents webContents, G3WebCore g3WebCore) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return new G3ContentViewApi23(context, webContents, g3WebCore);
        }
        return new G3ContentView(context, webContents, g3WebCore);
    }

    G3ContentView(Context context, WebContents webContents, G3WebCore g3WebCore) {
        super(context, webContents);
        mG3WebCore = g3WebCore;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
                && event.getAction() == KeyEvent.ACTION_UP
                && mG3WebCore.isFullScreen()) {
            mG3WebCore.requestExitFullscreen();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    private static class G3ContentViewApi23 extends G3ContentView {
        public G3ContentViewApi23(Context context, WebContents webContents, G3WebCore g3WebCore) {
            super(context, webContents, g3WebCore);
        }

        @Override
        public void onProvideVirtualStructure(final ViewStructure structure) {
            WebContentsAccessibility wcax = getWebContentsAccessibility();
            if (wcax != null) wcax.onProvideVirtualStructure(structure, false);
        }
    }

}
