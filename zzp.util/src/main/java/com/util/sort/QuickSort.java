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
    private static int divide(int[] array, int start, int end) {
        int base = array[end];// end最后一个元素作为基准
        while (start < end) {
            while (start < end && array[start] <= base)
                start++;

            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                end--;
            }

            while (start < end && array[end] >= base)
                end--;

            if (start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
            }
        }
        return end;
    }

    private static void sort(int[] array, int start, int end) {
        if (array == null || array.length <= 0) {
            throw new ArrayIndexOutOfBoundsException("数组不能为空");
        }

        if (start > end) {
            return;
        }

        int divide = divide(array, start, end);
        sort(array, start, divide - 1);
        sort(array, divide + 1, end);
    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.randomArray(1000, 40);
        ArrayUtil.print(array);
        sort(array, 0, array.length - 1);
        ArrayUtil.print(array);
    }

}
