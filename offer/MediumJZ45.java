package com.hou.offer;

import java.util.TreeSet;

/**
 * @author ：hc
 * @date ：Created in 2021/1/14 17:32
 * @modified By：
 */
public class MediumJZ45 {

    /**
     * 扑克牌顺子
     * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
     * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
     * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
     * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
     * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
     * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
     * input：[0,3,2,6,4]
     * output：true
     *
     * 先去重，有重复不能组成顺子，0不放进去，计数0
     * 遍历treeSet
     * 相邻元素，注意有4个0，所以两张牌之间可以差5个（1 6 0 0 0 0   -> 1 2 3 4 5 6）
     * 如果大于5，直接false
     * 相差5，需要4个0
     * 相差4，需要3个0
     * 相差3，需要2个0
     * 相差2，需要1个0
     * 相差1，没事
     * 可以发现，相差n个需要n-1个0
     */

    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        // 先去重
        TreeSet<Integer> set = new TreeSet<>();
        int kingNum = 0;
        for (int element : numbers) {
            if (element < 0) {
                // 数组输入有误，返回false
                return false;
            } else if (element == 0) {
                // 遇到0，就计数
                kingNum++;
            } else if (!set.add(element)) {
                // 有重复不能组成顺子，false
                return false;
            }
        }
        System.out.println(set);
        // 遍历set
        int pre = 0;
        for (int element : set) {
            if (pre == 0) {
                pre = element;
            } else if (Math.abs(pre - element) > 5) {
                // 相差大于5免谈
                return false;
            } else {
                // 其他情况需要n-1个0来抵
                kingNum -= Math.abs(pre - element) - 1;
            }
            // 判断完成后更新pre
            pre = element;
        }
        // 循环到最后0不够用就false，够用就true
        // 0的个数可以大于0，因为0可以作为任何数，如果是有序的那么补头和尾都行
        return kingNum >= 0;
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{1,3,2,5,4};
        MediumJZ45 mediumJZ45 = new MediumJZ45();
        mediumJZ45.isContinuous(numbers);
    }
}
