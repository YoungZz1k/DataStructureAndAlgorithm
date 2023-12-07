package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 */
public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        // 队列存放节点
        Queue<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.offer(root);
        // 队列非空进行遍历
        while (!queue.isEmpty()){
            // 获取队列大小
            int size = queue.size();
            // 当前层级的值
            List<Integer> level = new ArrayList<>();
            // 对当前层进行遍历
            for (int i = 0; i < size; i++) {
                // 出队
                TreeNode node = queue.poll();
                // 加入到集合
                level.add(node.val);
                // 若有左右孩子 加入到下一层级
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            // 当前层级放入到结果集合
            result.add(level);
        }
        return result;
    }
}
