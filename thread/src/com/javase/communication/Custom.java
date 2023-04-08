package com.javase.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * {@code @Description:}
 */
class Share {
    // 1：A
    // 2：B
    // 3：C
    int flag = 1;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    
    public void print1() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 1) {
                c1.await();
            }
            System.out.println(Thread.currentThread().getName() + "打印：1");
            // 修改标志并且通知线程B
            flag = 2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public void print2() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 2) {
                c2.await();
            }
            System.out.println(Thread.currentThread().getName() + "打印：2");
            // 修改标志并且通知线程C
            flag = 3;
            c3.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public void print3() throws InterruptedException {
        lock.lock();
        try {
            while (flag != 3) {
                c3.await();
            }
            System.out.println(Thread.currentThread().getName() + "打印：3");
            // 修改标志并且通知线程A
            flag = 1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}

public class Custom {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(() -> {
            try {
                while (true) {
                    share.print1();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A").start();
        new Thread(() -> {
            try {
                while (true) {
                    share.print2();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B").start();
        new Thread(() -> {
            try {
                while (true) {
                    share.print3();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "C").start();
    }
}