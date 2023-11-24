package com.YoungZz1k.LeetCode.Queue.Deque;

import com.YoungZz1k.DataStructure.Queue.Deque.LinkedListDeque;

/**
 * 设计循环双端队列
 */
public class LeetCode641 {

    public static class Node<E> {
        Node<E> prev;
        E value;
        Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

    }

    int capacity;
    int size;
    Node<Integer> sentinel = new Node<>(null, null, null);

    public LeetCode641(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    //  sentinel added c
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node<Integer> added = new Node<>(sentinel, value, sentinel.next);
        sentinel.next.prev = added;
        sentinel.next = added;
        size++;
        return true;
    }

    // a (added) sentinel
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node<Integer> last = sentinel.prev;
        Node<Integer> added = new Node<>(last, value, sentinel);
        last.next = added;
        sentinel.prev = added;
        size++;
        return true;
    }

    // sentinel a b
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return true;
    }

    //a b sentinel
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return sentinel.next.value;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return sentinel.prev.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {

        LeetCode641 obj = new LeetCode641(2);
        System.out.println(obj.insertFront(7));//
        System.out.println(obj.deleteLast());//
        System.out.println(obj.getFront());// false
        System.out.println(obj.insertLast(5));//
        System.out.println(obj.insertFront(0));// true
        System.out.println(obj.getFront());// false
        System.out.println(obj.getRear());// false
        System.out.println(obj.getFront());// false
        System.out.println(obj.getFront());// false
        System.out.println(obj.getRear());// false
        System.out.println(obj.insertLast(0));// 3

    }
}
