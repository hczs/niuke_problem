package com.hou.offer;

import java.net.Inet4Address;
import java.util.ArrayList;

/**
 * @author ：hc
 * @date ：Created in 2021/1/3 14:13
 * @modified By：
 */
public class HaedJZ13 {
    /**
     * 调整数组的顺序使奇数位于偶数前面
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
     * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
     * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * 初步想法，就是扫描一遍然后把奇数放一个数组里面，偶数放一个数组里面最后再合并
     * // TODO 需要更好的解法
     */

    public void reOrderArray(int [] array) {
        if (array == null) {
            return;
        }
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        // 分开奇数偶数
        for (int element : array) {
            if ((element & 1) == 1) {
                odd.add(element);
            } else {
                even.add(element);
            }
        }
        // 合并
        int index = 0;
        for (int element : odd) {
            array[index++] = element;
        }
        for (int element : even) {
            array[index++] = element;
        }
    }

}
