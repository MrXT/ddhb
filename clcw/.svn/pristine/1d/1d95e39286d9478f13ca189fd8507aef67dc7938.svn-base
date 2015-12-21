/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.module.lm.dao;

import java.util.List;

import com.manzz.clcw.domain.LmWtClassline;
import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.domain.LmWtSites;
import com.manzz.clcw.module.lm.web.vo.LmWtClasslineVo;
import com.manzz.framework.core.model.PaginationDAO;

public interface LmWtClasslineDAO extends PaginationDAO<LmWtClassline> {

    List<LmWtClasslineVo> queryClassLineByCompany(LmWtLines condition);

    List<LmWtSites> querySiteNameBySiteNumbers(String[] siteNumbers);

    List<LmWtClasslineVo> queryClassLineByLine(LmWtLines condition);

    int updateClasslinesByLine(List<LmWtClasslineVo> classlineVos);
}