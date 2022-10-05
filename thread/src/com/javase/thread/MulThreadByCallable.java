package com.javase.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @Description:
 */
class MyCallable implements Callable<Object> {
    @Override
    public Object call() throws Exception {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyCallable正在运行，线程名：" + Thread.currentThread().getName());
        }
    }
}

public class MulThreadByCallable {
    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask<Object> futureTask = new FutureTask<>(myCallable);
        // 因为FutureTask实现了Runnable接口，所以可以传入该构造方法
        Thread thread = new Thread(futureTask);
        
        /* 调用start()方法表示开启新线程，实现多线程，即主线程和该线程一起运行 */
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
        // MyCallable正在运行，线程名：Thread-0
        // 主线程正在运行
        // MyCallable正在运行，线程名：Thread-0
        // 主线程正在运行
        // MyCallable正在运行，线程名：Thread-0
    }
}