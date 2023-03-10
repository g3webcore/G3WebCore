package org.chromium.webview.g3webcore;


import androidx.annotation.VisibleForTesting;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeMethods;
import org.chromium.components.embedder_support.delegate.WebContentsDelegateAndroid;

/**
 * WebView-specific WebContentsDelegate.
 * This file is the Java version of the native class of the same name.
 * It should contain abstract WebContentsDelegate methods to be implemented by the embedder.
 * These methods belong to WebView but are not shared with the Chromium Android port.
 */
@VisibleForTesting
@JNINamespace("g3webcore")
public abstract class G3WebContentsDelegate extends WebContentsDelegateAndroid {
    // Callback filesSelectedInChooser() when done.
    @CalledByNative
    public abstract void runFileChooser(int processId, int renderId, int modeFlags,
                                        String acceptTypes, String title, String defaultFilename,  boolean capture);

    @CalledByNative
    public abstract boolean addNewContents(boolean isDialog, boolean isUserGesture);

    @Override
    @CalledByNative
    public abstract void closeContents();

    @Override
    @CalledByNative
    public abstract void activateContents();

    @Override
    @CalledByNative
    public abstract void navigationStateChanged(int flags);

    // Not an override, because WebContentsDelegateAndroid maps this call
    // into onLoad{Started|Stopped}.
    @CalledByNative
    public abstract void loadingStateChanged();

    @NativeMethods
    interface Natives {
        // Call in response to a prior runFileChooser call.
        void filesSelectedInChooser(int processId, int renderId, int modeFlags, String[] filePath,
                                    String[] displayName);
    }
}
