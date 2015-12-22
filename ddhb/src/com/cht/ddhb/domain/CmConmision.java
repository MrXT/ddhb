/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.domain;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.model.BaseEntity;

public class CmConmision extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  佣金id
     */
    @IdKey
    private String commisionId;

    /**
     *  年份
     */
    private Integer year;

    /**
     *  月份
     */
    private Integer month;

    /**
     *  这个月的佣金
     */
    private Long commisionMoney;

    /**
     *  用户id
     */
    private String userId;

    /**
     *  佣金发放状态
     */
    private Integer status;

    public String getCommisionId() {
        return commisionId;
    }

    public void setCommisionId(String commisionId) {
        this.commisionId = commisionId == null ? null : commisionId.trim();
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Long getCommisionMoney() {
        return commisionMoney;
    }

    public void setCommisionMoney(Long commisionMoney) {
        this.commisionMoney = commisionMoney;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}