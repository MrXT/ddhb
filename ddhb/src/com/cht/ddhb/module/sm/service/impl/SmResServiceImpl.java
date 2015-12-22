package com.cht.ddhb.module.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.SmRes;
import com.cht.ddhb.module.sm.dao.SmResDAO;
import com.cht.ddhb.module.sm.service.SmResService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class SmResServiceImpl extends PaginationServiceImpl<SmRes> implements SmResService{
	@Autowired
	private SmResDAO dao;
}
