package com.YoungZz1k.DataStructure.LinkedList;


/**
 * 链表题目所用节点类
 */
public class ListNode {
    public int val;

    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 批量头插
     * @param elements
     * @return
     */
    public static ListNode insertHead(int...elements){
        ListNode p = null;
        for (int element : elements) {
            p = new ListNode(element,p);
        }
        return p;
    }

    /**
     * 批量尾插
     * @param elements
     * @return
     */
    public static ListNode insertTail(int...elements){
        ListNode head = new ListNode(-1,null);
        ListNode p1 = head;
        for (int element : elements) {
            p1.next = new ListNode(element,null);
            p1 = p1.next;
        }
        return head.next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * 反转链表 方法1
     *
     * @param head
     * @return
     */
    public static ListNode reverseList1(ListNode head) {
        ListNode n1 = null;
        ListNode p = head;
        while (p != null) {
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;
    }

    static class List{
        ListNode head;

        public List(ListNode head) {
            this.head = head;
        }

        public void addFirst(ListNode first){
            first.next = head;
            head = first;
        }

        public ListNode removeFirst(){
            ListNode first = head;
            if (first != null){
                head = first.next;
            }
            return first;
        }
    }

    /**
     * 反转链表 方法2
     * @param head
     */
    public static ListNode reverseList2(ListNode head){
        List list1 = new List(head);
        List list2 = new List(null);
        while (true){
            ListNode first = list1.removeFirst();
            if (first == null){
                break;
            }
            list2.addFirst(first);
        }
        return list2.head;
    }

    /**
     * 反转链表 方法3
     * @param p
     * @return
     */
    public static ListNode reverseList3(ListNode p){
        if (p== null || p.next == null){
            return p;
        }
        ListNode last = reverseList3(p.next);
        p.next.next = p;
        p.next = null;
        return last;
    }

    /**
     * 反转链表 方法4
     * @param p
     * @return
     */
    public static ListNode reverseList4(ListNode p){
        if (p == null || p.next == null){
            return p;
        }
        // 旧头节点
        ListNode o1 = p;
        // 新头节点
        ListNode n1 = o1;
        // 旧头节点的第二个节点
        ListNode o2 = o1.next;
        while (o2 != null){
            o1.next = o2.next;// 将第二个节点与第一个节点断开 并将第一个节点next指向第二个节点的next
            o2.next = n1;// 让分离出来的第二个节点的next指向新的头节点
            n1 = o2;// 更新新头节点的值
            o2 = o1.next;// 设置o2为旧头节点的第二个节点
        }
        return n1;
    }

    /**
     * 反转链表 方法5
     * @param p
     * @return
     */
    public static ListNode reverseList5(ListNode p){
        if (p == null || p.next == null){
            return p;
        }
        ListNode n1 = null;
        while(p != null){
            ListNode o2 = p.next; // 暂存头节点的下一节点
            p.next = n1; // 将头节点next指向n1
            n1 = p;// 将n1变为新的头
            p = o2;// 头节点变为原来的第二个节点
        }
        return n1;
    }
}
