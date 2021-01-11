package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2021/1/11 15:05
 * @modified By：
 */
public class MediumJZ43 {
    /**
     * 左旋转字符串（数组循环左移）
     * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
     * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
     * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
     * 先判断n为0 和 n取余字符串长度为0时，直接返回字符串即可
     * 其他情况先将n对字符串长度取余，得到真正需要移动的次数，更新n的值
     * 字符串长度为len
     * 分割 0,n 为s1
     * 分割 n,len 为s2
     * 然后return s2+s1
     * 如果不使用substring的话就使用StringBuilder来进行手动切分增加
     * 不使用StringBuilder的话就用String了..
     */

    public String LeftRotateString(String str,int n) {
        int length = str.length();
        // 注意判断顺序，先判断n为0，不用移动，再判断是否为空串，然后再判断是否移动次数为字符串长度
        if (n == 0 || length == 0 || n%length == 0) {
            return str;
        }
        // 接下来是正常情况，更新n的值，确定具体移动哪些
        n = n%length;
        return str.substring(n, length) + str.substring(0, n);
    }

}
