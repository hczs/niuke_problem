package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2020/12/20 22:21
 * @modified By：
 */
public class MediumJZ67 {
    /**
     * 剪绳子
     * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n）
     * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 输入一个数n，意义见题面。（2 <= n <= 60）
     * 暴力递归
     * 不想分成多少段，就只想返回的是最大值就行
     * 函数作用：返回分成m段之后的最大乘积
     * 结束条件：当绳子长度n<=4的时候，返回target
     * 下一步递归：我们依次尝试分成 1，n-1之后，2，n-2之后，。。。取最大值
     * 递归超时
     */
    public int cutRope(int target) {
        if (target <= 4) {
            return target;
        }
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=target; i++) {
            int cur = i * cutRope(target-i);
            if (cur > max) {
                max = cur;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * 自顶向下分析
     * 设 f(n) 是长度n分段后的最大乘积
     * 要求f(n)，就得求 max( 1*f(n-1), 2*f(n-2), 3*f(n-3), ... ,n-1*f(1) )
     * 自底向上求解
     * f(1) = 1     // 1不再范围之内，不过也需要1
     * f(2) = 2
     * f(3) = 3
     * f(4) = 4
     * f(5) = max(1*f(4), 2*f(3), 3*f(2), 4*f(1)) = 6
     *
     * f(7) = max(1*f(6), 2*f(5), 3*f(4), 4*f(3), 5*f(2), 6*f(1))
     */

    public int cutRope1(int target) {
        if (target <= 4) {
            return target;
        }
        int[] dp = new int[target+1];
        for (int i=0; i<=4; i++) {
            dp[i] = i;
        }
        for (int i=5; i<=target; i++) {
            int max = Integer.MIN_VALUE;
            for (int j=1; j<i; j++) {
                max = Integer.max(max, j*dp[i-j]);
            }
            dp[i] = max;
        }
        return dp[target];
    }

    public static void main(String[] args) {
        MediumJZ67 mediumJZ67 = new MediumJZ67();
        System.out.println(mediumJZ67.cutRope(7));
        System.out.println(mediumJZ67.cutRope(6));
        System.out.println(mediumJZ67.cutRope1(6));
        System.out.println(mediumJZ67.cutRope1(7));
    }
}
