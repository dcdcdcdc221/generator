package com.deng;

import com.deng.command.CommandExecutor;
import picocli.CommandLine;

import java.io.File;


public class Main {
    public static void main(String[] args) {
        /*String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        String inputPath = new File(parentFile, "generator-demo-projects/src/com/yupi/acm").getAbsolutePath();
        String outputPath = projectPath;
        copyFileByHutool(inputPath,outputPath);*/
        args = new String[]{"generate","-l","-a","-o"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecute(args);
    }
}