package com.javase.annotation;

/**
 * {@code @Description:}
 */
// @MyAnnotationList({@MyAnnotation("hello"), @MyAnnotation("world")})
@MyAnnotation("hello")
@MyAnnotation("world")
public class mainTest {
    public static void main(@MyAnnotation("hi") String[] args) {
    
    }
}