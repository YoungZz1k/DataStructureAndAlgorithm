package com.YoungZz1k.LeetCode.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 合并k个有序链表
 */
public class LeetCode23 {

    /**
     * 合并两个有序链表
     *
     * @param p1
     * @param p2
     * @return
     */
    public static ListNode mergeTwoLinkedLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return s.next;
    }

    /**
     * 合并k个有序链表
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    /**
     * 返回合并后的链表
     *
     * @param lists
     * @param i
     * @param j
     * @return
     */
    private static ListNode split(ListNode[] lists, int i, int j) {
        if (i == j){// 数组内只有一个链表
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode p1 = split(lists, i, m);
        ListNode p2 = split(lists, m + 1, j);
        return mergeTwoLinkedLists(p1,p2);
    }

    public static void main(String[] args) {
        ListNode p1 = ListNode.insertTail(1, 3, 5, 7, 9);
        ListNode p2 = ListNode.insertTail(2, 4, 6, 8, 10);
        ListNode p3 = ListNode.insertTail(1,2,3,4,10,11,12,14);
        ListNode[] lists = {p1,p2,p3};
        System.out.println(mergeKLists(lists));
    }
}
