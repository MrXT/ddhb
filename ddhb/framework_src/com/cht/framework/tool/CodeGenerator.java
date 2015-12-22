package com.cht.framework.tool;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
/**
 * 代码生成器
 * @author WJK
 * @version 2015-03
 */
public class CodeGenerator {
    
	public static void main(String[] args) throws Exception {
		mybatisGenerator();
		freemarkerGenerator(true);
//		velocityGenerator(); 
		System.out.println("Generator finshed");
	}

    /** 功能:通过在generator.properties中指定的tableName生成对应domain、xml及DAO */
    private static void mybatisGenerator() throws Exception {
        List<String> configs = new ArrayList<String>();
		boolean overwrite = true;
		//File configFile = new File("generatorConfig.xml");
		InputStream  configInputStream = CodeGenerator.class.getResourceAsStream("generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(configs);
		Configuration config = cp.parseConfiguration(configInputStream);
		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, configs);
		myBatisGenerator.generate(null);
    }
    
    /** 
     * 功能:根据模板生成contorller、service及serviceImpl代码模板
     * @param isCreateJsp 是否生成页面(注意 当需要生成页面时需要与mybatisGenerator方法分开执行)
     */
    private static void freemarkerGenerator(boolean isCreateJsp) throws IOException {
        FreeMarkerGenerator fmg = new FreeMarkerGenerator(isCreateJsp);
        fmg.generate();
    }
    
//    /** 功能:根据模板生成contorller、service及serviceImpl代码模板  */
//    private static void velocityGenerator() throws IOException {
//        VelocityGenerator vg = new VelocityGenerator();
//        vg.generate();
//    }
}
