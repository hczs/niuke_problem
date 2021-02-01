package com.hou.offer;

/**
 * @author ：hc
 * @date ：Created in 2020/12/24 16:53
 * @modified By：
 */
public class EasyJZ51 {
    /**
     * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
     * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
     * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
     * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
     * 输入：[1,2,3,4,5]
     * 输出：[120,60,40,30,24]
     * 一个左数组：left[i] = A[0]*...A[i-1]
     * 一个右数组：right[i] = A[i+1]*...A[n-1]
     * B[i] = left[i] * right[i]
     */
    public int[] multiply(int[] A) {
        // 按照题意做
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];
        if (n <= 1) {
            return res;
        }
        for (int i=0; i<n; i++) {
            left[i] = 1;
            for (int j=0; j<=i-1; j++) {
                left[i] *= A[j];
            }
        }
        for (int i=0; i<n; i++) {
            right[i] = 1;
            for (int j=i+1; j<n; j++) {
                right[i] *= A[j];
            }
        }
        for (int i=0; i<n; i++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }

    /**
     * 仔细一看不就是从前往后乘再从后往前乘
     * 假设 n = 4
     * 0   1    2         3
     * 1 a[0] a[0]*a[1] a[0]*a[1]*a[2]
     * 是否可以把上一步的乘积存储下来，下次利用直接乘a[n-1]
     * b[3] = a[0]*a[1]*a[2] = res[3]     这一步乘完之后要存储A[3]
     * b[2] = a[0]*a[1]*a[3] = res[2]*a[3]   用到上一步存储的A[3]了，这一步要存储A[2]*A[3]
     * b[1] = a[0]*a[2]*a[3] = res[1]*a[2]*a[3] 用到上一步存储的值
     * 从后往前乘也是把上一步的存储下来与之前的结果数组乘
     */
    public int[] multiply1(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int tmp = 1;
        for (int i=0; i<n; i++) {
            res[i] = tmp;
            tmp *= A[i];
        }
        tmp = 1;
        for (int i=n-1; i>=0; i--) {
            res[i] *= tmp;
            tmp *= A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5};
        EasyJZ51 easyJZ51 = new EasyJZ51();
        int[] v = easyJZ51.multiply1(a);
        for (int i : v) {
            System.out.println(i);
        }
    }
}
