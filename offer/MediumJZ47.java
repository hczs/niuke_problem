package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2020/11/17 17:26
 * @modified By：
 */
public class MediumJZ47 {

    /**
     * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
     */

    public int Sum_Solution(int n) {
        // 主要就是卡条件，当n>1的时候就需要执行后面的式子，递归求和
        // 一直递归下去，当n不大于1的时候就该结束了，因为&&，前面是false，后面就不再执行
        // 利用&&的这个特性卡这个条件
        boolean s = (n > 1) && ( n += Sum_Solution(n-1)) > 0;
        return n;
    }

//    public int Sum_Solution(int n) {
//        if (n == 1) return n;
//        return n+Sum_Solution(n-1);
//    }
}
