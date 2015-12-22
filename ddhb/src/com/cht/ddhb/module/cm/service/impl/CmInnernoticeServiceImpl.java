package com.cht.ddhb.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.CmInnernotice;
import com.cht.ddhb.module.cm.dao.CmInnernoticeDAO;
import com.cht.ddhb.module.cm.service.CmInnernoticeService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class CmInnernoticeServiceImpl extends PaginationServiceImpl<CmInnernotice> implements CmInnernoticeService{
	@Autowired
	private CmInnernoticeDAO dao;
}
