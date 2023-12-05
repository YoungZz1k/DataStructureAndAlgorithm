package com.YoungZz1k.LeetCode.Hot100;

import java.util.Arrays;

/**
 * 两数之和
 */
public class LeetCode1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] t = new int[2];
        for (int i = 0; i + 1 < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if ((nums[i] + nums[j] )== target){
                    t[0] = i;
                    t[1] = j;
                }
            }
        }
        return t;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }
}
