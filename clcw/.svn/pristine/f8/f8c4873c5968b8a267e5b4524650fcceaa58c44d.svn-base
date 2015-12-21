/**
 * create by XXXX
 * @date 2015-09-17
 */
package com.manzz.clcw.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.manzz.framework.core.annotation.IdKey;
import com.manzz.framework.core.model.BaseEntity;
import com.manzz.framework.core.web.serializer.CustomDateSerializer;

import java.math.BigDecimal;
import java.util.Date;

public class FmWtOrderform extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@IdKey
	private String id;
	/**
	 * 班次编号（关联班次表ID）
	 */
	private String frequencyId;

	/**
	 * 客户编号（关联客户表ID）
	 */
	private String customersid;

	/**
	 * 下单时间
	 */
	private Date orderdatetime;

	/**
	 * 支付时间
	 */
	private Date paydatetime;

	/**
	 * 支付状态（-1.未付款 1.已支付 2.已退票 3.已过期） OrderPayStatusEnum.java
	 */
	private Integer paystatus;

	/**
	 * 支付方式
	 */
	private String payway;

	/**
	 * 支付帐号
	 */
	private String payaccount;

	/**
	 * 票价
	 */
	private BigDecimal ticketprice;

	/**
	 * 总价
	 */
	private BigDecimal amount;
	/**
	 * 第三方交易号（用于退款）
	 */
	private String tradecode;

	/**
     *  
     */
	private BigDecimal shullteprice;

	/**
	 * 购票数量
	 */
	private Integer ticketno;

	/**
     *  
     */
	private Integer isreview;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(String frequencyId) {
		this.frequencyId = frequencyId;
	}

	public String getCustomersid() {
		return customersid;
	}

	public void setCustomersid(String customersid) {
		this.customersid = customersid;
	}

	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getOrderdatetime() {
		return orderdatetime;
	}

	public void setOrderdatetime(Date orderdatetime) {
		this.orderdatetime = orderdatetime;
	}
	
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getPaydatetime() {
		return paydatetime;
	}

	public void setPaydatetime(Date paydatetime) {
		this.paydatetime = paydatetime;
	}

	public Integer getPaystatus() {
		return paystatus;
	}

	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}

	public String getPayway() {
		return payway;
	}

	public void setPayway(String payway) {
		this.payway = payway;
	}

	public String getPayaccount() {
		return payaccount;
	}

	public void setPayaccount(String payaccount) {
		this.payaccount = payaccount;
	}

	public BigDecimal getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(BigDecimal ticketprice) {
		this.ticketprice = ticketprice;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTradecode() {
		return tradecode;
	}

	public void setTradecode(String tradecode) {
		this.tradecode = tradecode;
	}

	public BigDecimal getShullteprice() {
		return shullteprice;
	}

	public void setShullteprice(BigDecimal shullteprice) {
		this.shullteprice = shullteprice;
	}

	public Integer getTicketno() {
		return ticketno;
	}

	public void setTicketno(Integer ticketno) {
		this.ticketno = ticketno;
	}

	public Integer getIsreview() {
		return isreview;
	}

	public void setIsreview(Integer isreview) {
		this.isreview = isreview;
	}
}