package com.deng.generator;

import com.deng.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DynamicGenerator {
    @SneakyThrows
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        //File.separator是Java中的一个静态常量，它标识操作系统的路径分隔符
        String inputPath = projectPath +File.separator +"src/main/resources/template/MainTemplate.java.ftl";
        String outputPath = projectPath +File.separator +"MainTemplate.java";
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("deng");
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");
        doGenerate(inputPath,outputPath,mainTemplateConfig);

    }


    public static void doGenerate(String inputPath,String outputPath,Object model) throws IOException, TemplateException{
        //new 出 Configuration 对象，参数为 FreeMarker 版本号
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_22);

        //指定模板文件所在路径
        configuration.setDirectoryForTemplateLoading(new File(inputPath));

        //设置模板文件使用的字符集
        configuration.setDefaultEncoding("UTF-8");

        //创建模板对象，加载指定模板
        String TemplateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(TemplateName);

        //创建数据模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setAuthor("deng");

        //不适用循环
        mainTemplateConfig.setLoop(false);
        mainTemplateConfig.setOutputText("求和结果：");

        //生成
        FileWriter out = new FileWriter(outputPath);
        template.process(model,out);
        //关闭流
        out.close();
    }
}
