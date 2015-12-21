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
	height: 92px;
}

.data-containers .data-search {
	background: #f6f6f6;
}

.data-containers .data-search .left-conditionals, .data-containers .data-search .right-searchButton
	{
	width: 83%;
	height: 85px;
	float: left;
	padding-left: 5.5%;
}

.data-containers .data-search .right-searchButton {
	width: 10%;
	height: 85px;
	line-height: 85px;
	float: left;
	padding: 0;
	margin-top: 5px;
}

.data-containers .data-search .left-conditionals .inner {
	margin: 0 auto;
	width: 95%;
	height: 38px;
	line-height: 38px;
}

.data-containers .data-search .left-conditionals .inner span {
	display: inline-block;
}

.data-containers .data-search .left-conditionals .inner span input {
	height: 25px;
	line-height: 25px;
	text-indent: 5px;
	background: #FAF9F3 url(resources/images/icons.png) no-repeat;
	border: 1px solid #E0DFD9;
	width: 140px;
	cursor: pointer;
}

.data-containers .data-search .left-conditionals .inner span input.date
	{
	background-position: -522px -768px;
}

.data-containers .data-search .left-conditionals .inner span input.time
	{
	background-position: -522px -824px;
}

.data-containers .data-search .left-conditionals .inner span.name {
	color: #454545;
	padding-left: 40px;
}

.data-containers .data-search .left-conditionals .inner span select {
	outline: 0;
	background: #FAF9F3;
	height: 28px;
	width: 160px;
	line-height: 28px;
	border: 1px solid #E0DFD9;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border-radius: 4px;
}

.data-containers .data-search .right-searchButton span.search {
	margin-left: 18px;
}

.data-containers .data-search .right-searchButton span.search input {
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat -573px -317px;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
	margin-top: 20px;
}

a.export {
	position: absolute;
	top: 235px;
	width: 30px;
	height: 76px;
	display: none;
	font-size: 16px;
	text-align: center;
	font-weight: normal;
	font-family: 宋体;
	color: #454545;
	margin-left: 1199px;
	background: #F6F6F6 url(resources/images/icons.png) no-repeat -403px
		-695px;
	border: 1px solid #E0DFD9;
	border-left: 0;
	padding-top: 32px;
}

a.export:hover {
	background-position: -303px -695px;
	border: 1px solid #FD7100;
	border-left: 0;
	color: #FD7100;
}

.export a.icons {
	margin: 0 auto;
	width: 30px;
	height: 34px;
	display: block;
	background: url(resources/images/icons.png) no-repeat -403px -695px;
}

.data-containers .results {
	border-top: 1px solid #e0dfd9;
	width: 100%;
	background-color: #fff;
	height: 120px;
}

.data-containers .results div.cloumns {
	width: 33%;
	border-right: 1px solid #e0dfd9;
	height: 120px;
	float: left;
}

.data-containers .results div.noborder {
	border: 0;
}

.data-containers .results div.cloumns .inner {
	width: 100%;
	height: 120px;
	text-align: center;
}

.data-containers .results div.cloumns .inner .name {
	height: 40px;
	line-height: 40px;
	position: relative;
	top: 20px;
	font-size: 20px;
	color: #FD7100;
}

.data-containers .results div.cloumns .inner .number {
	height: 40px;
	position: relative;
	top: 20px;
	font-size: 32px;
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
	background: #F6F6F6;
	height: 40px;
	box-shadow: 0 2px 0 #d2d2d1;
	border-top: 1px solid #e0dfd9;
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

.data-containers .data-list table tr td.width140 {
	width: 140px;
}

.data-containers .data-list table tr td.width120 {
	width: 120px;
}

.data-containers .data-list table tr td.width160 {
	width: 160px;
}

.data-containers .data-list table tr td.width220 {
	width: 220px;
}

.data-containers .data-list table tr td.width260 {
	width: 260px;
}
.data-containers .data-list table tr td.width270 {
	width: 270px;
}

.evaluate-content {
	width: 100%;
	margin: 0 auto;
	padding: 0;
}

.content-header {
	width: 99.9%;
	background: #fff;
	height: 90px;
	line-height: 90px;
	border-bottom: 1px solid #D4D4D4;
}

.content-header-word {
	float: left;
	margin-left: 20px;
	width: 400px;
}

.content-header-word span {
	color: #666666;
	width: 300px;
	font-size: 15px;
	font-weight: bold;
	float: left;
	display: inline-block;
	letter-spacing: 2px;
}

.content-header-word span.score-value {
	width: 30px;
	display: block;
	position: relative;
	top: -1px;
	left: 10px;
	color: #E74C3C;
	font-size: 17px;
	font-family: 微软雅黑;
	font-weight: normal;
}

.content-header-word a {
	color: #666;
	font-size: 15px;
}

.content-header-word a.jiaolian {
	margin-left: 30px;
	display: inline-block;
	width: auto;
}

.evaluate-content .datalist {
	width: 99.9%;
	height: auto;
	min-height: 430px;
	background: #F6F5F5;
}

.evaluate-content .datalist .listView {
	height: auto;
	width: 100%;
	margin: 0 auto;
}

.evaluate-content .datalist .listView .details-content {
	width: 100%;
	height: auto;
	margin-top: 0px;
	clear: both;
}

.evaluate-content .datalist .listView .details-content .header {
	height: 70px;
	background: #FFF;
	border-bottom: 1px solid #D4D4D4;
}

.evaluate-content .datalist .listView .details-content .header .inner {
	width: 92%;
	margin: 0 auto;
	height: 70px;
	line-height: 70px;
}

.evaluate-content .datalist .listView .details-content .header .inner span
	{
	margin-right: 15px;
}

.evaluate-content .datalist .listView .details-content .header .inner span.downlist
	{
	display: inline-block;
	width: 130px;
	height: 30px;
	line-height: 30px;
	text-indent: 5px;
	border: 1px solid #D4D4D4;
	background: #E7E8EB url(resources/images/stars.png) no-repeat 57px
		-2598px;
	color: #666;
	cursor: pointer;
	font-size: 14px;
}

.evaluate-content .datalist .listView .details-content .header .inner span.score-value
	{
	width: 30px;
	display: block;
	position: relative;
	top: -1px;
	left: 20px;
	color: #E74C3C;
	font-size: 17px;
	font-family: 微软雅黑;
	font-weight: normal;
}

.evaluate-content .datalist .listView .details-content .evaluate-info {
	min-height: 435px;
	background: #F8F9F9;
	padding-top: 0px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner
	{
	width: 96%;
	margin: 0px auto;
	height: auto;
	padding-bottom: 0px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows
	{
	width: 100%;
	height: 100%;
	min-height: 50px;
	border-bottom: 1px solid #D4D4D4;
	padding-bottom: 10px;
	padding-top: 20px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .userinfo
	{
	float: left;
	height: 80px;
	padding-left: 10px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .userinfo .touxiang
	{
	width: 80px;
	height: 50px;
	text-align: center;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .userinfo .touxiang img
	{
	width: 55px;
	height: 55px;
	-moz-border-radius: 55px;
	border-radius: 55px;
	-webkit-border-radius: 55px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .userinfo .name
	{
	width: 80px;
	text-align: center;
	height: 40px;
	line-height: 40px;
	font-size: 13px;
	font-family: simsun;
	color: #787878;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo
	{
	float: left;
	width: 85%;
	margin-left: 45px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .zhiliang-inner
	{
	height: 35px;
	line-height: 35px;
	width: 100%;
	margin-bottom: 8px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .zhiliang-inner .inner-columns
	{
	float: left;
	width: 215px;
	height: 30px;
	font-size: 14px;
	font-family: simsun;
	color: #787878;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .zhiliang-inner .inner-columns.date
	{
	width: 115px;
	float: right;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .zhiliang-inner .inner-columns span
	{
	margin-right: 10px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .zhiliang-inner .inner-columns span.start
	{
	background: url(resources/images/stars.png) no-repeat -6px -40px;
	width: 18px;
	height: 18px;
	display: inline-block;
	position: relative;
	top: 3px;
	margin-right: 7px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .inner-context
	{
	font-size: 14px;
	font-family: simsun;
	color: #787878;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .inner-context .ping
	{
	float: left;
	width: 16px;
	height: 16px;
	line-height: 17px;
	text-align: center;
	color: #FFF;
	font-family: simsun;
	font-size: 13px;
	margin-top: 3px;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .inner-context .ping.e74c3c
	{
	background: #E74C3C;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .inner-context .ping.c5c5c5
	{
	background: #C5C5C5;
}

.evaluate-content .datalist .listView .details-content .evaluate-info .inner .rows .evaluateinfo .inner-context .context
	{
	float: left;
	width: 96%;
	margin-left: 8px;
	line-height: 22px;
}

.star-inner {
	height: 20px;
	width: 125px;
	margin: 0 auto;
	float: left;
	display: inline-block;
	position: relative;
	top: 25px;
	left: 10px;
}

.star-inner span.stars, span.stars span {
	display: block;
	background: url(resources/images/stars.png) 0 -21px repeat-x;
	width: 125px;
	height: 17px;
}

.star-inner span.stars span {
	background-position: 0 0;
	float: left;
}

.release-frequency, .edit-frequency {
	width: 98%;
	height: 234px;
	margin: 20px auto;
}

.release-frequency .columns, .edit-frequency .columns {
	height: 64px;
	width: 100%;
}

.release-frequency .inputs-containers, .edit-frequency .inputs-containers
	{
	width: 305px;
	height: 44px;
	margin-left: 13px;
	float: left;
	display: inline-block;
}

.release-frequency .sites, .edit-frequency .sites {
	border: 1px solid #DCDDDF;
	width: 905px;
	border-raduis: 3px;
	background-color: #FAF9F3;
	margin-left: 13px;
	*margin-left: 26px;
}

.release-frequency .sites .arrow-up, .edit-frequency .sites .arrow-up {
	width: 27px;
	height: 22px;
	margin-top: -21px;
	margin-right: 20px;
	float: right;
	background: url(resources/images/icons.png) no-repeat -510px -696px;
}

.release-frequency .columns input, .edit-frequency .columns input {
	width: 300px;
	height: 42px;
	line-height: 42px\9;
	text-indent: 6px;
	border: 1px solid #DCDDDF;
	cursor: pointer;
	border-radius: 3px;
	float: left;
	display: inline-block;
	background-color: #FAF9F3;
}

.edit-frequency .columns input {
	cursor: default;
	border: 0;
}

.release-frequency .columns input.clve, .edit-frequency .columns input.clve
	{
	background: url(resources/images/icons.png) no-repeat -97px -1308px;
	border: 0;
}

.release-frequency .inputs-containers label, .edit-frequency .inputs-containers label
	{
	background: url(resources/images/icons.png) no-repeat -468px -448px;
	display: inline-block;
	margin-left: -40px;
	margin-top: 7px;
	float: left;
	width: 30px;
	height: 30px;
	cursor: pointer;
}

.release-frequency .inputs-containers .timeIcon, .edit-frequency .inputs-containers .timeIcon
	{
	background: url(resources/images/icons.png) no-repeat -882px -446px;
}

.release-frequency .inputs-containers label.down-arrow, .edit-frequency .inputs-containers label.down-arrow
	{
	background-position: -356px -1308px;
	height: 42px;
	width: 42px;
	margin-top: 1px;
	margin-left: -42px;
	cursor: text;
}

.release-frequency .inputs-containers span, .edit-frequency .inputs-containers span
	{
	margin-left: 5px;
	color: #DE5438;
	display: inline-block;
	float: left;
	width: auto;
	height: 44px;
	line-height: 44px;
	font-size: 14px;
	font-family: 宋体;
	letter-spacing: 2px;
}

.release-frequency .inputs-containers p, .edit-frequency .inputs-containers p
	{
	float: left;
	display: inline-block;
	height: 42px;
	line-height: 42px;
	width: auto;
	font-size: 14px;
	color: #A9A9A9;
	text-indent: 10px;
}

.release-frequency .inputs-containers p.zhi {
	color: #000;
	text-indent: 0;
	margin-left: 5px;
	margin-right: 5px;
}

.release-frequency .inputs-containers .right span, .edit-frequency .inputs-containers .right span
	{
	margin-right: 15px;
	color: #FD7100;
	font-size: 13px;
}
</style>
<script type="text/javascript">
	var objSel, chareredDivhtml, dept = "", dest = "", classlines = "", cars = "", drivers = "",carsBeans,driverBeans;
	var createWin = {
		searchStatistics : function() {
			$("#search").attr("disabled", true);
			$("#search").val("搜索中...");
			$(".export").hide();
			$
					.ajax({
						type : "post",
						url : "Statistics/SearchStatistics",
						data : {
							lineId : $("#lines_sel").val(),
							startDate : $("#dept_date1").val(),
							endDate : $("#dept_date2").val(),
							startTime : $("#dept_time1").val(),
							endTime : $("#dept_time2").val(),
							classlineId : $("#classline_sel").val(),
							licenseplate : $("#carname_sel").val(),
							driverId : $("#drivername_sel").val()
						},
						dataType : "json",
						success : function(resultData) {
							if (resultData.success) {
								var data = resultData.rows;
								var allticketcount = 0;
								var allticketnumber = 0;
								var alltotalamount = 0;
								var result_str = "<table cellpadding='0' cellspacing='0'><tr class='list-header'><td class=\"width270\">线路</td><td class=\"width140\">班线</td><td class=\"width160\">发车时间</td><td class=\"width160\">车辆</td><td class=\"width260\">司机</td><td class=\"width260\">总票数/已售</td><td class=\"width120\">收入金额(元)</td><td class=\"width140\"></td></tr>";
								if (data.length > 0) {
									$(".export").show();
								}

								$.each(data, function(i, row) {
									var param = JSON.stringify(row);
									allticketcount += row.ticketcount;
									allticketnumber += row.ticketnumber;
									alltotalamount += row.ticketnumber * row.ticketfacevalue;
									var carsDrivers = row.carSDrivers;//carSDrivers字符串格式 ：_车牌号,司机id，司机id__车牌号,司机id，司机id_
									//截取车牌号与所有的司机
									var vehicleString = "";
									var driversString = "";
									if (carsDrivers != null) {
										var carDrivers = carsDrivers.split("_");
										for (var i = 0; i < carDrivers.length; i++) {
											var carToDrivers = carDrivers[i].split(",");
											vehicleString += carToDrivers[0] + ",";
											for (var j = 1; j < carToDrivers.length; j++) {
												for (var z = 0; z < driverBeans.length; z++) {
													if (driverBeans[z].driverId == carToDrivers[j]) {
														driversString += driverBeans[z].fullname + ",";
													}
												}
											}
										}
									}
									if(row.charteredVo.charteredId == null){
										vehicleString = vehicleString.substring(0, vehicleString.length - 1);
										driversString = driversString.substring(0, driversString.length - 1);
									}else{
										vehicleString = row.charteredVo.licenseplate;
										driversString = row.charteredVo.drivername;
									}
									result_str += "<tr><td style='width:280px;'><div style='display:inline-block;vertical-align: middle;min-width:30px;height:25px;width:auto;max-width:130px;overflow:hidden;'>" 
									+ (row.departurename.length >9? row.departurename.substring(0,7)+"<span onmouseover='openTip(\""+row.departurename+"\");' onmouseout='closeTip();' style='display:inline-block;vertical-align: middle;color:#aaa;'>‥‥</span>":row.departurename)
									+ "</div><div style='display:inline-block;vertical-align: middle;width:10px;text-align:center;'>-</div><div style='display:inline-block;height:25px;vertical-align: middle;min-width:30px;width:auto;max-width:130px;overflow:hidden;'>" 
									+ (row.destinationname.length >9? (row.destinationname.substring(0,7)+"<span onmouseover='openTip(\""+row.destinationname+"\");' onmouseout='closeTip();' style='display:inline-block;vertical-align: middle;color:#aaa;'>‥‥</span>"):row.destinationname) + "</div></td><td>" + row.classlineName
											+ "</td><td>" + row.departuredate + "&nbsp;" + row.departuretime + "</td><td>"
											+ (vehicleString == '' ? '--' : vehicleString) + "</td><td>"
											+ (driversString == '' ? '--' : driversString) + "</td><td>" + row.ticketcount + "/" + row.ticketnumber
											+ "</td><td>" + row.ticketnumber * row.ticketfacevalue
											+ "</td><td><a href='javascript:void(0);' onclick='scanCharered(" + param + ");'>查看包车单</a></td></tr>";
								});
								$("#tickets .number").html(allticketcount);
								$("#actualTickets .number").html(allticketnumber);
								$("#totalRevenue .number").html(alltotalamount);
								$("#search").attr("disabled", false);
								$("#search").val("搜 索");
								$(".data-list").html(result_str + "</table>");
							}
						}
					});
		},
		bindStatisticsDetails : function(dept, dest, classline, drivers, carname, flag) {
			$.ajax({
				type : 'post',
				url : (flag > 1 ? '/Statistics/TT' : '/Statistics/SearchStatistics'),
				data : {
					departure : dept,
					DESTINATION : dest,
					DEPARTUREDATE1 : $("#dept_date1").val(),
					DEPARTUREDATE2 : $("#dept_date2").val(),
					DEPARTURETIME1 : $("#dept_time1").val(),
					DEPARTURETIME2 : $("#dept_time2").val(),
					CLASSLINE_NAME : classline,
					FULLNAME : drivers,
					LICENSEPLATE : carname,
					FLAG : flag
				},
				dataType : "json",
				success : function(data) {
					if (flag == 0) {

						$("#tickets .number").html(data[0]["TICKETCOUNT"]);
						$("#actualTickets .number").html(parseInt(data[0]["TICKETNUMBER"]) - parseInt(data[0]["REFUNDTICTETNUMBER"]));
						$("#refundTickets .number").html(data[0]["REFUNDTICTETNUMBER"]);
						$("#totalRevenue .number").html(data[0]["TOTALAMOUNT"]);
						createWin.bindStatisticsDetails(dept, dest, classlines, drivers, cars, 1);
					} else {
						if (flag == 2) {
							return;
						}

						for (var i = 0; i < data.length; i++) {
							var frequencyId = data[i]["FREQUENCY_ID"];
							var actualTickets = parseInt(data[i]["TICKETNUMBER"]) - parseInt(data[i]["REFUNDTICTETNUMBER"]);
							result_str += "<tr><td>" + data[i]["DEPARTURENAME"] + "-" + data[i]["DESTINATIONNAME"] + "</td><td>"
									+ data[i]["CLASSLINE_NAME"] + "</td><td>" + data[i]["DEPARTUREDATE"] + "&nbsp;" + data[i]["DEPARTURETIME"]
									+ "</td><td>" + data[i]["LICENSEPLATE"] + "</td><td>" + data[i]["FULLNAME"] + "</td><td>"
									+ data[i]["TICKETCOUNT"] + "/" + actualTickets + "/" + data[i]["REFUNDTICTETNUMBER"] + "</td><td>"
									+ data[i]["TOTALAMOUNT"] + "</td><td><a href='javascript:void(0);' onclick=\"createWin.viewEvaluateDetails('"
									+ frequencyId + "','" + data[i]["DEPARTURENAME"] + "-" + data[i]["DESTINATIONNAME"] + "');\">查看评价</a></td></tr>";
						}
						$("#search").attr("disabled", false);
						$("#search").val("搜 索");
						$(".data-list").html(result_str + "</table>");
					}
				}
			});
		},
		searchStatisticsDetails : function(flag) {
			dept = ($("#lines_sel").val() == "全部" ? "" : $("#lines_sel").val().split(",")[0]);
			dest = ($("#lines_sel").val() == "全部" ? "" : $("#lines_sel").val().split(",")[1]);
			classlines = ($("#classline_sel").val() == "全部" ? "" : $("#classline_sel").val());
			cars = ($("#carname_sel").val() == "全部" ? "" : $("#carname_sel").val());
			drivers = ($("#drivername_sel").val() == "全部" ? "" : $("#drivername_sel").val());
			if (flag == 2) {
				var urls = "/Export/TT?DEPARTURE=" + dept + "&DESTINATION=" + dest + "&DEPARTUREDATE1=" + $("#dept_date1").val() + "&DEPARTUREDATE2="
						+ $("#dept_date2").val() + "&DEPARTURETIME1=" + $("#dept_time1").val() + "&DEPARTURETIME2=" + $("#dept_time2").val()
						+ "&CLASSLINE_NAME=" + classlines + "&FULLNAME=" + drivers + "&LICENSEPLATE=" + cars;
				window.location.href = urls;
			} else {
				$("#search").attr("disabled", true);
				$("#search").val("搜索中...");
				$(".export").hide();
				createWin.bindStatisticsDetails(dept, dest, classlines, drivers, cars, flag);
			}
		},
		viewEvaluateDetails : function(frequencyId, lines) {
			$
					.get(
							'/Frequency/GetEvaluates',
							{
								frequencyId : frequencyId
							},
							function(result) {
								if (result.isSuccess == false) {
									alert(result.Content);
								} else {
									var cnt = result.Content.length;
									var results_str = "<div class=\"evaluate-content\">";
									results_str += "<div class=\"content\">";
									results_str += "<div class=\"datalist\">";
									results_str += "<div class=\"listView\">";
									results_str += "<div class=\"details-content\">";
									results_str += "<div class=\"header\"><div class=\"inner\"><div style=\"width:auto;float:left; text-align:center; font-size:15px;font-family:simsun;color:#787878;\">"
											+ lines
											+ "</div><div class=\"star-inner\"><span class=\"stars\" score='" + result.Score + "'><span></span></span></div><div style=\"float:left;\"><span class=\"score-value\">"
											+ result.Score + "</span></div></div></div>";
									results_str += "<div class=\"evaluate-info\" id=\"evaluateInfo\">";
									results_str += "<div class=\"inner\" id=\"infoContent\">";

									for (var i = 0; i < result.Content.length; i++) {
										results_str += "<div class=\"rows\" " + (i == cnt - 1 ? "style='border:0;'" : "") + ">";
										results_str += "<div class=\"userinfo\"><div class=\"touxiang\"><img src=\"/Content/images/headPic.png\" onerror=\"this.src='resources/Images/icons/default-personicon.png'\" alt=\"\" /></div><div class=\"name\">"
												+ result.Content[i].UserName + "</div></div>";
										results_str += "<div class=\"evaluateinfo\">";

										var stars = "";
										for (var j = 0; j < result.Content[i].Grade; j++) {
											stars += "<span class=\"start\"></span>";
										}

										results_str += "<div class=\"zhiliang-inner\"><div class=\"inner-columns\">" + stars
												+ "</div><div class=\"inner-columns date\">" + ChangeDateFormat(result.Content[i].EvaluateDateTime)
												+ "</div></div>";
										results_str += "<div class=\"inner-context\"><div class=\"ping "
												+ ((result.Content[i].Evaluate == "undefined" || result.Content[i].Evaluate == "" || result.Content[i].Evaluate == null) ? "c5c5c5"
														: "e74c3c")
												+ "\">评</div><div class=\"context\">"
												+ ((result.Content[i].Evaluate == "undefined" || result.Content[i].Evaluate == "" || result.Content[i].Evaluate == null) ? "这家伙很懒，没有写评语。"
														: result.Content[i].Evaluate) + "</div></div>";
										results_str += "</div>";
										results_str += "<div style=\"clear:both\"></div></div>";
									}
									results_str += "</div></div></div></div></div></div>";

									kyWin(results_str, 1000, 550, '评价详情', true, true);

									$("span.stars").each(
											function() {
												$(this).html(
														parent.$("<span />").width(
																Math.max(0, (Math.min(5, parseFloat($(this).attr("score")) / 2 / 10))) * 24));
											});
								}
							});
		},
		releaseChartered : function() {
			var winStr;
			releaseOne = true;
			ticketcnt = "";
			winStr = "<div class='edit-frequency'><div class='columns'><div class='inputs-containers'><input type='hidden' id='frequencyId' name='frequencyId' /><input type='text' id='departure' name='departure' placeholder='起点' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='destination' name='destination' placeholder='终点' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='shiji_no' name='shiji_no' placeholder='预约装载人数' readonly='readonly' /></div></div><div class='columns'><div class='inputs-containers'><textarea id='baoche_tujing' name='baoche_tujing' placeholder='途径线路' style='width:951px;background-image:none;resize:none;border:0;height:50px;' readonly='readonly' ></textarea></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='vehicles' name='vehicles' placeholder='车牌号' maxlength='7' autocomplete='off' readonly='readonly' style='width:255px;' code='0' /></div><div class='inputs-containers'><input type='text' id='drivers' name='drivers' placeholder='驾驶员' maxlength='10' code='0' autocomplete='off' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='baoche_company' name='baoche_company' placeholder='包车单位' style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;'/></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='baoche_contactor' name='baoche_contactor' placeholder='包车单位联系人' style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;'/></div><div class='inputs-containers'><input type='text' id='contactor_idcard' name='contactor_idcard' placeholder='身份证号码' style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;'/></div><div class='inputs-containers'><input type='text' id='contact_phone' name='contact_phone' placeholder='联系电话'  style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;'/></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='departureDate' name='departureDate' placeholder='发车时间' readonly=\"readonly\"/></div><div class='inputs-containers'><input type='text' id='destinationDate' name='destinationDate' placeholder='收车时间' readonly=\"readonly\" style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' onclick=\"WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(departureDate)}',maxDate:'%y-%M-{%d+60}',isShowToday:false,isShowOK:false, readOnly: true,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\" /><label ></label></div><div class='inputs-containers'><input type='text' id='ticketprice' name='ticketprice' placeholder='0.00' style='width:275px;' maxlength='20' readonly='readonly'/><span>元</span></div></div><div class='columns' style='height:42px;margin-top:10px;'><div class='inputs-containers' style='width:935px;'><div class=\"right\"><span></span><input type=\"button\" id=\"savefrequency\" name=\"savefrequency\" value=\"保存\" class=\"release\" onclick=\"createWin.releaseCharered($(this).attr('charteredId'));\" hidefocus=\"hidefocus\" /></div></div></div></div>";
			return winStr;
		}
	}
	//日期格式化
	function ChangeDateFormat(jsondate) {
		if (jsondate == null || jsondate == '')
			return '';
		jsondate = jsondate.replace("/Date(", "").replace(")/", "");
		if (jsondate.indexOf("+") > 0) {
			jsondate = jsondate.substring(0, jsondate.indexOf("+"));
		} else if (jsondate.indexOf("-") > 0) {
			jsondate = jsondate.substring(0, jsondate.indexOf("-"));
		}

		var date = new Date(parseInt(jsondate, 10));
		var month = date.getMonth() + 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
		var currentDate = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
		var currentHour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
		var currentMinute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();

		return date.getFullYear() + "-" + month + "-" + currentDate + " " + currentHour + ":" + currentMinute;
	}

	$(function() {
		carsBeans = $.parseJSON('${carsBeans}');
		driverBeans = $.parseJSON('${driverBeans}');
		createWin.searchStatistics();
		chareredDivhtml = $("#chareredDiv").html();
	});
	function scanCharered(param) {
		if (param.charteredVo.charteredId == null || param.charteredVo.charteredId == "") {
			alert("该班次还没有添加包车单！");
			return;
		}
		kyWin(chareredDivhtml, 1050, 460, '包车单信息', true, true);
		$("#chareredDiv").html("");
		var carsDrivers = param.carSDrivers;//carSDrivers字符串格式 ：_车牌号,司机id，司机id__车牌号,司机id，司机id_
		Tools.supportPlaceholder();
		//截取车牌号与所有的司机
		/* var vehicleString = "";
		var driversString = "";
		var carDrivers = carsDrivers.split("_");
		for (var i = 0; i < carDrivers.length; i++) {
			var carToDrivers = carDrivers[i].split(",");
			if(carToDrivers[0] !="0"){
				vehicleString += carToDrivers[0] + ",";
				for (var j = 1; j < carToDrivers.length; j++) {
					for (var z = 0; z < driverBeans.length; z++) {
						if (driverBeans[z].driverId == carToDrivers[j]) {
							driversString += driverBeans[z].fullname + ",";
						}
					}
				}
			}
		} */
		$("#departure").val('起点：' + param.departurename);
		$("#destination").val('终点：' + param.destinationname);
		$("#shiji_no").val('预约装载人数：' + param.ticketcount);
		$("#baoche_tujing").val('途径站点名：' + (param.sitename==''?'无':param.sitename));
		$("#vehicles").val('车牌：' + param.charteredVo.licenseplate);
		$("#drivers").val('司机：' + param.charteredVo.drivername);
		$("#departureDate").val('发车时间：' + param.departuredate);
		$("#ticketprice").val('票价：' + param.ticketfacevalue);
		$("#baoche_company").val('包车单位：' + param.charteredVo.charteredcompany);
		$("#baoche_contactor").val('包车单位联系人：' + param.charteredVo.companyleader);
		$("#contactor_idcard").val('身份证号码：' + param.charteredVo.leaderidnumber);
		$("#contact_phone").val('联系号码：' + param.charteredVo.leaderphone);
		$("#destinationDate").val('收车时间：' + param.charteredVo.destinationdatetime);
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
				<div class="data-containers" style="border: 1px solid #e0dfd9;">
					<div class="data-search">
						<div class="left-conditionals">
							<div class="inner" style="margin-top: 10px;">
								<span>线路名称：</span><span><select id="lines_sel" name="lines_sel"><option value=''>全部</option>
										<c:forEach items="${lines}" var="line">
											<option value="${line.lineId}">${line.departurename}-${line.destinationname}</option>
										</c:forEach>
								</select></span> <span class="name">发车日期：</span><span><input type="text" id="dept_date1" name="dept_date1" class="date"
									readonly="readonly" placeholder="${curDate }"
									onclick="WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',isShowToday:false,isShowOK:false});" /></span><span
									style="margin: 0 2px 0 2px;">-</span><span><input type="text" id="dept_date2" name="dept_date2"
									class="date" readonly="readonly" placeholder="${curDate }"
									onclick="WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',isShowToday:false,isShowOK:false});" /></span> <span
									class="name">车牌：</span><span><select id="carname_sel" name="carname_sel"><option value=''>全部</option>
										<c:forEach items="${cars}" var="car">
											<option value="${car.licenseplate}">${car.licenseplate}</option>
										</c:forEach>
								</select></span>
							</div>
							<div class="inner">
								<span>班线名称：</span><span><select id="classline_sel" name="classline_sel"><option value=''>全部</option>
										<c:forEach items="${classlines}" var="classline">
											<option value="${classline.classlineId}">${classline.classlineName}</option>
										</c:forEach>
								</select></span> <span class="name">发车时间：</span><span><input type="text" id="dept_time1" name="dept_time1" class="time"
									readonly="readonly" placeholder="${startCurTime}"
									onclick="WdatePicker({skin:'twoer',dateFmt:'HH:mm',isShowToday:false,isShowOK:false});" /></span><span
									style="margin: 0 2px 0 2px;">-</span><span><input type="text" id="dept_time2" name="dept_time2"
									class="time" readonly="readonly" placeholder="${endCurTime }"
									onclick="WdatePicker({skin:'twoer',dateFmt:'HH:mm',isShowToday:false,isShowOK:false});" /></span> <span class="name">司机：</span><span><select
									id="drivername_sel" name="drivername_sel"><option value=''>全部</option>
										<c:forEach items="${drivers}" var="driver">
											<option value="${driver.driverId}">${driver.fullname}</option>
										</c:forEach>
								</select></span>
							</div>
						</div>
						<div class="right-searchButton">
							<span class="search"><input type="button" id="search" name="search" value="搜 索"
								onclick="createWin.searchStatistics();" /></span>
						</div>
					</div>
					<div class="results">
						<div class="cloumns">
							<div class="inner" id="tickets">
								<div class="name">售票总数</div>
								<div class="number">0</div>
							</div>
						</div>
						<div class="cloumns">
							<div class="inner" id="actualTickets">
								<div class="name">实际售票总数</div>
								<div class="number">0</div>
							</div>
						</div>
						<div class="cloumns noborder">
							<div class="inner" id="totalRevenue">
								<div class="name">总收入</div>
								<div class="number">0</div>
							</div>
						</div>
					</div>
					<div class="data-list"></div>
					<div class="data-more">
						<a href="javascript:void(0);">查看更多 ▼</a>
					</div>
					<!-- <a class="export" href="javascript:void(0);" target="_parent" onclick="createWin.searchStatisticsDetails(2);">导出报表</a> -->
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />   
	</div>
	<div id="chareredDiv" style="display: none;">
		<div class='edit-frequency'>
			<div class='columns'>
				<div class='inputs-containers'>
					<input type='text' id='departure' name='departure' placeholder='起点' readonly='readonly' />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='destination' name='destination' placeholder='终点' readonly='readonly' />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='shiji_no' name='shiji_no' placeholder='预约装载人数' readonly='readonly' />
				</div>
			</div>
			<div class='columns'>
				<div class='inputs-containers'>
					<textarea  id='baoche_tujing' name='baoche_tujing' placeholder='途径线路'
						style='width: 951px; background-color: #FAF9F3; border: 0;height: 50px;resize:none;' readonly='readonly' ></textarea>
				</div>
			</div>
			<div class='columns'>
				<div class='inputs-containers'>
					<input type='text' id='vehicles' name='vehicles' placeholder='车牌号' maxlength='7' autocomplete='off'
						readonly='readonly' style='width: 255px;' code='0' />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='drivers' name='drivers' placeholder='驾驶员' maxlength='10' code='0' autocomplete='off'
						readonly='readonly' />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='baoche_company' name='baoche_company' placeholder='包车单位' readonly="readonly" />
				</div>
			</div>
			<div class='columns'>
				<div class='inputs-containers'>
					<input type='text' id='baoche_contactor' name='baoche_contactor' placeholder='包车单位联系人' readonly="readonly" />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='contactor_idcard' name='contactor_idcard' placeholder='身份证号码' readonly="readonly" />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='contact_phone' name='contact_phone' placeholder='联系电话' readonly="readonly" />
				</div>
			</div>
			<div class='columns'>
				<div class='inputs-containers'>
					<input type='text' id='departureDate' name='departureDate' placeholder='发车时间' readonly=readonly />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='destinationDate' name='destinationDate' placeholder='收车时间' readonly="readonly" />
				</div>
				<div class='inputs-containers'>
					<input type='text' id='ticketprice' name='ticketprice' placeholder='0.00' style='width: 275px;' maxlength='20'
						readonly='readonly' /><span>元</span>
				</div>
			</div>
		</div>
	</div>

</body>
</html>