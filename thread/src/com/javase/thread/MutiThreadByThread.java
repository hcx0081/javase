package com.javase.thread;

import static java.lang.Thread.sleep;

/**
 * @description:
 */
public class MutiThreadByThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        
        //myThread.run();//主线程执行该方法，该方法只是一个普通方法，没有开启一个新线程
        //MyThread正在运行，线程名：main
        //MyThread正在运行，线程名：main
        //MyThread正在运行，线程名：main
        
        myThread.start();//用于开启新线程，实现多线程，即主线程后面的代码和该进程一起运行
        while (true) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("主线程正在运行");
        }
        //主线程正在运行
        //MyThread正在运行，线程名：Thread-0
        //MyThread正在运行，线程名：Thread-0
        //主线程正在运行
        //主线程正在运行
        //MyThread正在运行，线程名：Thread-0
    }
}

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