package com.hou.offer.tree;

import com.hou.util.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author ：hc
 * @date ：Created in 2021/1/20 17:14
 * @modified By：
 */
public class HardJZ58 {
    /**
     * 对称的二叉树
     * 请实现一个函数，用来判断一棵二叉树是不是对称的。
     * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     * input：{8,6,6,5,7,7,5}
     * output：true
     * input：{8,6,9,5,7,7,5}
     * output：false
     *
     * bfs，每一层遍历的存入队列，双指针同时扫描查看是否对称
     * 第一次提交未通过：原因，没有考虑最后一层只有一个叶子节点的情况，如果只有一个元素，我的那个循环直接通过了就
     * 解决办法：不用一个集合存储当前行数据了，用两个集合存储，然后一个从头到尾 一个从尾到头 扫描
     * 两个集合 先比较长度是否相等，再比较数据是否相同
     * 第二次提交未通过：树为空是 对称的  不能return false...
     *
     * 第三次提交：通过 13ms！
     * LeetCode上提交未通过：原因：如果一边是右子树 9 8 另一边也是右子树 8 9，导致不通过
     * 解决办法：空节点也得存储，存储 0 作为空节点
     *
     * LeetCode上提交还未通过：原因，0不能作为空节点，因为也可能是值，以后考虑清楚再提交
     * 解决办法：以String存储，空存储一个null字符串
     *
     * 程序不怎么样。。我选择递归重新写
     */

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (queue.size() != 0) {
            // 存储下一行数据
            ArrayList<String> leftNodes = new ArrayList<>();
            ArrayList<String> rightNodes = new ArrayList<>();
            // 存储当前行节点
            ArrayList<TreeNode> treeNodes = new ArrayList<>(queue);
            for (TreeNode node : treeNodes) {
                queue.poll();
                // 遍历存储下一层节点
                if (node.left != null) {
                    queue.offer(node.left);
                    leftNodes.add(String.valueOf(node.left.val));
                } else {
                    leftNodes.add("null");
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    rightNodes.add(String.valueOf(node.right.val));
                } else {
                    rightNodes.add("null");
                }
            }
            // 长度不一样直接pass
            if (leftNodes.size() != rightNodes.size()) {
                return false;
            } else {
                for (int i=0,j=rightNodes.size()-1; i<leftNodes.size(); i++,j--) {
                    if (!leftNodes.get(i).equals(rightNodes.get(j))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 看了评论区解法
     * 原来一个队列存储就行了
     * 先把root的左右节点放进去，然后出队，判断左右是否相同（左右都为空 或者 都不为空且值相等 通过）
     * 下一步就放进去 左子树的左子树 和 右子树的右子树 和 左子树的右子树 和 右子树的左子树（就是按照对称的往里面放）
     * 然后队列为空的时候 结束循环
     *
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (queue.size() != 0) {
            // 先提取左右子树
            TreeNode leftNode = queue.peekFirst();
            queue.poll();
            TreeNode rightNode = queue.peekFirst();
            queue.pop();
            // 进行判断，都为空 直接结束本次循环了，继续判断下一对左右子树
            if (leftNode == null && rightNode == null) {
                continue;
            }
            // 如果有一个值为空了（因为之前判断过了肯定不是同时都为空），说明 不一样 或者 值不相同 的时候 返回false
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            // 对称放入队列
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    /**
     * 用递归再写
     * left.val = right.val
     * left.left.val = right.right.val
     * left.right.val = right.left.val
     * 递归三部曲
     * 1.函数作用：用一个isSame(left, right)判断是否对称
     * 2.结束条件： left 和 right 同时为空 return true 或 有一个为空 return false
     * 3.下一步递归： 放进去 左子树的左子树 和 右子树的右子树 和 左子树的右子树 和 右子树的左子树（就是按照对称的往里面放） 是否same
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        // 如果有一个为空就不行 或者 值不一样也不行
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }

}
