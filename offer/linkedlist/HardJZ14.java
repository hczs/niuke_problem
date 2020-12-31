package com.hou.offer.linkedlist;

import com.hou.util.ListNode;

import java.util.ArrayList;

/**
 * @author ：hc
 * @date ：Created in 2020/12/31 20:43
 * @modified By：
 */
public class HardJZ14 {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * input： 1,{1,2,3,4,5}
     * output：{5}
     * 这个一般解法：遍历链表求出长度n，然后再次遍历求第n-k个结点
     */

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int n = 0;
        ListNode tmp = head;
        while (tmp != null) {
            n++;
            tmp = tmp.next;
        }
        // 要考虑非正常参数的情况
        if (k > n) {
            return null;
        }
        for (int i=0; i<n-k; i++) {
            head = head.next;
        }
        return head;
    }

    /**
     * 优雅的解法，双指针，时间复杂度严格控制在O(n)，不论如何都是遍历一次
     * 双指针如何操作呢？
     * 一个fast，一个slow，fast先走k步，然后slow开始和fast一起走，知道fast为空，证明扫描到末尾了
     * 此时返回slow即可，控制两个指针之间刚好相差k步
     * 二话不说上代码
     */
    public ListNode FindKthToTail1(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode slow = null;
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            k--;
            // fast走k步之后slow启动，等于0的时候启动
            if (k == 0) {
                slow = head;
            }
            // 小于0的时候跟fast脚步
            if (k < 0) {
                slow = slow.next;
            }
        }
        return slow;
    }
}
