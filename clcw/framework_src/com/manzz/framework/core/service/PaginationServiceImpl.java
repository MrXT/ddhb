/**
 * Project Name:dtdp
 * File Name:BaseService.java
 * Package Name:com.manzz.framework.core.model
 * Date:2014-10-08上午9:21:12
 * Copyright (c) 2014, manzz.com All Rights Reserved.
 *
 */

package com.manzz.framework.core.service;

import java.util.List;

import com.manzz.clcw.common.enums.constant.StatusEnum;
import com.manzz.framework.core.model.BaseEntity;
import com.manzz.framework.core.model.PaginationDAO;
import com.manzz.framework.core.model.PaginationVO;
import com.manzz.framework.core.mybatis.session.MybatisRowBounds;

/**
 * ClassName: PaginationService <br/>
 * Function: 带分页的Service实现类. <br/>
 *
 * @author WJK
 * @version 2015-01
 */
public abstract class PaginationServiceImpl<T extends BaseEntity> extends BaseServiceImpl<T> implements PaginationService<T>{
	
	public PaginationDAO<T> getPaginationDAO(){
		return (PaginationDAO<T>)this.getBaseDAO();
	};

	@Override
	public PaginationVO<T> queryPaginationVO(T condition, int pageIndex, int pageSize) {
//	    if(condition.getCompanyId() == null){
//	        condition.setCompanyId(SessionHolder.getCompanyId());
//	    }
	    if(condition.getValidity() == null){
	    	condition.setValidity(StatusEnum.VALID.getBooleanValue());
	    }
        List <T> list = this.getPaginationDAO().queryPagedList(condition, new MybatisRowBounds(pageIndex, pageSize));
        int recordCount = this.getPaginationDAO().queryCount(condition);
        return new PaginationVO <T>(list, recordCount, pageIndex, pageSize);
	}
	
	
}
