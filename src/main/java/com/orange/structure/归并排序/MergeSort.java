package com.orange.structure.归并排序;

import java.util.Arrays;

public class MergeSort {

    /**
     * 这个排序还没想好
     */

    Integer[] integer = new Integer[]{3, 344,55,566,224,45,3,43,2,2,4,552,244,3,4,6};

    //如果是两个有序的数组排序

    /**
     * 这个是自己写的，有错误
     * @param arr
     * @param arr2
     * @param arr3
     */
    public void sort(Integer[] arr, Integer[] arr2, Integer[] arr3) {
        int num = 0;
        int j =0;
        //当arr的最大值小于arr2的时候如何做。就是i先循环完。而arr2还没循环完
        for(int i = 0; i<arr.length; i++) {

            while(j<arr2.length) {
                if(arr[i] >= arr2[j]) {
                    arr3[num] = arr2[j];
                    j++;
                    num++;
                } else {
                    arr3[num] = arr[i];
                    num++;
                    break;
                }
            }
            if(j >= arr2.length) {
                arr3[num] = arr[i];
                num++;
            }
        }
        System.out.println(Arrays.toString(arr3));
    }

    public void sort2(Integer[] arr1, Integer[] arr2, Integer[] arr3) {
        int i=0, j=0, k=0;
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }

        }
        while(i < arr1.length) {
            arr3[k++] = arr1[i++];
        }
        while(j < arr2.length) {
            arr3[k++] = arr2[j++];
        }
        System.out.println(Arrays.toString(arr3));
    }


    //归并排序
    public static void mergeSort(int[] arr){
        int[] temp =new int[arr.length];
        internalMergeSort(arr, temp, 0, arr.length-1);
    }
    private static void internalMergeSort(int[] a, int[] b, int left, int right){
        //当left==right的时，已经不需要再划分了
        if (left<right){
            int middle = (left+right)/2;
            internalMergeSort(a, b, left, middle);          //左子数组
            internalMergeSort(a, b, middle+1, right);       //右子数组
            mergeSortedArray(a, b, left, middle, right);    //合并两个子数组
        }
    }
    // 合并两个有序子序列 arr[left, ..., middle] 和 arr[middle+1, ..., right]。temp是辅助数组。
    private static void mergeSortedArray(int arr[], int temp[], int left, int middle, int right){
        int i=left;
        int j=middle+1;
        int k=0;
        while ( i<=middle && j<=right){
            if (arr[i] <=arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        while (i <=middle){
            temp[k++] = arr[i++];
        }
        while ( j<=right){
            temp[k++] = arr[j++];
        }
        //把数据复制回原数组
        for (i=0; i<k; ++i){
            arr[left+i] = temp[i];
        }
    }
}
