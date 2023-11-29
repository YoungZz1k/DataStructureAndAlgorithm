package com.YoungZz1k.DataStructure.Queue.BlockingQueue;

import org.junit.jupiter.api.Test;

public class TestBlockingQueue1 {

    @Test
    void test() {
        BlockingQueue1<String> blockingQueue = new BlockingQueue1<>(3);

        new Thread(()->{
            try {
                System.out.println(System.currentTimeMillis() + " begin");
                blockingQueue.offer("任务1");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务2");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务3");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务4",3000);
                System.out.println(blockingQueue);
                System.out.println(System.currentTimeMillis() + " end ");
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        },"生产者").start();
    }
}
