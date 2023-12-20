package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

import java.util.Arrays;

/**
 * 从中序与后序遍历序列构造二叉树
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 */
public class LeetCode106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        // 后序遍历最后一个是根节点
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                // 划分中序 左右子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);//9
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);// 15 20 7

                // 划分后序 左右子树
                int[] postLeft = Arrays.copyOfRange(postorder, 0, i);// 9
                int[] postRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);// 15 7 20

                root.left = buildTree(inLeft,postLeft);
                root.right = buildTree(inRight,postRight);
            }
        }

        return root;
    }
}
