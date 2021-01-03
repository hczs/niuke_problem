package com.hou.offer.linkedlist;

import com.hou.util.ListNode;

/**
 * @author ：hc
 * @date ：Created in 2021/1/3 17:53
 * @modified By：
 */
public class MediumJZ36 {
    /**
     * 两个链表的第一个公共结点
     * 输入两个链表，找出它们的第一个公共结点。
     * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
     * 没做出来，参考题解了
     * 也就是找他们相交的结点
     * 可以设两个链表的长度分别为L1+C 和 L2+C
     * 当第一个链表的指针从头开始走 走 L1+C步的时候，再走L2步，走过的总长为 L1+L2+C
     * 当第二个链表的指针从头开始走 走 L2+C步的时候，再走L1步，走过的总长为 L1+L2+C
     * 此时，相遇，找到公共结点
     */

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        while (node1 != node2) {
            // 走到终点之后换链表继续走
            if (node1 == null) {
                node1 = pHead2;
            } else {
                node1 = node1.next;
            }
            if (node2 == null) {
                node2 = pHead1;
            } else {
                node2 = node2.next;
            }
        }
        return node1;
    }
}
