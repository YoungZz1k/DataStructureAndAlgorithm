package com.YoungZz1k.LeetCode.Hot100;

import com.YoungZz1k.DataStructure.BinaryTree.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 验证二叉搜索树
 */
public class LeetCode98 {
    long pre = Long.MIN_VALUE;

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * 有效二叉搜索树定义如下：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     */

    public boolean isValidBST(TreeNode root) {    //   2
        if (root == null){                       //   / \
            return true;                        //   1   3
        }                                      //   /     \
                                              //   0       4
        if (!isValidBST(root.left)){
            return false;
        }

        // 如果当前节点小于之前遍历的节点 false 中序 0 1 2 3 4
        if (root.val <= pre){
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }


    public static void main(String[] args) {
        LeetCode98 leetCode98 = new LeetCode98();
        TreeNode node = new TreeNode(new TreeNode(new TreeNode(null,0,null), 1, null), 2, new TreeNode(null, 3, new TreeNode(null,4,null)));
        System.out.println(leetCode98.isValidBST(node));
    }
}
