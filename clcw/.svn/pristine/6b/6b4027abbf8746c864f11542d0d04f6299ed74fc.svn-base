/**
 * create by XXXX
 * @date 2015-09-17
 */
package com.manzz.clcw.module.fm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manzz.clcw.domain.FmWtOrderform;
import com.manzz.clcw.module.fm.web.vo.OrderformVO;
import com.manzz.framework.core.model.PaginationDAO;

public interface FmWtOrderformDAO extends PaginationDAO<FmWtOrderform> {
	
	List<OrderformVO> queryOrderformVOList(@Param("customerID") String customerID, @Param("orderID") String orderID);
	
	Integer querySumTicketNoByFrequencyId(@Param("frequencyId") String frequencyId);
}