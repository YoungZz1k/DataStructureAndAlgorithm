package com.YoungZz1k.LeetCode.Stack;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 用队列实现栈
 */
public class LeetCode225 {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    public static void push(int x) {
        q1.offer(x);
    }

    public static int pop() {
        Object[] array = q1.toArray();
        if (!q1.isEmpty() && array.length > 0){
            if (q2.isEmpty()){
                for (int i = array.length - 1; i >= 0 ; i--) {
                    q2.offer((Integer) array[i]);
                }
                while (!q1.isEmpty()){
                    q1.poll();
                }
            }else{
                Object[] array1 = q2.toArray();
                while (!q2.isEmpty()){
                    q2.poll();
                }
                for (int i = array.length - 1; i >= 0 ; i--) {
                    q2.offer((Integer) array[i]);
                }
                for (int i = 0; i < array1.length ; i++) {
                    q2.offer((Integer) array1[i]);
                }
                while (!q1.isEmpty()){
                    q1.poll();
                }
            }
        }
        return q2.poll();
    }

    public static int top() {
        Object[] array = q1.toArray();
        if (!q1.isEmpty() && array.length > 0){
            if (q2.isEmpty()){
                for (int i = array.length - 1; i >= 0 ; i--) {
                    q2.offer((Integer) array[i]);
                }
                while (!q1.isEmpty()){
                    q1.poll();
                }
            }else{
                Object[] array1 = q2.toArray();
                while (!q2.isEmpty()){
                    q2.poll();
                }
                for (int i = array.length - 1; i >= 0 ; i--) {
                    q2.offer((Integer) array[i]);
                }
                for (int i = 0; i < array1.length ; i++) {
                    q2.offer((Integer) array1[i]);
                }
                while (!q1.isEmpty()){
                    q1.poll();
                }
            }
        }
        return q2.peek();
    }

    public static boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
        push(4);
        pop();
        pop();
        pop();
    }
}
