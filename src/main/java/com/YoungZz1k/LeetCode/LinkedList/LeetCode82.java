package com.YoungZz1k.LeetCode.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 有序链表去重(不保留重复元素)
 */
public class LeetCode82 {


    /**
     * 方法一 递归
     *
     * @param p
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        if (p.val == p.next.val) {
            ListNode x = p.next.next;
            while (x != null && x.val == p.val) {
                x = x.next;
            }
            return deleteDuplicates1(x); // 与p取值不同的节点
        } else {
            p.next = deleteDuplicates1(p.next);
            return p;
        }
    }

    /**
     * 方法二
     *
     * @param p
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode p) {
        if (p == null || p.next == null) {
            return p;
        }
        ListNode s = new ListNode(-1, p);
        ListNode p1 = s;
        ListNode p2,p3;
        while((p2 = p1.next) != null
                && ((p3 = p2.next) != null)){
            if (p2.val == p3.val){
                while ((p3 = p3.next) != null
                        && (p2.val == p3.val)){
                }
                p1.next = p3;
            }else{
                p1 = p1.next;
            }
        }
        return s.next;
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
