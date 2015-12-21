<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/libs.jsp"%>
<base href="${basePath}">
<title>车来车往后台系统管理平台</title>
<style type="text/css">
.data-containers {
	border-radius: 4px;
	border: 1px solid #e0dfd9;
}

.data-containers .data-search, .data-more {
	width: 100%;
	height: 62px;
}

.data-containers .data-search {
	background: #f6f6f6;
}

.data-containers .data-search .inner {
	margin: 0 auto;
	width: 96%;
	height: 60px;
}

.data-containers .data-search .inner .left, .data-containers .data-search .inner .right
	{
	display: inline-block;
	height: 62px;
	line-height: 62px;
}

.data-containers .data-search .inner .left {
	float: left;
}

.data-containers .data-search .inner .left span {
	font-size: 20px;
	display: inline-block;
}

.data-containers .data-search .inner .left span.name {
	font-weight: bold;
	color: #454545;
}

.data-containers .data-search .inner .left span.select {
	color: #b6b6b6;
	margin-left: 5px;
}

.data-containers .data-search .inner .left span.select select {
	outline: 0;
	background: #FAF9F3;
	height: 28px;
	width: 140px;
	line-height: 28px;
	border: 1px solid #E0DFD9;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border-radius: 4px;
}

.data-containers .data-search .inner .right {
	float: right;
}

.data-containers .data-search .inner .right input {
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
	margin-left: 15px;
}

.data-containers .data-search .inner .right input.refresh {
	background-position: -746px -317px;
}

.data-containers .data-search .inner .right input.mode {
	background-position: -573px -317px;
}

.data-containers .data-list {
	height: auto;
	width: 100%;
	background: #fff;
}

.data-containers .data-list table {
	width: 100%;
	border: 0px solid #000;
}

.data-containers .data-list table tr {
	height: 60px;
	text-align: center;
	border-bottom: 1px solid #E0DFD9;
}

.data-containers .data-list table tr.list-header {
	background: #bcd9f3;
	height: 40px;
	box-shadow: 0 2px 0 #d2d2d1;
}

.data-containers .data-list table tr.list-header td {
	font-family: 微软雅黑;
	font-size: 16px;
}

.data-containers .data-list table tr td {
	font-size: 14px;
	color: #454545;
	font-family: 宋体;
}

.data-containers .data-list table tr td.width160 {
	width: 160px;
}

.data-containers .data-list table tr td.width400 {
	width: 400px;
	text-align: left;
	padding-left: 30px;
}
</style>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=bqvCmIoE8UAGlCuqW8Dz6SC1"></script>
<script type="text/javascript">
	var trData = new Array(), record_carName = 0;
	var geoc = null;
	function LocationAddress(point, location) {
		this.point = point;
		this.location = location;
	}
	$(function() {
		geoc = new BMap.Geocoder();
		$(".refresh").bind("click", function() {
			kyWin(Tools.showCustomerWin("loading"), 300, 70, '', true, false);
			createWin.initMonitorData($("#carId").val());
		});
		createWin.initMonitorData("");
	});
	var createWin = {
		initMonitorData : function(carId) {
			var data = null
			if (carId == "") {
				data = {}
			} else {
				data = {
					carId : carId
				}
			}
			$
					.ajax({
						type : 'POST',
						url : 'Monitor/SearchMonitor?o=' + Math.random(),
						data : data,
						dataType : "json",
						success : function(resultData) {
							var locationAddresses = [];
							var data = resultData.rows;
							var length = 0;
							trData = new Array();
							trData.push("<table cellpadding='0' cellspacing='0'>");
							trData
									.push("<tr class='list-header'><td class=\"width160\">车牌号</td><td class=\"width160\">GPS定位时间</td><td class=\"width160\">GPS上报时间</td><td class=\"width400\">当前位置</td>");
							trData.push("</tr>");
							for (var i = 0; i < data.length; i++) {
								if (data[i].longitude != null && data[i].latitude != null) {
									var point = new BMap.Point((data[i].longitude / (1000000)).toFixed(6), (data[i].latitude / (1000000)).toFixed(6));
									geoc.getLocation(point, function(rs) {
										var addComp = rs.addressComponents;
										var locationAddress = new LocationAddress(rs.point, addComp.province + ", " + addComp.city + ", "
												+ addComp.district + (addComp.street == null?"":", " + addComp.street));
										locationAddresses.push(locationAddress);
									});
									length++;
								}
								trData.push("<tr><td>" + data[i].licenseplate + "</td><td>"
										+ (data[i].gpsdatetime == null ? "--" : data[i].gpsdatetime) + "</td><td>"
										+ (data[i].recvdatetime == null ? "--" : data[i].recvdatetime)
										+ "</td><td class=\"width400\" id='"+data[i].carId+"'>暂无GPS数据</td></tr>");
							}
							$(".data-list").html(trData.join("") + "</table>");
							var interval = setInterval(function() {
								if (locationAddresses.length == length) {
									$.each(data, function(j, car) {
										if (car.longitude != null && car.latitude != null) {
											$.each(locationAddresses, function(i, locationAddress) {
												if (car.longitude == Math.round(locationAddress.point.lng * 1000000)
														&& car.latitude == Math.round(locationAddress.point.lat * 1000000)) {
														$("#" + car.carId).html(locationAddress.location);
													}
											});
										}
									});
									clearInterval(interval);
								}
							}, 100);
							Tools.closeWin("");
							$(".refresh").attr("disabled", false);
						}
					});
		}
	}
</script>
</head>
<body>
	<div id="container">
		<div style="height: 136px;">
			<jsp:include page="../common/head.jsp" />
		</div>
		<div id="content">
			<div id="main">
				<div class="data-containers">
					<div class="data-search">
						<div class="inner">
							<div class="left">
								<span class="name">线路实时监控</span> <span class="select"> <select id="carId" name="carId"
									onchange="createWin.initMonitorData(this.value);">
										<option value=''>全部</option>
										<c:forEach items="${cars}" var="car">
											<option value="${car.carId}">${car.licenseplate }</option>
										</c:forEach>
								</select>
								</span>
							</div>
							<div class="right">
								<input type="button" value="刷新" class="refresh" disabled="disabled" /> <input type="button" value="地图模式"
									class="mode" onclick="Tools.jump('${basePath}/Monitor/MapView');" />
							</div>
						</div>
					</div>
					<div class="data-list"></div>
					<div class="data-more">
						<a href="javascript:void(0);">查看更多 ▼</a>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>