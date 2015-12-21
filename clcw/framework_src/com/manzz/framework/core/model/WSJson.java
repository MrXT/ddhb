package com.manzz.framework.core.model;

/**
 * WebService响应返回的Json对象
 * @author WJK
 * @version 2015-07
 */
public class WSJson {

    private Boolean isSuccess = false;

    private String  msg = "";
    
    private String  errorCode = null;

    private Object data = null;
    
    public WSJson() {}
    
    public WSJson(Boolean isSuccess) {
        this.isSuccess = isSuccess;
        this.msg = isSuccess?"操作成功":"操作失败";
    }
    
    public WSJson(String msg) {
        this.msg = msg;
    }
    
    public WSJson(Boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public WSJson(Boolean isSuccess, String msg, Object data) {
        this.isSuccess = isSuccess;
        this.msg = msg;
        this.data = data;
    }
    
    /**
     * @param data 操作成功时返回的数据
     */
    public WSJson(Object data) {
        this.isSuccess = true;
        this.msg = "操作成功";
        this.data = data;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
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

    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
