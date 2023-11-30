package com.YoungZz1k.LeetCode.Heap;

import com.YoungZz1k.DataStructure.Heap.MaxHeap;

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



    public static void main(String[] args) {
        int[] array = {1,5,3,7,9};
        int k = 2;
        System.out.println(findKthLargest1(array, 2));
    }
}
