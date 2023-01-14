package org.chromium.webview.g3webcore;

import java.lang.Override;
import javax.annotation.Generated;
import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;

@Generated("org.chromium.jni_generator.JniProcessor")
@CheckDiscard("crbug.com/993421")
final class G3BrowserContextJni implements G3BrowserContext.Natives {
  private static G3BrowserContext.Natives testInstance;

  public static final JniStaticTestMocker<G3BrowserContext.Natives> TEST_HOOKS = new org.chromium.base.JniStaticTestMocker<org.chromium.webview.g3webcore.G3BrowserContext.Natives>() {
    @java.lang.Override
    public void setInstanceForTesting(
        org.chromium.webview.g3webcore.G3BrowserContext.Natives instance) {
      if (!org.chromium.base.natives.GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public G3BrowserContext getDefaultJava() {
    return (G3BrowserContext)GEN_JNI.org_chromium_webview_g3webcore_G3BrowserContext_getDefaultJava();
  }

  public static G3BrowserContext.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.webview.g3webcore.G3BrowserContext.Natives. The current configuration requires all native implementations to have a mock instance.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded(false);
    return new G3BrowserContextJni();
  }
}
