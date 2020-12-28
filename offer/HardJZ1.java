package com.hou.offer;

/**
 * @author hczs8
 */
public class HardJZ1{
    /**
     * 二维数组中的查找
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * 可以使用右上角或者左下角法判断
     */
    public boolean Find(int target, int [][] array) {
        // 选取右上角数字，比target大还是小
        // 大的话就排除所在列，找前面一列的右上角数字比较，小的话就排除所在行，找下一行的右上角数字
        // 列
        int y = array[0].length - 1;
        for (int i=0; i<array.length;) {
            if (y < 0) {
                return false;
            }
            if (array[i][y] == target) {
                return true;
            } else if (array[i][y] > target) {
                // 大于target，最后一列的最小的数都比target大，所以最后一列可以放弃了
                // 往前面一列的右上角数字找
                y--;
            } else if (array[i][y] < target) {
                // 右上角是这一行最大的数，都比target小，那这行也可以放弃了，下一行
                i++;
            }
        }
        return false;
    }
}
