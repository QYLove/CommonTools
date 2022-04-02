package com.tele.tscheckeye.model.lib_tools.util;

import static com.tele.tscheckeye.model.lib_tools.Constant.logState;
import static com.tele.tscheckeye.model.lib_tools.Constant.TAG;

import android.util.Log;

/**
 * 日志工具
 */
public class LogUtil {

    public static void logD(String msg) {
        if (logState) {
            Log.d(TAG, msg);
        }
    }

    public static void logD(String tag, String msg) {
        if (logState) {
            Log.d(tag, msg);
        }
    }

    public static void logE(String msg) {
        if (logState) {
            Log.e(TAG, msg);
        }
    }

    public static void logE(String tag, String msg) {
        if (logState) {
            Log.e(tag, msg);
        }
    }

    public static void logW(String msg) {
        if (logState) {
            Log.w(TAG, msg);
        }
    }

    public static void logW(String tag, String msg) {
        if (logState) {
            Log.w(tag, msg);
        }
    }

    public static void logI(String msg) {
        if (logState) {
            Log.i(TAG, msg);
        }
    }

    public static void logI(String tag, String msg) {
        if (logState) {
            Log.i(tag, msg);
        }
    }

    public static void logV(String msg) {
        if (logState) {
            Log.v(TAG, msg);
        }
    }

    public static void logV(String tag, String msg) {
        if (logState) {
            Log.v(tag, msg);
        }
    }
}
