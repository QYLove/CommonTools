package com.tele.tscheckeye.model.lib_tools.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具
 * 1，判断密码
 * 2，判断手机号
 */
public class RegularUtil {

    private static String PASSWORD = "^(?![0-9]+$)(?![a-z]+$)[0-9a-z]{6,19}$";
    private static String PHONE = "^1[3|4|5|6|7|8|9][0-9]\\d{8}$";

    /**
     * 判断手机号输入规则
     *
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone) {
        Pattern pattern = Pattern.compile(PHONE);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }

    /**
     * 判断密码规则（6-20位数字和小写英文字母）
     *
     * @param password
     * @return
     */
    public static boolean isPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
