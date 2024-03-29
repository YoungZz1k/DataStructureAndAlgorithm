package com.YoungZz1k.LeetCode.General.String;

/**
 * 压缩字符串[mid]
 */
public class LeetCode443 {
    /**
     * 给你一个字符数组 chars ，请使用下述算法压缩：
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     * 示例 1：
     * 输入：chars = ["a","a","b","b","c","c","c"]
     * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     * 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * 示例 2：
     * 输入：chars = ["a"]
     * 输出：返回 1 ，输入数组的前 1 个字符应该是：["a"]
     * 解释：唯一的组是“a”，它保持未压缩，因为它是一个字符。
     * 示例 3：
     * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]。
     * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
     * 提示：
     * 1 <= chars.length <= 2000
     * chars[i] 可以是小写英文字母、大写英文字母、数字或符号
     */
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        while (left < chars.length) {
            cnt = 0;
            right = left;
            while (right < chars.length && chars[left] == chars[right]  ) { // 移动右指针直到不等于左指针的值
                right++;
                cnt++; // 期间对出现次数进行计数
            }
            //拆分cnt
            if (cnt == 1){
                left++;
                continue;
            }
            char[] cntArr = String.valueOf(cnt).toCharArray();
            left += 1; // 移动到后面1个 准备填充数字
            for (char c : cntArr) {
                chars[left] = c;// 填充数组
                left++;
            }
            while (left < right){
                // 将剩余的字符全部置空
                chars[left] = ' ';
                left++;
            }
            left = right;
        }
        // 空字符后移
        char c;
        int i = 0;
        int j = 0;
        while (i < chars.length){
            while (i < chars.length && chars[i] != ' '){ // 寻找空字符位置
                i++;
            }
            // i 空字符起始位置 [
            // j 空字符结束位置 )
            j = i;
            while (j < chars.length && chars[j] == ' '){ // 寻找空字符后的第一个非空字符
                j++;
            }
            while (j < chars.length && i < j){ // 空字符后移
                while (i < chars.length && chars[i] != ' '){ // 空字符位置可能变动 更新位置
                    i++;
                }
                j = i;
                while (j < chars.length && chars[j] == ' '){
                    j++;
                }
                if (j == chars.length){
                    i++;
                    break;
                }
                c = chars[j];
                chars[j] = chars[i];
                chars[i] = c;
                j++;
                i++;
            }
            i++;
        }
        // 统计非空字符返回
        int count = 0;
        for (char aChar : chars) {
            if (aChar != ' '){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        LeetCode443 leetCode443 = new LeetCode443();
        System.out.println(leetCode443.compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(leetCode443.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(leetCode443.compress(new char[]{'a','a','a','b','b','b','c','c','c'}));
    }
}
