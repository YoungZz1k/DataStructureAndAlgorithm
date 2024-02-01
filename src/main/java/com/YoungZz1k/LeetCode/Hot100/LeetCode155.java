package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.Stack.Stack;

import java.util.Iterator;

/**
 * 最小栈
 */
public class LeetCode155 {


//     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
//     *
//     * 实现 MinStack 类:
//     *
//     * MinStack() 初始化堆栈对象。
//     * void push(int val) 将元素val推入堆栈。
//     * void pop() 删除堆栈顶部的元素。
//     * int top() 获取堆栈顶部的元素。
//     * int getMin() 获取堆栈中的最小元素。
//     *
//     * 输入：
//     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
//     * [[],[-2],[0],[-3],[],[],[],[]]
//     *
//     * 输出：
//     * [null,null,null,null,-3,null,0,-2]
//     *
//     * 解释：
//     * MinStack minStack = new MinStack();
//     * minStack.push(-2);
//     * minStack.push(0);
//     * minStack.push(-3);
//     * minStack.getMin();   --> 返回 -3.
//     * minStack.pop();
//     * minStack.top();      --> 返回 0.
//     * minStack.getMin();   --> 返回 -2.


    private ArrayStack arrayStack;


    public void MinStack() {
        arrayStack = new ArrayStack(100);
    }

    public void push(int val) {
        arrayStack.push(val);
    }

    public void pop() {
        int pop = arrayStack.pop();
    }

    public int top() {
        return arrayStack.peek();
    }

    public int getMin() {
        return arrayStack.getMin();
    }

    static class ArrayStack  {


        private int[] array;

        private int top = 0;// 栈顶指针

        private int min;// 内部维护一个最小值

        public ArrayStack(int capacity) {//初始化
            array = new int[capacity];
        }


        public void push(int value) {
            if (isFull()) {
                // 扩容
                int size = array.length;
                size += (array.length >> 1);
                int[] arr = new int[size];
                System.arraycopy(array, 0, arr, 0, array.length);
                array = arr;
            }
            if (isEmpty()) {
                min = value;
            }
            if (min > value) {
                min = value;
            }
            array[top] = value;
            top++;
        }

        public int getMin() {
            return min;
        }

        public int pop() {
            if (isEmpty()) {

            }
            int value = array[top - 1];
            if (min == value) {// pop时若pop出去的等于最小值 更新最小值
                min = array[0];
                for (int i = 0; i <= top -2 ; i++) {
                    if (min > array[i]) {
                        min = array[i];
                    }
                }
            }
            top--;
            return value;
        }


        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            return array[top - 1];
        }


        public boolean isEmpty() {
            return top == 0;
        }


        public boolean isFull() {
            return top == array.length;
        }


    }

    public static void main(String[] args) {
        LeetCode155 leetCode155 = new LeetCode155();
        leetCode155.MinStack();
        leetCode155.push(512);
        leetCode155.push(-1024);
        leetCode155.push(-1024);
        leetCode155.push(512);
        leetCode155.pop();
        System.out.println(leetCode155.getMin());
        leetCode155.pop();
        System.out.println(leetCode155.getMin());
        leetCode155.pop();
        System.out.println(leetCode155.getMin());
    }
}
