package com.YoungZz1k.LeetCode.Hot100;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 字符串解码
 */
public class LeetCode394 {
    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * 示例 1：
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     */
    public String decodeString(String s) {
        // 双栈
        Deque<Integer> numberStack = new ArrayDeque<>();// 存放数字
        Deque<StringBuilder> stringDeque = new ArrayDeque<>();// 存放字符串
        StringBuilder sb = new StringBuilder();// 临时字符串
        int i = 0;
        int tNum = 0; // 可能遇到的数字
        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch == '[') { // 遇到[就入栈 次数和临时字符串
                numberStack.push(tNum);
                stringDeque.push(sb);
                sb = new StringBuilder();
                tNum = 0;
            } else if (ch == ']') { // 遇到]就出栈 取出字符串并根据次数追加临时字符串
                StringBuilder pop = stringDeque.pop();
                Integer count = numberStack.pop();
                for (int j = 0; j < count; j++) {
                    pop.append(sb.toString());
                }
                sb = pop;
            } else if (ch >= '0' && ch <= '9') {
                tNum = tNum * 10 + ch - '0'; // 有可能不是个位100[iop]
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode394 leetCode394 = new LeetCode394();
        System.out.println(leetCode394.decodeString("3[a]2[bc]"));
        System.out.println(leetCode394.decodeString("3[a2[c]]"));
        System.out.println(leetCode394.decodeString("2[abc]3[cd]ef"));
        System.out.println(leetCode394.decodeString("abc3[cd]xyz"));
    }
}
