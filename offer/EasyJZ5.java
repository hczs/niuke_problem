package com.hou.offer;

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

/**
 * 思路：stack1用来存放正常入队的值
 * 如果要出队了，直接stack1出栈是不行的呀，所以把stack1全部出栈倒腾到stack2中，stack2再出栈就是出队的正确数字了
 * 例如当前队列： 1 2 3 4 5
 * stack1（底->上）：1 2 3 4 5  此时直接出栈自然是5，但是人家出队应该是出1才对，所以倒腾到stack2中
 * stack2（底->上）：5 4 3 2 1 此时出栈就是1啦！
 * 所以出栈就有了：先判断stack2是否为空，为空就把stack1中的值倒腾进来再出栈，不为空直接出栈
 * 进栈呢？就直接放入stack1即可
 * 所以这题的push和pop就都有了
 * 现在可以代码了~
 */
public class EasyJZ5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    /*public int pop() {
        if (stack2.isEmpty()){
            int len = stack1.size();
            // 注意此时要用len来代替size奥，不能直接写表达式，因为出栈的时候size也会变化的
            for (int i=0; i<len; i++){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }*/

    // 好像用while循环更优雅一些
    public int pop() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // 自己先写个main方法测试
    public static void main(String[] args) {
        EasyJZ5 queue = new EasyJZ5();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        queue.push(6);
        System.out.println(queue.pop());
    }
}
