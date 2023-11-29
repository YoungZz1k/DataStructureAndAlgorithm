package com.YoungZz1k.DataStructure.Queue.BlockingQueue;

/**
 * 阻塞队列
 * @param <E>
 */
public interface BlockingQueue<E> {

    void offer(E e) throws InterruptedException ;

    boolean offer(E e, long timeout) throws InterruptedException;

    E poll() throws InterruptedException;
}
