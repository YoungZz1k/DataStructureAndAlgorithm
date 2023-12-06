package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

/**
 * 二叉树的最大深度
 */
public class LeetCode104 {
    public int maxDepth(TreeNode root) {
        return maxDepth(root,0);
    }


    public int maxDepth(TreeNode root, int deep) {
        if(root == null){
            return deep;
        }
        // 前序遍历 进入一次+1
        deep++;
        int left = maxDepth(root.left,deep);// 左子树深度
        int right = maxDepth(root.right,deep);// 右子树深度
        return Math.max(left, right);
    }
}
