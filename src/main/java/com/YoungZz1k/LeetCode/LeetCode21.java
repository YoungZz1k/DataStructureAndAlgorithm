package com.YoungZz1k.LeetCode;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

public class LeetCode21 {


    /**
     * 方法一
     * @param p1
     * @param p2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode p1,ListNode p2){
        ListNode s = new ListNode(-1,null);
        ListNode p = s;
        while( p1 != null && p2 != null){
            if (p1.val > p2.val){
                p.next = p2;
                p2 = p2.next;
            }else{
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 != null){
            p.next = p1;
        }else {
            p.next = p2;
        }
        return s.next;
    }

    /**
     * 方法二 递归
     * @param p1
     * @param p2
     * @return
     */
    public static ListNode mergeTwoLists2(ListNode p1,ListNode p2){
        if ( p1 == null){
            return p2;
        }
        if (p2 == null){
            return p1;
        }
        if (p1.val < p2.val){
            p1.next = mergeTwoLists2(p1.next,p2);
            return p1;
        }else{
            p2.next = mergeTwoLists2(p1,p2.next);
            return p2;
        }
    }

    public static void main(String[] args) {
        ListNode p = ListNode.insertTail(1,3,4,5,6,7);
        ListNode p1 = ListNode.insertTail(2,3,4,6,8,9,10);

        System.out.println(p);
        System.out.println(p1);

        System.out.println(mergeTwoLists2(p, p1));
    }
}
