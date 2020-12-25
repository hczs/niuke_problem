package com.hou.offer;

import java.util.HashMap;

/**
 * @author ：hc
 * @date ：Created in 2020/12/25 16:53
 * @modified By：
 */
public class HardJZ34 {
    /**
     *  第一个只出现一次的字符
     *  在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
     *  如果没有则返回 -1（需要区分大小写）.（从0开始计数）
     *  用一个hashmap 存储 字符 和 字符所在下标
     *  用数组存 字符下标 和 次数 （数组下标就是字符下标）
     *  这样遍历数组获取第一个次数为1的数，返回下标就是第一个只出现一次的字符位置
     */
    public int firstNotRepeatingChar(String str) {
        // 存放 char 和 index
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = str.toCharArray();
        int[] res = new int[chars.length];
        for (int i=0; i<chars.length; i++) {
            if (!hashMap.containsKey(chars[i])) {
                hashMap.put(chars[i],i);
                res[i] = 1;
            } else {
                // 重复了 用char获取字符下标，再++
                res[hashMap.get(chars[i])]++;
            }
        }
        for (int i=0; i<res.length; i++) {
            if (res[i] == 1) {
                return i;
            }
        }
        // 都重复的话就返回-1
        return -1;
    }

    /**
     * 发现不用记录字符下标，可以用字符的ASCII码来记录字符 以及 字符次数
     * 也就是数组的下标为字符ASCII码 值为 次数
     * 总结：数组下标作为key的思想，数组实现简单哈希表
     */
    public int FirstNotRepeatingChar(String str) {
        int[] res = new int[128];
        char[] chars = str.toCharArray();
        for (Character character : chars) {
            res[character]++;
        }
        for (int i=0; i<chars.length; i++) {
            if (res[chars[i]] == 1) {
                return i;
            }
        }
        return -1;
    }
}
