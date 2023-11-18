package com.YoungZz1k.LeetCode.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 删除有序链表重复节点
 */
public class LeetCode83 {


    /**
     * 方法1
     * @param p
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode p){
        if (p == null || p.next == null){
            return p;
        }
        ListNode p1 = p;
        ListNode p2 = p.next;
        while (p2 != null){
            if (p1.val == p2.val){
                p2 = p1.next.next;
                p1.next = p1.next.next;
                continue;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return p;
    }

    /**
     * 方法2 递归
     * @param p
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode p){
        if (p == null || p.next == null){
            return p;
        }
        if (p.val == p.next.val){
            return deleteDuplicates2(p.next);
        }else{
            p.next = deleteDuplicates2(p.next);
            return p;
        }
    }

    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(3, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(1, o3);
        ListNode o1 = new ListNode(1, o2);
        System.out.println(o1);

        System.out.println(deleteDuplicates2(o1));
    }
}
