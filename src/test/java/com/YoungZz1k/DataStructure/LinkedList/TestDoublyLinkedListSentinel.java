package com.YoungZz1k.DataStructure.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.DoublyLinkedListSentinel;
import com.YoungZz1k.DataStructure.LinkedList.SinglyLinkedListSentinel;
import org.junit.jupiter.api.Test;

public class TestDoublyLinkedListSentinel {

    /**
     * 头部添加
     */
    @Test
    public void addFirst() { //
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addFirst(1);
        doublyLinkedListSentinel.addFirst(2);
        doublyLinkedListSentinel.addFirst(3);
        doublyLinkedListSentinel.addFirst(4);
        for (Integer integer : doublyLinkedListSentinel) {
            System.out.println(integer);
        }
    }

    /**
     * 头部删除
     */
    @Test
    public void removeFirst() { //
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addFirst(1);
        doublyLinkedListSentinel.addFirst(2);
        doublyLinkedListSentinel.addFirst(3);
        doublyLinkedListSentinel.addFirst(4);

        doublyLinkedListSentinel.removeFirst();

        for (Integer integer : doublyLinkedListSentinel) {
            System.out.println(integer);
        }
    }

    /**
     * 尾部添加
     */
    @Test
    public void addLast() { //
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);
        doublyLinkedListSentinel.addLast(4);

        for (Integer value : doublyLinkedListSentinel) {
            System.out.println(value);
        }
    }

    /**
     * 尾部删除
     */
    @Test
    public void removeLast() {
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);
        doublyLinkedListSentinel.addLast(4);

        doublyLinkedListSentinel.removeLast();

        for (Integer value : doublyLinkedListSentinel) {
            System.out.println(value);
        }
    }

    /**
     * 根据索引插入
     */
    @Test
    public void insert() {
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);
        doublyLinkedListSentinel.addLast(4);

        for (Integer integer : doublyLinkedListSentinel) {
            System.out.println(integer);
        }

        System.out.println("============");

        doublyLinkedListSentinel.insert(2, 5);
        for (Integer integer : doublyLinkedListSentinel) {
            System.out.println(integer);
        }
    }

    /**
     * 根据索引删除
     */
    @Test
    public void remove() {
        DoublyLinkedListSentinel doublyLinkedListSentinel = new DoublyLinkedListSentinel();
        doublyLinkedListSentinel.addLast(1);
        doublyLinkedListSentinel.addLast(2);
        doublyLinkedListSentinel.addLast(3);
        doublyLinkedListSentinel.addLast(4);

        for (Integer integer : doublyLinkedListSentinel) {
            System.out.println(integer);
        }

        System.out.println("==============");

        doublyLinkedListSentinel.remove(2);

        for (Integer integer : doublyLinkedListSentinel) {
            System.out.println(integer);
        }

    }

}
