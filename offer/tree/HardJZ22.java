package com.hou.offer.tree;

import com.hou.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author ：hc
 * @date ：Created in 2021/1/5 11:42
 * @modified By：
 */
public class HardJZ22 {
    /**
     * 从上往下打印二叉树
     * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
     * 第二次做了
     * bfs
     * 从上往下逐层遍历，每一层的数据存储到一个队列中，先进先出
     */

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(root.right);
            }
        }
        return res;
    }


    /**
     * LeetCode同款题
     * 同样的思路为什么牛客总是超时......
     */
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            resultList.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        int[] result = new int[resultList.size()];
        int i=0;
        for (Integer element : resultList) {
            result[i++] = element;
        }
        return result;
    }
}
