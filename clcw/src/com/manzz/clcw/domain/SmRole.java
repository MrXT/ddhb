/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;

public class SmRole extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  角色ID
     */
    @IdKey
    private String roleId;

    /**
     *  角色名称
     */
    private String roleName;

    /**
     *  角色描述
     */
    private String roleDescription;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription == null ? null : roleDescription.trim();
    }
}