package com.mine.util;

public final class ArrayUtil {

    /**
     * 交换
     *
     * @param arr
     * @param aIndex
     * @param bIndex
     */
    public static void swap(int[] arr, int aIndex, int bIndex) {
        int temp = arr[aIndex];
        arr[aIndex] = arr[bIndex];
        arr[bIndex] = temp;
    }
}
