package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2021/1/8 16:29
 * @modified By：
 */
public class HardJZ49 {
    /**
     * 把字符串转换成整数
     * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
     * 数值为0或者字符串不是一个合法的数值则返回0
     * 0对应的ASCII码值为48，所以可得 每一个字符-48得字符对应的数值
     * 设置一个flag来判断正负
     */

    public int StrToInt(String str) {
        // 首先判断是否合法
        if (str == null || "".equals(str)) {
            return 0;
        }
        char[] chars = str.toCharArray();
        // 第一个字符不是正负，也不是数字，返回0
        if (chars[0] != '+' && chars[0] != '-' && (chars[0] < '0' || chars[0] > '9')) {
            return 0;
        }
        // 开始正常判断
        int product = 1;
        int res = 0;
        // 默认是正值
        int end = 0;
        boolean flag = false;
        if (chars[0] == '-') {
            flag = true;
            end = 1;
        }
        if (chars[0] == '+') {
            end = 1;
        }
        for (int i=chars.length-1; i>=end; i--) {
            if (chars[i] < '0' || chars[i] > '9') {
                return 0;
            }
            res += (chars[i]-48) * product;
            product *= 10;
        }
        if (flag) {
            return -res;
        }
        return res;
    }

    public static void main(String[] args) {
        HardJZ49 hardJZ49 = new HardJZ49();
        int i = hardJZ49.StrToInt("+123");
        System.out.println(i);

    }
}
