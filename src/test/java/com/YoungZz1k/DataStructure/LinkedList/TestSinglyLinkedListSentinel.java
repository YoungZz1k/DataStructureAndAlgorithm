package com.YoungZz1k.DataStructure.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.SinglyLinkedListSentinel;
import com.YoungZz1k.DataStructure.LinkedList.SinglyLinkedListSentinel;
import org.junit.jupiter.api.Test;

public class TestSinglyLinkedListSentinel {

    /**
     * 遍历链表1
     */
    @Test
    public void test(){ //
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.loop1(value ->{
            System.out.println(value);
        });
    }

    /**
     * 遍历链表2
     */
    @Test
    public void test2(){ //
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);
        singlyLinkedList.loop2(value ->{
            System.out.println(value);
        });
    }

    /**
     * 遍历链表3
     */
    @Test
    public void test3(){ //
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addFirst(1);
        singlyLinkedList.addFirst(2);
        singlyLinkedList.addFirst(3);
        singlyLinkedList.addFirst(4);

        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    /**
     * 尾插法
     */
    @Test
    public void test4(){
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        for (Integer value : singlyLinkedList) {
            System.out.println(value);
        }
    }

    /**
     * 根据索引取值
     */
    @Test
    public void test5() {
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        System.out.println(singlyLinkedList.get(3));
    }

    /**
     * 向索引位置插入
     */
    @Test
    public void test6(){
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.insert(3,8);

        singlyLinkedList.loop1(System.out::println);
    }

    /**
     * 删除第一个结点
     */
    @Test
    public void test7(){
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.removeFirst();

        singlyLinkedList.loop1(System.out::println);

        System.out.println("=======");
        singlyLinkedList.removeFirst();

        singlyLinkedList.loop1(System.out::println);

        System.out.println("=======");
        singlyLinkedList.removeFirst();

        singlyLinkedList.loop1(System.out::println);

        System.out.println("=======");
        singlyLinkedList.removeFirst();

        singlyLinkedList.loop1(System.out::println);
    }

    /**
     * 根据索引位置删除
     */
    @Test
    public void test8(){
        SinglyLinkedListSentinel singlyLinkedList = new SinglyLinkedListSentinel();
        singlyLinkedList.addLast(1);
        singlyLinkedList.addLast(2);
        singlyLinkedList.addLast(3);
        singlyLinkedList.addLast(4);

        singlyLinkedList.remove(3);

        singlyLinkedList.loop1(System.out::println);
    }
}
