package com.YoungZz1k.DataStructure.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * 树的遍历
 */
public class TreeTraversal {


    /**
     * 前序遍历
     * @param node 根节点
     */
    static void preOrder(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val + "\t");
        preOrder(node.left);// 左子树
        preOrder(node.right);// 右子树
    }

    /**
     * 中序遍历
     * @param node 根节点
     */
    static void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);// 左
        System.out.printf(node.val + "\t");// 值
        inOrder(node.right);// 右
    }

    /**
     * 后序遍历
     * @param node 根节点
     */
    static void postOrder(TreeNode node){
        if (node == null){
            return;
        }
        postOrder(node.left);// 左
        postOrder(node.right);// 右
        System.out.printf(node.val + "\t");// 值
    }

    //       1
    //      / \
    //     2   3
    //    / \  / \
    //   4    5   6
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(
                new TreeNode(new TreeNode(4),2,null),
                1,
                new TreeNode(new TreeNode(5),3,new TreeNode(6))
        );
        // 前序遍历 1 2 4 3 5 6
        preOrder(treeNode);
        System.out.println();
        // 中序遍历 4 2 1 5 3 6
        inOrder(treeNode);
        System.out.println();
        // 后序遍历 4 2 5 6 3 1
        postOrder(treeNode);
    }
}
