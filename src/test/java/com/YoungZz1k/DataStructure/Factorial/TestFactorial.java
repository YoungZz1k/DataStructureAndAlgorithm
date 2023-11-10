package com.YoungZz1k.DataStructure.Factorial;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;


public class TestFactorial {

    /**
     * 递归阶乘测试
     */
    @Test
    @DisplayName("递归阶乘")
    public void test1() {
        System.out.println(Factorial.f(5));
    }


    /**
     * 递归输出逆序字符串
     */
    @Test
    @DisplayName("逆序输出字符串递归")
    public void test2() {
        Factorial.ReversePrintString(0, "abcd");
    }

    /**
     * 递归二分查找
     */
    @Test
    @DisplayName("递归二分查找")
    public void test3() {
        int[] a = {1, 2, 5, 8, 99, 333, 666, 777, 2344};
        System.out.println(Factorial.search(a, 99, 0, a.length - 1));
    }

    /**
     * 递归冒泡排序
     */
    @Test
    @DisplayName("冒泡排序")
    public void test4() {
        int[] a = {90, 444, 99, -8, 99, -333, 9, 7, -2344};
        System.out.println(Arrays.toString(a));
        Factorial.bubbleSort(a, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 递归插入排序
     */
    @Test
    @DisplayName("插入排序")
    public void test5() {
        int[] a = {90, 444, 99, -8, 99, -333, 9, 7, -2344};
        System.out.println(Arrays.toString(a));
        Factorial.insertionSort(a, 1);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 斐波那契数列 多路递归
     */
    @Test
    @DisplayName("斐波那契数列")
    public void test6(){
        System.out.println(Factorial.fibonacci(8));
    }
}
