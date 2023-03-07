package com.javase.wrap;

import java.io.File;

/**
 * {@code @Description:}
 */
public class FileTest {
    public static void main(String[] args) {
        /* 要求dest不能存在于磁盘中，因为不确定是否覆盖 */
        File fileSrc = new File("E:\\hello");
        File fileDest = new File("E:\\hi\\hi.jpg");
        // boolean b = fileSrc.renameTo(fileDest);
        // System.out.println(b);
    
        System.out.println(fileSrc.canRead());
        System.out.println(fileSrc.canWrite());
        System.out.println(fileSrc.isHidden());
    
        System.out.println(fileDest.canRead());
        System.out.println(fileDest.canWrite());
        System.out.println(fileDest.isHidden());
    }
}