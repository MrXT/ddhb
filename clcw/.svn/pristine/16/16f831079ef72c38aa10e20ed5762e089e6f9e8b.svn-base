/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;
import com.manzz.framework.core.web.serializer.CustomDateHHMMSerializer;
import com.manzz.framework.core.web.serializer.CustomDateSerializer;

import java.util.Date;

public class FmWtFrequency extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  班次编号
     */
    @IdKey
    private String frequencyId;

    /**
     *  班线编号（关联班线表ID
     */
    private String classlineId;

    /**
     *  车辆编号（关联车辆表ID
     */
    private String carsId;

    /**
     *  司机编号（关联司机表ID
     */
    private String driverId;

    /**
     *  拼接班次对应的车辆与司机（_car车牌,司机ID,司机ID_car车牌,司机ID,司机ID_）
     */
    private String carSDrivers;
    
    public String getCarSDrivers() {
        return carSDrivers;
    }
    
    public void setCarSDrivers(String carSDrivers) {
        this.carSDrivers = carSDrivers;
    }

    /**
     *  票量
     */
    private Integer ticketcount;

    /**
     *  票价
     */
    private Integer ticketfacevalue;

    /**
     *  发车日期
     */
    private Date departuredate;

    /**
     *  发车时间
     */
    private Date departuretime;

    /**
     *  班次状态(-1:关闭，1代表开启) FrequencyStatusEnum.java
     */
    private Integer status;

    /**
     *  发布日期
     */
    private Date releasedatetime;

    /**
     *  
     */
    private String sitename;

    public String getFrequencyId() {
        return frequencyId;
    }

    public void setFrequencyId(String frequencyId) {
        this.frequencyId = frequencyId == null ? null : frequencyId.trim();
    }

    public String getClasslineId() {
        return classlineId;
    }

    public void setClasslineId(String classlineId) {
        this.classlineId = classlineId == null ? null : classlineId.trim();
    }

    public String getCarsId() {
        return carsId;
    }

    public void setCarsId(String carsId) {
        this.carsId = carsId == null ? null : carsId.trim();
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId == null ? null : driverId.trim();
    }

    public Integer getTicketcount() {
        return ticketcount;
    }

    public void setTicketcount(Integer ticketcount) {
        this.ticketcount = ticketcount;
    }

    public Integer getTicketfacevalue() {
        return ticketfacevalue;
    }

    public void setTicketfacevalue(Integer ticketfacevalue) {
        this.ticketfacevalue = ticketfacevalue;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getDeparturedate() {
        return departuredate;
    }

    public void setDeparturedate(Date departuredate) {
        this.departuredate = departuredate;
    }

    @JsonSerialize(using = CustomDateHHMMSerializer.class)
    public Date getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(Date departuretime) {
        this.departuretime = departuretime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getReleasedatetime() {
        return releasedatetime;
    }

    public void setReleasedatetime(Date releasedatetime) {
        this.releasedatetime = releasedatetime;
    }

    public String getSitename() {
        return sitename;
    }

    public void setSitename(String sitename) {
        this.sitename = sitename == null ? null : sitename.trim();
    }
}