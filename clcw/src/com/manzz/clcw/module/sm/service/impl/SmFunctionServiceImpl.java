package com.manzz.clcw.module.sm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.SmFunction;
import com.manzz.clcw.module.sm.dao.SmFunctionDAO;
import com.manzz.clcw.module.sm.service.SmFunctionService;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XXXX
 * @version:2015-9-11
 */
public class SmFunctionServiceImpl extends PaginationServiceImpl<SmFunction> implements SmFunctionService{
	@Autowired
	private SmFunctionDAO dao;
}
