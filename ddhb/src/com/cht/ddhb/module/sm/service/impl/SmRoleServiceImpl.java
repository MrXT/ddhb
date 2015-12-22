package com.cht.ddhb.module.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.SmRole;
import com.cht.ddhb.module.sm.dao.SmRoleDAO;
import com.cht.ddhb.module.sm.service.SmRoleService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class SmRoleServiceImpl extends PaginationServiceImpl<SmRole> implements SmRoleService{
	@Autowired
	private SmRoleDAO dao;
}
