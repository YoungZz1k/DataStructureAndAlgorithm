package com.YoungZz1k.LeetCode.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 判断链表是否有换   涉及判环算法
 */
public class LeetCode141 {


    /**
     * 是否有环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2){
                // 有环
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
