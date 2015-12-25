/**
 * Project Name:dtdp
 * File Name:BaseService.java
 * Package Name:com.cht.framework.core.model
 * Date:2014-10-08上午9:21:12
 * Copyright (c) 2014, cht.com All Rights Reserved.
 *
 */

package com.cht.framework.core.service;

import java.util.List;

import com.cht.ddhb.common.enums.constant.StatusEnum;
import com.cht.framework.core.exception.BusinessException;
import com.cht.framework.core.model.BaseEntity;
import com.cht.framework.core.model.PaginationDAO;
import com.cht.framework.core.model.PaginationVO;
import com.cht.framework.core.mybatis.session.MybatisRowBounds;

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
	public PaginationVO<T> queryPaginationVO(T condition) {
//	    if(condition.getCompanyId() == null){
//	        condition.setCompanyId(SessionHolder.getCompanyId());
//	    }
	    if(condition.getPage() == null || condition.getRows()==null){
	        throw new BusinessException("请求参数错误!");
	    }
	    if(condition.getValidity() == null){
	    	condition.setValidity(StatusEnum.VALID.getBooleanValue());
	    }
        List <T> list = this.getPaginationDAO().queryPagedList(condition, new MybatisRowBounds(condition.getPage(), condition.getRows()));
        int recordCount = this.getPaginationDAO().queryCount(condition);
        return new PaginationVO <T>(list, recordCount, condition.getPage(), condition.getRows());
	}
	
	
}

