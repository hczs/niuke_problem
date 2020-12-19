package com.hou.offer.tree;

import com.hou.util.TreeLinkNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：hc
 * @date ：Created in 2020/12/19 13:22
 * @modified By：
 */
public class MediumJZ57 {
    /**
     * 二叉树的下一个节点
     * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
     * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
     * 暴力解吧：
     * 1.直接向上找root
     * 2.中序遍历root
     * 3.确定刚刚那个节点的下一个节点
     * 3.1 如何确定？
     * 把中序遍历结果遍历一遍，找到和刚刚节点相同 并且此节点不是最后一个节点的情况时，返回此节点下一个即可
     */

    List<TreeLinkNode> res = new ArrayList<>();

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 寻找root
        TreeLinkNode root;
        if (pNode == null){
            return null;
        }
        root = pNode;
        TreeLinkNode tmp = pNode;
        while (pNode != null) {
            root = pNode;
            pNode = pNode.next;
        }

        // 中序遍历root
        inOrder(root);

        // 遍历res出结果
        for (int i=0; i<res.size(); i++){
            if (res.get(i) == tmp && i+1 != res.size() ){
                return res.get(i+1);
            }
        }
        // 其他情况返回空即可
        return null;
    }

    /**
     * 中序遍历二叉树
     * @param root 二叉树
     */
    private void inOrder(TreeLinkNode root) {
        if (root != null){
            inOrder(root.left);
            res.add(root);
            inOrder(root.right);
        }
    }
}
