package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.Stack.LinkedListStack;
import com.YoungZz1k.DataStructure.Stack.Stack;

import java.util.LinkedList;

/**
 * 有效的括号(sec)
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
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
}
