package com.manzz.clcw.module.fm.service;

import java.util.List;

import com.manzz.clcw.domain.FmWtChartered;
import com.manzz.clcw.module.fm.web.vo.FmWtCharteredVo;
import com.manzz.framework.core.service.PaginationService;
/**
 * 功能：TODO
 * @author XXXX
 * @version:2015-9-14
 */
public interface FmWtCharteredService extends PaginationService<FmWtChartered>{
    /**
     * 
     * 功能:(查询带状态名的包车信息). <br/>
     *
     * @author XT
     * @param condition
     * @return
     */
    List<FmWtCharteredVo> queryCharteredVoByCondition(FmWtChartered condition);

    int doDelete(Integer charteredId);

    /**
     * 功能:插入包车单，同时修改车辆状态为待安检
     * @param chartered
     * @return
     */
    int doInsertCharered(FmWtCharteredVo chartered);

}