package com.YoungZz1k.LeetCode.Stack;

import com.YoungZz1k.DataStructure.Stack.ArrayStack;

import java.util.Stack;

/**
 * 用栈实现队列
 */
public class LeetCode232 {


    // 队头
    Stack<Integer> s1 = new Stack<>();
    // 队尾
    Stack<Integer> s2 = new Stack<>();

    public void push(int x) {
        s2.push(x);
    }

    public int pop() {
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.pop();
    }

    public int peek() {
        if (s1.isEmpty()){
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {

    }
}
