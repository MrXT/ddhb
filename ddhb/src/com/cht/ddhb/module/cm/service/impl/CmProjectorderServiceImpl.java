package com.cht.ddhb.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.CmProjectorder;
import com.cht.ddhb.module.cm.dao.CmProjectorderDAO;
import com.cht.ddhb.module.cm.service.CmProjectorderService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class CmProjectorderServiceImpl extends PaginationServiceImpl<CmProjectorder> implements CmProjectorderService{
	@Autowired
	private CmProjectorderDAO dao;
}
