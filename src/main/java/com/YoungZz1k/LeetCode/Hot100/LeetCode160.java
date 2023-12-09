package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 相交链表
 */
public class LeetCode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        while (a != null){
            b = headB;
            while (b != null){
                if (a == b){
                    return a;
                }else if( a != b){
                    b = b.next;
                }
            }
            a = a.next;
        }
        return a;
    }

}
