package com.YoungZz1k.LeetCode.Interview150;

/**
 * 判断子序列
 */
public class LeetCode392 {
    //                  s: "abc"  t: "ahbgdc"
    public static boolean isSubsequence(String s, String t) {
        // 子串s 是否在t中
        //    j      i
        if (s == null || t == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        if (s.length() > 0 && t.length() == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        int count = 0;
        while (true) {
            if (s.charAt(i) == t.charAt(j)) {
                // 匹配到一位后 子串指针后移继续寻找
                i++;
                j++;
                count++;
            } else {
                j++;
            }
            if (count == s.length()) {
                return true;
            }
            if (j == t.length()) {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }
}
