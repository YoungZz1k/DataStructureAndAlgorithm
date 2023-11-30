package com.YoungZz1k.LeetCode.Heap;

import com.YoungZz1k.DataStructure.Heap.MaxHeap;
import com.YoungZz1k.DataStructure.Heap.MinHeap;

/**
 * 找数组内第k大的元素
 */
public class LeetCode76 {


    /**
     * 大顶堆实现
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest1(int[] nums, int k) {
        MaxHeap  heap = new MaxHeap(nums);
        int i = 0;
        int num = 0;
        while(i != k){
            num = heap.poll();
            i++;
        }
        return num;
    }

    /**
     * 小顶堆实现
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        MinHeap heap = new MinHeap(k);
        for (int i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i ++){
            if (nums[i] > heap.peek()){
                heap.replace(nums[i]);
            }
        }
        return heap.peek();
    }



    public static void main(String[] args) {
        int[] array = {1,5,3,7,9};
        int[] array1 = {3,2,3,1,2,4,5,5,6};
        int k = 2;
        System.out.println(findKthLargest2(array1, 4));
    }
}
