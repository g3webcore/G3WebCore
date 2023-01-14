package org.chromium.webview.g3webcore;

import java.lang.Override;
import java.lang.String;
import java.security.PrivateKey;
import javax.annotation.Generated;
import org.chromium.base.JniStaticTestMocker;
import org.chromium.base.NativeLibraryLoadedStatus;
import org.chromium.base.annotations.CheckDiscard;
import org.chromium.base.natives.GEN_JNI;

@Generated("org.chromium.jni_generator.JniProcessor")
@CheckDiscard("crbug.com/993421")
final class G3ContentsClientBridgeJni implements G3ContentsClientBridge.Natives {
  private static G3ContentsClientBridge.Natives testInstance;

  public static final JniStaticTestMocker<G3ContentsClientBridge.Natives> TEST_HOOKS = new org.chromium.base.JniStaticTestMocker<org.chromium.webview.g3webcore.G3ContentsClientBridge.Natives>() {
    @java.lang.Override
    public void setInstanceForTesting(
        org.chromium.webview.g3webcore.G3ContentsClientBridge.Natives instance) {
      if (!org.chromium.base.natives.GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public void proceedSslError(long nativeG3ContentsClientBridge, G3ContentsClientBridge caller,
      boolean proceed, int id) {
    GEN_JNI.org_chromium_webview_g3webcore_G3ContentsClientBridge_proceedSslError(nativeG3ContentsClientBridge, caller, proceed, id);
  }

  @Override
  public void provideClientCertificateResponse(long nativeG3ContentsClientBridge,
      G3ContentsClientBridge caller, int id, byte[][] certChain, PrivateKey androidKey) {
    GEN_JNI.org_chromium_webview_g3webcore_G3ContentsClientBridge_provideClientCertificateResponse(nativeG3ContentsClientBridge, caller, id, certChain, androidKey);
  }

  @Override
  public void confirmJsResult(long nativeG3ContentsClientBridge, G3ContentsClientBridge caller,
      int id, String prompt) {
    GEN_JNI.org_chromium_webview_g3webcore_G3ContentsClientBridge_confirmJsResult(nativeG3ContentsClientBridge, caller, id, prompt);
  }

  @Override
  public void cancelJsResult(long nativeG3ContentsClientBridge, G3ContentsClientBridge caller,
      int id) {
    GEN_JNI.org_chromium_webview_g3webcore_G3ContentsClientBridge_cancelJsResult(nativeG3ContentsClientBridge, caller, id);
  }

  public static G3ContentsClientBridge.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.webview.g3webcore.G3ContentsClientBridge.Natives. The current configuration requires all native implementations to have a mock instance.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded(false);
    return new G3ContentsClientBridgeJni();
  }
}
