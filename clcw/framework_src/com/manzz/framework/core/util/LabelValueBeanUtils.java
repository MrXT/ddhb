package com.manzz.framework.core.util;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.exception.SystemException;
import com.manzz.framework.core.model.LabelValueBean;
/**
 * 键值对工具类
 * @author WJK
 * @version: 2012-08
 */
public final class LabelValueBeanUtils {
    private LabelValueBeanUtils() {}
    
    public static final LabelValueBean EMTPY_LABEL_VALUE_BEAN_ARRAY[] = new LabelValueBean[0];    
    
    public static List<LabelValueBean> addBlank(List<LabelValueBean> labelValueBeanList)
    {
        return addBlank(null,labelValueBeanList);
    }
    
    public static List <LabelValueBean> addBlank(Class<Object> valueClass, List<LabelValueBean> labelValueBeanList) {
        List <LabelValueBean> list = creatEmptyLabelValueList(true);
        if (CollectionUtils.isEmpty(labelValueBeanList)) {
            return list;
        } else {
            list.addAll(labelValueBeanList);
            return list;
        }
    }
    
    public static LabelValueBean[] creatEmptyLabelValue() {
        return EMTPY_LABEL_VALUE_BEAN_ARRAY;
    }
    
    public static List <LabelValueBean> creatEmptyLabelValueList() {
        return creatEmptyLabelValueList(false);
    }
    
    public static List <LabelValueBean> creatEmptyLabelValueList(boolean addBlank) {
        return creatEmptyLabelValueList(null,addBlank);
    }

    public static List <LabelValueBean> creatEmptyLabelValueList(Object selectValue,boolean addBlank) {
        List <LabelValueBean> list = new LinkedList <LabelValueBean>();
        if(addBlank){
            list.add(new LabelValueBean(Constants.DEFAULT_BLANK_SELECT, selectValue));
        }
        return list;
    }
    
    public static String getLabelByValue(LabelValueBean[] labelValueBeans, Object value) {
        String label = "";
        if(labelValueBeans == null || value == null) {
            return label;
        }
        
        for (LabelValueBean bean : labelValueBeans) {
            if(value.equals(bean.getValue())) {
                label = bean.getLabel();
                break;
            }
        }
        return label;
    }

    public static Map<Object, String> getLabelMap(LabelValueBean[] beans) {
        Map<Object, String> map = new HashMap<Object, String>();
        for (LabelValueBean bean : beans) {
            map.put(bean.getValue(), bean.getLabel());
        }
        return map;
    }
    
    public static String getLabel(LabelValueBean[] beans, Object value) {
        for (LabelValueBean bean : beans) {
            if(bean.getValue().equals(value)){
                return bean.getLabel();
            }
        }
        throw new SystemException(value+"没有对应的label");
    }

}