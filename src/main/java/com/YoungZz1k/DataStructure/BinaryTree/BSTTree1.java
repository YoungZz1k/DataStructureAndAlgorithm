package com.YoungZz1k.DataStructure.BinaryTree;

/**
 * Binary Search Tree 二叉搜索树
 */
public class BSTTree1 {

    // 根节点
    BSTNode root;

    /**
     * 二叉搜索树节点类
     */
    static class BSTNode{
        int key;
        Object value;
        BSTNode left;
        BSTNode right;

        public BSTNode(int key) {
            this.key = key;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }


    /**
     * 根据key找值
     * @param key 关键字
     * @return 值
     */
    public Object get(int key){
        return doGet(root,key);
    }

    private Object doGet(BSTNode node , int key){
        if (node == null){
            return null;// 结束递归
        }
        if (node.key < key){
            return doGet(node.right,key);// 向右
        }else if(key < node.key){
            return doGet(node.left,key);// 向左
        }else{
            return node;// 找到
        }
    }

    /**
     * 获得最小的key的值
     * @return 返回最小的key的值
     */
    public Object min(){
        return null;
    }

    /**
     * 获得最大的key的值
     * @return 返回最大的key的值
     */
    public Object max(){
        return null;
    }

    /**
     * 增加值
     * @param key 关键字
     * @param value 值
     */
    public void put(int key,Object value){

    }

    /**
     * 找到当前key的前任
     * @param key 关键字
     * @return 返回对应的值
     */
    public Object successor(int key){
        return null;
    }

    /**
     * 找到当前key的后继
     * @param key 关键字
     * @return 返回对应的值
     */
    public Object predecessor(int key){
        return null;
    }

    /**
     * 根据key删除节点
     * @param key
     * @return
     */
    public Object delete(int key){
        return null;
    }
}