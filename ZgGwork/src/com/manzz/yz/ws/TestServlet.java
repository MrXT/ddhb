package com.manzz.yz.ws;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manzz.yz.util.HttpUtils;
import com.manzz.yz.util.JSONUtil;
import com.manzz.yz.vo.Parameter;
import com.manzz.yz.vo.RequestParameter;


/**
 * Servlet implementation class TestServlet
 */
//@WebServlet("/test")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    response.setContentType("application/json;charset=UTF-8");
	    RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_SchoolQuery", JSONUtil.beanToJson(new Parameter("", "", "","","")));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx", JSONUtil.beanToJson(requestParameter));
	    PrintWriter out = response.getWriter();
        out.print(resJson);
        out.close();
	}
	public static void main(String[] args) {
	    RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_SchoolQuery", JSONUtil.beanToJson(new Parameter(null,null,null,null,null)));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx",JSONUtil.beanToJson(requestParameter));
        System.out.println(resJson);
    }

}
