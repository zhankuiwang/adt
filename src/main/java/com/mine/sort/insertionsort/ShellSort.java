package com.mine.sort.insertionsort;

import java.util.Arrays;

/**
 * 希尔排序
 * 对直接插入排序的改进，在于引入了一个步长的概念
 * 直接插入排序中，步长肯定是1
 * 注意：shellSort中的步长要求：步长<n
 */
public class ShellSort {

    /**
     * 升序排列
     *
     * @param arr
     * @param dk  本次增量
     */
    public void ascShellSort(int[] arr, int dk) {
        //步长为dk，那么currentIndex的位置，就是dk，dk+1，dk+2...一直到dk+dk为止，根本不需要关心第一个元素是谁，只需要关心current和target两个元素位置即可
        //因为前一个元素，后一个元素，没有第一个元素的纠结
        //只需要关心循环的起始位置即可
        //直接插入排序的套路，先定义两个变量，分别代表了需要插入的元素位置，源位置，将要插入的元素的位置，目的位置
        int currIndex, targetIndex;    //起始元素并不是第一个元素，而是第一个元素+步长位置的元素,这里说法有待商榷
        //注意，这里小于的数，必须是arr.length，否则不对，因为你后面的是+=dk，所以这个是完全合理的
        //上述说法错误，这里应该是《2*dk，但是后面必须是+1，因为希尔排序的是见图吧
        //注意，上述说法是错误的，for (currIndex = dk; currIndex < 2 * dk; currIndex += 1)，这种写法就是错误的
        //为什么这样写不对呢？因为不管是current还是target都是针对的是current之前的值，但是之后的值呢？会处理吗？在这个阶段不会处理的
        //所以这里需要+1而不是+dk，并且，必须是<length而不是2*dk
        //所以，循环开始的这个位置，和步长无关，有关的是，序列的长度，以及步长的个数，因为这个东西决定了从哪一个开始
        //无关指的是，确定了循环开始位置后，这个循环的序列就确定了，这个时候就和步长无关了
        for (currIndex = dk; currIndex < arr.length; currIndex += 1) {
            if (arr[currIndex] < arr[currIndex - dk]) {
                int temp = arr[currIndex];
                //大于等于0即可，本本不需要知道起始位置
                for (targetIndex = currIndex - dk; targetIndex >= 0 && arr[targetIndex] > temp; targetIndex -= dk) {
                    arr[targetIndex + dk] = arr[targetIndex];
                }
                arr[targetIndex + dk] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {58, 46, 72, 95, 84, 25, 37, 58, 63, 12};
        ShellSort shellSort = new ShellSort();
        shellSort.ascShellSort(arr, 5);   //[25, 37, 58, 63, 12, 58, 46, 72, 95, 84]
        shellSort.ascShellSort(arr, 3);   //[25, 12, 58, 46, 37, 58, 63, 72, 95, 84]
        shellSort.ascShellSort(arr, 1);   //[12, 25, 37, 46, 58, 58, 63, 72, 84, 95]
        System.out.println(Arrays.toString(arr));
    }
}
