package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.RingLinkedListSentinel;

import java.util.Arrays;

/**
 * 在排序数组查找元素第一个和最后一个位置
 */
public class LeetCode34 {

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * 示例 1：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     *
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     *
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */

    public int[] searchRange(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        int Lindex = -1, Rindex = -1;
        int[] res = {Lindex, Rindex};
        if (nums.length == 0){
            return res;
        }
        while (begin <= end) {
            int mid = (begin + end) >>> 1;
            if (target < nums[mid]) {
                // 向左
                end = mid - 1;
            } else if (target > nums[mid]) {
                // 向右
                begin = mid + 1;
            } else {
                Lindex = mid;
                end = mid - 1;
            }
        }
        begin = 0;
        end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) >>> 1;
            if (target < nums[mid]) {
                // 向左
                end = mid - 1;
            } else if (target > nums[mid]) {
                // 向右
                begin = mid + 1;
            } else {
                Rindex = mid;
                begin = mid + 1;
            }
        }
        res[0] = Lindex;
        res[1] = Rindex;
        return res;
    }

    public static void main(String[] args) {
        LeetCode34 leetCode34 = new LeetCode34();
        int[] a = {};
        int[] range = leetCode34.searchRange(a, 6);
        for (int i : range) {
            System.out.print(i + ",");
        }
    }

}
