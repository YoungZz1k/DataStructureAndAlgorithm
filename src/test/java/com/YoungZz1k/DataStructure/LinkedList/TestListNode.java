package com.YoungZz1k.DataStructure.LinkedList;

import org.junit.jupiter.api.Test;

public class TestListNode {

    /**
     * 反转链表1
     */
    @Test
    public void test1(){
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        ListNode n = ListNode.reverseList1(o1);
        System.out.println(n);
    }

    /**
     * 反转链表2
     */
    @Test
    public void test2(){
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        System.out.println(ListNode.reverseList2(o1));
    }

    /**
     * 反转链表3
     */
    @Test
    public void test3(){
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        System.out.println(ListNode.reverseList3(o1));
    }

    /**
     * 反转链表4
     */
    @Test
    public void test4(){
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        System.out.println(ListNode.reverseList4(o1));
    }

    /**
     * 反转链表5
     */
    @Test
    public void test5(){
        ListNode o5 = new ListNode(5,null);
        ListNode o4 = new ListNode(4,o5);
        ListNode o3 = new ListNode(3,o4);
        ListNode o2 = new ListNode(2,o3);
        ListNode o1 = new ListNode(1,o2);
        System.out.println(o1);
        System.out.println(ListNode.reverseList5(o1));
    }
}
