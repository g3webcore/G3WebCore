package org.chromium.webview.g3webcore;

import java.lang.Override;
import java.lang.Runnable;
import java.lang.String;
import javax.annotation.Generated;
import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;

@Generated("org.chromium.jni_generator.JniProcessor")
@CheckDiscard("crbug.com/993421")
final class G3ContentsStaticsJni implements G3ContentsStatics.Natives {
  private static G3ContentsStatics.Natives testInstance;

  public static final JniStaticTestMocker<G3ContentsStatics.Natives> TEST_HOOKS = new org.chromium.base.JniStaticTestMocker<org.chromium.webview.g3webcore.G3ContentsStatics.Natives>() {
    @java.lang.Override
    public void setInstanceForTesting(
        org.chromium.webview.g3webcore.G3ContentsStatics.Natives instance) {
      if (!org.chromium.base.natives.GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void clearClientCertPreferences(Runnable callback) {
    GEN_JNI.org_chromium_webview_g3webcore_G3ContentsStatics_clearClientCertPreferences(callback);
  }

  @Override
  public String getUnreachableWebDataUrl() {
    return (String)GEN_JNI.org_chromium_webview_g3webcore_G3ContentsStatics_getUnreachableWebDataUrl();
  }

  @Override
  public String getProductVersion() {
    return (String)GEN_JNI.org_chromium_webview_g3webcore_G3ContentsStatics_getProductVersion();
  }

  @Override
  public void setCheckClearTextPermitted(boolean permitted) {
    GEN_JNI.org_chromium_webview_g3webcore_G3ContentsStatics_setCheckClearTextPermitted(permitted);
  }

  @Override
  public boolean isMultiProcessEnabled() {
    return (boolean)GEN_JNI.org_chromium_webview_g3webcore_G3ContentsStatics_isMultiProcessEnabled();
  }

  public static G3ContentsStatics.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.webview.g3webcore.G3ContentsStatics.Natives. The current configuration requires all native implementations to have a mock instance.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded(false);
    return new G3ContentsStaticsJni();
  }
}
