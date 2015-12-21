<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <base href="${basePath}"/>
    <style type="text/css">
        #header{width:100%;height:76px;background:#4c6a84;min-width:1200px;text-align:center}
        #header .top{width:1200px;height:38px;margin:0 auto;}
        #header .top .left{float:left;width:auto;height:30px;line-height:30px;display:inline;padding-left:25px;color:#fff;font-size:16px;font-family:宋体;position:relative;top:6px;}
        #header .top .right{float:right;width:160px;height:38px;line-height:38px;display:inline;text-align:center;color:#fff;font-size:12px;font-family:宋体;position:relative;top:3px;}
        #header .top .right ul li{margin:0;padding:0;float:left;display:inline-block;width:auto;padding:0 5px 0 5px;}
        #header .top .right ul li a{color:#fff;}
        #header .middle{width:1200px;height:76px;margin:0 auto;background:#f6f6f6;position:relative;z-index:999;border-radius:4px;box-shadow:0 2px 0 #e0dfd9;}
        #header .middle .logo{float:left;width:220px;height:76px;line-height:76px;text-align:center;background:url(resources/images/logo.png) no-repeat -110px -460px;cursor:pointer;}
        #header .middle .menu{float:left;width:auto;height:76px;line-height:76px;}
        #header .middle .menu ul li,#header .middle .sa ul li{margin:0;padding:0;display:inline;list-style:none;float:left;}
        #header .middle .menu ul li a,#header .middle .sa ul li a{display:inline-block;float:left;width:auto;color:#7a7b7b;font-family:微软雅黑;font-size:18px;font-weight:bold;margin-left:2px;outline:0;}
        
        #header .middle .menu ul li a:hover,#header .middle .sa ul li a:hover,#header .middle .menu ul li a.active,#header .middle .sa ul li a.active{background:url(resources/images/icons.png) no-repeat -265px -408px;}
        
        #header .middle .menu ul li a.jiashiyuanhecheliang:hover,#header .middle .menu ul li a.jiashiyuanhecheliang.active{background:url(resources/images/icons.png) no-repeat -255px -408px;}
        #header .middle .menu ul li span.spacing,#header .middle .sa ul li span.spacing{float:left;position:relative;background:url(resources/images/icons.png) no-repeat -413px -424px;display:block;width:10px;height:70px;}
        #header .middle .menu ul li .menu-left{left:23px;}
        #header .middle .sa ul li .sa-left{left:8px;}
        #header .middle .sa ul li a{font-size:16px;font-weight:normal;}
        #header .middle .menu ul li{padding-left:22px;padding-right:22px;}
        #header .middle .sa ul li{padding-left:6px;padding-right:6px;}
        #header .middle .sa{float:right;width:auto;height:76px;line-height:76px;margin-right:22px;}
        
        #header .bottom{height:20px;width:100%;position:relative;z-index:999;margin: 0px auto;}
    </style>
</head>
<body>
    <input type="hidden" id="cur_user" name="cur_user" value="${sessionScope.user != null?sessionScope.user.userName:''}" />
    <div id="header">
        <div class="top">
            <div class="left">${sessionScope.user.userInfo != null ?sessionScope.user.userInfo.companyName:'' }</div>
            <div class="right">
                <ul>
                    <li><a href="javascript:void(0);" onclick="alert('功能研发中，感谢关注！');">关于</a></li>
                    <li style="width:10px;">|</li>
                    <li><a href="javascript:void(0);" onclick="alert('功能研发中，感谢关注！');">帮助</a></li>
                    <li style="width:10px;">|</li>
                    <li><a href="javascript:void(0);" onclick="Tools.ExitSystem('${basePath}');">退出</a></li>
                </ul>
            </div>
        </div>
        
        <div class="middle">
            <div class="logo" onclick="Tools.jump(window.location.href);"></div>
            <div class="menu">
                <ul>
                	<c:forEach items="${sessionScope.user.functionList }" var="function" varStatus="vs">
                		<c:if test="${function.parentId == '-1'}">
                			<c:if test="${vs.count<=5 }">
                				<li><a t="${function.action}" class="${fn:contains(requestScope.requestPath,function.controller) == true && fn:contains(requestScope.requestPath,function.action) ?'active':'' }" href="javascript:void(0);" hidefocus="hidefocus" onclick='Tools.jump("${basePath}/${function.controller}/${function.action}")'>${function.displayName}</a>
                				<c:if test="${vs.count <= 4}">
                					<span class="spacing menu-left"></span>
                				</c:if>
                				</li>
                			</c:if>
                       	</c:if>
                	</c:forEach>
                </ul>
            </div>
            <div class="sa">
                <ul>
                	<c:forEach items="${sessionScope.user.functionList }" var="function" varStatus="vs">
                		<c:if test="${function.parentId == '-1'}">
                			<c:if test="${vs.count>5 }">
                				<li><a t="${function.action}" class="${fn:contains(requestScope.requestPath,function.controller) == true && fn:contains(requestScope.requestPath,function.action) ?'active':'' }" href="javascript:void(0);" hidefocus="hidefocus" onclick='Tools.jump("${basePath}/${function.controller}/${function.action}")'>${function.displayName}</a>
                				<c:if test="${vs.count < sessionScope.user.functionList.size()}">
                					<span class="spacing menu-left"></span>
                				</c:if>
                				</li>
                			</c:if>
                       	</c:if>
                	</c:forEach>
                </ul>
            </div>
        </div>
        <div class="bottom"></div>
    </div>
</body>

<script type="text/javascript">
    var t = window.location.toString().split("/")[4];
    $(function () {
        //setTimeout(function () { var skiper = Tools.initSkiper(); $($(".right ul").children("li")[0]).children("a").attr("href", skiper + "About/Index"); $($(".right ul").children("li")[2]).children("a").attr("href", skiper + "About/Help"); }, 500);
        $(".function ul li").each(function (index) {
            $(this).children("a").hover(function () { $(this).parent().attr("class", "bright-FF4D00"); }, function () { if (t == "" || $(this).attr("t") != t) { $(this).parent().attr("class", "bright-E3E2E2"); } });
            $(this).click(function () {
                var str = $.trim($(this).text());
                var A = $(".function ul li").children("a");
                A.eq(0).attr("class", "join");
                A.eq(1).attr("class", "release");
                A.eq(2).attr("class", "index");
                A.eq(3).attr("class", "history");
                A.parent("li").attr("class", "bright-E3E2E2");
                for (var i = 0; i < 4; i++) {
                    if (i == index) {
                        $(this).children("a").attr("class", $(this).children("a").attr("class") + "current");
                        $(this).attr("class", "bright-FF4D00");
                        $(".rightwords").html("<div style='background:url(resources/img/loading-16.gif) no-repeat 0 5px;width:22px;height:22px;'></div>");
                        t = $(this).children("a").attr("t");
                        break;
                    }
                }
            });
        });
    });
</script>
</html>