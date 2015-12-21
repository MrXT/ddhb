/**
 * Project Name:DTDP
 * File Name:JsonResult.java
 * Package Name:com.manzz.domain
 * Date:2015年1月27日下午2:06:08
 * Copyright (c) 2015, manzz.com All Rights Reserved.
 *
 */

package com.manzz.framework.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * ClassName: JsonResult <br/>
 * @description: http调用返回json通用格式
 *
 * @author ZZW
 * @version 2015-02
 */
@JsonSerialize
public class JsonResult<T> implements Serializable
{
    /** serialVersionUID. */
    private static final long serialVersionUID = 8474207367759906745L;

    @JsonProperty
    private boolean suc;
    
    @JsonProperty
    private List<?> data;
    
    /**
     * Getter method for property <tt>suc</tt>.
     * 
     * @return property value of suc
     */
    public Boolean getSuc()
    {
        return suc;
    }

    
    /**
     * Setter method for property <tt>suc</tt>.
     * 
     * @param suc value to be assigned to property suc
     */
    public void setSuc(Boolean suc)
    {
        this.suc = suc;
    }

    
    /**
     * Getter method for property <tt>data</tt>.
     * 
     * @return property value of data
     */
    public List<?> getData()
    {
        return data;
    }

    /**
     * Setter method for property <tt>data</tt>.
     * 
     * @param data value to be assigned to property data
     */
    public void setData(Object data)
    {
        if(data instanceof List){
            this.data = (List<?>) data;
        }else{
            List<Object> list = new ArrayList<Object>();
            list.add(data);
            this.data = list;
        }
    }
}

