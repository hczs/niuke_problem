package com.hou.offer;

import java.util.Stack;

/**
 * @author ：hc
 * @date ：Created in 2021/2/1 10:20
 * @modified By：
 */
public class HardJZ66 {
    /**
     * 机器人的运动范围
     * 地上有一个m行和n列的方格。
     * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
     * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
     * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
     * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
     *
     * 我选择dfs
     */
    int[][] mark;
    int res = 0;
    public int movingCount(int threshold, int rows, int cols) {
        mark = new int[rows][cols];
        dfs(threshold,0,0,rows,cols);
        return res;
    }

    void dfs(int threshold, int curRow, int curCol, int rows, int cols) {
        // 检查是否越界 或者 是已经走过的
        if (curRow < 0 || curRow >= rows || curCol < 0 || curCol >= cols || mark[curRow][curCol] == 1) {
            return;
        }
        // 检查坐标是否有效，无效返回就行
        if (sumRowAndCol(curRow, curCol) > threshold) {
            return;
        }
        // 通过重重检测，标记可以走
        mark[curRow][curCol] = 1;
        res++;
        // 下一步递归，往上下左右走
        dfs(threshold,curRow-1, curCol, rows, cols);
        dfs(threshold,curRow+1, curCol, rows, cols);
        dfs(threshold,curRow, curCol-1, rows, cols);
        dfs(threshold,curRow, curCol+1, rows, cols);
    }

    int sumRowAndCol(int row, int col) {
        int sum = 0;
        while (row != 0) {
            sum += row % 10;
            row = row / 10;
        }
        while (col != 0) {
            sum += col % 10;
            col = col / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HardJZ66 hardJZ66 = new HardJZ66();
        System.out.println(hardJZ66.movingCount(10,1,100));
    }
}
