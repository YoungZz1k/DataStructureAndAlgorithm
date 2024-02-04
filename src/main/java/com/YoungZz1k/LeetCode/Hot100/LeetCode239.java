package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.Queue.Deque.LinkedListDeque;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 */
public class LeetCode239 {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length < 2 || nums == null) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];

        int index = 0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {

            // 移除比当前值小的索引
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // 加入队尾
            deque.offerLast(i);

            // 移除不在滑动窗口里的索引
            while (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }

            // 如果大于等于第一个窗口右边界 可以开始取值放入结果数组
            if (i >= k - 1) {
                res[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    // 暴力超时
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int i = 0;// 左边界
        while ((i + k - 1) < nums.length) {
            int r = i + k - 1; // 窗口右边界
            int max = nums[i];
            while (r > i && r < nums.length) {
                if (max < nums[r]) {
                    max = nums[r];
                }
                r--;
            }
            res[i] = max;
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        LeetCode239 leetCode239 = new LeetCode239();
//        int[] window = leetCode239.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        int[] window = leetCode239.maxSlidingWindow(new int[]{7, 2, 4}, 2);
        for (int i : window) {
            System.out.printf(i + " ");
        }
    }
}
