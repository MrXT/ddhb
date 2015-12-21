package com.manzz.yz.ws;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manzz.yz.util.HttpUtils;
import com.manzz.yz.util.JSONUtil;
import com.manzz.yz.vo.ParameterMore;
import com.manzz.yz.vo.RequestParameter;

/**
 * Servlet implementation class CarLocServlet
 */
public class CarLocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarLocServlet() {
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
		String ssdq = request.getParameter("ssdq");
	    String ssxs = request.getParameter("ssxs");
	    String mc = request.getParameter("mc");
	    String begin = request.getParameter("begin");//开始时间不能为null
	    String end = request.getParameter("end");//结束时间不能为null
	    String vehicle = request.getParameter("vehicle");
	    request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_LastLocatingQuery", JSONUtil.beanToJson(new ParameterMore(ssdq, ssxs, mc,begin,end,vehicle)));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx", JSONUtil.beanToJson(requestParameter));
        PrintWriter out = response.getWriter();
        out.print(resJson);
        out.close();
	}
	
	public static void main(String[] args) {
	    RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_LastLocatingQuery", JSONUtil.beanToJson(new ParameterMore(null,null,null,null,null,"川C0268学")));
	    String requestPara = JSONUtil.beanToJson(requestParameter);
	    String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx",requestPara);
        System.out.println(resJson);
    }
}
