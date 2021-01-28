package com.hou.offer.sort;

import java.util.Arrays;

/**
 * 冒泡排序基本实现和优化
 * 稳定的排序算法
 * 时间复杂度O(n²)
 * @author ：hc
 * @date ：Created in 2021/1/9 16:42
 * @modified By：
 */
public class BubbleSort {


    /**
     * 正宗冒泡排序思想
     * 就是每一次循环都让最小的值浮出水面
     * 注意循环起始条件和终止条件
     * 外层循环控制次数
     * 内层循环从后往前比较，从最后一个开始把最小的值慢慢交换到第一个
     * 然后再从后往前比较，到第二个数停下，把最小的数交换到第二个
     * ...
     * 重复n次，n为数组长度
     * 不论好坏都是O(n²)
     * @param array 待排序数组
     */
    public void bubbleSort(int[] array) {
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
    }

    /**
     * 冒泡排序在优化
     * 可以使用一个flag，来记录一趟排序下来是否有元素改动
     * 如果没有发生元素交换，那大可不必进行后面的循环了，可以直接返回
     * 时间复杂度分析：最好情况，没有元素交换，O(n)，最坏情况，数组倒序，O(n²)
     * @param array 待排序数组
     */
    public void betterBubbleSort(int[] array) {
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
    }

    public static void main(String[] args) {
        // 编写主函数进行测试
        int[] array = new int[]{2,3,6,5,1,7,9,8,4};
        int[] array1 = new int[]{1,3,2,4,5,6,7};
        BubbleSort sort = new BubbleSort();
        sort.betterBubbleSort(array1);
        System.out.println(Arrays.toString(array1));
    }
}
