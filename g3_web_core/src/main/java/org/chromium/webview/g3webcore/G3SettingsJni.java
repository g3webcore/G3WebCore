package org.chromium.webview.g3webcore;

import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;
import org.chromium.content_public.browser.WebContents;

@Generated("org.chromium.jni_generator.JniProcessor")
@CheckDiscard("crbug.com/993421")
final class G3SettingsJni implements G3Settings.Natives {
  private static G3Settings.Natives testInstance;

  public static final JniStaticTestMocker<G3Settings.Natives> TEST_HOOKS = new org.chromium.base.JniStaticTestMocker<org.chromium.webview.g3webcore.G3Settings.Natives>() {
    @java.lang.Override
    public void setInstanceForTesting(org.chromium.webview.g3webcore.G3Settings.Natives instance) {
      if (!org.chromium.base.natives.GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public long init(G3Settings caller, WebContents webContents) {
    return (long)GEN_JNI.org_chromium_webview_g3webcore_G3Settings_init(caller, webContents);
  }

  @Override
  public void destroy(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_destroy(nativeG3Settings, caller);
  }

  @Override
  public void populateWebPreferencesLocked(long nativeG3Settings, G3Settings caller,
      long webPrefsPtr) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_populateWebPreferencesLocked(nativeG3Settings, caller, webPrefsPtr);
  }

  @Override
  public void resetScrollAndScaleState(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_resetScrollAndScaleState(nativeG3Settings, caller);
  }

  @Override
  public void updateEverythingLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateEverythingLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateInitialPageScaleLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateInitialPageScaleLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateUserAgentLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateUserAgentLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateWebkitPreferencesLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateWebkitPreferencesLocked(nativeG3Settings, caller);
  }

  @Override
  public String getDefaultUserAgent() {
    return (String)GEN_JNI.org_chromium_webview_g3webcore_G3Settings_getDefaultUserAgent();
  }

  @Override
  public void updateFormDataPreferencesLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateFormDataPreferencesLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateRendererPreferencesLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateRendererPreferencesLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateOffscreenPreRasterLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateOffscreenPreRasterLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateWillSuppressErrorStateLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateWillSuppressErrorStateLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateCookiePolicyLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateCookiePolicyLocked(nativeG3Settings, caller);
  }

  @Override
  public void updateAllowFileAccessLocked(long nativeG3Settings, G3Settings caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3Settings_updateAllowFileAccessLocked(nativeG3Settings, caller);
  }

  public static G3Settings.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.webview.g3webcore.G3Settings.Natives. The current configuration requires all native implementations to have a mock instance.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded(false);
    return new G3SettingsJni();
  }
}
