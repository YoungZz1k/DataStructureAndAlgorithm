package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 两两交换链表中的节点
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 */
public class LeetCode24 {
    public ListNode swapPairs(ListNode head) {
        // 哨兵节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        // 当前到达的节点
        ListNode temp = dummyHead;
        while (temp.next != null && temp.next.next != null) {
            // 要交换的第一个节点
            ListNode node1 = temp.next;
            // 要交换的第二个节点
            ListNode node2 = temp.next.next;
            // 交换
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // temp移动到交换后的node1
            temp = node1;
        }
        return dummyHead.next;

    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        LeetCode24 leetCode24 = new LeetCode24();
        System.out.println(leetCode24.swapPairs(node));
    }
}
