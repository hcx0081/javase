package com.javase.readwrite;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * {@code @Description:}
 */
public class Downgrade {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        
        // 写锁上锁
        writeLock.lock();
        System.out.println("w");// 此时只有一个线程
        
        // 读锁上锁
        readLock.lock();
        System.out.println("r");
        
        // 读锁解锁
        readLock.unlock();
        
        
        // 写锁解锁
        writeLock.unlock();
    }
}