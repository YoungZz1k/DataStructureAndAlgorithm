package com.YoungZz1k.LeetCode;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 根据值删除节点
 */
public class LeetCode203 {

    /**
     * 根据值删除节点 方法1
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s.next;
        while (p2 != null) {
            if (p2.val == val) {
                // 删除,p2向后平移
                p1.next = p2.next;
                p2 = p2.next;
            } else {
                // p1 p2向后平移
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    /**
     * 根据值删除节点 方法2
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements2(head.next, val);
        } else {
            head.next = removeElements2(head.next, val);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o6 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);

        System.out.println(removeElements2(o1, 3));
    }
}
