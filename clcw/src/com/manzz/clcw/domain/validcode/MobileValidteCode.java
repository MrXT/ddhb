/**
 * Project Name:datacenter
 * File Name:ValidteCode.java
 * Package Name:com.manzz.datacenter.common.validcode
 * Date:2015-08-17上午10:01:51
 * Copyright (c) 2015, manzz.com All Rights Reserved.
 *
 */

package com.manzz.clcw.domain.validcode;

import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import com.manzz.clcw.domain.PsMobile;
import com.manzz.framework.core.exception.BusinessException;
import com.manzz.framework.core.exception.ValidateCodeException;
import com.manzz.framework.core.util.MobileUtil;
import com.manzz.framework.core.util.MobileUtil.Result;

/** 功能: 手机验证码基础类 */
public abstract class MobileValidteCode {
    private String appName = "橙客巴士";
    
    @Resource
    protected Map<String, String> errorMap;
    private PsMobile mobile;
    
    /**
     * 功能:校验是否推送验证码
     * @throws ValidateCodeException 不满足推送条件时抛出的异常
     */
    protected abstract void validate() throws ValidateCodeException;
    
    /**
     * 功能:生成验证码
     */
    protected String genValidCode() {
        return String.format("%06d", (new Random()).nextInt(1000000));
    }
    /**
     * 功能:短信内容
     * @param vliadCode 验证码
     */
    protected String genMsg(String validCode) {
        return "您的验证码为:" + validCode;
    }
    
    /**
     * 功能:推送验证码
     * @return 返回生成的验证码
     */
    public String sendValidateCode(){
        if (!MobileUtil.isMobile(mobile.getPhoneNum())) {
            throw new BusinessException("10001", errorMap.get("10001"));
        }

        try {
            validate();
        } catch (ValidateCodeException e) {
            throw new BusinessException(e.getErrorCode(), e.getMessage());
        }
        String validCode = genValidCode();
        Result response = MobileUtil.send(mobile.getPhoneNum(), genMsg(validCode));
        if (!Result.RESPONSE_OK.equals(response)) {
            throw new BusinessException("41000", errorMap.get("41000"));
        }
        return validCode;
    }
    
    public PsMobile getMobile() {
        return mobile;
    }
    
    public void setMobile(PsMobile mobile) {
        this.mobile = mobile;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}

