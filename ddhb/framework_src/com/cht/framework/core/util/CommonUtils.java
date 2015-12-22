package com.cht.framework.core.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.util.CollectionUtils;


/**
 * <p> 通用工具类 </p>
 * @author WJK
 * @version 2015-08
 */
public class CommonUtils {
	private final static boolean IS_AUTOLOAD_RESOURCE = false;
	
    /**
     * 从配置文件中读取静态常量的值
     * @param key
     * @return
     */
    public static String readResource(String key){
        return readResource(key, IS_AUTOLOAD_RESOURCE);
    }
    /**
     * 从配置文件中读取静态常量数组的值
     * @param key
     * @return
     */
    public static String[] readResourceArray(String key){
        return readResourceArray(key, IS_AUTOLOAD_RESOURCE);
    }
    /**
     * 从配置文件中读取静态常量的值
     * @param key
     * @param reloading 是否加载最新配置文件
     * @return
     */
    public static String readResource(String key,boolean reloading){
//        String str = null;
//        if(reloading){
//            str = ResourceBundle.getBundle("properties/system").getString(key);
//            try {
//              if(str.equals(new String(str.getBytes("ISO-8859-1"), "ISO-8859-1"))){
//                  str = new String(str.getBytes("ISO-8859-1"), "UTF-8");//解决UTF-8格式的properties的中文乱码问题
//              }
//                
//            } catch (UnsupportedEncodingException e) {
//                throw new SystemException(e.getMessage());
//            }
//        }
//        return str;
        String value = null;
        PropertiesConfiguration cfg;
        try {
            cfg = new PropertiesConfiguration("properties/system.properties");
            if (reloading) {
                cfg.setReloadingStrategy(new FileChangedReloadingStrategy());
            }
            value = cfg.getString(key);
            if(value.equals(new String(value.getBytes("ISO-8859-1"), "ISO-8859-1"))){
                value = new String(value.getBytes("ISO-8859-1"), "UTF-8");//解决UTF-8格式的properties的中文乱码问题
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    
    /**
     * 从配置文件中读取静态常量的值
     * @param key
     * @param reloading 是否加载最新配置文件
     * @return
     */
    public static String[] readResourceArray(String key,boolean reloading){
        String[] value = null;
        PropertiesConfiguration cfg;
        try {
            cfg = new PropertiesConfiguration("properties/system.properties");
            if (reloading) {
                cfg.setReloadingStrategy(new FileChangedReloadingStrategy());
            }
            value = cfg.getStringArray(key);
            
            for(String str : value){
                if(str.equals(new String(str.getBytes("ISO-8859-1"), "ISO-8859-1"))){
                	str = new String(str.getBytes("ISO-8859-1"), "UTF-8");//解决UTF-8格式的properties的中文乱码问题
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    /**
     * 通用toString方法
     * @param bean 需要进行toString的对象bean
     * @return 返回对象原有toString值及对象属性
     */
    public static String toString(Object bean){
        return ToStringBuilder.reflectionToString(bean, ToStringStyle.MULTI_LINE_STYLE);
    }
    
    /** 
     * 获得指定包下的所有类
     * @param dir 
     * @param pk 
     * @return 
     * @throws ClassNotFoundException 
     */ 
    public static Class<?>[] getClasses(String packageName) {
        String path = packageName.replace('.', '/');  
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();  
        URL url = classloader.getResource(path);  
        List<Class<?>> list = new ArrayList<Class<?>>();
        try {
            list = getClasses(new File(url.getFile()), packageName);
        } catch (ClassNotFoundException e) {
            System.out.println("找不到"+packageName);
        }
        return list.toArray(new Class[list.size()]);  
    }
    
    /** 
     * 迭代查找类 
     * @param dir 
     * @param pk 
     * @return 
     * @throws ClassNotFoundException 
     */  
    private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {  
        List<Class<?>> classes = new ArrayList<Class<?>>();  
        if (!dir.exists()) {  
            return classes;  
        }  
        for (File f : dir.listFiles()) {  
            if (f.isDirectory()) {  
                classes.addAll(getClasses(f, pk + "." + f.getName()));  
            }  
            String name = f.getName();  
            if (name.endsWith(".class")) {  
                classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));  
            }  
        }  
        return classes;  
    }  
	
	/**
     * 生成n~m之间的随机整数(包括m、n)
     */
    public static int random(int n,int m){
        Random rand = new Random(); 
        int r = rand.nextInt(m)%(m-n+1)+n;
        return r;
    }
	
	public static final String substring(String str,int start,int end) {
//        if(str == null)
//            return null;
//        if(end < 0)
//            end = str.length() + end;
//        if(start < 0)
//            start = str.length() + start;
//        if(end > str.length())
//            end = str.length();
//        if(start > end)
//            return "";
//        if(start < 0)
//            start = 0;
//        if(end < 0)
//            end = 0;
//        return str.substring(start, end);		
		return StringUtils.substring(str, start, end);
	}
    
    @SuppressWarnings("unchecked")
	public static <T> List<T> arrayToList(T[] source)
    {
        return CollectionUtils.arrayToList(source);
    }
    
    /** 深度复制   */
    @SuppressWarnings("unchecked")
    public static <T> T copy(T t) throws IOException, ClassNotFoundException
    {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(t);
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return (T) ois.readObject();
    }
    
    /**
     * 功能:是否包含空字符串
     * @author ZZW
     * @param strings
     * @return
     */
    public static Boolean hasEmpty(String... strings)
    {
        Boolean result = Boolean.FALSE;
        for (String string : strings)
        {
            if(StringUtils.isEmpty(string)){
                result = Boolean.TRUE;
                break;
            }
        }
        return result;
    }
    
    /**
     * 功能:是否包含
     * @author ZZW
     * @param strings
     * @return
     */
    public static Boolean allNotEmpty(String... strings)
    {
        Boolean result = Boolean.TRUE;
        for (String string : strings)
        {
            if(StringUtils.isEmpty(string)){
                result = Boolean.FALSE;
                break;
            }
        }
        return result;
    }
    
    /**
     * @description: 至少一个不为空
     * @author ZZW
     * @param strings
     * @return
     */
    public static Boolean atLeastOneNotEmpty(String... strings)
    {
        Boolean result = Boolean.FALSE;
        for (String string : strings)
        {
            if(StringUtils.isNotEmpty(string)){
                result = Boolean.TRUE;
                break;
            }
        }
        return result;
    }
    
    /**
     * @description: 添加url问号
     * @author ZZW
     * @param url
     * @return
     */
    public static String assemblyURLQuestionMark(String url){
        if(StringUtils.isNotEmpty(url) && url.indexOf("?") == -1){
            url = url.trim() + "?";
        }
        return url;
    }
    
    /**
     * @description: 拼装url参数格式
     * @author ZZW
     * @param param
     * @param value
     * @return
     */
    public static String assemblyURLParams(String param, String value){
        return "&" + param + "=" + value;
    }
    
    public static Boolean parseSQLBoolean(String param){
        return "1".equals(param) ? true
                : "0".equals(param) ? false
                    : Boolean.parseBoolean(param);
    }
    
    /**
     * 将指定字符的首字母小写
     * @param str 需要转换的字符
     */
    public static String toLowerInitial(String str){
        char ch[];
        ch = str.toCharArray();
        if (ch[0] >= 'A' && ch[0] <= 'Z') {
            ch[0] = (char) (ch[0] + 32);
        }
        return new String(ch);
    }
    
    /**
     * 将指定字符的首字母大写
     * @param str 需要转换的字符
     */
    public static String toUpperInitial(String str){
        char ch[];
        ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }
    
    /**
     * 功能:根据map参数构造url参数
     * @param param
     * @return
     */
    public static String getUrlParam(Map<String, Object> param) {
        if (param.size() == 0) {
            return "";
        }
        StringBuffer result = new StringBuffer();
        result.append("?");
        boolean firstLoop = true;
        for (String key : param.keySet()) {
            Object value = param.get(key) == null ? "" : key + "=" + param.get(key).toString();
            if (firstLoop) {
                firstLoop = false;
            } else {
                value = "&" + value;
            }
            result.append(value);
        }
        return result.toString();
    }
}
