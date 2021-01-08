package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2021/1/8 15:29
 * @modified By：
 */

public class HardJZ44 {

    /**
     * 翻转单词顺序序列
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
     * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
     * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     * input："nowcoder. a am I"
     * output："I am a nowcoder."
     * 解法很简单：一眼就能有思路，就是根据空格分割，然后倒序输出到另一个数组中返回
     * 提交两次都错了，第一次是没考虑每个单词之后应该加空格
     * 第二次是没考虑"   "这种全空格的输入情况
     * 面向测试编程........
     */

    public String ReverseSentence(String str) {
        String[] words = str.split(" ");
        // 如果输入"      "，分割完之后的数组是没有数据的，返回本身
        if (words.length == 0) {
            return str;
        }
        StringBuilder res = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            if (i==0) {
                res.append(words[i]);
            } else {
                res.append(words[i]);
                res.append(" ");
            }
        }
        return res.toString();
    }
}
