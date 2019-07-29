package com.util.sort;

/**
 * @Description 快速排序
 * @Author karyzeng
 * @since 2019.07.26
 **/
public class QuickSort {

    /**
     * 递归排序，当start等于end的时候结束递归
     * @param array 要排序的数组
     * @param start 数组排序开始下标
     * @param end 数据排序结束下标
     */
    private static void recursion(int[] array, int start, int end) {
        if (array != null && array.length > 0) {
            if (start == end) return;
            int middle = array[end];// end最后一个元素作为基准
            for (int i = start; i < end; i++) {

            }
        }
    }

}
