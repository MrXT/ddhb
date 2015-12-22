/**
 * create by XT
 * @date 2015-12-22
 */
package com.cht.ddhb.domain;

import com.cht.framework.core.annotation.IdKey;
import com.cht.framework.core.model.BaseEntity;

public class CmShop extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  专卖店id
     */
    @IdKey
    private String shopId;

    /**
     *  专卖店名称
     */
    private String name;

    /**
     *  专卖店地址
     */
    private String address;

    /**
     *  店主id
     */
    private String userId;

    /**
     *  区域代理id
     */
    private String areaId;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }
}