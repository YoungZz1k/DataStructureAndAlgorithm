package com.YoungZz1k.LeetCode.Queue.Deque;


import com.YoungZz1k.DataStructure.Queue.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树z字遍历
 */
public class LeetCode103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int c1 = 1;// 当前层级
        boolean flag = true;// 奇数层 true
        while (!queue.isEmpty()) {
            int c2 = 0;// 下一层级
            LinkedList<Integer> level = new LinkedList<>(); // 保存每一层结果
            for (int i = 0; i < c1; i++) {
                TreeNode node = queue.poll();
                if (!flag){
                    // 偶数层向头部插入
                    level.offerFirst(node.val);
                }else{
                    level.offerLast(node.val);
                }

                if (node.left != null){
                    queue.offer(node.left);
                    c2++;
                }
                if (node.right != null){
                    queue.offer(node.right);
                    c2++;
                }
            }
            flag = !flag;
            result.add(level);
            c1 = c2;
        }
        return result;
    }
}
