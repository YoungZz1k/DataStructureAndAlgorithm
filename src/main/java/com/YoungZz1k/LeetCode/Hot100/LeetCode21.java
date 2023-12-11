package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 合并两个有序链表
 */
public class LeetCode21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode(-1,null);
        ListNode cur = result;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
                cur.next = new ListNode(list2.val,null);
                list2 = list2.next;

            }else{
                cur.next = new ListNode(list1.val,null);
                list1 = list1.next;
            }
            cur = cur.next;
        }
        if (list1 == null){
            cur.next = list2;
        }
        if (list2 == null){
            cur.next = list1;
        }
        return result.next;
    }
}
