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

    public String minWindow(String s, String t) {
        Map<String, Integer> map = new HashMap<>();// 记录t中各字符出现次数
        Map<Integer, Integer> minMap = new HashMap<>(); // 记录s中覆盖t的字串的长度
        int j = 0;
        while (j < t.length()) { // 记录各字符出现次数
            Integer orDefault = map.getOrDefault(String.valueOf(t.charAt(j)), 0);
            orDefault++;
            map.put(String.valueOf(t.charAt(j)), orDefault);
            j++;
        }
        int left = 0;
        int right = 0;
        int min = Integer.MAX_VALUE;
        int key = 0;
        while (right < s.length()){
            
        }
//        while (i < s.length()) { // 遍历
//            k = i;
//            Map<String, Integer> temp = new HashMap<>(map);
//            while (k < s.length()) {
//                Integer integer = minMap.get(key);
//                if (integer != null && integer < (k - i)){
//                    break;
//                }
//                String s1 = String.valueOf(s.charAt(k));
//                Integer orDefault = temp.getOrDefault(s1, 0);
//                if (orDefault == 0) {
//                    k++;
//                    continue;
//                } else {
//                    orDefault--;
//                    temp.put(s1, orDefault);
//                    boolean flag = false;
//                    if (temp.values().stream().allMatch(item -> item == 0)) {
//                        flag = true;
//                    }
//                    if (flag) {
//                        minMap.put(i, k - i);
//                        if (min > (k - i)){ // 更新最小覆盖索引
//                            min = k - i;
//                            key = i;
//                        }
//                        break;
//                    }
//                }
//                k++;
//            }
//            i++;
//        }

        if (minMap.isEmpty()) {
            return "";
        }

        return s.substring(key, key + min + 1);
    }

    // 时间复杂度： O(n2)
    public String minWindow1(String s, String t) {
        Map<String, Integer> map = new HashMap<>();// 记录t中各字符出现次数
        Map<Integer, Integer> minMap = new HashMap<>(); // 记录s中覆盖t的字串的长度
        int j = 0;
        while (j < t.length()) { // 记录各字符出现次数
            Integer orDefault = map.getOrDefault(String.valueOf(t.charAt(j)), 0);
            orDefault++;
            map.put(String.valueOf(t.charAt(j)), orDefault);
            j++;
        }
        int i = 0;
        int k = 0;
        int min = Integer.MAX_VALUE;
        int key = 0;
        while (i < s.length()) { // 遍历
            k = i;
            Map<String, Integer> temp = new HashMap<>(map);
            while (k < s.length()) {
                Integer integer = minMap.get(key);
                if (integer != null && integer < (k - i)){
                    break;
                }
                String s1 = String.valueOf(s.charAt(k));
                Integer orDefault = temp.getOrDefault(s1, 0);
                if (orDefault == 0) {
                    k++;
                    continue;
                } else {
                    orDefault--;
                    temp.put(s1, orDefault);
                    boolean flag = false;
                    if (temp.values().stream().allMatch(item -> item == 0)) {
                        flag = true;
                    }
                    if (flag) {
                        minMap.put(i, k - i);
                        if (min > (k - i)){ // 更新最小覆盖索引
                            min = k - i;
                            key = i;
                        }
                        break;
                    }
                }
                k++;
            }
            i++;
        }

        if (minMap.isEmpty()) {
            return "";
        }

        return s.substring(key, key + min + 1);
    }

    public static void main(String[] args) {
        LeetCode76 leetCode76 = new LeetCode76();
        System.out.println(leetCode76.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(leetCode76.minWindow("a", "a"));
        System.out.println(leetCode76.minWindow("a", "aa"));
    }
}
