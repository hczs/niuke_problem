package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2021/1/28 9:14
 * @modified By：
 */
public class HardJZ65 {
    /**
     * 矩阵中的路径
     * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
     * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * input："ABCESFCSADEE",3,4,"ABCCED"
     * output：true
     * input："ABCESFCSADEE",3,4,"ABCB"
     * output：false
     * 思路很简单，就是根据给定的str路径，然后dfs矩阵，从第一行第一个开始，找属于str的第一个字符，然后搜上下左右
     *
     * dfs：
     * 参数：矩阵数组，字符串，当前行，当前列，当前扫描的字符下标
     * 终止条件：返回false：数组下标越界、字符不匹配，已扫描过的字符；
     *          返回 true：字符串的下标 为 字符串长度减一，证明已经扫描完字符串了，有了一条完整的路径
     *  标记当前字符证明是走过了
     * 下一步递归：上下左右四个方向依次dfs
     * 回溯：去掉标记，证明此路不通，不走了，返回上一步
     * 返回
     *
     * 二维数组用一维数组上表示的下标计算错误..........草率了
     */
    // 全局记录行和列的长度
    int rows;
    int cols;
    // 标记是否走过了
    boolean[] isVisited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.rows = rows;
        this.cols = cols;
        isVisited = new boolean[matrix.length];
        for (int i=0; i<matrix.length; i++) {
            isVisited[i] = false;
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                // 如果从某一个点可以搜出来一条路径，就返回true
                if (dfs(matrix, str, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索字符矩阵中是否有要找的路径
     * @param matrix 字符矩阵
     * @param str 要找的路径
     * @param row 当前行
     * @param col 当前列
     * @param position 扫描路径中的下标
     * @return 是否符合条件
     */
    boolean dfs(char[] matrix, char[] str, int row, int col, int position) {
        // 首先排除下标越界，访问过了，不符合当前条件
        if (row < 0 || row >= rows || col < 0 || col >= cols || isVisited[row * cols + col] || matrix[row * cols + col] != str[position]) {
            return false;
        }
        // 成功的时候返回
        if (position == str.length - 1) {
            return true;
        }
        // 都不是，标记本路径，并进行下一步递归
        isVisited[row * cols + col] = true;
        // 搜它的上下左右有没有符合的
        boolean result = dfs(matrix, str, row-1, col, position+1) || dfs(matrix, str, row+1, col, position+1)
                || dfs(matrix, str, row, col-1, position+1) || dfs(matrix, str, row, col+1, position+1);
        // 回溯
        isVisited[row * cols + col] = false;
        return result;
    }

    public static void main(String[] args) {
        HardJZ65 hardJZ65 = new HardJZ65();
        String a = "ABCESFCSADEE";
        /**  0 1 2 3
         * 0 A B C E
         * 1 S F C S
         * 2 A D E E
         *
         * 0 1 2 3 4 5
         * A B C C E D
         */
        int r = 3;
        int c = 4;
        String path = "ABCCED";
        System.out.println(hardJZ65.hasPath(a.toCharArray(), r, c, path.toCharArray()));
    }
}
