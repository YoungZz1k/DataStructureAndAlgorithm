package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树展开为链表
 */
public class LeetCode114 {

    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode node = root;
        // 前序遍历过程
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                // 结果加入集合
                list.add(node.val);
                stack.push(node);
                node = node.left;
            } else {
                TreeNode poll = stack.poll();
                node = poll.right;
            }
        }
        TreeNode curr = root;
        // 遍历集合修改root.right的值
        for (int i = 1; i < list.size(); i++) {
            curr.left = null;
            curr.right = new TreeNode(null, list.get(i), null);
            curr = curr.right;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(null, 3, null), 2, new TreeNode(null, 4, null)),
                1,
                new TreeNode(null, 5, new TreeNode(null, 6, null))
        );
        flatten(root);
        System.out.println(root.toString());
    }
}
