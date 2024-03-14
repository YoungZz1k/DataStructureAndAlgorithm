package com.YoungZz1k.LeetCode.BinarySearch;

import java.util.ArrayList;

/**
 * 搜索插入位置[simple]
 */
public class LeetCode35 {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 请必须使用时间复杂度为 O(log n) 的算法。
     * 示例 1:
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right){
            mid = (left + right) >> 1;
            if (nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LeetCode35 leetCode35 = new LeetCode35();
        int[] nums = new int[]{1,3,5,6};
        System.out.println(leetCode35.searchInsert(nums, 5));
        System.out.println(leetCode35.searchInsert(nums, 2));
        System.out.println(leetCode35.searchInsert(nums, 7));
        System.out.println(leetCode35.searchInsert(nums, 6));
    }
}
