package com.hou.offer;

import java.util.Stack;

/**
 * @author ：hc
 * @date ：Created in 2021/1/7 15:26
 * @modified By：
 */
public class HardJZ20 {
    /**
     * 包含min函数的栈
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
     * 维护一个最小栈
     * push的时候，看将要push的元素是否小于咱们最小栈的栈顶元素，如果小的话就也push进去
     * pop的时候，看咱们pop的元素是否是最小栈的栈顶元素，是的话也同步pop
     * 也会有个疑问，就是这样最小栈的元素并不完整
     * 答：为什么要完整？ 假如有以下操作
     *        从左到右-自底向上
     * push 3 stack(3) minStack(3)
     * push 2 stack(3,2) minStack(3,2)
     * push 4 stack(3,2,4) minStack(3,2)
     * 现在的情况的话，求最小值，就是minStack的栈顶元素
     * 求最小值只是返回最小值，又不是让最小值出栈！求n次也一样
     */

    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        // 推进去的时候看是否是最小值
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        }
        stack.push(node);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
