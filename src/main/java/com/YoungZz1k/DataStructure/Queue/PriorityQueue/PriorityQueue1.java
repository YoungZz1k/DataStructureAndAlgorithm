package com.YoungZz1k.DataStructure.Queue.PriorityQueue;

import com.YoungZz1k.DataStructure.Queue.Queue;

/**
 * 基于无序数组实现的优先队列
 * @param <E>
 */
public class PriorityQueue1<E extends Priority> implements Queue<E> {


    private Priority[] array;
    private int size;

    public PriorityQueue1(int capacity) {
        array = new Priority[capacity];
    }

    @Override
    public boolean offer(E value) {
        if (isFull()){
            return false;
        }
        array[size] = value;
        size++;
        return true;
    }

    /**
     * 返回优先级最高的索引值
     * @return
     */
    private int selectMax(){
        int max = 0;
        for (int i = 1; i < size; i++){
            if (array[i].priority() > array[max].priority()){
                max = i;
            }
        }
        return max;
    }

    @Override
    public E pull() {
        if (isEmpty()){
            return null;
        }
        int max = selectMax();
        E e =(E) array[max];
        remove(max);
        return e;
    }

    private void remove(int index) {
        if (index < size - 1){
            // 移动
            System.arraycopy(array,index + 1,array,index,size - 1 -index);
        }
        size--;
    }

    @Override
    public E peek() {
        if (isEmpty()){
            return null;
        }
        int max = selectMax();
        return (E) array[max];
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
