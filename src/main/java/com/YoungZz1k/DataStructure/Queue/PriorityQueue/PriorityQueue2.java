package com.YoungZz1k.DataStructure.Queue.PriorityQueue;

import com.YoungZz1k.DataStructure.Queue.Queue;

/**
 * 基于有序数组实现的优先队列
 * @param <E>
 */
public class PriorityQueue2<E extends Priority> implements Queue<E> {


    private Priority[] array;
    private int size;

    public PriorityQueue2(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if(isFull()){
            return false;
        }
        insert(value);
        size++;
        return true;
    }


    private void insert(E e){
        int i = size - 1;
        while (i >= 0 && array[i].priority() > e.priority()){
            array[i + 1] = array[i];
            i--;
        }
        array[i + 1] = e;
    }

    @Override
    public E pull() {
        if (isEmpty()){
            return null;
        }
        E e =(E) array[size - 1];
        size--;
        array[size] = null;// 引用地址置为null
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        return (E) array[size - 1];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == array.length;
    }

}
