package org.chromium.webview.g3webcore;


import android.content.SharedPreferences;

import org.chromium.base.task.PostTask;
import org.chromium.content_public.browser.UiThreadTaskTraits;
import org.chromium.net.GURLUtils;

import java.util.HashSet;
import java.util.Set;

public final class G3GeolocationPermissions {

    private static final String PREF_PREFIX =
            "G3GeolocationPermissions%";
    private final SharedPreferences mSharedPreferences;

    public interface Callback {
        /* See {@link android.webkit.GeolocationPermissions}. */
        public void invoke(String origin, boolean allow, boolean retain);
    }

    public G3GeolocationPermissions(SharedPreferences sharedPreferences) {
        mSharedPreferences = sharedPreferences;
    }

    public void allow(String origin) {
        String key = getOriginKey(origin);
        if (key != null) {
            mSharedPreferences.edit().putBoolean(key, true).apply();
        }
    }

    public void deny(String origin) {
        String key = getOriginKey(origin);
        if (key != null) {
            mSharedPreferences.edit().putBoolean(key, false).apply();
        }
    }

    public void clear(String origin) {
        String key = getOriginKey(origin);
        if (key != null) {
            mSharedPreferences.edit().remove(key).apply();
        }
    }

    public void clearAll() {
        SharedPreferences.Editor editor = null;
        for (String name : mSharedPreferences.getAll().keySet()) {
            if (name.startsWith(PREF_PREFIX)) {
                if (editor == null) {
                    editor = mSharedPreferences.edit();
                }
                editor.remove(name);
            }
        }
        if (editor != null) {
            editor.apply();
        }
    }

    public boolean isOriginAllowed(String origin) {
        return mSharedPreferences.getBoolean(getOriginKey(origin), false);
    }

    public boolean hasOrigin(String origin) {
        return mSharedPreferences.contains(getOriginKey(origin));
    }

    public void getAllowed(String origin, final org.chromium.base.Callback<Boolean> callback) {
        final boolean finalAllowed = isOriginAllowed(origin);
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, () -> callback.onResult(finalAllowed));
    }

    public void getOrigins(final org.chromium.base.Callback<Set<String>> callback) {
        final Set<String> origins = new HashSet<String>();
        for (String name : mSharedPreferences.getAll().keySet()) {
            if (name.startsWith(PREF_PREFIX)) {
                origins.add(name.substring(PREF_PREFIX.length()));
            }
        }
        PostTask.postTask(UiThreadTaskTraits.DEFAULT, () -> callback.onResult(origins));
    }

    private String getOriginKey(String url) {
        String origin = GURLUtils.getOrigin(url);
        if (origin.isEmpty()) {
            return null;
        }

        return PREF_PREFIX + origin;
    }

    /* package */
    static void migrateGeolocationPreferences(
            SharedPreferences oldPrefs, SharedPreferences newPrefs) {
        SharedPreferences.Editor oldPrefsEditor = oldPrefs.edit();

        SharedPreferences.Editor newPrefsEditor = newPrefs.edit();

        for (String name : oldPrefs.getAll().keySet()) {
            if (name.startsWith(G3GeolocationPermissions.PREF_PREFIX)) {
                newPrefsEditor.putBoolean(name, oldPrefs.getBoolean(name, false)).apply();
                oldPrefsEditor.remove(name).apply();
            }
        }
    }
}
