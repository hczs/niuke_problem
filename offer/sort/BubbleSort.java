package com.hou.offer.sort;

import java.util.Arrays;

/**
 * @author ：hc
 * @date ：Created in 2021/1/9 16:42
 * @modified By：
 */
public class BubbleSort {


    /**
     * 正宗冒泡排序思想
     * 就是每一次循环都让最小的值浮出水面
     * 注意循环起始条件和终止条件
     * @param array 待排序数组
     * @return 排序之后的数组
     */
    public int[] bubbleSort(int[] array) {
        for (int i=0; i<array.length; i++) {
            // 注意第二层循环条件，从倒数第一个开始，到第二（i+1）个元素停
            // 意思就是之前浮出水面的最小值就不要打扰了，继续求除了之前的最小值，后面的值中的最小值，浮出来
            for (int j=array.length-1; j>i; j--) {
                // 如果发现相邻两个元素，前面竟然比后面大，果断交换
                if (array[j-1] > array[j]) {
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }

    /**
     * 冒泡排序在优化
     * 可以使用一个flag，来记录一趟排序下来是否有元素改动
     * 如果没有发生元素交换，那大可不必进行后面的循环了，可以直接返回
     * 时间复杂度分析：最好情况，没有元素交换，O(n)，最坏情况，数组倒序，O(n²)
     * @param array 待排序数组
     * @return 排序之后的数组
     */
    public int[] betterBubbleSort(int[] array) {
        // 记录是否进行过交换
        boolean flag = true;
        // 这里循环结束条件改一下，只有flag=true的情况下才会继续循环，因为发生了元素交换
        // 相反，如果没有发生元素交换的话，flag自然是false，所以跳出循环
        for (int i=0; i<array.length && flag; i++) {
            flag = false;
            for (int j=array.length-1; j>i; j--) {
                if (array[j-1] > array[j]) {
                    int tmp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        // 编写主函数进行测试
        int[] array = new int[]{2,3,6,5,1,7,9,8,4};
        BubbleSort sort = new BubbleSort();
        System.out.println(Arrays.toString(sort.betterBubbleSort(array)));
    }
}