package com.YoungZz1k.LeetCode.Hot100;

import java.util.HashMap;
import java.util.Map;

/**
 * 和为k的子数组
 */
public class LeetCode560 {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * 子数组是数组中元素的连续非空序列。
     * 示例 1：
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     */
    public int subarraySum(int[] nums, int k) { // 暴力
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }
        return count;
    }

    public int subarraySum1(int[] nums, int k) { // map + 前缀和优化
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        int count = 0;
        int prefixSum = 0; // 前缀和

        for (int num : nums) {
            prefixSum += num;
            if (prefixSumCount.containsKey(prefixSum - k)) { // 是否存在prefixSum - k 的前缀和 有则累加到count
                count += prefixSumCount.get(prefixSum - k);
            }
            prefixSumCount.put(prefixSum, prefixSumCount.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }


    public static void main(String[] args) {
        LeetCode560 leetCode560 = new LeetCode560();
        System.out.println(leetCode560.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(leetCode560.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(leetCode560.subarraySum(new int[]{-1, 1, 0}, 0));
        System.out.println(leetCode560.subarraySum(new int[]{0,0}, 0));
    }
}
