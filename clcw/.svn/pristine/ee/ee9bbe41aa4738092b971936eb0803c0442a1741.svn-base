/**
 * Project Name:datacenter
 * File Name:ValidteCode.java
 * Package Name:com.manzz.datacenter.common.validcode
 * Date:2015-08-17上午10:01:51
 * Copyright (c) 2015, manzz.com All Rights Reserved.
 *
 */

package com.manzz.clcw.domain.validcode;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.SmCustomers;
import com.manzz.clcw.module.sm.dao.SmCustomersDAO;
import com.manzz.framework.core.exception.ValidateCodeException;

/** 功能: 重置密码验证码 */
public class ResetPwdValidteCode extends MobileValidteCode{
    @Autowired
    private SmCustomersDAO customersDAO;
    /**
     * 功能:校验是否推送验证码
     * 校验规则：在我方系统中已注册
     * @throws ValidateCodeException 不满足推送条件时抛出的异常
     */
    @Override
    public void validate() throws ValidateCodeException{
        String phoneNum = getMobile().getPhoneNum();
        SmCustomers customer = new SmCustomers();
        customer.setPhoneNum(phoneNum);
        List<SmCustomers> list = customersDAO.queryPagedList(customer);
        if (CollectionUtils.isEmpty(list)) {
            throw new ValidateCodeException("30001",errorMap.get("30001"));
        }
    }
    
    @Override
    public String genMsg(String validCode){
        return "您正在重置" + getAppName() + "通行证的密码，验证码为:" + validCode + "请在页面填写";
    }
}
