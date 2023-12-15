package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 删除链表倒数第n个节点(sec)
 */
public class LeetCode19 {
    // 自己想的
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head.next == null){
            return null;
        }
        int count = 0;
        // 1->2->3->4->5
        ListNode cur = head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        int s = 1;
        ListNode now = head;
        // 1->2
        while (now != null){
            if ((count - n) == 0){
                head = head.next;
            }
            if (s == (count - n )){
                now.next = now.next.next;
                break;
            }
            now = now.next;
            s++;
        }
        return head;
    }

    // 快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1,head);
        ListNode p1 = s;
        ListNode p2 = s;
        // p2先走n + 1步
        for(int i = 0; i < n + 1; i ++){
            p2 = p2.next;
        }
        // p2为null时 到达倒数第n-1节点
        while(p2 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        LeetCode19 leetCode19 = new LeetCode19();
        System.out.println(leetCode19.removeNthFromEnd(head, 2));
    }
}
