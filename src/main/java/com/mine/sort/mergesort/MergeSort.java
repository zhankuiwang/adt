package com.mine.sort.mergesort;

import com.mine.util.NumberUtil;

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
     * 明确两个数据，排序序列arr，本次归并中有序子表的长度（上一次归并完成后）
     * 这一趟归并后，有序子表的长度变成了2*len
     * 可能遇到3种情况：长度均为len的子表的归并，len长度的和另一个小于len的子表的归并，以及只剩下一个小于len的子表不处理
     *
     * @param arr    待排序列
     * @param length arr序列的长度
     * @param len    上一趟归并完成后有序子表的长度，也就是现在的子表长度，这一次归并完成后会变成2*len，默认开始的时候就是1
     */
    public void mergeOnce(int[] arr, int length, int len) {
        //归并长度为len的两个子序列
        //i指的arr中的索引，这个索引是针对于长度为len的子序列说的：i+=2*len，每一次都是跨过2个子序列后，第三个序列的起始位置
        //【1】首先是arr=0的位置，跨过两个长度为len的索引，即，i,i+len-1,i+2*len-1
        //【2】循环一次后，i变为了i+2*len，又开始了归并两个子序列过程
        //【3】这个时候，判断这两个子序列的最后一个元素的位置，在已经计算了i的条件下，最后一个high位置为i+2*len-1，如果在数组下标范围内，那么说明符合要求
        //     注意，这个并不是判断的下一次的起始位置，而是判断的这一次归并的结束位置
        //要求，2个长度为len的子序列，所有的数组下标索引都要在length-1中，这样就好了理解了，不要纠结等于号
        int i = 0;
        for (; i + 2 * len - 1 <= length - 1; i = i + 2 * len) {
            merge(arr, i, i + len - 1, i + 2 * len - 1);
        }
        //归并长度为len和长度不足len的两个子序列
        //现在有三个位置，分别是i,i+len,i+2*len-1，已经明确i+2*len-1>length-1，那么分为了2种情况
        //在length-1固定的情况下[i+len应该到哪里，但是固定了在length位置，如果超出了，说明小于一个len]
        //【1】i+len-1<length-1，说明剩下部分大于一个len
        //【2】i+len-1>=length-1，说明剩下的不足一个len，或者等于一个len
        if (i + len - 1 < length - 1) {
            merge(arr, i, i + len - 1, length - 1);
        }
    }

    /**
     * 完整的归并排序,2路归并排序,
     * 关键在于需要多少趟
     * 一定要注意区分的是有序子表的长度，什么叫这次的长度，什么叫这次完成后的长度
     * n个记录进行二路归并排序时，归并的次数为多少呢？
     */
    public void asc(int[] arr, int length) {
        //len指的是：每一归并排序的时候，子序列的长度
        //归并第一次的时候，len为1，归并完成后，len=2
        //归并第二次的时候，len为2，归并完成后，len=4
        //归并第三次的时候，len为4，归并完成后，len=8
        //所以说，不管第几次，自豪要归并的时候，小于最大的值，那么你就去归并排序把，就可以了
        //一定是小于，并不是小于等于
        for (int len = 1; len < length; len = len * 2) {
            mergeOnce(arr, length, len);
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {34, 26, 78, 88, 18, 22, 26, 94};
        mergeSort.asc(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }


}
