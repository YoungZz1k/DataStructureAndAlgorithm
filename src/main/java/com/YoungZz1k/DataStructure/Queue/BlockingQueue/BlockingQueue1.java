package com.YoungZz1k.DataStructure.Queue.BlockingQueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 单锁阻塞队列
 * @param <E>
 */
public class BlockingQueue1<E> implements BlockingQueue<E> {

    private final E[] array;
    private int size;
    private int head;
    private int tail;

    public BlockingQueue1(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock lock  = new ReentrantLock();
    private Condition headWaits = lock.newCondition();
    private Condition tailWaits = lock.newCondition();

    @Override
    public void offer(E o) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            while (isFull()){
                tailWaits.await();
            }
            array[tail] = o;
            if((++tail) == array.length){
                tail = 0;
            }
            size++;
            headWaits.signal();
        }finally {
            lock.unlock();
        }
    }

    @Override
    public boolean offer(E o, long timeout) throws InterruptedException {
        lock.lockInterruptibly();
        try{
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            while (isFull()){
                if (nanos <= 0){
                    return false;
                }
                nanos = tailWaits.awaitNanos(nanos);  // 等待多少纳秒
            }
            array[tail] = o;
            if((++tail) == array.length){
                tail = 0;
            }
            size++;
            headWaits.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    @Override
    public E poll() throws InterruptedException {
        lock.lockInterruptibly();
        try {
            while (isEmpty()){
                headWaits.await();
            }
            E e = array[head];
            array[head] = null;
            if ((++head) == array.length){
                head = 0;
            }
            size--;
            tailWaits.signal();
            return e;
        }finally {
            lock.unlock();
        }
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private boolean isFull(){
        return size == array.length;
    }

    @Override
    public String toString() {
        return "BlockingQueue1{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
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

        Thread.sleep(2000);
        blockingQueue.poll();
    }
}
