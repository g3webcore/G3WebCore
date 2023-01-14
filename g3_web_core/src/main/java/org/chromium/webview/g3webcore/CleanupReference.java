package org.chromium.webview.g3webcore;


import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import org.chromium.base.Log;
import org.chromium.base.ThreadUtils;
import org.chromium.base.TraceEvent;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

public class CleanupReference extends WeakReference<Object> {
    private static final String TAG = "CleanupReference";

    private static final boolean DEBUG = false;
    private static ReferenceQueue<Object> sGcQueue = new ReferenceQueue<Object>();
    private static Object sCleanupMonitor = new Object();

    private static final Thread sReaperThread = new Thread(TAG) {
        @Override
        @SuppressWarnings("WaitNotInLoop")
        public void run() {
            while (true) {
                try {
                    CleanupReference ref = (CleanupReference) sGcQueue.remove();
                    if (DEBUG) Log.d(TAG, "removed one ref from GC queue");
                    synchronized (sCleanupMonitor) {
                        Message.obtain(LazyHolder.sHandler, REMOVE_REF, ref).sendToTarget();
                        sCleanupMonitor.wait(500);
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Queue remove exception:", e);
                }
            }
        }
    };

    static {
        sReaperThread.setDaemon(true);
        sReaperThread.start();
    }

    private static final int ADD_REF = 1;
    private static final int REMOVE_REF = 2;

    @SuppressLint("HandlerLeak")
    private static class LazyHolder {
        static final Handler sHandler = new Handler(ThreadUtils.getUiThreadLooper()) {
            @Override
            public void handleMessage(Message msg) {
                try {
                    TraceEvent.begin("CleanupReference.LazyHolder.handleMessage");
                    CleanupReference ref = (CleanupReference) msg.obj;
                    switch (msg.what) {
                        case ADD_REF:
                            sRefs.add(ref);
                            break;
                        case REMOVE_REF:
                            ref.runCleanupTaskInternal();
                            break;
                        default:
                            Log.e(TAG, "Bad message=%d", msg.what);
                            break;
                    }

                    if (DEBUG) Log.d(TAG, "will try and cleanup; max = %d", sRefs.size());

                    synchronized (sCleanupMonitor) {
                        while ((ref = (CleanupReference) sGcQueue.poll()) != null) {
                            ref.runCleanupTaskInternal();
                        }
                        sCleanupMonitor.notifyAll();
                    }
                } finally {
                    TraceEvent.end("CleanupReference.LazyHolder.handleMessage");
                }
            }
        };
    }

    /**
     * Keep a strong reference to {@link CleanupReference} so that it will
     * actually get enqueued.
     * Only accessed on the UI thread.
     */
    private static Set<CleanupReference> sRefs = new HashSet<CleanupReference>();

    private Runnable mCleanupTask;

    /**
     * @param obj the object whose loss of reachability should trigger the
     *            cleanup task.
     * @param cleanupTask the task to run once obj loses reachability.
     */
    public CleanupReference(Object obj, Runnable cleanupTask) {
        super(obj, sGcQueue);
        if (DEBUG) Log.d(TAG, "+++ CREATED ONE REF");
        mCleanupTask = cleanupTask;
        handleOnUiThread(ADD_REF);
    }

    /**
     * Clear the cleanup task {@link Runnable} so that nothing will be done
     * after garbage collection.
     */
    public void cleanupNow() {
        handleOnUiThread(REMOVE_REF);
    }

    public boolean hasCleanedUp() {
        return mCleanupTask == null;
    }

    private void handleOnUiThread(int what) {
        Message msg = Message.obtain(LazyHolder.sHandler, what, this);
        if (Looper.myLooper() == msg.getTarget().getLooper()) {
            msg.getTarget().handleMessage(msg);
            msg.recycle();
        } else {
            msg.sendToTarget();
        }
    }

    private void runCleanupTaskInternal() {
        if (DEBUG) Log.d(TAG, "runCleanupTaskInternal");
        sRefs.remove(this);
        Runnable cleanupTask = mCleanupTask;
        mCleanupTask = null;
        if (cleanupTask != null) {
            if (DEBUG) Log.i(TAG, "--- CLEANING ONE REF");
            cleanupTask.run();
        }
        clear();
    }
}