package com.cht.ddhb.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.CmShop;
import com.cht.ddhb.module.cm.dao.CmShopDAO;
import com.cht.ddhb.module.cm.service.CmShopService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class CmShopServiceImpl extends PaginationServiceImpl<CmShop> implements CmShopService{
	@Autowired
	private CmShopDAO dao;
}
