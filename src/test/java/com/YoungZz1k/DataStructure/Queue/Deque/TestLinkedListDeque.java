package com.YoungZz1k.DataStructure.Queue.Deque;

import org.junit.jupiter.api.Test;

public class TestLinkedListDeque {

    @Test
    void offerFirst(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
    }

    @Test
    void offerLast(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerLast(4);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
    }

    @Test
    void pollFirst(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
        deque.pollFirst();
        System.out.println("----poolFirst----");
        for (Integer integer : deque) {
            System.out.println(integer);
        }
    }

    @Test
    void pollLast(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
        deque.pollLast();
        System.out.println("----poolLast----");
        for (Integer integer : deque) {
            System.out.println(integer);
        }
    }

    @Test
    void peekFirst(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
        System.out.println("----peekFirst----");
        System.out.println(deque.peekFirst());
    }

    @Test
    void peekLast(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        for (Integer integer : deque) {
            System.out.println(integer);
        }
        System.out.println("----peekLast----");
        System.out.println(deque.peekLast());
    }

    @Test
    void isEmpty(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(10);
        System.out.println(deque.isEmpty());
    }

    @Test
    void isFull(){
        LinkedListDeque<Integer> deque = new LinkedListDeque<>(3);
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        System.out.println(deque.isFull());
    }
}
