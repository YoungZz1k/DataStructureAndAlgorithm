package com.YoungZz1k.LeetCode.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 判断链表是否带环并返回环的起点
 */
public class LeetCode142 {
    /**
     * 判断链表是否带环并返回环的起点
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
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

    public static void main(String[] args) {

    }
}
