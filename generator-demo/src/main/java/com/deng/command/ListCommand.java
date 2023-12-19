package com.deng.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.*;

import java.io.File;
import java.util.List;

/**
 * 文件
 */
@Command(name = "list", description="查看文件列表",mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{

    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        //整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        //输入路径
        String inputPath = new File(parentFile, "generator-demo-projects/src/com/yupi/acm/MainTemplate.java").getAbsolutePath();
        //loopFiles遍历所有文件（包括子目录）
        List<File> files = FileUtil.loopFiles(inputPath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
