<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="basePath" value="<%=basePath%>" scope="request" />
<link href="${basePath}/resources/css/global.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/resources/skin/simple_gray/ymPrompt.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/resources/css/jquery.autocomplete.css" rel="stylesheet" type="text/css" />
<style type="text/css">
#container {
	min-height: 100%;
	position: relative;
	zoom:1;/* 解决ie10以下绝对定位时bug */
}

#container #content {
	min-height: 309px;
	width: 100%;
	border: 1px solid #FAF9F3;
	text-align:center;
}

#container #content #main {
	width: 1200px;
	margin: 0 auto;
	clear: both;
	margin-bottom: 52px;
}

.loading {
	width: 240px;
	height: 60px;
	margin: 0 auto;
}

.loading .left-icon {
	float: left;
	width: 60px;
	height: 60px;
	background: url(${basePath}/resources/images/loading_32.gif) no-repeat 18px 15px;
}

.loading .right-txt {
	float: left;
	width: 155px;
	height: 32px;
	line-height: 32px;
	margin-top: 16px;
	color: #333333;
}
</style>
<script src="${basePath}/resources/js/jquery-1.7.1.js" type="text/javascript"></script>
<script src="${basePath}/resources/js/tools.js" type="text/javascript"></script>
<script src="${basePath}/resources/Scripts/jquery.autocomplete.min.js" type="text/javascript"></script>
<script src="${basePath}/resources/Scripts/ymPrompt.js" type="text/javascript"></script>
<script src="${basePath}/resources/Scripts/LinkedList-0.1.js" type="text/javascript"></script>
<script src="${basePath}/resources/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
<script type="text/javascript" src="${basePath}/resources/js/json2.js"></script>
<script type="text/javascript">
    //document.oncontextmenu = Tools.mouseDownHandler;
    //document.oncontextmenu = function (e) { return false; }
    var timeout = false;
    var mousewheelevt = (/Firefox/i.test(navigator.userAgent)) ? "DOMMouseScroll" : "mousewheel";
    $(window).scroll(function () { if (timeout) { clearTimeout(timeout); ($(".ac_results") != "undefined") ? $(".ac_results").hide() : $(".ac_results").hide(); } timeout = setTimeout(function () { }, 100); });

    window.onload = function () {
        var user = Tools.x("cur_user").value;
        if (user != "") {
            $(".org").html("<div><span>您好</span>,<a href=\"javascript:void(0);\" onclick=\"Tools.jump('../Center/Index');\">" + user + "</a></div>");
            $(".loginbox").css("display", "none");
            $(".right-logo").css("display", "block");
        }
        else {
            $(".loginbox").css("display", "block");
            $(".right-logo").css("display", "none");
        }
        Tools.pollingCheck();
        Tools.bindAutocomplete(2);
        //Tools.windowIntercept(true);
        $("#footer").css("min-width", "1200px");
    }

    function kyWin(content, width, height, header, close, showHeader) {
        ymPrompt.win({ message: content, width: width, height: height, title: header, closeBtn: close, titleBar: showHeader, handler: handler });
        $(document).bind(mousewheelevt, function () { return false; });
    }

    function mouseWheel(){
        return "1";
    }

    function handler(tp) {
        if (tp == 'close') {
            if (skip > 0) { Tools.closeWin(window.location.href); }
            window.onmousewheel = document.onmousewheel = null;
            $(document).unbind(mousewheelevt);
        }
    }
</script>
