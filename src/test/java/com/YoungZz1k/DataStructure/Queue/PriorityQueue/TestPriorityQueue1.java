package com.YoungZz1k.DataStructure.Queue.PriorityQueue;


import org.junit.jupiter.api.Test;

public class TestPriorityQueue1 {


    @Test
    void test1(){
        PriorityQueue1<Entry> priorityQueue1 = new PriorityQueue1<>(10);
        System.out.println("empty : " + priorityQueue1.isEmpty());
        System.out.println("full : " + priorityQueue1.isFull());
        priorityQueue1.offer(new Entry("task1",10));
        priorityQueue1.offer(new Entry("task2",1));
        priorityQueue1.offer(new Entry("task3",2));
        priorityQueue1.offer(new Entry("task4",5));
        priorityQueue1.offer(new Entry("task5",12));
        System.out.println(priorityQueue1.peek());
        System.out.println(priorityQueue1.pull());
        System.out.println(priorityQueue1.peek());
    }
}
