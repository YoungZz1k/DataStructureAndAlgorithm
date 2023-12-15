package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.LinkedList.ListNode;

/**
 * 两数之和
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 */
public class LeetCode2 {

    // 自己想的 样例无法通过 爆long
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        // l1 与 l2 转为数字
        ListNode p1 = l1;
        ListNode p2 = l2;
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        // 两个链表拼接为字符串
        while (p1 != null) {
            s1.append(p1.val);
            p1 = p1.next;
        }
        while (p2 != null) {
            s2.append(p2.val);
            p2 = p2.next;
        }
        // 反转
        StringBuilder str1 = s1.reverse();
        StringBuilder str2 = s2.reverse();
        // 转long
        long n1 = Long.parseLong(str1.toString());
        long n2 = Long.parseLong(str2.toString());
        // 相加
        long num = n1 + n2;
        // 转字符串
        String s = String.valueOf(num);
        StringBuilder str = new StringBuilder(s);
        // 反转结果
        StringBuilder reverse = str.reverse();
        // 分割字符
        String[] split = reverse.toString().split("");
        // 返回链表头节点
        ListNode head = new ListNode(-1,null);
        ListNode cur = head;
        // 组建结果链表
        for (String s3 : split) {
            cur.next = new ListNode(Integer.parseInt(s3),null);
            cur = cur.next;
        }
        return head.next;
    }

    // leetcode 题解
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 节点链表
        ListNode head = new ListNode(0);
        // 保存相加的进位
        int carry = 0;
        // 可移动的指针
        ListNode cur = head;
        while (l1 != null || l2 != null){

            // 取值
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            // 相加
            int sum = x + y + carry;
            // 计算进位数
            carry = sum / 10;
            // 计算两个数的和
            sum = sum % 10;
            // 求和数赋值给新链表节点
            cur.next = new ListNode(sum);
            // 新链表后移
            cur = cur.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }

        }
        // 如果最后相加有进位 把进位给新链表节点
        if (carry == 1){
            cur.next = new ListNode(carry);
        }

        return head.next;
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(2,new ListNode(4,new ListNode(3,null)));
        ListNode l2 = new ListNode(5,new ListNode(6,new ListNode(4,null)));
        LeetCode2 leetCode2 = new LeetCode2();
        System.out.println(leetCode2.addTwoNumbers1(l1, l2));
    }
}
