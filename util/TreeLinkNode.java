package com.hou.util;

/**
 * 此二叉树包含一个next指针，指向的是下一个节点（横向），也就是指向兄弟节点
 * 更准确的说是指向右边节点
 */
public class TreeLinkNode {
    public int val;
    public TreeLinkNode left = null;
    public TreeLinkNode right = null;
    public TreeLinkNode next = null;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
