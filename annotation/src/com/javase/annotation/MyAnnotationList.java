package com.javase.annotation;

import java.lang.annotation.Inherited;

/**
 * {@code @Description:}
 */
@Inherited
public @interface MyAnnotationList {
    MyAnnotation[] value();
}