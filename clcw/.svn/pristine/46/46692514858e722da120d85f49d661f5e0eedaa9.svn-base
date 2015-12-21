<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page isErrorPage="true"%>
<%@ page isErrorPage="true" import="java.io.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<title>405错误页面</title>
		<script type="text/javascript" src="<%=basePath%>/resources/js/common.js"></script>
	</head>
	<body>
	    <div align="center" style="vertical-align:middle;top:40%;position:absolute;width:100%;height:100%;" />
		    <div align="center" />
				<font size="5" style="font-weight:bold">错误提示</font><br/><br/>
				请不要通过手动输入地址的方式进行访问。<br/><br/>
				<input type="button" onClick="relogin('<%=basePath%>/relogin')" value="重新登录"/>
		    </div>
	    </div>
	</body>
</html>