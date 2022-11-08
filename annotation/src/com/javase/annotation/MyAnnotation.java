package com.javase.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;

/**
 * @Description: 自定义注解
 */
@Inherited
@Repeatable(MyAnnotationList.class)
public @interface MyAnnotation {
    String value();
}
