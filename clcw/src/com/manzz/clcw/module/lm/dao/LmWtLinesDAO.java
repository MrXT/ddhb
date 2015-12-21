/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.module.lm.dao;

import java.util.List;

import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.domain.LmWtSites;
import com.manzz.clcw.module.lm.web.vo.LmWtLinesVo;
import com.manzz.framework.core.model.PaginationDAO;

public interface LmWtLinesDAO extends PaginationDAO<LmWtLines> {

    List<LmWtLinesVo> queryLinesVoByCondition(LmWtLines line);

    int insertSitesByLine(List<LmWtSites> sites);

    int queryMaxSiteNumber(String lineId);

    List<LmWtLinesVo> queryLinesVoByCompany(String company);

    int deleteSiteByLineId(String lineId);

    int deleteClasslineByLineId(String lineId);


}