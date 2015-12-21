/**
 * create by XT
 * @date 2015-09-17
 */
package com.manzz.clcw.module.fm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manzz.clcw.domain.FmWtTickets;
import com.manzz.clcw.module.fm.web.vo.FmWtTicketsVo;
import com.manzz.clcw.module.fm.web.vo.TicketNumberVO;
import com.manzz.clcw.module.fm.web.vo.TicketVO;
import com.manzz.clcw.module.ws.vo.CheckTicketVO;
import com.manzz.framework.core.model.PaginationDAO;

public interface FmWtTicketsDAO extends PaginationDAO<FmWtTickets> {

    List<FmWtTicketsVo> queryTicketsVo(String frequencyId);
    
    int deleteByOrderID(String orderID);
    
    CheckTicketVO validateTicket(@Param("ticketnumber") String ticketnumber,@Param("driverId") String driverId);
    
    List<TicketVO> queryTicketVOByOrderID(String orderID);
    
    TicketNumberVO queryTicketNumberVO(@Param("orderID") String orderID);
}