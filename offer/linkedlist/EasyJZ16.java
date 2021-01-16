package com.hou.offer.linkedlist;

import com.hou.util.ListNode;

/**
 * @author ：hc
 * @date ：Created in 2021/1/16 22:05
 * @modified By：
 */
public class EasyJZ16 {
    /**
     * 合并两个排序的链表
     * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
     * 两个指针一起走
     * 把较小的指针放到cur的next下，然后cur = cur.next
     * 然后继续比较
     * 当两个指针有一个为空时，就把另一个拼接到后面
     */

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1);
        ListNode cur = result;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        // 出循环肯定有一个为空，1为空就剩下的是list2，反之list1
        cur.next = list1 == null ? list2 : list1;
        return result.next;
    }

    /**
     * 递归
     * 三部曲：
     * 1.函数作用：递归函数的作用就是合并两个链表并返回头结点
     * 2.结束条件：list1为空，返回list2，list2为空，返回list1
     * 3.下一步递归：list1的val小于list2的val就把list1的next指向Merge(list1.next, list2)
     */
    public ListNode Merge1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            list1.next = Merge1(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge1(list1, list2.next);
            return list2;
        }
    }
}
