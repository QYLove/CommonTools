package com.tele.tscheckeye.model.lib_tools.util;

import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具
 * 1，时间比较
 * 2，获取当前毫秒值
 * 3，获取当前时间Date
 * 4，获取当前时间年月日时分秒
 * 5，获取当前时间年月日
 * 6，获取当前时间前一个月时间Date
 * 7，获取当前时间前一个月时间年月日时分秒
 * 8，获取当前时间前一个月时间年月日
 * 9，获取传入时间的年月日时分秒
 * 10，获取传入时间的年月日
 * 11，获取传入时间的年月
 * 12，判断是否超过一个月
 * 13，
 */
public class DateUtil {

    /**
     * 判断两个Date的大小
     *
     * @param date1
     * @param date2
     * @return true 1大于等于2
     * false  1小于2
     */
    public static boolean compareSize(Date date1, Date date2) {
        boolean flag = false;
        if (date1 != null && date2 != null) {
            if (date1.getTime() >= date2.getTime()) {
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 获取当前时间的毫秒值
     *
     * @return
     */
    public static String getCurrentTime() {
        long time = new Date().getTime();
        return time + "";
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDate_YMDHMS() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentDate_YMD() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * 获取当前时间前一个月时间
     *
     * @return
     */
    public static Date getMonthAgoDate() {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        c.add(Calendar.DAY_OF_MONTH, +1);

        Date date = c.getTime();
        return date;
    }

    /**
     * 获取当前时间前一个月时间
     *
     * @return
     */
    public static String getMonthAgo_YMDHMS() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        c.add(Calendar.DAY_OF_MONTH, +1);

        Date date = c.getTime();
        return df.format(date);
    }

    /**
     * 获取当前时间前一个月时间
     *
     * @return
     */
    public static String getMonthAgo_YMD() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MONTH, -1);
        c.add(Calendar.DAY_OF_MONTH, +1);

        Date date = c.getTime();
        return df.format(date);
    }

    /**
     * 获取传入时间的 年月日 时分秒
     *
     * @param date
     * @return
     */
    public static String getData_YMDHMS(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 获取传入时间的 年月日
     *
     * @param date
     * @return
     */
    public static String getData_YMD(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(date);
    }

    /**
     * 获取传入时间的年月
     *
     * @param date
     * @return
     */
    public static String getData_YM(Date date) {
        String data_ymd = getData_YMD(date);
        String substring = data_ymd.substring(0, 7);
        return substring;
    }

    /**
     * 判断 时间是否超过一个月
     *
     * @param start
     * @param end
     * @return
     */
    public static boolean isMonth(Date start, Date end) {
        Date monthAgo = isMonthAgo(end);

        if (start.getTime() >= monthAgo.getTime()) {
            return true;
        } else {
            if (getData_YMD(start).equals(getData_YMD(monthAgo))) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 获取当前时间 一个月前的Date
     *
     * @param start
     * @return
     */
    public static Date isMonthAgo(Date start) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.MONTH, -1);
        c.add(Calendar.DAY_OF_MONTH, +1);

        Date date = c.getTime();
        return date;
    }

    // 获得当天24点时间
    public static Date getTimesnight() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 获得当天0点时间
    public static Date getTimesmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    // 获得本周一0点时间
    public static Date getTimesWeekmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    // 获得本月第一天0点时间
    public static Date getTimesMonthmorning() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    //获取前3个月时间
    public static Date getTimesThreeMonthmorning() {
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(new Date());//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -3);  //设置为前3月
        return calendar.getTime();
    }

    //获取前6个月时间
    public static Date getTimesSixMonthmorning() {
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(new Date());//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -6);  //设置为前3月
        return calendar.getTime();
    }

    public static Date getTodayEnd() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getDayStart(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getDayEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取本周周一 时间  年月日
     *
     * @return
     */
    public static String getWeekFristDay() {
        Date timesWeekmorning = getTimesWeekmorning();
        return getData_YMD(timesWeekmorning);
    }

    /**
     * 获取本月第一天时间  年月日
     *
     * @return
     */
    public static String getMonthFirstDay() {
        Date timesMonthmorning = getTimesMonthmorning();
        return getData_YMD(timesMonthmorning);
    }

    /**
     * 获取date前一天时间
     *
     * @param date
     * @return
     */
    public static Date getDayBefore(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, -1);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获取date后一天时间
     *
     * @param date
     * @return
     */
    public static Date getDayAfter(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE, +1);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获取传入的date的上个月第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获取传入的date的上个月最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获取传入的date的下个月的第一天
     *
     * @param date
     * @return
     */
    public static Date getNextFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 获取传入的date的下个月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getNextLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 根据date获取上一周的周一
     *
     * @param date
     * @return
     */
    public static Date getFirstOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, -1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 根据date获取上一周的周日
     *
     * @param date
     * @return
     */
    public static Date getLastOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, -1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 根据date获取下一周的周一
     *
     * @param date
     * @return
     */
    public static Date getNextFirstOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, 1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date time = calendar.getTime();
        return time;
    }

    /**
     * 根据date获取下一周的周日
     *
     * @param date
     * @return
     */
    public static Date getNextLastOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.add(Calendar.DATE, 1 * 7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date time = calendar.getTime();
        return time;
    }

    public static Date getCurFirstOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int last = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, last);
        Date time = calendar.getTime();
        return time;
    }

    public static Date getCurLastOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int last = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, last);
        Date time = calendar.getTime();
        return time;
    }

    public static Date getCurFirstOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int d = 0;
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - calendar.get(Calendar.DAY_OF_WEEK);
        }
        calendar.add(Calendar.DAY_OF_WEEK, d);
        Date time = calendar.getTime();
        return time;
    }

    public static Date getCurLastOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int d = 0;
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        } else {
            d = 2 - calendar.get(Calendar.DAY_OF_WEEK);
        }
        calendar.add(Calendar.DAY_OF_WEEK, 6);
        Date time = calendar.getTime();
        return time;
    }


    /**
     * 当前时间
     *
     * @return
     */
    public static String getNowDate_YMD_HMS() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = dateFormat.format(new java.util.Date());// 当前时间
        return nowTime;
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static String getNowDate_YMD() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = dateFormat.format(new java.util.Date());// 当前时间
        return nowTime;
    }

    /**
     * 获取传入的Date时间 的 前day天
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - day);
        return calendar.getTime();
    }

    /**
     * 获取传入的Date时间 的 后day天
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + day);
        return calendar.getTime();
    }

    /**
     * 根据当前毫秒值获取Date
     *
     * @param time
     * @return
     */
    public static Date getDateByString(String time) {
        Date date = null;
        if (!TextUtils.isEmpty(time)) {
            try {
                long l = Long.parseLong(time);
                //根据毫秒值声明一个date类型的时间
                Date d = new Date(l);
                //把date类型的时间转换为string
                String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
                //把string类型转换为date类型
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                date = sdf.parse(format);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return date;
    }

    /**
     * date2比date1多的天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1 = cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if (year1 != year2)   //同一年
        {
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0)    //闰年
                {
                    timeDistance += 366;
                } else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2 - day1);
        } else    //不同年
        {
            System.out.println("判断day2 - day1 : " + (day2 - day1));
            return day2 - day1;
        }
    }

    /**
     * 比较两个日期的大小，日期格式为yyyy-MM-dd
     *
     * @param str1 the first date
     * @param str2 the second date
     * @return true <br/>false
     */
    public static boolean isDate2Bigger(String str1, String str2) {
        boolean isBigger = false;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dt1 = null;
        Date dt2 = null;
        try {
            dt1 = sdf.parse(str1);
            dt2 = sdf.parse(str2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (dt1.getTime() > dt2.getTime()) {
            isBigger = false;
        } else if (dt1.getTime() <= dt2.getTime()) {
            isBigger = true;
        }
        return isBigger;
    }
}
