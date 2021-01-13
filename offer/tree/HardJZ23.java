package com.hou.offer.tree;

import com.hou.util.TreeNode;

/**
 * @author ：hc
 * @date ：Created in 2021/1/13 14:08
 * @modified By：
 */
public class HardJZ23 {
    /**
     * 二叉搜索树的后序遍历序列
     * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
     * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
     * input：[4,8,6,12,16,14,10]
     * output：true
     *
     * 我想的是先默认这个是二叉搜索树，然后根据序列重建一颗树，再后序遍历，再比较，实在是太麻烦了，而且题中也没给用到的树的数据结构
     * 还有一种方法
     * 我们能够确定root，然后我们能确定左右子树分界线，如果分界线右侧出现一个值小于root，这不符合二叉搜索树的性质（left<root<right）
     * 所以可以这样递归判断！
     * 注意递归结束条件：为什么是start >= end？
     * 因为试想一种情况，序列为 7 8，start 0， end 1
     * 判断得到分界线divide: 1，递归 左子树 start 0，end 0
     * 递归右子树：start(divide) 1，end 0，此时 start > end，如果不结束，两个循环都不会进入
     * 会进入下一步递归：judgeBST(sequence, 1, -1) && judgeBST(sequence, 0, -1)
     * 出现了-1的情况，所以当第一步先确定root的时候就会出现数组下标越界异常
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length == 0) {
            return false;
        }

        return judgeBST(sequence, 0, sequence.length-1);
    }

    boolean judgeBST(int[] sequence, int start, int end) {
        // 结束条件
        if (start >= end) {
            return true;
        }
        // 确定root
        int root = sequence[end];
        // 默认分界线end
        int divide = end;
        // 找左右子树分界线
        for (int i=start; i<end; i++) {
            // 一直找直到出现一个比root大的值的时候，再往后就是右子树了
            if (sequence[i] > root) {
                divide = i;
                break;
            }
        }
        // 找右子树中是否存在小于root的值，小于就返回false
        for (int i=divide; i<end; i++) {
            if (sequence[i] < root) {
                return false;
            }
        }
        // 继续递归找左右子树，看看他们是否符合条件
        return judgeBST(sequence, start, divide-1) && judgeBST(sequence, divide, end-1);
    }

    public static void main(String[] args) {
        HardJZ23 hardJZ23 = new HardJZ23();
        int[] sequence = new int[]{4,6,7,5};
        System.out.println(hardJZ23.VerifySquenceOfBST(sequence));
    }

}
