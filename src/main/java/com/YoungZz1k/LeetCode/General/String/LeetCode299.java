package com.YoungZz1k.LeetCode.General.String;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 猜数字游戏[mid]
 */
public class LeetCode299 {

    /**
     * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
     * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
     * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
     * 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
     * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
     * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
     * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
     * 示例 1：
     * 输入：secret = "1807", guess = "7810"
     * 输出："1A3B"
     * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
     * "1807"
     * |
     * "7810"
     * 示例 2：
     * 输入：secret = "1123", guess = "0111"
     * 输出："1A1B"
     * 解释：数字和位置都对（公牛）用 '|' 连接，数字猜对位置不对（奶牛）的采用斜体加粗标识。
     * "1123"        "1123"
     * |      or     |
     * "0111"        "0111"
     * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置不对）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
     * 提示：
     * 1 <= secret.length, guess.length <= 1000
     * secret.length == guess.length
     * secret 和 guess 仅由数字组成
     */

    public String getHint(String secret, String guess) {
        int bulls = 0; // 公牛
        int cows = 0; // 奶牛
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> secMap = new HashMap<>();// 记录数字出现次数
        Map<Character, Integer> gueMap = new HashMap<>();// 记录猜测的数字出现次数
        for (int i = 0; i < secret.length(); i++) { // 记录两个数字出现次数

            int sec = secMap.getOrDefault(secret.charAt(i), 0).intValue();
            sec++;
            secMap.put(secret.charAt(i), sec);

            int gue = gueMap.getOrDefault(guess.charAt(i), 0).intValue();
            gue++;
            gueMap.put(guess.charAt(i), gue);
        }
        for (int i = 0; i < secret.length(); i++) { // 确认公牛数
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            int sec = secMap.getOrDefault(c1, 0).intValue();
            int gue = gueMap.getOrDefault(c2, 0).intValue();
            if (c1 == c2 && sec != 0 && gue != 0) {
                // 公牛+1
                bulls++;
                sec--;
                gue--;
                secMap.put(c1,sec);
                gueMap.put(c2,gue);
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator = secMap.entrySet().iterator();
        while (iterator.hasNext()){ // 确认母牛数
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if (gueMap.containsKey(key)){
                int gue = gueMap.get(key);
                while (gue != 0 && value != 0){
                    cows++;
                    gue--;
                    value--;
                }
                gueMap.put(key,gue);
                gueMap.put(key,value);
                continue;
            }
        }
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        LeetCode299 leetCode299 = new LeetCode299();
        System.out.println(leetCode299.getHint("1807", "7810"));
        System.out.println(leetCode299.getHint("1123", "0111"));
        System.out.println(leetCode299.getHint("1112", "1123"));
        System.out.println(leetCode299.getHint("1122", "2211"));
    }
}
