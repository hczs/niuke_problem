package com.hou.offer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author ：hc
 * @date ：Created in 2021/1/8 15:46
 * @modified By：
 */
public class MediumJZ42 {
    /**
     * 和为s的两个数字
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
     * 如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 对应每个测试案例，输出两个数，小的先输出。
     * input：[1,2,4,7,11,15],15
     * output：[4,11]
     * 无脑暴力法
     * 用一个map存储 key：乘积 value：两个数中的小的那个
     * 维护一个min：当前最小乘积
     * 双重循环遍历符合条件的
     * 注意：也有可能没有和为sum的两个数
     * 时间复杂度O(n²)
     */

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array.length == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i=0; i<array.length; i++) {
            for (int j=i+1; j<array.length; j++) {
                if (array[i] + array[j] == sum) {
                    int product = array[i] * array[j];
                    // 维护最小值
                    if (product < min) {
                        min = product;
                    }
                    // 因为数组递增，所以放i没问题
                    map.put(product,array[i]);
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (map.get(min) == null) {
            return res;
        } else {
            res.add(map.get(min));
            res.add(sum - map.get(min));
            return res;
        }
    }

    /**
     * 双指针
     * 一个从头往后（i）
     * 一个从后往前（j）
     * 三种情况
     * 如果两个指针对应的值相加为sum，直接返回（因为再往下找到相同的乘积肯定比现在的大）
     * 如果相加小于sum，证明从头往后那个太小了，得增加，所以i++
     * 如果相加大于sum，证明从后往前那个太大了，得减小，所以j--
     * 时间复杂度O(n)
     */
    public ArrayList<Integer> FindNumbersWithSum1(int [] array,int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i=0,j=array.length-1; i<j;) {
            if (array[i] + array[j] == sum) {
                result.add(array[i]);
                result.add(array[j]);
                return result;
            } else if (array[i] + array[j] < sum) {
                i++;
            } else if (array[i] + array[j] > sum) {
                j--;
            }
        }
        // 跳出循环后证明没有符合要求的值
        return result;
    }

}
