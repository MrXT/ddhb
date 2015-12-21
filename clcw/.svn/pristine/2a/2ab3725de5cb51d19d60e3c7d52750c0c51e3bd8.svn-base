/**
 * create by XXXX
 * @date 2015-09-11
 */
package com.manzz.clcw.domain;

import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;

public class LmWtLines extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     *  线路编号
     */
    @IdKey
    private String lineId;

    /**
     *  出发地
     */
    private Integer departure;

    /**
     *  目的地
     */
    private Integer destination;

    /**
     *  指导票价
     */
    private Integer ticketprice;

    /**
     *  所属公司
     */
    private String company;

    public String getLineId() {
        return lineId;
    }

    public void setLineId(String lineId) {
        this.lineId = lineId == null ? null : lineId.trim();
    }

    public Integer getDeparture() {
        return departure;
    }

    public void setDeparture(Integer departure) {
        this.departure = departure;
    }

    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public Integer getTicketprice() {
        return ticketprice;
    }

    public void setTicketprice(Integer ticketprice) {
        this.ticketprice = ticketprice;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }
}