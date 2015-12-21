package com.manzz.yz.ws.order;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.RemoteException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.tempuri.ZGSerSoap;
import org.tempuri.ZGSerSoapProxy;

import com.manzz.yz.util.JSONUtil;
import com.manzz.yz.vo.order.Parameter;
import com.manzz.yz.vo.order.RequestParameter;


/**
 * 查询总预约条数接口
 */
public class AllCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllCountServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    doPost(request, response);
	}

	/**
     * new Parameter(schoolCode,pageSize,pageIndex,beginTime,endTime,keyStr)
     * type:类型（1自贡）
     * pageSize:每页条数
     * pageIndex：第几页
     * beginTime：开始时间
     * endTime：结束时间
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String type = request.getParameter("type");
	    String pageSize = request.getParameter("pageSize");
	    String pageIndex = request.getParameter("pageIndex");
	    String beginTime = request.getParameter("beginTime");
	    String endTime = request.getParameter("endTime");
	    request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        RequestParameter requestParameter = new RequestParameter(new Parameter((type!=null?Integer.parseInt(type):null), (pageSize!=null?Integer.parseInt(pageSize):null), pageIndex,beginTime,endTime));
        ZGSerSoap soap = new ZGSerSoapProxy();
        String resJson = soap.ZGQueryAllCount(JSONUtil.beanToJson(requestParameter));
        PrintWriter out = response.getWriter();
        out.print(resJson);
        out.close();
	}
	public static void main(String[] args) throws RemoteException {
	    ZGSerSoap soap = new ZGSerSoapProxy();
	    RequestParameter requestParameter = new RequestParameter(new Parameter(1, 20, "1",null,null));
	    String resJson = soap.ZGQueryAllCount(JSONUtil.beanToJson(requestParameter));
        System.out.println(resJson);
    }

}
