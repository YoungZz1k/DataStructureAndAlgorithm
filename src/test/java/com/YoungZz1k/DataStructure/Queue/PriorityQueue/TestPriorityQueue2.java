package com.YoungZz1k.DataStructure.Queue.PriorityQueue;


import org.junit.jupiter.api.Test;

public class TestPriorityQueue2 {


    @Test
    void test1(){
        PriorityQueue2<Entry> queue = new PriorityQueue2<>(10);
        System.out.println("empty : " + queue.isEmpty());
        System.out.println("full : " + queue.isFull());
        queue.offer(new Entry("task1",10));
        queue.offer(new Entry("task2",1));
        queue.offer(new Entry("task3",2));
        queue.offer(new Entry("task4",5));
        queue.offer(new Entry("task5",12));
        System.out.println(queue.peek());
        System.out.println(queue.pull());
        System.out.println(queue.peek());
    }
}
