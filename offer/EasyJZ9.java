package com.hou.offer;

public class EasyJZ9 {

    /**
     * 变态跳台阶
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
     *
     * f(n) n级台阶的跳法
     *
     * f(0) = f(1) = 1
     * f(2) = f(2-1) + f(2-2) = f(1) + f(0) = 2  第一次跳一级台阶 第一次跳两级台阶
     * f(3) = f(3-1) + f(3-2) + f(3-3) = f(2) + f(1) +f(0) = 2 + 1 + 1 = 4 第一次跳一级台阶 第一次跳两级台阶 第一次跳三级台阶
     * f(4) = f(3) + f(2) + f(1) +f(0) = 4 + 2 + 1 + 1 = 8   理由同上 依次类推
     * ...
     * f(n) = f(n-1) + f(n-2) + f(n-3) + ... + f(n-n)
     *
     */
    public int JumpFloorII(int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        dp[1] = 1;
        // 从2开始计算，一直计算到target出结果为止
        for (int i=2; i<=target; i++) {
            // 此处j的意义是你第一次跳多少级台阶
            // dp[2] = dp[1] + dp[0]
            // dp[3] = dp[2] + dp[1] + dp[0]
            for (int j=1; j<=i; j++) {
                dp[i] += dp[i-j];
            }
        }
        return dp[target];
    }

}
