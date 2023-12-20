package com.YoungZz1k.DataStructure.BinaryTree;

import java.util.LinkedList;

/**
 * 后缀表达式转二叉树
 */
public class ExpressionTree {


    static class TreeNode {

        public TreeNode left;
        public String val;
        public TreeNode right;

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        public TreeNode(String val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }

    // 21-3*
    //     *
    //    / \
    //   -   3
    //  / \
    // 2   1
    public TreeNode constructExpressionTree(String[] tokens){
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String t : tokens) {

            switch (t){
                // 遇到符号就出栈 构建树
                case "+":
                case "-":
                case "*":
                case "/":
                    TreeNode right = stack.pop();
                    TreeNode left = stack.pop();
                    TreeNode root = new TreeNode(t);
                    root.left = left;
                    root.right = right;
                    stack.push(root);
                    break;
                // 遇到数字就入栈
                default:
                    stack.push(new TreeNode(t));
                    break;
            }
        }
        return stack.peek();
    }

    /**
     * 后序遍历(非递归)
     *
     * @param node
     */
    public void postOrder1(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        TreeNode pop = null; // 上一次弹栈的元素
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
//                System.out.println("去 : " + curr.val);// 前序遍历
                stack.push(curr);// 压入走过的节点，方便回溯
                curr = curr.left;//
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || pop == peek.right) {
                    pop = stack.pop();// 弹栈刚好是中序遍历
                    System.out.println(pop.val);
                } else {
                    curr = peek.right;// 左边为空时 取出上一步的右孩子赋给curr
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","-","3","*"};
        ExpressionTree expressionTree = new ExpressionTree();
        TreeNode treeNode = expressionTree.constructExpressionTree(tokens);
        expressionTree.postOrder1(treeNode);
    }
}
