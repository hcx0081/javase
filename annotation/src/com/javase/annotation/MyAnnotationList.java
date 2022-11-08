package com.javase.annotation;

import java.lang.annotation.Inherited;

/**
 * @Description:
 */
@Inherited
public @interface MyAnnotationList {
    MyAnnotation[] value();
}
