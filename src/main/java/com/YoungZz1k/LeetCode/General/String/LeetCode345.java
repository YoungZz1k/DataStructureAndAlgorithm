package com.YoungZz1k.LeetCode.General.String;



/**
 * 反转字符串中的元音字母[simple]
 */
public class LeetCode345 {
    /**
     * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
     * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
     * 示例 1：
     * 输入：s = "hello"
     * 输出："holle"
     * 示例 2：
     * 输入：s = "leetcode"
     * 输出："leotcede"
     * 提示：
     * 1 <= s.length <= 3 * 105
     * s 由 可打印的 ASCII 字符组成
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        char c;
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            while (!(chars[left] == 'a' || chars[left] == 'e' || chars[left] == 'i' || chars[left] == 'o' || chars[left] == 'u'
                    || chars[left] == 'A' || chars[left] == 'E' || chars[left] == 'I' || chars[left] == 'O' || chars[left] == 'U') && left < right) { // 没碰到元音字母直接跳过
                left++;
            }
            while (!(chars[right] == 'a' || chars[right] == 'e' || chars[right] == 'i' || chars[right] == 'o' || chars[right] == 'u'
                    || chars[right] == 'A' || chars[right] == 'E' || chars[right] == 'I' || chars[right] == 'O' || chars[right] == 'U') && left < right) {
                right--;
            }
            c = chars[left]; // 交换元素
            chars[left] = chars[right];
            chars[right] = c;
            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode345 leetCode345 = new LeetCode345();
        System.out.println(leetCode345.reverseVowels("leetcode"));
        System.out.println(leetCode345.reverseVowels("hello"));
    }

}
