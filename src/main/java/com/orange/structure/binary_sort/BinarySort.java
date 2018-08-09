package com.orange.structure.binary_sort;

import java.util.Arrays;

public class BinarySort {

    Integer[] integer = new Integer[]{3, 344,55,566,224,45,3,43,2,2,4,552,244,3,4,6};

    /**
     * 要找到这个数
     */
    private Integer A = 33;
    /**
     * 把这个数组排序
     * 先冒泡排序，把数组按从小到大排序
     * 再使用二分法
     */
    public void iterator() {

        for(int i = integer.length - 1; i> 0; i--) {
            for( int l =0; l < i; l++) {
                if(integer[l] > integer[l+1]) {
                    Integer temp = integer[l+1];
                    integer[l+1] = integer[l];
                    integer[l] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(integer));
        /**
         * 二分法的思想
         *  首先就是确定两头，最小点和最大点
         *  而后根据这两个点确定中间值
         *  当中间值与最小点或最大点相等时，说明没有该值
         */
        int middle = integer.length/2;
        int start = 0 ;
        int end = integer.length - 1;
        while(start < middle && end > middle) {
            if(A > integer[middle]) {
                start = middle;
            } else if (A < integer[middle] ) {
                end = middle;
            } else {
                System.out.println(middle);
                break;
            }
            middle = (start + end ) / 2;
        }
    }

}
