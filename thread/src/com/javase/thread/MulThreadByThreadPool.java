package com.javase.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 */
class MyThreadPool implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThreadPool正在运行，线程名：" + Thread.currentThread().getName());
        }
    }
}

public class MulThreadByThreadPool {
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        
        // 开启线程
        executorService.execute(myThreadPool);
        // 关闭线程池
        executorService.shutdown();
        
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程正在运行");
        }
        // 主线程正在运行
        // MyThreadPool正在运行，线程名：pool-1-thread-1
        // 主线程正在运行
        // MyThreadPool正在运行，线程名：pool-1-thread-1
        // 主线程正在运行
        // MyThreadPool正在运行，线程名：pool-1-thread-1
    }
}