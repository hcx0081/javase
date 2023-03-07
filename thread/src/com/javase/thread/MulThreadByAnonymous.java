package com.javase.thread;

import static java.lang.Thread.sleep;

/**
 * {@code @Description:}
 */
public class MulThreadByAnonymous {
    public static void main(String[] args) {
        new Thread() {
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
        }.start();
        
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
        // 主线程正在运行
        // MyThread正在运行，线程名：Thread-0
        // 主线程正在运行
        // MyThread正在运行，线程名：Thread-0
    }
}