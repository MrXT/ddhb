/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;

public class SmUserInfo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  ID
     */
    @IdKey
    private String userinfoId;

    /**
     *  用户表（B端）ID
     */
    private String userId;

    /**
     *  所属公司
     */
    private String company;

    /**
     *  
     */
    private String sub;

    public String getUserinfoId() {
        return userinfoId;
    }

    public void setUserinfoId(String userinfoId) {
        this.userinfoId = userinfoId == null ? null : userinfoId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub == null ? null : sub.trim();
    }
}