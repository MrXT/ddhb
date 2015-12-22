package com.cht.framework.tool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.cht.framework.core.common.Constants;
import com.cht.framework.core.util.CommonUtils;
import com.cht.framework.core.util.DateUtils;
/**
 * Velocity工具类
 * Function: 用于根据模板生成contorller,service及serviceImpl代码模板.
 * @author YXQ
 * @version 2015年3月31日
 */
public class VelocityGenerator {
    /** Controller模板*/
    private final static int VM_TYPE_CONTROLLER = 1;
    /** Service模板*/
    private final static int VM_TYPE_SERVICE = 2;
    /** ServiceImpl模板*/
    private final static int VM_TYPE_SERVICEIMPL = 3;
    /** 参数获取路径 */
    private final static String PARAMS_PATH = "configs/properties/generator.properties";
    /** 模板路径*/
    private final static String TEMPLATE_PATH = "configs/template/vm";

    private static VelocityBean bean = new VelocityBean();

    public void generate() {
        // 获取参数
        Properties properties = new Properties();
        InputStream in;
        try {
            in = new BufferedInputStream(new FileInputStream(PARAMS_PATH));
            properties.load(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String modulePackage = properties.getProperty("module.package");
        String domainPackage = properties.getProperty("domain.package");
        String entityName = properties.getProperty("entity.name");

        // 初始化参数bean
        bean.setEntityName(entityName);
        bean.setDomainUrl(domainPackage);
        bean.setModuleUrl(modulePackage);
        bean.setLowerEntityName(CommonUtils.toLowerInitial(entityName));
        bean.setModuleName(modulePackage.substring(modulePackage.lastIndexOf(".")+1));
        bean.setAuthName(System.getProperty("user.name"));
        bean.setCreateDate(DateUtils.toShortDateString(new Date()));
        
        // 生成代码
        generateFile(VM_TYPE_CONTROLLER,bean);
        generateFile(VM_TYPE_SERVICE,bean);
        generateFile(VM_TYPE_SERVICEIMPL,bean);
    }
    /**
     * 
     * 功能:(这里用一句话描述这个方法的作用). <br/>
     * @author YXQ
     * @param vmType 模板类型
     * @param bean
     */
    private void generateFile(int vmType, VelocityBean bean) {
        String vmTypeName = "";
        String fileSavePath = "";
        switch(vmType){
            case VM_TYPE_CONTROLLER:
                vmTypeName = "Controller";
                fileSavePath = "src/"+bean.getModuleUrl().replace(".", "/")+"/web/controller/";
                break;
            case VM_TYPE_SERVICE:
                vmTypeName = "Service";
                fileSavePath = "src/"+bean.getModuleUrl().replace(".", "/")+"/service/";
                break;
            case VM_TYPE_SERVICEIMPL:
                vmTypeName = "ServiceImpl";
                fileSavePath = "src/"+bean.getModuleUrl().replace(".", "/")+"/service/impl/";
                break;
            default:
                break;
        }
        try {
            File filePath = new File(fileSavePath);
            FileUtils.forceMkdir(filePath);
            String fileName = fileSavePath + bean.getEntityName() + vmTypeName+".java";
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            //创建Velocity引擎
            VelocityEngine velocityEngine = new VelocityEngine();
            velocityEngine.setProperty("input.encoding", Constants.DEFAULT_WEB_ENCODING);
            velocityEngine.setProperty("output.encoding", Constants.DEFAULT_WEB_ENCODING);
            velocityEngine.init();
            //锁定模板文件
            Template template = velocityEngine.getTemplate(TEMPLATE_PATH+"/"+vmTypeName+".vm");
            VelocityContext velocityContext = new VelocityContext();
            velocityContext.put("bean", bean);
            StringWriter stringWriter = new StringWriter();
            template.merge(velocityContext, stringWriter);
            fw.write(stringWriter.toString());
            fw.flush();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
