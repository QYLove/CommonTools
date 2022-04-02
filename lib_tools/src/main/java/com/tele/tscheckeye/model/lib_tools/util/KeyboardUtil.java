package com.tele.tscheckeye.model.lib_tools.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;

/**
 * 软键盘工具
 * 1，弹出软键盘
 * 2，隐藏软键盘
 */
public class KeyboardUtil {

    public static void showKeyboard(@NonNull final View view) {
        showKeyboard(view, 0);
    }

    public static void showKeyboard(@NonNull final View view, final int flag) {
        final InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        if (!imm.showSoftInput(view, flag)) {
            view.postDelayed(() -> imm.showSoftInput(view, flag), 100);
        }
    }

    public static void hideIme(@NonNull Activity context) {
        hideIme(context.getWindow().peekDecorView());
    }

    public static void hideIme(@NonNull View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
