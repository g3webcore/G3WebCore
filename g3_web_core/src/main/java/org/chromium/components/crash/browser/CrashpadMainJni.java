package org.chromium.components.crash.browser;

import java.lang.Override;
import java.lang.String;
import javax.annotation.Generated;
import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;

@Generated("org.chromium.jni_generator.JniProcessor")
@CheckDiscard("crbug.com/993421")
final class CrashpadMainJni implements CrashpadMain.Natives {
  private static CrashpadMain.Natives testInstance;

  public static final JniStaticTestMocker<CrashpadMain.Natives> TEST_HOOKS = new JniStaticTestMocker<org.chromium.components.crash.browser.CrashpadMain.Natives>() {
    @Override
    public void setInstanceForTesting(
        org.chromium.components.crash.browser.CrashpadMain.Natives instance) {
      if (!GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void crashpadMain(String[] argv) {
    GEN_JNI.org_chromium_components_crash_browser_CrashpadMain_crashpadMain(argv);
  }

  public static CrashpadMain.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.components.crash.browser.CrashpadMain.Natives. The current configuration requires all native implementations to have a mock instance.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded(false);
    return new CrashpadMainJni();
  }
}
