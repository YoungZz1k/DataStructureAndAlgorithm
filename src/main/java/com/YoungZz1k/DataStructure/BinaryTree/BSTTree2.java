package com.YoungZz1k.DataStructure.BinaryTree;

/**
 * Binary Search Tree 二叉搜索树
 */
public class BSTTree2<E extends Comparable<E>> {

    // 根节点
    BSTNode<E> root;

    /**
     * 二叉搜索树节点类
     */
    static class BSTNode<E> {
        E key;
        Object value;
        BSTNode<E> left;
        BSTNode<E> right;

        public BSTNode(E key) {
            this.key = key;
        }

        public BSTNode(E key, Object value, BSTNode<E> left, BSTNode<E> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode(E key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public Object get(E key) {
        BSTNode<E> node = root;
        while (node != null) {
            // 1 key > node.key
            // 0 key == node.key
            // -1 key < node.key
            if (key.compareTo(node.key) > 0) {
                node = node.right;
            } else if (key.compareTo(node.key) < 0) {
                node = node.left;
            } else {
                return node.value;
            }
        }
        return null;
    }

    /**
     * 获得最小的key的值
     *
     * @return 返回最小的key的值
     */
    public Object min() {
        return null;
    }

    /**
     * 获得最大的key的值
     *
     * @return 返回最大的key的值
     */
    public Object max() {
        return null;
    }

    /**
     * 增加值
     *
     * @param key   关键字
     * @param value 值
     */
    public void put(E key, Object value) {

    }

    /**
     * 找到当前key的前任
     *
     * @param key 关键字
     * @return 返回对应的值
     */
    public Object successor(E key) {
        return null;
    }

    /**
     * 找到当前key的后继
     *
     * @param key 关键字
     * @return 返回对应的值
     */
    public Object predecessor(E key) {
        return null;
    }

    /**
     * 根据key删除节点
     *
     * @param key
     * @return
     */
    public Object delete(E key) {
        return null;
    }
}
