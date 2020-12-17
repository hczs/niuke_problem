package com.hou.offer;


import com.hou.util.TreeNode;
import com.sun.xml.internal.bind.v2.TODO;

public class EasyJZ38 {

    /**
     * 题目描述
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
     * 最长路径的长度为树的深度。
     */

    // 递归访问左右子树，两个子树中更长的子树加一就是整个树的长度
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }

    // TODO 需要第二种解法
}
