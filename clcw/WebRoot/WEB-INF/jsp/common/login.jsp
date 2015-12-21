<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<base href="${ctx}/"/>
    <title>车来车往后台系统管理平台—登录</title>
    <link href="${ctx}/resources/css/global.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/resources/js/jquery-1.7.1.js" type="text/javascript"></script>
    <script src="${ctx}/resources/js/tools.js" type="text/javascript"></script>
    <style type="text/css">
        *{padding:0;margin:0;box-sizing:content-box;-moz-box-sizing:content-box;-webkit-box-sizing:content-box;}
        ul,ol,li,p,h1,h2,h3,h4,h5,h6,form,fieldset,table,td,img,div,input,textarea,dl,dt,dd {margin:0;padding:0;font-family:"Arial","微软雅黑","黑体","simsun","宋体";}
        body{margin:0;padding:0;font-family:"Arial","微软雅黑","黑体","simsun","宋体";background:#fff;}
        
        #container{min-height:100%;position:relative;display:none;}
        #container .clcw{height:550px;background:#4c6a84;width:100%;color:#FFF;text-align:center;}
        #container .clcw .logo{width:100%;height:330px;float:left;position:absolute;left:0;top:60px;}
        #container .clcw .logo .img{width:408px;height:330px;margin:0 auto;background:url(${ctx}/resources/images/logo.png) no-repeat 0 0;}
        #container .clcw .city{width:100%;height:254px;position:absolute;top:295px;left:0;background:url(${ctx}/resources/images/city.png) repeat-x 140px 0; background-position:36px\9 0;}
        
        #content{min-height:349px;width:100%;}
        #content .login-mod{height:306px;background:#FFF;width:100%;color:#000;text-align:center;overflow:hidden;}
        #content .login-mod .inner{width:600px;margin:0 auto;height:226px;margin-top:40px;margin-bottom:40px;}
        #content .login-mod .inner div.ap{height:82px;}
        #content .login-mod .inner div.btn{height:62px;}
        #content .login-mod .inner div.btn input,#content .login-mod .inner div.ap input{width:400px;height:60px;line-height:60px\9;}
        #content .login-mod .inner div.ap input{background:#dcdddf;border:1px solid #dcdddf;color:#000;font-size:18px;-moz-border-radius:4px;-webkit-border-radius:4px;border-radius:4px;padding-left:20px;}
        #content .login-mod .inner div.ap input.active{border:1px solid #f6ad72;background-color:#fff;}
        #content .login-mod .inner div.ap input.error{border:1px solid #f6ad72;background:#fff;}
        #content .login-mod .inner div.btn input{width:422px;background:url(${ctx}/resources/images/icons.png) no-repeat -97px -297px;border:0;font-size:20px;font-family:微软雅黑;color:#fff;letter-spacing:2px;cursor:pointer;}
        
        ::-webkit-input-placeholder{color:#A9A9A9;font-family:SimSun;}
        :-moz-placeholder{color:#A9A9A9;font-family:SimSun;}
        .placeholder{color:#A9A9A9;font-family:SimSun;}
        #footer{position:absolute;bottom:0;padding:0;background-color:#dcdddf;width:100%;text-align:center;font-size:16px;height:50px;line-height:50px;font-family:宋体;color:#7a7b7b;}
        
    </style>
    
</head>
<script type="text/javascript">
    $(function () {
        if (($.browser.msie) && ($.browser.version < 7)) {
            Tools.closeWin("../System/Browser");
        }
        else {
            $("#container").show();
        }
    });
</script>
<body>
    <div id="container">
        <div class="clcw">
            <div class="logo">
                <div class="img"></div>
            </div>
            <div class="city"></div>
        </div>
        <div id="content">
            <div class="login-mod">
                <div class="inner">
                    <div class="ap">
                        <input type="text" id="account" name="account" autocomplete="off" placeholder="登录帐号" class="placeholder" value="" />
                    </div>
                    <div class="ap">
                        <input type="password" id="password" name="password" autocomplete="off" placeholder="密码" value="" />
                    </div>
                    <div class="btn">
                        <input type="button" id="login" name="login" value="登录" />
                    </div>
                </div>
            </div>
        </div>
       <jsp:include page="../common/footer.jsp"/> 
    </div>
</body>
<script src="${ctx}/resources/js/login.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        if (!isPlaceholder()) {
            $("input").not("input[type='password']").each(//把input绑定事件 排除password框
	            function () {
	                if ($(this).val() == "" && $(this).attr("placeholder") != "") {
	                    $(this).val($(this).attr("placeholder"));
	                    $(this).css("color", "#A9A9A9");
	                    $(this).css("font-family", "SimSun");
	                    $(this).focus(function () {
	                        if ($(this).val() == $(this).attr("placeholder")) $(this).val(""); $(this).css("color", "#000");
	                    });
	                    $(this).blur(function () {
	                        if ($(this).val() == "") {
	                            $(this).val($(this).attr("placeholder"));
	                            $(this).css("color", "#A9A9A9");
	                        }
	                    });
	                    $(this).val("");
	                    $(this).focus();
	                }
	            });
            //对password框的特殊处理1.创建一个text框 2获取焦点和失去焦点的时候切换
            pwdField = $("input[type=password]");
            pwdVal = pwdField.attr('placeholder');
            pwdField.after('<input id="pwdPlaceholder" type="text" value=' + pwdVal + ' autocomplete="off" />');
            pwdPlaceholder = $('#pwdPlaceholder');
            pwdPlaceholder.css("color", "#A9A9A9");
            pwdPlaceholder.css("font-family", "SimSun");
            pwdPlaceholder.show();
            pwdField.hide();

            pwdPlaceholder.focus(function () {
                pwdPlaceholder.css("color", "#000");
                pwdPlaceholder.addClass("active");
                pwdPlaceholder.hide();
                pwdField.show();
                pwdField.focus();
            });

            pwdField.blur(function () {
                if (pwdField.val() == '') {
                    pwdPlaceholder.show();
                    pwdField.hide();
                    pwdPlaceholder.css("color", "#A9A9A9");
                    pwdPlaceholder.removeClass("active");
                }
            });
        }
    });

    //判断浏览器是否支持 placeholder属性
    function isPlaceholder() {
        var input = document.createElement('input');
        return 'placeholder' in input;
    }
</script>
</html>
