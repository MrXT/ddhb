
package com.manzz.yz.vo;

/**
 * 
 * @author fc
 * 
 * 违规培训请求参数实体
 *
 */
public class ParameterMore {
    /**
     * 所属地区
     */
    private String ssdq;
    /**
     * 所属县所
     */
    private String ssxs;
    /**
     * 名称
     */
    private String mc;
    /**
     * 报名起始时间
     */
    private String begin;
    /**
     * 报名结束时间
     */
    private String end;
    
    private String vehicle;//车牌号

	public ParameterMore(String ssdq, String ssxs, String mc, String begin,
			String end, String vehicle) {
		super();
		this.ssdq = ssdq;
		this.ssxs = ssxs;
		this.mc = mc;
		this.begin = begin;
		this.end = end;
		this.vehicle = vehicle;
	}

	public String getSsdq() {
		return ssdq;
	}

	public void setSsdq(String ssdq) {
		this.ssdq = ssdq;
	}

	public String getSsxs() {
		return ssxs;
	}

	public void setSsxs(String ssxs) {
		this.ssxs = ssxs;
	}

	public String getMc() {
		return mc;
	}

	public void setMc(String mc) {
		this.mc = mc;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}
}

