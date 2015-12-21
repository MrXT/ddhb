package com.manzz.clcw.module.fm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manzz.clcw.common.enums.constant.OrderPayStatusEnum;
import com.manzz.clcw.domain.FmWtFrequency;
import com.manzz.clcw.domain.FmWtOrderform;
import com.manzz.clcw.module.fm.dao.FmWtFrequencyDAO;
import com.manzz.clcw.module.fm.dao.FmWtOrderformDAO;
import com.manzz.clcw.module.fm.dao.FmWtTicketsDAO;
import com.manzz.clcw.module.fm.service.FmWtOrderformService;
import com.manzz.clcw.module.fm.web.vo.TicketNumberVO;
import com.manzz.framework.core.exception.BusinessException;
import com.manzz.framework.core.service.PaginationServiceImpl;
import com.manzz.framework.core.util.CommonUtils;
import com.manzz.framework.core.util.DateUtils;
import com.manzz.framework.core.util.MobileUtil;
import com.manzz.framework.core.util.MobileUtil.Result;
/**
 * @author XXXX
 * @version:2015-9-17
 */
@Service("fmWtOrderformService")
public class FmWtOrderformServiceImpl extends PaginationServiceImpl<FmWtOrderform> implements FmWtOrderformService{
	@Autowired
	private FmWtOrderformDAO fmWtOrderformDAO;
	@Autowired
	private FmWtTicketsDAO fmWtTicketsDAO;
	@Autowired
	private FmWtFrequencyDAO fmWtFrequencyDAO;
	
	@Override
	public void doUpdateOrderStatus(String orderID, String tradeCode, String buyerEmail, String tradeStatus){
		if(CommonUtils.hasEmpty(orderID,tradeCode,buyerEmail,tradeStatus)){
			throw new BusinessException("10000", errorMap.get("10000"));
		}
		FmWtOrderform orderForm = fmWtOrderformDAO.selectByPrimaryKey(orderID);
		if(orderForm == null){
			throw new BusinessException("30010", errorMap.get("30010"));
		}
		
		orderForm.setPaydatetime(new Date());//支付时间
		orderForm.setPaystatus(OrderPayStatusEnum.PAY.getIntValue());  //支付状态（-1.未付款 1.已支付 2.已退票 3.已过期） OrderPayStatusEnum.java
		orderForm.setPayaccount(buyerEmail);//支付帐号
		orderForm.setTradecode(tradeCode);//第三方交易号（用于退款）
		fmWtOrderformDAO.updateByPrimaryKey(orderForm);
		
		//发送票码等相关信息到手机上
		TicketNumberVO ticketNumberVO = fmWtTicketsDAO.queryTicketNumberVO(orderID);
		String phoneNum = ticketNumberVO.getMobile();
		String departureDate = ticketNumberVO.getDepartureDate();
		String departureTime = ticketNumberVO.getDepartureTime();
		String destination = ticketNumberVO.getDestination();
		String ticketNums = ticketNumberVO.getTicketNums();
		String ticketsiteName = ticketNumberVO.getTicketsiteName();
		
		String content = "购票成功，您的乘车码为" + ticketNums + "。票务信息：" 
					   + departureDate + " " + departureTime 
					   + "从" + ticketsiteName + "到" + destination 
					   + "。请提前到达乘车站点持乘车码检票乘车。";
    	
    	Result response = MobileUtil.send(phoneNum, content);
    	if (!Result.RESPONSE_OK.equals(response)) {
    		throw new BusinessException("41000", errorMap.get("41000"));
    	}
	}
	
	/**
     * 每隔1分钟执行一次
     */
    public void executeTask(){
    	doDelOrder();
    	doUpdateOrderPayStatus();
    }
    
    //清除十分钟未付款的订单
    public void doDelOrder(){
    	String now = DateUtils.toFormatDateString(new Date(), "yyyyMMddHHmmss");
    	FmWtOrderform condition = new FmWtOrderform();
    	condition.setPaystatus(OrderPayStatusEnum.NOPAY.getIntValue());//支付状态（-1.未付款 1.已支付 2.已退票 3.已过期） OrderPayStatusEnum.java
    	List<FmWtOrderform> orderList = fmWtOrderformDAO.queryPagedList(condition);
    	//如果要包括已过期状态(即 删除已过期3的订单), 则再查询一次, 然后list.addAll(Collection...) for循环合并后的list
//    	FmWtOrderform condition2 = new FmWtOrderform();
//    	condition.setPaystatus(OrderPayStatusEnum.EXPIRE.getIntValue());//支付状态（-1.未付款 1.已支付 2.已退票 3.已过期） OrderPayStatusEnum.java
//    	List<FmWtOrderform> orderList2 = fmWtOrderformDAO.queryPagedList(condition2);
//    	orderList.addAll(orderList2);
    	for(int i=0; i<orderList.size(); i++){
    		FmWtOrderform o = orderList.get(i);
    		Date orderDateTime = DateUtils.addMinutes(o.getOrderdatetime(), 10);
    		String datetime = DateUtils.toFormatDateString(orderDateTime, "yyyyMMddHHmmss");  //下单时间
    		if(Long.parseLong(now) > Long.parseLong(datetime)){
//    			if(now.compareTo(datetime)>0){
    			fmWtOrderformDAO.deleteByPrimaryKey(o.getId());
    			//删除该订单对应的票
    			fmWtTicketsDAO.deleteByOrderID(o.getId());
    		}
    	}
    }
    
    //已过发车时间的订单，未付款的订单变为已过期，该班次的剩余票数相应增加；
    public void doUpdateOrderPayStatus(){
    	String now = DateUtils.toFormatDateString(new Date(), "yyyyMMddHHmmss");
    	FmWtOrderform condition = new FmWtOrderform();
    	condition.setPaystatus(OrderPayStatusEnum.NOPAY.getIntValue());//支付状态（-1.未付款 1.已支付 2.已退票 3.已过期） OrderPayStatusEnum.java
    	List<FmWtOrderform> orderList = fmWtOrderformDAO.queryPagedList(condition);
    	for(int i=0; i<orderList.size(); i++){
    		FmWtOrderform order = orderList.get(i);
    		String frequencyId = order.getFrequencyId();
    		FmWtFrequency frequency = fmWtFrequencyDAO.selectByPrimaryKey(frequencyId);
    		Date departuredate = frequency.getDeparturedate();
        	Date departuretime = frequency.getDeparturetime();
        	String date = new SimpleDateFormat ("yyyyMMdd").format(departuredate);
        	String time = new SimpleDateFormat ("HHmmss").format(departuretime);
        	String datetime = date+time;
        	if(datetime.compareTo(now) < 0 ){    	//判断 日期， 时间
        		order.setPaystatus(OrderPayStatusEnum.EXPIRE.getIntValue());
        		order.setTicketno(0);
        		fmWtOrderformDAO.updateByPrimaryKey(order);
        	}
    	}
    }
}
