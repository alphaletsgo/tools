package cn.isif.alibs.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zh on 15/10/19.
 */
public class TimeUtil {

    private final static ThreadLocal<SimpleDateFormat> dateFormatStr = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    private final static ThreadLocal<SimpleDateFormat> dateFormatStr2 = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("MM-dd");
        }
    };

    /**
     * 将字符串转位日期类型
     *
     * @param sDate
     * @return
     */
    public static Date toDate(String sDate) {
        try {
            return dateFormatStr.get().parse(sDate);
        } catch (ParseException e) {
            return null;
        }
    }


    /**
     * 将时间格式化为5秒、1分20秒这样的形式
     *
     * @param milliseconds 时间段的秒数
     * @param accuracy     需要显示的时间的精度，该值目前有两个可用值Calendar.HOUR和Calendar.MINUTE
     * @return 返回格式化后的时间字符串
     */
    public static String formatTimeLong(long milliseconds, int accuracy) {
        String datetime = "";
        String hour = "0";
        String minute = "0";
        String seconds = "0";

        switch (accuracy) {
            case Calendar.HOUR:
                hour = (milliseconds / 3600 + "");
                milliseconds %= 3600;
                minute = (milliseconds / 60 + "");
                milliseconds %= 60;
                seconds = (milliseconds + "");
                break;
            case Calendar.MINUTE:
                minute = (milliseconds / 60 + "");
                milliseconds %= 60;
                seconds = (milliseconds + "");
                break;
        }
        if ("0".equals(hour) && "0".equals(minute)) {
            datetime = StringUtils.concat(new Object[]{
                    seconds, "秒"
            });
        } else if (!"0".equals(minute)) {
            datetime = StringUtils.concat(new Object[]{
                    minute, "分", seconds, "秒"
            });
        } else {
            datetime = StringUtils.concat(new Object[]{
                    hour, "小时", minute, "分", seconds, "秒"
            });
        }
        return datetime;
    }

    /**
     * 以友好的方式显示时间
     *
     * @param sDate
     * @return
     */
    public static String friendlyTime(long sDate) {
        Date time = new Date(sDate);
        if (time == null) {
            return "Unknown";
        }
        String fTime = "";
        Calendar cal = Calendar.getInstance();

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        String sb = time.getHours() < 12 ? "上午" : "下午";
        if (days == 0) {
            return sb + new SimpleDateFormat("HH:mm").format(time);
        } else if (days == 1) {
            fTime = "昨天  " + sb + new SimpleDateFormat("HH:mm").format(time);
        } else if (days == 2) {
            fTime = "前天  " + sb + new SimpleDateFormat("HH:mm").format(time);
        } else if (days > 2) {
            fTime = dateFormatStr2.get().format(time) + sb + new SimpleDateFormat("HH:mm").format(time);
        }
        return fTime;
    }

    /**
     * 以友好的方式显示时间
     *
     * @param sDate
     * @return
     */
    public static String friendlyTimeWeek(long sDate) {
        Date time = new Date(sDate);
        if (time == null) {
            return "Unknown";
        }
        String fTime = "";
        Calendar cal = Calendar.getInstance();

        long lt = time.getTime() / 86400000;
        long ct = cal.getTimeInMillis() / 86400000;
        int days = (int) (ct - lt);
        String sb = time.getHours() < 12 ? "上午" : "下午";
        if (days == 0) {
            return sb + new SimpleDateFormat("HH:mm").format(time);
        } else if (days == 1) {
            fTime = "昨天";
        } else if (2 <= days && days < 7) {
            fTime = getWeekOfDate(time);
        } else if (days > 7) {
            fTime = dateFormatStr2.get().format(time);
        }
        return fTime;
    }

    /**
     * 匹配中文星期
     *
     * @param dt
     * @return
     */
    public static String getWeekOfDate(Date dt) {
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }

    /**
     * 判断给定字符串时间是否为今日
     *
     * @param sDate
     * @return boolean
     */
    public static boolean isToday(String sDate) {
        boolean b = false;
        Date time = toDate(sDate);
        Date today = new Date();
        if (time != null) {
            String nowDate = dateFormatStr2.get().format(today);
            String timeDate = dateFormatStr2.get().format(time);
            if (nowDate.equals(timeDate)) {
                b = true;
            }
        }
        return b;
    }

}
