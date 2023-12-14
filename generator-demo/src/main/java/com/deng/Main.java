package com.deng;

import java.io.File;

import static com.deng.generator.StaticGenerator.copyFileByHutool;

public class Main {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "generator-demo-projects/src/com/yupi/acm").getAbsolutePath();
        String outputPath = projectPath;
        copyFileByHutool(inputPath,outputPath);

    }
}