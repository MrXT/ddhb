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
 * 查询自贡下面的车辆（详情）数据信息
 */
public class CarDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarDetailServlet() {
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
     * drivercode:驾校id
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");
	    String ssdq = request.getParameter("ssdq");
	    String ssxs = request.getParameter("ssxs");
	    String mc = request.getParameter("mc");
	    String begin = request.getParameter("begin");
	    String end = request.getParameter("end");
	    String drivecode = request.getParameter("drivecode");
        response.setContentType("application/json;charset=UTF-8");
        RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_CarDetailQuery", JSONUtil.beanToJson(new Parameter(ssdq, ssxs, mc,begin,end,drivecode)));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx", JSONUtil.beanToJson(requestParameter));
        PrintWriter out = response.getWriter();
        out.print(resJson);
        out.close();
	}

	public static void main(String[] args) {
	    RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_CarDetailQuery", JSONUtil.beanToJson(new Parameter("51030000","51030000","川C0337学",null,null,null)));
        String resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx",JSONUtil.beanToJson(requestParameter));
        System.out.println(resJson);
    }
}
