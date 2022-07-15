package com.javase;

import java.util.List;

/**
 * @description:
 */
public class GenericWildcard {
    public static void main(String[] args) {
    
    }
}

class Plate<T> {
    private List<T> list;
    
    public Plate() {
    }
    
    public void add(T item) {
        list.add(item);
    }
    
    public T get() {
        return list.get(0);
    }
}

class Fruit {

}

class Apple extends Fruit {

}

class Banana extends Fruit {

}

class Orange extends Fruit {

}