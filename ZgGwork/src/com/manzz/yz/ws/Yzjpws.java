package com.manzz.yz.ws;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tempuri.InterfaceUser;
import org.tempuri.MainServiceSoapProxy;
import org.tempuri.WeixinQueryStruct;

/**
 * Servlet implementation class Yzjpws
 */
public class Yzjpws extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Yzjpws() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=gb2312");
		response.setHeader("Cache-Control", "no-cache");
 	    response.setHeader("Pragma", "no-cache");
 	    response.setDateHeader("Expires", 0);
		
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
	    
		PrintWriter out = response.getWriter();
	    out.print(result);
	    out.close();
	}

}
