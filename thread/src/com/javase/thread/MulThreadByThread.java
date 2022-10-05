package com.javase.thread;

import static java.lang.Thread.sleep;

/**
 * @description:
 */
class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread正在运行，线程名：" + Thread.currentThread().getName());
        }
    }
}

public class MulThreadByThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        
        /* 直接调用run()方法表示主线程执行该方法，该方法只是一个普通方法，没有开启一个新线程 */
        /* myThread.run(); */
        // MyThread正在运行，线程名：main
        // MyThread正在运行，线程名：main
        // MyThread正在运行，线程名：main
        
        /* 调用start()方法表示开启新线程，实现多线程，即主线程和该线程一起运行 */
        myThread.start();
        
        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程正在运行");
        }
        // 主线程正在运行
        // MyThread正在运行，线程名：Thread-0
        // MyThread正在运行，线程名：Thread-0
        // 主线程正在运行
        // 主线程正在运行
        // MyThread正在运行，线程名：Thread-0
    }
}