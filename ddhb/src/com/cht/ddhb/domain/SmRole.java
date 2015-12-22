/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.domain;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.model.BaseEntity;

public class SmRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  角色id
     */
    @IdKey
    private String roleId;

    /**
     *  姓名
     */
    private String name;

    /**
     *  描述
     */
    private String describle;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle == null ? null : describle.trim();
    }
}