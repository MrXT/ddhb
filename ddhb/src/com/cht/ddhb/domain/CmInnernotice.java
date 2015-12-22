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

public class CmInnernotice extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  内部公告id
     */
    @IdKey
    private String innernoticeId;

    /**
     *  公告名称
     */
    private String name;

    /**
     *  内容
     */
    private String content;

    /**
     *  发布人id
     */
    private String userId;

    /**
     *  发布时间
     */
    private Date creaetime;

    public String getInnernoticeId() {
        return innernoticeId;
    }

    public void setInnernoticeId(String innernoticeId) {
        this.innernoticeId = innernoticeId == null ? null : innernoticeId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreaetime() {
        return creaetime;
    }

    public void setCreaetime(Date creaetime) {
        this.creaetime = creaetime;
    }
}