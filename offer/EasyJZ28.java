package com.hou.offer;

import java.util.HashMap;

/**
 * @author ：hc
 * @date ：Created in 2020/12/20 22:33
 * @modified By：
 */
public class EasyJZ28 {
    /**
     * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
     * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
     * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
     * 可以使用HashMap存储，然后value是每个数字出现的次数
     * 遍历key，找出value > (数组.length / 2) return key
     *
     *  还可以优化：在同一个循环中加上长度的判断
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : array) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
            if (map.get(i) > (array.length / 2) ) {
                return i;
            }
        }
        return 0;
    }
}
