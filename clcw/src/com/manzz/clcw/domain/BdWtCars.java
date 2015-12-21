/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;
import com.manzz.framework.core.web.serializer.CustomDateSerializer;
import java.util.Date;

public class BdWtCars extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  车辆自增UID
     */
    @IdKey
    private String carId;

    /**
     *  车牌号
     */
    private String licenseplate;

    /**
     *  车牌颜色
     */
    private String licenseplatecolor;

    /**
     *  
     */
    private String models;
    /*
     * 技术等级
     */
    private String technicalgrade;
    
    public String getTechnicalgrade() {
        return technicalgrade;
    }

    
    public void setTechnicalgrade(String technicalgrade) {
        this.technicalgrade = technicalgrade;
    }

    /**
     *  
     */
    private Integer passengers;

    /**
     *  
     */
    private String licensenumber;

    /**
     *  
     */
    private String transportpermits;

    /**
     *  
     */
    private String company;

    /**
     *  
     */
    private Date createdate;

    /**
     *  冻结0,未冻结1
     */
    private String freeze;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId == null ? null : carId.trim();
    }

    public String getLicenseplate() {
        return licenseplate;
    }

    public void setLicenseplate(String licenseplate) {
        this.licenseplate = licenseplate == null ? null : licenseplate.trim();
    }

    public String getLicenseplatecolor() {
        return licenseplatecolor;
    }

    public void setLicenseplatecolor(String licenseplatecolor) {
        this.licenseplatecolor = licenseplatecolor == null ? null : licenseplatecolor.trim();
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models == null ? null : models.trim();
    }

    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    public String getLicensenumber() {
        return licensenumber;
    }

    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber == null ? null : licensenumber.trim();
    }

    public String getTransportpermits() {
        return transportpermits;
    }

    public void setTransportpermits(String transportpermits) {
        this.transportpermits = transportpermits == null ? null : transportpermits.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze == null ? null : freeze.trim();
    }
}