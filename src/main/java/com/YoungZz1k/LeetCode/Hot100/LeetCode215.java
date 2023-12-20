package com.YoungZz1k.LeetCode.Hot100;

import java.util.PriorityQueue;

/**
 * 数组中第k个大的元素
 */
public class LeetCode215 {
    public int findKthLargest(int[] nums, int k) {
        // 构造大根堆
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        for (int num : nums) {
            heap.offer(num);
        }
        int i = 0;
        int res = 0;
        while (i != k){
            res = heap.poll();
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> b-a);
        heap.offer(1);
        heap.offer(2);
        for (Integer integer : heap) {
            System.out.println(integer);
        }
    }
}
