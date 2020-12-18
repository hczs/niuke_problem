package com.hou.offer;

import com.hou.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ：hc
 * @date ：Created in 2020/12/18 11:25
 * @modified By：
 */
public class MediumJZ60 {
    /**
     * 把二叉树打印成多行(从上到下打印二叉树)
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     * 基础题：bfs（广度优先搜索）
     * 利用队列循环提取每层数据（因为队列中有节点数据），提取的同时将下层节点放入队列
     * 第一次就将root放入节点就行
     * 两层循环
     * 外层循环跳出条件：队列为空（证明下一层数据为空）
     * 内层循环：预先存储队列长度，循环这个队列的长度次，出队每个节点，取值放入res中
     * 本题结果要求分行存储，所以需要维护一个tmp来存储每行数据，读取一行往res中放一次
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // 记得判空，而且还不能返回null，应该返回一个空的对象，也就是[]
        if (pRoot == null){
            return res;
        }
        // LinkedList implements Deque and Deque extends Queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()){
            // 因为题目要求分行存储，使用tmp来存储每行的数据
            ArrayList<Integer> tmp = new ArrayList<>();
            // 循环队列的长度次
            for (int i=queue.size(); i>0; i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                // 添加完此节点的值，再看看它左右子树（也就是下一层）是否为空，不为空就添加到queue中
                // 所以queue才能储存下一层的值，每一个节点扫描都不放过
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            // 一行数据循环完毕后已经都放入到tmp中了，此时只需要将tmp放入res即可
            res.add(tmp);
        }
        return res;
    }

}
