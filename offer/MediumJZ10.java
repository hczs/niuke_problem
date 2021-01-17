package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2021/1/16 22:41
 * @modified By：
 */
public class MediumJZ10 {
    /**
     * 矩形覆盖
     * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
     * 找规律题
     * n = 1：1种
     * n = 2：2种
     * n = 3：3种
     * n = 4：5种
     * n = 5：8种
     * 画图找规律就行
     * 递归，找n-1和n-2
     * 294ms
     * .....
     */
    public int rectCover(int target) {
        if (target <= 2) {
            return target;
        } else {
            return rectCover(target-1) + rectCover(target-2);
        }
    }

    /**
     * 还是存储一下递归中产生的值吧
     * 8ms
     */
    public int rectCover1(int target) {
        if (target <= 2) {
            return target;
        }
        int[] dp = new int[target+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i=3; i<=target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }

    /**
     * 优化一下空间复杂度
     * 8ms
     * 省去了一个长度为target的数组
     */
    public int rectCover2(int target) {
        if (target <= 2) {
            return target;
        }
        int one = 1;
        int two = 2;
        int result = 0;
        for (int i=3; i<=target; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

}
