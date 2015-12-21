package com.manzz.framework.core.web.vo;

import java.util.List;

import com.manzz.framework.core.model.LabelValueBean;

/**
 * 功能：下拉框数据对象
 * @author WJK
 * @version 2014-09
 */
public class SelectBox {
    private String id;
    private String name;
    private List<LabelValueBean> data;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public List<LabelValueBean> getData() {
        return data;
    }
    
    public void setData(List<LabelValueBean> data) {
        this.data = data;
    }
}
