/**
 * Project Name:datacenter
 * File Name:ValidteCode.java
 * Package Name:com.manzz.datacenter.common.validcode
 * Date:2015-08-17上午10:01:51
 * Copyright (c) 2015, manzz.com All Rights Reserved.
 *
 */

package com.manzz.clcw.domain.validcode;

import com.manzz.framework.core.exception.BusinessException;
import com.manzz.framework.core.exception.ValidateCodeException;
import com.manzz.framework.core.util.MobileUtil;

/** 功能: 游客买票验证码 */
public class VisitorBuyTicketValidteCode extends MobileValidteCode{
    /**
     * 功能:校验是否推送验证码
     * 校验规则：是要手机号码符合格式就行了，不做任何其他验证
     * @throws ValidateCodeException 不满足推送条件时抛出的异常
     */
    @Override
    public void validate() throws ValidateCodeException{
    	String phoneNum = getMobile().getPhoneNum();
		if (!MobileUtil.isMobile(phoneNum)) {
            throw new BusinessException("10001", errorMap.get("10001"));
		}
    }
    
    @Override
    public String genMsg(String validCode){
        return "您正在使用" + getAppName() + "，验证码为:" + validCode + "请在页面填写";
    }
}
