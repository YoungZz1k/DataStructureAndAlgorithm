package com.YoungZz1k.LeetCode;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 查找链表中间节点
 */
public class LeetCode876 {


    /**
     * 查找链表中间节点
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode p1 = ListNode.insertTail(1,3,5,7,9,11,13,15,17);
        System.out.println(middleNode(p1));
    }

}
