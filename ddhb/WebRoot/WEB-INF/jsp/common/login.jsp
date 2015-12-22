<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="basePath" value="<%=basePath%>" scope="request" />
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="utf-8">
        <base href="${basePath}"/>
        <title>后台登录</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
						
        <!-- CSS -->
        <link rel="stylesheet" href="resources/assets/css/reset.css">
        <link rel="stylesheet" href="resources/assets/css/supersized.css">
        <link rel="stylesheet" href="resources/assets/css/style.css">
		<script src="resources/js/common/common.js"></script>
		<script src="resources/js/jquery.min.js"></script> <!-- jQuery Library -->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
				<script>
				function sub(){
				$.ajax({
					url:"/ddhb/login/valid",
					type:"POST",
					contentType:"application/json;charset=utf-8",
					dataType:"json",
		data:"{\"username\":\"admin\",\"password\":\"c4ca4238a0b923820dcc509a6f75849b\",\"vcode\":\""+$("#vcode").val()+"\"}",
		success:function(result){
			alert(result)
		}
		});
				}
				</script>
    </head>
    <body>

        <div class="page-container">
            <h1>滴滴环保后台系统</h1>
            <form id="loginForm">
                <input type="text" name="username" class="username" placeholder="用户名">
                <input type="password" name="password" class="password" placeholder="密码">
                <input type="text" id="vcode" name="vcode" /><img src="/ddhb/vcode">
                <button type="button" onclick="sub();" id="loginBtn">登录</button>
                <div class="error"><span>+</span></div>
            </form>
        </div>

        <!-- Javascript -->
        <script src="resources/assets/js/jquery-1.8.2.min.js"></script>
        <script src="resources/assets/js/supersized.3.2.7.min.js"></script>
        <script src="resources/assets/js/supersized-init.js"></script>
        <script src="resources/assets/js/scripts.js"></script>

    </body>

</html>
