package com.manzz.clcw.module.ws.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.manzz.clcw.common.enums.constant.FrequencyStatusEnum;
import com.manzz.clcw.common.enums.constant.OrderPayStatusEnum;
import com.manzz.clcw.domain.AndroidVersion;
import com.manzz.clcw.domain.BdGtRegion;
import com.manzz.clcw.domain.BdWtCars;
import com.manzz.clcw.domain.BdWtDriver;
import com.manzz.clcw.domain.FmWtFrequency;
import com.manzz.clcw.domain.FmWtOrderform;
import com.manzz.clcw.domain.FmWtSecurityrecord;
import com.manzz.clcw.domain.FmWtTickets;
import com.manzz.clcw.domain.PsMobile;
import com.manzz.clcw.domain.SmCustomers;
import com.manzz.clcw.domain.validcode.MobileValidteCode;
import com.manzz.clcw.module.bd.dao.BdGtRegionDAO;
import com.manzz.clcw.module.bd.dao.BdWtCarsDAO;
import com.manzz.clcw.module.bd.dao.BdWtDriverDAO;
import com.manzz.clcw.module.bd.web.vo.BdWtCarsVo;
import com.manzz.clcw.module.fm.dao.FmWtFrequencyDAO;
import com.manzz.clcw.module.fm.dao.FmWtOrderformDAO;
import com.manzz.clcw.module.fm.dao.FmWtSecurityrecordDAO;
import com.manzz.clcw.module.fm.dao.FmWtTicketsDAO;
import com.manzz.clcw.module.fm.web.vo.FrequencyVO;
import com.manzz.clcw.module.fm.web.vo.OrderformVO;
import com.manzz.clcw.module.fm.web.vo.TicketVO;
import com.manzz.clcw.module.sm.dao.SmCustomersDAO;
import com.manzz.clcw.module.sm.dao.SmUserDAO;
import com.manzz.clcw.module.ws.service.WebService;
import com.manzz.clcw.module.ws.vo.CheckTicketVO;
import com.manzz.clcw.module.ws.vo.CheckUserVO;
import com.manzz.framework.core.common.Constants;
import com.manzz.framework.core.exception.BusinessException;
import com.manzz.framework.core.service.BaseServiceImpl;
import com.manzz.framework.core.util.CommonUtils;
import com.manzz.framework.core.util.DateUtils;
import com.manzz.framework.core.util.GuidUtils;
import com.manzz.framework.core.util.MobileUtil;
import com.manzz.framework.core.util.StringUtils;

public class WebServiceImpl extends BaseServiceImpl<SmCustomers> implements WebService {
	@Autowired
    private PsMobile mobile;
	@Autowired
	private SmCustomersDAO customersDAO;
	@Autowired
	private FmWtFrequencyDAO fmWtFrequencyDAO;
	@Autowired
	private FmWtOrderformDAO fmWtOrderformDAO;
	@Autowired
	private FmWtTicketsDAO fmWtTicketsDAO;
	@Autowired
	private SmUserDAO smUserDAO;
	@Autowired
	private BdWtCarsDAO bdWtCarsDAO;
	@Autowired
	private FmWtSecurityrecordDAO fmWtSecurityrecordDAO;
	@Autowired
	private BdWtDriverDAO bdWtDriverDAO;
	@Autowired
	private BdGtRegionDAO bdGtRegionDAO;
	
	private Map<String, MobileValidteCode> validateCodeTypes;
	
	/**
     * 1.1 生成验证码并发送短信给手机
     * @param validCode 手机验证码实现类
     * @param validCodeType 验证码类型
     * @see spring.xml -> <bean id="validateCodeTypes" class="java.util.Map">
     */
    public String doGenValidCode(String phoneNum, Integer validCodeType){
    	// 参数校验
        if (!MobileUtil.isMobile(phoneNum)) {
            throw new BusinessException("10001", errorMap.get("10001"));
        } 
        if (validCodeType == null ) {
            throw new BusinessException("10007", errorMap.get("10007"));
        }
    	MobileValidteCode mvc = validateCodeTypes.get(String.valueOf(validCodeType));
        if (mvc == null) {
            throw new BusinessException("10007",errorMap.get("10007"));
        }
        mobile.setPhoneNum(phoneNum);
        mvc.setMobile(mobile);
        return mvc.sendValidateCode();
    }
	
	/** 1.3 手机登录返回用户信息 */
	@Override
	public SmCustomers doAppLogon(String phoneNum, String password) {
		// 参数校验
        if (!MobileUtil.isMobile(phoneNum)) {
            throw new BusinessException("10001", errorMap.get("10001"));
        } else if (CommonUtils.hasEmpty(password)) {
            throw new BusinessException("10002", errorMap.get("10002"));
        }
		SmCustomers condition = new SmCustomers();
		condition.setPhoneNum(phoneNum);
		List<SmCustomers> customerList = customersDAO.queryPagedList(condition);
		if (CollectionUtils.isEmpty(customerList)) {
			throw new BusinessException("30001", errorMap.get("30001"));
		}else{
			SmCustomers customers = customerList.get(0);
			if( !customers.getPassword().trim().equals(password) ){
				throw new BusinessException("30003", errorMap.get("30003"));
			}
			return customers;
		}
	}
	
	 /** 1.2 手机注册 */
    @Override
    public int doRegist(String phoneNum, String password) {
        // 参数校验
        if (!MobileUtil.isMobile(phoneNum)) {
            throw new BusinessException("10001", errorMap.get("10001"));
        } else if (CommonUtils.hasEmpty(password)) {
            throw new BusinessException("10002", errorMap.get("10002"));
        }
        SmCustomers customer = new SmCustomers();
        customer.setPhoneNum(phoneNum);
        List<SmCustomers> customerList = customersDAO.queryPagedList(customer);
        if (CollectionUtils.isEmpty(customerList)) {// 未注册
        	customer.setId(GuidUtils.getGuid());
        	customer.setPassword(password);
        	return customersDAO.insert(customer);
        }else if(customerList.get(0).getPassword().equals("0")){
        	//对于未注册的游客来说，他自己是不晓得后台已经默认注册了，且密码为0
        	SmCustomers record = customerList.get(0);
        	record.setPassword(password);
        	return customersDAO.updateByPrimaryKey(record);
        }else{
        	throw new BusinessException("30002", errorMap.get("30002"));
        }
    }

    /** 1.4 查询候车大厅    1.5 查询班次 */
    @Override
	public List<FrequencyVO> queryFrequencyList(String departureCode,String destinationCode, String departuredate, boolean waitingRoomFlag) {
    	if(CommonUtils.hasEmpty(departuredate)){
			throw new BusinessException("10000", errorMap.get("10000"));
		}
    	try {
    		DateUtils.parseShortDateString(departuredate);
    	} catch (ParseException e) {
    		throw new BusinessException("10005", errorMap.get("10005"));
    	}
    	FrequencyVO frequencyVO = new FrequencyVO();
    	frequencyVO.setDeparturedate(departuredate);
    	frequencyVO.setWaitingRoomFlag(waitingRoomFlag);
    	//候车大厅isWaitingRoom==true  只返回今日5条数据  最近发车时间排序
    	//查询班次  isWaitingRoom == false
    	if(!waitingRoomFlag){
    		if(CommonUtils.hasEmpty(departureCode,destinationCode,departuredate)){
    			throw new BusinessException("10000", errorMap.get("10000"));
    		}
        	frequencyVO.setDepartureCode(departureCode);
        	frequencyVO.setDestinationCode(destinationCode);
    	}
    	List<FrequencyVO> frequencyVOList = fmWtFrequencyDAO.queryFrequencyList(frequencyVO);
    	for (FrequencyVO frequency : frequencyVOList) {
    		//根据班次查询所有的已用票量总计
        	int sum = fmWtOrderformDAO.querySumTicketNoByFrequencyId(frequency.getFrequencyId());
        	int remainTicket = Integer.parseInt(frequency.getTicketcount()) - sum ; //班次总票量 - 已买票量  =  剩余票量
        	frequency.setTicketcount(remainTicket+"");
        	if(remainTicket == 0){
        		frequency.setTicketState("售完");
        	}else{
        		frequency.setTicketState("订票");
        	}
    		frequency.setWaitingRoomFlag(waitingRoomFlag);
			String sites = frequency.getSites();
			if(StringUtils.hasText(sites)){
//				String siteNames = fmWtFrequencyDAO.querySiteNamesBySiteNumber(sites);
//				frequency.setSiteNames(siteNames);
				//直接用 frequency.getSiteNames() 便可以得到所有的站点集合名称
				sites = frequency.getDepartureCode() + "," + sites;
				String siteNames = frequency.getDeparture() + "," + frequency.getSiteNames();
				frequency.setSites(sites + "," + frequency.getDestinationCode());
				frequency.setSiteNames(siteNames + "," + frequency.getDestination());
				
				frequency.setDepartureSiteNumbers(sites);
				frequency.setDepartureSiteNames(siteNames);
			}else{
				frequency.setSites(frequency.getDepartureCode() + "," + frequency.getDestinationCode());
				frequency.setSiteNames(frequency.getDeparture() + "," + frequency.getDestination());
				
				frequency.setDepartureSiteNumbers(frequency.getDepartureCode());
				frequency.setDepartureSiteNames(frequency.getDeparture());
			}
			/**
			String startPoint =frequency.getDepartureCode();
			String endPoint = frequency.getDestinationCode();
			//出发地 站点集合
			List<Map<String, Object>> regionMap = fmWtFrequencyDAO.querySiteNumberAndNameByRegionCode(startPoint);
			Map<Integer, String> startSiteCodeName = getSiteCodeAndNameMap(regionMap);
			//目的地 站点集合
			List<Map<String, Object>> regionMap2 = fmWtFrequencyDAO.querySiteNumberAndNameByRegionCode(endPoint);
			Map<Integer, String> endSiteCodeName = getSiteCodeAndNameMap(regionMap2);
			if(StringUtils.hasText(sites)){  //sites!=null && sites.trim() != ""
				String[] siteArray = sites.split(",");
				String startSiteCode = "";
				String startSiteName = "";
				String endSiteName = "";
				for(int i=0; i<siteArray.length; i++){
					Integer siteCode = Integer.parseInt(siteArray[i]);
					if(startSiteCodeName.containsKey(siteCode)){
						startSiteCode = startSiteCode + siteCode + ",";
						startSiteName = startSiteName + startSiteCodeName.get(siteCode) + ",";
					}
					if(endSiteCodeName.containsKey(siteCode)){
						endSiteName = endSiteName + endSiteCodeName.get(siteCode) + ",";
					}
				}
				if(CommonUtils.hasEmpty(startSiteCode,startSiteName,endSiteName)){
			        throw new SystemException("班线wt_classline站点列表中的编码site_list 和 站点表wt_site中的站点编号sitenumber 不对应；\n 线路管理-->途径站点");
			    }
				//选择出发站点  集合code name
				frequency.setDepartureSiteNumbers(startSiteCode.substring(0, startSiteCode.length()-1));
				frequency.setDepartureSiteNames(startSiteName.substring(0, startSiteName.length()-1));
				//途径站点集合名称
				frequency.setSiteNames(startSiteName + endSiteName.substring(0, endSiteName.length()-1));
			}*/
		}
    	return frequencyVOList;
	}
    
    /**
	private Map<Integer, String> getSiteCodeAndNameMap(List<Map<String, Object>> regionMap) {
		Map<Integer,String> resultMap = new HashMap<>();
		for (Map<String, Object> map : regionMap) {
			Integer sitenumber = null;
			String sitename = null;
			
			for(Map.Entry<String, Object> entry: map.entrySet()){
				if(entry.getKey().toLowerCase().equals("sitenumber")){
					sitenumber = (Integer) entry.getValue();
				}else if(entry.getKey().toLowerCase().equals("sitename")){
					sitename = (String)entry.getValue();
				}
			}
			resultMap.put(sitenumber, sitename);
		}
		return resultMap;
	}*/
    
    /** 1.6 更新用户密码  */
    @Override
	public int doUpdatePwd(String phoneNum, String oldPwd, String newPwd) {
        if (CommonUtils.hasEmpty(phoneNum,oldPwd,newPwd)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
        //根据 手机号进行查询
        SmCustomers condition = new SmCustomers();
        condition.setPhoneNum(phoneNum);
        SmCustomers customer = customersDAO.queryPagedList(condition).get(0);
    	// 验证参数   如果是游客，因为游客不知道旧密码，但生成订单时会默认新增消费者并且密码为0，
//        if( !StringUtils.hasText(oldPwd) && customer.getPassword().trim().equals("0")){
//        	customer.setPassword(newPwd);
//        	return customersDAO.updateByPrimaryKey(customer);
//        }else 
        if(customer.getPassword().equals(oldPwd)){
        	customer.setPassword(newPwd);
        	return customersDAO.updateByPrimaryKey(customer);
        }else {
            throw new BusinessException("30007", errorMap.get("30007"));
        }
	}
    
    /** 1.7 重置用户密码 */
    @Override
    public int doResetPwd(String phoneNum, String newPwd) {
    	if (!MobileUtil.isMobile(phoneNum)) {
            throw new BusinessException("10001", errorMap.get("10001"));
        } else if (CommonUtils.hasEmpty(newPwd)) {
            throw new BusinessException("10002", errorMap.get("10002"));
        }
    	// 验证参数   如果是游客，因为游客不知道旧密码，但生成订单时会默认新增消费者并且密码为0，
    	SmCustomers condition = new SmCustomers();
    	condition.setPhoneNum(phoneNum);
        List<SmCustomers> memberList = customersDAO.queryPagedList(condition);
        if (CollectionUtils.isEmpty(memberList)) {
			throw new BusinessException("30001", errorMap.get("30001"));
		}else{
			SmCustomers customer = memberList.get(0);
			customer.setPassword(newPwd);
			return customersDAO.updateByPrimaryKey(customer);
		}
    }
    
    /** 1.8 生成订单 */
    @Override
	public String[] doAddOrder(String phoneNum, String frequencyId, String payway, Integer ticketno, String ticketSiteCode) {
    	if (CommonUtils.hasEmpty(phoneNum,frequencyId,payway,ticketSiteCode)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
    	if(ticketno < 0){
    		throw new BusinessException("30014", errorMap.get("30014"));
    	}
    	//根据  班次ID  得到 票价，班次状态，发车时间（不能超过当前日期时间） 
    	FmWtFrequency frequency = fmWtFrequencyDAO.selectByPrimaryKey(frequencyId);
    	if(frequency.getStatus() == FrequencyStatusEnum.CLOSE.getIntValue()){//班次状态(-1:关闭，1代表开启) FrequencyStatusEnum.java
    		throw new BusinessException("30009", errorMap.get("30009"));
    	}
    	Date departuredate = frequency.getDeparturedate();
    	Date departuretime = frequency.getDeparturetime();
    	String date = new SimpleDateFormat ("yyyyMMdd").format(departuredate);
    	String time = new SimpleDateFormat ("HHmmss").format(departuretime);
    	String datetime = date+time;
    	String now = new SimpleDateFormat ("yyyyMMddHHmmss").format(new Date());
    	if(datetime.compareTo(now) < 0 ){    	//判断 日期， 时间
    		throw new BusinessException("30008", errorMap.get("30008"));
    	}
    	Integer ticketfacevalue = frequency.getTicketfacevalue();//票价
    	int ticketCount = frequency.getTicketcount();//班次总票量
    	//根据班次查询所有的已用票量总计
    	int sum = fmWtOrderformDAO.querySumTicketNoByFrequencyId(frequencyId);
    	int remainTicket = ticketCount - sum - ticketno;// 剩余票量
    	if(remainTicket < 0){
    		throw new BusinessException("30011", errorMap.get("30011"));
    	}
    	//1:往customers 中插入数据，如果是游客身份则默认密码为0;  插入成功后返回主键
    	SmCustomers custmerCondition = new SmCustomers();
    	custmerCondition.setPhoneNum(phoneNum);
    	List<SmCustomers> customerList = customersDAO.queryPagedList(custmerCondition);
    	String customerId = "";
    	if (CollectionUtils.isEmpty(customerList)) {
    		SmCustomers customer = new SmCustomers();
    		customerId = GuidUtils.getGuid();//主键
    		customer.setId(customerId);
    		customer.setPhoneNum(phoneNum);
    		customer.setPassword("0");
    		customersDAO.insert(customer);
    	}else{
    		customerId = customerList.get(0).getId();
    	}
    	//2:往订单表wt_orderform 中插入数据,插入成功后返回主键
    	FmWtOrderform orderForm = new FmWtOrderform();
    	String orderID = GuidUtils.getGuid();//主键
    	orderForm.setId(orderID);
    	orderForm.setFrequencyId(frequencyId);
    	orderForm.setCustomersid(customerId);
    	Date orderDateTime = new Date();
    	orderForm.setOrderdatetime(orderDateTime);
    	orderForm.setPaystatus(OrderPayStatusEnum.NOPAY.getIntValue());//支付状态（-1.未付款 1.已支付 <2.已退票> 3.已过期） OrderPayStatusEnum.java
    	orderForm.setPayway(payway);
    	orderForm.setTicketprice(new BigDecimal(ticketfacevalue));
    	orderForm.setAmount( new BigDecimal(ticketfacevalue * ticketno));//总价
    	orderForm.setTicketno(ticketno);
    	fmWtOrderformDAO.insert(orderForm);
    	//3:往车票表wt_tickets 中插入数据
    	for(int i=0; i<ticketno; i++){
    		FmWtTickets ticket = new FmWtTickets();
        	ticket.setOrderid(orderID);
        	ticket.setTicketnumber(String.format("%06d", (new Random()).nextInt(1000000)));//票码6位
        	ticket.setTicketsite(ticketSiteCode);
        	ticket.setCheckingstatus(0);//检票状态(0 未检票 1已检票)
        	fmWtTicketsDAO.insert(ticket);
    	}
    	//req6.生成订单时，该班次的剩余票数相应减少；  通过SQL计算出来的
//		frequency.setTicketcount(ticketCount - ticketno);
//		fmWtFrequencyDAO.updateByPrimaryKey(frequency);
		String[] s = {orderID,DateUtils.toLongDateString(orderDateTime)};
    	return s;
	}
    
    /** 1.9 订单查询 */
    @Override
	public List<OrderformVO> queryOrderList(String phoneNum, String password) {
    	if (CommonUtils.hasEmpty(phoneNum,password)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
    	//1查询 消费者表,2订单表：3班次表： 4班线表：5线路表：6车票表：
    	SmCustomers cusCondition = new SmCustomers();
    	cusCondition.setPhoneNum(phoneNum);
    	if( !password.trim().equals("0") ){
    		cusCondition.setPassword(password);
    	}
    	List<SmCustomers> customersList =customersDAO.queryPagedList(cusCondition);
    	if(CollectionUtils.isEmpty(customersList)){
    		throw new BusinessException("30006", errorMap.get("30006"));
    	}
    	String customerID = customersList.get(0).getId();
    	List<OrderformVO> orderList = fmWtOrderformDAO.queryOrderformVOList(customerID,null);
    	for(int i=0; i< orderList.size(); i++){
    		orderList.get(i).setCustomerID(customerID);
    		orderList.get(i).setPhoneNum(customersList.get(0).getPhoneNum());
    		String orderID = orderList.get(i).getOrderID();
    		List<TicketVO> ticketVOList = fmWtTicketsDAO.queryTicketVOByOrderID(orderID);
    		orderList.get(i).setTicketList(ticketVOList);//票码
    	}
		return orderList;
	}
    
    /** 1.10 查询订单详情 */
    public List<OrderformVO> queryOrderDetail(String orderID) {
    	if (CommonUtils.hasEmpty(orderID)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
    	FmWtOrderform order = fmWtOrderformDAO.selectByPrimaryKey(orderID);
    	SmCustomers customers = customersDAO.selectByPrimaryKey(order.getCustomersid());
    	List<OrderformVO> orderList = fmWtOrderformDAO.queryOrderformVOList(null, orderID);
    	for(int i=0; i< orderList.size(); i++){
    		orderList.get(i).setCustomerID(customers.getId());
    		orderList.get(i).setPhoneNum(customers.getPhoneNum());
    		List<TicketVO> ticketVOList = fmWtTicketsDAO.queryTicketVOByOrderID(orderID);
    		orderList.get(i).setTicketList(ticketVOList);//票码
    	}
    	return orderList;
    }
    
	
    /** 1.11 取消订单*/
    @Override
	public int doDelOrder(String orderID) {
    	if (CommonUtils.hasEmpty(orderID)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
    	//orderID 既是  订单表的主键， 也是  车票表中 外键，   唯一
    	int i = fmWtTicketsDAO.deleteByOrderID(orderID);
    	if(i > 0 ){//一个订单可能对应多张票
    		return fmWtOrderformDAO.deleteByPrimaryKey(orderID);
    	}
		return 0;
	}
    
    /** 1.12 获取安卓版本信息 */
    @Override
    public AndroidVersion queryAndroidVersion() {
        return new AndroidVersion();
    }
    
    /** 1.13 1.16 检票(安检)员登录 */
	@Override
	public CheckUserVO queryCheck(String username, String password, String roleName) {
		CheckUserVO checkUser = smUserDAO.queryCheck(username,roleName); //安检 和 票检
		//司机也可以进行安检，用  username:手机号 + password:从业资格证后8位
		if(checkUser == null){
			BdWtDriver condition = new BdWtDriver();
			condition.setPhone(username);
			List<BdWtDriver> driverList = bdWtDriverDAO.queryPagedList(condition);
			if(CollectionUtils.isNotEmpty(driverList)){
				BdWtDriver driver = driverList.get(0);
				String certificateNumber = driver.getCertificatenumber();
				String str = certificateNumber.substring(certificateNumber.length()-8, certificateNumber.length());
				if(password.equals(str)){
					CheckUserVO checkUserVO = new CheckUserVO();
					checkUserVO.setUserID(driver.getDriverId());
					checkUserVO.setUserName(driver.getFullname());
					checkUserVO.setUserPassword(str);
					checkUserVO.setCompanyID(driver.getCompany());
					return checkUserVO;
				}else{
					throw new BusinessException("30003", errorMap.get("30003"));		
				}
			}
			throw new BusinessException("30006", errorMap.get("30006"));
		}
		if(password.equals(checkUser.getUserPassword())){
			return checkUser;
		}else{
			throw new BusinessException("30003", errorMap.get("30003"));
		}
	}

	/** 1.14 验证票据 */
	@Override
	public CheckTicketVO validateTicket(String ticketnumber,String driverId) {
		if (CommonUtils.hasEmpty(ticketnumber,driverId)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
		CheckTicketVO ticketVO = fmWtTicketsDAO.validateTicket(ticketnumber,driverId); 
		if(ticketVO == null){
			throw new BusinessException("30012", errorMap.get("30012"));
		}
		return ticketVO;
	}
	
	/** 1.15 确定检票  */
	@Override
	public int doUpdateTicketCheckingStatus(String ticketnumber) {
		if (CommonUtils.hasEmpty(ticketnumber)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
		FmWtTickets ticketCondition = new FmWtTickets();
		ticketCondition.setTicketnumber(ticketnumber);
		List<FmWtTickets> ticketList = fmWtTicketsDAO.queryPagedList(ticketCondition);
		if(CollectionUtils.isEmpty(ticketList)){
			throw new BusinessException("30012", errorMap.get("30012"));
		}
		FmWtTickets ticket = ticketList.get(0);
		if(ticket.getCheckingstatus() == 1){
			throw new BusinessException("30013", errorMap.get("30013"));
		}
		ticket.setCheckingstatus(1);//检票状态(0 未检票 1已检票)
		return fmWtTicketsDAO.updateByPrimaryKey(ticket);
	}
	
	/** 1.17 车牌查询  FrequencyController.java#searchCars() return List<BdWtCars> */
	@Override
	public List<BdWtCars> queryCars(String companyId){
		if (CommonUtils.hasEmpty(companyId)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
		BdWtCars condition = new BdWtCars();
		condition.setCompany(companyId);
		condition.setFreeze("0");//查询未冻结的车辆
		List<BdWtCars> carList = bdWtCarsDAO.queryPagedList(condition);
		
		BdWtCarsVo carsVo = new BdWtCarsVo();
		carsVo.setCompany(companyId);
		carsVo.setFreeze("0");
		carsVo.setCheckstatus(1);//已经通过的车
		//已经通过然后变成 待安检，xt只会修改该条记录的状态而不会增量添加一条 待安检的记录  
		List<BdWtCarsVo> carsVOList = bdWtCarsDAO.queryByCarsVoByCondition(carsVo);
		
		//删除 已经通过的 车
		Iterator<BdWtCars> cars = carList.iterator();
		while(cars.hasNext()){  
			BdWtCars car = cars.next();  
			for(int i=0; i<carsVOList.size(); i++){
				if(car.getCarId().equals(carsVOList.get(i).getCarId())){
					cars.remove();
				}
			}
		}
		return carList;
	}
	
	/** 1.18 (不)通过安检 */
	@Override
	public int doUpdateCheckStatus(String companyID, String inspector, String licenseplate, Integer checkStatus){
		if (CommonUtils.hasEmpty(companyID,inspector,licenseplate)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
		//安检状态：0待安检，1通过，-1不通过
		if(checkStatus != null && checkStatus != Constants.CAR_PASS && checkStatus != Constants.CAR_NOPASS){
			throw new BusinessException("10000", errorMap.get("10000"));
		}
		FmWtSecurityrecord securityrecord = new FmWtSecurityrecord();
		securityrecord.setLicenseplate(licenseplate);
		securityrecord.setCheckstatus(checkStatus);
		securityrecord.setInspector(inspector);
		securityrecord.setCheckdatetime(new Date());
		securityrecord.setCompany(companyID);
		return fmWtSecurityrecordDAO.insert(securityrecord);
	}
	
	/** 1.19 判断是否是游客 */
	@Override
	public boolean queryVisitor(String phoneNum){
		if (!MobileUtil.isMobile(phoneNum)) {
            throw new BusinessException("10001", errorMap.get("10001"));
        }
		SmCustomers condition = new SmCustomers();
		condition.setPhoneNum(phoneNum);
		List<SmCustomers> customerList = customersDAO.queryPagedList(condition);
		if (CollectionUtils.isEmpty(customerList)) {
			throw new BusinessException("30001", errorMap.get("30001"));
		}else{
			SmCustomers customers = customerList.get(0);
			if( customers.getPassword().trim().equals("0") ){
				return true;
			}
		}
		return false;
	}
	
	/** 1.20 从未付款订单进入时调用：修改订单号,删除老订单，老票 */
	@Override
	public String[] doNopayorder(String orderID){
		if (CommonUtils.hasEmpty(orderID)) {
            throw new BusinessException("10000", errorMap.get("10000"));
        }
    	FmWtOrderform order = fmWtOrderformDAO.selectByPrimaryKey(orderID);
    	if(order == null){
    		 //1.判断传入的订单号是否在数据库存在,不存在说明已经超时被删
    		throw new BusinessException("30015", errorMap.get("30015"));
    	}
    	if(order.getPaystatus() == 3){
    		throw new BusinessException("30016", errorMap.get("30016"));
    	}
    	SmCustomers customers = customersDAO.selectByPrimaryKey(order.getCustomersid());
    	List<OrderformVO> orderList = fmWtOrderformDAO.queryOrderformVOList(null, orderID);
    	for(int i=0; i< orderList.size(); i++){
    		orderList.get(i).setCustomerID(customers.getId());
    		orderList.get(i).setPhoneNum(customers.getPhoneNum());
    		List<TicketVO> ticketVOList = fmWtTicketsDAO.queryTicketVOByOrderID(orderID);
    		orderList.get(i).setTicketList(ticketVOList);//票码
    	}
	     //2.判断发车时间是否超过当前时间,如果超过,错误提示 
		OrderformVO orderForm = orderList.get(0);
		String departuredate = orderForm.getDeparturedate();
		String departuretime = orderForm.getDeparturetime();
    	String datetime = departuredate+" "+departuretime;
    	String now = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(new Date());
    	if(datetime.compareTo(now) < 0 ){    	//判断 日期， 时间
    		throw new BusinessException("30008", errorMap.get("30008"));
    	}
        //3.修改订单号, 返回: 订单号 + 创建订单的时间(首次创建的时间)
    	FmWtOrderform source = fmWtOrderformDAO.selectByPrimaryKey(orderID);
    	FmWtOrderform target = new FmWtOrderform();
    	BeanUtils.copyProperties(source, target);
    	Date orderdatetime = source.getOrderdatetime(); 
    	String newOrderID = GuidUtils.getGuid(); 
    	target.setId(newOrderID);
    	fmWtOrderformDAO.deleteByPrimaryKey(orderID);
    	fmWtOrderformDAO.insert(target);
    	
    	FmWtTickets ticketCondition = new FmWtTickets();
    	ticketCondition.setOrderid(orderID);
    	List<FmWtTickets> ticketsList = fmWtTicketsDAO.queryPagedList(ticketCondition);
    	for(int i=0; i<ticketsList.size(); i++){
    		FmWtTickets ticket = ticketsList.get(i);
    		FmWtTickets newObj = new FmWtTickets();	
    		BeanUtils.copyProperties(ticket, newObj);
    		newObj.setOrderid(newOrderID);
    		fmWtTicketsDAO.deleteByOrderID(orderID);
    		fmWtTicketsDAO.insert(newObj);
    	}
    	String[] s = {newOrderID,DateUtils.toLongDateString(orderdatetime)};
    	return s;
	}
	
	/** 1.21 查询所有出发地或目的地*/
	@Override
	public List<BdGtRegion> queryRegion(){
		BdGtRegion condition = new BdGtRegion();
		List<BdGtRegion> regionList = bdGtRegionDAO.queryPagedList(condition);
		return regionList;
	}
	
    
    public Map<String, MobileValidteCode> getValidateCodeTypes() {
        return validateCodeTypes;
    }

    public void setValidateCodeTypes(Map<String, MobileValidteCode> validateCodeTypes) {
        this.validateCodeTypes = validateCodeTypes;
    }

	

	
}