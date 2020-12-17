package com.hou.offer;


public class EasyJZ48 {
    /**
     * 不用加减乘除做加法
     * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
     */


    // 先记住吧
    // 两个数做异或运算，是不考虑进位求和
    // 两个数做与运算再左移一位，是这两个数的进位
    // 重复上述两步直到进位为0即可
    // TODO 是我不懂的题
    public int Add(int num1,int num2) {
        // 当进位为 0 时跳出
        while(num2 != 0) {
            // c = 进位
            int c = (num1 & num2) << 1;
            // num1 = 非进位和
            num1 ^= num2;
            // num2 = 进位
            num2 = c;
        }
        return num1;
    }
}
