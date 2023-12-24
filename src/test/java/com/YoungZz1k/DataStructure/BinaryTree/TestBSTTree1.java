package com.YoungZz1k.DataStructure.BinaryTree;

import org.junit.jupiter.api.Test;

public class TestBSTTree1 {


    @Test
    void testGet(){
        BSTTree1 bstTree1 = new BSTTree1();
        BSTTree1.BSTNode n1 = new BSTTree1.BSTNode(1, "one");
        BSTTree1.BSTNode n3 = new BSTTree1.BSTNode(3, "three");
        BSTTree1.BSTNode n2 = new BSTTree1.BSTNode(2, "two",n1,n3);

        BSTTree1.BSTNode n5 = new BSTTree1.BSTNode(5, "five");
        BSTTree1.BSTNode n7 = new BSTTree1.BSTNode(7, "seven");
        BSTTree1.BSTNode n6 = new BSTTree1.BSTNode(6, "six",n5,n7);
        BSTTree1.BSTNode root = new BSTTree1.BSTNode(4, "root",n2,n6);

        bstTree1.root = root;
        System.out.println(bstTree1.get(3).toString());
        System.out.println(bstTree1.min());
        System.out.println(bstTree1.max());
    }
}
