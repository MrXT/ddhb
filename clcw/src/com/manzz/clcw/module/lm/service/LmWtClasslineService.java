package com.manzz.clcw.module.lm.service;

import java.util.List;

import com.manzz.clcw.domain.LmWtClassline;
import com.manzz.clcw.domain.LmWtLines;
import com.manzz.clcw.module.lm.web.vo.LmWtClasslineVo;
import com.manzz.framework.core.service.PaginationService;
/**
 * 功能：TODO
 * @author XXXX
 * @version:2015-9-11
 */
public interface LmWtClasslineService extends PaginationService<LmWtClassline>{
    
    /**
     * 
     * 功能:(根据相应条件查询班线信息). <br/>
     *
     * @author XT
     * @param condition
     * @return
     */
    List<LmWtClasslineVo> queryClassLineByCompany(LmWtLines condition);
    
    /**
     * 
     * 功能:(根据相应条件查询班线信息). <br/>
     *
     * @author XT
     * @param condition
     * @return
     */
    List<LmWtClasslineVo> queryByLinesVoByCondition(LmWtLines condition);

}