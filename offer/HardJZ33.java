package com.hou.offer;

import java.util.TreeSet;

/**
 * @author ：hc
 * @date ：Created in 2021/1/11 14:19
 * @modified By：
 */
public class HardJZ33 {
    /**
     * 丑数
     * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
     * 例如6、8都是丑数，但14不是，因为它包含质因子7。
     * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
     * 无脑按照题意要求做的话：
     * 如果一个数能对2取余为0，就一直除以2，同样对于3和5，最后为1了，就证明是丑数
     * 很顺利的超时了，太复杂了
     */
    public int GetUglyNumber_Solution(int index) {
        int number = 1;
        int count = 0;
        while (true) {
            // 判断是否是丑数，若是 count++
            if (judge(number)) {
                count++;
            }
            if (count == index) {
                return number;
            }
            number++;
        }
    }

    boolean judge(int number) {
        while (number%2 == 0) {
            number /= 2;
        }
        while (number%3 == 0) {
            number /= 3;
        }
        while (number%5 == 0) {
            number /= 5;
        }
        return number == 1;
    }


    /**
     * 有没有其他办法呢？
     * 后面的丑数是以前面的数为基础的，比如8 就是 4*2，8通过4这个丑数乘以2得到
     * 比如9 通过 3*3 三这个丑数*3得到
     * 比如 5 通过1 这个丑数乘以5得到
     * 类似我们一边运行一边计算后面的丑数
     * 1 可以 *2 *3 *5 得到 2 3 5
     * 2 可以 *2 *3 *5 得到 4 6 10
     * 3 可以 *2 *3 *5 得到 6 9 15
     * ...
     * 关键在于如何一边乘一边排序，把丑数放到对应位置上
     * 可以找三个位置 p2, p3, p5
     * 每次放三个位置乘2，乘3，乘5这三个中最小的数
     * 然后看最小的是谁，谁就++，走向下一个位置
     * 然后给对应位置赋值代表这个是第i个丑数，一直循环到n
     */
    public int GetUglyNumber_Solution1(int index) {
        if (index <= 0) {
            return 0;
        }
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        int[] res = new int[index];
        res[0] = 1;
        for (int i=1; i<index; i++) {
            res[i] = Math.min(res[p2]*2, Math.min(res[p3]*3, res[p5]*5));
            // 看看哪个位置成功赋值了就位置++
            if (res[i] == res[p2]*2) {
                p2++;
            }
            if (res[i] == res[p3]*3) {
                p3++;
            }
            if (res[i] == res[p5]*5) {
                p5++;
            }
        }
        // 因为第1个丑数是res[0]，所以自然第index个丑数就是res[index-1]
        return res[index-1];
    }

    public static void main(String[] args) {
        HardJZ33 hardJZ33 = new HardJZ33();
        TreeSet<Integer> integers = new TreeSet<>();
        integers.add(6);
        integers.add(1);
        if (integers.add(1)) {
            System.out.println("成功放入！");
        }
        integers.add(1);
        integers.add(2);
        integers.add(3);
        System.out.println(integers.last());
        for (int i : integers) {
            System.out.println(i);
        }
    }
}
