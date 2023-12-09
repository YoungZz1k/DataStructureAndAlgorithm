package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 反转链表
 */
public class LeetCode206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            {
                return head;
            }
        }
        // 新链表头
        ListNode n1 = null;
        while (head != null){
            // 暂存头结点下一节点
            ListNode o2 = head.next;
            // 断开头节点与原来的下一节点
            head.next = n1;
            // n1作为新的头
            n1 = head;
            // head后移
            head = o2;
        }
        return n1;
    }
}
