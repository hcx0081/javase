package com.javase.sale;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 */
class WindowByLockSecurity implements Runnable {
    private int ticket = 100;
    // 如果是继承Thread类方式则需要使用static修饰
    private /* static */ ReentrantLock lock = new ReentrantLock();
    
    @Override
    public void run() {
        while (true) {
            try {
                // 加锁
                lock.lock();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket <= 0) {
                    System.out.println("售罄");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "窗口卖了一张票，剩余：" + (--ticket) + "票");
            } finally {
                // 解锁
                lock.unlock();
            }
        }
    }
}

public class TicketWindowByLockSecurity {
    public static void main(String[] args) {
        WindowByLockSecurity window = new WindowByLockSecurity();
        new Thread(window).start();
        new Thread(window).start();
        new Thread(window).start();
    }
}