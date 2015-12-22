package com.cht.ddhb.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.CmConmision;
import com.cht.ddhb.module.cm.dao.CmConmisionDAO;
import com.cht.ddhb.module.cm.service.CmConmisionService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class CmConmisionServiceImpl extends PaginationServiceImpl<CmConmision> implements CmConmisionService{
	@Autowired
	private CmConmisionDAO dao;
}
