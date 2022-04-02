package com.tele.tscheckeye.model.lib_tools.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;

/**
 * apk工具
 * 1，根据包名检查apk是否存在
 * 2，卸载apk
 */
public class ApkUtil {

    private final static String PACKAGE_NAME = "";

    /**
     * 根据包名检查apk是否存在
     *
     * @param context
     * @param packageName
     * @return
     */
    public static boolean checkApkExist(Context context, String packageName) {
        if (TextUtils.isEmpty(packageName))
            return false;
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName, PackageManager.GET_UNINSTALLED_PACKAGES);
            LogUtil.logD(info.toString());
            // Timber 是我打印 log 用的工具，这里只是打印一下 log
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            LogUtil.logD(e.toString());
            // Timber 是我打印 log 用的工具，这里只是打印一下 log
            return false;
        }
    }

    /**
     * 卸载
     *
     * @param context
     */
    public static void uninstall(Context context) {
        if (checkApkExist(context, PACKAGE_NAME)) {
            Intent intent = new Intent(Intent.ACTION_DELETE);
            intent.setData(Uri.parse("package:" + PACKAGE_NAME));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }

}
