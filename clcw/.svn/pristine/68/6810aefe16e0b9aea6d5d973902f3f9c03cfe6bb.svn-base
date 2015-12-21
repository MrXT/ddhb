package com.manzz.clcw.module.ws.service;

import java.util.List;

import com.manzz.clcw.domain.AndroidVersion;
import com.manzz.clcw.domain.BdGtRegion;
import com.manzz.clcw.domain.BdWtCars;
import com.manzz.clcw.domain.SmCustomers;
import com.manzz.clcw.module.fm.web.vo.FrequencyVO;
import com.manzz.clcw.module.fm.web.vo.OrderformVO;
import com.manzz.clcw.module.ws.vo.CheckTicketVO;
import com.manzz.clcw.module.ws.vo.CheckUserVO;


/**
 * 功能：WebService操作接口
 * @author WJK
 * @version 2015-07
 */
public interface WebService {

	/**
     * 1.1 生成验证码并发送短信给手机
     * @param validCode 手机验证码实现类
     * @param validCodeType 验证码类型
     * @see spring.xml -> <bean id="validateCodeTypes" class="java.util.Map">
     */
	String doGenValidCode(String phoneNum, Integer validCodeType);
	
	 /**
     * 1.2 手机注册
     * @param phoneNum 手机号
     * @param password 密码
     */
    int doRegist(String phoneNum, String password);
    
    /**
     * 1.3 手机登录返回用户信息
     * @param phoneNum 手机号
     * @param password 密码
     */
	SmCustomers doAppLogon(String phoneNum,String password);
	
	/**
	 * 1.4 查询候车大厅    1.5 查询班次
	 */
	List<FrequencyVO> queryFrequencyList(String departureCode,String destinationCode,String departuredate,boolean waitingRoomFlag);

	 /**
     * 1.6 更新用户密码 
     * @param phoneNum 手机号
     * @param oldPwd 原密码
     * @param newPwd 新密码
     */
    int doUpdatePwd(String phoneNum, String oldPwd, String newPwd);
	
    /**
     * 1.7 重置用户密码
     * @param phoneNum 手机号
     * @param newPwd 新密码
     */
    int doResetPwd(String phoneNum, String newPwd);

    /**
     * 1.8 生成订单
     * @param phoneNum 手机号 
     * @param frequencyId  班次ID
     * @param payway  支付方式
     * @param ticketno 票数
     * @param ticketsite上车站点 对应wt_tickets表里的售票站点
     * @return 订单编号
     */
	String[] doAddOrder(String phoneNum, String frequencyId, String payway, Integer ticketno, String ticketSiteCode);

	/** 1.9 订单查询 */
	List<OrderformVO> queryOrderList(String phoneNum, String password);
	
	/** 1.10 查询订单详情 */
    List<OrderformVO> queryOrderDetail(String orderID);

	/** 1.11 取消订单 */
	int doDelOrder(String orderID);

    /** 1.12 获取安卓版本信息 */
    AndroidVersion queryAndroidVersion();

    /** 1.13 1.16 检票员，安检员登录 */
    CheckUserVO queryCheck(String username, String password, String roleName);

    /** 1.14 验证票据  */
    CheckTicketVO validateTicket(String ticketnumber,String driverId);

    /** 1.15 确定检票  */
	int doUpdateTicketCheckingStatus(String ticketnumber);

	/** 1.17 车牌查询  FrequencyController.java#searchCars() */
	List<BdWtCars> queryCars(String companyId);

	/** 1.18 (不)通过安检 */
	int doUpdateCheckStatus(String companyID,String inspector, String licenseplate, Integer checkStatus);

	/** 1.19 判断是否是游客 */
	boolean queryVisitor(String phoneNum);
	
	/** 1.20 从未付款订单进入时调用：修改订单号 */
	public String[] doNopayorder(String orderID);

	/** 1.21 查询所有出发地或目的地*/
	List<BdGtRegion> queryRegion();
    
}