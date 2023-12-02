package com.YoungZz1k.DataStructure.Heap;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 大顶堆
 */
public class MaxHeap {
    int[] array;
    int size;

    public int getSize() {
        return size;
    }

    public MaxHeap(int capacity) {
        array = new int[capacity];
    }

    public MaxHeap(int[] array) {
        this.array = array;
        this.size = array.length;
        heapify();
    }

    /**
     * 建堆
     */
    private void heapify() {
        // 找到最后一个非叶子节点
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(i);
        }
    }


    /**
     * 将parent处元素下潜直到没有孩子或没有孩子比他大
     *
     * @param parent
     */
    private void down(int parent) {
        // 左右孩子
        int left = parent * 2 + 1;
        int right = left + 1;
        // 假定初始父亲就是最大
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {// 找到了更大的孩子
            swap(max, parent);
            down(max);
        }
    }

    private void swap(int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    /**
     * 返回堆顶元素
     *
     * @return 堆顶元素
     */
    public int peek() {
        if (array.length == 0) {
            throw new RuntimeException("数组为空");
        }
        return array[0];
    }

    /**
     * 删除堆顶元素
     *
     * @return 返回堆顶元素
     */
    public int poll() {
        int e = array[0];
        swap(0, size - 1);
        size--;
        down(0);
        return e;
    }

    /**
     * 删除指定索引位置元素
     *
     * @param index 索引
     * @return 返回删除元素
     */
    public int poll(int index) {
        int e = array[index];
        swap(index, size - 1);
        size--;
        down(index);
        return e;
    }

    /**
     * 替换堆顶元素
     *
     * @param element
     */
    public void replace(int element) {
        array[0] = element;
        down(0);
    }

    /**
     * 上浮 直到遇到比offered元素小的节点
     *
     * @param offered
     */
    private void up(int offered) {
        int child = size;
        while (child > 0){
            int parent = (child - 1) / 2;
            if (array[parent] < offered){
                array[child] = array[parent];
            }else{
                break;
            }
            child = parent;
        }
        array[child] = offered;
    }

    /**
     * 堆尾部添加元素
     *
     * @param offered
     * @return
     */
    public boolean offer(int offered) {
        if (size == array.length) {
            return false;
        }
        up(offered);
        size++;
        return true;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 3, 5, 7, 9, 4, 2, 8};
        MaxHeap maxHeap = new MaxHeap(array);
        // 堆排序 每次把堆顶交换到最底下，然后对堆顶元素做下潜恢复堆
        while (maxHeap.size > 1){
            maxHeap.swap(0,maxHeap.size - 1);
            maxHeap.size--;
            maxHeap.down(0);
        }
        System.out.println(Arrays.toString(array));
    }
}
