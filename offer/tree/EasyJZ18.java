package com.hou.offer.tree;

import com.hou.util.TreeNode;


public class EasyJZ18 {

    /**
     * 二叉树的镜像
     * 操作给定的二叉树，将其变换为源二叉树的镜像。
     *
     * 二叉树的镜像定义：源二叉树
     *     	    8
     *     	   /  \
     *     	  6   10
     *     	 / \  / \
     *     	5  7 9 11
     *
     *     	镜像二叉树
     *     	    8
     *     	   /  \
     *     	  10   6
     *     	 / \  / \
     *     	11 9 7  5
     */

    // 其实就是左右子树进行转换，可以用递归
    // 如果树为空 什么都不干
    // 树不为空，交换左右子树
    // 然后再递归交换左右子树的左右子树即可
    public void Mirror(TreeNode root) {
        if (root != null){
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    // 刚看了一位更棒的写法
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }
}
