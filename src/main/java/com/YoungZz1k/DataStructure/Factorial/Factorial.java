package com.YoungZz1k.DataStructure.Factorial;

/**
 * 递归
 */
public class Factorial {


    /**
     * 阶乘
     *
     * @param n
     * @return
     */
    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        return n * f(n - 1);
    }

    /**
     * 逆序输出字符串
     */
    public static void ReversePrintString(int n, String str) {
        if (n == str.length()) {
            return;
        }
        ReversePrintString(n + 1, str);
        System.out.println(str.charAt(n));
    }

    /**
     * 递归二分查找
     *
     * @return
     */
    public static int search(int[] a, int target, int i, int j) {
        if (i > j) {
            return -1;
        }
        int m = (i + j) >>> 1;
        if (target < a[m]) {
            search(a, target, i, m - 1);
        } else if (a[m] < target) {
            search(a, target, m + 1, j);
        } else {
            return m;
        }
        return -1;
    }

    /**
     * 递归冒泡排序
     *
     * @param a
     * @Param j 未排序的右边界
     */
    public static void bubbleSort(int[] a, int j) {
        if (j == 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < j; i++) {
            if (a[i] > a[i + 1]) {
                int t = a[i];
                a[i] = a[i + 1];
                a[i + 1] = t;
                // x记录发生交换的位置  若一直为0  则都已排好序 然后将x作为未排序的边界传入
                x = i;
            }
        }
        bubbleSort(a, x);
    }

    /**
     * 递归插入排序
     */
    public static void insertionSort(int[] a, int low) {
        if (low == a.length) {
            return;
        }
        int t = a[low];
        int i = low - 1;// 已排序区域右边界
        while (i >= 0 && a[i] > t) { // 未找到插入位置
            a[i + 1] = a[i];// 空出插入位置
            i--;
        }
        // 已找到插入位置
        if (i + 1 != low) {
            a[i + 1] = t;
        }
        insertionSort(a, low + 1);
    }

    /**
     * 斐波那契数列 多路递归
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci( n - 2);
    }
}
