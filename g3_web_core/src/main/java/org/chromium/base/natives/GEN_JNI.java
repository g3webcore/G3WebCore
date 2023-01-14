package org.chromium.base.natives;

import java.lang.Class;
import java.lang.Object;
import java.lang.String;
import javax.annotation.Generated;

@Generated("org.chromium.jni_generator.JniProcessor")
public final class GEN_JNI {
  public static boolean TESTING_ENABLED;

  public static boolean REQUIRE_MOCK;


  /**
   * org.chromium.base.AnimationFrameTimeHistogram.saveHistogram
   * @param histogramName (java.lang.String)
   * @param frameTimesMs (long[])
   * @param count (int)
   * @return (void)
   */
  public static final native void org_chromium_base_AnimationFrameTimeHistogram_saveHistogram(
          String histogramName, long[] frameTimesMs, int count);

  /**
   * org.chromium.base.ApplicationStatus.onApplicationStateChange
   * @param newState (int)
   * @return (void)
   */
  public static final native void org_chromium_base_ApplicationStatus_onApplicationStateChange(
          int newState);

  /**
   * org.chromium.base.CommandLine.appendSwitch
   * @param switchString (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_CommandLine_appendSwitch(String switchString);

  /**
   * org.chromium.base.CommandLine.appendSwitchWithValue
   * @param switchString (java.lang.String)
   * @param value (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_CommandLine_appendSwitchWithValue(
          String switchString, String value);

  /**
   * org.chromium.base.CommandLine.appendSwitchesAndArguments
   * @param array (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_base_CommandLine_appendSwitchesAndArguments(
          String[] array);

  /**
   * org.chromium.base.CommandLine.getSwitchValue
   * @param switchString (java.lang.String)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_base_CommandLine_getSwitchValue(
          String switchString);

  /**
   * org.chromium.base.CommandLine.hasSwitch
   * @param switchString (java.lang.String)
   * @return (boolean)
   */
  public static final native boolean org_chromium_base_CommandLine_hasSwitch(String switchString);

  /**
   * org.chromium.base.CommandLine.init
   * @param args (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_base_CommandLine_init(String[] args);

  /**
   * org.chromium.base.CommandLine.removeSwitch
   * @param switchString (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_CommandLine_removeSwitch(String switchString);

  /**
   * org.chromium.base.CpuFeatures.getCoreCount
   * @return (int)
   */
  public static final native int org_chromium_base_CpuFeatures_getCoreCount();

  /**
   * org.chromium.base.CpuFeatures.getCpuFeatures
   * @return (long)
   */
  public static final native long org_chromium_base_CpuFeatures_getCpuFeatures();

  /**
   * org.chromium.base.EarlyTraceEvent.recordEarlyEvent
   * @param name (java.lang.String)
   * @param beginTimNanos (long)
   * @param endTimeNanos (long)
   * @param threadId (int)
   * @param threadDurationMillis (long)
   * @return (void)
   */
  public static final native void org_chromium_base_EarlyTraceEvent_recordEarlyEvent(String name,
                                                                                     long beginTimNanos, long endTimeNanos, int threadId, long threadDurationMillis);

  /**
   * org.chromium.base.EarlyTraceEvent.recordEarlyFinishAsyncEvent
   * @param name (java.lang.String)
   * @param id (long)
   * @param timestamp (long)
   * @return (void)
   */
  public static final native void org_chromium_base_EarlyTraceEvent_recordEarlyFinishAsyncEvent(
          String name, long id, long timestamp);

  /**
   * org.chromium.base.EarlyTraceEvent.recordEarlyStartAsyncEvent
   * @param name (java.lang.String)
   * @param id (long)
   * @param timestamp (long)
   * @return (void)
   */
  public static final native void org_chromium_base_EarlyTraceEvent_recordEarlyStartAsyncEvent(
          String name, long id, long timestamp);

  /**
   * org.chromium.base.FieldTrialList.findFullName
   * @param trialName (java.lang.String)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_base_FieldTrialList_findFullName(String trialName);

  /**
   * org.chromium.base.FieldTrialList.getVariationParameter
   * @param trialName (java.lang.String)
   * @param parameterKey (java.lang.String)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_base_FieldTrialList_getVariationParameter(
          String trialName, String parameterKey);

  /**
   * org.chromium.base.FieldTrialList.logActiveTrials
   * @return (void)
   */
  public static final native void org_chromium_base_FieldTrialList_logActiveTrials();

  /**
   * org.chromium.base.FieldTrialList.trialExists
   * @param trialName (java.lang.String)
   * @return (boolean)
   */
  public static final native boolean org_chromium_base_FieldTrialList_trialExists(String trialName);

  /**
   * org.chromium.base.ImportantFileWriterAndroid.writeFileAtomically
   * @param fileName (java.lang.String)
   * @param data (byte[])
   * @return (boolean)
   */
  public static final native boolean org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(
          String fileName, byte[] data);

  /**
   * org.chromium.base.JavaExceptionReporter.reportJavaException
   * @param crashAfterReport (boolean)
   * @param e (java.lang.Throwable)
   * @return (void)
   */
  public static final native void org_chromium_base_JavaExceptionReporter_reportJavaException(
          boolean crashAfterReport, Throwable e);

  /**
   * org.chromium.base.JavaExceptionReporter.reportJavaStackTrace
   * @param stackTrace (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(
          String stackTrace);

  /**
   * org.chromium.base.JavaHandlerThread.initializeThread
   * @param nativeJavaHandlerThread (long)
   * @param nativeEvent (long)
   * @return (void)
   */
  public static final native void org_chromium_base_JavaHandlerThread_initializeThread(
          long nativeJavaHandlerThread, long nativeEvent);

  /**
   * org.chromium.base.JavaHandlerThread.onLooperStopped
   * @param nativeJavaHandlerThread (long)
   * @return (void)
   */
  public static final native void org_chromium_base_JavaHandlerThread_onLooperStopped(
          long nativeJavaHandlerThread);

  /**
   * org.chromium.base.MemoryPressureListener.onMemoryPressure
   * @param pressure (int)
   * @return (void)
   */
  public static final native void org_chromium_base_MemoryPressureListener_onMemoryPressure(
          int pressure);

  /**
   * org.chromium.base.PathService.override
   * @param what (int)
   * @param path (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_PathService_override(int what, String path);

  /**
   * org.chromium.base.PowerMonitor.onBatteryChargingChanged
   * @return (void)
   */
  public static final native void org_chromium_base_PowerMonitor_onBatteryChargingChanged();

  /**
   * org.chromium.base.SysUtils.logPageFaultCountToTracing
   * @return (void)
   */
  public static final native void org_chromium_base_SysUtils_logPageFaultCountToTracing();

  /**
   * org.chromium.base.TimeUtils.getTimeTicksNowUs
   * @return (long)
   */
  public static final native long org_chromium_base_TimeUtils_getTimeTicksNowUs();

  /**
   * org.chromium.base.TraceEvent.begin
   * @param name (java.lang.String)
   * @param arg (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_begin(String name, String arg);

  /**
   * org.chromium.base.TraceEvent.beginToplevel
   * @param target (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_beginToplevel(String target);

  /**
   * org.chromium.base.TraceEvent.end
   * @param name (java.lang.String)
   * @param arg (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_end(String name, String arg);

  /**
   * org.chromium.base.TraceEvent.endToplevel
   * @param target (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_endToplevel(String target);

  /**
   * org.chromium.base.TraceEvent.finishAsync
   * @param name (java.lang.String)
   * @param id (long)
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_finishAsync(String name, long id);

  /**
   * org.chromium.base.TraceEvent.instant
   * @param name (java.lang.String)
   * @param arg (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_instant(String name, String arg);

  /**
   * org.chromium.base.TraceEvent.registerEnabledObserver
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_registerEnabledObserver();

  /**
   * org.chromium.base.TraceEvent.startATrace
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_startATrace();

  /**
   * org.chromium.base.TraceEvent.startAsync
   * @param name (java.lang.String)
   * @param id (long)
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_startAsync(String name, long id);

  /**
   * org.chromium.base.TraceEvent.stopATrace
   * @return (void)
   */
  public static final native void org_chromium_base_TraceEvent_stopATrace();

  /**
   * org.chromium.base.library_loader.LibraryLoader.getVersionNumber
   * @return (java.lang.String)
   */
  public static final native String org_chromium_base_library_1loader_LibraryLoader_getVersionNumber(
  );

  /**
   * org.chromium.base.library_loader.LibraryLoader.libraryLoaded
   * @param processType (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_base_library_1loader_LibraryLoader_libraryLoaded(
          int processType);

  /**
   * org.chromium.base.library_loader.LibraryLoader.recordRendererLibraryLoadTime
   * @param libraryLoadTime (long)
   * @return (void)
   */
  public static final native void org_chromium_base_library_1loader_LibraryLoader_recordRendererLibraryLoadTime(
          long libraryLoadTime);

  /**
   * org.chromium.base.library_loader.LibraryLoader.registerNonMainDexJni
   * @return (void)
   */
  public static final native void org_chromium_base_library_1loader_LibraryLoader_registerNonMainDexJni(
  );

  /**
   * org.chromium.base.library_loader.LibraryPrefetcher.forkAndPrefetchNativeLibrary
   * @return (void)
   */
  public static final native void org_chromium_base_library_1loader_LibraryPrefetcher_forkAndPrefetchNativeLibrary(
  );

  /**
   * org.chromium.base.library_loader.LibraryPrefetcher.percentageOfResidentNativeLibraryCode
   * @return (int)
   */
  public static final native int org_chromium_base_library_1loader_LibraryPrefetcher_percentageOfResidentNativeLibraryCode(
  );

  /**
   * org.chromium.base.library_loader.LibraryPrefetcher.periodicallyCollectResidency
   * @return (void)
   */
  public static final native void org_chromium_base_library_1loader_LibraryPrefetcher_periodicallyCollectResidency(
  );

  /**
   * org.chromium.base.metrics.NativeUmaRecorder.recordBooleanHistogram
   * @param name (java.lang.String)
   * @param nativeHint (long)
   * @param sample (boolean)
   * @return (long)
   */
  public static final native long org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(
          String name, long nativeHint, boolean sample);

  /**
   * org.chromium.base.metrics.NativeUmaRecorder.recordExponentialHistogram
   * @param name (java.lang.String)
   * @param nativeHint (long)
   * @param sample (int)
   * @param min (int)
   * @param max (int)
   * @param numBuckets (int)
   * @return (long)
   */
  public static final native long org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(
          String name, long nativeHint, int sample, int min, int max, int numBuckets);

  /**
   * org.chromium.base.metrics.NativeUmaRecorder.recordLinearHistogram
   * @param name (java.lang.String)
   * @param nativeHint (long)
   * @param sample (int)
   * @param min (int)
   * @param max (int)
   * @param numBuckets (int)
   * @return (long)
   */
  public static final native long org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(
          String name, long nativeHint, int sample, int min, int max, int numBuckets);

  /**
   * org.chromium.base.metrics.NativeUmaRecorder.recordSparseHistogram
   * @param name (java.lang.String)
   * @param nativeHint (long)
   * @param sample (int)
   * @return (long)
   */
  public static final native long org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(
          String name, long nativeHint, int sample);

  /**
   * org.chromium.base.metrics.RecordHistogram.getHistogramTotalCountForTesting
   * @param name (java.lang.String)
   * @return (int)
   */
  public static final native int org_chromium_base_metrics_RecordHistogram_getHistogramTotalCountForTesting(
          String name);

  /**
   * org.chromium.base.metrics.RecordHistogram.getHistogramValueCountForTesting
   * @param name (java.lang.String)
   * @param sample (int)
   * @return (int)
   */
  public static final native int org_chromium_base_metrics_RecordHistogram_getHistogramValueCountForTesting(
          String name, int sample);

  /**
   * org.chromium.base.metrics.RecordUserAction.addActionCallbackForTesting
   * @param callback (org.chromium.base.metrics.RecordUserAction.UserActionCallback)
   * @return (long)
   */
  public static final native long org_chromium_base_metrics_RecordUserAction_addActionCallbackForTesting(
          Object callback);

  /**
   * org.chromium.base.metrics.RecordUserAction.recordUserAction
   * @param action (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_base_metrics_RecordUserAction_recordUserAction(
          String action);

  /**
   * org.chromium.base.metrics.RecordUserAction.removeActionCallbackForTesting
   * @param callbackId (long)
   * @return (void)
   */
  public static final native void org_chromium_base_metrics_RecordUserAction_removeActionCallbackForTesting(
          long callbackId);

  /**
   * org.chromium.base.metrics.StatisticsRecorderAndroid.toJson
   * @param verbosityLevel (int)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(
          int verbosityLevel);

  /**
   * org.chromium.base.process_launcher.ChildProcessService.dumpProcessStack
   * @return (void)
   */
  public static final native void org_chromium_base_process_1launcher_ChildProcessService_dumpProcessStack(
  );

  /**
   * org.chromium.base.process_launcher.ChildProcessService.exitChildProcess
   * @return (void)
   */
  public static final native void org_chromium_base_process_1launcher_ChildProcessService_exitChildProcess(
  );

  /**
   * org.chromium.base.process_launcher.ChildProcessService.registerFileDescriptors
   * @param keys (java.lang.String[])
   * @param id (int[])
   * @param fd (int[])
   * @param offset (long[])
   * @param size (long[])
   * @return (void)
   */
  public static final native void org_chromium_base_process_1launcher_ChildProcessService_registerFileDescriptors(
          String[] keys, int[] id, int[] fd, long[] offset, long[] size);

  /**
   * org.chromium.base.task.PostTask.postDelayedTask
   * @param prioritySetExplicitly (boolean)
   * @param priority (int)
   * @param mayBlock (boolean)
   * @param useThreadPool (boolean)
   * @param extensionId (byte)
   * @param extensionData (byte[])
   * @param task (java.lang.Runnable)
   * @param delay (long)
   * @return (void)
   */
  public static final native void org_chromium_base_task_PostTask_postDelayedTask(
          boolean prioritySetExplicitly, int priority, boolean mayBlock, boolean useThreadPool,
          byte extensionId, byte[] extensionData, Object task, long delay);

  /**
   * org.chromium.base.task.TaskRunnerImpl.belongsToCurrentThread
   * @param nativeTaskRunnerAndroid (long)
   * @return (boolean)
   */
  public static final native boolean org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(
          long nativeTaskRunnerAndroid);

  /**
   * org.chromium.base.task.TaskRunnerImpl.destroy
   * @param nativeTaskRunnerAndroid (long)
   * @return (void)
   */
  public static final native void org_chromium_base_task_TaskRunnerImpl_destroy(
          long nativeTaskRunnerAndroid);

  /**
   * org.chromium.base.task.TaskRunnerImpl.init
   * @param taskRunnerType (int)
   * @param prioritySetExplicitly (boolean)
   * @param priority (int)
   * @param mayBlock (boolean)
   * @param useThreadPool (boolean)
   * @param extensionId (byte)
   * @param extensionData (byte[])
   * @return (long)
   */
  public static final native long org_chromium_base_task_TaskRunnerImpl_init(int taskRunnerType,
                                                                             boolean prioritySetExplicitly, int priority, boolean mayBlock, boolean useThreadPool,
                                                                             byte extensionId, byte[] extensionData);

  /**
   * org.chromium.base.task.TaskRunnerImpl.postDelayedTask
   * @param nativeTaskRunnerAndroid (long)
   * @param task (java.lang.Runnable)
   * @param delay (long)
   * @return (void)
   */
  public static final native void org_chromium_base_task_TaskRunnerImpl_postDelayedTask(
          long nativeTaskRunnerAndroid, Object task, long delay);

  /**
   * org.chromium.content.app.ContentChildProcessServiceDelegate.initChildProcess
   * @param caller (org.chromium.content.app.ContentChildProcessServiceDelegate)
   * @param cpuCount (int)
   * @param cpuFeatures (long)
   * @return (void)
   */
  public static final native void org_chromium_content_app_ContentChildProcessServiceDelegate_initChildProcess(
      Object caller, int cpuCount, long cpuFeatures);

  /**
   * org.chromium.content.app.ContentChildProcessServiceDelegate.retrieveFileDescriptorsIdsToKeys
   * @param caller (org.chromium.content.app.ContentChildProcessServiceDelegate)
   * @return (void)
   */
  public static final native void org_chromium_content_app_ContentChildProcessServiceDelegate_retrieveFileDescriptorsIdsToKeys(
      Object caller);

  /**
   * org.chromium.content.app.ContentMain.start
   * @param startServiceManagerOnly (boolean)
   * @return (int)
   */
  public static final native int org_chromium_content_app_ContentMain_start(
      boolean startServiceManagerOnly);

  /**
   * org.chromium.content.browser.AppWebMessagePort.decodeStringMessage
   * @param encodedData (byte[])
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_AppWebMessagePort_decodeStringMessage(
      byte[] encodedData);

  /**
   * org.chromium.content.browser.AppWebMessagePort.encodeStringMessage
   * @param message (java.lang.String)
   * @return (byte[])
   */
  public static final native byte[] org_chromium_content_browser_AppWebMessagePort_encodeStringMessage(
      String message);

  /**
   * org.chromium.content.browser.AppWebMessagePortDescriptor.closeAndDestroy
   * @param blinkMessagePortDescriptor (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_AppWebMessagePortDescriptor_closeAndDestroy(
      long blinkMessagePortDescriptor);

  /**
   * org.chromium.content.browser.AppWebMessagePortDescriptor.create
   * @param nativeHandle (int)
   * @param idLow (long)
   * @param idHigh (long)
   * @param sequenceNumber (long)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_AppWebMessagePortDescriptor_create(
      int nativeHandle, long idLow, long idHigh, long sequenceNumber);

  /**
   * org.chromium.content.browser.AppWebMessagePortDescriptor.createPair
   * @return (long[])
   */
  public static final native long[] org_chromium_content_browser_AppWebMessagePortDescriptor_createPair(
      );

  /**
   * org.chromium.content.browser.AppWebMessagePortDescriptor.giveDisentangledHandle
   * @param blinkMessagePortDescriptor (long)
   * @param nativeHandle (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_AppWebMessagePortDescriptor_giveDisentangledHandle(
      long blinkMessagePortDescriptor, int nativeHandle);

  /**
   * org.chromium.content.browser.AppWebMessagePortDescriptor.passSerialized
   * @param blinkMessagePortDescriptor (long)
   * @return (long[])
   */
  public static final native long[] org_chromium_content_browser_AppWebMessagePortDescriptor_passSerialized(
      long blinkMessagePortDescriptor);

  /**
   * org.chromium.content.browser.AppWebMessagePortDescriptor.takeHandleToEntangle
   * @param blinkMessagePortDescriptor (long)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_AppWebMessagePortDescriptor_takeHandleToEntangle(
      long blinkMessagePortDescriptor);

  /**
   * org.chromium.content.browser.AudioFocusDelegate.onResume
   * @param nativeAudioFocusDelegateAndroid (long)
   * @param caller (org.chromium.content.browser.AudioFocusDelegate)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_AudioFocusDelegate_onResume(
      long nativeAudioFocusDelegateAndroid, Object caller);

  /**
   * org.chromium.content.browser.AudioFocusDelegate.onStartDucking
   * @param nativeAudioFocusDelegateAndroid (long)
   * @param caller (org.chromium.content.browser.AudioFocusDelegate)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_AudioFocusDelegate_onStartDucking(
      long nativeAudioFocusDelegateAndroid, Object caller);

  /**
   * org.chromium.content.browser.AudioFocusDelegate.onStopDucking
   * @param nativeAudioFocusDelegateAndroid (long)
   * @param caller (org.chromium.content.browser.AudioFocusDelegate)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_AudioFocusDelegate_onStopDucking(
      long nativeAudioFocusDelegateAndroid, Object caller);

  /**
   * org.chromium.content.browser.AudioFocusDelegate.onSuspend
   * @param nativeAudioFocusDelegateAndroid (long)
   * @param caller (org.chromium.content.browser.AudioFocusDelegate)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_AudioFocusDelegate_onSuspend(
      long nativeAudioFocusDelegateAndroid, Object caller);

  /**
   * org.chromium.content.browser.AudioFocusDelegate.recordSessionDuck
   * @param nativeAudioFocusDelegateAndroid (long)
   * @param caller (org.chromium.content.browser.AudioFocusDelegate)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_AudioFocusDelegate_recordSessionDuck(
      long nativeAudioFocusDelegateAndroid, Object caller);

  /**
   * org.chromium.content.browser.BackgroundSyncNetworkObserver.notifyConnectionTypeChanged
   * @param nativePtr (long)
   * @param caller (org.chromium.content.browser.BackgroundSyncNetworkObserver)
   * @param newConnectionType (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_BackgroundSyncNetworkObserver_notifyConnectionTypeChanged(
      long nativePtr, Object caller, int newConnectionType);

  /**
   * org.chromium.content.browser.BrowserStartupControllerImpl.flushStartupTasks
   * @return (void)
   */
  public static final native void org_chromium_content_browser_BrowserStartupControllerImpl_flushStartupTasks(
      );

  /**
   * org.chromium.content.browser.BrowserStartupControllerImpl.isOfficialBuild
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_BrowserStartupControllerImpl_isOfficialBuild(
      );

  /**
   * org.chromium.content.browser.BrowserStartupControllerImpl.setCommandLineFlags
   * @param singleProcess (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_BrowserStartupControllerImpl_setCommandLineFlags(
      boolean singleProcess);

  /**
   * org.chromium.content.browser.ChildProcessLauncherHelperImpl.onChildProcessStarted
   * @param nativeChildProcessLauncherHelper (long)
   * @param pid (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ChildProcessLauncherHelperImpl_onChildProcessStarted(
      long nativeChildProcessLauncherHelper, int pid);

  /**
   * org.chromium.content.browser.ChildProcessLauncherHelperImpl.setTerminationInfo
   * @param termiantionInfoPtr (long)
   * @param bindingState (int)
   * @param killedByUs (boolean)
   * @param cleanExit (boolean)
   * @param remainingStrong (int)
   * @param remainingModerate (int)
   * @param remainingWaived (int)
   * @param reverseRank (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ChildProcessLauncherHelperImpl_setTerminationInfo(
      long termiantionInfoPtr, int bindingState, boolean killedByUs, boolean cleanExit,
      int remainingStrong, int remainingModerate, int remainingWaived, int reverseRank);

  /**
   * org.chromium.content.browser.ContactsDialogHost.addContact
   * @param nativeContactsProviderAndroid (long)
   * @param names (java.lang.String[])
   * @param emails (java.lang.String[])
   * @param tel (java.lang.String[])
   * @param addresses (java.nio.ByteBuffer[])
   * @param icons (java.nio.ByteBuffer[])
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContactsDialogHost_addContact(
      long nativeContactsProviderAndroid, String[] names, String[] emails, String[] tel,
      Object[] addresses, Object[] icons);

  /**
   * org.chromium.content.browser.ContactsDialogHost.endContactsList
   * @param nativeContactsProviderAndroid (long)
   * @param percentageShared (int)
   * @param propertiesRequested (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContactsDialogHost_endContactsList(
      long nativeContactsProviderAndroid, int percentageShared, int propertiesRequested);

  /**
   * org.chromium.content.browser.ContactsDialogHost.endWithPermissionDenied
   * @param nativeContactsProviderAndroid (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContactsDialogHost_endWithPermissionDenied(
      long nativeContactsProviderAndroid);

  /**
   * org.chromium.content.browser.ContentFeatureListImpl.isEnabled
   * @param featureName (java.lang.String)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_ContentFeatureListImpl_isEnabled(
      String featureName);

  /**
   * org.chromium.content.browser.ContentUiEventHandler.cancelFling
   * @param nativeContentUiEventHandler (long)
   * @param caller (org.chromium.content.browser.ContentUiEventHandler)
   * @param timeMs (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContentUiEventHandler_cancelFling(
      long nativeContentUiEventHandler, Object caller, long timeMs);

  /**
   * org.chromium.content.browser.ContentUiEventHandler.init
   * @param caller (org.chromium.content.browser.ContentUiEventHandler)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_ContentUiEventHandler_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.browser.ContentUiEventHandler.sendMouseEvent
   * @param nativeContentUiEventHandler (long)
   * @param caller (org.chromium.content.browser.ContentUiEventHandler)
   * @param timeMs (long)
   * @param action (int)
   * @param x (float)
   * @param y (float)
   * @param pointerId (int)
   * @param pressure (float)
   * @param orientation (float)
   * @param tilt (float)
   * @param changedButton (int)
   * @param buttonState (int)
   * @param metaState (int)
   * @param toolType (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContentUiEventHandler_sendMouseEvent(
      long nativeContentUiEventHandler, Object caller, long timeMs, int action, float x, float y,
      int pointerId, float pressure, float orientation, float tilt, int changedButton,
      int buttonState, int metaState, int toolType);

  /**
   * org.chromium.content.browser.ContentUiEventHandler.sendMouseWheelEvent
   * @param nativeContentUiEventHandler (long)
   * @param caller (org.chromium.content.browser.ContentUiEventHandler)
   * @param timeMs (long)
   * @param x (float)
   * @param y (float)
   * @param ticksX (float)
   * @param ticksY (float)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContentUiEventHandler_sendMouseWheelEvent(
      long nativeContentUiEventHandler, Object caller, long timeMs, float x, float y, float ticksX,
      float ticksY);

  /**
   * org.chromium.content.browser.ContentUiEventHandler.sendScrollEvent
   * @param nativeContentUiEventHandler (long)
   * @param caller (org.chromium.content.browser.ContentUiEventHandler)
   * @param timeMs (long)
   * @param deltaX (float)
   * @param deltaY (float)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContentUiEventHandler_sendScrollEvent(
      long nativeContentUiEventHandler, Object caller, long timeMs, float deltaX, float deltaY);

  /**
   * org.chromium.content.browser.ContentViewStaticsImpl.setWebKitSharedTimersSuspended
   * @param suspend (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_ContentViewStaticsImpl_setWebKitSharedTimersSuspended(
      boolean suspend);

  /**
   * org.chromium.content.browser.GestureListenerManagerImpl.init
   * @param caller (org.chromium.content.browser.GestureListenerManagerImpl)
   * @param webContents (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_GestureListenerManagerImpl_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.browser.GestureListenerManagerImpl.resetGestureDetection
   * @param nativeGestureListenerManager (long)
   * @param caller (org.chromium.content.browser.GestureListenerManagerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_GestureListenerManagerImpl_resetGestureDetection(
      long nativeGestureListenerManager, Object caller);

  /**
   * org.chromium.content.browser.GestureListenerManagerImpl.setDoubleTapSupportEnabled
   * @param nativeGestureListenerManager (long)
   * @param caller (org.chromium.content.browser.GestureListenerManagerImpl)
   * @param enabled (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_GestureListenerManagerImpl_setDoubleTapSupportEnabled(
      long nativeGestureListenerManager, Object caller, boolean enabled);

  /**
   * org.chromium.content.browser.GestureListenerManagerImpl.setMultiTouchZoomSupportEnabled
   * @param nativeGestureListenerManager (long)
   * @param caller (org.chromium.content.browser.GestureListenerManagerImpl)
   * @param enabled (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_GestureListenerManagerImpl_setMultiTouchZoomSupportEnabled(
      long nativeGestureListenerManager, Object caller, boolean enabled);

  /**
   * org.chromium.content.browser.GpuProcessCallback.completeScopedSurfaceRequest
   * @param requestToken (org.chromium.base.UnguessableToken)
   * @param surface (android.view.Surface)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_GpuProcessCallback_completeScopedSurfaceRequest(
      Object requestToken, Object surface);

  /**
   * org.chromium.content.browser.GpuProcessCallback.getViewSurface
   * @param surfaceId (int)
   * @return (org.chromium.content.common.SurfaceWrapper)
   */
  public static final native Object org_chromium_content_browser_GpuProcessCallback_getViewSurface(
      int surfaceId);

  /**
   * org.chromium.content.browser.JavascriptInjectorImpl.addInterface
   * @param nativeJavascriptInjector (long)
   * @param caller (org.chromium.content.browser.JavascriptInjectorImpl)
   * @param object (java.lang.Object)
   * @param name (java.lang.String)
   * @param requiredAnnotation (java.lang.Class)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_JavascriptInjectorImpl_addInterface(
      long nativeJavascriptInjector, Object caller, Object object, String name,
      Class requiredAnnotation);

  /**
   * org.chromium.content.browser.JavascriptInjectorImpl.init
   * @param caller (org.chromium.content.browser.JavascriptInjectorImpl)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @param retainedObjects (java.lang.Object)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_JavascriptInjectorImpl_init(
      Object caller, Object webContents, Object retainedObjects);

  /**
   * org.chromium.content.browser.JavascriptInjectorImpl.removeInterface
   * @param nativeJavascriptInjector (long)
   * @param caller (org.chromium.content.browser.JavascriptInjectorImpl)
   * @param name (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_JavascriptInjectorImpl_removeInterface(
      long nativeJavascriptInjector, Object caller, String name);

  /**
   * org.chromium.content.browser.JavascriptInjectorImpl.setAllowInspection
   * @param nativeJavascriptInjector (long)
   * @param caller (org.chromium.content.browser.JavascriptInjectorImpl)
   * @param allow (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_JavascriptInjectorImpl_setAllowInspection(
      long nativeJavascriptInjector, Object caller, boolean allow);

  /**
   * org.chromium.content.browser.MediaSessionImpl.didReceiveAction
   * @param nativeMediaSessionAndroid (long)
   * @param caller (org.chromium.content.browser.MediaSessionImpl)
   * @param action (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_MediaSessionImpl_didReceiveAction(
      long nativeMediaSessionAndroid, Object caller, int action);

  /**
   * org.chromium.content.browser.MediaSessionImpl.getMediaSessionFromWebContents
   * @param contents (org.chromium.content_public.browser.WebContents)
   * @return (org.chromium.content.browser.MediaSessionImpl)
   */
  public static final native Object org_chromium_content_browser_MediaSessionImpl_getMediaSessionFromWebContents(
      Object contents);

  /**
   * org.chromium.content.browser.MediaSessionImpl.requestSystemAudioFocus
   * @param nativeMediaSessionAndroid (long)
   * @param caller (org.chromium.content.browser.MediaSessionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_MediaSessionImpl_requestSystemAudioFocus(
      long nativeMediaSessionAndroid, Object caller);

  /**
   * org.chromium.content.browser.MediaSessionImpl.resume
   * @param nativeMediaSessionAndroid (long)
   * @param caller (org.chromium.content.browser.MediaSessionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_MediaSessionImpl_resume(
      long nativeMediaSessionAndroid, Object caller);

  /**
   * org.chromium.content.browser.MediaSessionImpl.seek
   * @param nativeMediaSessionAndroid (long)
   * @param caller (org.chromium.content.browser.MediaSessionImpl)
   * @param millis (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_MediaSessionImpl_seek(
      long nativeMediaSessionAndroid, Object caller, long millis);

  /**
   * org.chromium.content.browser.MediaSessionImpl.seekTo
   * @param nativeMediaSessionAndroid (long)
   * @param caller (org.chromium.content.browser.MediaSessionImpl)
   * @param millis (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_MediaSessionImpl_seekTo(
      long nativeMediaSessionAndroid, Object caller, long millis);

  /**
   * org.chromium.content.browser.MediaSessionImpl.stop
   * @param nativeMediaSessionAndroid (long)
   * @param caller (org.chromium.content.browser.MediaSessionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_MediaSessionImpl_stop(
      long nativeMediaSessionAndroid, Object caller);

  /**
   * org.chromium.content.browser.MediaSessionImpl.suspend
   * @param nativeMediaSessionAndroid (long)
   * @param caller (org.chromium.content.browser.MediaSessionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_MediaSessionImpl_suspend(
      long nativeMediaSessionAndroid, Object caller);

  /**
   * org.chromium.content.browser.RenderWidgetHostViewImpl.dismissTextHandles
   * @param nativeRenderWidgetHostViewAndroid (long)
   * @param caller (org.chromium.content.browser.RenderWidgetHostViewImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_RenderWidgetHostViewImpl_dismissTextHandles(
      long nativeRenderWidgetHostViewAndroid, Object caller);

  /**
   * org.chromium.content.browser.RenderWidgetHostViewImpl.getBackgroundColor
   * @param nativeRenderWidgetHostViewAndroid (long)
   * @param caller (org.chromium.content.browser.RenderWidgetHostViewImpl)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_RenderWidgetHostViewImpl_getBackgroundColor(
      long nativeRenderWidgetHostViewAndroid, Object caller);

  /**
   * org.chromium.content.browser.RenderWidgetHostViewImpl.isReady
   * @param nativeRenderWidgetHostViewAndroid (long)
   * @param caller (org.chromium.content.browser.RenderWidgetHostViewImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_RenderWidgetHostViewImpl_isReady(
      long nativeRenderWidgetHostViewAndroid, Object caller);

  /**
   * org.chromium.content.browser.RenderWidgetHostViewImpl.onViewportInsetBottomChanged
   * @param nativeRenderWidgetHostViewAndroid (long)
   * @param caller (org.chromium.content.browser.RenderWidgetHostViewImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_RenderWidgetHostViewImpl_onViewportInsetBottomChanged(
      long nativeRenderWidgetHostViewAndroid, Object caller);

  /**
   * org.chromium.content.browser.RenderWidgetHostViewImpl.showContextMenuAtTouchHandle
   * @param nativeRenderWidgetHostViewAndroid (long)
   * @param caller (org.chromium.content.browser.RenderWidgetHostViewImpl)
   * @param x (int)
   * @param y (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_RenderWidgetHostViewImpl_showContextMenuAtTouchHandle(
      long nativeRenderWidgetHostViewAndroid, Object caller, int x, int y);

  /**
   * org.chromium.content.browser.RenderWidgetHostViewImpl.writeContentBitmapToDiskAsync
   * @param nativeRenderWidgetHostViewAndroid (long)
   * @param caller (org.chromium.content.browser.RenderWidgetHostViewImpl)
   * @param width (int)
   * @param height (int)
   * @param path (java.lang.String)
   * @param callback (org.chromium.base.Callback<java.lang.String>)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_RenderWidgetHostViewImpl_writeContentBitmapToDiskAsync(
      long nativeRenderWidgetHostViewAndroid, Object caller, int width, int height, String path,
      Object callback);

  /**
   * org.chromium.content.browser.SpeechRecognitionImpl.onAudioEnd
   * @param nativeSpeechRecognizerImplAndroid (long)
   * @param caller (org.chromium.content.browser.SpeechRecognitionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_SpeechRecognitionImpl_onAudioEnd(
      long nativeSpeechRecognizerImplAndroid, Object caller);

  /**
   * org.chromium.content.browser.SpeechRecognitionImpl.onAudioStart
   * @param nativeSpeechRecognizerImplAndroid (long)
   * @param caller (org.chromium.content.browser.SpeechRecognitionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_SpeechRecognitionImpl_onAudioStart(
      long nativeSpeechRecognizerImplAndroid, Object caller);

  /**
   * org.chromium.content.browser.SpeechRecognitionImpl.onRecognitionEnd
   * @param nativeSpeechRecognizerImplAndroid (long)
   * @param caller (org.chromium.content.browser.SpeechRecognitionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_SpeechRecognitionImpl_onRecognitionEnd(
      long nativeSpeechRecognizerImplAndroid, Object caller);

  /**
   * org.chromium.content.browser.SpeechRecognitionImpl.onRecognitionError
   * @param nativeSpeechRecognizerImplAndroid (long)
   * @param caller (org.chromium.content.browser.SpeechRecognitionImpl)
   * @param error (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_SpeechRecognitionImpl_onRecognitionError(
      long nativeSpeechRecognizerImplAndroid, Object caller, int error);

  /**
   * org.chromium.content.browser.SpeechRecognitionImpl.onRecognitionResults
   * @param nativeSpeechRecognizerImplAndroid (long)
   * @param caller (org.chromium.content.browser.SpeechRecognitionImpl)
   * @param results (java.lang.String[])
   * @param scores (float[])
   * @param provisional (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_SpeechRecognitionImpl_onRecognitionResults(
      long nativeSpeechRecognizerImplAndroid, Object caller, String[] results, float[] scores,
      boolean provisional);

  /**
   * org.chromium.content.browser.SpeechRecognitionImpl.onSoundEnd
   * @param nativeSpeechRecognizerImplAndroid (long)
   * @param caller (org.chromium.content.browser.SpeechRecognitionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_SpeechRecognitionImpl_onSoundEnd(
      long nativeSpeechRecognizerImplAndroid, Object caller);

  /**
   * org.chromium.content.browser.SpeechRecognitionImpl.onSoundStart
   * @param nativeSpeechRecognizerImplAndroid (long)
   * @param caller (org.chromium.content.browser.SpeechRecognitionImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_SpeechRecognitionImpl_onSoundStart(
      long nativeSpeechRecognizerImplAndroid, Object caller);

  /**
   * org.chromium.content.browser.TracingControllerAndroidImpl.destroy
   * @param nativeTracingControllerAndroid (long)
   * @param caller (org.chromium.content.browser.TracingControllerAndroidImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_TracingControllerAndroidImpl_destroy(
      long nativeTracingControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.TracingControllerAndroidImpl.getDefaultCategories
   * @param caller (org.chromium.content.browser.TracingControllerAndroidImpl)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_TracingControllerAndroidImpl_getDefaultCategories(
      Object caller);

  /**
   * org.chromium.content.browser.TracingControllerAndroidImpl.getKnownCategoriesAsync
   * @param nativeTracingControllerAndroid (long)
   * @param caller (org.chromium.content.browser.TracingControllerAndroidImpl)
   * @param callback (org.chromium.base.Callback<java.lang.String[]>)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_TracingControllerAndroidImpl_getKnownCategoriesAsync(
      long nativeTracingControllerAndroid, Object caller, Object callback);

  /**
   * org.chromium.content.browser.TracingControllerAndroidImpl.getTraceBufferUsageAsync
   * @param nativeTracingControllerAndroid (long)
   * @param caller (org.chromium.content.browser.TracingControllerAndroidImpl)
   * @param callback (org.chromium.base.Callback<android.util.Pair<java.lang.Float, java.lang.Long>>)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_TracingControllerAndroidImpl_getTraceBufferUsageAsync(
      long nativeTracingControllerAndroid, Object caller, Object callback);

  /**
   * org.chromium.content.browser.TracingControllerAndroidImpl.init
   * @param caller (org.chromium.content.browser.TracingControllerAndroidImpl)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_TracingControllerAndroidImpl_init(
      Object caller);

  /**
   * org.chromium.content.browser.TracingControllerAndroidImpl.startTracing
   * @param nativeTracingControllerAndroid (long)
   * @param caller (org.chromium.content.browser.TracingControllerAndroidImpl)
   * @param categories (java.lang.String)
   * @param traceOptions (java.lang.String)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_TracingControllerAndroidImpl_startTracing(
      long nativeTracingControllerAndroid, Object caller, String categories, String traceOptions);

  /**
   * org.chromium.content.browser.TracingControllerAndroidImpl.stopTracing
   * @param nativeTracingControllerAndroid (long)
   * @param caller (org.chromium.content.browser.TracingControllerAndroidImpl)
   * @param filename (java.lang.String)
   * @param compressFile (boolean)
   * @param callback (org.chromium.base.Callback<java.lang.Void>)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_TracingControllerAndroidImpl_stopTracing(
      long nativeTracingControllerAndroid, Object caller, String filename, boolean compressFile,
      Object callback);

  /**
   * org.chromium.content.browser.TtsPlatformImpl.onEndEvent
   * @param nativeTtsPlatformImplAndroid (long)
   * @param caller (org.chromium.content.browser.TtsPlatformImpl)
   * @param utteranceId (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_TtsPlatformImpl_onEndEvent(
      long nativeTtsPlatformImplAndroid, Object caller, int utteranceId);

  /**
   * org.chromium.content.browser.TtsPlatformImpl.onErrorEvent
   * @param nativeTtsPlatformImplAndroid (long)
   * @param caller (org.chromium.content.browser.TtsPlatformImpl)
   * @param utteranceId (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_TtsPlatformImpl_onErrorEvent(
      long nativeTtsPlatformImplAndroid, Object caller, int utteranceId);

  /**
   * org.chromium.content.browser.TtsPlatformImpl.onStartEvent
   * @param nativeTtsPlatformImplAndroid (long)
   * @param caller (org.chromium.content.browser.TtsPlatformImpl)
   * @param utteranceId (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_TtsPlatformImpl_onStartEvent(
      long nativeTtsPlatformImplAndroid, Object caller, int utteranceId);

  /**
   * org.chromium.content.browser.TtsPlatformImpl.requestTtsStop
   * @param nativeTtsPlatformImplAndroid (long)
   * @param caller (org.chromium.content.browser.TtsPlatformImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_TtsPlatformImpl_requestTtsStop(
      long nativeTtsPlatformImplAndroid, Object caller);

  /**
   * org.chromium.content.browser.TtsPlatformImpl.voicesChanged
   * @param nativeTtsPlatformImplAndroid (long)
   * @param caller (org.chromium.content.browser.TtsPlatformImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_TtsPlatformImpl_voicesChanged(
      long nativeTtsPlatformImplAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.BrowserAccessibilityState.onAnimatorDurationScaleChanged
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_BrowserAccessibilityState_onAnimatorDurationScaleChanged(
      );

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.addSpellingErrorForTesting
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @param startOffset (int)
   * @param endOffset (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_addSpellingErrorForTesting(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id, int startOffset,
      int endOffset);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.adjustSlider
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @param increment (boolean)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_adjustSlider(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id, boolean increment);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.areInlineTextBoxesLoaded
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_areInlineTextBoxesLoaded(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.blur
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_blur(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.click
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_click(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.deleteEarly
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_deleteEarly(
      long nativeWebContentsAccessibilityAndroid);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.enable
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_enable(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.findElementType
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param startId (int)
   * @param elementType (java.lang.String)
   * @param forwards (boolean)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_findElementType(
      long nativeWebContentsAccessibilityAndroid, Object caller, int startId, String elementType,
      boolean forwards);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.focus
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_focus(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.getCharacterBoundingBoxes
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @param start (int)
   * @param len (int)
   * @return (int[])
   */
  public static final native int[] org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getCharacterBoundingBoxes(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id, int start, int len);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.getEditableTextSelectionEnd
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getEditableTextSelectionEnd(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.getEditableTextSelectionStart
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getEditableTextSelectionStart(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.getIdForElementAfterElementHostingAutofillPopup
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getIdForElementAfterElementHostingAutofillPopup(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.getRootId
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getRootId(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.getSupportedHtmlElementTypes
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getSupportedHtmlElementTypes(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.getTextLength
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_getTextLength(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.init
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.isAutofillPopupNode
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isAutofillPopupNode(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.isEditableText
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isEditableText(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.isEnabled
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isEnabled(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.isFocused
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isFocused(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.isNodeValid
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isNodeValid(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.isSlider
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_isSlider(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.loadInlineTextBoxes
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_loadInlineTextBoxes(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.moveAccessibilityFocus
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param oldId (int)
   * @param newId (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_moveAccessibilityFocus(
      long nativeWebContentsAccessibilityAndroid, Object caller, int oldId, int newId);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.nextAtGranularity
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param selectionGranularity (int)
   * @param extendSelection (boolean)
   * @param id (int)
   * @param cursorIndex (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_nextAtGranularity(
      long nativeWebContentsAccessibilityAndroid, Object caller, int selectionGranularity,
      boolean extendSelection, int id, int cursorIndex);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.onAutofillPopupDismissed
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_onAutofillPopupDismissed(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.onAutofillPopupDisplayed
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_onAutofillPopupDisplayed(
      long nativeWebContentsAccessibilityAndroid, Object caller);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.populateAccessibilityEvent
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param event (android.view.accessibility.AccessibilityEvent)
   * @param id (int)
   * @param eventType (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_populateAccessibilityEvent(
      long nativeWebContentsAccessibilityAndroid, Object caller, Object event, int id,
      int eventType);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.populateAccessibilityNodeInfo
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param info (android.view.accessibility.AccessibilityNodeInfo)
   * @param id (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_populateAccessibilityNodeInfo(
      long nativeWebContentsAccessibilityAndroid, Object caller, Object info, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.previousAtGranularity
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param selectionGranularity (int)
   * @param extendSelection (boolean)
   * @param id (int)
   * @param cursorIndex (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_previousAtGranularity(
      long nativeWebContentsAccessibilityAndroid, Object caller, int selectionGranularity,
      boolean extendSelection, int id, int cursorIndex);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.scroll
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @param direction (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_scroll(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id, int direction);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.scrollToMakeNodeVisible
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_scrollToMakeNodeVisible(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.setSelection
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @param start (int)
   * @param end (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setSelection(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id, int start, int end);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.setTextFieldValue
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @param newValue (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_setTextFieldValue(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id, String newValue);

  /**
   * org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl.showContextMenu
   * @param nativeWebContentsAccessibilityAndroid (long)
   * @param caller (org.chromium.content.browser.accessibility.WebContentsAccessibilityImpl)
   * @param id (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_WebContentsAccessibilityImpl_showContextMenu(
      long nativeWebContentsAccessibilityAndroid, Object caller, int id);

  /**
   * org.chromium.content.browser.accessibility.captioning.CaptioningController.init
   * @param caller (org.chromium.content.browser.accessibility.captioning.CaptioningController)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_accessibility_captioning_CaptioningController_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.browser.accessibility.captioning.CaptioningController.setTextTrackSettings
   * @param nativeCaptioningController (long)
   * @param caller (org.chromium.content.browser.accessibility.captioning.CaptioningController)
   * @param textTracksEnabled (boolean)
   * @param textTrackBackgroundColor (java.lang.String)
   * @param textTrackFontFamily (java.lang.String)
   * @param textTrackFontStyle (java.lang.String)
   * @param textTrackFontVariant (java.lang.String)
   * @param textTrackTextColor (java.lang.String)
   * @param textTrackTextShadow (java.lang.String)
   * @param textTrackTextSize (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_accessibility_captioning_CaptioningController_setTextTrackSettings(
      long nativeCaptioningController, Object caller, boolean textTracksEnabled,
      String textTrackBackgroundColor, String textTrackFontFamily, String textTrackFontStyle,
      String textTrackFontVariant, String textTrackTextColor, String textTrackTextShadow,
      String textTrackTextSize);

  /**
   * org.chromium.content.browser.androidoverlay.DialogOverlayImpl.completeInit
   * @param nativeDialogOverlayImpl (long)
   * @param caller (org.chromium.content.browser.androidoverlay.DialogOverlayImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_androidoverlay_DialogOverlayImpl_completeInit(
      long nativeDialogOverlayImpl, Object caller);

  /**
   * org.chromium.content.browser.androidoverlay.DialogOverlayImpl.destroy
   * @param nativeDialogOverlayImpl (long)
   * @param caller (org.chromium.content.browser.androidoverlay.DialogOverlayImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_androidoverlay_DialogOverlayImpl_destroy(
      long nativeDialogOverlayImpl, Object caller);

  /**
   * org.chromium.content.browser.androidoverlay.DialogOverlayImpl.getCompositorOffset
   * @param nativeDialogOverlayImpl (long)
   * @param caller (org.chromium.content.browser.androidoverlay.DialogOverlayImpl)
   * @param rect (org.chromium.gfx.mojom.Rect)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_androidoverlay_DialogOverlayImpl_getCompositorOffset(
      long nativeDialogOverlayImpl, Object caller, Object rect);

  /**
   * org.chromium.content.browser.androidoverlay.DialogOverlayImpl.init
   * @param caller (org.chromium.content.browser.androidoverlay.DialogOverlayImpl)
   * @param high (long)
   * @param low (long)
   * @param isPowerEfficient (boolean)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_androidoverlay_DialogOverlayImpl_init(
      Object caller, long high, long low, boolean isPowerEfficient);

  /**
   * org.chromium.content.browser.androidoverlay.DialogOverlayImpl.lookupSurfaceForTesting
   * @param surfaceId (int)
   * @return (android.view.Surface)
   */
  public static final native Object org_chromium_content_browser_androidoverlay_DialogOverlayImpl_lookupSurfaceForTesting(
      int surfaceId);

  /**
   * org.chromium.content.browser.androidoverlay.DialogOverlayImpl.registerSurface
   * @param surface (android.view.Surface)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_androidoverlay_DialogOverlayImpl_registerSurface(
      Object surface);

  /**
   * org.chromium.content.browser.androidoverlay.DialogOverlayImpl.unregisterSurface
   * @param surfaceId (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_androidoverlay_DialogOverlayImpl_unregisterSurface(
      int surfaceId);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.canGoBack
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_canGoBack(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.canGoForward
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_canGoForward(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.canGoToOffset
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param offset (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_canGoToOffset(
      long nativeNavigationControllerAndroid, Object caller, int offset);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.cancelPendingReload
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_cancelPendingReload(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.clearHistory
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_clearHistory(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.clearSslPreferences
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_clearSslPreferences(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.continuePendingReload
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_continuePendingReload(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getDirectedNavigationHistory
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param history (org.chromium.content_public.browser.NavigationHistory)
   * @param isForward (boolean)
   * @param itemLimit (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_getDirectedNavigationHistory(
      long nativeNavigationControllerAndroid, Object caller, Object history, boolean isForward,
      int itemLimit);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getEntryAtIndex
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param index (int)
   * @return (org.chromium.content_public.browser.NavigationEntry)
   */
  public static final native Object org_chromium_content_browser_framehost_NavigationControllerImpl_getEntryAtIndex(
      long nativeNavigationControllerAndroid, Object caller, int index);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getEntryExtraData
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param index (int)
   * @param key (java.lang.String)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_framehost_NavigationControllerImpl_getEntryExtraData(
      long nativeNavigationControllerAndroid, Object caller, int index, String key);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getLastCommittedEntryIndex
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_framehost_NavigationControllerImpl_getLastCommittedEntryIndex(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getNavigationHistory
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param history (java.lang.Object)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_framehost_NavigationControllerImpl_getNavigationHistory(
      long nativeNavigationControllerAndroid, Object caller, Object history);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getPendingEntry
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (org.chromium.content_public.browser.NavigationEntry)
   */
  public static final native Object org_chromium_content_browser_framehost_NavigationControllerImpl_getPendingEntry(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getUseDesktopUserAgent
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_getUseDesktopUserAgent(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.getVisibleEntry
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (org.chromium.content_public.browser.NavigationEntry)
   */
  public static final native Object org_chromium_content_browser_framehost_NavigationControllerImpl_getVisibleEntry(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.goBack
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_goBack(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.goForward
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_goForward(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.goToNavigationIndex
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param index (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_goToNavigationIndex(
      long nativeNavigationControllerAndroid, Object caller, int index);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.goToOffset
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param offset (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_goToOffset(
      long nativeNavigationControllerAndroid, Object caller, int offset);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.isEntryMarkedToBeSkipped
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param index (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_isEntryMarkedToBeSkipped(
      long nativeNavigationControllerAndroid, Object caller, int index);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.isInitialNavigation
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_isInitialNavigation(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.loadIfNecessary
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_loadIfNecessary(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.loadUrl
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param url (java.lang.String)
   * @param loadUrlType (int)
   * @param transitionType (int)
   * @param referrerUrl (java.lang.String)
   * @param referrerPolicy (int)
   * @param uaOverrideOption (int)
   * @param extraHeaders (java.lang.String)
   * @param postData (org.chromium.content_public.common.ResourceRequestBody)
   * @param baseUrlForDataUrl (java.lang.String)
   * @param virtualUrlForDataUrl (java.lang.String)
   * @param dataUrlAsString (java.lang.String)
   * @param canLoadLocalResources (boolean)
   * @param isRendererInitiated (boolean)
   * @param shouldReplaceCurrentEntry (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_loadUrl(
      long nativeNavigationControllerAndroid, Object caller, String url, int loadUrlType,
      int transitionType, String referrerUrl, int referrerPolicy, int uaOverrideOption,
      String extraHeaders, Object postData, String baseUrlForDataUrl, String virtualUrlForDataUrl,
      String dataUrlAsString, boolean canLoadLocalResources, boolean isRendererInitiated,
      boolean shouldReplaceCurrentEntry);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.needsReload
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_needsReload(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.pruneForwardEntries
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_pruneForwardEntries(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.reload
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param checkForRepost (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_reload(
      long nativeNavigationControllerAndroid, Object caller, boolean checkForRepost);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.reloadBypassingCache
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param checkForRepost (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_reloadBypassingCache(
      long nativeNavigationControllerAndroid, Object caller, boolean checkForRepost);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.removeEntryAtIndex
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param index (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_NavigationControllerImpl_removeEntryAtIndex(
      long nativeNavigationControllerAndroid, Object caller, int index);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.setEntryExtraData
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param index (int)
   * @param key (java.lang.String)
   * @param value (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_setEntryExtraData(
      long nativeNavigationControllerAndroid, Object caller, int index, String key, String value);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.setNeedsReload
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_setNeedsReload(
      long nativeNavigationControllerAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.NavigationControllerImpl.setUseDesktopUserAgent
   * @param nativeNavigationControllerAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.NavigationControllerImpl)
   * @param override (boolean)
   * @param reloadOnChange (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_NavigationControllerImpl_setUseDesktopUserAgent(
      long nativeNavigationControllerAndroid, Object caller, boolean override,
      boolean reloadOnChange);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.getAndroidOverlayRoutingToken
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @return (org.chromium.base.UnguessableToken)
   */
  public static final native Object org_chromium_content_browser_framehost_RenderFrameHostImpl_getAndroidOverlayRoutingToken(
      long nativeRenderFrameHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.getCanonicalUrlForSharing
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @param callback (org.chromium.base.Callback<java.lang.String>)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_RenderFrameHostImpl_getCanonicalUrlForSharing(
      long nativeRenderFrameHostAndroid, Object caller, Object callback);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.getLastCommittedOrigin
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @return (org.chromium.url.Origin)
   */
  public static final native Object org_chromium_content_browser_framehost_RenderFrameHostImpl_getLastCommittedOrigin(
      long nativeRenderFrameHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.getLastCommittedURL
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_framehost_RenderFrameHostImpl_getLastCommittedURL(
      long nativeRenderFrameHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.isPaymentFeaturePolicyEnabled
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_RenderFrameHostImpl_isPaymentFeaturePolicyEnabled(
      long nativeRenderFrameHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.isProcessBlocked
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_RenderFrameHostImpl_isProcessBlocked(
      long nativeRenderFrameHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.isRenderFrameCreated
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_framehost_RenderFrameHostImpl_isRenderFrameCreated(
      long nativeRenderFrameHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.framehost.RenderFrameHostImpl.notifyUserActivation
   * @param nativeRenderFrameHostAndroid (long)
   * @param caller (org.chromium.content.browser.framehost.RenderFrameHostImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_framehost_RenderFrameHostImpl_notifyUserActivation(
      long nativeRenderFrameHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.input.DateTimeChooserAndroid.cancelDialog
   * @param nativeDateTimeChooserAndroid (long)
   * @param caller (org.chromium.content.browser.input.DateTimeChooserAndroid)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_DateTimeChooserAndroid_cancelDialog(
      long nativeDateTimeChooserAndroid, Object caller);

  /**
   * org.chromium.content.browser.input.DateTimeChooserAndroid.replaceDateTime
   * @param nativeDateTimeChooserAndroid (long)
   * @param caller (org.chromium.content.browser.input.DateTimeChooserAndroid)
   * @param dialogValue (double)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_DateTimeChooserAndroid_replaceDateTime(
      long nativeDateTimeChooserAndroid, Object caller, double dialogValue);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.advanceFocusInForm
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param focusType (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_advanceFocusInForm(
      long nativeImeAdapterAndroid, Object caller, int focusType);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.appendBackgroundColorSpan
   * @param spanPtr (long)
   * @param start (int)
   * @param end (int)
   * @param backgroundColor (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_appendBackgroundColorSpan(
      long spanPtr, int start, int end, int backgroundColor);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.appendSuggestionSpan
   * @param spanPtr (long)
   * @param start (int)
   * @param end (int)
   * @param isMisspelling (boolean)
   * @param removeOnFinishComposing (boolean)
   * @param underlineColor (int)
   * @param suggestionHighlightColor (int)
   * @param suggestions (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_appendSuggestionSpan(
      long spanPtr, int start, int end, boolean isMisspelling, boolean removeOnFinishComposing,
      int underlineColor, int suggestionHighlightColor, String[] suggestions);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.appendUnderlineSpan
   * @param spanPtr (long)
   * @param start (int)
   * @param end (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_appendUnderlineSpan(
      long spanPtr, int start, int end);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.commitText
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param text (java.lang.CharSequence)
   * @param textStr (java.lang.String)
   * @param newCursorPosition (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_commitText(
      long nativeImeAdapterAndroid, Object caller, Object text, String textStr,
      int newCursorPosition);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.deleteSurroundingText
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param before (int)
   * @param after (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_deleteSurroundingText(
      long nativeImeAdapterAndroid, Object caller, int before, int after);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.deleteSurroundingTextInCodePoints
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param before (int)
   * @param after (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_deleteSurroundingTextInCodePoints(
      long nativeImeAdapterAndroid, Object caller, int before, int after);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.finishComposingText
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_finishComposingText(
      long nativeImeAdapterAndroid, Object caller);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.init
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_input_ImeAdapterImpl_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.requestCursorUpdate
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param immediateRequest (boolean)
   * @param monitorRequest (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_requestCursorUpdate(
      long nativeImeAdapterAndroid, Object caller, boolean immediateRequest,
      boolean monitorRequest);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.requestTextInputStateUpdate
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_input_ImeAdapterImpl_requestTextInputStateUpdate(
      long nativeImeAdapterAndroid, Object caller);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.sendKeyEvent
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param event (android.view.KeyEvent)
   * @param type (int)
   * @param modifiers (int)
   * @param timestampMs (long)
   * @param keyCode (int)
   * @param scanCode (int)
   * @param isSystemKey (boolean)
   * @param unicodeChar (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_input_ImeAdapterImpl_sendKeyEvent(
      long nativeImeAdapterAndroid, Object caller, Object event, int type, int modifiers,
      long timestampMs, int keyCode, int scanCode, boolean isSystemKey, int unicodeChar);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.setComposingRegion
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param start (int)
   * @param end (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_setComposingRegion(
      long nativeImeAdapterAndroid, Object caller, int start, int end);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.setComposingText
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param text (java.lang.CharSequence)
   * @param textStr (java.lang.String)
   * @param newCursorPosition (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_setComposingText(
      long nativeImeAdapterAndroid, Object caller, Object text, String textStr,
      int newCursorPosition);

  /**
   * org.chromium.content.browser.input.ImeAdapterImpl.setEditableSelectionOffsets
   * @param nativeImeAdapterAndroid (long)
   * @param caller (org.chromium.content.browser.input.ImeAdapterImpl)
   * @param start (int)
   * @param end (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_ImeAdapterImpl_setEditableSelectionOffsets(
      long nativeImeAdapterAndroid, Object caller, int start, int end);

  /**
   * org.chromium.content.browser.input.SelectPopup.selectMenuItems
   * @param nativeSelectPopup (long)
   * @param caller (org.chromium.content.browser.input.SelectPopup)
   * @param nativeSelectPopupSourceFrame (long)
   * @param indices (int[])
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_SelectPopup_selectMenuItems(
      long nativeSelectPopup, Object caller, long nativeSelectPopupSourceFrame, int[] indices);

  /**
   * org.chromium.content.browser.input.TextSuggestionHost.applySpellCheckSuggestion
   * @param nativeTextSuggestionHostAndroid (long)
   * @param caller (org.chromium.content.browser.input.TextSuggestionHost)
   * @param suggestion (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_TextSuggestionHost_applySpellCheckSuggestion(
      long nativeTextSuggestionHostAndroid, Object caller, String suggestion);

  /**
   * org.chromium.content.browser.input.TextSuggestionHost.applyTextSuggestion
   * @param nativeTextSuggestionHostAndroid (long)
   * @param caller (org.chromium.content.browser.input.TextSuggestionHost)
   * @param markerTag (int)
   * @param suggestionIndex (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_TextSuggestionHost_applyTextSuggestion(
      long nativeTextSuggestionHostAndroid, Object caller, int markerTag, int suggestionIndex);

  /**
   * org.chromium.content.browser.input.TextSuggestionHost.deleteActiveSuggestionRange
   * @param nativeTextSuggestionHostAndroid (long)
   * @param caller (org.chromium.content.browser.input.TextSuggestionHost)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_TextSuggestionHost_deleteActiveSuggestionRange(
      long nativeTextSuggestionHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.input.TextSuggestionHost.onNewWordAddedToDictionary
   * @param nativeTextSuggestionHostAndroid (long)
   * @param caller (org.chromium.content.browser.input.TextSuggestionHost)
   * @param word (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_TextSuggestionHost_onNewWordAddedToDictionary(
      long nativeTextSuggestionHostAndroid, Object caller, String word);

  /**
   * org.chromium.content.browser.input.TextSuggestionHost.onSuggestionMenuClosed
   * @param nativeTextSuggestionHostAndroid (long)
   * @param caller (org.chromium.content.browser.input.TextSuggestionHost)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_input_TextSuggestionHost_onSuggestionMenuClosed(
      long nativeTextSuggestionHostAndroid, Object caller);

  /**
   * org.chromium.content.browser.selection.SelectionPopupControllerImpl.init
   * @param caller (org.chromium.content.browser.selection.SelectionPopupControllerImpl)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_selection_SelectionPopupControllerImpl_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.browser.selection.SelectionPopupControllerImpl.setTextHandlesTemporarilyHidden
   * @param nativeSelectionPopupController (long)
   * @param caller (org.chromium.content.browser.selection.SelectionPopupControllerImpl)
   * @param hidden (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_selection_SelectionPopupControllerImpl_setTextHandlesTemporarilyHidden(
      long nativeSelectionPopupController, Object caller, boolean hidden);

  /**
   * org.chromium.content.browser.selection.SmartSelectionClient.cancelAllRequests
   * @param nativeSmartSelectionClient (long)
   * @param caller (org.chromium.content.browser.selection.SmartSelectionClient)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_selection_SmartSelectionClient_cancelAllRequests(
      long nativeSmartSelectionClient, Object caller);

  /**
   * org.chromium.content.browser.selection.SmartSelectionClient.init
   * @param caller (org.chromium.content.browser.selection.SmartSelectionClient)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_selection_SmartSelectionClient_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.browser.selection.SmartSelectionClient.requestSurroundingText
   * @param nativeSmartSelectionClient (long)
   * @param caller (org.chromium.content.browser.selection.SmartSelectionClient)
   * @param numExtraCharacters (int)
   * @param callbackData (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_selection_SmartSelectionClient_requestSurroundingText(
      long nativeSmartSelectionClient, Object caller, int numExtraCharacters, int callbackData);

  /**
   * org.chromium.content.browser.sms.SmsReceiver.onReceive
   * @param nativeSmsProviderAndroid (long)
   * @param sms (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_sms_SmsReceiver_onReceive(
      long nativeSmsProviderAndroid, String sms);

  /**
   * org.chromium.content.browser.sms.SmsReceiver.onTimeout
   * @param nativeSmsProviderAndroid (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_sms_SmsReceiver_onTimeout(
      long nativeSmsProviderAndroid);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.addMessageToDevToolsConsole
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param level (int)
   * @param message (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_addMessageToDevToolsConsole(
      long nativeWebContentsAndroid, Object caller, int level, String message);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.adjustSelectionByCharacterOffset
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param startAdjust (int)
   * @param endAdjust (int)
   * @param showSelectionMenu (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_adjustSelectionByCharacterOffset(
      long nativeWebContentsAndroid, Object caller, int startAdjust, int endAdjust,
      boolean showSelectionMenu);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.clearNativeReference
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_clearNativeReference(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.collapseSelection
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_collapseSelection(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.copy
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_copy(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.cut
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_cut(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.destroyWebContents
   * @param webContentsAndroidPtr (long)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_destroyWebContents(
      long webContentsAndroidPtr);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.downloadImage
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param url (java.lang.String)
   * @param isFavicon (boolean)
   * @param maxBitmapSize (int)
   * @param bypassCache (boolean)
   * @param callback (org.chromium.content_public.browser.ImageDownloadCallback)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_webcontents_WebContentsImpl_downloadImage(
      long nativeWebContentsAndroid, Object caller, String url, boolean isFavicon,
      int maxBitmapSize, boolean bypassCache, Object callback);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.evaluateJavaScript
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param script (java.lang.String)
   * @param callback (org.chromium.content_public.browser.JavaScriptCallback)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_evaluateJavaScript(
      long nativeWebContentsAndroid, Object caller, String script, Object callback);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.evaluateJavaScriptForTests
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param script (java.lang.String)
   * @param callback (org.chromium.content_public.browser.JavaScriptCallback)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_evaluateJavaScriptForTests(
      long nativeWebContentsAndroid, Object caller, String script, Object callback);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.exitFullscreen
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_exitFullscreen(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.focusLocationBarByDefault
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_focusLocationBarByDefault(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.fromNativePtr
   * @param webContentsAndroidPtr (long)
   * @return (org.chromium.content_public.browser.WebContents)
   */
  public static final native Object org_chromium_content_browser_webcontents_WebContentsImpl_fromNativePtr(
      long webContentsAndroidPtr);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getEncoding
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_webcontents_WebContentsImpl_getEncoding(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getFocusedFrame
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (org.chromium.content_public.browser.RenderFrameHost)
   */
  public static final native Object org_chromium_content_browser_webcontents_WebContentsImpl_getFocusedFrame(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getFullscreenVideoSize
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (android.graphics.Rect)
   */
  public static final native Object org_chromium_content_browser_webcontents_WebContentsImpl_getFullscreenVideoSize(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getHeight
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_webcontents_WebContentsImpl_getHeight(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getInnerWebContents
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (org.chromium.content.browser.webcontents.WebContentsImpl[])
   */
  public static final native Object[] org_chromium_content_browser_webcontents_WebContentsImpl_getInnerWebContents(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getLastCommittedURL
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_webcontents_WebContentsImpl_getLastCommittedURL(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getLoadProgress
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (float)
   */
  public static final native float org_chromium_content_browser_webcontents_WebContentsImpl_getLoadProgress(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getMainFrame
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (org.chromium.content_public.browser.RenderFrameHost)
   */
  public static final native Object org_chromium_content_browser_webcontents_WebContentsImpl_getMainFrame(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getOrCreateEventForwarder
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (org.chromium.ui.base.EventForwarder)
   */
  public static final native Object org_chromium_content_browser_webcontents_WebContentsImpl_getOrCreateEventForwarder(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getRenderWidgetHostView
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (org.chromium.content.browser.RenderWidgetHostViewImpl)
   */
  public static final native Object org_chromium_content_browser_webcontents_WebContentsImpl_getRenderWidgetHostView(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getThemeColor
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_webcontents_WebContentsImpl_getThemeColor(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getTitle
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_webcontents_WebContentsImpl_getTitle(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getTopLevelNativeWindow
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (org.chromium.ui.base.WindowAndroid)
   */
  public static final native Object org_chromium_content_browser_webcontents_WebContentsImpl_getTopLevelNativeWindow(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getVisibleURL
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_content_browser_webcontents_WebContentsImpl_getVisibleURL(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.getWidth
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (int)
   */
  public static final native int org_chromium_content_browser_webcontents_WebContentsImpl_getWidth(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.hasAccessedInitialDocument
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_hasAccessedInitialDocument(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.hasActiveEffectivelyFullscreenVideo
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_hasActiveEffectivelyFullscreenVideo(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.isBeingDestroyed
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_isBeingDestroyed(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.isIncognito
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_isIncognito(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.isLoading
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_isLoading(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.isLoadingToDifferentDocument
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_isLoadingToDifferentDocument(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.isPictureInPictureAllowedForFullscreenVideo
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_isPictureInPictureAllowedForFullscreenVideo(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.isShowingInterstitialPage
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_browser_webcontents_WebContentsImpl_isShowingInterstitialPage(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.notifyBrowserControlsHeightChanged
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_notifyBrowserControlsHeightChanged(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.notifyRendererPreferenceUpdate
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_notifyRendererPreferenceUpdate(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.onHide
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_onHide(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.onScaleFactorChanged
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_onScaleFactorChanged(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.onShow
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_onShow(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.paste
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_paste(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.pasteAsPlainText
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_pasteAsPlainText(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.postMessageToMainFrame
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param message (java.lang.String)
   * @param sourceOrigin (java.lang.String)
   * @param targetOrigin (java.lang.String)
   * @param ports (org.chromium.content_public.browser.MessagePort[])
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_postMessageToMainFrame(
      long nativeWebContentsAndroid, Object caller, String message, String sourceOrigin,
      String targetOrigin, Object[] ports);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.replace
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param word (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_replace(
      long nativeWebContentsAndroid, Object caller, String word);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.requestAccessibilitySnapshot
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param callback (org.chromium.content_public.browser.AccessibilitySnapshotCallback)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_requestAccessibilitySnapshot(
      long nativeWebContentsAndroid, Object caller, Object callback);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.requestSmartClipExtract
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param callback (org.chromium.content.browser.webcontents.WebContentsImpl.SmartClipCallback)
   * @param x (int)
   * @param y (int)
   * @param width (int)
   * @param height (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_requestSmartClipExtract(
      long nativeWebContentsAndroid, Object caller, Object callback, int x, int y, int width,
      int height);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.resumeLoadingCreatedWebContents
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_resumeLoadingCreatedWebContents(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.scrollFocusedEditableNodeIntoView
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_scrollFocusedEditableNodeIntoView(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.selectAll
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_selectAll(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.selectWordAroundCaret
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_selectWordAroundCaret(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.sendOrientationChangeEvent
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param orientation (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_sendOrientationChangeEvent(
      long nativeWebContentsAndroid, Object caller, int orientation);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setAudioMuted
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param mute (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setAudioMuted(
      long nativeWebContentsAndroid, Object caller, boolean mute);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setDisplayCutoutSafeArea
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param top (int)
   * @param left (int)
   * @param bottom (int)
   * @param right (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setDisplayCutoutSafeArea(
      long nativeWebContentsAndroid, Object caller, int top, int left, int bottom, int right);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setFocus
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param focused (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setFocus(
      long nativeWebContentsAndroid, Object caller, boolean focused);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setHasPersistentVideo
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param value (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setHasPersistentVideo(
      long nativeWebContentsAndroid, Object caller, boolean value);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setImportance
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param importance (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setImportance(
      long nativeWebContentsAndroid, Object caller, int importance);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setOverscrollRefreshHandler
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param nativeOverscrollRefreshHandler (org.chromium.ui.OverscrollRefreshHandler)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setOverscrollRefreshHandler(
      long nativeWebContentsAndroid, Object caller, Object nativeOverscrollRefreshHandler);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setSize
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param width (int)
   * @param height (int)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setSize(
      long nativeWebContentsAndroid, Object caller, int width, int height);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setSpatialNavigationDisabled
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param disabled (boolean)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setSpatialNavigationDisabled(
      long nativeWebContentsAndroid, Object caller, boolean disabled);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setTopLevelNativeWindow
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param windowAndroid (org.chromium.ui.base.WindowAndroid)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setTopLevelNativeWindow(
      long nativeWebContentsAndroid, Object caller, Object windowAndroid);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.setViewAndroidDelegate
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @param viewDelegate (org.chromium.ui.base.ViewAndroidDelegate)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_setViewAndroidDelegate(
      long nativeWebContentsAndroid, Object caller, Object viewDelegate);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.stop
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_stop(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsImpl.suspendAllMediaPlayers
   * @param nativeWebContentsAndroid (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsImpl_suspendAllMediaPlayers(
      long nativeWebContentsAndroid, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsObserverProxy.destroy
   * @param nativeWebContentsObserverProxy (long)
   * @param caller (org.chromium.content.browser.webcontents.WebContentsObserverProxy)
   * @return (void)
   */
  public static final native void org_chromium_content_browser_webcontents_WebContentsObserverProxy_destroy(
      long nativeWebContentsObserverProxy, Object caller);

  /**
   * org.chromium.content.browser.webcontents.WebContentsObserverProxy.init
   * @param caller (org.chromium.content.browser.webcontents.WebContentsObserverProxy)
   * @param webContents (org.chromium.content.browser.webcontents.WebContentsImpl)
   * @return (long)
   */
  public static final native long org_chromium_content_browser_webcontents_WebContentsObserverProxy_init(
      Object caller, Object webContents);

  /**
   * org.chromium.content.common.ServiceManagerConnectionImpl.getConnectorMessagePipeHandle
   * @return (int)
   */
  public static final native int org_chromium_content_common_ServiceManagerConnectionImpl_getConnectorMessagePipeHandle(
      );

  /**
   * org.chromium.content.common.CameraPlugin.postMessage
   * @param nativeCameraPlugin (long)
   * @param caller (org.chromium.content.common.CameraPlugin)
   * @param message (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_common_CameraPlugin_postMessage(
          long nativeCameraPlugin, Object caller, String message);

  /**
   * org.chromium.content_public.browser.LoadUrlParams.isDataScheme
   * @param url (java.lang.String)
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_1public_browser_LoadUrlParams_isDataScheme(
      String url);

  /**
   * org.chromium.content_public.browser.NavigationHandle.removeRequestHeader
   * @param nativeNavigationHandleProxy (long)
   * @param headerName (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_1public_browser_NavigationHandle_removeRequestHeader(
      long nativeNavigationHandleProxy, String headerName);

  /**
   * org.chromium.content_public.browser.NavigationHandle.setRequestHeader
   * @param nativeNavigationHandleProxy (long)
   * @param headerName (java.lang.String)
   * @param headerValue (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_content_1public_browser_NavigationHandle_setRequestHeader(
      long nativeNavigationHandleProxy, String headerName, String headerValue);

  /**
   * org.chromium.content_public.common.ResourceRequestBody.createResourceRequestBodyFromBytes
   * @param httpBody (byte[])
   * @return (byte[])
   */
  public static final native byte[] org_chromium_content_1public_common_ResourceRequestBody_createResourceRequestBodyFromBytes(
      byte[] httpBody);

  /**
   * org.chromium.content_public.common.UseZoomForDSFPolicy.isUseZoomForDSFEnabled
   * @return (boolean)
   */
  public static final native boolean org_chromium_content_1public_common_UseZoomForDSFPolicy_isUseZoomForDSFEnabled(
      );

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.destroy
   * @param nativeContentViewRenderView (long)
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_destroy(
          long nativeContentViewRenderView);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.init
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @param rootWindow (org.chromium.ui.base.WindowAndroid)
   * @return (long)
   */
  public static final native long org_chromium_components_embedder_1support_view_ContentViewRenderView_init(
          Object caller, Object rootWindow);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.onPhysicalBackingSizeChanged
   * @param nativeContentViewRenderView (long)
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @param width (int)
   * @param height (int)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_onPhysicalBackingSizeChanged(
          long nativeContentViewRenderView, Object webContents, int width, int height);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.setCurrentWebContents
   * @param nativeContentViewRenderView (long)
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_setCurrentWebContents(
          long nativeContentViewRenderView, Object caller);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.setOverlayVideoMode
   * @param nativeContentViewRenderView (long)
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @param enabled (boolean)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_setOverlayVideoMode(
          long nativeContentViewRenderView, Object caller, boolean enabled);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.surfaceChanged
   * @param nativeContentViewRenderView (long)
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @param format (int)
   * @param width (int)
   * @param height (int)
   * @param surface (android.view.Surface)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_surfaceChanged(
          long nativeContentViewRenderView, Object caller, int format, int width, int height,
          Object surface);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.surfaceCreated
   * @param nativeContentViewRenderView (long)
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_surfaceCreated(
          long nativeContentViewRenderView);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.surfaceDestroyed
   * @param nativeContentViewRenderView (long)
   * @param caller (org.chromium.components.embedder_support.view.ContentViewRenderView)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_surfaceDestroyed(
          long nativeContentViewRenderView, Object caller);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.evictCachedSurface
   * @param nativeContentViewRenderView (long)
   * @return (void)
   */
  public static final native void org_chromium_components_embedder_1support_view_ContentViewRenderView_evictCachedSurface(
          long nativeContentViewRenderView);

  /**
   * org.chromium.components.embedder_support.view.ContentViewRenderView.getResourceManager
   * @param nativeContentViewRenderView (long)
   * @return (org.chromium.ui.resources.ResourceManager)
   */
  public static final native Object org_chromium_components_embedder_1support_view_ContentViewRenderView_getResourceManager(
          long nativeContentViewRenderView);

  /**
   * org.chromium.ui.base.Clipboard.getLastModifiedTimeToJavaTime
   * @param nativeClipboardAndroid (long)
   * @return (long)
   */
  public static final native long org_chromium_ui_base_Clipboard_getLastModifiedTimeToJavaTime(
          long nativeClipboardAndroid);

  /**
   * org.chromium.ui.base.Clipboard.onPrimaryClipChanged
   * @param nativeClipboardAndroid (long)
   * @param caller (org.chromium.ui.base.Clipboard)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_Clipboard_onPrimaryClipChanged(
          long nativeClipboardAndroid, Object caller);

  /**
   * org.chromium.ui.base.Clipboard.onPrimaryClipTimestampInvalidated
   * @param nativeClipboardAndroid (long)
   * @param caller (org.chromium.ui.base.Clipboard)
   * @param timestamp (long)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_Clipboard_onPrimaryClipTimestampInvalidated(
          long nativeClipboardAndroid, Object caller, long timestamp);

  /**
   * org.chromium.ui.base.EventForwarder.cancelFling
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param timeMs (long)
   * @param preventBoosting (boolean)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_EventForwarder_cancelFling(
          long nativeEventForwarder, Object caller, long timeMs, boolean preventBoosting);

  /**
   * org.chromium.ui.base.EventForwarder.dispatchKeyEvent
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param event (android.view.KeyEvent)
   * @return (boolean)
   */
  public static final native boolean org_chromium_ui_base_EventForwarder_dispatchKeyEvent(
          long nativeEventForwarder, Object caller, Object event);

  /**
   * org.chromium.ui.base.EventForwarder.doubleTap
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param timeMs (long)
   * @param x (int)
   * @param y (int)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_EventForwarder_doubleTap(
          long nativeEventForwarder, Object caller, long timeMs, int x, int y);

  /**
   * org.chromium.ui.base.EventForwarder.getJavaWindowAndroid
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @return (org.chromium.ui.base.WindowAndroid)
   */
  public static final native Object org_chromium_ui_base_EventForwarder_getJavaWindowAndroid(
          long nativeEventForwarder, Object caller);

  /**
   * org.chromium.ui.base.EventForwarder.onDragEvent
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param action (int)
   * @param x (int)
   * @param y (int)
   * @param screenX (int)
   * @param screenY (int)
   * @param mimeTypes (java.lang.String[])
   * @param content (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_EventForwarder_onDragEvent(
          long nativeEventForwarder, Object caller, int action, int x, int y, int screenX, int screenY,
          String[] mimeTypes, String content);

  /**
   * org.chromium.ui.base.EventForwarder.onGenericMotionEvent
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param event (android.view.MotionEvent)
   * @param timeMs (long)
   * @return (boolean)
   */
  public static final native boolean org_chromium_ui_base_EventForwarder_onGenericMotionEvent(
          long nativeEventForwarder, Object caller, Object event, long timeMs);

  /**
   * org.chromium.ui.base.EventForwarder.onGestureEvent
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param type (int)
   * @param timeMs (long)
   * @param delta (float)
   * @return (boolean)
   */
  public static final native boolean org_chromium_ui_base_EventForwarder_onGestureEvent(
          long nativeEventForwarder, Object caller, int type, long timeMs, float delta);

  /**
   * org.chromium.ui.base.EventForwarder.onKeyUp
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param event (android.view.KeyEvent)
   * @param keyCode (int)
   * @return (boolean)
   */
  public static final native boolean org_chromium_ui_base_EventForwarder_onKeyUp(
          long nativeEventForwarder, Object caller, Object event, int keyCode);

  /**
   * org.chromium.ui.base.EventForwarder.onMouseEvent
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param timeMs (long)
   * @param action (int)
   * @param x (float)
   * @param y (float)
   * @param pointerId (int)
   * @param pressure (float)
   * @param orientation (float)
   * @param tilt (float)
   * @param changedButton (int)
   * @param buttonState (int)
   * @param metaState (int)
   * @param toolType (int)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_EventForwarder_onMouseEvent(
          long nativeEventForwarder, Object caller, long timeMs, int action, float x, float y,
          int pointerId, float pressure, float orientation, float tilt, int changedButton,
          int buttonState, int metaState, int toolType);

  /**
   * org.chromium.ui.base.EventForwarder.onTouchEvent
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param event (android.view.MotionEvent)
   * @param timeMs (long)
   * @param action (int)
   * @param pointerCount (int)
   * @param historySize (int)
   * @param actionIndex (int)
   * @param x0 (float)
   * @param y0 (float)
   * @param x1 (float)
   * @param y1 (float)
   * @param pointerId0 (int)
   * @param pointerId1 (int)
   * @param touchMajor0 (float)
   * @param touchMajor1 (float)
   * @param touchMinor0 (float)
   * @param touchMinor1 (float)
   * @param orientation0 (float)
   * @param orientation1 (float)
   * @param tilt0 (float)
   * @param tilt1 (float)
   * @param rawX (float)
   * @param rawY (float)
   * @param androidToolType0 (int)
   * @param androidToolType1 (int)
   * @param androidButtonState (int)
   * @param androidMetaState (int)
   * @param isTouchHandleEvent (boolean)
   * @return (boolean)
   */
  public static final native boolean org_chromium_ui_base_EventForwarder_onTouchEvent(
          long nativeEventForwarder, Object caller, Object event, long timeMs, int action,
          int pointerCount, int historySize, int actionIndex, float x0, float y0, float x1, float y1,
          int pointerId0, int pointerId1, float touchMajor0, float touchMajor1, float touchMinor0,
          float touchMinor1, float orientation0, float orientation1, float tilt0, float tilt1,
          float rawX, float rawY, int androidToolType0, int androidToolType1, int androidButtonState,
          int androidMetaState, boolean isTouchHandleEvent);

  /**
   * org.chromium.ui.base.EventForwarder.scrollBy
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param deltaX (float)
   * @param deltaY (float)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_EventForwarder_scrollBy(
          long nativeEventForwarder, Object caller, float deltaX, float deltaY);

  /**
   * org.chromium.ui.base.EventForwarder.scrollTo
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param x (float)
   * @param y (float)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_EventForwarder_scrollTo(
          long nativeEventForwarder, Object caller, float x, float y);

  /**
   * org.chromium.ui.base.EventForwarder.startFling
   * @param nativeEventForwarder (long)
   * @param caller (org.chromium.ui.base.EventForwarder)
   * @param timeMs (long)
   * @param velocityX (float)
   * @param velocityY (float)
   * @param syntheticScroll (boolean)
   * @param preventBoosting (boolean)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_EventForwarder_startFling(
          long nativeEventForwarder, Object caller, long timeMs, float velocityX, float velocityY,
          boolean syntheticScroll, boolean preventBoosting);

  /**
   * org.chromium.ui.base.LocalizationUtils.getFirstStrongCharacterDirection
   * @param string (java.lang.String)
   * @return (int)
   */
  public static final native int org_chromium_ui_base_LocalizationUtils_getFirstStrongCharacterDirection(
          String string);

  /**
   * org.chromium.ui.base.SelectFileDialog.onContactsSelected
   * @param nativeSelectFileDialogImpl (long)
   * @param caller (org.chromium.ui.base.SelectFileDialog)
   * @param contacts (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_SelectFileDialog_onContactsSelected(
          long nativeSelectFileDialogImpl, Object caller, String contacts);

  /**
   * org.chromium.ui.base.SelectFileDialog.onFileNotSelected
   * @param nativeSelectFileDialogImpl (long)
   * @param caller (org.chromium.ui.base.SelectFileDialog)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_SelectFileDialog_onFileNotSelected(
          long nativeSelectFileDialogImpl, Object caller);

  /**
   * org.chromium.ui.base.SelectFileDialog.onFileSelected
   * @param nativeSelectFileDialogImpl (long)
   * @param caller (org.chromium.ui.base.SelectFileDialog)
   * @param filePath (java.lang.String)
   * @param displayName (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_SelectFileDialog_onFileSelected(
          long nativeSelectFileDialogImpl, Object caller, String filePath, String displayName);

  /**
   * org.chromium.ui.base.SelectFileDialog.onMultipleFilesSelected
   * @param nativeSelectFileDialogImpl (long)
   * @param caller (org.chromium.ui.base.SelectFileDialog)
   * @param filePathArray (java.lang.String[])
   * @param displayNameArray (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_ui_base_SelectFileDialog_onMultipleFilesSelected(
          long nativeSelectFileDialogImpl, Object caller, String[] filePathArray,
          String[] displayNameArray);

  /**
   * org.chromium.ui.base.WindowAndroid.destroy
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_destroy(
          long nativeWindowAndroid, Object caller);

  /**
   * org.chromium.ui.base.WindowAndroid.init
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @param displayId (int)
   * @param scrollFactor (float)
   * @param windowIsWideColorGamut (boolean)
   * @return (long)
   */
  public static final native long org_chromium_ui_base_WindowAndroid_init(Object caller,
                                                                          int displayId, float scrollFactor, boolean windowIsWideColorGamut);

  /**
   * org.chromium.ui.base.WindowAndroid.onActivityStarted
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_onActivityStarted(
          long nativeWindowAndroid, Object caller);

  /**
   * org.chromium.ui.base.WindowAndroid.onActivityStopped
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_onActivityStopped(
          long nativeWindowAndroid, Object caller);

  /**
   * org.chromium.ui.base.WindowAndroid.onCursorVisibilityChanged
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @param visible (boolean)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_onCursorVisibilityChanged(
          long nativeWindowAndroid, Object caller, boolean visible);

  /**
   * org.chromium.ui.base.WindowAndroid.onFallbackCursorModeToggled
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @param isOn (boolean)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_onFallbackCursorModeToggled(
          long nativeWindowAndroid, Object caller, boolean isOn);

  /**
   * org.chromium.ui.base.WindowAndroid.onSupportedRefreshRatesUpdated
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @param supportedRefreshRates (float[])
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_onSupportedRefreshRatesUpdated(
          long nativeWindowAndroid, Object caller, float[] supportedRefreshRates);

  /**
   * org.chromium.ui.base.WindowAndroid.onUpdateRefreshRate
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @param refreshRate (float)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_onUpdateRefreshRate(
          long nativeWindowAndroid, Object caller, float refreshRate);

  /**
   * org.chromium.ui.base.WindowAndroid.onVisibilityChanged
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @param visible (boolean)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_onVisibilityChanged(
          long nativeWindowAndroid, Object caller, boolean visible);

  /**
   * org.chromium.ui.base.WindowAndroid.setVSyncPaused
   * @param nativeWindowAndroid (long)
   * @param caller (org.chromium.ui.base.WindowAndroid)
   * @param paused (boolean)
   * @return (void)
   */
  public static final native void org_chromium_ui_base_WindowAndroid_setVSyncPaused(
          long nativeWindowAndroid, Object caller, boolean paused);

  /**
   * org.chromium.ui.display.DisplayAndroidManager.removeDisplay
   * @param nativeDisplayAndroidManager (long)
   * @param caller (org.chromium.ui.display.DisplayAndroidManager)
   * @param sdkDisplayId (int)
   * @return (void)
   */
  public static final native void org_chromium_ui_display_DisplayAndroidManager_removeDisplay(
          long nativeDisplayAndroidManager, Object caller, int sdkDisplayId);

  /**
   * org.chromium.ui.display.DisplayAndroidManager.setPrimaryDisplayId
   * @param nativeDisplayAndroidManager (long)
   * @param caller (org.chromium.ui.display.DisplayAndroidManager)
   * @param sdkDisplayId (int)
   * @return (void)
   */
  public static final native void org_chromium_ui_display_DisplayAndroidManager_setPrimaryDisplayId(
          long nativeDisplayAndroidManager, Object caller, int sdkDisplayId);

  /**
   * org.chromium.ui.display.DisplayAndroidManager.updateDisplay
   * @param nativeDisplayAndroidManager (long)
   * @param caller (org.chromium.ui.display.DisplayAndroidManager)
   * @param sdkDisplayId (int)
   * @param width (int)
   * @param height (int)
   * @param dipScale (float)
   * @param rotationDegrees (int)
   * @param bitsPerPixel (int)
   * @param bitsPerComponent (int)
   * @param isWideColorGamut (boolean)
   * @return (void)
   */
  public static final native void org_chromium_ui_display_DisplayAndroidManager_updateDisplay(
          long nativeDisplayAndroidManager, Object caller, int sdkDisplayId, int width, int height,
          float dipScale, int rotationDegrees, int bitsPerPixel, int bitsPerComponent,
          boolean isWideColorGamut);

  /**
   * org.chromium.ui.events.devices.InputDeviceObserver.inputConfigurationChanged
   * @param caller (org.chromium.ui.events.devices.InputDeviceObserver)
   * @return (void)
   */
  public static final native void org_chromium_ui_events_devices_InputDeviceObserver_inputConfigurationChanged(
          Object caller);

  /**
   * org.chromium.ui.gfx.ViewConfigurationHelper.updateSharedViewConfiguration
   * @param caller (org.chromium.ui.gfx.ViewConfigurationHelper)
   * @param maximumFlingVelocity (float)
   * @param minimumFlingVelocity (float)
   * @param touchSlop (float)
   * @param doubleTapSlop (float)
   * @param minScalingSpan (float)
   * @return (void)
   */
  public static final native void org_chromium_ui_gfx_ViewConfigurationHelper_updateSharedViewConfiguration(
          Object caller, float maximumFlingVelocity, float minimumFlingVelocity, float touchSlop,
          float doubleTapSlop, float minScalingSpan);

  /**
   * org.chromium.ui.gl.SurfaceTextureListener.destroy
   * @param nativeSurfaceTextureListener (long)
   * @param caller (org.chromium.ui.gl.SurfaceTextureListener)
   * @return (void)
   */
  public static final native void org_chromium_ui_gl_SurfaceTextureListener_destroy(
          long nativeSurfaceTextureListener, Object caller);

  /**
   * org.chromium.ui.gl.SurfaceTextureListener.frameAvailable
   * @param nativeSurfaceTextureListener (long)
   * @param caller (org.chromium.ui.gl.SurfaceTextureListener)
   * @return (void)
   */
  public static final native void org_chromium_ui_gl_SurfaceTextureListener_frameAvailable(
          long nativeSurfaceTextureListener, Object caller);

  /**
   * org.chromium.ui.resources.ResourceFactory.createBitmapResource
   * @return (long)
   */
  public static final native long org_chromium_ui_resources_ResourceFactory_createBitmapResource();

  /**
   * org.chromium.ui.resources.ResourceFactory.createNinePatchBitmapResource
   * @param paddingLeft (int)
   * @param paddingTop (int)
   * @param paddingRight (int)
   * @param paddingBottom (int)
   * @param apertureLeft (int)
   * @param apertureTop (int)
   * @param apertureRight (int)
   * @param apertureBottom (int)
   * @return (long)
   */
  public static final native long org_chromium_ui_resources_ResourceFactory_createNinePatchBitmapResource(
          int paddingLeft, int paddingTop, int paddingRight, int paddingBottom, int apertureLeft,
          int apertureTop, int apertureRight, int apertureBottom);

  /**
   * org.chromium.ui.resources.ResourceManager.clearTintedResourceCache
   * @param nativeResourceManagerImpl (long)
   * @param caller (org.chromium.ui.resources.ResourceManager)
   * @return (void)
   */
  public static final native void org_chromium_ui_resources_ResourceManager_clearTintedResourceCache(
          long nativeResourceManagerImpl, Object caller);

  /**
   * org.chromium.ui.resources.ResourceManager.onResourceReady
   * @param nativeResourceManagerImpl (long)
   * @param caller (org.chromium.ui.resources.ResourceManager)
   * @param resType (int)
   * @param resId (int)
   * @param bitmap (android.graphics.Bitmap)
   * @param width (int)
   * @param height (int)
   * @param nativeResource (long)
   * @return (void)
   */
  public static final native void org_chromium_ui_resources_ResourceManager_onResourceReady(
          long nativeResourceManagerImpl, Object caller, int resType, int resId, Object bitmap,
          int width, int height, long nativeResource);

  /**
   * org.chromium.ui.resources.ResourceManager.removeResource
   * @param nativeResourceManagerImpl (long)
   * @param caller (org.chromium.ui.resources.ResourceManager)
   * @param resType (int)
   * @param resId (int)
   * @return (void)
   */
  public static final native void org_chromium_ui_resources_ResourceManager_removeResource(
          long nativeResourceManagerImpl, Object caller, int resType, int resId);

  /**
   * org.chromium.components.download.DownloadCollectionBridge.getExpirationDurationInDays
   * @return (int)
   */
  public static final native int org_chromium_components_download_DownloadCollectionBridge_getExpirationDurationInDays(
  );


  /**
   * org.chromium.device.bluetooth.ChromeBluetoothAdapter.createOrUpdateDeviceOnScan
   * @param nativeBluetoothAdapterAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothAdapter)
   * @param address (java.lang.String)
   * @param deviceWrapper (org.chromium.device.bluetooth.Wrappers.BluetoothDeviceWrapper)
   * @param localName (java.lang.String)
   * @param rssi (int)
   * @param advertisedUuids (java.lang.String[])
   * @param txPower (int)
   * @param serviceDataKeys (java.lang.String[])
   * @param serviceDataValues (java.lang.Object[])
   * @param manufacturerDataKeys (int[])
   * @param manufacturerDataValues (java.lang.Object[])
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothAdapter_createOrUpdateDeviceOnScan(
          long nativeBluetoothAdapterAndroid, Object caller, String address, Object deviceWrapper,
          String localName, int rssi, String[] advertisedUuids, int txPower, String[] serviceDataKeys,
          Object[] serviceDataValues, int[] manufacturerDataKeys, Object[] manufacturerDataValues);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothAdapter.onAdapterStateChanged
   * @param nativeBluetoothAdapterAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothAdapter)
   * @param powered (boolean)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothAdapter_onAdapterStateChanged(
          long nativeBluetoothAdapterAndroid, Object caller, boolean powered);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothAdapter.onScanFailed
   * @param nativeBluetoothAdapterAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothAdapter)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothAdapter_onScanFailed(
          long nativeBluetoothAdapterAndroid, Object caller);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothDevice.createGattRemoteService
   * @param nativeBluetoothDeviceAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothDevice)
   * @param instanceId (java.lang.String)
   * @param serviceWrapper (org.chromium.device.bluetooth.Wrappers.BluetoothGattServiceWrapper)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothDevice_createGattRemoteService(
          long nativeBluetoothDeviceAndroid, Object caller, String instanceId, Object serviceWrapper);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothDevice.onConnectionStateChange
   * @param nativeBluetoothDeviceAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothDevice)
   * @param status (int)
   * @param connected (boolean)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothDevice_onConnectionStateChange(
          long nativeBluetoothDeviceAndroid, Object caller, int status, boolean connected);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothDevice.onGattServicesDiscovered
   * @param nativeBluetoothDeviceAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothDevice)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothDevice_onGattServicesDiscovered(
          long nativeBluetoothDeviceAndroid, Object caller);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic.createGattRemoteDescriptor
   * @param nativeBluetoothRemoteGattCharacteristicAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic)
   * @param instanceId (java.lang.String)
   * @param descriptorWrapper (org.chromium.device.bluetooth.Wrappers.BluetoothGattDescriptorWrapper)
   * @param chromeBluetoothDevice (org.chromium.device.bluetooth.ChromeBluetoothDevice)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_createGattRemoteDescriptor(
          long nativeBluetoothRemoteGattCharacteristicAndroid, Object caller, String instanceId,
          Object descriptorWrapper, Object chromeBluetoothDevice);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic.onChanged
   * @param nativeBluetoothRemoteGattCharacteristicAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic)
   * @param value (byte[])
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_onChanged(
          long nativeBluetoothRemoteGattCharacteristicAndroid, Object caller, byte[] value);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic.onRead
   * @param nativeBluetoothRemoteGattCharacteristicAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic)
   * @param status (int)
   * @param value (byte[])
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_onRead(
          long nativeBluetoothRemoteGattCharacteristicAndroid, Object caller, int status, byte[] value);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic.onWrite
   * @param nativeBluetoothRemoteGattCharacteristicAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothRemoteGattCharacteristic)
   * @param status (int)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothRemoteGattCharacteristic_onWrite(
          long nativeBluetoothRemoteGattCharacteristicAndroid, Object caller, int status);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothRemoteGattDescriptor.onRead
   * @param nativeBluetoothRemoteGattDescriptorAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothRemoteGattDescriptor)
   * @param status (int)
   * @param value (byte[])
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothRemoteGattDescriptor_onRead(
          long nativeBluetoothRemoteGattDescriptorAndroid, Object caller, int status, byte[] value);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothRemoteGattDescriptor.onWrite
   * @param nativeBluetoothRemoteGattDescriptorAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothRemoteGattDescriptor)
   * @param status (int)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothRemoteGattDescriptor_onWrite(
          long nativeBluetoothRemoteGattDescriptorAndroid, Object caller, int status);

  /**
   * org.chromium.device.bluetooth.ChromeBluetoothRemoteGattService.createGattRemoteCharacteristic
   * @param nativeBluetoothRemoteGattServiceAndroid (long)
   * @param caller (org.chromium.device.bluetooth.ChromeBluetoothRemoteGattService)
   * @param instanceId (java.lang.String)
   * @param characteristicWrapper (org.chromium.device.bluetooth.Wrappers.BluetoothGattCharacteristicWrapper)
   * @param chromeBluetoothDevice (org.chromium.device.bluetooth.ChromeBluetoothDevice)
   * @return (void)
   */
  public static final native void org_chromium_device_bluetooth_ChromeBluetoothRemoteGattService_createGattRemoteCharacteristic(
          long nativeBluetoothRemoteGattServiceAndroid, Object caller, String instanceId,
          Object characteristicWrapper, Object chromeBluetoothDevice);

  /**
   * org.chromium.device.gamepad.GamepadList.setGamepadData
   * @param caller (org.chromium.device.gamepad.GamepadList)
   * @param webGamepadsPtr (long)
   * @param index (int)
   * @param mapping (boolean)
   * @param connected (boolean)
   * @param devicename (java.lang.String)
   * @param timestamp (long)
   * @param axes (float[])
   * @param buttons (float[])
   * @return (void)
   */
  public static final native void org_chromium_device_gamepad_GamepadList_setGamepadData(
          Object caller, long webGamepadsPtr, int index, boolean mapping, boolean connected,
          String devicename, long timestamp, float[] axes, float[] buttons);

  /**
   * org.chromium.media.ScreenCapture.onActivityResult
   * @param nativeScreenCaptureMachineAndroid (long)
   * @param caller (org.chromium.media.ScreenCapture)
   * @param result (boolean)
   * @return (void)
   */
  public static final native void org_chromium_media_ScreenCapture_onActivityResult(
          long nativeScreenCaptureMachineAndroid, Object caller, boolean result);

  /**
   * org.chromium.media.ScreenCapture.onI420FrameAvailable
   * @param nativeScreenCaptureMachineAndroid (long)
   * @param caller (org.chromium.media.ScreenCapture)
   * @param yBuffer (java.nio.ByteBuffer)
   * @param yStride (int)
   * @param uBuffer (java.nio.ByteBuffer)
   * @param vBuffer (java.nio.ByteBuffer)
   * @param uvRowStride (int)
   * @param uvPixelStride (int)
   * @param left (int)
   * @param top (int)
   * @param width (int)
   * @param height (int)
   * @param timestamp (long)
   * @return (void)
   */
  public static final native void org_chromium_media_ScreenCapture_onI420FrameAvailable(
          long nativeScreenCaptureMachineAndroid, Object caller, Object yBuffer, int yStride,
          Object uBuffer, Object vBuffer, int uvRowStride, int uvPixelStride, int left, int top,
          int width, int height, long timestamp);

  /**
   * org.chromium.media.ScreenCapture.onOrientationChange
   * @param nativeScreenCaptureMachineAndroid (long)
   * @param caller (org.chromium.media.ScreenCapture)
   * @param rotation (int)
   * @return (void)
   */
  public static final native void org_chromium_media_ScreenCapture_onOrientationChange(
          long nativeScreenCaptureMachineAndroid, Object caller, int rotation);

  /**
   * org.chromium.media.ScreenCapture.onRGBAFrameAvailable
   * @param nativeScreenCaptureMachineAndroid (long)
   * @param caller (org.chromium.media.ScreenCapture)
   * @param buf (java.nio.ByteBuffer)
   * @param rowStride (int)
   * @param left (int)
   * @param top (int)
   * @param width (int)
   * @param height (int)
   * @param timestamp (long)
   * @return (void)
   */
  public static final native void org_chromium_media_ScreenCapture_onRGBAFrameAvailable(
          long nativeScreenCaptureMachineAndroid, Object caller, Object buf, int rowStride, int left,
          int top, int width, int height, long timestamp);


  /**
   * org.chromium.media.VideoCapture.dCheckCurrentlyOnIncomingTaskRunner
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_dCheckCurrentlyOnIncomingTaskRunner(
          long nativeVideoCaptureDeviceAndroid, Object caller);

  /**
   * org.chromium.media.VideoCapture.onError
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @param androidVideoCaptureError (int)
   * @param message (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_onError(
          long nativeVideoCaptureDeviceAndroid, Object caller, int androidVideoCaptureError,
          String message);

  /**
   * org.chromium.media.VideoCapture.onFrameAvailable
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @param data (byte[])
   * @param length (int)
   * @param rotation (int)
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_onFrameAvailable(
          long nativeVideoCaptureDeviceAndroid, Object caller, byte[] data, int length, int rotation);

  /**
   * org.chromium.media.VideoCapture.onFrameDropped
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @param androidVideoCaptureFrameDropReason (int)
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_onFrameDropped(
          long nativeVideoCaptureDeviceAndroid, Object caller, int androidVideoCaptureFrameDropReason);

  /**
   * org.chromium.media.VideoCapture.onGetPhotoCapabilitiesReply
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @param callbackId (long)
   * @param result (org.chromium.media.PhotoCapabilities)
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_onGetPhotoCapabilitiesReply(
          long nativeVideoCaptureDeviceAndroid, Object caller, long callbackId, Object result);

  /**
   * org.chromium.media.VideoCapture.onI420FrameAvailable
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @param yBuffer (java.nio.ByteBuffer)
   * @param yStride (int)
   * @param uBuffer (java.nio.ByteBuffer)
   * @param vBuffer (java.nio.ByteBuffer)
   * @param uvRowStride (int)
   * @param uvPixelStride (int)
   * @param width (int)
   * @param height (int)
   * @param rotation (int)
   * @param timestamp (long)
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_onI420FrameAvailable(
          long nativeVideoCaptureDeviceAndroid, Object caller, Object yBuffer, int yStride,
          Object uBuffer, Object vBuffer, int uvRowStride, int uvPixelStride, int width, int height,
          int rotation, long timestamp);

  /**
   * org.chromium.media.VideoCapture.onPhotoTaken
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @param callbackId (long)
   * @param data (byte[])
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_onPhotoTaken(
          long nativeVideoCaptureDeviceAndroid, Object caller, long callbackId, byte[] data);

  /**
   * org.chromium.media.VideoCapture.onStarted
   * @param nativeVideoCaptureDeviceAndroid (long)
   * @param caller (org.chromium.media.VideoCapture)
   * @return (void)
   */
  public static final native void org_chromium_media_VideoCapture_onStarted(
          long nativeVideoCaptureDeviceAndroid, Object caller);


  /**
   * org.chromium.media.AudioManagerAndroid.setMute
   * @param nativeAudioManagerAndroid (long)
   * @param caller (org.chromium.media.AudioManagerAndroid)
   * @param muted (boolean)
   * @return (void)
   */
  public static final native void org_chromium_media_AudioManagerAndroid_setMute(
          long nativeAudioManagerAndroid, Object caller, boolean muted);

  /**
   * org.chromium.media.AudioTrackOutputStream.getAddress
   * @param nativeAudioTrackOutputStream (long)
   * @param caller (org.chromium.media.AudioTrackOutputStream)
   * @param byteBuffer (java.nio.ByteBuffer)
   * @return (long)
   */
  public static final native long org_chromium_media_AudioTrackOutputStream_getAddress(
          long nativeAudioTrackOutputStream, Object caller, Object byteBuffer);

  /**
   * org.chromium.media.AudioTrackOutputStream.onError
   * @param nativeAudioTrackOutputStream (long)
   * @param caller (org.chromium.media.AudioTrackOutputStream)
   * @return (void)
   */
  public static final native void org_chromium_media_AudioTrackOutputStream_onError(
          long nativeAudioTrackOutputStream, Object caller);

  /**
   * org.chromium.media.AudioTrackOutputStream.onMoreData
   * @param nativeAudioTrackOutputStream (long)
   * @param caller (org.chromium.media.AudioTrackOutputStream)
   * @param audioData (java.nio.ByteBuffer)
   * @param delayInFrames (long)
   * @return (org.chromium.media.AudioTrackOutputStream.AudioBufferInfo)
   */
  public static final native Object org_chromium_media_AudioTrackOutputStream_onMoreData(
          long nativeAudioTrackOutputStream, Object caller, Object audioData, long delayInFrames);

  /**
   * org.chromium.media.HdrMetadata.colorTransfer
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (int)
   */
  public static final native int org_chromium_media_HdrMetadata_colorTransfer(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.maxContentLuminance
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (int)
   */
  public static final native int org_chromium_media_HdrMetadata_maxContentLuminance(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.maxFrameAverageLuminance
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (int)
   */
  public static final native int org_chromium_media_HdrMetadata_maxFrameAverageLuminance(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.maxMasteringLuminance
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_maxMasteringLuminance(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.minMasteringLuminance
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_minMasteringLuminance(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.primaries
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (int)
   */
  public static final native int org_chromium_media_HdrMetadata_primaries(long nativeJniHdrMetadata,
                                                                          Object caller);

  /**
   * org.chromium.media.HdrMetadata.primaryBChromaticityX
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_primaryBChromaticityX(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.primaryBChromaticityY
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_primaryBChromaticityY(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.primaryGChromaticityX
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_primaryGChromaticityX(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.primaryGChromaticityY
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_primaryGChromaticityY(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.primaryRChromaticityX
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_primaryRChromaticityX(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.primaryRChromaticityY
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_primaryRChromaticityY(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.range
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (int)
   */
  public static final native int org_chromium_media_HdrMetadata_range(long nativeJniHdrMetadata,
                                                                      Object caller);

  /**
   * org.chromium.media.HdrMetadata.whitePointChromaticityX
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_whitePointChromaticityX(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.HdrMetadata.whitePointChromaticityY
   * @param nativeJniHdrMetadata (long)
   * @param caller (org.chromium.media.HdrMetadata)
   * @return (float)
   */
  public static final native float org_chromium_media_HdrMetadata_whitePointChromaticityY(
          long nativeJniHdrMetadata, Object caller);

  /**
   * org.chromium.media.MediaCodecBridge.onBuffersAvailable
   * @param nativeMediaCodecBridge (long)
   * @param caller (org.chromium.media.MediaCodecBridge)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaCodecBridge_onBuffersAvailable(
          long nativeMediaCodecBridge, Object caller);

  /**
   * org.chromium.media.MediaDrmBridge.onMediaCryptoReady
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param mediaCrypto (android.media.MediaCrypto)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onMediaCryptoReady(
          long nativeMediaDrmBridge, Object caller, Object mediaCrypto);

  /**
   * org.chromium.media.MediaDrmBridge.onPromiseRejected
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param promiseId (long)
   * @param errorMessage (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onPromiseRejected(
          long nativeMediaDrmBridge, Object caller, long promiseId, String errorMessage);

  /**
   * org.chromium.media.MediaDrmBridge.onPromiseResolved
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param promiseId (long)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onPromiseResolved(
          long nativeMediaDrmBridge, Object caller, long promiseId);

  /**
   * org.chromium.media.MediaDrmBridge.onPromiseResolvedWithSession
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param promiseId (long)
   * @param emeSessionId (byte[])
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onPromiseResolvedWithSession(
          long nativeMediaDrmBridge, Object caller, long promiseId, byte[] emeSessionId);

  /**
   * org.chromium.media.MediaDrmBridge.onProvisionRequest
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param defaultUrl (java.lang.String)
   * @param requestData (byte[])
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onProvisionRequest(
          long nativeMediaDrmBridge, Object caller, String defaultUrl, byte[] requestData);

  /**
   * org.chromium.media.MediaDrmBridge.onProvisioningComplete
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param success (boolean)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onProvisioningComplete(
          long nativeMediaDrmBridge, Object caller, boolean success);

  /**
   * org.chromium.media.MediaDrmBridge.onSessionClosed
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param emeSessionId (byte[])
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onSessionClosed(
          long nativeMediaDrmBridge, Object caller, byte[] emeSessionId);

  /**
   * org.chromium.media.MediaDrmBridge.onSessionExpirationUpdate
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param emeSessionId (byte[])
   * @param expirationTime (long)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onSessionExpirationUpdate(
          long nativeMediaDrmBridge, Object caller, byte[] emeSessionId, long expirationTime);

  /**
   * org.chromium.media.MediaDrmBridge.onSessionKeysChange
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param emeSessionId (byte[])
   * @param keysInfo (java.lang.Object[])
   * @param hasAdditionalUsableKey (boolean)
   * @param isKeyRelease (boolean)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onSessionKeysChange(
          long nativeMediaDrmBridge, Object caller, byte[] emeSessionId, Object[] keysInfo,
          boolean hasAdditionalUsableKey, boolean isKeyRelease);

  /**
   * org.chromium.media.MediaDrmBridge.onSessionMessage
   * @param nativeMediaDrmBridge (long)
   * @param caller (org.chromium.media.MediaDrmBridge)
   * @param emeSessionId (byte[])
   * @param requestType (int)
   * @param message (byte[])
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmBridge_onSessionMessage(
          long nativeMediaDrmBridge, Object caller, byte[] emeSessionId, int requestType,
          byte[] message);

  /**
   * org.chromium.media.MediaDrmStorageBridge.onClearInfo
   * @param nativeMediaDrmStorageBridge (long)
   * @param caller (org.chromium.media.MediaDrmStorageBridge)
   * @param sessionId (byte[])
   * @param cb (org.chromium.base.Callback<java.lang.Boolean>)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmStorageBridge_onClearInfo(
          long nativeMediaDrmStorageBridge, Object caller, byte[] sessionId, Object cb);

  /**
   * org.chromium.media.MediaDrmStorageBridge.onLoadInfo
   * @param nativeMediaDrmStorageBridge (long)
   * @param caller (org.chromium.media.MediaDrmStorageBridge)
   * @param sessionId (byte[])
   * @param cb (org.chromium.base.Callback<org.chromium.media.MediaDrmStorageBridge.PersistentInfo>)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmStorageBridge_onLoadInfo(
          long nativeMediaDrmStorageBridge, Object caller, byte[] sessionId, Object cb);

  /**
   * org.chromium.media.MediaDrmStorageBridge.onProvisioned
   * @param nativeMediaDrmStorageBridge (long)
   * @param caller (org.chromium.media.MediaDrmStorageBridge)
   * @param cb (org.chromium.base.Callback<java.lang.Boolean>)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmStorageBridge_onProvisioned(
          long nativeMediaDrmStorageBridge, Object caller, Object cb);

  /**
   * org.chromium.media.MediaDrmStorageBridge.onSaveInfo
   * @param nativeMediaDrmStorageBridge (long)
   * @param caller (org.chromium.media.MediaDrmStorageBridge)
   * @param info (org.chromium.media.MediaDrmStorageBridge.PersistentInfo)
   * @param cb (org.chromium.base.Callback<java.lang.Boolean>)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaDrmStorageBridge_onSaveInfo(
          long nativeMediaDrmStorageBridge, Object caller, Object info, Object cb);

  /**
   * org.chromium.media.MediaPlayerBridge.onDidSetDataUriDataSource
   * @param nativeMediaPlayerBridge (long)
   * @param caller (org.chromium.media.MediaPlayerBridge)
   * @param success (boolean)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaPlayerBridge_onDidSetDataUriDataSource(
          long nativeMediaPlayerBridge, Object caller, boolean success);

  /**
   * org.chromium.media.MediaPlayerListener.onMediaError
   * @param nativeMediaPlayerListener (long)
   * @param caller (org.chromium.media.MediaPlayerListener)
   * @param errorType (int)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaPlayerListener_onMediaError(
          long nativeMediaPlayerListener, Object caller, int errorType);

  /**
   * org.chromium.media.MediaPlayerListener.onMediaPrepared
   * @param nativeMediaPlayerListener (long)
   * @param caller (org.chromium.media.MediaPlayerListener)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaPlayerListener_onMediaPrepared(
          long nativeMediaPlayerListener, Object caller);

  /**
   * org.chromium.media.MediaPlayerListener.onPlaybackComplete
   * @param nativeMediaPlayerListener (long)
   * @param caller (org.chromium.media.MediaPlayerListener)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaPlayerListener_onPlaybackComplete(
          long nativeMediaPlayerListener, Object caller);

  /**
   * org.chromium.media.MediaPlayerListener.onVideoSizeChanged
   * @param nativeMediaPlayerListener (long)
   * @param caller (org.chromium.media.MediaPlayerListener)
   * @param width (int)
   * @param height (int)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaPlayerListener_onVideoSizeChanged(
          long nativeMediaPlayerListener, Object caller, int width, int height);

  /**
   * org.chromium.media.MediaServerCrashListener.onMediaServerCrashDetected
   * @param nativeMediaServerCrashListener (long)
   * @param caller (org.chromium.media.MediaServerCrashListener)
   * @param watchdogNeedsRelease (boolean)
   * @return (void)
   */
  public static final native void org_chromium_media_MediaServerCrashListener_onMediaServerCrashDetected(
          long nativeMediaServerCrashListener, Object caller, boolean watchdogNeedsRelease);


  /**
   * org.chromium.midi.MidiInputPortAndroid.onData
   * @param nativeMidiInputPortAndroid (long)
   * @param bs (byte[])
   * @param offset (int)
   * @param count (int)
   * @param timestamp (long)
   * @return (void)
   */
  public static final native void org_chromium_midi_MidiInputPortAndroid_onData(
          long nativeMidiInputPortAndroid, byte[] bs, int offset, int count, long timestamp);

  /**
   * org.chromium.midi.MidiManagerAndroid.onAttached
   * @param nativeMidiManagerAndroid (long)
   * @param device (org.chromium.midi.MidiDeviceAndroid)
   * @return (void)
   */
  public static final native void org_chromium_midi_MidiManagerAndroid_onAttached(
          long nativeMidiManagerAndroid, Object device);

  /**
   * org.chromium.midi.MidiManagerAndroid.onDetached
   * @param nativeMidiManagerAndroid (long)
   * @param device (org.chromium.midi.MidiDeviceAndroid)
   * @return (void)
   */
  public static final native void org_chromium_midi_MidiManagerAndroid_onDetached(
          long nativeMidiManagerAndroid, Object device);

  /**
   * org.chromium.midi.MidiManagerAndroid.onInitializationFailed
   * @param nativeMidiManagerAndroid (long)
   * @return (void)
   */
  public static final native void org_chromium_midi_MidiManagerAndroid_onInitializationFailed(
          long nativeMidiManagerAndroid);

  /**
   * org.chromium.midi.MidiManagerAndroid.onInitialized
   * @param nativeMidiManagerAndroid (long)
   * @param devices (org.chromium.midi.MidiDeviceAndroid[])
   * @return (void)
   */
  public static final native void org_chromium_midi_MidiManagerAndroid_onInitialized(
          long nativeMidiManagerAndroid, Object[] devices);

  /**
   * org.chromium.midi.UsbMidiDeviceAndroid.onData
   * @param nativeUsbMidiDeviceAndroid (long)
   * @param endpointNumber (int)
   * @param data (byte[])
   * @return (void)
   */
  public static final native void org_chromium_midi_UsbMidiDeviceAndroid_onData(
          long nativeUsbMidiDeviceAndroid, int endpointNumber, byte[] data);

  /**
   * org.chromium.midi.UsbMidiDeviceFactoryAndroid.onUsbMidiDeviceAttached
   * @param nativeUsbMidiDeviceFactoryAndroid (long)
   * @param device (java.lang.Object)
   * @return (void)
   */
  public static final native void org_chromium_midi_UsbMidiDeviceFactoryAndroid_onUsbMidiDeviceAttached(
          long nativeUsbMidiDeviceFactoryAndroid, Object device);

  /**
   * org.chromium.midi.UsbMidiDeviceFactoryAndroid.onUsbMidiDeviceDetached
   * @param nativeUsbMidiDeviceFactoryAndroid (long)
   * @param index (int)
   * @return (void)
   */
  public static final native void org_chromium_midi_UsbMidiDeviceFactoryAndroid_onUsbMidiDeviceDetached(
          long nativeUsbMidiDeviceFactoryAndroid, int index);

  /**
   * org.chromium.midi.UsbMidiDeviceFactoryAndroid.onUsbMidiDeviceRequestDone
   * @param nativeUsbMidiDeviceFactoryAndroid (long)
   * @param devices (java.lang.Object[])
   * @return (void)
   */
  public static final native void org_chromium_midi_UsbMidiDeviceFactoryAndroid_onUsbMidiDeviceRequestDone(
          long nativeUsbMidiDeviceFactoryAndroid, Object[] devices);


  /**
   * org.chromium.mojo.system.impl.BaseRunLoop.createBaseRunLoop
   * @param caller (org.chromium.mojo.system.impl.BaseRunLoop)
   * @return (long)
   */
  public static final native long org_chromium_mojo_system_impl_BaseRunLoop_createBaseRunLoop(
          Object caller);

  /**
   * org.chromium.mojo.system.impl.BaseRunLoop.deleteMessageLoop
   * @param caller (org.chromium.mojo.system.impl.BaseRunLoop)
   * @param runLoopID (long)
   * @return (void)
   */
  public static final native void org_chromium_mojo_system_impl_BaseRunLoop_deleteMessageLoop(
          Object caller, long runLoopID);

  /**
   * org.chromium.mojo.system.impl.BaseRunLoop.postDelayedTask
   * @param caller (org.chromium.mojo.system.impl.BaseRunLoop)
   * @param runLoopID (long)
   * @param runnable (java.lang.Runnable)
   * @param delay (long)
   * @return (void)
   */
  public static final native void org_chromium_mojo_system_impl_BaseRunLoop_postDelayedTask(
          Object caller, long runLoopID, Object runnable, long delay);

  /**
   * org.chromium.mojo.system.impl.BaseRunLoop.quit
   * @param caller (org.chromium.mojo.system.impl.BaseRunLoop)
   * @return (void)
   */
  public static final native void org_chromium_mojo_system_impl_BaseRunLoop_quit(Object caller);

  /**
   * org.chromium.mojo.system.impl.BaseRunLoop.run
   * @param caller (org.chromium.mojo.system.impl.BaseRunLoop)
   * @return (void)
   */
  public static final native void org_chromium_mojo_system_impl_BaseRunLoop_run(Object caller);

  /**
   * org.chromium.mojo.system.impl.BaseRunLoop.runUntilIdle
   * @param caller (org.chromium.mojo.system.impl.BaseRunLoop)
   * @return (void)
   */
  public static final native void org_chromium_mojo_system_impl_BaseRunLoop_runUntilIdle(
          Object caller);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.beginReadData
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param numBytes (int)
   * @param flags (int)
   * @return (org.chromium.mojo.system.ResultAnd<java.nio.ByteBuffer>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_beginReadData(
          Object caller, int mojoHandle, int numBytes, int flags);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.beginWriteData
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param numBytes (int)
   * @param flags (int)
   * @return (org.chromium.mojo.system.ResultAnd<java.nio.ByteBuffer>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_beginWriteData(
          Object caller, int mojoHandle, int numBytes, int flags);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.close
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_CoreImpl_close(Object caller,
                                                                              int mojoHandle);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.createDataPipe
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param optionsBuffer (java.nio.ByteBuffer)
   * @return (org.chromium.mojo.system.ResultAnd<org.chromium.mojo.system.impl.CoreImpl.IntegerPair>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_createDataPipe(
          Object caller, Object optionsBuffer);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.createMessagePipe
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param optionsBuffer (java.nio.ByteBuffer)
   * @return (org.chromium.mojo.system.ResultAnd<org.chromium.mojo.system.impl.CoreImpl.IntegerPair>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_createMessagePipe(
          Object caller, Object optionsBuffer);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.createSharedBuffer
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param optionsBuffer (java.nio.ByteBuffer)
   * @param numBytes (long)
   * @return (org.chromium.mojo.system.ResultAnd<java.lang.Integer>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_createSharedBuffer(
          Object caller, Object optionsBuffer, long numBytes);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.duplicate
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param optionsBuffer (java.nio.ByteBuffer)
   * @return (org.chromium.mojo.system.ResultAnd<java.lang.Integer>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_duplicate(Object caller,
                                                                                     int mojoHandle, Object optionsBuffer);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.endReadData
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param numBytesRead (int)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_CoreImpl_endReadData(Object caller,
                                                                                    int mojoHandle, int numBytesRead);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.endWriteData
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param numBytesWritten (int)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_CoreImpl_endWriteData(Object caller,
                                                                                     int mojoHandle, int numBytesWritten);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.getNativeBufferOffset
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param buffer (java.nio.ByteBuffer)
   * @param alignment (int)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_CoreImpl_getNativeBufferOffset(
          Object caller, Object buffer, int alignment);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.getTimeTicksNow
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @return (long)
   */
  public static final native long org_chromium_mojo_system_impl_CoreImpl_getTimeTicksNow(
          Object caller);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.map
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param offset (long)
   * @param numBytes (long)
   * @param flags (int)
   * @return (org.chromium.mojo.system.ResultAnd<java.nio.ByteBuffer>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_map(Object caller,
                                                                               int mojoHandle, long offset, long numBytes, int flags);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.queryHandleSignalsState
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param signalsStateBuffer (java.nio.ByteBuffer)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_CoreImpl_queryHandleSignalsState(
          Object caller, int mojoHandle, Object signalsStateBuffer);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.readData
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param elements (java.nio.ByteBuffer)
   * @param elementsSize (int)
   * @param flags (int)
   * @return (org.chromium.mojo.system.ResultAnd<java.lang.Integer>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_readData(Object caller,
                                                                                    int mojoHandle, Object elements, int elementsSize, int flags);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.readMessage
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param flags (int)
   * @return (org.chromium.mojo.system.ResultAnd<org.chromium.mojo.system.MessagePipeHandle.ReadMessageResult>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_readMessage(
          Object caller, int mojoHandle, int flags);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.unmap
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param buffer (java.nio.ByteBuffer)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_CoreImpl_unmap(Object caller,
                                                                              Object buffer);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.writeData
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param elements (java.nio.ByteBuffer)
   * @param limit (int)
   * @param flags (int)
   * @return (org.chromium.mojo.system.ResultAnd<java.lang.Integer>)
   */
  public static final native Object org_chromium_mojo_system_impl_CoreImpl_writeData(Object caller,
                                                                                     int mojoHandle, Object elements, int limit, int flags);

  /**
   * org.chromium.mojo.system.impl.CoreImpl.writeMessage
   * @param caller (org.chromium.mojo.system.impl.CoreImpl)
   * @param mojoHandle (int)
   * @param bytes (java.nio.ByteBuffer)
   * @param numBytes (int)
   * @param handlesBuffer (java.nio.ByteBuffer)
   * @param flags (int)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_CoreImpl_writeMessage(Object caller,
                                                                                     int mojoHandle, Object bytes, int numBytes, Object handlesBuffer, int flags);

  /**
   * org.chromium.mojo.system.impl.WatcherImpl.cancel
   * @param caller (org.chromium.mojo.system.impl.WatcherImpl)
   * @param implPtr (long)
   * @return (void)
   */
  public static final native void org_chromium_mojo_system_impl_WatcherImpl_cancel(Object caller,
                                                                                   long implPtr);

  /**
   * org.chromium.mojo.system.impl.WatcherImpl.createWatcher
   * @param caller (org.chromium.mojo.system.impl.WatcherImpl)
   * @return (long)
   */
  public static final native long org_chromium_mojo_system_impl_WatcherImpl_createWatcher(
          Object caller);

  /**
   * org.chromium.mojo.system.impl.WatcherImpl.delete
   * @param caller (org.chromium.mojo.system.impl.WatcherImpl)
   * @param implPtr (long)
   * @return (void)
   */
  public static final native void org_chromium_mojo_system_impl_WatcherImpl_delete(Object caller,
                                                                                   long implPtr);

  /**
   * org.chromium.mojo.system.impl.WatcherImpl.start
   * @param caller (org.chromium.mojo.system.impl.WatcherImpl)
   * @param implPtr (long)
   * @param mojoHandle (int)
   * @param flags (int)
   * @return (int)
   */
  public static final native int org_chromium_mojo_system_impl_WatcherImpl_start(Object caller,
                                                                                 long implPtr, int mojoHandle, int flags);


  /**
   * org.chromium.net.GURLUtils.getOrigin
   * @param url (java.lang.String)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_net_GURLUtils_getOrigin(String url);

  /**
   * org.chromium.net.GURLUtils.getScheme
   * @param url (java.lang.String)
   * @return (java.lang.String)
   */
  public static final native String org_chromium_net_GURLUtils_getScheme(String url);

  /**
   * org.chromium.net.HttpNegotiateAuthenticator.setResult
   * @param nativeJavaNegotiateResultWrapper (long)
   * @param caller (org.chromium.net.HttpNegotiateAuthenticator)
   * @param status (int)
   * @param authToken (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_net_HttpNegotiateAuthenticator_setResult(
          long nativeJavaNegotiateResultWrapper, Object caller, int status, String authToken);

  /**
   * org.chromium.net.HttpUtil.isAllowedHeader
   * @param headerName (java.lang.String)
   * @param headerValue (java.lang.String)
   * @return (boolean)
   */
  public static final native boolean org_chromium_net_HttpUtil_isAllowedHeader(String headerName,
                                                                               String headerValue);

  /**
   * org.chromium.net.NetworkChangeNotifier.notifyConnectionTypeChanged
   * @param nativePtr (long)
   * @param caller (org.chromium.net.NetworkChangeNotifier)
   * @param newConnectionType (int)
   * @param defaultNetId (long)
   * @return (void)
   */
  public static final native void org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(
          long nativePtr, Object caller, int newConnectionType, long defaultNetId);

  /**
   * org.chromium.net.NetworkChangeNotifier.notifyMaxBandwidthChanged
   * @param nativePtr (long)
   * @param caller (org.chromium.net.NetworkChangeNotifier)
   * @param subType (int)
   * @return (void)
   */
  public static final native void org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(
          long nativePtr, Object caller, int subType);

  /**
   * org.chromium.net.NetworkChangeNotifier.notifyOfNetworkConnect
   * @param nativePtr (long)
   * @param caller (org.chromium.net.NetworkChangeNotifier)
   * @param netId (long)
   * @param connectionType (int)
   * @return (void)
   */
  public static final native void org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(
          long nativePtr, Object caller, long netId, int connectionType);

  /**
   * org.chromium.net.NetworkChangeNotifier.notifyOfNetworkDisconnect
   * @param nativePtr (long)
   * @param caller (org.chromium.net.NetworkChangeNotifier)
   * @param netId (long)
   * @return (void)
   */
  public static final native void org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(
          long nativePtr, Object caller, long netId);

  /**
   * org.chromium.net.NetworkChangeNotifier.notifyOfNetworkSoonToDisconnect
   * @param nativePtr (long)
   * @param caller (org.chromium.net.NetworkChangeNotifier)
   * @param netId (long)
   * @return (void)
   */
  public static final native void org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(
          long nativePtr, Object caller, long netId);

  /**
   * org.chromium.net.NetworkChangeNotifier.notifyPurgeActiveNetworkList
   * @param nativePtr (long)
   * @param caller (org.chromium.net.NetworkChangeNotifier)
   * @param activeNetIds (long[])
   * @return (void)
   */
  public static final native void org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(
          long nativePtr, Object caller, long[] activeNetIds);

  /**
   * org.chromium.net.ProxyChangeListener.proxySettingsChanged
   * @param nativePtr (long)
   * @param caller (org.chromium.net.ProxyChangeListener)
   * @return (void)
   */
  public static final native void org_chromium_net_ProxyChangeListener_proxySettingsChanged(
          long nativePtr, Object caller);

  /**
   * org.chromium.net.ProxyChangeListener.proxySettingsChangedTo
   * @param nativePtr (long)
   * @param caller (org.chromium.net.ProxyChangeListener)
   * @param host (java.lang.String)
   * @param port (int)
   * @param pacUrl (java.lang.String)
   * @param exclusionList (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(
          long nativePtr, Object caller, String host, int port, String pacUrl, String[] exclusionList);

  /**
   * org.chromium.net.X509Util.notifyKeyChainChanged
   * @return (void)
   */
  public static final native void org_chromium_net_X509Util_notifyKeyChainChanged();


  /**
   * org.chromium.device.geolocation.LocationProviderAdapter.newErrorAvailable
   * @param message (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_device_geolocation_LocationProviderAdapter_newErrorAvailable(
          String message);

  /**
   * org.chromium.device.geolocation.LocationProviderAdapter.newLocationAvailable
   * @param latitude (double)
   * @param longitude (double)
   * @param timeStamp (double)
   * @param hasAltitude (boolean)
   * @param altitude (double)
   * @param hasAccuracy (boolean)
   * @param accuracy (double)
   * @param hasHeading (boolean)
   * @param heading (double)
   * @param hasSpeed (boolean)
   * @param speed (double)
   * @return (void)
   */
  public static final native void org_chromium_device_geolocation_LocationProviderAdapter_newLocationAvailable(
          double latitude, double longitude, double timeStamp, boolean hasAltitude, double altitude,
          boolean hasAccuracy, double accuracy, boolean hasHeading, double heading, boolean hasSpeed,
          double speed);


  /**
   * org.chromium.device.sensors.PlatformSensor.notifyPlatformSensorError
   * @param nativePlatformSensorAndroid (long)
   * @param caller (org.chromium.device.sensors.PlatformSensor)
   * @return (void)
   */
  public static final native void org_chromium_device_sensors_PlatformSensor_notifyPlatformSensorError(
          long nativePlatformSensorAndroid, Object caller);

  /**
   * org.chromium.device.sensors.PlatformSensor.updatePlatformSensorReading
   * @param nativePlatformSensorAndroid (long)
   * @param caller (org.chromium.device.sensors.PlatformSensor)
   * @param timestamp (double)
   * @param value1 (double)
   * @param value2 (double)
   * @param value3 (double)
   * @param value4 (double)
   * @return (void)
   */
  public static final native void org_chromium_device_sensors_PlatformSensor_updatePlatformSensorReading(
          long nativePlatformSensorAndroid, Object caller, double timestamp, double value1,
          double value2, double value3, double value4);


  /**
   * org.chromium.device.usb.ChromeUsbService.deviceAttached
   * @param nativeUsbServiceAndroid (long)
   * @param caller (org.chromium.device.usb.ChromeUsbService)
   * @param device (android.hardware.usb.UsbDevice)
   * @return (void)
   */
  public static final native void org_chromium_device_usb_ChromeUsbService_deviceAttached(
          long nativeUsbServiceAndroid, Object caller, Object device);

  /**
   * org.chromium.device.usb.ChromeUsbService.deviceDetached
   * @param nativeUsbServiceAndroid (long)
   * @param caller (org.chromium.device.usb.ChromeUsbService)
   * @param deviceId (int)
   * @return (void)
   */
  public static final native void org_chromium_device_usb_ChromeUsbService_deviceDetached(
          long nativeUsbServiceAndroid, Object caller, int deviceId);

  /**
   * org.chromium.device.usb.ChromeUsbService.devicePermissionRequestComplete
   * @param nativeUsbServiceAndroid (long)
   * @param caller (org.chromium.device.usb.ChromeUsbService)
   * @param deviceId (int)
   * @param granted (boolean)
   * @return (void)
   */
  public static final native void org_chromium_device_usb_ChromeUsbService_devicePermissionRequestComplete(
          long nativeUsbServiceAndroid, Object caller, int deviceId, boolean granted);

  /**
   * org.chromium.device.time_zone_monitor.TimeZoneMonitor.timeZoneChangedFromJava
   * @param nativeTimeZoneMonitorAndroid (long)
   * @param caller (org.chromium.device.time_zone_monitor.TimeZoneMonitor)
   * @return (void)
   */
  public static final native void org_chromium_device_time_1zone_1monitor_TimeZoneMonitor_timeZoneChangedFromJava(
          long nativeTimeZoneMonitorAndroid, Object caller);

  /**
   * org.chromium.components.viz.service.frame_sinks.ExternalBeginFrameSourceAndroid.onVSync
   * @param nativeExternalBeginFrameSourceAndroid (long)
   * @param caller (org.chromium.components.viz.service.frame_sinks.ExternalBeginFrameSourceAndroid)
   * @param vsyncTimeMicros (long)
   * @param vsyncPeriodMicros (long)
   * @return (void)
   */
  public static final native void org_chromium_components_viz_service_frame_1sinks_ExternalBeginFrameSourceAndroid_onVSync(
          long nativeExternalBeginFrameSourceAndroid, Object caller, long vsyncTimeMicros,
          long vsyncPeriodMicros);

  /**
   * org.chromium.components.crash.browser.CrashpadMain.crashpadMain
   * @param argv (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_components_crash_browser_CrashpadMain_crashpadMain(
          String[] argv);

  /**
   * org.chromium.webview.g3webcore.AndroidProtocolHandler.getAndroidAssetPath
   * @return (java.lang.String)
   */
  public static final native String org_chromium_webview_g3webcore_AndroidProtocolHandler_getAndroidAssetPath(
  );

  /**
   * org.chromium.webview.g3webcore.AndroidProtocolHandler.getAndroidResourcePath
   * @return (java.lang.String)
   */
  public static final native String org_chromium_webview_g3webcore_AndroidProtocolHandler_getAndroidResourcePath(
  );

  /**
   * org.chromium.webview.g3webcore.G3BrowserContext.getDefaultJava
   * @return (org.chromium.webview.g3webcore.G3BrowserContext)
   */
  public static final native Object org_chromium_webview_g3webcore_G3BrowserContext_getDefaultJava(
  );

  /**
   * org.chromium.webview.g3webcore.G3ContentsClientBridge.cancelJsResult
   * @param nativeG3ContentsClientBridge (long)
   * @param caller (org.chromium.webview.g3webcore.G3ContentsClientBridge)
   * @param id (int)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3ContentsClientBridge_cancelJsResult(
          long nativeG3ContentsClientBridge, Object caller, int id);

  /**
   * org.chromium.webview.g3webcore.G3ContentsClientBridge.confirmJsResult
   * @param nativeG3ContentsClientBridge (long)
   * @param caller (org.chromium.webview.g3webcore.G3ContentsClientBridge)
   * @param id (int)
   * @param prompt (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3ContentsClientBridge_confirmJsResult(
          long nativeG3ContentsClientBridge, Object caller, int id, String prompt);

  /**
   * org.chromium.webview.g3webcore.G3ContentsClientBridge.proceedSslError
   * @param nativeG3ContentsClientBridge (long)
   * @param caller (org.chromium.webview.g3webcore.G3ContentsClientBridge)
   * @param proceed (boolean)
   * @param id (int)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3ContentsClientBridge_proceedSslError(
          long nativeG3ContentsClientBridge, Object caller, boolean proceed, int id);

  /**
   * org.chromium.webview.g3webcore.G3ContentsClientBridge.provideClientCertificateResponse
   * @param nativeG3ContentsClientBridge (long)
   * @param caller (org.chromium.webview.g3webcore.G3ContentsClientBridge)
   * @param id (int)
   * @param certChain (byte[][])
   * @param androidKey (java.security.PrivateKey)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3ContentsClientBridge_provideClientCertificateResponse(
          long nativeG3ContentsClientBridge, Object caller, int id, byte[][] certChain,
          Object androidKey);

  /**
   * org.chromium.webview.g3webcore.G3ContentsStatics.clearClientCertPreferences
   * @param callback (java.lang.Runnable)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3ContentsStatics_clearClientCertPreferences(
          Object callback);

  /**
   * org.chromium.webview.g3webcore.G3ContentsStatics.getProductVersion
   * @return (java.lang.String)
   */
  public static final native String org_chromium_webview_g3webcore_G3ContentsStatics_getProductVersion(
  );

  /**
   * org.chromium.webview.g3webcore.G3ContentsStatics.getUnreachableWebDataUrl
   * @return (java.lang.String)
   */
  public static final native String org_chromium_webview_g3webcore_G3ContentsStatics_getUnreachableWebDataUrl(
  );

  /**
   * org.chromium.webview.g3webcore.G3ContentsStatics.isMultiProcessEnabled
   * @return (boolean)
   */
  public static final native boolean org_chromium_webview_g3webcore_G3ContentsStatics_isMultiProcessEnabled(
  );

  /**
   * org.chromium.webview.g3webcore.G3ContentsStatics.setCheckClearTextPermitted
   * @param permitted (boolean)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3ContentsStatics_setCheckClearTextPermitted(
          boolean permitted);

  /**
   * org.chromium.webview.g3webcore.G3PermissionRequest.destroy
   * @param nativeG3PermissionRequest (long)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3PermissionRequest_destroy(
          long nativeG3PermissionRequest);

  /**
   * org.chromium.webview.g3webcore.G3PermissionRequest.onAccept
   * @param nativeG3PermissionRequest (long)
   * @param caller (org.chromium.webview.g3webcore.G3PermissionRequest)
   * @param allowed (boolean)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3PermissionRequest_onAccept(
          long nativeG3PermissionRequest, Object caller, boolean allowed);

  /**
   * org.chromium.webview.g3webcore.G3Settings.destroy
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_destroy(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.getDefaultUserAgent
   * @return (java.lang.String)
   */
  public static final native String org_chromium_webview_g3webcore_G3Settings_getDefaultUserAgent();

  /**
   * org.chromium.webview.g3webcore.G3Settings.init
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @param webContents (org.chromium.content_public.browser.WebContents)
   * @return (long)
   */
  public static final native long org_chromium_webview_g3webcore_G3Settings_init(Object caller,
                                                                                 Object webContents);

  /**
   * org.chromium.webview.g3webcore.G3Settings.populateWebPreferencesLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @param webPrefsPtr (long)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_populateWebPreferencesLocked(
          long nativeG3Settings, Object caller, long webPrefsPtr);

  /**
   * org.chromium.webview.g3webcore.G3Settings.resetScrollAndScaleState
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_resetScrollAndScaleState(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateAllowFileAccessLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateAllowFileAccessLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateCookiePolicyLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateCookiePolicyLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateEverythingLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateEverythingLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateFormDataPreferencesLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateFormDataPreferencesLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateInitialPageScaleLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateInitialPageScaleLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateOffscreenPreRasterLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateOffscreenPreRasterLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateRendererPreferencesLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateRendererPreferencesLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateUserAgentLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateUserAgentLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateWebkitPreferencesLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateWebkitPreferencesLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3Settings.updateWillSuppressErrorStateLocked
   * @param nativeG3Settings (long)
   * @param caller (org.chromium.webview.g3webcore.G3Settings)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3Settings_updateWillSuppressErrorStateLocked(
          long nativeG3Settings, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3WebContentsDelegate.filesSelectedInChooser
   * @param processId (int)
   * @param renderId (int)
   * @param modeFlags (int)
   * @param filePath (java.lang.String[])
   * @param displayName (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebContentsDelegate_filesSelectedInChooser(
          int processId, int renderId, int modeFlags, String[] filePath, String[] displayName);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.addVisitedLinks
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @param visitedLinks (java.lang.String[])
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebCore_addVisitedLinks(
          long nativeG3WebCore, Object caller, String[] visitedLinks);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.clearCache
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @param includeDiskFiles (boolean)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebCore_clearCache(
          long nativeG3WebCore, Object caller, boolean includeDiskFiles);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.releasePopupG3Contents
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @return (long)
   */
  public static final native long org_chromium_webview_g3webcore_G3WebCore_releasePopupG3Contents(
          long nativeG3WebCore, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.resumeLoadingCreatedPopupWebContents
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebCore_resumeLoadingCreatedPopupWebContents(
          long nativeG3WebCore, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.destroy
   * @param nativeG3WebCore (long)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebCore_destroy(
          long nativeG3WebCore);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.getWebContents
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @return (org.chromium.content_public.browser.WebContents)
   */
  public static final native Object org_chromium_webview_g3webcore_G3WebCore_getWebContents(
          long nativeG3WebCore, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.getBrowserContext
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @return (org.chromium.webview.g3webcore.G3BrowserContext)
   */
  public static final native Object org_chromium_webview_g3webcore_G3WebCore_getBrowserContext(
          long nativeG3WebCore, Object caller);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.initNative
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @return (long)
   */
  public static final native long org_chromium_webview_g3webcore_G3WebCore_initNative(
          Object caller);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.insertVisualStateCallback
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @param requestId (long)
   * @param callback (org.chromium.webview.g3webcore.G3WebCore.VisualStateCallback)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebCore_insertVisualStateCallback(
          long nativeG3WebCore, Object caller, long requestId, Object callback);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.invokeGeolocationCallback
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @param value (boolean)
   * @param requestingFrame (java.lang.String)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebCore_invokeGeolocationCallback(
          long nativeG3WebCore, Object caller, boolean value, String requestingFrame);

  /**
   * org.chromium.webview.g3webcore.G3WebCore.setJavaPeers
   * @param nativeG3WebCore (long)
   * @param caller (org.chromium.webview.g3webcore.G3WebCore)
   * @param g3WebCore (org.chromium.webview.g3webcore.G3WebCore)
   * @param webViewWebContentsDelegate (org.chromium.webview.g3webcore.G3WebContentsDelegate)
   * @param contentsClientBridge (org.chromium.webview.g3webcore.G3ContentsClientBridge)
   * @param ioThreadClient (org.chromium.webview.g3webcore.G3ContentsIoThreadClient)
   * @return (void)
   */
  public static final native void org_chromium_webview_g3webcore_G3WebCore_setJavaPeers(
          long nativeG3WebCore, Object caller, Object g3WebCore, Object webViewWebContentsDelegate,
          Object contentsClientBridge, Object ioThreadClient);

}
