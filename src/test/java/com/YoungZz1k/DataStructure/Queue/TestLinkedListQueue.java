package com.YoungZz1k.DataStructure.Queue;

import org.junit.jupiter.api.Test;

public class TestLinkedListQueue {

    @Test
    void offer(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
    }

    @Test
    void peek(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
    }

    @Test
    void pull(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        System.out.println("----------------");
        System.out.println(queue.pull());
        System.out.println("----------------");
        for (Integer integer : queue) {
            System.out.println(integer);
        }

    }

    @Test
    void isEmpty(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        System.out.println(queue.isEmpty());
    }

    @Test
    void isFull(){
        LinkedListQueue<Integer> queue = new LinkedListQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer i : queue) {
            System.out.println(i);
        }
        System.out.println("-------------------");
        System.out.println(queue.offer(4));
    }
}
