/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.domain;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.model.BaseEntity;
import com.cht.framework.core.web.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import java.util.Date;

public class CmProjectorder extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  工程单id
     */
    @IdKey
    private String projectorderId;

    /**
     *  工程单类型
     */
    private Integer type;

    /**
     *  工程单描述
     */
    private String describle;

    /**
     *  需要施工的地址
     */
    private String address;

    /**
     *  提交人id
     */
    private String userId;

    /**
     *  接收人id
     */
    private String receiverId;

    /**
     *  需要施工的联系电话
     */
    private String telephone;

    /**
     *  工程单的价钱（施工队完成后所填的）
     */
    private BigDecimal price;

    /**
     *  工程单状态
     */
    private Integer status;

    /**
     *  创建时间
     */
    private Date createtime;

    public String getProjectorderId() {
        return projectorderId;
    }

    public void setProjectorderId(String projectorderId) {
        this.projectorderId = projectorderId == null ? null : projectorderId.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDescrible() {
        return describle;
    }

    public void setDescrible(String describle) {
        this.describle = describle == null ? null : describle.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}