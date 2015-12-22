package com.cht.ddhb.module.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.SmUser;
import com.cht.ddhb.module.sm.dao.SmUserDAO;
import com.cht.ddhb.module.sm.service.SmUserService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class SmUserServiceImpl extends PaginationServiceImpl<SmUser> implements SmUserService{
	@Autowired
	private SmUserDAO dao;
}
