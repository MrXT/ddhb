package com.manzz.clcw.module.fm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.domain.FmWtSecurityrecord;
import com.manzz.clcw.module.fm.dao.FmWtSecurityrecordDAO;
import com.manzz.clcw.module.fm.service.FmWtSecurityrecordService;
import com.manzz.framework.core.model.PaginationVO;
/**
 * @author XXXX
 * @version:2015-9-14
 */
public class FmWtSecurityrecordServiceImpl implements FmWtSecurityrecordService{
	@Autowired
	private FmWtSecurityrecordDAO dao;

    @Override
    public PaginationVO<FmWtSecurityrecord> queryPaginationVO(FmWtSecurityrecord condition, int pageIndex, int pageSize) {
        
        return null;
    }

    @Override
    public FmWtSecurityrecord queryByPrimaryKey(String id) {
        
        return null;
    }

    @Override
    public List<FmWtSecurityrecord> queryByCondition(FmWtSecurityrecord condition) {
        
        return null;
    }

    @Override
    public int doInsert(FmWtSecurityrecord entity) {
        
        return 0;
    }

    @Override
    public int doUpdate(FmWtSecurityrecord entity) {
        
        return 0;
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
    public int doInvalidate(FmWtSecurityrecord t) {
        
        return 0;
    }

    @Override
    public int doRevalidate(String id) {
        
        return 0;
    }

    @Override
    public int doRevalidate(FmWtSecurityrecord t) {
        
        return 0;
    }

    @Override
    public int doSave(FmWtSecurityrecord record) {
        
        return 0;
    }
}
