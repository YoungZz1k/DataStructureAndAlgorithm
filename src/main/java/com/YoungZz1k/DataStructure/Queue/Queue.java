package com.YoungZz1k.DataStructure.Queue;

public interface Queue<E> {

    /**
     * 向队列尾部插入值
     * @param value
     * @return
     */
    boolean offer(E value);

    /**
     * 从队列头获取值并移除
     * @return
     */
    E pull();

    /**
     * 从队列头获取值不移除
     * @return
     */
    E peek();

    /**
     * 检查队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 检查队列是否已满
     * @return
     */
    boolean isFull();
}
