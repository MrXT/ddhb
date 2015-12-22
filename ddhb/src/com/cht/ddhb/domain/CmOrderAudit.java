/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.domain;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.model.BaseEntity;
import com.cht.framework.core.web.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;

public class CmOrderAudit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  工程单审核id
     */
    @IdKey
    private String orderAuditId;

    /**
     *  审核内容
     */
    private String content;

    /**
     *  工程订单id
     */
    private String projectorderId;

    /**
     *  审核人id
     */
    private String userId;

    /**
     *  创建时间
     */
    private Date createtime;

    public String getOrderAuditId() {
        return orderAuditId;
    }

    public void setOrderAuditId(String orderAuditId) {
        this.orderAuditId = orderAuditId == null ? null : orderAuditId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getProjectorderId() {
        return projectorderId;
    }

    public void setProjectorderId(String projectorderId) {
        this.projectorderId = projectorderId == null ? null : projectorderId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}