package com.tele.tscheckeye.model.lib_tools.util;

/**
 * 点击工具
 * 1，屏蔽连续点击事件
 */
public class ClickUtil {

    private static long lastClickTime;

    /**
     * 屏蔽快速连续点击
     *
     * @return
     */
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

}
