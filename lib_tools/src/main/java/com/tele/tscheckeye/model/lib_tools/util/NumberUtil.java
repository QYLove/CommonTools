package com.tele.tscheckeye.model.lib_tools.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 数字工具类
 * 1，判断是否为0
 * 2，去除无效的0
 * 3，数字取整
 * 4，字符串转float
 * 5，数字保留两位小数
 * 6，元转分
 * 7，分转元
 */
public class NumberUtil {

    /**
     * 判断字符串是否为0
     *
     * @param s
     * @return
     */
    public static boolean isZero(String s) {
        boolean flag = false;
        if ("0".equals(s) || "0.0".equals(s) || "0.00".equals(s) || "".equals(s) || s == null) {
            flag = true;
        }
        return flag;
    }

    /**
     * 去除无效的0
     *
     * @param s
     * @return
     */
    public static String removeZeroAndDot(String s) {
        String result = "0";
        try {
            BigDecimal b = new BigDecimal(s);
            result = b.toString();
            if (result.indexOf(".") > 0) {
                result = result.replaceAll("0+?$", "");//去掉多余的0
                result = result.replaceAll("[.]$", "");//如最后一位是.则去掉
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 去除无效的0
     *
     * @param s
     * @return
     */
    public static String removeZero(String s) {
        return removeZeroAndDot(formatTwo(s));
    }

    /**
     * 数字取整数
     *
     * @param value string
     * @return
     */
    public static String formatInt(String value) {
        String s = "0";
        try {
            Double d = Double.valueOf(value);
            DecimalFormat decimalFormat = new DecimalFormat("0");
            s = decimalFormat.format(d);
        } catch (Exception e) {
        }
        return s;
    }

    /**
     * String 转 float
     *
     * @param value
     * @return
     */
    public static float formatFloat(String value) {
        float f = 0;
        try {
            f = Float.valueOf(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    /**
     * 数字保留两位小数
     *
     * @param value
     * @return
     */
    public static String formatTwo(String value) {
        String s = "0.00";
        try {
            BigDecimal bd = new BigDecimal(value);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            s = bd.toString();
        } catch (Exception e) {
        }
        return s;
    }

    /**
     * 分转元
     *
     * @param fen
     * @return
     */
    public static String fenToYuan(String fen) {
        String yuan = "";
        try {
            Double d = Double.valueOf(fen);
            yuan = String.valueOf(d / 100);
        } catch (Exception e) {
        }
        return yuan;
    }

    /**
     * 元转分
     *
     * @param yuan
     * @return
     */
    public static String yuanToFen(String yuan) {
        return formatInt(CountUtil.mul(yuan, "100"));
    }

}
