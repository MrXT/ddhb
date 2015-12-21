/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;

public class SmFunction extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  功能id
     */
    @IdKey
    private String functionId;

    /**
     *  父ID
     */
    private String parentId;

    /**
     *  功能名称
     */
    private String displayName;

    /**
     *  
     */
    private String controller;

    /**
     *  
     */
    private String action;

    /**
     *  序号（排序使用）
     */
    private Integer orders;

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId == null ? null : functionId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName == null ? null : displayName.trim();
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller == null ? null : controller.trim();
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action == null ? null : action.trim();
    }

    public Integer getOrders() {
        return orders;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }
}