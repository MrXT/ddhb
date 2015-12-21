/**
 * Project Name:datacenter
 * File Name:PsMobile.java
 * Package Name:com.manzz.datacenter.domain
 * Date:2015-08-17下午2:05:16
 * Copyright (c) 2015, manzz.com All Rights Reserved.
 *
 */

package com.manzz.clcw.domain;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.SmCustomers;
import com.manzz.clcw.module.sm.dao.SmCustomersDAO;

/**
 * 功能: 手机号
 * @author WJK
 * @version 2015-08-17 
 */
public class PsMobile{
    @Autowired
    private SmCustomersDAO customersDAO;
    
    private String phoneNum;
    
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    /**
     * 功能:判断手机号是否可用
     * @param phoneNum 手机号
     * @return
     */
    public boolean isMobileEnable(String phoneNum) {
        SmCustomers condition = new SmCustomers();
        condition.setPhoneNum(phoneNum);
        boolean isMobileEnable = customersDAO.queryCount(condition) > 0 ? true : false;
        return isMobileEnable;
    }
}

