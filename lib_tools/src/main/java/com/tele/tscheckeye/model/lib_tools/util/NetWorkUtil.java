package com.tele.tscheckeye.model.lib_tools.util;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * 网络状态工具
 * 1，检查网络状态
 */
public class NetWorkUtil {

    /**
     * 检查当前网络状态
     *
     * @param context
     * @return
     */
    public static boolean checkNetWorkState(Context context) {
        boolean flag = false;
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null) {
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        return flag;
    }

}
