package com.deng.generator;

import cn.hutool.core.io.FileUtil;

public class StaticGenerator {
    public static void copyFilesByRecursive(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }
}
