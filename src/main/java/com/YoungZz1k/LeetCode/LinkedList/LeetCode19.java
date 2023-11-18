package com.YoungZz1k.LeetCode.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 删除倒数第n个节点
 */
public class LeetCode19 {


    /**
     * 删除倒数第n节点
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode s = new ListNode(-1,head);
        recurision(s, n);
        return s.next;
    }

    /**
     * 方法一 递归法
     * @param p
     * @param n
     * @return
     */
    public static int recurision(ListNode p, int n) {
        if (p == null) {
            return 0;
        }

        int nth = recurision(p.next, n);//下一个节点的倒数位置

        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }

    /**
     * 方法二 快慢指针法
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;

        return s.next;
    }


    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);

        System.out.println(o1);

//        System.out.println(removeNthFromEnd1(o1, 3));
        System.out.println(removeNthFromEnd2(o1, 1));
    }
}
