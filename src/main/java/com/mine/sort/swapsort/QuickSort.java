package com.mine.sort.swapsort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 快速排序
 * 是对冒泡排序的一种改进，又称为分区交换法
 * 通常以第一个元素作为支点
 * 一趟快速排序，就是一次划分成左右两个部分
 * 注意，快速排序并不是同时移动的，而是先移动大的，然后移动小的，因此最终肯定是会想碰到的
 * 不适用于记录基本有序的场合
 * 快速排序涉及到了递归
 */
public class QuickSort {

    public void asc(int[] arr, int low, int high) {
        if (low < high) {
            int partition = partition(arr, low, high);
            asc(arr, low, partition - 1);
            asc(arr, partition + 1, high);
        }
    }

    /**
     * 一趟快速排序,返回支点位置
     */
    public int partition(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                --high;
            }
            arr[low] = arr[high];  //此时high所在的这个位置应该被替换掉，等待low的值
            while (low < high && arr[low] < temp) {
                ++low;
            }
            arr[high] = arr[low];   //此时，low处的值应该为空，等待下一个high的值或者直接填入temp的值
        }
        arr[low] = temp;
        return low;
    }


    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 50};
        QuickSort quickSort = new QuickSort();
        quickSort.asc(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));   //[13, 27, 38, 49, 50, 65, 76, 97]
    }
}
