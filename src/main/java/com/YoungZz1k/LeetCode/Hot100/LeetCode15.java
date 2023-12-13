package com.YoungZz1k.LeetCode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 */
public class LeetCode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        // 输入：nums = [-1,0,1,2,-1,-4]
        // 输出：[[-1,-1,2],[-1,0,1]]
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果遍历的起始元素都大于0 后面肯定都大于0 退出
            if (nums[i] > 0) {
                break;
            }
            // 去重 当前后两个值相同 得到的结果集会相同 跳过此次
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                // 相加等于0
                if (sum == 0) {
                    // 加入结果集
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 去重 i不变 前后两个值相同 得到的结果集会相同 跳过
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // 去重 i不变 前后两个值相同 得到的结果集会相同 跳过
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    // 双指针移动
                    left++;
                    right--;
                } else if (sum < 0) {
                    // 相加小于0 left向右移动
                    left++;
                } else {
                    // 大于0 right向左移动
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode15 leetCode15 = new LeetCode15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(leetCode15.threeSum(nums));
    }
}
