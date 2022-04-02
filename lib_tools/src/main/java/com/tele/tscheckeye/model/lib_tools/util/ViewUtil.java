package com.tele.tscheckeye.model.lib_tools.util;

import android.view.View;
import android.view.ViewGroup;

/**
 * View工具
 */
public class ViewUtil {

    /**
     * 动态设置View的宽高
     *
     * @param view
     * @param width
     */
    public static void setViewWidth(View view, int width, int height) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = width;
        layoutParams.height = height;
        view.setLayoutParams(layoutParams);
    }

}
