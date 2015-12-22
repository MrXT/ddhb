package com.cht.ddhb.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.CmConmisionsetting;
import com.cht.ddhb.module.cm.dao.CmConmisionsettingDAO;
import com.cht.ddhb.module.cm.service.CmConmisionsettingService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-22
 */
public class CmConmisionsettingServiceImpl extends PaginationServiceImpl<CmConmisionsetting> implements CmConmisionsettingService{
	@Autowired
	private CmConmisionsettingDAO dao;
}
