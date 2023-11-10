package com.YoungZz1k.DataStructure.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.DoublyLinkedListSentinel;
import com.YoungZz1k.DataStructure.LinkedList.RingLinkedListSentinel;
import org.junit.jupiter.api.Test;

public class TestRingLinkedListSentinel {

    /**
     * 头部添加
     */
    @Test
    public void addFirst() { //
        RingLinkedListSentinel ringLinkedListSentinel = new RingLinkedListSentinel();
        ringLinkedListSentinel.addFirst(1);
        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(3);
        ringLinkedListSentinel.addFirst(4);
        for (Integer integer : ringLinkedListSentinel) {
            System.out.println(integer);
        }
    }

    /**
     * 头部删除
     */
    @Test
    public void removeFirst() { //
        RingLinkedListSentinel ringLinkedListSentinel = new RingLinkedListSentinel();
        ringLinkedListSentinel.addFirst(1);
        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(3);
        ringLinkedListSentinel.addFirst(4);
        for (Integer integer : ringLinkedListSentinel) {
            System.out.println(integer);
        }

        System.out.println("=====");

        ringLinkedListSentinel.removeFirst();

        for (Integer integer : ringLinkedListSentinel) {
            System.out.println(integer);
        }

    }

    /**
     * 尾部添加
     */
    @Test
    public void addLast() { //
        RingLinkedListSentinel ringLinkedListSentinel = new RingLinkedListSentinel();
        ringLinkedListSentinel.addFirst(1);
        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(3);
        ringLinkedListSentinel.addFirst(4);

        for (Integer value : ringLinkedListSentinel) {
            System.out.println(value);
        }
    }

    /**
     * 尾部删除
     */
    @Test
    public void removeLast() {
        RingLinkedListSentinel ringLinkedListSentinel = new RingLinkedListSentinel();
        ringLinkedListSentinel.addFirst(1);
        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(3);
        ringLinkedListSentinel.addFirst(4);

        ringLinkedListSentinel.removeLast();
        ringLinkedListSentinel.removeLast();
        ringLinkedListSentinel.removeLast();


        for (Integer value : ringLinkedListSentinel) {
            System.out.println(value);
        }
    }

    /**
     * 根据值删除
     */
    @Test
    public void removeByValue() {
        RingLinkedListSentinel ringLinkedListSentinel = new RingLinkedListSentinel();
        ringLinkedListSentinel.addFirst(1);
        ringLinkedListSentinel.addFirst(2);
        ringLinkedListSentinel.addFirst(3);
        ringLinkedListSentinel.addFirst(4);

        for (Integer integer : ringLinkedListSentinel) {
            System.out.println(integer);
        }

        System.out.println("============");

        ringLinkedListSentinel.removeByValue(2);
        ringLinkedListSentinel.removeByValue(3);
        ringLinkedListSentinel.removeByValue(4);
        for (Integer integer : ringLinkedListSentinel) {
            System.out.println(integer);
        }
    }

}
