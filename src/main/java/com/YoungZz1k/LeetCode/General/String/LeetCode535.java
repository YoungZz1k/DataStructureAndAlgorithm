package com.YoungZz1k.LeetCode.General.String;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

/**
 * TinyURL的加密与解密[mid]
 */
public class LeetCode535 {
    /**
     *TinyURL 是一种 URL 简化服务， 比如：当你输入一个 URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk 。请你设计一个类来加密与解密 TinyURL 。
     * 加密和解密算法如何设计和运作是没有限制的，你只需要保证一个 URL 可以被加密成一个 TinyURL ，并且这个 TinyURL 可以用解密方法恢复成原本的 URL 。
     * 实现 Solution 类：
     * Solution() 初始化 TinyURL 系统对象。
     * String encode(String longUrl) 返回 longUrl 对应的 TinyURL 。
     * String decode(String shortUrl) 返回 shortUrl 原本的 URL 。题目数据保证给定的 shortUrl 是由同一个系统对象加密的。
     * 示例：
     * 输入：url = "https://leetcode.com/problems/design-tinyurl"
     * 输出："https://leetcode.com/problems/design-tinyurl"
     * 解释：
     * Solution obj = new Solution();
     * string tiny = obj.encode(url); // 返回加密后得到的 TinyURL 。
     * string ans = obj.decode(tiny); // 返回解密后得到的原本的 URL 。
     * 提示：
     * 1 <= url.length <= 104
     * 题目数据保证 url 是一个有效的 URL
     */

    String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Map<String,String> map = new HashMap<>();

    public String encode(String longUrl) {
        String uid = UUID.randomUUID().toString().replace("-", "");
        StringBuilder code = new StringBuilder("");
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            code.append(s.charAt(random.nextInt(62)));
        }
        uid = uid.substring(0,3) + code;
        map.put(uid,longUrl);
        return "http://tinyurl.com/" + uid;
    }

    public String decode(String shortUrl) {
        String s = shortUrl.substring(shortUrl.length() - 6);
        return map.get(s);
    }

    public static void main(String[] args) {
        LeetCode535 leetCode535 = new LeetCode535();
        System.out.println(leetCode535.decode(leetCode535.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
