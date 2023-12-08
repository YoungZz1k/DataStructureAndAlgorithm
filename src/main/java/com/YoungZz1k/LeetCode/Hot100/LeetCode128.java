package com.YoungZz1k.LeetCode.Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最长连续序列
 */
public class LeetCode128 {
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        // 对数组进行排序
        Arrays.sort(nums);
        // 进行遍历
        List<Integer> max = new ArrayList<>();
        int count = 1;
        for (int i = 0; i + 1 < nums.length; i++) {
            if (nums[i] == nums[i + 1]){
                max.add(count);
                continue;
            }
            if (nums[i] + 1 == nums[i + 1]){
                count++;
            }else {
                count = 1;
            }
            max.add(count);
        }
        int m = max.get(0);
        for (Integer integer : max) {
            if (m < integer){
                m = integer;
            }
        }
        return m;
    }

    public static void main(String[] args) {
//        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        int[] nums = {0,0};
        System.out.println(longestConsecutive(nums));
    }
}
