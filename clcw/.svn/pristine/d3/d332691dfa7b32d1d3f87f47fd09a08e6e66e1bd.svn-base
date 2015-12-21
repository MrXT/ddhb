/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.manzz.framework.core.model.BaseEntity;

@JsonIgnoreProperties(value = { "regionFirstletter", "regionPinyin", "extRegionCode", "id"})
public class BdGtRegion extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  地域编码
     */
    private Integer regionCode;

    /**
     *  拼音缩写
     */
    private String regionFirstletter;

    /**
     *  地域名称
     */
    private String regionRegionname;

    /**
     *  拼音
     */
    private String regionPinyin;

    /**
     *  
     */
    private String extRegionCode;

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public String getRegionFirstletter() {
        return regionFirstletter;
    }

    public void setRegionFirstletter(String regionFirstletter) {
        this.regionFirstletter = regionFirstletter == null ? null : regionFirstletter.trim();
    }

    public String getRegionRegionname() {
        return regionRegionname;
    }

    public void setRegionRegionname(String regionRegionname) {
        this.regionRegionname = regionRegionname == null ? null : regionRegionname.trim();
    }

    public String getRegionPinyin() {
        return regionPinyin;
    }

    public void setRegionPinyin(String regionPinyin) {
        this.regionPinyin = regionPinyin == null ? null : regionPinyin.trim();
    }

    public String getExtRegionCode() {
        return extRegionCode;
    }

    public void setExtRegionCode(String extRegionCode) {
        this.extRegionCode = extRegionCode == null ? null : extRegionCode.trim();
    }
}