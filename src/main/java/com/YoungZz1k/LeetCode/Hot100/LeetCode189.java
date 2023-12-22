package com.YoungZz1k.LeetCode.Hot100;

import java.util.Arrays;

/**
 * 轮转数组
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 */
public class LeetCode189 {
    // 超时
    public void rotate1(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        int len = nums.length;
        int i = 0;
        while (i < k) {
            // 先暂存最后一个元素
            int temp = nums[nums.length - 1];
            // 从后往前移动
            for (int j = nums.length - 2; j >= 0; j--) {
                // 计算移动后的位置
                int index = (j + 1) % len;
                int t = nums[j];
                nums[j] = nums[index];
                nums[index] = t;
            }
            i++;
        }
    }
    // 数组替换
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        for (int i = 0; i < nums.length; i++) {
            arr[(i + k) % len] = nums[i];
        }
        System.arraycopy(arr,0,nums,0,len);
    }

    public static void main(String[] args) {
        int[] n = {1, 2, 3, 4, 5, 6, 7};
        LeetCode189 leetCode189 = new LeetCode189();
        leetCode189.rotate(n, 3);
        System.out.println(Arrays.toString(n));
    }
}
