package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

import java.util.Arrays;

/**
 * 从前序与中序遍历序列构造二叉树
 * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * 输出: [3,9,20,null,null,15,7]
 */
public class LeetCode105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }
        // 前序遍历第一个值是根节点
        int rootValue = preorder[0];
        TreeNode root = new TreeNode(rootValue);
        // 中序遍历根节点左边是左子树 右边是右子树
        for (int i = 0; i < inorder.length; i++) {
            if (rootValue == inorder[i]) {
                // 中序左右子树划分
                // 0 ~ i-1 左子树
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                // i+1 ~ length -1 右子树
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                // 前序左右子树划分
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, inorder.length);

                root.left = buildTree(preLeft,inLeft);
                root.right = buildTree(preRight,inRight);
            }
        }
        return root;
    }
}
