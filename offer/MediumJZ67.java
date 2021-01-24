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
     * 结束条件：当绳子长度n<=3的时候，返回target-1
     * 下一步递归：我们剪一刀之后，面临的选择有 不再继续往下剪了，还有就是继续往下剪
     * 不再继续往下剪的时候 乘积就是 (假设在j处剪开) j*(n-j)
     * 继续往下剪就是  j*cutRope(n-j) 求两者最大值 ----------这是一次剪开
     * 剪n次就是  多个 max( j*(n-j), j*cutRope(n-j) )
     * 递归超时
     */
    public int cutRope(int target) {
        if (target <= 3) {
            return target-1;
        }
        int max = Integer.MIN_VALUE;
        for (int i=1; i<=target; i++) {
            // 要比较三个值，max 和 切一下分两段 再比较 切一下*剩下的继续分段的最大值
            max = Math.max(max, Math.max(i*(target-i), i * cutRope(target-i)));
        }
        return max;
    }

    /**
     * 动态规划
     * 有了递归动态规划就好知道了
     * 其实就是把函数 定义为了数组存储，分别还是 函数设计、结束条件、下一步递归
     * 只不过递归是从上往下算
     * 动态规划是从下往上算
     * 定义 dp：就是存储对应长度的乘积最大值
     * 初始状态 dp[2] = 1
     * 转移方程：dp[i] = max(dp[i], max(j*[i-j], j*dp[i-j]))   j=1;j<i 从切一个长度为1的段开始，切1，切2...
     * 返回 dp[n]
     */

    public int cutRope1(int target) {
        if (target <= 3) {
            return target-1;
        }
        int[] dp = new int[target+1];
        dp[2] = 1;
        for (int i=3; i<=target; i++) {
            for (int j=1; j<i; j++) {
                dp[i] = Math.max( dp[i], Math.max( j*(i-j), j*dp[i-j]) );
            }
        }
        return dp[target];
    }

}
