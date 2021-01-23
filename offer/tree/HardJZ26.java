package com.hou.offer.tree;

import com.hou.util.TreeNode;

/**
 * @author ：hc
 * @date ：Created in 2021/1/23 20:18
 * @modified By：
 */
public class HardJZ26 {
    /**
     * 二叉搜索树与双向链表
     * 二叉搜索树，就是中序遍历是从小到大有序的
     * 所以，可以中序遍历的时候改变指针指向 让left指向上一个，right指向下一个
     * 要预先存储pre
     * 预先存储head作为返回值
     * 如何dfs？
     * 如果遍历的当前节点cur为空，则返回，证明是到最后了
     * dfs(left)
     * 如果pre为空 但是cur不为空 证明是第一个节点，把当前的cur赋值给head，然后 pre = cur
     * 如果pre不为空，则pre.right = cur cur.left = pre pre = cur
     * dfs(right)
     *
     * LeetCode上为双向循环链表，牛客这里只要求了双向链表
     * 循环链表怎么实现？只要再加一步尾 和 头互相指一下就行了，把尾和头连接起来
     */
    TreeNode pre, head;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        dfs(pRootOfTree);
        return head;
    }
    void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);
        if (pre == null) {
            // pre为空，证明是第一个节点，给head赋值
            head = cur;
        } else {
            pre.right = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}
