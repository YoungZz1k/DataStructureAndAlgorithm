package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

/**
 * 翻转二叉树
 */
public class LeetCode226 {
    public TreeNode invertTree(TreeNode root) {
        helper(root);
        return root;
    }

    public void helper(TreeNode node){
        if (node == null){
            return;
        }
        TreeNode t = node.left;
        node.left = node.right;
        node.right = t;
        helper(node.left);
        helper(node.right);
    }
}
