package com.YoungZz1k.DataStructure.BinaryTree;

import sun.reflect.generics.tree.Tree;

public class TreeNode {

    public TreeNode left;
    public int val;
    public TreeNode right;

    public TreeNode(TreeNode left, int val,  TreeNode right) {
        this.left = left;
        this.val = val;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
