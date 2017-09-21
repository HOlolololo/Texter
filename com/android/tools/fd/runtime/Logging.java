package com.android.tools.fd.runtime;

import android.util.Log;
import java.util.logging.Level;

public class Logging {
    public static final String LOG_TAG = "InstantRun";

    static class C00011 implements com.android.tools.fd.common.Log.Logging {
        C00011() {
        }

        public void log(Level level, String string) {
            log(level, string, null);
        }

        public boolean isLoggable(Level level) {
            if (level == Level.SEVERE) {
                return Log.isLoggable(Logging.LOG_TAG, 6);
            }
            if (level == Level.FINE) {
                return Log.isLoggable(Logging.LOG_TAG, 2);
            }
            return Log.isLoggable(Logging.LOG_TAG, 4);
        }

        public void log(Level level, String string, Throwable throwable) {
            if (level == Level.SEVERE) {
                if (throwable == null) {
                    Log.e(Logging.LOG_TAG, string);
                } else {
                    Log.e(Logging.LOG_TAG, string, throwable);
                }
            } else if (level == Level.FINE) {
                if (!Log.isLoggable(Logging.LOG_TAG, 2)) {
                    return;
                }
                if (throwable == null) {
                    Log.v(Logging.LOG_TAG, string);
                } else {
                    Log.v(Logging.LOG_TAG, string, throwable);
                }
            } else if (!Log.isLoggable(Logging.LOG_TAG, 4)) {
            } else {
                if (throwable == null) {
                    Log.i(Logging.LOG_TAG, string);
                } else {
                    Log.i(Logging.LOG_TAG, string, throwable);
                }
            }
        }
    }

    static {
        com.android.tools.fd.common.Log.logging = new C00011();
    }
}
