package org.chromium.webview.g3webcore;

import android.app.Application;

import org.chromium.base.ContextUtils;
import org.chromium.base.PathUtils;
import org.chromium.base.library_loader.LibraryLoader;
import org.chromium.base.library_loader.LibraryProcessType;

public class G3WebCoreInitializer {

    private static final String PRIVATE_DATA_DIRECTORY_SUFFIX = "g3_web_core";

    public static void init(Application application) {
        boolean isBrowserProcess = !ContextUtils.getProcessName().contains(":");
        ContextUtils.initApplicationContext(application);
        LibraryLoader.getInstance().setLibraryProcessType(isBrowserProcess
                ? LibraryProcessType.PROCESS_BROWSER
                : LibraryProcessType.PROCESS_CHILD);
        if (isBrowserProcess) {
            PathUtils.setPrivateDataDirectorySuffix(PRIVATE_DATA_DIRECTORY_SUFFIX);
        }
    }

}
