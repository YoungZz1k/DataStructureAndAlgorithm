package com.YoungZz1k.DataStructure.Arrays;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



public class TestDynamicArray {

    @Test
    @DisplayName("测试插入")
    public void test1(){
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2,5);

        for (int i = 0; i < 5; i++) {
            System.out.println(dynamicArray.get(i));
        }
    }

    @Test
    @DisplayName("测试遍历1")
    public void test2(){
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2,5);

        dynamicArray.foreach((element)->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试遍历2")
    public void test3(){
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2,5);


        for (Integer element : dynamicArray) { // hasNext
            System.out.println(element); // element = next()
        }
    }

    @Test
    @DisplayName("测试遍历3")
    public void test4(){
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2,5);

        dynamicArray.stream().forEach(element ->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试删除元素")
    public void test5(){
        DynamicArray dynamicArray = new DynamicArray();

        dynamicArray.addLast(1);
        dynamicArray.addLast(2);
        dynamicArray.addLast(3);
        dynamicArray.addLast(4);
        dynamicArray.add(2,5);

        dynamicArray.stream().forEach(element ->{
            System.out.println(element);
        });

        System.out.println("------------------------");
        System.out.println(dynamicArray.remove(2));
        System.out.println("------------------------");

        dynamicArray.foreach(element->{
            System.out.println(element);
        });
    }

    @Test
    @DisplayName("测试扩容")
    public void test6(){
        DynamicArray dynamicArray = new DynamicArray();
        for (int i = 0; i < 10; i++) {
            dynamicArray.add(i,i);
        }

        dynamicArray.stream().forEach(e->{
            System.out.println(e);
        });
    }
}
