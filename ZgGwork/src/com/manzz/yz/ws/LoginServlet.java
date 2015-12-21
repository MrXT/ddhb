package com.manzz.yz.ws;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manzz.yz.util.HttpUtils;
import com.manzz.yz.util.JSONUtil;
import com.manzz.yz.vo.RequestParameter;


/**
 * 用户登录接口
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
	    String username = request.getParameter("username");
	    String psw = request.getParameter("psw");
	    request.setCharacterEncoding("UTF-8");
	    String resJson = "";
	    String regEx = "[`·~!@#$^&*()=|{}':;'\"\",\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]";
	    Pattern pattern = Pattern.compile(regEx);
	    if(username == null || pattern.matcher(username).find()){
	        resJson = "{\"errmsg\":\"用户名为空或者包含非法字符！\",\"errcode\":0,\"datas\":null}";
	    }else if(pattern.matcher(psw).find()){
	        resJson = "{\"errmsg\":\"密码为空或者包含非法字符！\",\"errcode\":0,\"datas\":null}";
	    }else{
            response.setContentType("application/json;charset=UTF-8");
            RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_ZGYGLogin", "{\"username\":\""+username+"\",\"psw\":\""+psw+"\"}");
            resJson = HttpUtils.httpPost("http://manage.scjpw.com.cn/orderinterface/ZGYGService.aspx", JSONUtil.beanToJson(requestParameter));
	    }
        PrintWriter out = response.getWriter();
        out.print(resJson);
        out.close();
	}
	
	public static void main(String[] args) {
	    RequestParameter requestParameter = new RequestParameter("ZGYG_GetInfo", "Order_Get_ZGYGLogin", "{\"username\":\"ZiGongTest\",\"psw\":\"ZiGongTest\"}");
        String resJson = HttpUtils.httpPost("http://localhost:8080/ddhb/login","{\"username\":\"usr\",\"password\":\"password\"}");
        System.out.println(resJson);
//	    String regEx = "[`·~!@#$^&*()=|{}':;'\"\",\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]";
//	    String username = "ssssasda!sd";
//        Pattern pattern = Pattern.compile(regEx);
//	    System.out.println(username == null||pattern.matcher(username).find());
    }

}
