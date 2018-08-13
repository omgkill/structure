package com.orange.structure.选择排序;

import java.util.Arrays;

public class SelectSort {


    Integer[] integer = new Integer[]{3, 344,55,566,224,45,3,43,2,2,4,552,244,3,4,6};

    /**
     * 选择排序
     * 思想：
     * 就是每一个与后面的进行比较，找到最小的，然后替换
     */
    public void sort(){

        int num = integer.length ;
        for(int i = 0; i<num; i++) {
            int min = Integer.MAX_VALUE;
            int min_index = -1;
            for(int j = i; j< num; j++) {
                if(min > integer[j]) {
                    min = integer[j];
                    min_index = j;
                }
            }
            Integer temp = integer[i];
            integer[i] = min;
            integer[min_index] = temp;
        }
        System.out.println(Arrays.toString(integer));




    }
}
