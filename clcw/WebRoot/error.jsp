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
		<title>错误页面</title>
		<script type="text/javascript" src="<%=basePath%>/resources/js/jquery.min.js"></script>
		<script>   
			jQuery(function($){
				$("#errorMessageDiv").hide();
			});
			function showErrorMessage(){                
				$("#errorMessageDiv").toggle();
			}   
		</script>
	</head>
	<body>
		<h2>错误提示</h2>
		系统出现了异常，请重新登录。<br/>
		如果问题重复出现，请联系系统管理员。<br/><br/>
		<input type="button" onclick="relogin('<%=basePath%>/relogin')" value="重新登录"><br/><br/>
		<a id="showErrorMessageButton" href="javascript:showErrorMessage();">详细错误信息</a>
		<div id="errorMessageDiv">
			<%
				if(exception!=null){
			%>
				<%=exception.getMessage()%>
				<%=exception.getLocalizedMessage()%>
			<%
					StringWriter sw=new StringWriter();
					PrintWriter pw=new PrintWriter(sw);
					exception.printStackTrace(pw);
					out.print(sw);
				}else{
			%>
				    404错误，找不到该页面
			<%
				}
			%>
		</div>
	</body>
</html>