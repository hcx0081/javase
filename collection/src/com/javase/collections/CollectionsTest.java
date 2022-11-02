package com.javase.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList src = new ArrayList();
        src.add(100);
        src.add(101);
        src.add(102);
        
        /* ArrayList dest = new ArrayList();
        Collections.copy(dest, src);// 直接使用会报错：Source does not fit in dest，原因：src的元素个数必须小于等于dest的元素个数 */
        
        List dest = Arrays.asList(new Object[src.size()]);// 占位，元素有默认值
        Collections.copy(dest, src);
        System.out.println(dest);
    }
}
