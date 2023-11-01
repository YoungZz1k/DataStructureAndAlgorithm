package com.YoungZz1k.DataStructure.LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

/**
 * 单向链表
 */
public class SinglyLinkedList implements Iterable<Integer> {
    private Node head = null;// 头指针

    /**
     * 节点类
     */
    private static class Node {
        int value;// 值

        Node next;// 下一节点指针

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 向链表头部插入
     *
     * @param value
     */
    public void addFirst(int value) {
        // 1. 链表为空
        // head = new Node(value, null);

        // 2. 链表不为空
        head = new Node(value, head);
    }

    /**
     * 遍历链表1
     */
    public void loop1(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    /**
     * 遍历链表2
     */
    public void loop2(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    /**
     * 遍历链表3
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node p = head;

            @Override
            public boolean hasNext() { // 是否有下一元素
                return p != null;
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
        Node node = head;
//        if (node != null){
//
//        }
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
        Node last = findLast();
        if (last == null) {
            addFirst(value);
            return;
        }
        last.next = new Node(value, null);
    }

    /**
     * 根据索引获取结点
     *
     * @param index
     * @return
     */
    public Node findNode(int index) {
        Node p = head;
        int count = 0;
        while (p != null) {
            if (count == index) {
                return p;
            }
            p = p.next;
            count++;
        }
        throw new IllegalArgumentException(String.format("非法索引 %d", index));
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
        if(p == null){
            throw new IllegalArgumentException(String.format("index [%d] 位置不合法",index));
        }
        return p.value;
    }

    /**
     * 向索引位置插入
     *
     * @param index
     */
    public void insert(int index, int value) {
        if (index == 0){
            addFirst(value);
            return;
        }
        Node node = findNode(index - 1);
        if (node == null){
            throw new IllegalArgumentException(String.format("index [%d] 位置不合法",index));
        }
        node.next = new Node(value, node.next);
    }

    /**
     * 删除第一个结点
     */
    public void removeFirst(){
        Node p = head;
        if(head != null){
           head = head.next;
        }
    }

    /**
     * 根据索引删除
     * @param index
     */
    public void remove(int index){
        if (index == 0){
            removeFirst();
            return;
        }
        Node prior = findNode(index - 1);
        if (prior == null){
            throw new IllegalArgumentException(String.format("index [%d] 位置不合法",index));
        }
        prior.next = findNode(index).next;
    }
}

