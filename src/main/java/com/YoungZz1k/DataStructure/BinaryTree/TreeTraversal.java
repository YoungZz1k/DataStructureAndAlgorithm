package com.YoungZz1k.DataStructure.BinaryTree;



import java.util.LinkedList;

/**
 * 树的遍历
 */
public class TreeTraversal {


    /**
     * 前序遍历
     *
     * @param node 根节点
     */
    static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + "\t");
        preOrder(node.left);// 左子树
        preOrder(node.right);// 右子树
    }

    /**
     * 中序遍历
     *
     * @param node 根节点
     */
    static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);// 左
        System.out.printf(node.val + "\t");// 值
        inOrder(node.right);// 右
    }

    /**
     * 后序遍历
     *
     * @param node 根节点
     */
    static void postOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);// 左
        postOrder(node.right);// 右
        System.out.printf(node.val + "\t");// 值
    }

    /**
     * 前序、中序遍历(非递归)
     * @param node
     */
    static void preOrder1(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println("去 : " + curr.val);// 前序遍历
                stack.push(curr);// 压入走过的节点，方便回溯
                curr = curr.left;//
            } else {
                TreeNode pop = stack.pop();// 弹栈刚好是中序遍历
//                System.out.println("回 : " + pop.val);
                curr = pop.right;// 左边为空时 取出上一步的右孩子赋给curr
            }
        }
    }

    /**
     * 后序遍历(非递归)
     *
     * @param node
     */
    static void postOrder1(TreeNode node) {
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
                    System.out.println("回 : " + pop.val);
                } else {
                    curr = peek.right;// 左边为空时 取出上一步的右孩子赋给curr
                }
            }
        }
    }


    /**
     * 前中后遍历(非递归)
     *
     * @param node
     */
    static void allOrder1(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        TreeNode pop = null; // 上一次弹栈的元素
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                System.out.println("前序 : " + curr.val);// 前序遍历
                stack.push(curr);// 压入走过的节点，方便回溯
                // 待处理左子树
                curr = curr.left;//
            } else {
                TreeNode peek = stack.peek();
                // 没有右子树
                if (peek.right == null ) {
                    pop = stack.pop();
                    System.out.println("中序 : " + pop.val);
                    System.out.println("后序 : " + pop.val);
                }
                // 右子树处理完成
                else if (pop == peek.right) {
                    pop = stack.pop();
                    System.out.println("后序 : " + pop.val);
                }
                // 待处理右子树
                else {
                    System.out.println("中序 : " + stack.peek().val);
                    curr = peek.right;// 左边为空时 取出上一步的右孩子赋给curr
                }
            }
        }
    }



    //       1
    //      / \
    //     2   3
    //    / \  / \
    //   4    5   6
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
//        // 前序遍历 1 2 4 3 5 6
//        preOrder(treeNode);
//        System.out.println();
//        // 中序遍历 4 2 1 5 3 6
//        inOrder(treeNode);
//        System.out.println();
//        // 后序遍历 4 2 5 6 3 1
//        postOrder(treeNode);
        allOrder1(treeNode);
    }
}
