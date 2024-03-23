package com.YoungZz1k.LeetCode.BinarySearch;

/**
 * x的平方根[simple]
 */
public class LeetCode69 {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     * 提示：
     * 0 <= x <= 231 - 1
     */
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1;
        // 平方根不会大于自身数的一半  以[1,x/2)为区间搜索
        int right = x / 2;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (mid > x / mid) {// mid*mid > x
                right = mid - 1;
            } else if (mid == x / mid) {
                return mid;
            } else {
                left = mid;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        LeetCode69 leetCode69 = new LeetCode69();
        System.out.println(leetCode69.mySqrt(8));
    }
}
