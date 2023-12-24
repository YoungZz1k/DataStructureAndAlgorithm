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
        return min(root);
    }

    public Object min(BSTNode node) {
        if (node == null) {
            return null;
        }
        BSTNode p = node;
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
        BSTNode node = root;
        BSTNode ancestorFromRight = null;
        while (node != null) {
            if (node.key < key) {
                node = node.right;
            } else if (node.key > key) {
                ancestorFromRight = node;
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
        // 情况一 当前节点有右子树 右子树的最小值就是当前节点的后继
        if (node.right != null) {
            return min(node.right);
        }
        // 情况二 当前节点无右子树 离他最近的 从右而来的祖先就是它的后继
        return ancestorFromRight != null ? ancestorFromRight.value : null;
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
        BSTNode node = root;
        BSTNode parent = null;
        while (node != null) {
            if (node.key < key) {
                parent = node;
                node = node.right;
            } else if (node.key > key) {
                parent = node;
                node = node.left;
            } else {
                break;
            }
        }
        // 没找到
        if (node == null) {
            return null;
        }
        // 找到 删除
        if (node.left == null ) {
            // 情况一 删除的节点没有左孩子 有右孩子
            shift(parent,node,node.right);
        } else if (node.right == null) {
            // 情况二 删除的节点没有右孩子 有左孩子
            shift(parent,node,node.left);
        }else{
            // 情况四 左右孩子都有
            // 1.找被删除节点的后继
            BSTNode s = node.right;
            BSTNode sParent = node;
            while (s.left != null){
                sParent = s;
                s = s.left;
            }
            if (sParent != node){//不相邻
                // 2.删除和后继不相邻，处理后继节点的孩子
                shift(sParent,s,s.right);// 不会有左孩子
                s.right = node.right;
            }
            // 3.后继取代被删除节点
            shift(parent,node,s);
            s.left = node.left;
        }

        return null;
    }

    /**
     * 删除调整树结构方法
     * @param parent 被删除节点的父节点
     * @param deleted 被删除节点
     * @param child 被顶上去的节点
     */
    private void shift(BSTNode parent,BSTNode deleted,BSTNode child){
        if (parent == null){
            // parent == null 顶上去的节点成为root
            root = child;
        }else if (deleted == parent.left){
            // 被顶上去的节点是被删除的左孩子
            parent.left = child;
        }else{
            // 被顶上去的节点是被删除的右孩子
            parent.right = child;
        }
    }
}
