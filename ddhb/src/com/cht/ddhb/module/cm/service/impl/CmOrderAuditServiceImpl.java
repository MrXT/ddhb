package com.cht.ddhb.module.cm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.domain.CmOrderAudit;
import com.cht.ddhb.module.cm.dao.CmOrderAuditDAO;
import com.cht.ddhb.module.cm.service.CmOrderAuditService;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author root
 * @version:2015-12-28
 */
public class CmOrderAuditServiceImpl extends PaginationServiceImpl<CmOrderAudit> implements CmOrderAuditService{
	@Autowired
	private CmOrderAuditDAO dao;
}
