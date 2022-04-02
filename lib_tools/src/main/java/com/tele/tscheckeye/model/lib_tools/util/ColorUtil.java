package com.tele.tscheckeye.model.lib_tools.util;

import android.content.Context;

import androidx.core.content.ContextCompat;

import com.tele.tscheckeye.model.lib_tools.R;

/**
 * 颜色工具
 */
public class ColorUtil {

    public static int getColor_black(Context context) {
        return getColor(context, R.color.color_black);
    }

    public static int getColor_white(Context context) {
        return getColor(context, R.color.color_white);
    }

    public static int getColor_999(Context context) {
        return getColor(context, R.color.color_333);
    }

    public static int getColor_666(Context context) {
        return getColor(context, R.color.color_666);
    }

    public static int getColor_333(Context context) {
        return getColor(context, R.color.color_333);
    }

    private static int getColor(Context context, int id) {
        return ContextCompat.getColor(context, id);
    }

}
