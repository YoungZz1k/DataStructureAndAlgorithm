package com.YoungZz1k.LeetCode.General.String;

import java.util.Stack;

/**
 * 反转字符串中的单词[mid]
 */
public class LeetCode151 {

    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * 示例 1：
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * 示例 2：
     * 输入：s = "  hello world  "
     * 输出："world hello"
     * 解释：反转后的字符串中不能存在前导空格和尾随空格。
     * 示例 3：
     * 输入：s = "a good   examplea"
     * 输出："example good a"
     * 解释：如果两个单词间有多余的空格，反转后的字符串需要将单词间的空格减少到仅有一个。
     * 提示：
     * 1 <= s.length <= 104
     * s 包含英文大小写字母、数字和空格 ' '
     * s 中 至少存在一个 单词
     */
    public String reverseWords(String s) {
        char[] array = s.toCharArray();
        int left = 0;
        int right;
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();// 拼接单词
        while (left < array.length ) {
            right = left;
            if (array[left] ==' '){
                left++;
                continue;
            }
            while (right < array.length && array[right] != ' '  ) {
                sb.append(array[right]);
                right++;
            }
            stack.push(sb.toString());
            sb = new StringBuilder();
            left += right - left;
        }

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            // 取元素
            String str = stack.pop();
            res.append(str);
            if (!stack.isEmpty()){
                res.append(" ");
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        LeetCode151 leetCode151 = new LeetCode151();
        System.out.println(leetCode151.reverseWords("the sky is blue"));
        System.out.println(leetCode151.reverseWords("  hello world  "));
        System.out.println(leetCode151.reverseWords("a good   examplea"));
    }
}
