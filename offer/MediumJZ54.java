package com.hou.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author ：hc
 * @date ：Created in 2021/1/26 16:51
 * @modified By：
 */
public class MediumJZ54 {
    /**
     * 字符流中第一个不重复的字符串
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
     * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
     * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     *
     * 存入map中，key为字符，value为次数，然后获取的时候就遍历map找第一个出现一次的字符
     * 但是 map中我们找第一个出现key的肯定要遍历map的keySet的，但是这个ketSet是无序的，所以没有办法获取第一个只出现一次的
     *
     * 更换LinkedHashMap
     */
    LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
    public void Insert(char ch) {
        if (linkedHashMap.containsKey(ch)) {
            linkedHashMap.put(ch, linkedHashMap.get(ch) + 1);
        } else {
            linkedHashMap.put(ch, 1);
        }
    }
    public char FirstAppearingOnce() {
        for (Character ch : linkedHashMap.keySet()) {
            if (linkedHashMap.get(ch) == 1) {
                return ch;
            }
        }
        return '#';
    }

}
