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
final class G3WebCoreJni implements G3WebCore.Natives {
  private static G3WebCore.Natives testInstance;

  public static final JniStaticTestMocker<G3WebCore.Natives> TEST_HOOKS = new org.chromium.base.JniStaticTestMocker<org.chromium.webview.g3webcore.G3WebCore.Natives>() {
    @java.lang.Override
    public void setInstanceForTesting(org.chromium.webview.g3webcore.G3WebCore.Natives instance) {
      if (!org.chromium.base.natives.GEN_JNI.TESTING_ENABLED) {
        throw new RuntimeException("Tried to set a JNI mock when mocks aren't enabled!");
      }
      testInstance = instance;
    }
  };

  @Override
  public long initNative(G3WebCore caller) {
    return (long)GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_initNative(caller);
  }

  @Override
  public void destroy(long nativeG3WebCore) {
    GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_destroy(nativeG3WebCore);
  }

  @Override
  public WebContents getWebContents(long nativeG3WebCore, G3WebCore caller) {
    return (WebContents)GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_getWebContents(nativeG3WebCore, caller);
  }

  @Override
  public G3BrowserContext getBrowserContext(long nativeG3WebCore, G3WebCore caller) {
    return (G3BrowserContext)GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_getBrowserContext(nativeG3WebCore, caller);
  }

  @Override
  public void setJavaPeers(long nativeG3WebCore, G3WebCore caller, G3WebCore g3WebCore,
      G3WebContentsDelegate webViewWebContentsDelegate, G3ContentsClientBridge contentsClientBridge,
      G3ContentsIoThreadClient ioThreadClient) {
    GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_setJavaPeers(nativeG3WebCore, caller, g3WebCore, webViewWebContentsDelegate, contentsClientBridge, ioThreadClient);
  }

  @Override
  public void insertVisualStateCallback(long nativeG3WebCore, G3WebCore caller, long requestId,
      G3WebCore.VisualStateCallback callback) {
    GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_insertVisualStateCallback(nativeG3WebCore, caller, requestId, callback);
  }

  @Override
  public void invokeGeolocationCallback(long nativeG3WebCore, G3WebCore caller, boolean value,
      String requestingFrame) {
    GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_invokeGeolocationCallback(nativeG3WebCore, caller, value, requestingFrame);
  }

  @Override
  public void addVisitedLinks(long nativeG3WebCore, G3WebCore caller, String[] visitedLinks) {
    GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_addVisitedLinks(nativeG3WebCore, caller, visitedLinks);
  }

  @Override
  public void clearCache(long nativeG3WebCore, G3WebCore caller, boolean includeDiskFiles) {
    GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_clearCache(nativeG3WebCore, caller, includeDiskFiles);
  }

  @Override
  public long releasePopupG3Contents(long nativeG3WebCore, G3WebCore caller) {
    return (long)GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_releasePopupG3Contents(nativeG3WebCore, caller);
  }

  @Override
  public void resumeLoadingCreatedPopupWebContents(long nativeG3WebCore, G3WebCore caller) {
    GEN_JNI.org_chromium_webview_g3webcore_G3WebCore_resumeLoadingCreatedPopupWebContents(nativeG3WebCore, caller);
  }

  public static G3WebCore.Natives get() {
    if (GEN_JNI.TESTING_ENABLED) {
      if (testInstance != null) {
        return testInstance;
      }
      if (GEN_JNI.REQUIRE_MOCK) {
        throw new UnsupportedOperationException("No mock found for the native implementation for org.chromium.webview.g3webcore.G3WebCore.Natives. The current configuration requires all native implementations to have a mock instance.");
      }
    }
    NativeLibraryLoadedStatus.checkLoaded(false);
    return new G3WebCoreJni();
  }
}
