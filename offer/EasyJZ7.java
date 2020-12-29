package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2020/12/29 15:16
 * @modified By：
 */
public class EasyJZ7 {
    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
     * n<=39
     * 最简单的递归，八百多毫秒
     */
    public int Fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return Fibonacci(n-1) + Fibonacci(n-2);
        }
    }

    /**
     * 优化避免重复计算，从下往上计算 11ms
     * O(n)
     */
    public int Fibonacci1(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int one = 0;
        int two = 1;
        int sum = 0;
        // 从第三项开始
        for (int i=2; i<=n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }
}
