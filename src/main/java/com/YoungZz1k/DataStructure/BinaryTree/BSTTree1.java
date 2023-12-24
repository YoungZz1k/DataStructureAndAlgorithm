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
    static class BSTNode {
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
//    public Object get(int key){
//        return doGet(root,key);
//    }

    /**
     * 根据key找值
     *
     * @param key 关键字
     * @return 值
     */
    public Object get(int key) {
        BSTNode node = root;
        while (node != null) {
            if (node.key < key) {
                node = node.right;
            } else if (node.key > key) {
                node = node.left;
            } else {
                return node.value;
            }
        }
        return null;
    }

    private Object doGet(BSTNode node, int key) {
        if (node == null) {
            return null;// 结束递归
        }
        if (node.key < key) {
            return doGet(node.right, key);// 向右
        } else if (key < node.key) {
            return doGet(node.left, key);// 向左
        } else {
            return node.value;// 找到
        }
    }

    /**
     * 获得最小的key的值
     *
     * @return 返回最小的key的值
     */
    public Object min() {
        if (root == null) {
            return null;
        }
        BSTNode p = root;
        while (p.left != null) {
            p = p.left;
        }
        return p.value;
    }

    /**
     * 获得最大的key的值
     *
     * @return 返回最大的key的值
     */
    public Object max() {
        return max(root);
    }

    public Object max(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
        while (p.right != null) {
            p = p.right;
        }
        return p.value;
    }

    /**
     * 增加值
     *
     * @param key   关键字
     * @param value 值
     */
    public void put(int key, Object value) {
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            parent = node;
            if (node.key < key) {
                node = node.right;
            } else if (node.key > key) {
                node = node.left;
            } else {
                // 有 更新
                node.value = value;
                return;
            }
        }
        BSTNode newNode = new BSTNode(key, value);
        // 树空 建立根节点
        if (parent == null) {
            root = newNode;
        }
        // 没有 新增
        if (parent.key > newNode.key) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }

    /**
     * 找到当前key的后继
     *
     * @param key 关键字
     * @return 返回对应的值
     */
    public Object successor(int key) {
        return null;
    }

    /**
     * 找到当前key的前驱
     *
     * @param key 关键字
     * @return 返回对应的值
     */
    public Object predecessor(int key) {
        BSTNode node = root;
        BSTNode ancestorFromLeft = null;
        while (node != null) {
            if (node.key < key) {
                ancestorFromLeft = node;
                node = node.right;
            } else if (node.key > key) {
                node = node.left;
            } else {
                break;
            }
        }
        // 没找到节点
        if (node == null) {
            return null;
        }
        // 找到节点
        // 情况一 当前节点有左子树 左子树的最大值就是当前节点的前驱
        if (node.left != null) {
            return max(node.left);
        }
        // 情况二 当前节点无左子树 离他最近的 从左而来的祖先就是它的前驱
        return ancestorFromLeft != null ? ancestorFromLeft.value : null;
    }

    /**
     * 根据key删除节点
     *
     * @param key
     * @return
     */
    public Object delete(int key) {
        return null;
    }
}
