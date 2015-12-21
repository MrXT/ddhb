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

.data-containers .data-search .inner .left span.input-box {
	color: #b6b6b6;
	margin-left: 5px;
}

.data-containers .data-search .inner .left span.input-box select {
	outline: 0;
	background: 0;
	height: 22px;
	line-height: 26px\9;
	width: 180px;
	border: 1px solid #E0DFD9;
	background-color: #fff;
	-moz-border-radius: 4px 6px 6px 4px;
	-webkit-border-radius: 4px 6px 6px 4px;
	border-radius: 4px 6px 6px 4px;
	text-indent: 5px;
}

.data-containers .data-search .inner .left span.input-box label {
	width: 28px;
	height: 25px;
	display: inline-block;
	position: relative;
	margin-left: -32px;
	top: 8px;
	background: url(resources/images/icons.png) no-repeat -208px -396px;
	cursor: pointer;
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

.map {
	width: 100%;
	border-top: 1px solid #E0DFD9;
	display: none;
}

.infoContainer {
	height: auto;
	width: 270px;
}

.infoContainer table {
	width: 100%;
	padding: 10px;
}

.infoContainer table td {
	width: auto;
	height: 26px;
	line-height: 26px;
	text-align: left;
}

.infoContainer table td.name {
	width: 90px;
}

.infoContainer table td.title {
	width: auto;
	padding: 0 5px 5px 0;
	font-size: 14px;
	font-weight: bold;
}
</style>

<script src="resources/js/LinkedList-0.1.js" type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=bqvCmIoE8UAGlCuqW8Dz6SC1"></script>
<script type="text/javascript">
	var map, markerArry, mapLayerTime;
	var geoc = null;
	window.onresize = function() {
		Tools.pagestyle($(".data-containers #maps"), 10);
	}
	$(window).load(Tools.pagestyle($(".data-containers #maps"), 58));
	function loadMap() {
		$(".map").height($("#container").height()-50-136-$(".data-search").height()-10);
		geoc = new BMap.Geocoder();
		map = new BMap.Map("maps");
		var point = new BMap.Point(116.404, 39.915);
		map.centerAndZoom(point, 9);
		map.enableScrollWheelZoom(true);

		var myCity = new BMap.LocalCity();
		myCity.get(function(result) {
			var cityName = result.name;
			map.setCenter(cityName);
			Tools.x("maps").style.display = "block";
		});
		bindCars(0);
	}

	function bindCars(plat) {
		clearTimeout(mapLayerTime);
		markerArry = new Array();
		var data=null;
		if(plat == ""){
			data={}
		}else{
			data = {carId : plat}
		}
		$.ajax({
			type : 'POST',
			url : 'Monitor/SearchMonitor?o=' + Math.random(),
			data : data,
			dataType : "json",
			success : function(resultData) {
				var data = resultData.rows;
				if (data.length > 0) {
					for (var i = 0; i < data.length; i++) {
						if (data[i].longitude != null && data[i].latitude != null) {
							createMarker((data[i].latitude / 1000000), (data[i].longitude / 1000000), data[i].licenseplate,
									data[i].gpsdatetime);
						}
					}
					Tools.closeWin("");
					$(".refresh").bind("click", function() {
						clearOverlays(true);
					});
					$(".refresh").attr("disabled", false);
					mapLayerTime = setTimeout(function() {
						clearOverlays(false);
					}, 30000);
				} else {
					alert("暂无当前查询车辆数据！");
				}
			}
		});
	}

	function createMarker(lat, lng, plat, gpsdate) {
		var pt = new BMap.Point(lng, lat);
		var myIcon = new BMap.Icon("resources/images/carIcon_on.png", new BMap.Size(23, 22));
		var marker = new BMap.Marker(pt, {
			icon : myIcon
		});
		marker.id = plat + "&" + lat + "&" + lng  + "&" + gpsdate;
		markerArry.push(marker);
		map.addOverlay(marker);
		marker.addEventListener("click", function() {
			openWindow(plat, lng, lat, gpsdate, this);
		});
	}

	function openCarsWindow(licenseplat) {
		var isExists = false;
		for (var i = 0; i < markerArry.length; i++) {
			if (markerArry[i].id.split("&")[0] == licenseplat) {
				isExists = true;
				break;
			}
		}
		!isExists ? alert("输入车牌无效，查询失败！") : openWindow(markerArry[i].id.split("&")[0], markerArry[i].id.split("&")[2],
				markerArry[i].id.split("&")[1], markerArry[i].id.split("&")[3], markerArry[i]);
	}

	function openWindow(plat, lng, lat, gpsdate, bMapWindow) {
		geoc.getLocation(new BMap.Point(lng,lat), function(rs) {
			var addComp = rs.addressComponents;
			var location = addComp.province + ", " + addComp.city + ", "
					+ addComp.district + ", " + addComp.street + ", " + addComp.streetNumber;
			var str = "<div class='infoContainer'>";
			str += "<table cellspacing='0' cellpadding='0'>";
			str += "<tr><td class='title' colspan='10'>车辆定位信息</td></tr>";
			str += "<tr><td class='name'>车　　牌：</td><td>" + plat + "</td></tr>";
			str += "<tr><td class='name'>GPS定位时间：</td><td>" + gpsdate + "</td></tr>";
			str += "<tr><td class='name'>GPS位置：</td><td title='" + location + "'>"
					+ ((location.length > 15) ? location.substring(0, 15) + "..." : location) + "</td></tr>";
			str += "</table>";
			str += "</div>";
			var infoWindow = new BMap.InfoWindow(str);
			bMapWindow.openInfoWindow(infoWindow);
			map.panTo(new BMap.Point(lng, lat));
		});
	}

	function clearOverlays(load) {
		var allOverlay = map.getOverlays();
		for (var i = 0; i < allOverlay.length - 1; i++) {
			map.removeOverlay(allOverlay[i]);
		}
		markerArry.length = 0;
		if (load) {
			kyWin(Tools.showCustomerWin("loading"), 300, 70, '', true, false);
		}
		bindCars("");
	}
</script>
</head>
<body onload="loadMap();">
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
								<span class="name">线路实时监控</span> <span class="input-box"> <select id="plat" name="plat" >
										<option  value=''>全部</option>
										<c:forEach items="${cars}" var="car">
											<option value="${car.carId}">${car.licenseplate }</option>
										</c:forEach>
									</select> <label onclick="openCarsWindow($('#plat option:selected').text());"></label>
								</span>
							</div>
							<div class="right">
								<input type="button" value="刷新" class="refresh" /> <input type="button" value="列表模式" class="mode"
									onclick="Tools.jump('${basePath}/Monitor/Index');" />
							</div>
						</div>
					</div>
					<div class="map" id="maps"></div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>