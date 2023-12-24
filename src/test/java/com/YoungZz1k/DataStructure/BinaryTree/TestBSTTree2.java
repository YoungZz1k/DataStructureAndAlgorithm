package com.YoungZz1k.DataStructure.BinaryTree;

import org.junit.jupiter.api.Test;

public class TestBSTTree2 {


    @Test
    void testGet(){
        BSTTree2<String> bstTree2 = new BSTTree2();
        BSTTree2.BSTNode<String> n1 = new BSTTree2.BSTNode<>("a", "one");
        BSTTree2.BSTNode<String> n3 = new BSTTree2.BSTNode<>("c", "three");
        BSTTree2.BSTNode<String> n2 = new BSTTree2.BSTNode<>("b", "two",n1,n3);

        BSTTree2.BSTNode<String> n5 = new BSTTree2.BSTNode<>("e", "five");
        BSTTree2.BSTNode<String> n7 = new BSTTree2.BSTNode<>("g", "seven");
        BSTTree2.BSTNode<String> n6 = new BSTTree2.BSTNode<>("f", "six",n5,n7);
        BSTTree2.BSTNode<String> root = new BSTTree2.BSTNode<>("d", "root",n2,n6);

        bstTree2.root = root;
        System.out.println(bstTree2.get("a").toString());
        System.out.println(bstTree2.get("q"));
    }
}
