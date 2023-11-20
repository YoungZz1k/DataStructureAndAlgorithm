package com.YoungZz1k.DataStructure.Queue;

import java.util.Iterator;

/**
 * 单向环形链表(带哨兵)实现队列
 * @param <E>
 */
public class LinkedListQueue<E> implements Queue<E>,Iterable<E> {

    private static class Node<E>{
        E value;
        Node<E> next;
        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }



    private Node<E> head = new Node<>(null,null);
    private Node<E> tail = head;
    private int size;// 节点数
    private int capacity = Integer.MAX_VALUE;// 容量

    {
        tail.next = head;
    }

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;

    }

    public LinkedListQueue() {
    }

    /**
     * 向队列尾部插入值
     * @param value
     * @return
     */
    @Override
    public boolean offer(E value) {
        // 如果已满
        if (isFull()){
            return false;
        }
        Node<E> added = new Node<>(value, head);
        tail.next = added;
        tail = added;
        size ++;
        return true;
    }

    /**
     * 从队列头获取值并移除
     * @return
     */
    @Override
    public E pull() {
        if (isEmpty()){
            return null;
        }
        Node<E> p = head.next;
        head.next = head.next.next;
        if (p == tail){
            tail = head;
        }
        size --;
        return p.value;
    }

    /**
     * 从队列头获取值不移除
     * @return
     */
    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return head.next.value;
    }

    /**
     * 检查队列是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 检查队列是否已满
     * @return
     */
    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> p = head.next;
            @Override
            public boolean hasNext() {
                return p != head;
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
