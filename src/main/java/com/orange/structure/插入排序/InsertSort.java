package com.orange.structure.插入排序;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    Integer[] integer = new Integer[]{3, 344,55,566,224,45,3,43,2,2,4,552,244,3,4,6};


    public void sort(){
        int total = integer.length;
        for(int i = 1; i < total; i++) {
            Integer value = integer[i];
            int position;
            for( position = i; position > 0; position--) {
                if(integer[position-1] > value) {
                    integer[position] = integer[position - 1];
                }
                else {
                    break;
                }
            }
            integer[position] = value;
            System.out.println(Arrays.toString(integer));
        }
        System.out.println(Arrays.toString(integer));
    }
    /**
     * 另一种方式
     */
    public void anotherSort(){
        int total = integer.length;
        for(int i = 1; i < total; i++ ) {
            Integer value = integer[i];
            int position = i;
            while(position > 0 && integer[position - 1] > value) {
                integer[position] = integer[position - 1];
                position -- ;
            }
            integer[position] = value;
        }

    }
}
