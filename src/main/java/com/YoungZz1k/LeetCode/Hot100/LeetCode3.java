package com.YoungZz1k.LeetCode.Hot100;

import java.util.*;

/**
 * 无重复字串的最长子串
 */
public class LeetCode3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                // 不重复 一直加入 right++
                set.add(s.charAt(right));
                right++;
            } else {
                // 重复 删除left位置的元素
                set.remove(s.charAt(left));
                left++;
            }
            // 一直更新max的值
            max = Math.max(max,set.size());
        }
        return max;
    }

    public static void main(String[] args) {
        LeetCode3 leetCode3 = new LeetCode3();
        System.out.println(leetCode3.lengthOfLongestSubstring("abcabcbb"));
    }
}
