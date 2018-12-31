package com.mine.sort.insertionsort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 基本操作（一趟）：[依次]将一个记录插入到已排好序的有序表中，从而得到一个新的，记录数+1的有序表，比较和移动
 */
public class StraightInsertionSort {


    /**
     * 直接插入排序，升序
     *
     * @param arr
     */
    public void asc(int[] arr) {
        //定义两个常量，一个代表了将要执行插入的元素的索引，一个代表目的地需要插入的位置索引[只是一种记录，因为需要插入的是j+1位置]
        int i, j;
        //数组左侧当作有序数列，排除第一个元素固定外，共有n-1个元素，需要循环n-1次
        for (i = 1; i < arr.length; i++) {
            //一般情况下，如果第i个元素，小于前一个i-1的元素，那么需要进行一趟插入排序[此时比较的是i，后续比较的是j，因为i是固定不动的]
            //否则直接i++到下一个索引位置即可
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];        //在C语言中，这个称之为哨兵,也叫做监视哨
                for (j = i - 1; j >= 0 && arr[j] > temp; --j) {   //必须使用temp，因为接下来就要覆盖arr[i]这个位置上的值了
                    arr[j + 1] = arr[j];    //元素后移
                }
                //此时，arr[j]<=temp，但是arr[j+1]的位置是需要插入的位置，因为arr[j]并没有移动
                arr[j + 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        StraightInsertionSort straightInsertionSort = new StraightInsertionSort();
        int[] arr = {23, 4, 15, 8, 19, 24, 15};
        straightInsertionSort.asc(arr);
        System.out.println(Arrays.toString(arr));
    }
}
