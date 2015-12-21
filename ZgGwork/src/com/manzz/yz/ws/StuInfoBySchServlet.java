package com.manzz.yz.ws;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manzz.yz.util.HttpUtils;
import com.manzz.yz.util.JSONUtil;
import com.manzz.yz.vo.RequestParameter;


/**
 * 查询院校下面的学生报名数据信息
 */
public class StuInfoBySchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuInfoBySchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String pageindex = request.getParameter("pageindex");
	    String pagesize = request.getParameter("pagesize");
	    String mc = request.getParameter("mc");//学员名称模糊查询
	    String drivecode = request.getParameter("drivecode");//驾校id，不能为空
	    String sfzh = request.getParameter("sfzh");//身份证号
	    if(mc == null){mc ="";}
	    if(sfzh == null){sfzh ="";}
	    request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_StuInfoBySchQuery", "{\"pageindex\":"+(pageindex!=null?Integer.parseInt(pageindex):null)+",\"pagesize\":"+(pagesize!=null?Integer.parseInt(pagesize):null)+",\"drivecode\":\""+drivecode+"\",\"sfzh\":\""+sfzh+"\",\"mc\":\""+mc+"\"}");
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx", JSONUtil.beanToJson(requestParameter));
        //System.out.println(JSONUtil.beanToJson(requestParameter));
        PrintWriter out = response.getWriter();
        out.print(resJson);
        out.close();
	}
	
	public static void main(String[] args) {
	    /*RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_StudentStatistic", JSONUtil.beanToJson(new Parameter(null,null,null,"2011-01-01","2015-10-10")));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx",JSONUtil.beanToJson(requestParameter));
        System.out.println(resJson);*/
        RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_StuInfoBySchQuery", "{\"pageindex\":1,\"pagesize\":20,\"drivecode\":\"51030000000008\",\"sfzh\":\"\",\"mc\":\"黄连臣\"}");
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx",JSONUtil.beanToJson(requestParameter));
        System.out.println(resJson);
    }

}
