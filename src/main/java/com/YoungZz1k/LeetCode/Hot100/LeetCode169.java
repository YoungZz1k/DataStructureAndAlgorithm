package com.YoungZz1k.LeetCode.Hot100;

import java.util.HashMap;

/**
 * 多数元素
 */
public class LeetCode169 {
    // 常规哈希表
    public int majorityElement1(int[] nums) {
        if (nums.length == 0 ){
            return 0;
        }
        int len = nums.length;
        float n = len / 2f;
        int res = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num,count);
            if (count > n){
                res = num;
            }
        }
        return res;
    }

    // 摩尔投票法
    public int majorityElement(int[] nums) {
        int x = 0, votes = 0;
        for (int num : nums){
            // vote == 0 假定x为众数
            if (votes == 0) x = num;
            // num == x votes自增1 否则自减1
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        LeetCode169 leetCode169 = new LeetCode169();
        System.out.println(leetCode169.majorityElement1(nums));
    }
}
