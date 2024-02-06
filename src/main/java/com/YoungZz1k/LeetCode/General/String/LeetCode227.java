package com.YoungZz1k.LeetCode.General.String;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 基本计算器Ⅱ[mid]
 */
public class LeetCode227 {
    /**
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 整数除法仅保留整数部分。
     * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
     * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
     * 示例 1：
     * 输入：s = "3+2*2"
     * 输出：7
     * 示例 2：
     * 输入：s = " 3/2 "
     * 输出：1
     * 示例 3：
     * 输入：s = " 3+5 / 2 "
     * 输出：5
     * 提示：
     * 1 <= s.length <= 3 * 105
     * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     * s 表示一个 有效表达式
     * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
     * 题目数据保证答案是一个 32-bit 整数
     */
    public int calculate(String s) {
        // 保存上一个符号，初始为 +
        char sign = '+';
        Deque<Integer> numStack = new ArrayDeque<>();
        // 保存当前数字，如：12是两个字符，需要进位累加
        int num = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur >= '0') {
                // 记录当前数字。先减，防溢出
                num = num * 10 - '0' + cur;
            }
            if ((cur < '0' && cur != ' ') || i == s.length() - 1) {
                // 判断上一个符号是什么
                switch (sign) {
                    // 当前符号前的数字直接压栈
                    case '+':
                        numStack.push(num);
                        break;
                    // 当前符号前的数字取反压栈
                    case '-':
                        numStack.push(-num);
                        break;
                    // 数字栈栈顶数字出栈，与当前符号前的数字相乘，结果值压栈
                    case '*':
                        numStack.push(numStack.pop() * num);
                        break;
                    // 数字栈栈顶数字出栈，除于当前符号前的数字，结果值压栈
                    case '/':
                        numStack.push(numStack.pop() / num);
                        break;
                }
                // 记录当前符号
                sign = cur;
                // 数字清零
                num = 0;
            }
        }
        // 将栈内剩余数字累加，即为结果
        while (!numStack.isEmpty()) {
            result += numStack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode227 leetCode227 = new LeetCode227();
        System.out.println(leetCode227.calculate("3+2*2"));
        System.out.println(leetCode227.calculate("3/2"));
        System.out.println(leetCode227.calculate("3+5/2"));
        System.out.println(leetCode227.calculate("222+15/3*5-2"));
    }
}
