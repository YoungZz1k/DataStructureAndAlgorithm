package com.YoungZz1k.DataStructure.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 双向链表（带哨兵）
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {
    private Node head = null;// 头部哨兵

    private Node tail = null;// 尾部哨兵

    public DoublyLinkedListSentinel() {
        this.head = new Node(null, 666, null);
        this.tail = new Node(null, 777, null);
        head.next = tail;
        tail.prev = head;
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
        insert(0, value);
    }

    /**
     * 遍历链表1
     */
    public void loop1(Consumer<Integer> consumer) {

    }

    /**
     * 遍历链表2
     */
    public void loop2(Consumer<Integer> consumer) {

    }

    /**
     * 遍历链表3
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head.next;

            @Override
            public boolean hasNext() { // 是否有下一元素
                return p != tail;
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
     * 遍历链表4
     */
    public void loop3() {

    }

    /**
     * 查找最后结点
     *
     * @return
     */
    private Node findLast() {
        if (head == null) {
            return null;
        }
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        return p;
    }

    /**
     * 向尾部插入
     */
    public void addLast(int value) {
        Node last = tail.prev;
        Node p = new Node(last, value, tail);
        last.next = p;
        tail.prev = p;
    }

    /**
     * 根据索引获取结点
     *
     * @param index
     * @return
     */
    public Node findNode(int index) {
        int i = -1;
        for (Node p = head; p != tail; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    /**
     * 根据索引取值
     *
     * @param index
     * @return
     */
    public int get(int index) {
        int count = 0;
        Node p = findNode(index);
        if (p == null) {
            throw new IllegalArgumentException(String.format("index [%d] 位置不合法", index));
        }
        return p.value;
    }

    /**
     * 向索引位置插入
     *
     * @param index
     */
    public void insert(int index, int value) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("索引 [%d] 不合法", index));
        }
        Node next = prev.next;
        Node p = new Node(prev, value, next);
        prev.next = p;
        next.prev = p;
    }

    /**
     * 删除第一个结点
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * 根据索引删除
     *
     * @param index
     */
    public void remove(int index) {
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw new IllegalArgumentException(String.format("索引 [%d] 不合法", index));
        }
        Node p = prev.next;
        if (prev.next == tail) {
            throw new IllegalArgumentException(String.format("索引 [%d] 不合法", index));
        }
        prev.next = p.next;
        p.next.prev = prev;
    }

    /**
     * 删除最后一个结点
     */
    public void removeLast(){
        Node last = tail.prev;
        if (last == head){
            throw new IllegalArgumentException(String.format("索引不正确"));
        }
        Node prev = last.prev;
        prev.next = tail;
        tail.prev = prev;
    }
}

