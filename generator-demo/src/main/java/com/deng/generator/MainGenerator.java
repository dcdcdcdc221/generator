package com.deng.generator;

import com.deng.model.MainTemplateConfig;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class MainGenerator {
    public static void doGenerate(Object model) throws TemplateException, IOException {
        String projectPath = System.getProperty("user.dir");
        //整个项目的根路径
        File parentFile = new File(projectPath).getParentFile();
        //输入路径，getAbsolutePath 从File类型转换成String类型
        String inputPath = new File(projectPath,"generator-demo-projects/acm-template").getAbsolutePath();
        //输出路径
        String outputPath = projectPath;

        //生成静态文件
        StaticGenerator.copyFileByHutool(inputPath, outputPath);
        //生成动态文件
        String inputDynamicFilePath = projectPath + File.separator + "src/main/resources/templates/MainTemplate";
        String outputDynamicFilePath = projectPath + File.separator + "acm-template/src/com.yupi.acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamicFilePath,outputDynamicFilePath,model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("deng");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(mainTemplateConfig);
    }
}
