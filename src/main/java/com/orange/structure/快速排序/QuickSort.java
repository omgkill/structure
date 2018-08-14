package com.orange.structure.快速排序;

import java.util.Arrays;

public class QuickSort {

    /**
     * 快速排序
     *
     * http://blog.51cto.com/flyingcat2013/1281614
     */

    Integer[] integer = new Integer[]{3, 344,55,566,224,45,3,43,2,2,4,552,244,3,4,6};
    private int number = 1;

    public int QuickSortM(Integer[] integer, int start, int end) {
//        int start = 0 ;
//        int end = integer.length - 1;
        Integer key = integer[start];
        while(start < end) {

            /**
             * 从后往前查找第一个比key小的值，然后放到start
             */
            while(integer[end] >= key && (end > start)) {
                end -- ;
            }
            integer[start] = integer[end];
            System.out.println(Arrays.toString(integer));
            /**
             * 从前往后找第一个比key大的值，然后放到end处
             */
            while(integer[start] <= key && (end > start)) {
                start ++;
            }
            integer[end] = integer[start];
            System.out.println(Arrays.toString(integer));
        }
        integer[end] = key;
        System.out.println(Arrays.toString(integer));
        return end;
    }

    public  void sort(Integer[] array,int lo ,int hi){
        if(lo>=hi){
            return ;
        }
        int index = QuickSortM(array,lo,hi);
        System.out.println("------------" + index);
        sort(array,lo,index-1);
        System.out.println("-----------------" + index);
        sort(array,index+1,hi);
        number ++;
    }
    public void mytest(){

        sort(integer,0 , integer.length-1);
        System.out.println(number);
    }
}
