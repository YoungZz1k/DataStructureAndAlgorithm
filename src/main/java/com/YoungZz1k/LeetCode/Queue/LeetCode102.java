package com.YoungZz1k.LeetCode.Queue;


import com.YoungZz1k.DataStructure.Queue.LinkedListQueue;
import com.YoungZz1k.DataStructure.Queue.TreeNode;

import java.util.*;

/**
 * 102.二叉树层序遍历
 */
public class LeetCode102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int c1 = 1;// 当前层级
        while (!queue.isEmpty()) {
            int c2 = 0;// 下一层级
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null){
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    c2++;
                }
            }
            result.add(level);
            c1 = c2;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(
                new TreeNode(null, 2, null),
                1,
                new TreeNode(new TreeNode(6), 3, new TreeNode(7))
        );

        System.out.println(levelOrder(t));

//        LinkedListQueue<TreeNode> queue = new LinkedListQueue<>();
//        queue.offer(t);
//
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.pull();
//            System.out.println(node.toString());
//            if (node.left != null){
//                queue.offer(node.left);
//            }
//            if (node.right != null){
//                queue.offer(node.right);
//            }
//        }
    }
}
