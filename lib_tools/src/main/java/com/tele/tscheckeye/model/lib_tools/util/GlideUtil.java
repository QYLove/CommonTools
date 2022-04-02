package com.tele.tscheckeye.model.lib_tools.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.tele.tscheckeye.model.lib_tools.R;

/**
 * glide图片工具类
 * 1，设置圆角图片
 * 2，设置图片
 * 3，清除图片
 * 4，图片预加载
 */
public class GlideUtil {

    public static void setImageView(Context mContext, String url, ImageView imageView, int errorImage, int radius) {
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(radius);
        //通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        // RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).override(300, 300);
        RequestOptions options = RequestOptions.bitmapTransform(roundedCorners).placeholder(errorImage).error(errorImage);
        Glide.with(mContext).load(url).apply(options).into(imageView);
    }

    public static void setImageView(Context mContext, String url, ImageView imageView) {
        Glide.with(mContext).load(url).apply(getOptions()).into(imageView);
    }

    public static void clearImageView(Context mContext, ImageView imageView) {
        Glide.with(mContext).clear(imageView);
    }

    /**
     * 图片预加载
     *
     * @param mContext
     * @param url
     */
    public static void preloadImageView(Context mContext, String url) {
        Glide.with(mContext).load(url).preload();
    }

    private static RequestOptions getOptions() {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(R.mipmap.icon_zhanwei)
                .error(R.mipmap.icon_zhanwei);
        return options;
    }
}
