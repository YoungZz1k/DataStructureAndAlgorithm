package com.YoungZz1k.LeetCode.Hot100;

/**
 * 盛最多水的容器
 */
public class LeetCode11 {
    public int maxArea1(int[] height) {
        // 暴力遍历 超时
        int max = 0;
        for (int i = 0; i + 1 < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 容器长
                int l = j - i;
                // 高
                int d = Math.min(height[i],height[j]);
                max = Math.max(max,d*l);
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        // 双指针
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            max = Math.max(max,(right - left) * Math.min(height[left],height[right]));
            // 如果左比右大 右指针减1
            if (height[left] > height[right]){
                right--;
            }else{
                left ++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        LeetCode11 leetCode11 = new LeetCode11();
        System.out.println(leetCode11.maxArea(nums));
    }
}
