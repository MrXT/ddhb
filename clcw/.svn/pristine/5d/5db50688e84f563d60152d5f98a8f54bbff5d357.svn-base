package com.manzz.clcw.module.ws.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manzz.clcw.module.ws.service.WebService;
import com.manzz.framework.core.common.Constants;

@Controller
@RequestMapping("/ws")
public class WsController {
    @Autowired
    private WebService webServcie;
    
    /** 1.1 生成验证码 */
    @RequestMapping(value = "/appGenValidCode", method = RequestMethod.POST)
    @ResponseBody
    public Object appGenValidCode(String phoneNum, Integer validCodeType) {
        return webServcie.doGenValidCode(phoneNum, validCodeType);
    }
    
    /** 1.2 手机注册 */
    @RequestMapping(value = "/appRegist", method = RequestMethod.POST)
    @ResponseBody
    public Object appRegist(String phoneNum,String password) {
        return webServcie.doRegist(phoneNum,password);
    }
    
    /** 1.3 手机登录返回用户信息 */
    @RequestMapping(value = "/appLogon", method = RequestMethod.POST)
    @ResponseBody
    public Object appLogon(String phoneNum, String password) {
        return webServcie.doAppLogon(phoneNum,password);
    }
    
    /** 1.4 查询候车大厅 */
    @RequestMapping(value = "/appQueryWaitingRoom", method = RequestMethod.POST)
    @ResponseBody
    public Object appQueryWaitingRoom(String departuredate){
    	return webServcie.queryFrequencyList(null, null, departuredate,true);
    }
    
    /** 1.5 查询班次 */
    @RequestMapping(value = "/appQueryFrequencyList", method = RequestMethod.POST)
    @ResponseBody
    public Object appQueryFrequencyList(String departureCode,String destinationCode,String departuredate){
    	return webServcie.queryFrequencyList(departureCode, destinationCode, departuredate,false);
    }
    
    /** 1.6 更新用户密码 */
    @RequestMapping(value = "/appUpdatePwd", method = RequestMethod.POST)
    @ResponseBody
    public Object appUpdatePwd(String phoneNum,String oldPwd,String newPwd) {
        return webServcie.doUpdatePwd(phoneNum,oldPwd,newPwd);
    }
    
    /** 1.7 重置用户密码 */
    @RequestMapping(value = "/appResetPwd", method = RequestMethod.POST)
    @ResponseBody
    public Object appResetPwd(String phoneNum,String newPwd) {
        return webServcie.doResetPwd(phoneNum, newPwd);
    }
    
    /** 1.8 生成订单  */
    @RequestMapping(value = "/appAddOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object appAddOrder(String phoneNum, String frequencyId, String payway, Integer ticketno, String ticketSiteCode) {
        return webServcie.doAddOrder(phoneNum, frequencyId, payway, ticketno, ticketSiteCode);
    }
    
    /** 1.9 订单查询  */
    @RequestMapping(value = "/appQueryOrderList", method = RequestMethod.POST)
    @ResponseBody
    public Object appQueryOrderList(String phoneNum, String password) {
        return webServcie.queryOrderList(phoneNum, password);
    }

    /** 1.10 查询订单详情 */
    @RequestMapping(value = "/appQueryOrderDetail", method = RequestMethod.POST)
    @ResponseBody
    public Object appQueryOrderDetail(String orderID){
    	return webServcie.queryOrderDetail(orderID);
    }
    
    /** 1.11 取消订单*/
    @RequestMapping(value = "/appDelOrder", method = RequestMethod.POST)
    @ResponseBody
    public Object appDelOrder(String orderID) {
        return webServcie.doDelOrder(orderID);
    }
    
    /** 1.12 获取安卓版本信息 */
    @RequestMapping(value = "/appQueryAndroidVersion", method = RequestMethod.POST)
    @ResponseBody
    public Object appQueryAndroidVersion() {
        return webServcie.queryAndroidVersion();
    }
    
    
    /** 1.13 检票员登录 */
    @RequestMapping(value = "/appCheckTicketLogon", method = RequestMethod.POST)
    @ResponseBody
    public Object appCheckTicketLogon(String username, String password) {
        return webServcie.queryCheck(username, password,Constants.TELLER_OFFICER);
    }
    
    /** 1.14 验证票据  */
    @RequestMapping(value = "/appValidateTicket", method = RequestMethod.POST)
    @ResponseBody
    public Object appValidateTicket(String ticketnumber,String driverId) {
        return webServcie.validateTicket(ticketnumber,driverId);
    }
    
    /** 1.15 确定检票  */
    @RequestMapping(value = "/appConfirmTicket", method = RequestMethod.POST)
    @ResponseBody
    public Object appConfirmTicket(String ticketnumber) {
        return webServcie.doUpdateTicketCheckingStatus(ticketnumber);
    }

    /** 1.16 安检员登录  */
    @RequestMapping(value = "/appSecurityCheckLogon", method = RequestMethod.POST)
    @ResponseBody
    public Object appSecurityCheckLogon(String username, String password) {
        return webServcie.queryCheck(username, password,Constants.SECURITY_OFFICER);
    }
    
    /** 1.17 车牌查询  FrequencyController.java#searchCars() */
    @RequestMapping(value = "/appSearchCars", method = RequestMethod.POST)
    @ResponseBody
    public Object appSearchCars(String companyId) {
        return webServcie.queryCars(companyId);
    }
    
    /** 1.18 (不)通过安检: 公司ID，安检员，车牌号，安检状态：1通过，-1不通过*/
    @RequestMapping(value = "/appUpdateCheckStatus", method = RequestMethod.POST)
    @ResponseBody
    public Object appUpdateCheckStatus(String companyID,String inspector, String licenseplate, Integer checkStatus) {
        return webServcie.doUpdateCheckStatus(companyID, inspector, licenseplate, checkStatus);
    }
    
    /** 1.19 判断是否是游客 */
    @RequestMapping(value = "/appQueryVisitor", method = RequestMethod.POST)
    @ResponseBody
    public Object appQueryRegister(String phoneNum) {
        return webServcie.queryVisitor(phoneNum);
    }
    
    /** 1.20 从未付款订单进入时调用：修改订单号 */
    @RequestMapping(value = "/appQueryNopayorder", method = RequestMethod.POST)
    @ResponseBody
    public Object appUpdateOrderID(String orderID) {
        return webServcie.doNopayorder(orderID);
    }
    
    /** 1.21 查询所有出发地或目的地*/
    @RequestMapping(value = "/appQueryRegion", method = RequestMethod.POST)
    @ResponseBody
    public Object queryRegion() {
        return webServcie.queryRegion();
    }
    
}

