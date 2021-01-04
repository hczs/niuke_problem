package com.hou.offer;

import java.util.HashMap;

/**
 * @author ：hc
 * @date ：Created in 2021/1/4 17:35
 * @modified By：
 */
public class MediumJZ40 {

    /**
     * 数组中只出现一次的数字
     * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * num1,num2分别为长度为1的数组。传出参数
     * 将num1[0],num2[0]设置为返回结果
     * 用哈希表存储元素和次数，然后取出分别放入num1和num2中
     */

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int element : array) {
            if (hashMap.containsKey(element)) {
                hashMap.put(element, hashMap.get(element) + 1);
            } else {
                hashMap.put(element, 1);
            }
        }
        boolean flag = false;
        for (Integer element : hashMap.keySet()) {
            if (hashMap.get(element) == 1 && !flag) {
                num1[0] = element;
                flag = true;
            }
            if (hashMap.get(element) == 1 && flag) {
                num2[0] = element;
            }
        }
    }
}
