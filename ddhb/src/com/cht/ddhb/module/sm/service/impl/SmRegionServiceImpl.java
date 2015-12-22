package com.cht.ddhb.module.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.SmRegion;
import com.cht.ddhb.module.sm.dao.SmRegionDAO;
import com.cht.ddhb.module.sm.service.SmRegionService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class SmRegionServiceImpl extends PaginationServiceImpl<SmRegion> implements SmRegionService{
	@Autowired
	private SmRegionDAO dao;
}
