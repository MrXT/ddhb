
package com.manzz.yz.vo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.manzz.yz.util.MD5;


/**
 * 基础数据接口 调用远程接口所需要的请求实体参数
 * 
 * ClassName: RequestParameter <br/>
 * @author XT
 * @version 2015年12月4日
 */
public class RequestParameter {
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 连接序列
     */
    private String valserial;
    /**
     * 命令名称
     */
    private String command;
    /**
     * 请求key，这个key由请求的发起方生成，用于关联该请求所产生的响应。
     */
    private String key;
    /**
     * 请求时间
     */
    private String requesttime;
    /**
     * 查询条件实体类
     */
    private String parameters;
    /**
     * MD5加密字串，加密方式如下：Requesttime+key+command+(协议字段)manzz_zgyg
     */
    private String encrypt;
    
    public RequestParameter(String valserial, String command, String parameters) {
        super();
        this.valserial = valserial;
        this.command = command;
        this.key = "0000000000000000000000";
        Date requestTimeDate = new Date();
        this.requesttime = format.format(requestTimeDate);
        this.encrypt = MD5.getStr2Digest(requesttime+key+command+"manzz_zgyg");
        this.parameters = parameters;
    }

    public String getValserial() {
        return valserial;
    }
    
    public void setValserial(String valserial) {
        this.valserial = valserial;
    }
    
    public String getCommand() {
        return command;
    }
    
    public void setCommand(String command) {
        this.command = command;
    }
    
    public String getEncrypt() {
        return encrypt;
    }
    
    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }
    
    public String getKey() {
        return key;
    }
    
    public void setKey(String key) {
        this.key = key;
    }
    
    public String getRequesttime() {
        return requesttime;
    }
    
    public void setRequesttime(String requesttime) {
        this.requesttime = requesttime;
    }
    
    public String getParameters() {
        return parameters;
    }
    
    public void setParameters(String parameter) {
        this.parameters = parameter;
    }
    
    
}

