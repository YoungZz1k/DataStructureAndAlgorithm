package com.YoungZz1k.LeetCode.General.String;

import java.math.BigInteger;

/**
 * 字符串相乘[mid]
 */
public class LeetCode43 {

    /**
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
     * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
     * 示例 1:
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 提示：
     * 1 <= num1.length, num2.length <= 200
     * num1 和 num2 只能由数字组成。
     * num1 和 num2 都不包含任何前导零，除了数字0本身。
     */
    public String multiply(String num1, String num2) { // 123
        if (num1.equals("0") || num2.equals("0")) {  // * 456
            return "0";                             //    res
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位和 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;// 进位
            // 保存 num2 第i位数字与 num1 相乘的结果  6*123
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘 3*6 2*6 1*6
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10; // 更新进位
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0; // 进位
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0;
             i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10; // 更新进位
        }
        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        LeetCode43 leetCode43 = new LeetCode43();
        System.out.println(leetCode43.multiply("123", "456"));
        System.out.println(leetCode43.multiply("2", "3"));
        System.out.println(leetCode43.multiply("498828660196", "840477629533"));
    }
}
