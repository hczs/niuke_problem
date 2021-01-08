package com.hou.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author ：hc
 * @date ：Created in 2021/1/8 21:23
 * @modified By：
 */
public class MediumJZ21 {
    /**
     * 栈的压入，弹出序列
     * 输入两个整数序列，第一个序列表示栈的压入顺序，
     * 请判断第二个序列是否可能为该栈的弹出顺序。
     * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
     * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
     * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
     * input：[1,2,3,4,5],[4,3,5,1,2]
     * output：false
     * 初步想法，很无赖，就是写一个栈模拟压入，弹出
     * 无赖的写法也不容易...提交了三次才通过.......
     * 自己模拟栈进出的时候
     * 就例题而言：先压入1，然后看1是否是第二个数组的首个元素，相同的话就pop，不相同的话就继续push新元素
     * 知道压入了1 2 3 4，再进入popA数组循环的时候，发现首个元素相同了，就pop，再继续循环，发现没有相同的了，再push 5
     * 然后再进入循环，此时，我们应该不判断这个4了，所以我们得想办法移除这个4，然后继续判断，但是数组遍历同时删除？那太麻烦了，用集合什么的
     * 遍历同时对其进行更改还会报异常，那更不行，如何解决？
     * 解决办法：利用一个集合trash（垃圾桶），记录pop过的元素，只要是出栈了的就是判断成功了的，就放入垃圾桶
     * 这样进循环先检测，就可以正常继续判断了！
     */

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> trash = new ArrayList<>();
        for (int i : pushA) {
            // 压入一个元素
            stack.push(i);
            for (int j : popA) {
                // 检查是否是已经pop过的
                if (trash.contains(j)) {
                    continue;
                }
                // 没有pop过就正常检查
                if (stack.peek() == j) {
                    stack.pop();
                    trash.add(j);
                } else {
                    break;
                }
            }
        }
        return stack.size() == 0;
    }


    /**
     * 在评论区看到了别人的代码，自卑了.....
     * 我怎么做的这么麻烦，用一个j+1就解决的事情！！！！！！！！！！！
     */
    public boolean IsPopOrder1(int [] pushA,int [] popA) {
        int len = pushA.length;
        Stack<Integer> s = new Stack<Integer>();

        for(int i=0, j=0;  i < len; i++){
            s.push(pushA[i]);
            while(j < len && s.peek() == popA[j]){
                s.pop();
                j = j+1;
            }
        }
        return s.empty();
    }
}
