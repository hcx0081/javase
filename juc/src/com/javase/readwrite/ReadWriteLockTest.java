package com.javase.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * {@code @Description:}
 */
class MyCache {
    private volatile Map<String, Object> map = new HashMap<>();
    
    // 只创建一个锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    
    public void put(String key, Object value) throws InterruptedException {
        Lock lock = readWriteLock.writeLock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：正在进行写操作");
            TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "：结束写操作");
        } finally {
            lock.unlock();
        }
    }
    
    public Object get(String key) throws InterruptedException {
        Lock lock = readWriteLock.readLock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "：正在进行读操作");
            TimeUnit.SECONDS.sleep((long) (Math.random() * 5));
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() + "：结束读操作：" + result);
            return result;
        } finally {
            lock.unlock();
        }
    }
}

public class ReadWriteLockTest {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        // 创建5个线程写数据
        for (int i = 0; i < 5; i++) {
            final int count = i;
            new Thread(() -> {
                try {
                    myCache.put(count + "", count + "");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
        
        // 创建5个线程读数据
        for (int i = 0; i < 5; i++) {
            final int count = i;
            new Thread(() -> {
                try {
                    myCache.get(count + "");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}