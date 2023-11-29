package com.YoungZz1k.LeetCode.LinkedList;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 合并k个有序链表
 */
public class LeetCode23 {

    /**
     * 合并两个有序链表
     *
     * @param p1
     * @param p2
     * @return
     */
    public static ListNode mergeTwoLinkedLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }
        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return s.next;
    }

    /**
     * 合并k个有序链表
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    /**
     * 返回合并后的链表
     *
     * @param lists
     * @param i
     * @param j
     * @return
     */
    private static ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) {// 数组内只有一个链表
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode p1 = split(lists, i, m);
        ListNode p2 = split(lists, m + 1, j);
        return mergeTwoLinkedLists(p1, p2);
    }

    ListNode[] array;
    int size;

    public LeetCode23(int capacity) {
        array = new ListNode[capacity];
    }

    public boolean offer(ListNode offered) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        // 获得插入位置  从底部往上浮  当碰到比插入元素大 将父元素下沉
        while (child > 0 && offered.val < array[parent].val) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = offered;
        return true;
    }

    public ListNode poll() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        ListNode e = array[size];
        array[size] = null;
        // 恢复小顶堆
        down(0);
        return e;
    }

    private void swap(int i, int j) {
        ListNode t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int min = parent;// 假设父元素值最小
        if (left < size && array[left].val < array[min].val) {
            min = left;
        }
        if (right < size && array[right].val < array[min].val) {
            min = right;
        }
        if (min != parent) {// 有孩子比父亲小
            swap(min, parent);
            down(min);
        }
    }

    public boolean isFull() {
        return size == array.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 合并k个有序链表(小顶堆实现)
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        LeetCode23 heap = new LeetCode23(lists.length);
        // 链表头节点加入到小顶堆
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        // 不断从堆顶移除并加入到新链表
        ListNode s = new ListNode(-1, null);
        ListNode t = s;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            t.next = min;
            t = min;

            if (min.next != null) {
                heap.offer(min.next);
            }
        }
        return s.next;
    }

    public static void main(String[] args) {
        ListNode p1 = ListNode.insertTail(1, 3, 5, 7, 9);
        ListNode p2 = ListNode.insertTail(2, 4, 6, 8, 10);
        ListNode p3 = ListNode.insertTail(1, 2, 3, 4, 10, 11, 12, 14);
        ListNode[] lists = {p1, p2, p3};
        System.out.println(mergeKLists1(lists));
    }
}
