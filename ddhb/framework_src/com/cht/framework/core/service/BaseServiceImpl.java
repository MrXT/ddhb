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
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.cht.ddhb.common.enums.constant.StatusEnum;
import com.cht.framework.core.exception.SystemException;
import com.cht.framework.core.model.BaseDAO;
import com.cht.framework.core.model.BaseEntity;
import com.cht.framework.core.util.ReflectUtils;

/**
 * ClassName: BaseService <br/>
 * Function: Service实现类基类. <br/>
 *
 * @author WJK
 * @version 2015-08
 */
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T>{
    @Resource
    protected Map<String, String> errorMap;
    @Autowired
    private BaseDAO<T> baseDAO;//spring4.0 泛型注入
    
    public BaseDAO<T> getBaseDAO() {
//        Class<? extends Annotation> annatation = com.cht.framework.core.annotation.BaseDAO.class;
//        return ReflectUtils.getFieldByAnnatation(this,BaseDAO.class,annatation);
        return baseDAO;
    }

    @Override
    public List<T> queryByCondition(T condition) {
        return getBaseDAO().queryPagedList(condition);
    }
    
	@Override
	public T queryByPrimaryKey(String id) {
		return id == null ? null : getBaseDAO().selectByPrimaryKey(id);
	}

	@Override
	public int doInsert(T record) {
	    record.setDefaultValue();
		return getBaseDAO().insert(record);
	}

	@Override
	public int doUpdate(T record) {
		record.setDefaultValue();
		return getBaseDAO().updateByPrimaryKeySelective(record);
	}

	@Override
	public int doDelete(String id) {
		return getBaseDAO().deleteByPrimaryKey(id);
	}

	@Override
	public int doInvalidate(String id) {
        T record = queryByPrimaryKey(id);
        record.setValidity(StatusEnum.INVALID.getBooleanValue());
        return doUpdate(record);
	}
	
	@Override
	public int doInvalidate(T t) {
	    t.setValidity(StatusEnum.INVALID.getBooleanValue());
	    return doUpdate(t);
	}
	
	@Override
    public int doRevalidate(String id) {
        T record = queryByPrimaryKey(id);
        record.setValidity(StatusEnum.VALID.getBooleanValue());
        return doUpdate(record);
    }
	
	@Override
	public int doRevalidate(T t) {
	    t.setValidity(StatusEnum.VALID.getBooleanValue());
	    return doUpdate(t);
	}
	
    @Override
    public int doSave(T record) {
        T old = queryByPrimaryKey(record.getId());
        if (old == null) {
            return doInsert(record);
        } else {
            return doUpdate(record);
        }
    }
    
    protected boolean isConflict(T obj, String fieldName, Object value) {
        boolean isConflict = false;
        try {
            @SuppressWarnings("unchecked")
            T condition = (T) obj.getClass().newInstance();
            ReflectUtils.setVal(condition, fieldName, value);
            List<T> list = getBaseDAO().queryPagedList(condition);
            if (list.size() > 0) {
                boolean idNotEquation = !list.get(0).getId().equals(obj.getId());
                if (obj.getId() == null ? true : idNotEquation) {
                    isConflict = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new SystemException(e);
        }
        return isConflict;
    }
}

