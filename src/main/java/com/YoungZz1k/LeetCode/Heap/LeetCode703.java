package com.YoungZz1k.LeetCode.Heap;

import com.YoungZz1k.DataStructure.Heap.MinHeap;

/**
 * 数据流中第k大元素
 */
public class LeetCode703 {

    private MinHeap minHeap;

    public LeetCode703(int k, int[] nums) {
        minHeap = new MinHeap(k);
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (!minHeap.isFull()){
            minHeap.offer(val);
        }else if (val > minHeap.peek()){
            minHeap.replace(val);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {

    }
}
