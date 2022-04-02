package com.tele.tscheckeye.model.lib_tools.util;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * app工具
 * 1，获取当前版本号
 * 2，获取当前版本名
 */
public class AppUtil {

    /**
     * 获取当前版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int verCode = -1;
        try {
            verCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.logD(e.getMessage());
        }
        return verCode;
    }

    /**
     * 获取当前版本名
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.logD(e.getMessage());
        }
        return verName;
    }

}
