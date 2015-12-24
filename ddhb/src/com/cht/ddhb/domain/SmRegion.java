/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.domain;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.model.BaseEntity;

public class SmRegion extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  行政编码
     */
    @IdKey
    private String regionId;

    /**
     *  所在地区
     */
    private String name;
    /**
     *  父级id
     */
    private String parentId;

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    
    public String getParentId() {
        return parentId;
    }

    
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    
}