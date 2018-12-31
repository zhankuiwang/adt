package com.mine.sort.selectsort;

import com.mine.util.ArrayUtil;

import java.util.Arrays;

/**
 * 直接选择排序
 */
public class StraightSelectionSort {

    /**
     * 直接选择排序
     *
     * @param arr
     */
    public void asc(int[] arr) {
        //外层循环，确定选择的点，也就是哪一个位置的元素需要去替换
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环，是一趟操作，循环i后面的元素，找到最小的那个替换进来
            //交换排序，一趟下来，并不是为了交换，而是为了寻找到一个最小值的坐标位置，只需要交换一次
            //注意，这个也是和冒泡排序最大的一个区别，这里可以实现交换次数的减少，最终交换次数可以直接变为O（n）
            int target = i + 1;
            for (int j = target; j < arr.length; j++) {
                if (arr[j] < arr[target]) {
                    target = j;
                }
            }
            //然后再去交换,在c语言的算法中会比较target和i是否相等，这里不用比较了，因为数组下表已经限制了不会相等
            ArrayUtil.swap(arr, i, target);
        }
    }

    public static void main(String[] args) {
        StraightSelectionSort straightSelectionSort = new StraightSelectionSort();
        int[] arr = {33, 25, 46, 13, 58, 95, 18, 63};
        straightSelectionSort.asc(arr);
        System.out.println(Arrays.toString(arr));  //[13, 18, 25, 33, 46, 58, 63, 95]
    }
}
