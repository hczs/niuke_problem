package com.hou.offer.linkedlist;

import com.hou.util.ListNode;

/**
 * @author ：hc
 * @date ：Created in 2020/12/28 14:39
 * @modified By：
 */
public class HardJZ56 {
    /**
     * 删除链表中重复的结点
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
     * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
     * 注意：重复的结点不保留，记得先看清题目再做...
     * TODO 看题解做的，隔段时间重做
     */
    public ListNode deleteDuplication(ListNode pHead) {
        // 建立头指针指向头结点pHead
        ListNode res = new ListNode(0);
        res.next = pHead;
        // 双指针 一个是当前的cur，一个是cur的前一个pre
        ListNode pre = res;
        ListNode cur = pHead;
        while (cur != null) {
            // 如果当前有下一个结点 并且 当前结点与下一个结点重复
            if (cur.next != null && cur.val == cur.next.val) {
                // 执行删除直到当前结点与下一个结点不重复
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 最后再删除当前结点，因为重复的结点不保留
                cur = cur.next;
                // pre也随着cur移动
                pre.next = cur;
            } else {
                // 没有下一个结点 或者 下一个结点与当前结点不重复的时候
                // 正常后移扫描
                pre = cur;
                cur = cur.next;
            }
        }
        // 返回头结点
        return res.next;
    }

    /**
     * leetcode上的题 剑指offer18 删除链表的结点
     * @param head 链表头结点
     * @param val 指定删除的值
     * @return 删除值之后的链表头结点
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 先把为空 或 只有一个元素并且是目标值的情况排除
        if (head == null) {
            return null;
        }
        // 下面是一个元素不是目标值 或 一个以上的元素
        ListNode pre = head;
        ListNode cur = head.next;
        // 首先排除第一个元素
        if (pre.val == val) {
            return cur;
        }
        // 其他情况
        while (cur != null) {
            if (cur.val == val) {
                if (cur.next != null) {
                    // 要删除的节点在中间
                    pre.next = cur.next;
                } else {
                    // 要删除的节点是最后一个
                    pre.next = null;
                }
            }
            pre = cur;
            cur = cur.next;
        }
        return head;
    }

    /**
     * 删除结点 方法还可以简化一下
     * 创建一个虚拟的头指针，指向head
     * 然后找到要删除的点，删除即可
     */
    public ListNode deleteNode1(ListNode head, int val) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;
        // 找到要删除的节点，然后删除
        while (pre.next.val != val) {
            pre = pre.next;
        }
        // 跳出循环时，pre就是要删除的节点的前一个
        pre.next = pre.next.next;
        // 返回头结点
        return res.next;
    }

}
