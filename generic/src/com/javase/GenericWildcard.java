package com.javase;

import java.util.List;

/**
 * {@code @Description:}
 */
public class GenericWildcard {
    public static void main(String[] args) {
        Plate<? extends Fruit> plate = new Plate<>();
    }
}

class Plate<T> {
    private List<T> list;
    
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