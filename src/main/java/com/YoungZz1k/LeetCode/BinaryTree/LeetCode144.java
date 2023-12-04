package com.YoungZz1k.LeetCode.BinaryTree;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树前序遍历
 */
public class LeetCode144 {

    /**
     * 非递归实现
     * @param root 根节点
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        TreeNode node = root;
        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()){
            if (node != null){
                result.add(node.val);
                stack.push(node);
                node = node.left;
            }else{
                TreeNode pop = stack.pop();
                node = pop.right;
            }
        }
        return result;
    }

    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traversal(root,result);
        return result;
    }

    public void traversal(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        result.add(root.val);
        traversal(root.left,result);
        traversal(root.right,result);
    }
}
