package com.YoungZz1k.LeetCode.Hot100;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 缺失的第一个正数[hard]
 */
public class LeetCode41 {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * 示例 1：
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 示例 3：
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     */
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return 2;
            } else {
                return 1;
            }
        }
        Arrays.sort(nums);
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                map.put("min", 1);// 如果有1 设置值为1
            }
        }
        if (map.getOrDefault("min", 0) == 0) {
            return 1;
        } else {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= 0) {
                    continue;
                }
                // 此处说明存在1
                Integer minValue = map.get("min"); //   -1,1,2, 3, 5,
                if (minValue == nums[i]) {
                    continue;
                } else { // 1之后的
                    // 查看当前值是否是上一次出现的最小值+1
                    // 是则更新lastMin
                    Integer lastMin = map.getOrDefault("lastMin", 1);
                    if (lastMin + 1 == nums[i]) {
                        // 更新lastMin
                        map.put("lastMin", nums[i]);
                    }
                    map.put("max", nums[i]);// 存放已出现的最大值
                }
            }
            Integer lastMin = map.getOrDefault("lastMin",1);
            Integer min = map.get("min");
            Integer max = map.getOrDefault("max",nums[nums.length-1]);
            if (max - lastMin >= 2) {
                return lastMin + 1;
            } else {
                return max + 1;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode41 leetCode41 = new LeetCode41();
        System.out.println(leetCode41.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(leetCode41.firstMissingPositive(new int[]{1,0}));
        System.out.println(leetCode41.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(leetCode41.firstMissingPositive(new int[]{2, 3, 5, -1, 1}));
        System.out.println(leetCode41.firstMissingPositive(new int[]{2, 4, 5, -1, 1}));
    }
}
