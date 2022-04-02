package com.tele.tscheckeye.model.lib_tools.util;

import android.widget.Toast;

import com.tele.tscheckeye.model.lib_tools.MyApplication;

/**
 * Toast工具
 */
public class ToastUtil {

    private static Toast mToast = null;

    static {
        mToast = Toast.makeText(MyApplication.getInstance(), "", Toast.LENGTH_SHORT);
    }

    public static void showToast(String str) {
        try {
            mToast.setText(str);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showToast(int resId) {
        try {
            mToast.setText(resId);
            mToast.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭当前Toast
     */
    public static void cancelCurrentToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

}
