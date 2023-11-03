package com.orange.structure.冒泡排序;

import java.util.Arrays;

/**
 * @author jingShuai
 * @description TODO
 * @date 2023/11/2 16:51
 */
public class BubbleSort {


     static Integer[] integer = new Integer[]{3, 344,55,566,224,45,3,43,2,2,4,552,244,3,4,6};

    public static void main(String[] args) {
        sort();
    }

    public static void sort() {

        for(int i = 0; i  < integer.length; i++) {
            int value = integer[i];
            for (int j = i + 1; j < integer.length; j++) {
                if (value > integer[j]) {
                    int temp = value;
                    value = integer[j];
                    integer[i] = value;
                    integer[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(integer));

    }
}
