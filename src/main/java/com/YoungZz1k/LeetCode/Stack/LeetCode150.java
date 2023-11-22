package com.YoungZz1k.LeetCode.Stack;

import java.util.Stack;

/**
 * 150.逆波兰表达式求值
 */
public class LeetCode150 {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.matches("^-?(200|[1]?[0-9]{1,2})$")){
                stack.push(token);
            }else {
                // 匹配到符号 弹出两个元素运算
                String first = stack.pop();
                String second = stack.pop();
                int n;
                switch (token){
                    case "+":
                        n = Integer.parseInt(first) + Integer.parseInt(second);
                        stack.push(Integer.toString(n));
                        break;
                    case "-":
                        n = Integer.parseInt(first) - Integer.parseInt(second);
                        stack.push(Integer.toString(n));
                        break;
                    case "*":
                        n = Integer.parseInt(first) * Integer.parseInt(second);
                        stack.push(Integer.toString(n));
                        break;
                    case "/":
                        n = Integer.parseInt(second) / Integer.parseInt(first);
                        stack.push(Integer.toString(n));
                        break;
                    default:
                        break;
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args) {
        String[] s = {"1","2","+","3","*"};
        String[] token = {"4","13","5","/","+"};
        System.out.println(evalRPN(token));
    }
}
