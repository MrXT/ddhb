package com.manzz.clcw.module.fm.web.vo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "waitingRoomFlag" })
public class FrequencyVO {
	// 出发地
	private String departure;
	// 目的地
	private String destination;
	// 出发地编码
	private String departureCode;
	// 目的地编码
	private String destinationCode;
	// 班次ID
	private String frequencyId;
	// 班次状态
	private String status;
	// 班线ID
	private String classlineId;
	// 班线名称
	private String classlineName;
	// 途径站点集合
	private String sites;
	// 途径站点集合名称
	private String siteNames;
	// 出发站点 集合
	private String departureSiteNumbers;
	// 出发站点 集合名称
	private String departureSiteNames;
	// 剩余票量
	private String ticketcount;
	// 票价
	private String ticketfacevalue;
	// 发车日期
	private String departuredate;
	// 发车时间
	private String departuretime;

	// 订票状态（售完/订票）
	private String ticketState;
	private boolean waitingRoomFlag;

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDepartureCode() {
		return departureCode;
	}

	public void setDepartureCode(String departureCode) {
		this.departureCode = departureCode;
	}

	public String getDestinationCode() {
		return destinationCode;
	}

	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}

	public String getFrequencyId() {
		return frequencyId;
	}

	public void setFrequencyId(String frequencyId) {
		this.frequencyId = frequencyId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClasslineId() {
		return classlineId;
	}

	public void setClasslineId(String classlineId) {
		this.classlineId = classlineId;
	}

	public String getTicketcount() {
		return ticketcount;
	}

	public void setTicketcount(String ticketcount) {
		this.ticketcount = ticketcount;
	}

	public String getTicketfacevalue() {
		return ticketfacevalue;
	}

	public void setTicketfacevalue(String ticketfacevalue) {
		this.ticketfacevalue = ticketfacevalue;
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

	public String getClasslineName() {
		return classlineName;
	}

	public void setClasslineName(String classlineName) {
		this.classlineName = classlineName;
	}

	public String getSites() {
		return sites;
	}

	public void setSites(String sites) {
		this.sites = sites;
	}

	public String getSiteNames() {
		return siteNames;
	}

	public void setSiteNames(String siteNames) {
		this.siteNames = siteNames;
	}

	public String getDepartureSiteNumbers() {
		return departureSiteNumbers;
	}

	public void setDepartureSiteNumbers(String departureSiteNumbers) {
		this.departureSiteNumbers = departureSiteNumbers;
	}

	public String getDepartureSiteNames() {
		return departureSiteNames;
	}

	public void setDepartureSiteNames(String departureSiteNames) {
		this.departureSiteNames = departureSiteNames;
	}

	public String getTicketState() {
		return ticketState;
	}

	public void setTicketState(String ticketState) {
		this.ticketState = ticketState;
	}

	public boolean isWaitingRoomFlag() {
		return waitingRoomFlag;
	}

	public void setWaitingRoomFlag(boolean waitingRoomFlag) {
		this.waitingRoomFlag = waitingRoomFlag;
	}
}
