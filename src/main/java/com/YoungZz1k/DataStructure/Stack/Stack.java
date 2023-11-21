package com.YoungZz1k.DataStructure.Stack;

/**
 * 栈
 * @param <E>
 */
public interface Stack<E> {

    /**
     * 向栈顶压入元素
     * @param value
     * @return
     */
    boolean push(E value);

    /**
     * 从栈顶弹出元素
     * @return
     */
    E pop();

    /**
     * 从栈顶返回元素，不弹出
     * @return
     */
    E peek();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 是否已满
     * @return
     */
    boolean isFull();
}
