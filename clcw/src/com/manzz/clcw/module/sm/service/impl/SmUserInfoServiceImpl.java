package com.manzz.clcw.module.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.SmUserInfo;
import com.manzz.clcw.module.sm.dao.SmUserInfoDAO;
import com.manzz.clcw.module.sm.service.SmUserInfoService;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XXXX
 * @version:2015-9-11
 */
public class SmUserInfoServiceImpl extends PaginationServiceImpl<SmUserInfo> implements SmUserInfoService{
	@Autowired
	private SmUserInfoDAO dao;
}
