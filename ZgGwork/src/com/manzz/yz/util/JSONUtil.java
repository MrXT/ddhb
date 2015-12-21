
package com.manzz.yz.util;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * json字符串处理
 * ClassName: JSONUtil <br/>
 * @author XT
 * @version 2015年12月4日
 */
public class JSONUtil {
    public static String beanToJson(Object object){
        return JSONObject.fromObject(object).toString();
    }
    public static String ListBeanToJson(List<Object> objects){
        return JSONArray.fromObject(objects).toString();
    }
}

