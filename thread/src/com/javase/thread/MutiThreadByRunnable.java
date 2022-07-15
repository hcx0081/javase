package com.javase.thread;

import static java.lang.Thread.sleep;

/**
 * @description:
 */
public class MutiThreadByRunnable {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        
        thread.start();
        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程正在运行");
        }
        //主线程正在运行
        //MyThread正在运行，线程名：Thread-1
        //主线程正在运行
        //MyThread正在运行，线程名：Thread-1
        //主线程正在运行
        //MyThread正在运行，线程名：Thread-1
    }
}

class MyRunnable implements Runnable {
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyRunnable正在运行，线程名：" + Thread.currentThread().getName());
        }
    }
}
