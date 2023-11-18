package com.YoungZz1k.LeetCode;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 判断回文链表
 */
public class LeetCode234 {


    /**
     * 判断回文链表 方法一
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        //1.寻找中间节点
        ListNode middle = middle(head);
        //2.反转中间节点后的
        ListNode reverse = reverse(middle);
        //3.逐一比较
        while (reverse != null) {
            if (reverse.val != head.val){
                return false;
            }
            reverse = reverse.next;
            head = head.next;
        }
        return true;
    }

    /**
     * 反转链表
     *
     * @param middle
     * @return
     */
    private static ListNode reverse(ListNode middle) {
        ListNode p = null;
        while (middle != null) {
            ListNode o = middle.next;
            middle.next = p;
            p = middle;
            middle = o;
        }
        return p;
    }

    /**
     * 找中间节点
     *
     * @param head
     * @return
     */
    private static ListNode middle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    /**
     * 判断回文链表 方法二
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome2(ListNode head) {
        // 中间节点
        ListNode p1 = head;
        ListNode p2 = head;
        // 反转后的链表
        ListNode n1 = null;
        ListNode o1 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            // 反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1;
        }

        if (p2 != null){// 奇数个节点
            p1 = p1.next;
        }
        while (n1 != null){
            if (n1.val != p1.val){
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode p = ListNode.insertTail(1, 2, 2, 1);
        ListNode p1 = ListNode.insertTail(1, 2, 3, 2, 1);
        System.out.println(isPalindrome2(p1));
    }
}
