package com.javase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * {@code @Description:}
 */
public class Regexp {
    public static void main(String[] args) {
        String content = "JDK（Java Development Kit）称为Java开发包或Java开发工具，" +
                "是一个编写Java的Applet小程序和应用程序的程序开发环境。" +
                "JDK是整个Java的核心，" +
                "包括了Java运行环境（Java Runtime Environment），一些Java工具和Java的核心类库（Java API）。" +
                "不论什么Java应用服务器实质都是内置了某个版本的JDK。" +
                "主流的JDK是Sun公司发布的JDK，" +
                "除了Sun之外，还有很多公司和组织都开发了自己的JDK，" +
                "例如，IBM公司开发的JDK，BEA公司的Jrocket，还有GNU组织开发的JDK。";
        
        /*提取段落中的字母*/
        /*提取段落中的数字*/
        /*提取段落中的字母和数字*/
        //1.传统方法，使用遍历，代码量大，效率不高
        
        //2.使用正则表达式
        
        //Pattern pattern = Pattern.compile("[a-zA-Z]+");
        //Pattern pattern = Pattern.compile("[0-9]+");
        Pattern pattern = Pattern.compile("([a-zA-Z]+)|([0-9]+)");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
        
        
    }
}