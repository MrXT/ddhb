package com.manzz.clcw.module.fm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.FmWtChartered;
import com.manzz.clcw.module.fm.dao.FmWtCharteredDAO;
import com.manzz.clcw.module.fm.dao.FmWtSecurityrecordDAO;
import com.manzz.clcw.module.fm.service.FmWtCharteredService;
import com.manzz.clcw.module.fm.web.vo.FmWtCharteredVo;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.model.PaginationVO;
/**
 * @author XT
 * @version:2015-9-14
 */
public class FmWtCharteredServiceImpl  implements FmWtCharteredService{
	@Autowired
	private FmWtCharteredDAO dao;
	@Autowired
	private FmWtSecurityrecordDAO recordDao;

    @Override
    public PaginationVO<FmWtChartered> queryPaginationVO(FmWtChartered condition, int pageIndex, int pageSize) {
        
        return null;
    }

    @Override
    public FmWtChartered queryByPrimaryKey(String id) {
        
        return null;
    }

    @Override
    public List<FmWtChartered> queryByCondition(FmWtChartered condition) {
        return dao.queryPagedList(condition);
    }

    @Override
    public int doInsert(FmWtChartered entity) {
        
        return dao.insert(entity);
    }

    @Override
    public int doUpdate(FmWtChartered entity) {
        
        return dao.updateByPrimaryKeySelective(entity);
    }

    @Override
    public int doDelete(String id) {
        
        return 0;
    }

    @Override
    public int doInvalidate(String id) {
        
        return 0;
    }

    @Override
    public int doInvalidate(FmWtChartered t) {
        
        return 0;
    }

    @Override
    public int doRevalidate(String id) {
        
        return 0;
    }

    @Override
    public int doRevalidate(FmWtChartered t) {
        
        return 0;
    }

    @Override
    public int doSave(FmWtChartered record) {
        
        return 0;
    }

    @Override
    public List<FmWtCharteredVo> queryCharteredVoByCondition(FmWtChartered condition) {
        
        return dao.queryCharteredVoByCondition(condition);
    }

    @Override
    public int doDelete(Integer charteredId) {
        
        return dao.deleteByPrimaryKey(charteredId);
    }

    @Override
    public int doInsertCharered(FmWtCharteredVo chartered) {
        if(doInsert(chartered)>0){
            String licenseplates [] = chartered.getLicenseplate().split(",");
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("checkStatus", Constants.CAR_NOSECURITY);//修改车状态为待安检
            map.put("array",licenseplates);
            return recordDao.updateCheckStatusByLicenseplate(map);
        }
        return 0;
    }
}
