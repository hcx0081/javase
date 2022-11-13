package com.javase.function;

import org.junit.Test;

import java.util.function.Consumer;

/**
 * @Description:
 */
public class ConsumerTest {
    Integer sum = 500;
    
    @Test
    public void ConsumerTest() {
        consume(100);
        System.out.println(sum);
        
        /* Java 8.0 */
        consumeByConsumer(100, new Consumer<Integer>() {
            @Override
            public void accept(Integer money) {
                sum -= money;
            }
        });
        System.out.println(sum);
        
        consumeByConsumer(100, money -> this.sum -= money);
        System.out.println(sum);
    }
    
    void consume(Integer money) {
        this.sum -= money;
    }
    
    void consumeByConsumer(Integer money, Consumer<Integer> consumer) {
        consumer.accept(money);
    }
}
