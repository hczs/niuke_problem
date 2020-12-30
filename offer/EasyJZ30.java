package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2020/12/30 10:42
 * @modified By：
 */
public class EasyJZ30 {
    /**
     * 连续子数组最大和
     * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。
     * 求所有子数组的和的最大值。要求时间复杂度为 O(n).
     * input: [1,-2,3,10,-4,7,2,-5]
     * output: 18
     * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
     * 最直观方法，列出所有子数组，求最大和，最快也要O(n²)
     * 可以从头往后加，维护一个最大值
     * 计算当前和然后判断，如果相加小于0了，再继续加下去是没有意义的，所以把之前的负值舍去，从新开始加
     * 每次加完都维护一下最大值
     * 循环完毕返回
     */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for (int value : array) {
            if (tmp < 0) {
                tmp = value;
            } else {
                tmp += value;
            }
            // 维护一下最大值
            max = Math.max(tmp, max);
        }
        return max;
    }
}
