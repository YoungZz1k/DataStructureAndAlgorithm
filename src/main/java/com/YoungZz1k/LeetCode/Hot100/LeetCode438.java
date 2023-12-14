package com.YoungZz1k.LeetCode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 */
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        //输入: s = "cbaebabacd", p = "abc"
        //输出: [0,6]
        List<Integer> res = new ArrayList<>();
        if (p == null || "".equals(p)) {
            return res;
        }
        // 构建字符出现次数数组
        int[] target = new int[26];
        for (int i = 0; i < p.length(); i++) {
            target[p.charAt(i) - 'a']++;
        }
        // 左右指针
        int left = 0,right = 0;
        // s的字符出现次数
        int[] window = new int[26];
        while (right < s.length()){
            // 把右指针出现的字符次数+1
            window[s.charAt(right) - 'a']++;
            // 如果窗口大小等于p的长度
            if (right - left + 1 == p.length()){
                // 比较两个数组是否相等 相等则字符出现次数相同 加入结果集
                if (Arrays.equals(window,target)) res.add(left);
                // 把left指针字符次数-1
                window[s.charAt(left) - 'a']--;
                left++;
            }
            right ++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        LeetCode438 leetCode438 = new LeetCode438();
        System.out.println(leetCode438.findAnagrams(s, p));
    }
}
