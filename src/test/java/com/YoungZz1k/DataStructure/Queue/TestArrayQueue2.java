package com.YoungZz1k.DataStructure.Queue;

import org.junit.jupiter.api.Test;

public class TestArrayQueue2 {

    @Test
    void offer(){
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    @Test
    void pull(){
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(5);
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
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(5);
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
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(3);
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
        ArrayQueue2<Integer> queue = new ArrayQueue2<>(3);
        System.out.println(queue.isEmpty());
    }

}
