/**
 * create by XT
 * @date 2015-09-11
 */
package com.manzz.clcw.module.lm.dao;

import com.manzz.clcw.domain.LmWtSites;
import com.manzz.framework.core.model.PaginationDAO;

public interface LmWtSitesDAO extends PaginationDAO<LmWtSites> {

    /**
     * 
     * 功能:修改站点失效（为line_id赋值为“0”）
     * @param lineId
     * @return
     */
    int updateSiteInValid(String lineId);
}