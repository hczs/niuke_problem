package com.hou.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author ：hc
 * @date ：Created in 2021/1/3 14:40
 * @modified By：
 */
public class HardJZ27 {
    /**
     * 字符串的排列
     * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
     * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
     *
     * 固定第一个字符，然后递归求后面的全排列情况
     * 字符重复问题用set去重
     * 字典序问题，算出来再进行一次排序吧
     * dfs结束条件：当下标为length-1时，就代表到最后一个字符了，就存储当前的c，代表完成了一次排列
     * 每次dfs完成之后，得恢复为交换字符之前的样子，才能继续以下一个字符为基准继续dfs
     */

    // 全局字符数组，目标字符串转为字符数组进行操作
    char[] c;
    // 存储结果
    ArrayList<String> result = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        // 全排列之后再排序
        TreeSet<String> treeSet = new TreeSet<>(result);
        result = new ArrayList<>(treeSet);
        return result;
    }

    void dfs(int pos) {
        // 证明到最后一个字符了，完成一次排列，记录结果
        if (pos == c.length-1) {
            result.add(String.valueOf(c));
            return;
        }
        // set的作用，来去除重复的字符，防止重复排列
        HashSet<Character> set = new HashSet<>();
        for (int i=pos; i<c.length; i++) {
            // 重复就跳过这次排列
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[pos]);
            swap(i, pos);
            dfs(pos+1);
            swap(i, pos);
        }
    }

    void swap(int x, int y) {
        char tmp = c[x];
        c[x] = c[y];
        c[y] = tmp;
    }



    public static void main(String[] args) {
        HardJZ27 hardJZ27 = new HardJZ27();
        System.out.println(hardJZ27.Permutation("ab"));
    }

}
