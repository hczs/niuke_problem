package com.hou.offer.linkedlist;

import com.hou.util.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author ：hc
 * @date ：Created in 2021/1/10 17:27
 * @modified By：
 */
public class MediumJZ55 {
    /**
     * 链表中环的入口节点
     * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
     * 无脑法
     * 用set存储每一个节点，第一个重复的节点就是入口
     */

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (!set.add(pHead)) {
                return pHead;
            }
            pHead = pHead.next;
        }
        return null;
    }

    /**
     * 有脑法
     * 书上的解法就是牛，思路非常清晰
     * 分为三步
     * 1.先确定是否有环，如果有找到环中的一个点
     * 2.找到环中的一个点之后，通过这个点就能求出环的长度
     * 3.通过环的长度，来求环的入口
     * 第一步如何求环中的一个点？
     * 快慢指针，快指针一次走两步，慢指针一次走一步，如果有环，两个指针肯定是在环中相遇的（因为快指针快人一步先在环中循环等着慢指针慢悠悠过来），画图理解
     * 第二步如何通过环中的一个点来计算环的长度？
     * 这个简单，记录这个节点的值，然后循环下去，再次遇到这个节点的时候，就计算出来环的长度了
     * 第三步，如何通过环的长度求入口？
     * 这个也得画图，不然啥也不知道
     * 如果环长度为6（已知），链表总长n（未知）
     * 那么 求入口只需要从头结点走 n-6 步就行了，那么如何求 n-6呢？ 设 n-6 = m，先让a指针走6步（环长），然后此时剩下的就是m步了
     * 再让b指针从头和a指针一块走，当a走完全程到路口了，b同时也走了m步，到入口了，也就是 两指针相遇
     */

    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode fast = pHead;
        ListNode slow = pHead;
        // 先判断是否有环以及找环中的一个点
        while (fast != null) {
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
            if (fast == slow) {
                break;
            }
        }
        // 求环长度
        int count = 1;
        slow = slow.next;
        while (slow != fast) {
            slow = slow.next;
            count++;
        }
        // 根据环长度求入口，重新对fast和slow赋值，就不创建新对象了
        fast = pHead;
        slow = pHead;
        for (int i=0; i<count; i++) {
            fast = fast.next;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // 相遇的时候就到入口啦
        return fast;
    }

}
