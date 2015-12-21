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
import com.manzz.framework.core.exception.BusinessException;
import com.manzz.framework.core.exception.ValidateCodeException;
import com.manzz.framework.core.util.GuidUtils;
import com.manzz.framework.core.util.MobileUtil;

/** 功能: 游客验证码 */
public class VisitorValidteCode extends RegisterValidteCode {
	@Autowired
	private SmCustomersDAO customersDAO;

	/**
	 * 功能:校验是否推送验证码 校验规则：暂时与注册时发送验证码的规则相同
	 * 
	 * @throws ValidateCodeException
	 *             不满足推送条件时抛出的异常
	 */
	@Override
	public void validate() throws ValidateCodeException {
//		super.validate();
		/**
		 * 1：如果是游客，发送验证码时 取消 手机号码判断是否已经存在 的限制；场景：订票 <单独写一个>
		 * 
		 * 2：注册：如果是 已有用户，直接提示登录 3：注册：如果是 无该用户，新增一条记录
		 */
		// 新增一条记录
		String phoneNum = getMobile().getPhoneNum();
		if (!MobileUtil.isMobile(phoneNum)) {
            throw new BusinessException("10001", errorMap.get("10001"));
		}
		SmCustomers customer = new SmCustomers();
    	customer.setPhoneNum(phoneNum);
        List<SmCustomers> list = customersDAO.queryPagedList(customer);
        if (CollectionUtils.isNotEmpty(list)) {
            throw new ValidateCodeException("30002", errorMap.get("30002"));
        }else{
        	customer.setId(GuidUtils.getGuid());
    		customer.setPhoneNum(phoneNum);
    		customer.setPassword("0");
    		customersDAO.insert(customer);
        }
	}

	@Override
	public String genMsg(String validCode) {
		return "您正在使用" + getAppName() + "通行证的手机号，验证码为:" + validCode + "请在页面填写";
	}
}
