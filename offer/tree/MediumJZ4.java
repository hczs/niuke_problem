package com.hou.offer.tree;

import com.hou.util.TreeNode;

import java.util.Arrays;

/**
 * @author ：hc
 * @date ：Created in 2020/12/29 9:35
 * @modified By：
 */
public class MediumJZ4 {
    /**
     * 重建二叉树
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * 先看前序：前序的第一个肯定是根节点
     * 再看中序：找到前序的第一个节点，左边就是左子树，右边部分就是右子树，因为中序是 左 根 右
     * 按照和这个思路写，关键就是如何切分数组
     * 可以记录下标来切分数组
     * 还可以使用Arrays.copyOfRange来切分，这个函数是前闭后开，比如[1,2,3,4,5] 切分 0,2 结果就是 [1,2]，就是包括下标0的元素但是不包括下标2的元素
     * 这里使用下标来切分
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return dfs(pre, 0, pre.length-1, in, 0, in.length-1);
    }

    TreeNode dfs(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        int mid = inStart;
        // 去中间部分找当前根
        for (int i=inStart; i<=inEnd; i++) {
            if (in[i] == node.val) {
                mid = i;
                break;
            }
        }
        // 创建左右子树
        node.left = dfs(pre, preStart+1, preStart+mid-inStart, in, inStart, mid-1);
        node.right = dfs(pre, preStart+mid-inStart+1, preEnd, in, mid+1, inEnd);
        return node;
    }
}
