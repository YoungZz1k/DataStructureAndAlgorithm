package com.YoungZz1k.LeetCode.BinaryTree;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 二叉树最小深度
 */
public class LeetCode111 {
    // 递归
    public int minDepth1(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = minDepth1(root.left);
        int right = minDepth1(root.right);
        if (left == 0){
            return right + 1;
        }
        if (right == 0){
            return left + 1;
        }
        return Integer.min(left,right) + 1;
    }

    // 层序遍历
    public int minDepth2(TreeNode root) {
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int deep = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            deep++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null){
                    return deep;
                }
                if (poll.left != null){
                    queue.offer(poll.left);
                }
                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return deep;
    }

}
