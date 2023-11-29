package com.YoungZz1k.DataStructure.Queue.PriorityQueue;

import com.YoungZz1k.DataStructure.Queue.Queue;

/**
 * 基于大顶堆实现的优先队列
 *
 * @param <E>
 */
public class PriorityQueue3<E extends Priority> implements Queue<E> {


    private Priority[] array;
    private int size;

    public PriorityQueue3(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()) {
            return false;
        }
        int child = size++;
        int parent = (child - 1) / 2;
        // 获得插入位置  从底部往上浮  当碰到比插入元素小 将父元素下沉
        while (child > 0 && value.priority() > array[parent].priority()) {
            array[child] = array[parent];
            child = parent;
            parent = (child - 1) / 2;
        }
        array[child] = value;
        return true;
    }

    @Override
    public E pull() {
        if (isEmpty()) {
            return null;
        }
        swap(0, size - 1);
        size--;
        E e = (E) array[size];
        array[size] = null;
        // 恢复大顶堆
        down(0);
        return e;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return (E) array[0];
    }

    private void swap(int i, int j) {
        Priority t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    private void down(int parent) {
        int left = 2 * parent + 1;
        int right = left + 1;
        int max = parent;// 假设父元素优先级最大
        if (left < size && array[left].priority() > array[parent].priority()){
            max = left;
        }
        if (right < size && array[right].priority() > array[parent].priority()){
            max = right;
        }
        if (max != parent){// 有孩子比父亲大
            swap(max,parent);
            down(max);
        }

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
