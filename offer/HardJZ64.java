package com.hou.offer;

import java.util.*;

/**
 * @author ：hc
 * @date ：Created in 2021/1/12 8:36
 * @modified By：
 */
public class HardJZ64 {
    /**
     * 滑动窗口的最大值
     * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
     * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
     * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
     * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
     * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
     * 窗口大于数组长度的时候，返回空
     *
     * 直接暴力O(n²)
     * 循环次数 n*size
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        if (size > num.length || size == 0) {
            return new ArrayList<>();
        }
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0; i<num.length; i++) {
            max = Integer.MIN_VALUE;
            for (int j=i; j<i+size; j++) {
                if (num[j] > max) {
                    max = num[j];
                }
            }
            // 每次循环完成之后将此滑动窗口最大值放入res中
            res.add(max);
            // 每次判断完一个滑动窗口之后，判断当前滑动窗口是否为最后一个
            if (i + size == num.length) {
                break;
            }
        }
        return res;
    }

    /**
     * 再优化，一次循环可以吗
     * 可以用之前用过的大根堆
     * 两个指针，j指针先走size步，然后i指针和j指针同步走
     * 往大根堆里放入值
     * 当i==j的时候，证明i走了size步，获取堆顶的值，放入res
     * 然后把刚开始加入到堆中的值删掉
     * 再j++，往后滑动一步，到下一个窗口
     * 但是循环次数是 size * (n - size) =  n*size - size²
     * 少循环了size²，还是很大
     */
    public ArrayList<Integer> maxInWindows1(int [] num, int size) {
        if (size > num.length || size == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<Integer> res = new ArrayList<>();
        for (int i=0,j=size-1; j<num.length; i++) {
            priorityQueue.offer(num[i]);
            if (i == j) {
                res.add(priorityQueue.peek());
                priorityQueue.remove(num[i+1-size]);
                j++;
            }
        }
        return res;
    }

    /**
     * 新思路：单调队列
     * 关联min函数的栈：当时是维护一个单调栈来实现O(1)的时间内来获取最小元素
     * 滑动窗口对应的数据结构是 双端队列
     * 这里可以同时维护一个单调队列 解决问题
     * 单调队列
     * 保证队列内元素是滑动窗口内的元素
     * 保证队列非严格单调递减：有新加入元素时，保证把队列中比新加入元素小的值都删去
     * 意思就是依次往后扫描，一边扫描一边维护这个单调队列
     * 需要注意的事项：窗口滑动时第一个值，也就是滑动过去的值，如果是最大值的话就得删去，不是最大值可以不予理睬，
     * 因为到后面新加的值，如果比最大值大，会更新，如果比最大值小，那更不用管了，所以我们只需要关注最大值
     * 参考生成第一个窗口时的状态思考
     * {[2,3,4],2,6,2,5,1}
     * 时间复杂度O(n)！
     */
    public ArrayList<Integer> maxInWindows2(int [] num, int size) {
        if (size > num.length || size == 0) {
            return new ArrayList<>();
        }
        // 维护这个单调队列
        Deque<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        // 没有形成窗口的时候
        for (int i=0; i<size; i++) {
            // 有新加入元素时，要把比新加入的元素小的都删除了
            while (!queue.isEmpty() && queue.peekLast() < num[i]) {
                queue.removeLast();
            }
            queue.addLast(num[i]);
        }
        result.add(queue.peek());
        // 开始滑动
        for (int i=size,j=0; i<num.length; i++) {
            // 如果当前队列最大的是被滑动过去的元素，就删掉，其他元素无所谓
            if (queue.peek() == num[i-size]) {
                queue.removeFirst();
            }
            // 添加新元素
            while (!queue.isEmpty() && queue.peekLast() < num[i]) {
                queue.removeLast();
            }
            queue.addLast(num[i]);
            result.add(queue.peek());
        }
        return result;
    }

    /**
     * leetcode同款题
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k > nums.length || k == 0) {
            return new int[]{};
        }
        // 维护这个单调队列
        Deque<Integer> queue = new LinkedList<>();
        // 计算滑动窗口的最大值的个数
        int[] result = new int[nums.length - k + 1];
        // 没有形成窗口的时候
        for (int i=0; i<k; i++) {
            // 有新加入元素时，要把比新加入的元素小的都删除了
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
        }
        result[0] = queue.peek();
        // 开始滑动
        for (int i=k,j=1; i<nums.length; i++) {
            // 如果当前队列最大的是被滑动过去的元素，就删掉，其他元素无所谓
            if (queue.peek() == nums[i-k]) {
                queue.removeFirst();
            }
            // 添加新元素
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) {
                queue.removeLast();
            }
            queue.addLast(nums[i]);
            result[j++] = queue.peek();
        }
        return result;
    }

}
