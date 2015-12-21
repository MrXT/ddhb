package com.manzz.gps.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.gps.domain.CmWtVgpslocation;
import com.manzz.gps.module.cm.dao.CmWtVgpslocationDAO;
import com.manzz.gps.module.cm.service.CmWtVgpslocationService;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XXXX
 * @version:2015-9-21
 */
public class CmWtVgpslocationServiceImpl extends PaginationServiceImpl<CmWtVgpslocation> implements CmWtVgpslocationService{
	@Autowired
	private CmWtVgpslocationDAO dao;
}
