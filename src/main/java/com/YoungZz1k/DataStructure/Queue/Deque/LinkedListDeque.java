package com.YoungZz1k.DataStructure.Queue.Deque;

import java.util.Iterator;

/**
 * 双向链表实现双端队列
 * @param <E>
 */
public class LinkedListDeque<E> implements Deque<E>, Iterable<E> {

    static class Node<E> {
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
    Node<E> sentinel = new Node<>(null,null,null);

    public LinkedListDeque(int capacity) {
        this.capacity = capacity;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    // a(头) added b
    @Override
    public boolean offerFirst(E value) {
        if (isFull()){
            return false;
        }
        Node<E> a = sentinel;
        Node<E> b = sentinel.next;
        a.next = new Node<>(a,value,b);
        b.prev = a.next;
        size++;
        return true;
    }
    // a added b(头)
    @Override
    public boolean offerLast(E value) {
        if (isFull()){
            return false;
        }
        Node<E> a = sentinel.prev;
        Node<E> b = sentinel;
        a.next = new Node<>(a,value,b);
        b.prev = a.next;
        size++;
        return true;
    }

    @Override
    public E pollFirst() {
        if (isEmpty()){
            return null;
        }
        Node<E> node = sentinel.next;
        sentinel.next = node.next;
        node.next.prev = sentinel;
        size--;
        return node.value;
    }
    // a rem sentinel
    @Override
    public E pollLast() {
        if (isEmpty()){
            return null;
        }
        Node<E> removed = sentinel.prev;
        removed.prev.next = sentinel;
        sentinel.prev = removed.prev;
        size--;
        return removed.value;
    }

    @Override
    public E peekFirst() {
        if (isEmpty()){
            return null;
        }
        return sentinel.next.value;
    }

    @Override
    public E peekLast() {
        if (isEmpty()){
            return null;
        }
        return sentinel.prev.value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = sentinel.next;
            @Override
            public boolean hasNext() {
                return p != sentinel;
            }
            @Override
            public E next() {
                E value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
