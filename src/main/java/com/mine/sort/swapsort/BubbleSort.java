package com.mine.sort.swapsort;

import com.mine.util.ArrayUtil;

import java.util.Arrays;

/**
 * 冒泡排序,循环访问要排序的数列，一次比较相邻的两个元素，是将最大值冒出来还是将最小值冒出来，决定了升降序
 * 重点在于：每一循环数列，一次比较相邻的两个元素，如果顺序不符合要求则交换，结果便是在最后的元素应该会是最大的数/最小的数
 * 时间复杂度，O(n^2)
 * 注意【1】:冒泡排序和直接插入排序相反，插入排序是在前面维护一个有序子序列（i移动），冒泡排序后是在后面冒出（j逐渐变小）
 * 注意【2】：并不是第几个元素，冒一次，出来一个最值元素，是整个序列中的最大值
 * 注意【3】：冒泡是在剩余的所有元素中找一个最值排过去，而插入排序是在剩余的元素中，按照次序随便找一个，插入进去而不是排进去
 */
public class BubbleSort {

    /**
     * 冒泡，非递减
     *
     * @param arr
     */
    public void asc(int[] arr) {
        //一共有n个元素，每一个元素都要冒泡，所以冒泡n次,也可以是n-1次，因为最后自己冒肯定还是自己，不影响
        for (int i = 0; i < arr.length; i++) {
            //每一趟，都是剩余的元素进行冒泡，冒到剩余元素的最大值位置，也就是最右边
            //实际上每一趟都是对应的一个无序序列的冒泡问题，类比于插入排序吧，只不过这个冒出来的是在最右边
            //这个剩余序列的起始元素为0，个数为arr.length-(i+1)
            for (int j = 0; j < arr.length - (i + 1); j++) {
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
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};
        bubbleSort.asc(arr);   //[13, 27, 38, 49, 49, 65, 76, 97]
        System.out.println(Arrays.toString(arr));
    }
}
