package com.hou.offer.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 时间复杂度O(n²)
 * 不稳定的排序算法
 * @author ：hc
 * @date ：Created in 2021/1/28 16:11
 * @modified By：
 */
public class SelectionSort {

    /**
     * 思想：每一趟都找出来最小的 或 最大的元素放到数组最前面
     * 就是暴力排序了
     * @param array 待排序数组
     */
    public void selectionSort(int[] array) {
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // 编写主函数进行测试
        int[] array = new int[]{2,3,6,5,1,7,9,8,4};
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
