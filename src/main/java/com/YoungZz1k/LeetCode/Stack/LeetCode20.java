package com.YoungZz1k.LeetCode.Stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 20.有效的括号
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }else if (c == '['){
                stack.push(']');
            }else if (c == '{'){
                stack.push('}');
            }else{
                if (stack.isEmpty()){
                    return false;
                }
                if (c == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {

    }
}
