package com.manzz.clcw.module.fm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.FmWtTickets;
import com.manzz.clcw.module.fm.dao.FmWtTicketsDAO;
import com.manzz.clcw.module.fm.service.FmWtTicketsService;
import com.manzz.clcw.module.fm.web.vo.FmWtTicketsVo;
import com.manzz.framework.core.service.PaginationServiceImpl;
/**
 * @author XT
 * @version:2015-9-17
 */
public class FmWtTicketsServiceImpl extends PaginationServiceImpl<FmWtTickets> implements FmWtTicketsService{
	@Autowired
	private FmWtTicketsDAO dao;

    @Override
    public List<FmWtTicketsVo> queryTicketsVo(String frequencyId) {
        return dao.queryTicketsVo(frequencyId);
    }
}
