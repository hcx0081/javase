package com.javase.deadlock;

/**
 * {@code @Description:}
 */
public class DeadLockTest {
    public static void main(String[] args) {
        Thread deadLockThread1 = new DeadLockThread(true);
        Thread deadLockThread2 = new DeadLockThread(false);
        deadLockThread1.setName("线程A");
        deadLockThread2.setName("线程B");
        
        deadLockThread1.start();
        deadLockThread2.start();
    }
}

class DeadLockThread extends Thread {
    // 加上static表示所有类对象共享这个成员
    private static Object lock1 = new Object();
    private static Object lock2 = new Object();
    boolean flag;
    
    public DeadLockThread(boolean flag) {
        this.flag = flag;
    }
    
    @Override
    public void run() {
        if (flag) {
            // 获得锁1
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + "进入1");
                // 尝试获得锁2
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "进入2");
                }
            }
        } else {
            // 获得锁2
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + "进入3");
                // 尝试获得锁1
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "进入4");
                }
            }
        }
    }
}