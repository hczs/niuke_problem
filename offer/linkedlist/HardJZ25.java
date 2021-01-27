package com.hou.offer.linkedlist;

import com.hou.util.RandomListNode;

import java.util.HashMap;

/**
 * @author ：hc
 * @date ：Created in 2021/1/27 9:21
 * @modified By：
 */
public class HardJZ25 {
    /**
     * 复杂链表的复制
     * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
     * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
     *
     * 常规思路
     * 使用map存储旧结点与新结点的映射关系
     * 然后再次遍历，根据旧结点建立新结点的指针连接
     */
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> hashMap = new HashMap<>();
        RandomListNode tmp = pHead;
        while (tmp != null) {
            RandomListNode node = new RandomListNode(tmp.label);
            hashMap.put(tmp, node);
            tmp = tmp.next;
        }
        tmp = pHead;
        while (tmp != null) {
            RandomListNode node = hashMap.get(tmp);
            node.next = tmp.next == null ? null : hashMap.get(tmp.next);
            node.random = tmp.random == null ? null : hashMap.get(tmp.random);
            tmp = tmp.next;
        }
        return hashMap.get(pHead);
    }
}
