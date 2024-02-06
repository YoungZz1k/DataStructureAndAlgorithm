package com.YoungZz1k.LeetCode.General.String;

import java.util.Arrays;

/**
 * 最长公共前缀[simple]
 */
public class LeetCode14 {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * 如果不存在公共前缀，返回空字符串 ""。
     * 示例 1：
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     */

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        StringBuilder sb = new StringBuilder("");
        int index = 0;
        char[] chars = new char[strs.length];
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length()){
                    return sb.toString();
                }
                chars[i] = strs[i].charAt(index);// 存储每个字符串某个字符
            }
            boolean flag = true;
            for (int i = 1; i <= chars.length - 1; i++) { // 比较字符是否全部相等
                if (chars[0] != chars[i]){
                    flag = false;
                }
            }
            if (flag) {// 相等追加到sb中 index++比较下一个字符
                sb.append(chars[0]);
                index++;
            }else{ // 不等直接返回
                return sb.toString();
            }
        }
    }

    public static void main(String[] args) {
        LeetCode14 leetCode14 = new LeetCode14();
        System.out.println(leetCode14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(leetCode14.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(leetCode14.longestCommonPrefix(new String[]{"reflower","flow","flight"}));
        System.out.println(leetCode14.longestCommonPrefix(new String[]{"flower","flower","flower","flower"}));
    }
}
