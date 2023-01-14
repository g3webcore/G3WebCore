package org.chromium.webview.g3webcore;


import android.net.Uri;

import org.chromium.base.ThreadUtils;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeMethods;

/**
 * This class wraps permission request in Chromium side, and can only be created
 * by native side.
 */
@JNINamespace("g3webcore")
public class G3PermissionRequest {
    private final Uri mOrigin;
    private final long mResources;
    private boolean mProcessed;

    private long mNativeG3PermissionRequest;

    // Responsible for deleting native peer.
    private CleanupReference mCleanupReference;

    // This should be same as corresponding definition in PermissionRequest.
    // We duplicate definition because it is used in Android L and afterwards, but is only
    // defined in M.
    // TODO(michaelbai) : Replace "android.webkit.resource.MIDI_SYSEX" with
    // PermissionRequest.RESOURCE_MIDI_SYSEX once Android M SDK is used.
    public static final String RESOURCE_MIDI_SYSEX = "android.webkit.resource.MIDI_SYSEX";

    private static final class DestroyRunnable implements Runnable {
        private final long mNativeG3PermissionRequest;

        private DestroyRunnable(long nativeG3PermissionRequest) {
            mNativeG3PermissionRequest = nativeG3PermissionRequest;
        }
        @Override
        public void run() {
            G3PermissionRequestJni.get().destroy(mNativeG3PermissionRequest);
        }
    }

    @CalledByNative
    private static G3PermissionRequest create(long nativeG3PermissionRequest, String url,
                                              long resources) {
        if (nativeG3PermissionRequest == 0) return null;
        Uri origin = Uri.parse(url);
        return new G3PermissionRequest(nativeG3PermissionRequest, origin, resources);
    }

    private G3PermissionRequest(long nativeG3PermissionRequest, Uri origin,
                                long resources) {
        mNativeG3PermissionRequest = nativeG3PermissionRequest;
        mOrigin = origin;
        mResources = resources;
        mCleanupReference =
                new CleanupReference(this, new DestroyRunnable(mNativeG3PermissionRequest));
    }

    public Uri getOrigin() {
        return mOrigin;
    }

    public long getResources() {
        return mResources;
    }

    public void grant() {
        validate();
        if (mNativeG3PermissionRequest != 0) {
            G3PermissionRequestJni.get().onAccept(
                    mNativeG3PermissionRequest, G3PermissionRequest.this, true);
            destroyNative();
        }
        mProcessed = true;
    }

    public void deny() {
        validate();
        if (mNativeG3PermissionRequest != 0) {
            G3PermissionRequestJni.get().onAccept(
                    mNativeG3PermissionRequest, G3PermissionRequest.this, false);
            destroyNative();
        }
        mProcessed = true;
    }

    @CalledByNative
    private void destroyNative() {
        mCleanupReference.cleanupNow();
        mCleanupReference = null;
        mNativeG3PermissionRequest = 0;
    }

    private void validate() {
        if (!ThreadUtils.runningOnUiThread()) {
            throw new IllegalStateException(
                    "Either grant() or deny() should be called on UI thread");
        }

        if (mProcessed) {
            throw new IllegalStateException("Either grant() or deny() has been already called.");
        }
    }

    @NativeMethods
    interface Natives {
        void onAccept(long nativeG3PermissionRequest, G3PermissionRequest caller, boolean allowed);
        void destroy(long nativeG3PermissionRequest);
    }
}
