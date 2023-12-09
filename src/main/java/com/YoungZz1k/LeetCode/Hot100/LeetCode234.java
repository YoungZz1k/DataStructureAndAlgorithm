package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 回文链表
 */
public class LeetCode234 {
    // 常规解法
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        // 找中间节点指针
        ListNode p1 = head;
        ListNode p2 = head;
        // 中间变量
        ListNode o2 = head;
        // 从中间节点往后反转的新链表
        ListNode n1 = null;
        // 找中间节点 1 2 3 2 1
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2 != null) {// 奇数个节点 往后挪动一个
            p1 = p1.next;
        }
        // 反转后半部分链表
        while (p1 != null) {
            ListNode o = p1.next;
            p1.next = n1;
            n1 = p1;
            p1 = o;
        }
        // 两个链表进行比较
        while (n1 != null) {
            if (n1.val != head.val) {
                return false;
            }
            n1 = n1.next;
            head = head.next;
        }
        return true;
    }

}
