/**
 * create by XXXX
 * @date 2015-09-21
 */
package com.manzz.gps.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;
import com.manzz.framework.core.web.serializer.CustomDateSerializer;

import java.util.Date;

public class CmWtCars extends BaseEntity{
    private static final long serialVersionUID = 6054943179227377792L;

    /**
     *  null
     */
    @IdKey
    private String carId;

    /**
     *  null
     */
    private String licenseplate;

    /**
     *  null
     */
    private String licenseplatecolor;

    /**
     *  null
     */
    private String models;

    /**
     *  null
     */
    private Integer passengers;

    /**
     *  null
     */
    private String licensenumber;

    /**
     *  null
     */
    private String transportpermits;


    /**
     *  null
     */
    private Date createdate;

    /**
     *  null
     */
    private String ownername;

    /**
     *  null
     */
    private String typelv;

    /**
     *  null
     */
    private String techlv;

    /**
     *  null
     */
    private String scopebusiness;

    /**
     *  null
     */
    private Date becertificationdate;

    /**
     *  null
     */
    private Date encertificationdate;

    /**
     *  null
     */
    private Date betechdate;

    /**
     *  null
     */
    private Date entechdate;

    /**
     *  null
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

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername == null ? null : ownername.trim();
    }

    public String getTypelv() {
        return typelv;
    }

    public void setTypelv(String typelv) {
        this.typelv = typelv == null ? null : typelv.trim();
    }

    public String getTechlv() {
        return techlv;
    }

    public void setTechlv(String techlv) {
        this.techlv = techlv == null ? null : techlv.trim();
    }

    public String getScopebusiness() {
        return scopebusiness;
    }

    public void setScopebusiness(String scopebusiness) {
        this.scopebusiness = scopebusiness == null ? null : scopebusiness.trim();
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBecertificationdate() {
        return becertificationdate;
    }

    public void setBecertificationdate(Date becertificationdate) {
        this.becertificationdate = becertificationdate;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEncertificationdate() {
        return encertificationdate;
    }

    public void setEncertificationdate(Date encertificationdate) {
        this.encertificationdate = encertificationdate;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getBetechdate() {
        return betechdate;
    }

    public void setBetechdate(Date betechdate) {
        this.betechdate = betechdate;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getEntechdate() {
        return entechdate;
    }

    public void setEntechdate(Date entechdate) {
        this.entechdate = entechdate;
    }

    public String getFreeze() {
        return freeze;
    }

    public void setFreeze(String freeze) {
        this.freeze = freeze == null ? null : freeze.trim();
    }
}