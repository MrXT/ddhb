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

public class CmWtVgpslocation extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  null
     */
    @IdKey
    private String vid;

    /**
     *  null
     */
    private Integer longitude;

    /**
     *  null
     */
    private Integer latitude;

    /**
     *  null
     */
    private Integer direction;

    /**
     *  null
     */
    private Integer speed;

    /**
     *  null
     */
    private Date gpsdatetime;

    /**
     *  null
     */
    private Date recvdatetime;

    /**
     *  null
     */
    private Integer datasource;

    /**
     *  null
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