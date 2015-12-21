/**
 * create by XXXX
 * @date 2015-09-17
 */
package com.manzz.clcw.domain;

import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;

public class FmWtTickets extends BaseEntity {
    private static final long serialVersionUID = 1L;
    
    /**
     *  车票ID
     */
    @IdKey
    private String id;
    /**
     *  订单ID
     */
    private String orderid;

    /**
     *  车票票码
     */
    private String ticketnumber;

    /**
     *  售票站点
     */
    private String ticketsite;

    /**
     *  检票站点
     */
    private String checkingsite;

    /**
     *  检票状态(0 未检票 1已检票)
     */
    private Integer checkingstatus;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getTicketnumber() {
        return ticketnumber;
    }

    public void setTicketnumber(String ticketnumber) {
        this.ticketnumber = ticketnumber == null ? null : ticketnumber.trim();
    }

    public String getTicketsite() {
        return ticketsite;
    }

    public void setTicketsite(String ticketsite) {
        this.ticketsite = ticketsite == null ? null : ticketsite.trim();
    }

    public String getCheckingsite() {
        return checkingsite;
    }

    public void setCheckingsite(String checkingsite) {
        this.checkingsite = checkingsite == null ? null : checkingsite.trim();
    }

	public Integer getCheckingstatus() {
		return checkingstatus;
	}

	public void setCheckingstatus(Integer checkingstatus) {
		this.checkingstatus = checkingstatus;
	}
}
