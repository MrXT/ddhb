
package com.manzz.yz.vo.order;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.manzz.yz.util.MD5;


/**
 * 预约接口  调用远程接口所需要的请求实体参数
 * 
 * ClassName: RequestParameter <br/>
 * @author XT
 * @version 2015年12月4日
 */
public class RequestParameter {
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 请求key，这个key由请求的发起方生成，用于关联该请求所产生的响应。
     */
    private String key;
    /**
     * 请求时间
     */
    private String requestTime;
    /**
     * 查询条件实体类
     */
    private Parameter parameter;
    /**
     * MD5加密字串，加密方式如下：Requesttime+key+(协议字段)yzmanzz.com
     */
    private String encryption;
    
    public RequestParameter(Parameter parameter) {
        super();
        this.key = "0000000000000000000000";
        Date requestTimeDate = new Date();
        this.requestTime = format.format(requestTimeDate);
        this.encryption = MD5.getStr2Digest(requestTime+key+"yzmanzz.com");
        this.parameter = parameter;
    }

    
    public String getEncryption() {
        return encryption;
    }
    
    public void setEncryption(String encryption) {
        this.encryption = encryption;
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getRequestTime() {
        return requestTime;
    }
    
    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }
    
    public Parameter getParameter() {
        return parameter;
    }
    
    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }
    
    
}

