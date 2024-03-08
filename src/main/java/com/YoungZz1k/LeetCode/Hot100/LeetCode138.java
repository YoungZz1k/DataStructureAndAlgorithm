package com.YoungZz1k.LeetCode.Hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 随机链表的复制[mid]
 */
public class LeetCode138 {
    /**
     *给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
     * 构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和 random 指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
     * 例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有 x.random --> y 。
     * 返回复制链表的头节点。
     * 用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
     * val：一个表示 Node.val 的整数。
     * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
     * 你的代码 只 接受原链表的头节点 head 作为传入参数。
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 使用HashMap来建立原节点和复制节点的映射关系
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;

        // 第一遍遍历，复制每个节点并将复制节点放在原节点后面
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;

        // 第二遍遍历，设置复制节点的next和random指针
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        // 返回复制链表的头节点
        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val,Node next,Node random) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }


    private static Node DeepCopyLinkedList(Node head) {
        // 普通链表复制
        Node node = new Node(head.val);
        Node p = head;
        Node pre = node;
        while (p.next != null){
            pre.next = new Node(p.next.val);
            p = p.next;
            pre = pre.next;
        }
        return node;
    }


    public static void main(String[] args) {
        LeetCode138 leetCode138 = new LeetCode138();
        Node node7 = new Node(7);
        Node node13 = new Node(13);
        Node node11 = new Node(11);
        Node node10 = new Node(10);
        Node node1 = new Node(1);
        node7.next = node13;
        node13.next = node11;
        node11.next = node10;
        node10.next = node1;
        node7.random = null;
        node13.random = node7;
        node11.random = node1;
        node10.random = node11;
        node1.random = node7;
        leetCode138.copyRandomList(node7);
    }


}
