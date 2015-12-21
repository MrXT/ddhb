package com.manzz.clcw.module.lm.service;

import java.util.List;

import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.module.lm.web.vo.LmWtLinesVo;
import com.manzz.framework.core.model.ResponseJson;
import com.manzz.framework.core.service.PaginationService;
/**
 * @author XT
 * @version:2015-9-11
 */
public interface LmWtLinesService extends PaginationService<LmWtLines>{
    
    /**
     * 功能:根据条件获取带班次与班线的线路信息
     * @param line
     * @return
     */
    List<LmWtLinesVo> queryLinesVoByCondition(LmWtLines line);

    /**
     * 功能:先删除线路下的所有站点，在插入新的站点
     * @param lineId
     * @param esiteNames 
     * @param ssiteNames 
     * @param destination 
     * @param departure 
     * @return
     */
    int doUpdateLineSites(String lineId,String lineName, Integer departure, Integer destination, String[] ssiteNames, String[] esiteNames);

    /**
     * 功能:级联删除线路与站点
     * @param lineId
     * @return
     */
    int doDeleteCascadeSite(String lineId);

    /**
     * 
     * 功能:
     * @param companyId
     * @return
     */
    List<LmWtLinesVo> queryLinesVoByCompany(String companyId);

    /**
     * 功能:
     * @param line
     * @return
     */
    ResponseJson doSaveByDepartureNameAndDepartureName(LmWtLinesVo line);

}