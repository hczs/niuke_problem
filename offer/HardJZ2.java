package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2020/12/28 14:13
 * @modified By：
 */
public class HardJZ2 {
    /**
     * 替换空格
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }

    /**
     * 使用StringBuilder，扫描str，遇到空格append %20
     */
    public String replaceSpace1(StringBuffer str) {
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                builder.append("%20");
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
