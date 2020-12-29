package com.hou.offer;

import com.hou.util.ListNode;
import java.util.ArrayList;
import java.util.Stack;

public class HardJZ3{
    /**
     * 从尾到头打印链表
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * 两遍遍历？放到栈里面再出栈？
     * no，既然想到栈了，那递归也是可以的啊
     * 直接递归
     */
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    /**
     * 递归存在问题，因为当链表非常长的时候，会存在函数调用栈溢出的问题
     * 所以建议用栈
     * 循环两遍，第一次放入栈，第二次出栈返回
     */
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

}
