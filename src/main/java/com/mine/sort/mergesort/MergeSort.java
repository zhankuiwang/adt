package com.mine.sort.mergesort;

import java.util.Arrays;

/**
 * 归并排序
 * 首先把长度为n的待排序的序列，看作是n个长度为1的有序表
 * 相邻的有序子表一一合并，得到n/2个新的有序表，并重复此步骤--视为一趟
 * 多趟后，得到最终的排序结果
 * 注：每次都只将相邻的两个有序子表进行合并，因此成为2路归并排序，可以推导出多路归并排序
 */
public class MergeSort {


    /**
     * 并的算法/合并算法
     * 二路归并排序中，将两个有序序列合并成一个新的有序序列
     * arr[low,mid]+arr[mid+1,high]-->arr[low,high]
     * 两个有序子表的长度不一定要相等
     *
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public void merge(int[] arr, int low, int mid, int high) {
        //首先申请一个临时空间，以及临时变量,注意一定要+1
        int[] tempArr = new int[high - low + 1];
        int i = low, j = mid + 1, p = 0;
        while (i <= mid && j <= high) {
            if (arr[i] < arr[j]) {
                tempArr[p++] = arr[i++];
            } else {
                tempArr[p++] = arr[j++];
            }
        }
        //剩余记录的处理：此时有一个还没有放进来，有可能是任何一路的，但某一路肯定是已经放完了
        // 下面两个循环肯定只能执行一个
        while (i <= mid) {
            tempArr[p++] = arr[i++];
        }
        while (j <= high) {
            tempArr[p++] = arr[j++];
        }
        //复制到原来的表中
        for (int k = low; k <= high; k++) {
            arr[k] = tempArr[k - low];
        }
    }


    /**
     * 一趟归并排序，
     * 一趟中，要确定的有两个数据，上一趟完成后的表arr，上一趟完成后的有序子表的长度len
     * 这个时候，每一个子序列都已经完成了各自的排序，需要合并了，合并后的长度为2*len
     *
     * @param arr 待排序的数组序列
     * @param len 该趟排序中有序子表的长度
     */
    public void mergeOnce(int[] arr, int len) {
        //i代表的是起始的low的索引，通过这个去推断mid和high的位置
        //限制条件是i+2*len肯定不能超过数组
        //为什么是2*len，因为归并需要两个len的长度，下一次归并肯定是2个len之后的了，所以需要*2
        //后面的i+2*len是为了计算下一个位置，中间的判断位置的i+2*len并不是为了计算，只是为了判断是否满足要求
        //归并长度为len的子序列，要求2个都要是len的长度
        //已经知道本次的起始位置low位置了，如果下一次low的值超过了length-1，说明这次不满足两个都是len，如果下一次仍旧有值，那么说明满足2个长度都为len
        //在这里的判断并不是比较的是2个len的长度，这样也不好得到以前所有的len的长度，干脆直接获取下一个的low值判断是否仍在数组范围内
        int i = 0
        for (; i + 2 * len <= arr.length - 1; i += 2 * len) {
            merge(arr, i, i + len, i + 2 * len);
        }
        //归并长度不满足2个都是len的子序列，有可能最后还剩下2个或者一个的
        //注意此时i的值，应该是最后一次的low值，一定要注意
        //如果最后剩下2个，那么需要归并长度为len和长度小于len的子序列
        //如果最后剩下1个，那么需要直接把这个不用管就可以了
        if (i + len < arr.length - 1) {
            merge(arr, i, i + len, arr.length - 1);
        }
    }

    /**
     * 完整的归并排序,2路归并排序,
     * 关键在于需要多少次，也就是长度=次数*2
     */
    public void asc(int[] arr){
        int i  = 1;
        int len = 1;
        while
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {26, 34, 78, 88, 18, 22, 26, 94};
        mergeSort.merge(arr, 0, 3, 7);
        System.out.println(Arrays.toString(arr));
    }


}
