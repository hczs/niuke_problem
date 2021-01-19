package com.hou.offer.tree;

import com.hou.util.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author ：hc
 * @date ：Created in 2021/1/19 9:15
 * @modified By：
 */
public class HardJZ24 {
    /**
     * 二叉树中和为某一值的路径
     * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
     * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
     * 定义一个全局的path记录走过的点，然后定义一个当前路径值
     * 相等且当前为叶子结点的时候（证明是一条路径）放一下path
     * 二叉树先序遍历：根 左 右
     * 递归三部曲：
     * 1.函数作用：dfs搜索树
     * 2.结束条件：当前root为空的时候
     * 3.下一步递归：如果左子树不为空则遍历左子树，右子树不为空则遍历右子树
     * 记得回溯到上一结点
     * 递归真好
     */
    // 定义一个全局的path
    ArrayList<Integer> path = new ArrayList<>();
    // 当前path存储的和
    int sum = 0;
    // 全局存储目标值
    int targetSum;
    // 返回值
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        targetSum = target;
        dfs(root);
        return result;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 把当前结点放入path
        path.add(root.val);
        sum += root.val;
        if (sum == targetSum && root.left == null && root.right == null) {
            // 这里不能直接放进去path，因为直接放进去的话，path改变，result中的也会随之改变，所以需要创建一个新对象放入
            ArrayList<Integer> tmp = new ArrayList<>(path);
            result.add(tmp);
        }
        // 继续往下扫描
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        // 左右都为空，回溯到上一结点
        path.remove(path.size()-1);
        sum -= root.val;
    }

    /**
     * TODO 使用迭代优化
     *
     */
    public ArrayList<ArrayList<Integer>> FindPath1(TreeNode root, int target) {

        return result;
    }
}
