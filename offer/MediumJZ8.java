package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2020/12/21 10:57
 * @modified By：
 */
public class MediumJZ8 {
    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * 输入：1 返回 1
     * 输入：4 返回 5
     * 递归三部曲：
     * 1.函数设计： f(n) 返回n级台阶的跳法
     * 2.终止条件： n<=1 只能跳一级，返回 1
     * 3.下一步递归： f(n-1) + f(n-2) 当前结果下跳一级台阶的跳法+当前结果下跳两级台阶的跳法
     */
    public int JumpFloor(int target) {
        if (target <= 1) {
            return 1;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    /**
     * 上述递归五百多毫秒.......
     * 下面动态规划来优化做一下
     * 最终问题？ f(n) 返回n级台阶最终跳法
     * 初始条件： f(0) = 1 f(1) = 1
     * f(2) = f(1) +f(0) = 2
     * f(3) = f(2) + f(1) = 3
     * f(4) = f(3) + f(2) = 3 + 2 = 5
     * ...
     * f(n) = f(n-1) + f(n-2) 第一次跳一级 或 第一次跳两级 两种选择
     * 数组来存储之前计算过的次数，也就是小问题的解，大问题的解依赖各个小问题的解
     * 然后直接求 第一次跳一级 f(n-1) 种跳法 第一次跳两级 有 f(n-2)种跳法 求和
     * 动态规划pass~ 10ms通过
     */
    public int JumpFloor2(int target) {
        if (target <= 0) {
            return 1;
        }
        // 运用数组可以将之前计算过的都存储起来了
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        // 从下到上依次计算，因为后面的问题会用到前面的小问题的解，用到的时候直接数组取值即可
        for (int i=2; i<=target; i++) {
            // 跳一级或跳两级
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }

}
