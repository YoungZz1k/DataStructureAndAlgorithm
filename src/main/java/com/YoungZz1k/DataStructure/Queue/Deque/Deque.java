package com.YoungZz1k.DataStructure.Queue.Deque;

/**
 * 双端队列
 */
public interface Deque<E> {


    boolean offerFirst(E value);

    boolean offerLast(E value);

    E pollFirst();

    E pollLast();

    E peekFirst();

    E peekLast();

    boolean isEmpty();

    boolean isFull();
}
