
package com.manzz.gps.module.cm.web.vo;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.web.serializer.CustomDateTimeSerializer;
import com.manzz.gps.domain.CmWtCars;


public class CarGpsVo extends CmWtCars{
    
    private static final long serialVersionUID = -6133590775253248097L;
    private int longitude;
    private Integer latitude;
    private Date gpsdatetime;
    private Date recvdatetime;
    
    public int getLongitude() {
        return longitude;
    }
    
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }
    
    public Integer getLatitude() {
        return latitude;
    }
    
    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getGpsdatetime() {
        return gpsdatetime;
    }
    
    public void setGpsdatetime(Date gpsdatetime) {
        this.gpsdatetime = gpsdatetime;
    }
    @JsonSerialize(using = CustomDateTimeSerializer.class)
    public Date getRecvdatetime() {
        return recvdatetime;
    }
    
    public void setRecvdatetime(Date recvdatetime) {
        this.recvdatetime = recvdatetime;
    }
    
}

