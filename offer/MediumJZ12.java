package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2021/1/2 15:43
 * @modified By：
 */
public class MediumJZ12 {
    /**
     * 数值的整数次方
     * 给定一个double类型的浮点数base和int类型的整数exponent。
     * 求base的exponent次方。
     * 保证base和exponent不同时为0
     * 先排除base为0 和 exponent为0的情况
     * 主要是考虑程序完整性，边界情况如何处理？负值情况如何处理？
     * 运行时间 27ms
     */

    public double Power(double base, int exponent) {
        // 0的任意次方都为0
        if (base == 0) {
            return 0;
        }
        // 任何数的0次方为1，1的任意次方为1
        if (exponent == 0 || base == 1) {
            return 1;
        }
        // 处理负值
        if (exponent < 0) {
            return 1/Power(base, -exponent);
        }
        // 常规情况
        double res = 1;
        for (int i=0; i<exponent; i++) {
            res *= base;
        }
        return res;
    }

    /**
     * 另一种思路，快速幂
     * 求2的32次方的时候，是不是可以转化为求2的16次方的平方？
     * 求2的15次方的时候，是不是可以转化为求2的7次方的平方再乘以2？
     * a^n = a^n/2 * a^n/2  n偶数
     * a^n = a^(n-1)/2 * a^(n-1)/2 * a  n为奇数
     * 使用位运算有10ms的时间提升
     */
    public double power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0 || base == 1) {
            return 1;
        }
        // 指数分到1就不继续往下分了
        if (exponent == 1) {
            return base;
        }
        // 处理负值
        if (exponent < 0) {
            return 1/power(base, -exponent);
        }
        // 使用位运算右移代替除以2
        double res = power(base, exponent >> 1);
        res *= res;
        // 使用与运算来判断奇偶，因为一个数换算成二进制后，奇数最后位是1，偶数最后一位是0，所以可以与1做与运算来判断奇偶
        if ( (exponent & 1) == 1) {
            // 为奇数时，要多乘一次base
            res *= base;
        }
        return res;
    }

}
