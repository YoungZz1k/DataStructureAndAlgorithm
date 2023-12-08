package com.YoungZz1k.LeetCode.Hot100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 */
public class LeetCode43 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 排序后的字母作为key
        HashMap<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            // 转字符数组
            char[] chars = str.toCharArray();
            // 排序
            Arrays.sort(chars);
            // 转字符串
            String key = new String(chars);
            // 取出对应的key  无key则创建新的list
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // 字符串放入list
            list.add(str);
            // 放入map
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
