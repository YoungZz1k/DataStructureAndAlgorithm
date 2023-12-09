package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 环形链表2 找出环的起点
 */
public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        // 快慢指针判环
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                // 有环
                // 回到起点
                p1 = head;
                while (true){
                    if (p1 == p2){
                        return p1;
                    }
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
        }
        return null;
    }
}
