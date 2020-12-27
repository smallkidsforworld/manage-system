package com.transwrap.transwrap.utils;


/**
 * @description:
 * @author: yml
 * @time: 2020/12/27
 */

public class StringUtil {

    public static String split(char split, String... str) {
        StringBuilder result = new StringBuilder();
        for (String s : str)
            result.append(s).append(split);
        return result.substring(0, result.length() - 1);
    }

    public static String split(char split, int... str) {
        StringBuilder result = new StringBuilder();
        for (int s : str)
            result.append(s).append(split);
        return result.substring(0, result.length() - 1);
    }
}
