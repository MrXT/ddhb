/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.domain;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.model.BaseEntity;

public class CmConmisionsetting extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  佣金设置id
     */
    @IdKey
    private String commisionsettingId;

    /**
     *  佣金类型1为特殊2为统一
     */
    private Integer type;

    /**
     *  佣金种类1：区域
2：专卖
3：微商
     */
    private Integer kind;

    /**
     *  
     */
    private Integer minRebate;

    /**
     *  返佣率(%)
     */
    private Integer maxRebate;

    /**
     *  代理人id
     */
    private String userId;

    public String getCommisionsettingId() {
        return commisionsettingId;
    }

    public void setCommisionsettingId(String commisionsettingId) {
        this.commisionsettingId = commisionsettingId == null ? null : commisionsettingId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public Integer getMinRebate() {
        return minRebate;
    }

    public void setMinRebate(Integer minRebate) {
        this.minRebate = minRebate;
    }

    public Integer getMaxRebate() {
        return maxRebate;
    }

    public void setMaxRebate(Integer maxRebate) {
        this.maxRebate = maxRebate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}