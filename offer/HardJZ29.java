package com.hou.offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ：hc
 * @date ：Created in 2021/1/9 16:20
 * @modified By：
 */
public class HardJZ29 {
    /**
     * 最小的k个数
     * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
     * input：[4,5,1,6,2,7,3,8],4
     * output：[1,2,3,4]
     *
     * 最简单做法，对数组进行排序，然后求前k个数，冒泡排序20ms
     */

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if (input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }

        // 冒泡排序
        for (int i=0; i<input.length; i++) {
            for (int j=input.length-1; j>i; j--) {
                if (input[j-1] > input[j]) {
                    int tmp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = tmp;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 好像基于冒泡的思想，冒到第k个泡了这前几名就出来了...
     * 重新修改，15ms，果然有显著提升呀！
     */
    public ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        if (input.length == 0 || k > input.length) {
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        // 冒泡排序
        for (int i=0; i<k; i++) {
            for (int j=input.length-1; j>i; j--) {
                if (input[j-1] > input[j]) {
                    int tmp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = tmp;
                }
            }
            // 每次冒泡完成之后，当前i就是冒出来的最小元素
            res.add(input[i]);
        }
        return res;
    }

    /**
     * 以上的方法是不建议使用的，因为这道题明显不是考察的数组排序
     * 可以维护一个大根堆，当不满的时候直接放进去，满了的时候与堆顶元素比较，小的话放进去
     * Java大根堆的实现是通过优先队列来实现的，优先队列默认是小根堆
     * 大跟堆需要预先Comparator.reverseOrder()告诉他
     * 也可以维护一个容量为k的集合，放满了就判断是否比当前集合最大元素小，然后再处理
     * 15ms
     */
    public ArrayList<Integer> getLeastNumbers1(int [] input, int k) {
        if (input.length == 0 || k > input.length || k == 0) {
            return new ArrayList<>();
        }
        // 大根堆
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int value : input) {
            // 堆不满的时候直接放进去即可
            if (priorityQueue.size() < k) {
                priorityQueue.offer(value);
            } else if (value < priorityQueue.peek()) {
                // 满了的话就判断是否小于堆顶元素，小于的话就放进去
                priorityQueue.poll();
                priorityQueue.offer(value);
            }
        }
        return new ArrayList<>(priorityQueue);
    }
}
