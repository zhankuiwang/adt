package com.mine.sort;

import com.mine.sort.insertionsort.StraightInsertionSort;
import com.mine.sort.swapsort.BubbleSort;

public class SortTest {

    public static int[] init() {
        int[] arr = new int[50000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.ceil(Math.random() * 50000);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = init();
        StraightInsertionSort straightInsertionSort = new StraightInsertionSort();
        BubbleSort bubbleSort = new BubbleSort();
        //
        long start = System.currentTimeMillis();
        straightInsertionSort.asc(arr);
        long mid = System.currentTimeMillis();
        //
        bubbleSort.asc(arr);
        long end = System.currentTimeMillis();
        //
        System.out.println(mid - start);
        System.out.println(end - mid);
    }
}
