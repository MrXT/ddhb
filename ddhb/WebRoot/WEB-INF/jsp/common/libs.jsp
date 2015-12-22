<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<c:set var="basePath" value="<%=basePath%>" scope="request" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta charset="UTF-8">

<meta name="description" content="Violate Responsive Admin Template">
<meta name="keywords" content="Super Admin, Admin, Template, Bootstrap">
<base href="${basePath}">
<title>管理员后台</title>
<!-- CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/animate.min.css" rel="stylesheet">
<link href="resources/css/font-awesome.min.css" rel="stylesheet">
<link href="resources/css/form.css" rel="stylesheet">
<link href="resources/css/calendar.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/icons.css" rel="stylesheet">
<link href="resources/css/generics.css" rel="stylesheet"> 
<!-- Javascript Libraries -->
<!-- jQuery -->
<script src="resources/js/common/common.js"></script>
<script src="resources/js/jquery.min.js"></script> <!-- jQuery Library -->
<script src="resources/js/jquery-ui.min.js"></script> <!-- jQuery UI -->
<script src="resources/js/jquery.easing.1.3.js"></script> <!-- jQuery Easing - Requirred for Lightbox + Pie Charts-->

<!-- Bootstrap -->
<script src="resources/js/bootstrap.min.js"></script>

<!-- Charts -->
<script src="resources/js/charts/jquery.flot.js"></script> <!-- Flot Main -->
<script src="resources/js/charts/jquery.flot.time.js"></script> <!-- Flot sub -->
<script src="resources/js/charts/jquery.flot.animator.min.js"></script> <!-- Flot sub -->
<script src="resources/js/charts/jquery.flot.resize.min.js"></script> <!-- Flot sub - for repaint when resizing the screen -->

<script src="resources/js/sparkline.min.js"></script> <!-- Sparkline - Tiny charts -->
<script src="resources/js/easypiechart.js"></script> <!-- EasyPieChart - Animated Pie Charts -->
<script src="resources/js/charts.js"></script> <!-- All the above chart related functions -->

<!-- Map -->
<script src="resources/js/maps/jvectormap.min.js"></script> <!-- jVectorMap main library -->
<script src="resources/js/maps/usa.js"></script> <!-- USA Map for jVectorMap -->

<!--  Form Related -->
<script src="resources/js/icheck.js"></script> <!-- Custom Checkbox + Radio -->

<!-- UX -->
<script src="resources/js/scroll.min.js"></script> <!-- Custom Scrollbar -->

<!-- Other -->
<script src="resources/js/calendar.min.js"></script> <!-- Calendar -->
<script src="resources/js/feeds.min.js"></script> <!-- News Feeds -->


<!-- All JS functions -->
<script src="resources/js/functions.js"></script>

