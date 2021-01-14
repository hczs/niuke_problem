package com.hou.offer;


import java.util.ArrayList;

/**
 * @author ：hc
 * @date ：Created in 2021/1/14 16:23
 * @modified By：
 */
public class MediumJZ41 {
    /**
     * 和为S的连续正数序列
     * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
     * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
     * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
     * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
     *
     * 这个就按照题意来做
     * 但是途中也出现了点点小问题
     * 集合装另一个集合的时候，类似于装的一个指针，指向了具体对象
     * 所以我必须每次都要new一个son
     * 如果不new的话，再对son进行操作，大集合中的son会随之改变，所以每次都得创建新对象
     * 才疏学浅了
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 从3开始才有子序列的
        if (sum <= 2) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> son = new ArrayList<>();
        int tmp;
        for (int i=1; i<sum ; i++) {
            tmp = 0;
            son = new ArrayList<>();
            for (int j=i; j<sum ; j++) {
                tmp += j;
                son.add(j);
                if (tmp == sum) {
                    result.add(son);
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MediumJZ41 mediumJZ41 = new MediumJZ41();
        ArrayList<ArrayList<Integer>> arrayLists = mediumJZ41.FindContinuousSequence(3);
        System.out.println(arrayLists);
//        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
//        ArrayList<Integer> son = new ArrayList<>();
//        son.add(1);
//        son.add(2);
//        for (int i=0; i<10; i++) {
//            son.add(i);
//            if (i == 3) {
//                arrayLists.add(son);
//                son.clear();
//                break;
//            }
//        }
//        System.out.println(arrayLists);
    }
}
