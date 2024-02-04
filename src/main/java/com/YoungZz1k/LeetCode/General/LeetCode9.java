package com.YoungZz1k.LeetCode.General;

/**
 * 回文数
 */
public class LeetCode9 {
    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 例如，121 是回文，而 123 不是。
     * 示例 1：
     * 输入：x = 121
     * 输出：true
     * 示例 2：
     * 输入：x = -121
     * 输出：false
     * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3：
     * 输入：x = 10
     * 输出：false
     * 解释：从右向左读, 为 01 。因此它不是一个回文数。
     */
    public boolean isPalindrome(int x) {// 转字符串做法
        String s = String.valueOf(x);

        StringBuilder s1 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            s1.append(s.charAt(i));
        }

        return s1.toString().equals(s);
    }

    //  将数字反过来计算比较是否和原数字相等
    public boolean isPalindrome1(int x) {
        // 121
        if (x < 0){
            return false;
        }
        int cur = 0;
        int num = x;
        while (num != 0){
            cur = num % 10 + cur*10;
            num/=10;
        }
        return cur == x;
    }


    public static void main(String[] args) {
        int a = 121;
        LeetCode9 leetCode9 = new LeetCode9();
        System.out.println(leetCode9.isPalindrome1(a));
    }
}
