package com.javase.communication;

/**
 * {@code @Description:}
 */
class Number implements Runnable {
    private int number = 1;
    private Object obj = new Object();
    
    /**
     * wait()、notify()、notifyAll()
     * 这三个方法必须使用在同步代码块、同步方法中，并且调用对象必须是同步代码块、同步方法中的锁
     * 这三个方法是Object类的方法
     */
    @Override
    public void run() {
        while (true) {
            // synchronized (this) {
            synchronized (obj) {
                // 唤醒一个线程
                // notify();
                obj.notify();
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
                    obj.wait();
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