package com.manzz.yz.ws;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manzz.yz.util.HttpUtils;
import com.manzz.yz.util.JSONUtil;
import com.manzz.yz.vo.Parameter;
import com.manzz.yz.vo.RequestParameter;


/**
 * 查询自贡下地区的报名数
 */
public class StudentStatisticBySsxsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentStatisticBySsxsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * new Parameter(ssdq,ssxs,mc,begin,end)
	 * ssdq:所属地区
	 * ssxs:所属县所
	 * mc：名称
	 * begin：报名开始时间
	 * end：报名结束时间
	 * 除了begin与end不能为空，其他都可以为空（建议时间字符串类型为yyyy-MM-dd）
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String ssdq = request.getParameter("ssdq");
	    String ssxs = request.getParameter("ssxs");
	    String mc = request.getParameter("mc");
	    String begin = request.getParameter("begin");//开始时间不能为null
	    String end = request.getParameter("end");//结束时间不能为null
	    request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_StudentStatisticBySsxs", JSONUtil.beanToJson(new Parameter(ssdq, ssxs, mc,begin,end)));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx", JSONUtil.beanToJson(requestParameter));
        PrintWriter out = response.getWriter();
        out.print(resJson);
        out.close();
	}
	
	public static void main(String[] args) {
	    RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_StudentStatisticBySsxs", JSONUtil.beanToJson(new Parameter(null,null,null,"2011-01-01","2015-10-10")));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx",JSONUtil.beanToJson(requestParameter));
        System.out.println(resJson);
       
    }

}
