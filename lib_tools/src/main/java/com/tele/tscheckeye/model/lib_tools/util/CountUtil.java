package com.tele.tscheckeye.model.lib_tools.util;

import java.math.BigDecimal;

/**
 * 计算工具类
 * 1，加
 * 2，减
 * 3，乘
 * 4，除
 * 5，比较大小
 */
public class CountUtil {

    /**
     * 加法
     * 计算两个传入字符串数字的和
     *
     * @param s1
     * @param s2
     * @return 字符串数字
     */
    public static String add(String s1, String s2) {
        String s = "";
        try {
            BigDecimal b1 = new BigDecimal(s1);
            BigDecimal b2 = new BigDecimal(s2);
            s = b1.add(b2).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 减法
     * 计算两个传入字符串数字的差
     *
     * @param s1
     * @param s2
     * @return 字符串数字
     */
    public static String sub(String s1, String s2) {
        String s = "";
        try {
            BigDecimal b1 = new BigDecimal(s1);
            BigDecimal b2 = new BigDecimal(s2);
            s = b1.subtract(b2).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 减法
     * 计算两个传入字符串数字的差
     *
     * @param s1
     * @param s2
     * @return 字符串数字
     */
    public static String subZero(String s1, String s2) {
        String s = "0";
        try {
            BigDecimal b1 = new BigDecimal(s1);
            BigDecimal b2 = new BigDecimal(s2);
            s = b1.subtract(b2).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 提供精确乘法运算的mul方法
     *
     * @param s1 被乘数
     * @param s2 乘数
     * @return 两个参数的积
     */
    public static String mul(String s1, String s2) {
        String s = "";
        try {
            BigDecimal b1 = new BigDecimal(s1);
            BigDecimal b2 = new BigDecimal(s2);
            s = b1.multiply(b2).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 提供精确的除法运算方法div
     *
     * @param value1 被除数
     * @param value2 除数
     * @param scale  精确范围
     * @return 两个参数的商
     * @throws IllegalAccessException
     */
    public static String div(String value1, String value2, int scale) throws IllegalAccessException {
        String s = "";
        try {
            //如果精确范围小于0，抛出异常信息
            if (scale < 0) {
                throw new IllegalAccessException("精确度不能小于0");
            }
            BigDecimal b1 = new BigDecimal(value1);
            BigDecimal b2 = new BigDecimal(value2);
            //默认保留两位会有错误，这里设置保留小数点后4位
            s = b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    /**
     * 比大小
     * 比较两个数值型字符串的大小
     *
     * @param s1
     * @param s2
     * @return true:大于 等于    false:小于
     */
    public static boolean compare(String s1, String s2) {
        int result = 0;
        try {
            BigDecimal data1 = new BigDecimal(s1);
            BigDecimal data2 = new BigDecimal(s2);
            result = data1.compareTo(data2);
        } catch (Exception e) {
        }

        if (result >= 0) {
            return true;
        } else {
            return false;
        }
    }

}
