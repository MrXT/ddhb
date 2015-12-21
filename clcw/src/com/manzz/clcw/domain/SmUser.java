/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;

public class SmUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  用户id（b端）
     */
    @IdKey
    private String userId;

    /**
     *  用户名（B端）
     */
    private String userName;

    /**
     *      用户密码（B端） 
     */
    private String userPassword;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }
}