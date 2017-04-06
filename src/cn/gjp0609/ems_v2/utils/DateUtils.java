package cn.gjp0609.ems_v2.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 时间类型转换相关工具类
 * Created by gjp06 on 17.4.1.
 */
public class DateUtils {

    /**
     * 把传入字符串转换为 utilDate
     *
     * @param text    自定格式的日期字符串
     * @param pattern 自定输入字符串格式
     * @return java.util 包下的日期类型对象
     */
    public static java.util.Date getUtilDate(String text, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        java.util.Date utilDate = new java.util.Date();
        try {
            utilDate = sdf.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utilDate;
    }

    /**
     * 把传入字符串转换为 utilDate
     *
     * @param text 指定格式的日期字符串（yyyy-MM-dd）
     * @return java.util 包下的日期类型对象
     */
    public static java.util.Date getUtilDate(String text) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = new java.util.Date();
        try {
            utilDate = sdf.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utilDate;
    }

    /**
     * 把java.util 包下的日期类型对象转换为 java.sql 包下的日期类型对象
     *
     * @param utilDate java.util 包下的日期类型对象
     * @return java.sql 包下的日期类型对象
     */
    public static java.sql.Date getSqlDate(java.util.Date utilDate) {
        return new java.sql.Date(utilDate.getTime());
    }

    /**
     * 把java.util 包下的日期类型对象转换为自定格式字符串
     *
     * @param utilDate java.util 包下的日期类型对象
     * @param partten  自定输出字符串格式
     * @return 自定格式的字符串
     */
    public static String getDate(java.util.Date utilDate, String partten) {
        return new SimpleDateFormat(partten).format(utilDate.getTime());
    }

    /**
     * 把java.util 包下的日期类型对象转换为指定格式字符串（yyyy-MM-dd）
     *
     * @param utilDate java.util 包下的日期类型对象
     * @return 指定格式的字符串
     */
    public static String getDate(java.util.Date utilDate) {
        return new SimpleDateFormat("yyyy-MM-dd").format(utilDate.getTime());
    }
}
