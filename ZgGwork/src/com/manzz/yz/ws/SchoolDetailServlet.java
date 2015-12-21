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
 * 查询自贡下面的驾校（详细）数据信息
 */
public class SchoolDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolDetailServlet() {
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
     * 所有的参数都可以为null
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String ssdq = request.getParameter("ssdq");
	    String ssxs = request.getParameter("ssxs");
	    String mc = new String(request.getParameter("mc").getBytes("iso-8859-1"),"UTF-8");
	    //String mc = request.getParameter("mc");
	    String begin = request.getParameter("begin");
	    String end = request.getParameter("end");
	    request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_SchoolDetailQuery", JSONUtil.beanToJson(new Parameter(ssdq, ssxs, mc,begin,end)));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx", JSONUtil.beanToJson(requestParameter));
        PrintWriter out = response.getWriter();
        //System.out.println(mc+"=="+JSONUtil.beanToJson(requestParameter));
        out.print(resJson);
        out.close();
	}
	
	public static void main(String[] args) {
	    RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_SchoolDetailQuery", JSONUtil.beanToJson(new Parameter("51030000", "51030000","自贡市汇川实业有限公司",null,null)));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx",JSONUtil.beanToJson(requestParameter));
        System.out.println(resJson);
    }

}
