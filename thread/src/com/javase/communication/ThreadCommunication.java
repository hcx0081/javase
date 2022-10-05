package com.javase.communication;

/**
 * @Description:
 */
class Number implements Runnable {
    private int number = 1;
    private Object lock = new Object();
    
    /**
     * wait()、notify()、notifyAll()
     * 这三个方法必须使用在同步代码块、同步方法中，且调用对象必须是同步代码块、同步方法中的锁对象
     * 这三个方法是Object类中的方法
     */
    @Override
    public void run() {
        while (true) {
            // synchronized (this) {
            synchronized (lock) {
                // 唤醒一个线程
                // notify();
                lock.notify();
                if (number <= 10) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "：" + (number++));
                } else {
                    break;
                }
                try {
                    // 阻塞当前线程
                    // wait();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class ThreadCommunication {
    public static void main(String[] args) {
        Number number = new Number();
        new Thread(number).start();
        new Thread(number).start();
        new Thread(number).start();
    }
}