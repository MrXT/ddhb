package com.cht.ddhb.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.CmArea;
import com.cht.ddhb.module.cm.dao.CmAreaDAO;
import com.cht.ddhb.module.cm.service.CmAreaService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class CmAreaServiceImpl extends PaginationServiceImpl<CmArea> implements CmAreaService{
	@Autowired
	private CmAreaDAO dao;
}
