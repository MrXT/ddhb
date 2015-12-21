package com.manzz.clcw.module.fm.service;

import java.util.List;

import com.manzz.clcw.domain.FmWtTickets;
import com.manzz.clcw.module.fm.web.vo.FmWtTicketsVo;
import com.manzz.framework.core.service.PaginationService;
/**
 * @author XT
 * @version:2015-9-17
 */
public interface FmWtTicketsService extends PaginationService<FmWtTickets>{
    List<FmWtTicketsVo> queryTicketsVo(String frequencyId);

}