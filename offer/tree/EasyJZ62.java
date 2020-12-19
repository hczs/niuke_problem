package com.hou.offer.tree;

import com.hou.util.TreeNode;

import java.util.Stack;

/**
 * @author ：hc
 * @date ：Created in 2020/12/17 10:47
 * @modified By： hc
 */

public class EasyJZ62 {
    /**
     * 二叉搜索树的第 k 小 个节点
     * 二叉搜索树特点，左<根<右
     * 只需要中序遍历到第k个节点结束即可
     * 还有一种方法是递归遍历整棵树，放入list中，再取第k个（不考虑）
     */

    /**
     * 全局num：记录遍历节点数
     */
    int num = 0;

    /**
     * 递归版本
     * @param pRoot TreeNode
     * @param k 第k小
     * @return TreeNode
     */
    TreeNode KthNode(TreeNode pRoot, int k){
        // 中序遍历到第k个结束
        if (pRoot != null){
            // 递归遍历，按照左-根-右的顺序
            TreeNode leftNode = KthNode(pRoot.left, k);
            // 先找左边，找到了就返回
            if (leftNode != null){
                return leftNode;
            }
            // 遍历到这刚好是第k个，说明找到了，直接返回即可
            if (++num == k){
                return pRoot;
            }
            // 再找右边
            TreeNode rightNode = KthNode(pRoot.right, k);
            if (rightNode != null){
                return rightNode;
            }
        }
        // 树为
        return null;
    }

    /**
     * 非递归版本
     * @param pRoot TreeNode
     * @param k 第k小
     * @return TreeNode
     */
    TreeNode KthNode2(TreeNode pRoot, int k){
        if (pRoot == null){
            return null;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        // 分析当前节点，不为空则找左边
        // 不为空则，出栈，回退到上一个节点，k--，找右边
        // 循环条件：栈不为空 或 树不为空
        while (!nodeStack.isEmpty() || pRoot != null){
            if (pRoot != null){
                nodeStack.push(pRoot);
                pRoot = pRoot.left;
            }else{
                // 左子树找到最尽头了，回退到上一个节点
                // 此节点也是最小值
                pRoot = nodeStack.pop();
                if (--k == 0){
                    return pRoot;
                }
                // 找右边
                pRoot = pRoot.right;
            }
        }
        return null;
    }

}
