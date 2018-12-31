package com.mine.sort.swapsort;

import com.mine.util.ArrayUtil;

import java.util.Arrays;

/**
 * 冒泡排序,循环访问要排序的数列，一次比较相邻的两个元素，是将最大值冒出来还是将最小值冒出来，决定了升降序
 * 重点在于：每一循环数列，一次比较相邻的两个元素，如果顺序不符合要求则交换，结果便是在最后的元素应该会是最大的数/最小的数
 * 时间复杂度，O(n^2)
 */
public class BubbleSort {

    /**
     * 顺序排序,从小到大
     *
     * @param arr
     * @return
     */
    public void ascBubbleSort(int[] arr) {
        //外层循环次数，每次循环确定一个最值，比如第一次确定最大值，第二次确定次最大值，因此循环arr.length-1次
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环找到需要交换的两个值的位置
            //方法1：直接使用arr.length-1次，时间复杂度为：O(n^2)
            //方法2：直接使用arr.length-i-1次，时间复杂度为：O(n^2),时间复杂度相等
            //下面的是一趟冒泡排序
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
        }
    }


    /**
     * test
     *
     * @param args
     */
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = {1, 3, 2, 3, 4, 5, 4, 5, 6, 7, 6, 5, 4, 3, 2};
        bubbleSort.ascBubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
