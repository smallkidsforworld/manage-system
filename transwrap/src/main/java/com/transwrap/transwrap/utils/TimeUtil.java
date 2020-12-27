package com.transwrap.transwrap.utils;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @description:
 * @author: yml
 * @time: 2020/12/27
 */

public class TimeUtil {

    private static final LocalTime localTime = LocalTime.now();
    private static final LocalDate localDate = LocalDate.now();

    public static String getCurrentDay() {
        return localDate.atStartOfDay().toLocalDate().toString();
    }

    public static String getCurrentTime() {
        return StringUtil.split(':', localTime.getHour(), localTime.getMinute(), localTime.getSecond());
    }

    public static String getDayWithTime() {
        return getCurrentTime() + " " + getCurrentDay();
    }

}
