package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2021/1/1 13:35
 * @modified By：
 */
public class MediumJZ11 {
    /**
     * 二进制中1的个数
     * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
     * 负数的补码是正数取反加一
     * 位运算逐位判断是否是1，是1的话count++，不是1的话下一个判断
     * 整体与 1 做 & 操作判断是否为1，判断完之后该数字不动，1如（0001）左移一位 >> 0010，这样就达到判断第二位数字的效果了
     * 这里是用4位举例，题中为32位
     * 1一直左移直到移出去了，也就是为0了，结束
     */

    public int NumberOf1(int n) {
        int count = 0;
        int judge = 1;
        while (judge != 0) {
            if ( (n & judge) != 0) {
                count++;
            }
            // judge左移一位，继续判断
            judge <<= 1;
        }
        return count;
    }
}
