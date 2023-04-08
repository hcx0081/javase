package com.javase.aid;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * {@code @Description:}
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        
        // 创建5个线程并发执行任务，每一个线程执行完成任务之后countDown
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    // 执行任务
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName() + " 执行完成任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown(); // 计数减1
                }
            }).start();
        }
        // 等待所有线程运行完成
        try {
            latch.await();
            System.out.println("所有线程运行完成");
        } catch (
                InterruptedException e) {
            e.printStackTrace();
        }
    }
}