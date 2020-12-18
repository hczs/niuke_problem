package com.hou.offer;

import com.hou.util.TreeNode;

/**
 * @author ：hc
 * @date ：Created in 2020/12/18 10:15
 * @modified By：
 */
public class EasyJZ39 {
    /**
     * 平衡二叉树
     * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
     * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1
     * 并且左右两个子树都是一棵平衡二叉树。
     * 初步思路：分别求左右子树的深度，然后相减，绝对值小于等于一 && 左右子树都为平衡二叉树
     * 就是按照题意来做
     *
     * 注意：牛客上不限制左右子树都为平衡二叉树条件也会通过，建议在leetcode上找同款题，有限制每个节点左右子树都为平衡二叉树条件测试用例
     */

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null){
            return true;
        }
        return Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    /**
     * 求二叉树深度
     * @param root 二叉树
     * @return 深度
     */
    int treeDepth(TreeNode root){
        if (root == null){
            return 0;
        }else{
            return Math.max(treeDepth(root.left), treeDepth(root.right)) + 1;
        }
    }

}
