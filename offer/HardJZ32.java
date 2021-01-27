package com.hou.offer;

import java.util.Arrays;

/**
 * @author ：hc
 * @date ：Created in 2021/1/27 10:40
 * @modified By：
 */
public class HardJZ32 {
    /**
     * 把数组排成最小的数
     * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
     * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
     *
     * 先排序
     * 从头到尾，一个一个看，当前数与紧跟其后的数组成的最小的数，两个就两种情况，返回最小的就行
     * 然后一次往后面比较
     * 3 32 -> 332 or 323 -> return 323
     * 323 321 -> 323321 or 321323 -> return 321323
     *
     * 注意给定的返回值 String，肯定会有int or long 存不下的数，所以问题在于比较两个数的大小上
     * 可以从高位到低位依次比较，如果发现小的就返回
     */
    public String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        Arrays.sort(numbers);
        String result = String.valueOf(numbers[0]);
        for (int i=1; i<numbers.length; i++) {
            result = compareTwoNumbers(numbers[i] + result, result + "" + numbers[i]);
        }
        return result;
    }

    /**
     * 比较两个数的大小，返回较小的数
     */
    String compareTwoNumbers(String a, String b) {
        // 此处两个数长度肯定相等，因为是前后位置变换得到的两个数
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) < b.charAt(i) ? a : b;
            }
        }
        // 如果比较完之后都没有不相等的字符，就随便返回一个就行，因为两数相等
        return a;
    }

}
