package com.hou.offer.tree;

import com.hou.util.TreeNode;

import java.util.*;

/**
 * @author ：hc
 * @date ：Created in 2021/1/26 9:06
 * @modified By：
 */
public class HardJZ59 {
    /**
     * 按之字形打印二叉树
     * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
     * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
     *
     * 初步想法，就是bfs，然后需要判断一下行数的奇偶，奇数行总是从左到右，偶数行总是从右到左
     * 问题就是怎么放，依旧使用队列存储下一行数据
     * 奇数行遍历：扫描当前行，因为是奇数行，所以下一行要 先放右，再放左
     * 偶数行遍历：扫描当前行，因为上一行是先右后左，所以自然就是从右边往左边遍历了，但是，从右到左，怎么把下一行数据从左到右放入呢
     * 队列 猝
     * 如何从右边到左遍历的同时能够使下一行能够从左到右遍历
     * 可以用栈， 依次从右到左 放子树 放左 右
     * 使用栈存储下一行数据（奇数行总是从左到右，偶数行总是从右到左）
     * 奇数行：扫描当前行存入ArrayList，依次放入每个结点的 左 右 左 右，下一行（偶数行） 栈出栈就是 右 左 右 左
     * 偶数行：扫描当前行存入ArrayList，依次放入每个结点的 右 左 右 左，下一行（奇数行） 栈出栈就是 左 右 左 右
     * 每遍历完成一行存入result
     *
     * 这个是老实人解法........
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 使用一个flag来标记是奇数行还是偶数行 奇数行为true，偶数行为false
        boolean flag = true;
        stack.push(pRoot);
        while (stack.size() != 0) {
            ArrayList<Integer> curList = new ArrayList<>();
            ArrayList<TreeNode> curLine = new ArrayList<>();
            while (stack.size() != 0) {
                curLine.add(stack.pop());
            }
            if (flag) {
                for (TreeNode node : curLine) {
                    curList.add(node.val);
                    // 奇数行下一行，先放左后放右
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                }
            } else {
                for (TreeNode node : curLine) {
                    curList.add(node.val);
                    // 偶数行下一行，先放右后放左
                    if (node.right != null) {
                        stack.push(node.right);
                    }
                    if (node.left != null) {
                        stack.push(node.left);
                    }
                }
            }
            result.add(curList);
            flag = !flag;
        }
        return result;
    }

    /**
     * 完全可以扫描完毕之后判断当前行是奇还是偶，偶数行就把当前行的list反转一下...........
     * 还有一个方法是使用双端队列，按照奇偶来分 addLast() or addFirst() 学到了..
     */
    public ArrayList<ArrayList<Integer> > Print1(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        // 队列存储
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        // 标志奇偶行，奇 true 偶 false，偶数行需要反转
        boolean flag = true;
        while (queue.size() != 0) {
            ArrayList<Integer> curList = new ArrayList<>();
            for (int i=queue.size(); i>0; i--) {
                TreeNode node = queue.poll();
                curList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            // 偶数行需要反转再存储
            if (!flag) {
                Collections.reverse(curList);
            }
            flag = !flag;
            result.add(curList);
        }
        return result;
    }
}
