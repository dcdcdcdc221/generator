package com.deng.command;


import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "deng",version = "1.0",mixinStandardHelpOptions = true)
public class CommandExecutor implements Runnable{

    private final CommandLine commandLine(){
        return new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand());
    }
    @Override
    public void run() {
        //不输入子命令时给出友好提示
        System.out.println("输入--help 查看");
    }

    public Integer doExecute(String[] args) {
        return new CommandLine(new ConfigCommand()).execute(args);
    }
}
