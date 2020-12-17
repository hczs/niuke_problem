package com.hou.offer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

/**
 * 非递减 啥意思 递增或者数相同
 *
 * 思考：1 2 3 4 5 6 7 -> 2 3 4 5 6 7 1
 *      4 5 6 7 1 2 3
 *      7 1 2 3 4 5 6
 *      1 1 2 3 5 8 -> 2 3 5 8 1 1
 */

/**
 * 方法1：暴力法
 * 我们直接从0开始扫描，如果发现前一个数比后一个数大了，那后面那个数就是分界点，也就是最小值
 * 如果扫描完毕还是没有，就直接返回第一个数即可
 *
 * 方法2：二分
 * mid = （low + high）/2
 * 如果mid>high:可以确定分界点（旋转点也就是最小值）在右边，为啥？因为中间的比最后的大，旋转之前又是非递减
 * 也就是mid->high的趋势是 高（mid）-----最高------最小值-------稍高（high），也可以这样想，如果旋转点在前面的话
 * 那么，mid后面肯定是非递减的，但是事实又是mid>high，所以不成立
 * 如果mid<high:mid后面是递增，所以分界点肯定在前半部分，有没有可能在后半部分？
 * 如果分界点在后半部分的话，最小值前面一定是本次的数组最大的数（因为非递减）
 * mid --- mid+100 --- min --- mid+1 那么应该是这样一个序列，翻转回去的话，会发现mid+1排在了mid的前面，非递减不成立
 * over
 * 因为此题考虑到了重复数字，所以是有可能相同的
 * mid==high：这个时候分界点前后都有可能
 * 例如：
 * 3 2 3 3 3
 * 3 3 3 2 3
 * 这个时候让high--，缩小范围，为什么high--没事？因为high--又丢不了最小值，所以没啥事
 */
public class EasyJZ6 {

    // 方法一： 暴力
    /*public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        for (int i=0; i<array.length; i++){
            if (array[i] > array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }*/

    // 方法二： 二分
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        // 如果没有旋转，直接返回
        int low = 0;
        int high = array.length-1;
        while (low < high){
            int mid = (low + high) / 2;
            if (array[mid] > array[high]){
                // 不用猜，向右边查找
                low = mid + 1;      // 为什么是mid+1，因为可以确定mid不是最小值
            }else if (array[mid] < array[high]){
                // 不用猜，向左边查找
                high = mid;     // 为什么又是mid，因为不确定mid是不是最小值，所以不能舍弃
            }else if (array[mid] == array[high]){
                // 不知左右，high--，缩小范围继续查找
                high--;
            }
        }
        return array[low];

    }
}
