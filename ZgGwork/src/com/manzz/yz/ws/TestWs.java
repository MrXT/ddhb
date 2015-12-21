package com.manzz.yz.ws;

import java.net.MalformedURLException;

import java.rmi.RemoteException;
import java.util.Calendar;

import javax.xml.rpc.ServiceException;

import org.tempuri.InterfaceUser;
import org.tempuri.MainServiceSoapProxy;
import org.tempuri.WeixinQueryStruct;

/**
 * @author ���� 
 * @version ����ʱ�䣺2015-12-2 ����10:42:50
 * ��˵��
 */
public class TestWs {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws ServiceException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws RemoteException, ServiceException, MalformedURLException {
		// TODO Auto-generated method stub
		
		InterfaceUser iuser = new InterfaceUser();
		iuser.setValStr("No!@34G0o*)b$D1@nJ");
		iuser.setCommand("Order_Weixin_StudentQuery");
		iuser.setValSerial("Order_GetInfo");
		
		WeixinQueryStruct weixin = new WeixinQueryStruct();
		weixin.setCertno("513822199007063190");
		weixin.setType("");
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 3, 1);
		weixin.setBegin(cal);
		weixin.setEnd(Calendar.getInstance());

		MainServiceSoapProxy service = new MainServiceSoapProxy();
		String result = service.genericFuctionJSON(iuser, weixin);
	    System.out.println(result);
	    
	    
	    //MainServiceSoap a = proxy.getMainServiceSoap();
	    
	    
	}

}
