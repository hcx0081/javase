package com.javase.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * {@code @Description:}
 */
public class CompletableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture.runAsync(() -> {
            System.out.println(1);
        });
        
        CompletableFuture<Integer> supplyAsync = CompletableFuture.supplyAsync(() -> 1);
        System.out.println(supplyAsync.get());
        // supplyAsync.whenCompleteAsync()
    }
}