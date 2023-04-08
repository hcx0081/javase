package com.javase.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@code @Description:}
 */
class CountByCondition {
    int count = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    
    
    public void add() throws InterruptedException {
        // 上锁
        lock.lock();
        try {
            while (count != 0) {
                condition.await();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：" + count);
            condition.signal();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
    
    public void sub() throws InterruptedException {
        // 上锁
        lock.lock();
        try {
            while (count != 1) {
                condition.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName() + "：" + count);
            condition.signal();
        } finally {
            // 解锁
            lock.unlock();
        }
    }
}


public class SpuriousWakeupByCondition {
    public static void main(String[] args) {
        CountByCondition countByCondition = new CountByCondition();
        new Thread(() -> {
            try {
                while (true) {
                    countByCondition.add();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A").start();
        new Thread(() -> {
            try {
                while (true) {
                    countByCondition.sub();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B").start();
        new Thread(() -> {
            try {
                while (true) {
                    countByCondition.add();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "C").start();
        new Thread(() -> {
            try {
                while (true) {
                    countByCondition.sub();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "D").start();
    }
}