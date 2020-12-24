package com.hou.offer;

import java.util.HashMap;

/**
 * @author ：hc
 * @date ：Created in 2020/12/24 17:23
 * @modified By：
 */
public class MediumJZ50 {
    /**
     * 数组中重复的数字
     * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
     * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。
     * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
     * 返回描述：
     * 如果数组中有重复的数字，函数返回true，否则返回false。
     * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
     * 一个一个往hashMap里面放，如果放之前判断包含，包含了就返回true，设置duplication值，遍历完毕 证明没有包含的，就返回false
     * 牛客的方法定义好像out了..
     */
    public boolean duplicate(int[] numbers,int length,int [] duplication) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i=0; i<length; i++) {
            if (hashMap.containsKey(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            }
            hashMap.put(numbers[i],0);
        }
        return false;
    }
}
