package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

/**
 * 二叉树的直径
 */
public class LeetCode543 {

    int count = 0;

    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * 两节点之间路径的 长度 由它们之间边数表示。
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。    1
     * 示例 2：                                        / \
     * 输入：root = [1,2]                             2   3
     * 输出：1                                       / \
     */                                         // 4   5
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return count;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);

        // 更新直径
        count = Math.max(count, left + right);

        // 返回节点的最大深度
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {
        LeetCode543 leetCode543 = new LeetCode543();
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(null, 4, null), 2, new TreeNode(null, 5, null)),
                1,
                new TreeNode(null, 3, null));
        System.out.println(leetCode543.diameterOfBinaryTree(node));
    }
}
