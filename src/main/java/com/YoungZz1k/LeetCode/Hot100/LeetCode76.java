package com.YoungZz1k.LeetCode.Hot100;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最小覆盖子串[hard]
 */
public class LeetCode76 {
    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     * 示例 3:
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     */
    public String minWindow(String s, String t) { // 滑动窗口
        int[] cnt = new int[128];
        for (int i = 0; i < t.length(); i++) // 记录t中字符位置
            cnt[t.charAt(i)]++;
        int l = 0, r = 0, ansL = 0, ansR = 0, ans = Integer.MAX_VALUE, cntT = t.length();
        while (r < s.length()) {
            if (cnt[s.charAt(r++)]-- > 0)
                cntT--;
            while (cntT == 0) { // 当前窗口已经包含子串
                if (r - l < ans) { // 当前窗口小于之前的记录 更新
                    ans = r - l;
                    ansL = l;
                    ansR = r;
                }
                if (cnt[s.charAt(l++)]++ == 0) cntT++; // 移动左边界 判断移动的字符是否在t中 在则+1
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(ansL, ansR);
    }


    // HashMap + 滑动窗口
    public String minWindow1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();// 记录t中各字符出现次数
        int j = 0;
        while (j < t.length()) { // 记录各字符出现次数
            int orDefault = map.getOrDefault(t.charAt(j), 0).intValue();
            orDefault++;
            map.put(t.charAt(j), orDefault);
            j++;
        }
        int i = 0;
        int k = 0;
        int min = Integer.MAX_VALUE;
        int cnt = t.length();
        int key = 0;
        while (k < s.length()) {
            char c = s.charAt(k++);
            if (map.containsKey(c)){
                map.put(c,map.get(c) - 1);
                if (map.get(c) >= 0 ){
                    cnt--;
                }
            }
            while (cnt == 0) { // 当找到子串
                if ((k - i ) < min) { // 更新最小窗口和起始索引
                    min = k - i;
                    key = i;
                }
                char c2 = s.charAt(i++);
                // 移动左边界 判断移动的字符是否在t中 在则+1
                if (map.containsKey(c2)){
                    map.put(c2,map.get(c2) + 1);
                    if (map.get(c2) > 0){
                        cnt++;
                    }
                }
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(key, key + min);
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow1("ADOBECODEBANC", "ABC"));
        System.out.println(leetCode76.minWindow("a", "a"));
        System.out.println(leetCode76.minWindow("a", "aa"));
    }
}
