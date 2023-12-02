package com.YoungZz1k.DataStructure.BinaryTree;

import sun.reflect.generics.tree.Tree;

public class TreeNode {

    private TreeNode left;
    private int val;
    private TreeNode right;

    public TreeNode(TreeNode left, int val,  TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
