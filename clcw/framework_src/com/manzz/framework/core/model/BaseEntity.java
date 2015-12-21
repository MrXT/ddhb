package com.manzz.framework.core.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.common.SessionHolder;
import com.manzz.framework.core.util.ReflectUtils;

/**
 * 基础实体对象
 * @author WJK
 * @version 2015-08
 */
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -2403825263026437472L;
    @JsonIgnore
    protected String companyId;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
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

    public void setDefaultValue() {
        operId = SessionHolder.getCurrentUser().getUserId();
        operTime = new Date();
    }
}