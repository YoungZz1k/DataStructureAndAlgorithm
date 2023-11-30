package com.YoungZz1k.DataStructure.Queue.BlockingQueue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 双锁实现阻塞队列
 * @param <E>
 */
public class BlockingQueue2<E> implements BlockingQueue<E> {

    private final E[] array;
    private AtomicInteger size = new AtomicInteger();
    private int head;
    private int tail;

    public BlockingQueue2(int capacity) {
        array = (E[]) new Object[capacity];
    }

    private ReentrantLock tailLock = new ReentrantLock();
    private Condition tailWaits = tailLock.newCondition();

    private ReentrantLock headLock = new ReentrantLock();

    private Condition headWaits = headLock.newCondition();

    @Override
    public void offer(E o) throws InterruptedException {
        tailLock.lockInterruptibly();
        int c;//  添加前的元素个数
        try {
            // 队列满进行等待
            while (isFull()) {
                tailWaits.await();
            }
            // 不满入队
            array[tail] = o;
            if ((++tail) == array.length) {
                tail = 0;
            }
            c = size.getAndIncrement();
            if (c + 1 < array.length){
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }
        // 唤醒等待非空的poll线程
        if (c == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }

    }

    @Override
    public boolean offer(E o, long timeout) throws InterruptedException {
        tailLock.lockInterruptibly();
        int c;//  添加前的元素个数
        try {
            long nanos = TimeUnit.MILLISECONDS.toNanos(timeout);
            // 队列满进行等待
            while (isFull()) {
                if (nanos <= 0){
                    return false;
                }
                nanos = tailWaits.awaitNanos(timeout);
            }
            // 不满入队
            array[tail] = o;
            if ((++tail) == array.length) {
                tail = 0;
            }
            c = size.getAndIncrement();
            if (c + 1 < array.length){
                tailWaits.signal();
            }
        } finally {
            tailLock.unlock();
        }
        // 唤醒等待非空的poll线程
        if (c == 0) {
            headLock.lock();
            try {
                headWaits.signal();
            } finally {
                headLock.unlock();
            }
        }
        return true;
    }

    @Override
    public E poll() throws InterruptedException {
        E e;
        int c;// 取走前的元素个数
        headLock.lockInterruptibly();
        try {
            // 队列为空
            while (isEmpty()) {
                headWaits.await();
            }
            // 队列不空
            e = array[head];
            array[head] = null;
            if ((++head) == array.length) {
                head = 0;
            }
            c = size.getAndDecrement();

            if (c > 1){
                headWaits.signal();
            }

        } finally {
            headLock.unlock();
        }
        // 唤醒等待不满的offer线程
        if (c == array.length){
            tailLock.lock();
            try {
                tailWaits.signal();
            } finally {
                tailLock.unlock();
            }
        }

        return e;
    }

    private boolean isEmpty() {
        return size.get() == 0;
    }

    private boolean isFull() {
        return size.get() == array.length;
    }

    @Override
    public String toString() {
        return "BlockingQueue1{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue2<String> blockingQueue = new BlockingQueue2<>(3);

        new Thread(() -> {
            try {
                System.out.println(System.currentTimeMillis() + " begin");
                blockingQueue.offer("任务1");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务2");
                System.out.println(blockingQueue);
                blockingQueue.offer("任务3");
                System.out.println(blockingQueue);
                blockingQueue.poll();
                blockingQueue.offer("任务4");
                System.out.println(blockingQueue);
                System.out.println(System.currentTimeMillis() + " end ");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "生产者").start();

        Thread.sleep(2000);
        blockingQueue.poll();
        System.out.println(blockingQueue);
    }
}
