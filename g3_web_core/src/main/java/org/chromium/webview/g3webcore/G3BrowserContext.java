package org.chromium.webview.g3webcore;


import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.VisibleForTesting;

import org.chromium.base.ContextUtils;
import org.chromium.base.StrictModeContext;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.base.annotations.NativeMethods;

/**
 * Java side of the Browser Context: contains all the java side objects needed to host one
 * browsing session (i.e. profile).
 *
 * Note that historically WebView was running in single process mode, and limitations on renderer
 * process only being able to use a single browser context, currently there can only be one
 * G3BrowserContext instance, so at this point the class mostly exists for conceptual clarity.
 */
@JNINamespace("g3webcore")
public class G3BrowserContext {
    private static final String CHROMIUM_PREFS_NAME = "WebViewProfilePrefsDefault";

    private static final String TAG = "G3BrowserContext";
    private final SharedPreferences mSharedPreferences;

    private G3GeolocationPermissions mGeolocationPermissions;

    /** Pointer to the Native-side G3BrowserContext. */
    private long mNativeG3BrowserContext;
    private final boolean mIsDefault;

    public G3BrowserContext(
            SharedPreferences sharedPreferences, long nativeG3BrowserContext, boolean isDefault) {
        mNativeG3BrowserContext = nativeG3BrowserContext;
        mSharedPreferences = sharedPreferences;

        mIsDefault = isDefault;
        if (isDefaultG3BrowserContext()) {
            migrateGeolocationPreferences();
        }
    }

    @VisibleForTesting
    public void setNativePointer(long nativeG3BrowserContext) {
        mNativeG3BrowserContext = nativeG3BrowserContext;
    }

    public G3GeolocationPermissions getGeolocationPermissions() {
        if (mGeolocationPermissions == null) {
            mGeolocationPermissions = new G3GeolocationPermissions(mSharedPreferences);
        }
        return mGeolocationPermissions;
    }

    private void migrateGeolocationPreferences() {
        try (StrictModeContext ignored = StrictModeContext.allowDiskWrites()) {
            // Prefs dir will be created if it doesn't exist, so must allow writes
            // for this and so that the actual prefs can be written to the new
            // location if needed.
            final String oldGlobalPrefsName = "WebViewChromiumPrefs";
            SharedPreferences oldGlobalPrefs =
                    ContextUtils.getApplicationContext().getSharedPreferences(
                            oldGlobalPrefsName, Context.MODE_PRIVATE);
            G3GeolocationPermissions.migrateGeolocationPreferences(
                    oldGlobalPrefs, mSharedPreferences);
        }
    }

    public long getNativePointer() {
        return mNativeG3BrowserContext;
    }

    public boolean isDefaultG3BrowserContext() {
        return mIsDefault;
    }

    private static G3BrowserContext sInstance;
    public static G3BrowserContext getDefault() {
        if (sInstance == null) {
            sInstance = G3BrowserContextJni.get().getDefaultJava();
        }
        return sInstance;
    }

    @CalledByNative
    public static G3BrowserContext create(long nativeG3BrowserContext, boolean isDefault) {
        SharedPreferences sharedPreferences;
        try (StrictModeContext ignored = StrictModeContext.allowDiskWrites()) {
            // Prefs dir will be created if it doesn't exist, so must allow writes.
            sharedPreferences = ContextUtils.getApplicationContext().getSharedPreferences(
                    CHROMIUM_PREFS_NAME, Context.MODE_PRIVATE);
        }

        return new G3BrowserContext(sharedPreferences, nativeG3BrowserContext, isDefault);
    }

    @NativeMethods
    interface Natives {
        G3BrowserContext getDefaultJava();
    }
}
