package com.YoungZz1k.LeetCode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 最大子数组和
 */
public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if (nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        //输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        //输出：6
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < len; i++) {
            // sum > 0 说明对和有增大的趋势 进行累加
            if (sum > 0){
                sum+=nums[i];
            }else{
                // 小于0 将和更新为当前值
                sum = nums[i];
            }
            max = Math.max(sum,max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        LeetCode53 leetCode53 = new LeetCode53();
        System.out.println(leetCode53.maxSubArray(nums));
    }
}
