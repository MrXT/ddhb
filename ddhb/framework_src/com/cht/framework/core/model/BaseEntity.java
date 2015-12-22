package com.cht.framework.core.model;

import java.io.Serializable;
import java.util.Date;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.util.ReflectUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 基础实体对象
 * @author WJK
 * @version 2015-08
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2403825263026437472L;
    protected Short companyId;
    @JsonIgnore
    protected String operId;
    @JsonIgnore
    protected Date operTime;
    @JsonIgnore
    protected Boolean validity = true;
    @JsonIgnore
    protected String sort;// 排序字段
    @JsonIgnore
    protected String order;// 排序方式：asc、desc
    @JsonIgnore
    protected Boolean isFuzzyQuery = false;// 是否进行模糊查询
    @JsonIgnore
    protected int page;
    @JsonIgnore
    protected int rows;
    
    public void setId(String id){
        ReflectUtils.setFieldByAnnatation(this,id,IdKey.class);
    }
    
    public String getId() {
        return ReflectUtils.getFieldByAnnatation(this, String.class, IdKey.class);
    }

    public Boolean getValidity() {
        return validity;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getId() != null && obj instanceof BaseEntity && ((BaseEntity) obj).getId() != null) {
            return this.getId().equals(((BaseEntity) obj).getId());
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getName() + " id = " + getId();
    }

    public Short getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Short companyId) {
        this.companyId = companyId;
    }

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    //@JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }
    
    public Boolean getIsFuzzyQuery() {
        return isFuzzyQuery;
    }
    
    public void setIsFuzzyQuery(Boolean isFuzzyQuery) {
        this.isFuzzyQuery = isFuzzyQuery;
    }

    public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setDefaultValue() {
        operTime = new Date();
    }
}