package com.manzz.framework.core.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 响应返回的Json对象
 * @author WJK
 * @version 2014-09
 */
public class ResponseJson {

    private boolean success = false;

    private String  msg = "";

    private Object  data = null;

    private List<Object> rows = new ArrayList<Object>();

    private int total = 0;
    
    private int code;
    
    private String url;
    
    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getRows() {
        return rows;
    }

    public void setRows(List<Object> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
