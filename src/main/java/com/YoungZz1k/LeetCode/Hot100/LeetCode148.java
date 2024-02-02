package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

import java.util.*;

/**
 * 排序链表
 */
public class LeetCode148 {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * 输入：head = [4,2,1,3]
     * 输出：       [1,2,3,4]
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null){
            return null;
        }
        List<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null){
            list.add(p.val);
            p = p.next;
        }
        list.sort(Comparator.comparingInt(a -> a));
        Iterator<Integer> iterator = list.iterator();
        ListNode node = head;
        while (iterator.hasNext()){
            node.val = iterator.next();
            node = node.next;
        }

        return head;
    }


    public static void main(String[] args) {
        LeetCode148 leetCode148 = new LeetCode148();
        //[4,19,14,5,-3,1,8,5,11,15]
        ListNode node = ListNode.insertTail(4, 19, 14, 5, -3, 1, 8, 5, 11, 15);
        ListNode listNode = leetCode148.sortList(node);
        System.out.println(listNode.toString());
    }
}
