package com.javase.thread;

/**
 * {@code @Description:}
 */
class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyRunnable正在运行，线程名：" + Thread.currentThread().getName());
        }
    }
}

public class MulThreadByRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        
        /* 调用start()方法表示开启新线程，实现多线程，主线程和该线程一起运行 */
        thread.start();
        
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程正在运行");
        }
        // 主线程正在运行
        // MyRunnable正在运行，线程名：Thread-0
        // 主线程正在运行
        // MyRunnable正在运行，线程名：Thread-0
        // 主线程正在运行
        // MyRunnable正在运行，线程名：Thread-0
    }
}