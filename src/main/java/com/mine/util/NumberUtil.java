package com.mine.util;

public class NumberUtil {

    /**
     * 以2为底的对数，取大于等于这个数的最小整数
     *
     * @param num
     * @return
     */
    public static int log2Ceil(int num) {
        double aa = Math.log(num) / Math.log(2);
        return (int) Math.ceil(aa);
    }
}
