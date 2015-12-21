package com.manzz.clcw.module.bd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.BdGtRegion;
import com.manzz.clcw.module.bd.dao.BdGtRegionDAO;
import com.manzz.clcw.module.bd.service.BdGtRegionService;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XXXX
 * @version:2015-9-11
 */
public class BdGtRegionServiceImpl extends PaginationServiceImpl<BdGtRegion> implements BdGtRegionService{
	@Autowired
	private BdGtRegionDAO dao;
}
