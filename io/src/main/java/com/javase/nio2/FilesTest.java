package com.javase.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Description:
 */
public class FilesTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\file\\1");
        System.out.println(Files.size(path));
        System.out.println(path.getNameCount());
    }
}
