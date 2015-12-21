package com.manzz.clcw.module.fm.web.vo;

public class TicketNumberVO {
	private String mobile;//手机号
	private String departureDate;//出发日期
	private String departureTime;//出发时间
	private String destination;//目的地
	private String ticketNums;//多个票码用都逗号隔开
	private String ticketsiteName;//上车站点
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getTicketNums() {
		return ticketNums;
	}
	public void setTicketNums(String ticketNums) {
		this.ticketNums = ticketNums;
	}
	public String getTicketsiteName() {
		return ticketsiteName;
	}
	public void setTicketsiteName(String ticketsiteName) {
		this.ticketsiteName = ticketsiteName;
	}
	
	
}
