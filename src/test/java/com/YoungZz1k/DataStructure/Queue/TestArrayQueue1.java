package com.YoungZz1k.DataStructure.Queue;

import org.junit.jupiter.api.Test;

public class TestArrayQueue1 {

    @Test
    void offer(){
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    @Test
    void pull(){
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        queue.pull();
        System.out.println("------------");
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    @Test
    void peek(){
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println("------------");

        System.out.println(queue.peek());
        System.out.println("------------");
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    @Test
    void isFull(){
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println("------------");
        System.out.println(queue.offer(4));
        System.out.println("------------");
        System.out.println(queue.isFull());
    }

    @Test
    void isEmpty(){
        ArrayQueue1<Integer> queue = new ArrayQueue1<>(3);
        System.out.println(queue.isEmpty());
    }

}
