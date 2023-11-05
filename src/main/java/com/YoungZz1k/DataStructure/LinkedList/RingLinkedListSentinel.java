package com.YoungZz1k.DataStructure.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 环形链表
 */
public class RingLinkedListSentinel implements Iterable<Integer> {
    private Node sentinel = new Node(null, -1, null);// 哨兵

    public RingLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * 节点类
     */
    private static class Node {
        Node prev;// 上一节点指针

        int value;// 值

        Node next;// 下一节点指针

        public Node(Node prev, int value, Node next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * 向链表头部插入
     *
     * @param value
     */
    public void addFirst(int value) {
        Node a = sentinel;
        Node b = sentinel.next;
        Node p = new Node(a, value, b);
        a.next = p;
        b.prev = p;
    }

    /**
     * 遍历链表
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() { // 是否有下一元素
                return p != sentinel;
            }

            @Override
            public Integer next() { // 返回当前元素值 指向下一元素
                int v = p.value;
                p = p.next;
                return v;
            }
        };
    }



    /**
     * 向尾部插入
     */
    public void addLast(int value) {
        Node last = sentinel.prev;
        Node p = new Node(last, value, sentinel);
        sentinel.prev = p;
        last.next = p;
    }




    /**
     * 删除第一个结点
     */
    public void removeFirst() {
        Node first = sentinel.next;
        if (first == sentinel){
            throw new IllegalArgumentException("非法");
        }
        sentinel.next = first.next;
        first.next.prev = sentinel;
    }

    /**
     * 删除最后一个结点
     */
    public void removeLast() {
        Node last = sentinel.prev;
        if (last == sentinel){
            throw new IllegalArgumentException(String.format("非法"));
        }
        Node prev = last.prev;
        prev.next = last.next;
        sentinel.prev = prev;
    }

    /**
     * 根据值查找节点
     * @param value
     * @return
     */
    private Node findByValue(int value){
        Node p = sentinel.next;
        while (p != sentinel){
            if (p.value == value){
                return p;
            }
            p = p.next;
        }
        return null;
    }

    /**
     * 根据值删除节点
     */
    public void removeByValue(int value){
        Node p = findByValue(value);
        if (p ==null){
            return;
        }
        Node prev = p.prev;
        prev.next = p.next;
        p.next.prev = prev;
    }
}

