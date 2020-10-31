package com.transwrap.transwrap.utils;

import java.util.Random;

/**
 * @description: 数学工具类
 * @author: yml
 * @time: 2020/10/31
 */

public class MathUtil {
    private static Random random = new Random();

    public static int intRandom(int end) {
        return random.nextInt(end);
    }

    public static int intRandom(int start, int end) {
        return random.nextInt(end - start) + start;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; ++i)
            System.out.println(MathUtil.intRandom(1));
    }


}

