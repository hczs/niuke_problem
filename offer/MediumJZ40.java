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
     * 13ms
     */

    public void FindNumsAppearOnce(int [] array, int[] num1, int[] num2) {
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

    /**
     * 优化
     * 使用异或，因为异或特性是相同为0
     * 整体异或完成之后 剩下的值 就是这两个不同的数异或的值
     * 然后找这两个数的不同点，比如 0010 ^ 1010 = 1000
     * 看这个结果中的从低到高第一个1，以这个为标记分组异或，再次扫描array，分出这两个值
     * （为什么要以这个为标记分组异或，因为这样可以分别出来这两个值，为什么不用0？因为异或 两个值相同部分是0）
     */

    public void FindNumsAppearOnce1(int [] array, int[] num1, int[] num2) {
        // 为什么可以把他初始值设置为0，因为0异或任何数都是任何数本身
        int value = 0;
        for (int num : array) {
            value ^= num;
        }
        // 开始找标记，找不到mask就一直往左移持续寻找第一个1
        int mask = 1;
        while ((mask & value) == 0) {
            mask <<= 1;
        }
        num1[0] = 0;
        num2[0] = 0;
        // 以mask为基准分组异或   0010 ^ 1010 = 1000 以这个来辅助想象， 这样分的两组只有一个不同的数，而相同的数会被异或消除掉，所以只剩下那个不同的数了
        for (int num : array) {
            // 注意此处分组的判断，与mask做与运算，可以把这两个数分开
            if ((mask & num) != 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }
}
