package com.manzz.framework.tool;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.util.CommonUtils;
import com.manzz.framework.core.util.ReflectUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
/**
 * FreeMarker工具类
 * 功能: 用于根据模板生成contorller,service及serviceImpl代码模板.
 * @author WJK
 * @version 2015-03-30
 */
public class FreeMarkerGenerator {
    /** 模板配置 */
    private Configuration cfg;
    /** Controller模板*/
    private final static int FTL_TYPE_CONTROLLER = 1;
    /** Service模板*/
    private final static int FTL_TYPE_SERVICE = 2;
    /** ServiceImpl模板*/
    private final static int FTL_TYPE_SERVICEIMPL = 3;
    /** 带查询功能的JSP模板*/
    private final static int FTL_TYPE_MANAGE_JSP = 4;
    /** 信息编辑JSP模板*/
    private final static int FTL_TYPE_EDIT_JSP = 5;
    /** 可编辑的JSP模板*/
    private final static int FTL_TYPE_MANAGE_JSP_2 = 6;
    /** 参数获取路径*/
    private final static String PARAMS_PATH = "configs/properties/generator.properties";
    /** 模板路径*/
    private final static String TEMPLATE_PATH = "configs/template";
    /** 生成文件人 */
    private final static String AUTH_NAME = System.getProperty("user.name");//系统用户名
    //private final static String TEMPLATE_PATH = new File(System.getProperty("user.dir")+"//WebRoot//WEB-INF//classes//template
    /** 是否生成页面 */
    private boolean isCreateJsp;

    public FreeMarkerGenerator(boolean isCreateJsp) {
        this.isCreateJsp = isCreateJsp;
    }

    public void generate() throws IOException {
        // 初始化FreeMarker配置,设置FreeMarker的模版文件位置
        cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_PATH));
        cfg.setLocale(Locale.CHINA);
        cfg.setDefaultEncoding(Constants.DEFAULT_WEB_ENCODING);
        
        //获取参数
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
        
        //生成代码
        generateFile(FTL_TYPE_SERVICE,modulePackage,domainPackage,entityName);
        generateFile(FTL_TYPE_SERVICEIMPL,modulePackage,domainPackage,entityName);
        if(isCreateJsp){
            generateFile(FTL_TYPE_CONTROLLER,modulePackage,domainPackage,entityName);
            generateFile(FTL_TYPE_MANAGE_JSP,modulePackage,domainPackage,entityName);
            generateFile(FTL_TYPE_MANAGE_JSP_2,modulePackage,domainPackage,entityName);
            generateFile(FTL_TYPE_EDIT_JSP,modulePackage,domainPackage,entityName);
        }
    }
    
    private void generateFile(int ftlType, String modulePackage, String domainPackage, String entityName){
        String moduleName = modulePackage.substring(modulePackage.lastIndexOf(".")+1);//模块名
        String simpleEntityName = CommonUtils.toLowerInitial(CommonUtils.toLowerInitial(entityName).replace(moduleName, ""));
        // 获取参数集合
        Map<String, Object> root = new HashMap<String,Object>();
        root.put("modulePackage", modulePackage);
        root.put("domainPackage", domainPackage);
        root.put("entityName", entityName);
        root.put("simpleEntityName", simpleEntityName);
        root.put("moduleName", moduleName);
        root.put("authName", AUTH_NAME);
        if(isCreateJsp){
            root.put("fieldsList", ReflectUtils.getFiledsListByObject(domainPackage+"."+entityName));//属性名称集合
        }
        
        String typeName = "";
        String fileDir = "";
        String fileName = "";
        
        // 设置文件存放位置
        switch (ftlType) {
            case FTL_TYPE_CONTROLLER:
                typeName = "Controller";
                fileDir = "src/"+modulePackage.replace(".", "/")+"/web/controller/";
                fileName = fileDir + entityName + typeName + ".java";
                break;
            case FTL_TYPE_SERVICE:
                typeName = "Service";
                fileDir = "src/"+modulePackage.replace(".", "/")+"/service/";
                fileName = fileDir + entityName + typeName + ".java";
                break;
            case FTL_TYPE_SERVICEIMPL:
                typeName = "ServiceImpl";
                fileDir = "src/"+modulePackage.replace(".", "/")+"/service/impl/";
                fileName = fileDir + entityName + typeName + ".java";
                break;
            case FTL_TYPE_MANAGE_JSP:
                typeName = "ManageJsp";
                fileDir = "WebRoot/WEB-INF/jsp/"+moduleName+"/";
                fileName = fileDir + simpleEntityName + "_manage.jsp";
                break;
            case FTL_TYPE_EDIT_JSP:
                typeName = "EditJsp";
                fileDir = "WebRoot/WEB-INF/jsp/"+moduleName+"/";
                fileName = fileDir + simpleEntityName + "_edit.jsp";
                break;
            case FTL_TYPE_MANAGE_JSP_2:
                typeName = "ManageJsp2";
                fileDir = "WebRoot/WEB-INF/jsp/"+moduleName+"/";
                fileName = fileDir + simpleEntityName + "_manage2.jsp";
            default:
                break;
        }
        
        try {
            File dir = new File(fileDir);
            FileUtils.forceMkdir(dir);
            Template template = cfg.getTemplate(typeName+".ftl");
            Writer out = new OutputStreamWriter(new FileOutputStream(fileName), Constants.DEFAULT_WEB_ENCODING);
            template.process(root, out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
