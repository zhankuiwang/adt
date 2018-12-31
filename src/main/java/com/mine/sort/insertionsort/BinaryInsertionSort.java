package com.mine.sort.insertionsort;

import java.util.Arrays;

/**
 * 折半插入排序,是一种改进的方法
 * 和直接插入排序的区别在于，寻找位置的时候，使用了一个高位和低位的平均值的方式，而不是从0-i-1倒叙查找的方式
 * 去掉了一个j的循环，使用了while循环代替
 */
public class BinaryInsertionSort {

    /**
     * 折半插入排序
     *
     * @param arr
     */
    public void ascBinaryInsertionSort(int[] arr) {
        //仍旧是循环n-1次，和直接插入排序类似
        int low, high, m = 0;
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            low = 0;
            high = i - 1;
            while (low <= high) {
                m = (low + high) / 2;
                if (arr[m] < arr[i]) {
                    low = m + 1;     //并不是以m作为分水岭的
                } else {
                    high = m - 1;
                }
            }
            //此时需要将m的值进行替换,必须倒叙，因为涉及到了不能覆盖后续的值
            //注意：此时以哪一个值作为临界点，是low的值，而不是m的值
            //只能会出现一种结果low》high且how=high+1，并且low位置的值也需要后移，因为low的位置才是temp该在的位置
            for (int k = i - 1; k >= low; k--) {
                arr[k + 1] = arr[k];
            }
            arr[low] = temp;
        }
    }

    public static void main(String[] args) {
        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort();
        int[] arr = {23, 4, 15, 8, 19, 24, 15};
        binaryInsertionSort.ascBinaryInsertionSort(arr);   //[8, 15, 15, 15, 19, 24, 24]
        System.out.println(Arrays.toString(arr));
    }
}
