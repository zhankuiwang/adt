package com.mine.sort.selectsort;

import com.mine.util.ArrayUtil;

import java.util.Arrays;

/**
 * 直接选择排序
 * 注意【1】：区别冒泡排序，没有那么多的交换；和插入排序区别，交换获得的位置并不是插入；选择一个最小值，与arr[0]交换位置......
 * 注意【2】：选择排序，只需要一个targetIndex的临时量即可，找到这个索引后，和i位置的元素进行移动
 * 注意【3】：for循环中，第一次的循环也会去跑判断条件
 */
public class StraightSelectionSort {


    /**
     * 直接选择排序是选择排序的一种，首先通过选择找到最值位置的索引，然后将当前的元素和最值元素移动
     * 选择完只需要交换最后一次即可，因此只需要找到targetIndex即可
     * 分割成了有序序列和无序序列，区分出他们的临界点i属于无序序列，且寻找最值从i+1的位置开始
     *
     * @param arr
     */
    public void ascSort(int[] arr) {
        //外层需要多少趟，总共是n个元素，需要n-1趟，最后那个就不考虑了
        //已排序记录，待排序记录。从待排序记录中选择最小值
        //i代表 需要替换的位置的索引
        int targetIndex;
        for (int i = 0; i < arr.length; i++) {
            //内层循环，是一趟操作，循环i后面的元素，找到最小的那个替换进来，多次比较但只需要一次替换，也是和交换排序最大的区别
            //注1：可以直接把targetIndex作为下一次循环的循环变量，但是，会出现数组下标越界的可能，因为targetIndex++超出了length，但++操作还是执行了
            //注2：i也是待排序序列中的值，因此，targetIndex初始化必须是i，因为这里是一个基准值，后续有可能不做交换，所以有一个判断
            //注3：i是无序序列的第一个值，但是寻找无序序列中最小的值，确是从i+1的位置开始寻找的，这个需要注意
            //注4：想象着下标index的移动即可，一开始在i位置，有可能移动到i+XX位置，然后再移动到i+XXX位置
            targetIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[targetIndex]) {
                    targetIndex = j;
                }
            }
            if (targetIndex != i) {
                ArrayUtil.swap(arr, i, targetIndex);
            }

        }
    }

    public static void main(String[] args) {
        StraightSelectionSort straightSelectionSort = new StraightSelectionSort();
        int[] arr = {33, 25, 46, 13, 58, 95, 18, 63};
        straightSelectionSort.ascSort(arr);
        System.out.println(Arrays.toString(arr));  //[13, 18, 25, 33, 46, 58, 63, 95]
    }

}
