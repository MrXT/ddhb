package com.manzz.clcw.module.fm.web.vo;

import java.math.BigDecimal;
import java.util.List;

public class OrderformVO {
	private String customerID;
	/**
	 * 手机号
	 */
	private String phoneNum;
	/**
	 * 订单ID
	 */
	private String orderID;
	/**
     *  班次编号（关联班次表ID）
     */
    private String frequencyId;
    /**
     *  支付状态（-1.未付款 1.已支付 2.已退票 3.已过期）OrderPayStatusEnum.java
     */
    private Integer paystatus;
	private String paystatusName;
	 /**
     *  票价
     */
    private BigDecimal ticketprice;
    /**
     *  购票数量
     */
    private Integer ticketno;
    /**
     *  总价
     */
    private BigDecimal amount;
    /**
     *  发车日期
     */
    private String departuredate;
    /**
     *  发车时间
     */
    private String departuretime;
    /**
     *  途径站点编码集合
     */
    private String siteList;
    /**
     *  途经站点名称集合
     */
    private String sitename;
	/**
	 * 起始站点
	 */
	private String startPoint;
	/**
	 * 终站点
	 */
	private String endPoint;
	/**
     *  班线名称
     */
    private String classlineName;
    /**
     *  出发地编码
     */
    private Integer departure;
    /**
     *  目的地编码
     */
    private Integer destination;
    /**
     *  出发地名称
     */
	private String departureName;
	/**
     *  目的地名称
     */
	private String destinationName;
	/**
	 * 票表
	 */
	private List<TicketVO> ticketList;
	
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getFrequencyId() {
		return frequencyId;
	}
	public void setFrequencyId(String frequencyId) {
		this.frequencyId = frequencyId;
	}
	public Integer getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(Integer paystatus) {
		this.paystatus = paystatus;
	}
	public String getPaystatusName() {
		return paystatusName;
	}
	public void setPaystatusName(String paystatusName) {
		this.paystatusName = paystatusName;
	}
	public BigDecimal getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(BigDecimal ticketprice) {
		this.ticketprice = ticketprice;
	}
	public Integer getTicketno() {
		return ticketno;
	}
	public void setTicketno(Integer ticketno) {
		this.ticketno = ticketno;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getDeparturedate() {
		return departuredate;
	}
	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}
	public String getDeparturetime() {
		return departuretime;
	}
	public void setDeparturetime(String departuretime) {
		this.departuretime = departuretime;
	}
	public String getSiteList() {
		return siteList;
	}
	public void setSiteList(String siteList) {
		this.siteList = siteList;
	}
	public String getSitename() {
		return sitename;
	}
	public void setSitename(String sitename) {
		this.sitename = sitename;
	}
	public String getStartPoint() {
		return startPoint;
	}
	public void setStartPoint(String startPoint) {
		this.startPoint = startPoint;
	}
	public String getEndPoint() {
		return endPoint;
	}
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}
	public String getClasslineName() {
		return classlineName;
	}
	public void setClasslineName(String classlineName) {
		this.classlineName = classlineName;
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
	public String getDepartureName() {
		return departureName;
	}
	public void setDepartureName(String departureName) {
		this.departureName = departureName;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	public List<TicketVO> getTicketList() {
		return ticketList;
	}
	public void setTicketList(List<TicketVO> ticketList) {
		this.ticketList = ticketList;
	}
}
