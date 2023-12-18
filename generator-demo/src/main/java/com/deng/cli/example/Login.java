package com.deng.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.*;

import java.util.concurrent.Callable;

@Command(name = "ASCIIArt",version = "ASCIIArt 1.0",mixinStandardHelpOptions = true)
public class Login implements Callable<Integer> {
    @Option(names = {"-u", "--user"}, description = "User Name")
    String user;

    //interactive标识该选项支持交互式输入,如果是以jar包运行的话，用户的输入是不会在控制台显示的
    //使用echo = true来显示用户输入
    @Option(names = {"-p", "--password"}, description = "Pass Word", interactive = true,echo = true)
    String password;
    @Override
    public Integer call() throws Exception {
        System.out.println("password = "+password);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u","user123","-p");
    }
}
