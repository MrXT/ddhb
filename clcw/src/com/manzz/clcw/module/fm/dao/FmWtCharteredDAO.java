/**
 * create by XXXX
 * @date 2015-09-14
 */
package com.manzz.clcw.module.fm.dao;

import java.util.List;

import com.manzz.clcw.domain.FmWtChartered;
import com.manzz.clcw.module.fm.web.vo.FmWtCharteredVo;
import com.manzz.framework.core.model.PaginationDAO;

public interface FmWtCharteredDAO extends PaginationDAO<FmWtChartered> {
    /**
     * 
     * 功能:(查询带其他值得包车信息). <br/>
     *
     * @author XT
     * @param condition
     * @return
     */
    List<FmWtCharteredVo> queryCharteredVoByCondition(FmWtChartered condition);

    int deleteByPrimaryKey(Integer charteredId);
}