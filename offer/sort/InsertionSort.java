package com.hou.offer.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 * 时间复杂度：最好情况（排好序的数组）：O(n)，最坏（逆序）：O(n²)
 * 平均时间复杂度：O(n²)
 * 稳定的排序算法
 * @author ：hc
 * @date ：Created in 2021/1/26 16:32
 * @modified By：
 */
public class InsertionSort {

    /**
     * 将每一个【新数字】【插入】到一个【排好序数组】的【合适位置】就是插入排序
     * 想象打牌的时候，一张一张拿到手中，拿一张牌，然后看大小，再放合适的位置上
     * 这就是插入排序
     * @param array 待排序数组
     */
    public void insertionSort(int[] array) {
        // 注意i,j的结束条件，为什么 i 是长度-1的时候结束？因为 j 是从i+1开始的，为什么j等于0就结束？因为内循环中是比较 j 和 j-1 的大小的，依次往前比较
        for (int i=0; i<array.length-1; i++) {
            // 从 i+1 往回看，就像是拿到新牌再看手中的牌
            for (int j=i+1; j>0 && array[j] < array[j-1]; j--) {
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        // 编写主函数进行测试
        int[] array = new int[]{2,3,6,5,1,7,9,8,4};
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
