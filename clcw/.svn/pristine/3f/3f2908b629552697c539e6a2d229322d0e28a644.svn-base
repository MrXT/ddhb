/**
 * create by XT
 * @date 2015-09-11
 */
package com.manzz.clcw.module.fm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.manzz.clcw.domain.FmWtFrequency;
import com.manzz.clcw.module.fm.web.vo.FmWtFrequencyVo;
import com.manzz.clcw.module.fm.web.vo.FrequencyVO;
import com.manzz.framework.core.model.PaginationDAO;

public interface FmWtFrequencyDAO extends PaginationDAO<FmWtFrequency> {

    /**
     * 
     * 功能:(根据条件查询详细的班次信息). <br/>
     *
     * @author XT
     * @param condition
     * @return
     */
    List<FmWtFrequencyVo> queryFrequencyVoByCondition(FmWtFrequencyVo condition);
	
	/**
	 * 功能：查询班次
	 * @param frequencyVO
	 * @return
	 */
	List<FrequencyVO> queryFrequencyList(FrequencyVO frequencyVO);
	
	/**
	 * 功能：根据出发地或目的地的 编码    得到所有站点 编码名称键值对 
	 * @param regionCode
	 * @return
	 */
	List<Map<String, Object>> querySiteNumberAndNameByRegionCode(@Param("regionCode")String regionCode);
	
	//查询所有途径站点集合名称
	String querySiteNamesBySiteNumber(@Param("siteNumber")String siteNumber);
	
}