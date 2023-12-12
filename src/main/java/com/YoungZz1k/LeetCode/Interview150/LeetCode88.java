package com.YoungZz1k.LeetCode.Interview150;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */
public class LeetCode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0){
            return;
        }
        int i = 0;
        int j = m;
        while (i < n && j <(m + n)){
            nums1[j] = nums2[i];
            j++;
            i++;
        }
        Arrays.sort(nums1);
    }

    public static void main(String[] args) {
        int[] nums1 = {0};
        int[] nums2 = {1};
        LeetCode88 leetCode88 = new LeetCode88();
        leetCode88.merge(nums1,0,nums2,1);
        System.out.println(Arrays.toString(nums1));
    }
}
