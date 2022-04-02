package com.tele.tscheckeye.model.lib_tools.util;

import android.app.Activity;
import android.webkit.JavascriptInterface;

/**
 * js调用android工具
 */
public class JavaScriptCallAndroidUtil extends Object {

    private Activity mActivity;

    public JavaScriptCallAndroidUtil(Activity mActivity) {
        this.mActivity = mActivity;
    }

    // 定义JS需要调用的方法
    // 被JS调用的方法必须加入@JavascriptInterface注解
    @JavascriptInterface
    public void hello(String msg) {
        System.out.println("JS调用了Android的hello方法");
    }

    @JavascriptInterface
    public void closePage() {
        mActivity.finish();
    }

}
