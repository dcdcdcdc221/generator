package com.deng.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.*;

/**
 * run通过实现Runnable方法或者Callable接口的类
 * 使用@Command注解标记该类，并为其命名，使用mixinStandardHelpOptions = true，属性可以给应用程序自动添加--version，--help
 */
@Command(name = "ASCIIArt",version = "ASCIIArt 1.0",mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable{

    //@Option(name = "")注解 将字段设置为命令行选项，可以设置名称和描述
    //此注解支持多选项，只需将后面的int[] fontSize设置为数组即可
    @Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    //@Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
    //设置为命令行参数，可以设置默认值,还可以有一个参数 require为true要求必填
    @Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };
    @Override
    public void run() {
        System.out.println("fontSize=" + fontSize);
        System.out.println("words ="+String.join(",",words));
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }
}