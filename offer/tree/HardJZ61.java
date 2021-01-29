package com.hou.offer.tree;

import com.hou.util.TreeNode;

/**
 * @author ：hc
 * @date ：Created in 2021/1/9 12:40
 * @modified By：
 */
public class HardJZ61 {
    /**
     * 请实现两个函数，分别用来序列化和反序列化二叉树
     *
     * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
     * 从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
     * 序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
     *
     * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
     *
     * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
     *
     * 序列化：意思就是把一个二叉树转换为字符串存储
     * 反序列化：字符串转化为二叉树
     * 初步想法先序遍历（先根，再左右，因为空值以'#'存储，所以可以使用先序遍历）
     *
     * 反序列化如何实现
     * 递归实现，因为是从根开始，先反序列化root，然后再递归反序列化左右子树
     * 本来只有一个先序遍历结果是无法确定唯一的树的，但是这道题允许我们存储空值，所以就能确定唯一的树了
     * 要先根据"!"把字符串分为字符数组[1, 2, #, #, 3, #, #]
     * 然后遍历此数组生成树，所以我们需要一个全局变量记录下标index；
     * 算法流程：先判断是否是"#"，是的话就返回null（返回null，就相当于返回到了上一个节点了）
     * 然后以当前节点创建树节点，然后递归创建左树和右树
     */
    String seqTree = "";
    int index = 0;
    String Serialize(TreeNode root) {
        dfs(root);
        System.out.println("序列化之后的值为："+seqTree);
        return seqTree;
    }
    void dfs(TreeNode root) {
        if (root == null) {
            seqTree += "#!";
            return;
        } else {
            seqTree += String.valueOf(root.val) + "!";
        }
        dfs(root.left);
        dfs(root.right);
    }
    TreeNode Deserialize(String str) {
        String[] nodes = str.split("!");
        return helpDeserialize(nodes);
    }
    TreeNode helpDeserialize(String[] str) {
        if ("#".equals(str[index])) {
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str[index++]));
        node.left = helpDeserialize(str);
        node.right = helpDeserialize(str);
        return node;
    }
}
