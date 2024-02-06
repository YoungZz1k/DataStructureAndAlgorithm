package com.YoungZz1k.LeetCode.General.String;

import java.util.*;

/**
 * 电话号码的字母组合[mid]
 */
public class LeetCode17 {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。示例 1：
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();
        int index = 0;
        backtrack(res, map, digits, "", 0);
        return res;
    }
    //  回溯
    private void backtrack(List<String> result, Map<Character, String> phoneMap, String digits, String combination, int index) {
        if (index == digits.length()) {
            result.add(combination);
        } else {
            char digit = digits.charAt(index);// 2
            String letters = phoneMap.get(digit);// "abc"
            for (int i = 0; i < letters.length(); i++) { // 递归调用 ===> (res,map,digits,"",0)a ===> (res,map,digits,"a",1)d ===> ad
                backtrack(result, phoneMap, digits, combination + letters.charAt(i), index + 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode17 leetCode17 = new LeetCode17();
        System.out.println(leetCode17.letterCombinations("2345"));
        System.out.println(leetCode17.letterCombinations("23"));
        System.out.println(leetCode17.letterCombinations("234"));
        System.out.println(leetCode17.letterCombinations("2"));
    }
}
