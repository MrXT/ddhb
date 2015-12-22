package com.cht.framework.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cht.framework.core.model.BaseEntity;
/**
 * @author WJK
 * @version 2012-03
 */
public class BeanUtils {
    
    private static transient Log logger = LogFactory.getLog(BeanUtils.class);
    
    /** Bean转化成Map */
    public static Map<String, Object> covertToMap(BaseEntity bean) {
        if(bean == null) 
            return null;
        
        Map<String, Object> map = new HashMap<String, Object>();        
        Field[] fields = bean.getClass().getDeclaredFields();
        String fieldName;
        Object fieldValue = null;
        for(Field field:fields){
            fieldName = field.getName();
            if("serialVersionUID".equals(fieldName)){
                continue;
            }
            Method method;
            try {
                method = bean.getClass().getMethod("get"+ StringUtils.capitalize(fieldName));
                fieldValue = method.invoke(bean);
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
            
            map.put(fieldName, fieldValue);
        }
        return map;
    }
}
