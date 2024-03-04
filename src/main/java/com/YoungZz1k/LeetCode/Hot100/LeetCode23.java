package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;


import java.util.PriorityQueue;

/**
 * 合并k个升序链表[hard][sec]
 */
public class LeetCode23 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * 示例 1：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * 输入：lists = [[]]
     * 输出：[]
     * 提示：
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);// 优先队列构建小顶堆

        // 对数组进行遍历
        for (ListNode list : lists) {
            if (list != null){
                pq.add(list);// 头节点入堆
            }
        }

        ListNode ans = new ListNode(0,null);// 头节点
        ListNode p = ans;
        while (!pq.isEmpty()){
            ListNode poll = pq.poll();// 堆顶是当前最小的节点值
            if (poll.next != null){
                pq.add(poll.next); // 下一节点入堆
            }
            p.next = poll; // 连接
            p = p.next;
        }

        return ans.next; // 返回头结点下一节点 才是实际需要的节点
    }

    public static void main(String[] args) {
        LeetCode23 leetCode23 = new LeetCode23();
        ListNode l1 = ListNode.insertTail(1, 4, 5);
        ListNode l2 = ListNode.insertTail(1, 3, 4);
        ListNode l3 = ListNode.insertTail(1, 2, 6);
        ListNode[] lists = new ListNode[]{l1,l2,l3};
        ListNode listNode = leetCode23.mergeKLists(lists);
        System.out.println(listNode.toString());
    }
}
