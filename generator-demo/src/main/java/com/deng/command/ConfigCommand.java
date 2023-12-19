package com.deng.command;

import cn.hutool.core.util.ReflectUtil;
import com.deng.model.MainTemplateConfig;
import picocli.CommandLine.*;

import java.lang.reflect.Field;

@Command(name = "config",description = "查看参数信息",mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        //输出/实现config的逻辑
        System.out.println("查看参数信息");
        
        //通过反射获取所有字段的参数
        for (Field field : ReflectUtil.getFields(MainTemplateConfig.class)) {
            System.out.println("字段名称"+field.getName());
            System.out.println("字段类型"+field.getType());
            System.out.println("--------------------------------");
        }


    }
}
