package com.YoungZz1k.DataStructure.Stack;

import org.junit.jupiter.api.Test;

public class TestArrayStack {

    @Test
    void push(){
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    @Test
    void pop(){
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println("----------");
        System.out.println(stack.pop());
        System.out.println("----------");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println("----------");
        System.out.println(stack.pop());
        System.out.println("----------");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println("----------");
        System.out.println(stack.pop());
        System.out.println("----------");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    @Test
    void peek(){
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println("------------");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println("------------");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
        System.out.println("------------");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println("------------");
        for (Integer integer : stack) {
            System.out.println(integer);
        }
    }

    @Test
    void isFull(){
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.isFull());
    }

    @Test
    void isEmpty(){
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        System.out.println(stack.isEmpty());
    }
}
