package com.YoungZz1k.LeetCode.Heap;

import com.YoungZz1k.DataStructure.Heap.Heap;
import com.YoungZz1k.DataStructure.Heap.MaxHeap;
import com.YoungZz1k.DataStructure.Heap.MinHeap;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 */
public class LeetCode295 {



    // 大顶堆
    private PriorityQueue<Integer> left = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    // 小顶堆
    private PriorityQueue<Integer> right = new PriorityQueue<>();

    public void addNum(int num) {
        if (left.size() == right.size()){
            right.offer(num);
            left.offer(right.poll());
        }else{
            left.offer(num);
            right.offer(left.poll());
        }
    }



        public double findMedian() {
        if (left.size() == right.size()){
            return (left.peek() + right.peek()) /2.0;
        }else{
            return left.peek();
        }
    }

    public static void main(String[] args) {
        LeetCode295 code295 = new LeetCode295();
        code295.addNum(1);
        code295.addNum(2);
        code295.addNum(3);
        code295.addNum(7);
        code295.addNum(8);
        code295.addNum(9);
        System.out.println(code295.findMedian());
    }
}
