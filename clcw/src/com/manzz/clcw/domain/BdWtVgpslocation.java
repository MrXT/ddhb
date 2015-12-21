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

public class BdWtVgpslocation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  
     */
    @IdKey
    private String vid;

    /**
     *  
     */
    private Integer longitude;

    /**
     *  
     */
    private Integer latitude;

    /**
     *  
     */
    private Integer direction;

    /**
     *  
     */
    private Integer speed;

    /**
     *  
     */
    private Date gpsdatetime;

    /**
     *  
     */
    private Date recvdatetime;

    /**
     *  
     */
    private Integer datasource;

    /**
     *  
     */
    private String vehno;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getGpsdatetime() {
        return gpsdatetime;
    }

    public void setGpsdatetime(Date gpsdatetime) {
        this.gpsdatetime = gpsdatetime;
    }

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getRecvdatetime() {
        return recvdatetime;
    }

    public void setRecvdatetime(Date recvdatetime) {
        this.recvdatetime = recvdatetime;
    }

    public Integer getDatasource() {
        return datasource;
    }

    public void setDatasource(Integer datasource) {
        this.datasource = datasource;
    }

    public String getVehno() {
        return vehno;
    }

    public void setVehno(String vehno) {
        this.vehno = vehno == null ? null : vehno.trim();
    }
}