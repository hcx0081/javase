package com.javase.aid;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * {@code @Description:}
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        // 3个停车位
        Semaphore semaphore = new Semaphore(3);
        
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 获得许可信号
                    semaphore.acquire();
                    
                    System.out.println(Thread.currentThread().getName() + " 进行停车");
                    TimeUnit.SECONDS.sleep((long) (Math.random() * 10));
                    System.out.println(Thread.currentThread().getName() + " 停车结束，归还停车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放许可信号
                    semaphore.release();
                }
            }, i + "号汽车").start();
        }
    }
}