package org.wuxinshui.boosters.date;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间格式转换
 */
public class DateUtils {
    /**
     * 默认日期字符串格式
     */
    public static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String[] DAY_OF_WEEK = {"周一", "周二", "周三", "周四", "周五", "周六","周日"};


    public static Date parse(String date) {
        return parse(date, DEFAULT_FORMAT);
    }

    /**
     * 根据格式把字符串转化为时间
     *
     * @param date   字符串时间
     * @param format 格式
     * @return
     */
    public static Date parse(String date, String format) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        DateTimeFormatter df = DateTimeFormat.forPattern(format);
        return DateTime.parse(date, df).toDate();
    }

    /**
     * 当前时间转化成字符串
     * <p>格式yyyy-MM-dd HH:mm:ss</p>
     *
     * @return
     */
    public static String formatCurDate() {
        return format(new Date(), DEFAULT_FORMAT);
    }

    /**
     * 根据格式把时间转化成字符串
     * <p>默认格式yyyy-MM-dd HH:mm:ss</p>
     *
     * @param date 时间
     * @return
     */
    public static String format(Date date) {
        return format(date, DEFAULT_FORMAT);
    }

    /**
     * 根据格式把时间转化成字符串
     *
     * @param date   时间
     * @param format 格式
     * @return
     */
    public static String format(Date date, String format) {
        if (date == null) {
            return "";
        }
        return new DateTime(date.getTime()).toString(format);
    }

    /**
     * 根据格式把毫秒数转化成字符串
     *
     * @param milliseconds 毫秒
     * @param format       格式
     * @return
     */
    public static String format(Long milliseconds, String format) {
        if (milliseconds == null) return "";
        return new DateTime(milliseconds).toString(format);
    }


    /**
     * 根据时间添加年数
     *
     * @param date  时间
     * @param years 年
     * @return
     */
    public static Date plusYeas(Date date, int years) {
        return new DateTime(date.getTime()).plusYears(years).toDate();
    }

    /**
     * 根据时间添加天数
     *
     * @param date 时间
     * @param days 天数，可为负数
     * @return
     */
    public static Date plusDays(Date date, int days) {
        return new DateTime(date.getTime()).plusDays(days).toDate();
    }

    /**
     * 根据时间添加月数
     *
     * @param date   时间
     * @param months 月数，可为负数
     * @return
     */
    public Date plusMonths(Date date, int months) {
        return new DateTime(date.getTime()).plusMonths(months).toDate();
    }


    /**
     * 2个时间天数差
     *
     * @param start
     * @param end
     * @return
     */
    public static int daysBetween(Date start, Date end) {
        LocalDate startLd = new LocalDate(start.getTime());
        LocalDate endLd = new LocalDate(end.getTime());
        return Days.daysBetween(startLd, endLd).getDays();
    }


    /**
     * 是否为同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        String d1 = format(date1, "yyyy-MM-dd");
        String d2 = format(date2, "yyyy-MM-dd");
        return isSameDay(d1, d2);
    }


    public static boolean isSameDay(String date1, String date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        return StringUtils.equals(date1, date2);
    }

    /**
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDate(Date date1, Date date2){
       if( date1 == null || date2 == null){
           return false;
       }
        return isSameDay(date1, date2);
    }

    /**
     * 得到以当前时间转化为long
     * <p>yyyyMMddHHmmss</p>
     *
     * @return
     */
    public static Long getCurTimeNum() {
        return Long.valueOf(format(new Date(), "yyyyMMddHHmmss"));
    }

    /**
     * 获取当前时间秒
     *
     * @return
     */
    public static int getCurrentSecond() {
        Calendar calendar = Calendar.getInstance();
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        int currentMinute = calendar.get(Calendar.MINUTE);
        int currentSecond = currentHour * 3600 + currentMinute * 60;
        return currentSecond;
    }

    /**
     * dt 是否在startDt 和 endDt 范围 内
     *
     * @param dt
     * @param startDt
     * @param endDt
     * @return
     */
    public static boolean isBetween(Date dt, Date startDt, Date endDt) {
        long time = dt.getTime();
        return (startDt.getTime() <= time && time <= endDt.getTime());
    }

    public static boolean isBetween(Date startDt, Date endDt) {
        return isBetween(new Date(), startDt, endDt);
    }

    public static boolean isNotBetween(Date startDt, Date endDt) {
        return !isBetween(startDt, endDt);
    }

    public static boolean isGt(Date date1, Date date2) {
        return (date1.getTime() > date2.getTime());
    }

    public static boolean isLt(Date date1, Date date2) {
        return !isGt(date1, date2);
    }

    /**
     * 星期几
     * @param date
     * @return
     */
    public static int dayOfWeek(Date date){
        return  new DateTime(date.getTime()).getDayOfWeek();
    }


    public static String getDayOfWeek(Date date){
        Integer day = dayOfWeek(date);
        return DAY_OF_WEEK[day-1];
    }

    public static void main(String[] args) {
        //2014-10-01 15:07:43	2014-11-30 15:07:49
        /*DateUtils.parse("2014-11-30 15:07:49", DEFAULT_FORMAT);
        boolean lt = isLt(new Date(), DateUtils.parse("2014-11-30 15:07:49", DEFAULT_FORMAT));
        System.out.println(lt);*/
    }
}
