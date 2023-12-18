package com.YoungZz1k.LeetCode.Hot100;

/**
 * 搜索插入位置(sec)
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 */
public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) >>> 1;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] <= target){
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        LeetCode35 leetCode35 = new LeetCode35();
        System.out.println(leetCode35.searchInsert(nums, 7));
    }
}
