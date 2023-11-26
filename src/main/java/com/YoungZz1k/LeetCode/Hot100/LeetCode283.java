package com.YoungZz1k.LeetCode.Hot100;

import java.util.Arrays;

/**
 * 移动0
 */
public class LeetCode283 {
    //                j
    //                i
    // nums = [1,3,12,0,0]
    // 自己写的
    public static void moveZeroes(int[] nums) {
        int i = -1;// 从头部开始
        int j = 0;//
        while ((i++ != nums.length)){
            if (i == nums.length){
                break;
            }
            if (nums[i] == 0){
                j = i;
                while (true){
                    // 找到第一个不为0的 交换位置
                    if (j == nums.length){
                        break;
                    }
                    if (nums[j] == 0){
                        j++;
                        continue;
                    }
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                    break;
                }
            }
        }
    }

    // 力扣官解
    public static void moveZeroes1(int[] nums) {
        int i = 0;// 从头部开始
        int j = 0;//
        while (j < nums.length){
            if (nums[j] != 0){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
            }
            j++;
        }
    }

        public static void main (String[]args){
            int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {1};
            moveZeroes(nums);
            System.out.println(Arrays.toString(nums));// [1,3,12,0,0]
        }

}