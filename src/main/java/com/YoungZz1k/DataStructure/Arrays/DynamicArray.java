package com.YoungZz1k.DataStructure.Arrays;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * 动态数组
 */
public class DynamicArray implements Iterable<Integer>{

    private int size = 0; // 逻辑大小
    private int capacity = 8; // 容量
    private int[] array = {};



    /**
     * 最后面插入
     * @param element
     */
    public void addLast(int element) {
//        array[size] = element;
//        size++;
        add(size, element);
    }

    /**
     * 添加元素 合并上一个方法
     * @param index
     * @param element
     */
    public void add(int index, int element) {

        checkAndGrow();

        if (index >= 0 && index < size) {
            //空出index的位置
            /**
             * array        要拷贝的数组
             * index        拷贝开始的位置
             * array        拷贝到哪里去
             * index + 1    目标起始位置
             * size - index 要拷贝的元素个数
             */
            System.arraycopy(array, index, array, index + 1, size - index);
        }else if (index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        array[index] = element;
        size++;
    }

    /**
     * 数组扩容
     */
    public void checkAndGrow() {
        //  容量检查
        if(size == 0){
            array = new int[capacity];
        }else if(size == capacity){
            // 进行扩容
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,newArray,0,size);
            array = newArray;
        }
    }

    /**
     * 根据索引获取元素
     * @param index
     * @return
     */
    public int get(int index){
        if(index >= 0 && index <= (size - 1)){
            return array[index];
        }else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * 遍普通历
     */
    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
//            System.out.println(array[i]);
            consumer.accept(array[i]);
        }
    }

    /**
     * 迭代器遍历
     * @return
     */
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int i = 0;
            @Override
            public boolean hasNext() { // 有没有下一个元素
                return i < size;
            }

            @Override
            public Integer next() { // 返回当前元素并移动到下一个元素
                return array[i++];
            }
        };
    }

    /**
     * stream流遍历
     * @return
     */
    public IntStream stream(){

        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }

    /**
     * 删除元素
     * @param index
     * @return
     */
    public int remove(int index){ // [0,size-1]
        int removed = array[index];
        if (index < size -1 ){
            System.arraycopy(array,index + 1,array,index,size - index - 1);
        }
        size--;
        return removed;
    }
    
}
