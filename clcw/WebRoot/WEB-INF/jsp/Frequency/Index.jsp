<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/libs.jsp"%>
<base href="${basePath}">
<title>车来车往后台系统管理平台</title>
<style type="text/css">
input {
	outline: 0;
}

a {
	outline: 0;
}

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

.data-containers .data-search .inner .left span.number, .data-containers .data-search .inner .left span.select
	{
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

.data-containers .data-search .inner .right, .release-frequency .inputs-containers .right,
	.edit-frequency .inputs-containers .right {
	float: right;
}

.data-containers .data-search .inner .right input.release,
	.release-frequency .inputs-containers .right input.release,
	.edit-frequency .inputs-containers .right input.release, .bottom input
	{
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat -573px -317px;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
	margin-top: 10px;
}

.data-containers .data-list, .skipFrequency {
	height: auto;
	width: 100%;
	background: #fff;
}

.bottom {
	width: 920px;
	height: 40px;
	margin: 20px auto;
	text-align: right;
}

.data-containers .data-list table, .skipFrequency table {
	width: 100%;
	border: 0px solid #000;
}

.data-containers .data-list table tr, .skipFrequency table tr {
	height: 60px;
	text-align: center;
	border-bottom: 1px solid #E0DFD9;
}

.data-containers .data-list table tr.list-header, .skipFrequency table tr.list-header
	{
	background: #bcd9f3;
	height: 40px;
	box-shadow: 0 2px 0 #d2d2d1;
}

.data-containers .data-list table tr.list-header td, .skipFrequency table tr.list-header td
	{
	font-family: 微软雅黑;
	font-size: 16px;
}

.data-containers .data-list table tr td, .skipFrequency table tr td {
	font-size: 14px;
	color: #454545;
	font-family: 宋体;
	border-bottom: 1px solid #E0DFD9;
}

.data-containers .data-list table tr td.width140, .skipFrequency table tr td.width140
	{
	width: 140px;
}

.data-containers .data-list table tr td.width120, .skipFrequency table tr td.width120
	{
	width: 120px;
}

.data-containers .data-list table tr td.width160, .skipFrequency table tr td.width160
	{
	width: 160px;
}

.data-containers .data-list table tr td.width220, .skipFrequency table tr td.width220
	{
	width: 220px;
}

.data-containers .data-list table tr td.width260, .skipFrequency table tr td.width260
	{
	width: 260px;
}

.data-containers .data-list table tr td.shouqing {
	color: #e84c3d;
}

.data-containers .data-list table tr td.normal {
	color: #000;
}

.data-containers .data-list table tr td p {
	border: 0;
	width: 75px;
	height: 40px;
	background: url(resources/images/icons.png) no-repeat;
	cursor: pointer;
	display: inline-block;
}

.data-containers .data-list table tr td p.normal {
	background-position: -97px -565px;
}

.data-containers .data-list table tr td p.close {
	background-position: -97px -505px;
}

.data-containers .data-list table tr td p.history {
	background-position: -195px -565px;
	cursor: default;
}

.data-containers .data-list table tr td a {
	margin-left: 15px;
	color: #000;
}

.data-containers .data-list table tr td a:hover {
	text-decoration: none;
	color: #fd7100;
}

.data-containers .data-list table tr td span.number {
	min-width: 80px;
	display: inline-block;
	height: 50px;
	line-height: 50px;
	text-align: left;
}

.data-containers .data-list table tr td span.xq {
	min-width: 60px;
	display: inline-block;
	height: 50px;
	line-height: 50px;
	text-align: left;
}

.data-containers .data-list table tr td span.xq a {
	margin-left: 0;
}

.data-containers .data-list table tr td.edit {
	position: relative;
	float: left;
	left: -1px;
	border: 0;
	width: 1px;
}

.data-containers .data-list table tr td.edit a {
	background: url(resources/images/icons.png) no-repeat -144px -632px;
	float: left;
	margin-left: 4px;
	margin-top: 4px;
	display: inline-block;
	width: 50px;
	height: 50px;
}

.data-containers .data-list table tr td.edit a:hover {
	background-position: -88px -632px;
	background-color: #FDEEDF;
}

.release-frequency, .edit-frequency {
	width: 100%;
	height: 234px;
	margin: 20px auto;
}

.release-frequency .columns, .edit-frequency .columns {
	height: 64px;
	width: 100%;
}

.release-frequency .inputs-containers, .edit-frequency .inputs-containers
	{
	width: 310px;
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
	float:left;
	width: 30px;
	height: 30px;
	cursor: pointer;
	postion:relative;
	z-index:5;
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

.classlines-list {
	position: relative;
	top: 0px;
	left: 0px;
	width: 258px;
	height: auto;
	max-height: 100px;
	overflow: auto;
	border: 1px solid #DCDDDF;
	border-top: 0;
	background-color: #fff;
	display: none;
}

.classlines-list ul li {
	margin: 0;
	padding: 0;
	list-style: none;
}

.classlines-list ul li a {
	display: block;
	height: 24px;
	line-height: 24px;
	padding: 5px;
}

.classlines-list ul li a:hover {
	background-color: #D2E9FF;
	color: #000;
}

.ticketsDetails {
	margin-top: 10px;
	height: auto;
}

.ticketsDetails table {
	width: 100%;
}

.ticketsDetails table tr td {
	width: 50%;
	height: 30px;
	line-height: 30px;
}

.ticketsDetails table tr td table {
	width: 100%;
	border: 1px solid #FFF;
}

.ticketsDetails table tr td table tr td {
	width: 30%;
	text-align: center;
}

.ticketsDetails table tr td table tr td b.ticket-checked {
	color: #1DBA9B;
	font-weight: normal;
}

.ticketsDetails table tr td table tr td span {
	display: inline-block;
	width: 15px;
	height: 10px;
	background: url(resources/images/icons.png) no-repeat -357px -460px;
}

.default-cursor {
	cursor: default;
}

.existsFrequency {
	width: 88%;
	height: 140px;
	line-height: 24px;
	margin: 0 auto;
}

.existsFrequency .inner {
	height: 90px;
	width: 100%;
}

.existsFrequency .inner .left-icon {
	float: left;
	display: inline-block;
	width: 17%;
	height: 90px;
	line-height: 90px;
	background: url(resources/skin/simple_gray/images/right.gif) no-repeat 0
		35px;
}

.existsFrequency .inner .right-text {
	float: left;
	display: inline-block;
	width: 80%;
	height: 70px;
	margin-top: 15px;
}

.existsFrequency .inner .right-text b {
	padding: 0 5px 0 5px;
}

.existsFrequency .inner .right-text b.red {
	color: #FF0000;
}

.existsFrequency .inner .right-text b.green {
	color: #4EB84A;
}

.existsFrequency .inner .right-text b.blue {
	color: #345DD1;
}

.existsFrequency .inner .right-text a {
	color: #FF0000;
	float: right;
}

.existsFrequency .inner1 {
	height: 45px;
	line-height: 45px;
	width: 90%;
	margin: 10px auto;
	text-align: center;
}

.existsFrequency .inner1 input {
	width: 100px;
	height: 42px;
	line-height: 42px;
	background: url(resources/images/icons.png) no-repeat -573px -317px;
	border: 0;
	color: #fff;
	cursor: pointer;
}

.cars-list, .drivers-list {
	position: relative;
	z-index: 1000;
	top: 0px;
	left: 0px;
	width: 240px;
	height: auto;
	max-height: 200px;
	overflow: auto;
	border: 1px solid #DCDDDF;
	border-top: 0;
	background-color: #fff;
	display: none;
}

.cars-list ul li, .drivers-list ul li {
	margin: 0;
	padding: 0;
	list-style: none;
}

.cars-list ul li a, .drivers-list ul li a {
	display: block;
	height: 30px;
	line-height: 30px;
	padding: 5px;
}

.cars-list ul li a:hover, .drivers-list ul li a:hover {
	background-color: #D2E9FF;
	color: #000;
}

.cars-list ul li a.active, .drivers-list ul li a.active {
	background: #D2E9FF url(resources/images/icons.png) no-repeat -300px
		-570px;
}


</style>
<script src="resources/js/LinkedList-0.1.js" type="text/javascript"></script>
<script type="text/javascript">
	var releaseOne = true, selectedCars,interval,autocompleteVehicles, carsLink = new LinkedList(), driverLink = new LinkedList(), carCount = 0, selectedFrequency, error_result, ticketcnt, classline = 0, car, driver, trData = new Array(), states, actualTickets, classlineData = 0;
	
	var createWin = {
		initLines : function(flag) {
			$.ajax({
				type : 'post',
				url : '/Statistics/BindAllConditions',
				data : {
					FLAG : flag,
					TAG : 'frequency'
				},
				dataType : "json",
				success : function(data) {
					Tools.bindSelect(document.getElementById("lineSel"), data, flag);
					$("#lineSel").change(
							function() {
								var line_name = $(this).children('option:selected').val();
								trData = new Array();
								line_name != "全部" ? createWin.initFrequency(line_name.split(",")[0], line_name.split(",")[1]) : createWin
										.initFrequency("", "");
							});
					createWin.initFrequency("", "");
				}
			});
		},
		initFrequency : function(dept, dest) {
			var data = null;
			if (dept != "" && dest != "") {
				data = {
					departure : dept,
					destination : dest
				}
			}
			$
					.ajax({
						url : "Frequency/GetFrequency",
						dataType : 'json',
						data : data,
						type : 'POST',
						success : function(resultData) {
							var data = resultData.rows;
							trData.push("<table cellpadding='0' cellspacing='0'>");
							trData.push("<tr class='list-header'>");
							trData.push("<td class=\"width200\">线路</td>");
							trData.push("<td class=\"width140\">班线</td>");
							trData.push("<td class=\"width120\">日期</td>");
							trData.push("<td class=\"width200\">发车时间</td>");
							trData.push("<td class=\"width160\">状态</td>");
							trData.push("<td class=\"width260\">总票数/已售(张)</td>");
							trData.push("<td class=\"width160\">操作</td>");
							trData.push("<td></td>");
							trData.push("</tr>");
							$(".data-search .inner .left .number").html(data.length + "次");
							if (data.length > 0) {
								for (var i = 0; i < data.length; i++) {
									trData.push("<tr>");
									//states = (data[i].timestampnumber > 60 ? (data[i].status == "-1" ? "close" : "normal") : "history");
									states = data[i].status == "-1" ? "close" : "normal";
									actualTickets = (parseInt(data[i].ticketnumber) - parseInt(data[i].refundtictetnumber));
									//trData.push("<td class='xl-left-td'><a  href='javascript:void(0);' id='del_" + data[i].FREQUENCY_ID + "' onclick='createWin.deleteFrequency(this.id);'></a></td>");
									trData.push("<td style='width:280px;'><div style='display:inline-block;vertical-align: middle;min-width:30px;height:25px;width:auto;max-width:130px;overflow:hidden;'>" 
									+ (data[i].departurename.length >9? data[i].departurename.substring(0,7)+"<span onmouseover='openTip(\""+data[i].departurename+"\");' onmouseout='closeTip();' style='display:inline-block;vertical-align: middle;color:#aaa;'>‥‥</span>":data[i].departurename)
									+ "</div><div style='display:inline-block;vertical-align: middle;width:10px;text-align:center;'>-</div><div style='display:inline-block;height:25px;vertical-align: middle;min-width:30px;width:auto;max-width:130px;overflow:hidden;'>" 
									+ (data[i].destinationname.length >9? (data[i].destinationname.substring(0,7)+"<span onmouseover='openTip(\""+data[i].destinationname+"\");' onmouseout='closeTip();' style='display:inline-block;vertical-align: middle;color:#aaa;'>‥‥</span>"):data[i].destinationname) + "</div></td>");
									trData.push("<td>" + data[i].classlineName + "</td>");
									trData.push("<td>" + data[i].departuredate + "</td>");
									trData.push("<td>" + data[i].departuretime + "</td>");
									trData
											.push("<td><p id='status_"
													+ data[i].frequencyId
													+ "' name='status_"
													+ data[i].frequencyId
													+ "' state="
													+ data[i].status
													+ " class='"
													+ states
													+ "' onclick='"
													+ (states != "history" ? "createWin.changeFrequencyStatus($(this).attr(\"id\").split(\"_\")[1],$(this).attr(\"state\"))"
															: "return false") + "'></p></td>");
									trData.push("<td><span class='number' style='text-align:center;'>"
											+ (data[i].ticketcount > 0 ? (data[i].ticketcount < 10 ? ("0" + data[i].ticketcount)
													: data[i].ticketcount) : data[i].ticketcount)
											+ "/"
											+ (actualTickets > 0 ? (actualTickets < 10 ? ("0" + actualTickets) : actualTickets) : actualTickets)
											+ /* "/"
																															+ (data[i].refundtictetnumber > 0 ? (data[i].refundtictetnumber < 10 ? ("0" + data[i].refundtictetnumber)
																																	: data[i].refundtictetnumber) : data[i].refundtictetnumber)
																															+ */"</span>"
											+ (actualTickets > 0 ? "<span class='xq' style='text-align:center;'><a href='javascript:void(0);' onclick=\"createWin.showTickets('"
													+ data[i].classlineName + "','" + data[i].ticketcount + "','" + data[i].frequencyId
													+ "',0);\">查看详情</a></span>" : '') + "</td>");
									if (data[i].charteredVo.charteredId == null) {
										trData.push("<td><a href='javascript:void(0)' onclick='assignCarAndDriver(\"" + data[i].frequencyId + "\",\""
												+ data[i].carSDrivers + "\"," + data[i].ticketcount + "," + data[i].charteredVo.charteredId
												+ ")'>派车</a></td>");
									} else {
										trData
												.push("<td><a href='javascript:void(0)' style='color:#CCC;'  onclick='javascript:return;'>派车</a></td>");
									}
									if (data[i].charteredVo.charteredId != null) {
										trData.push("<td class='edit'><a href='javascript:void(0);' hidefocus=\"hidefocus\" id='update_"
												+ data[i].frequencyId + "' onclick=\"createWin.createEditCharered(" + "'"
												+ data[i].charteredVo.frequencyId + "'," + data[i].charteredVo.charteredId + ",'"
												+ data[i].charteredVo.departure + "','" + data[i].charteredVo.destination + "','"
												+ data[i].charteredVo.wayline + "','" + data[i].charteredVo.departuredatetime + "','"
												+ data[i].charteredVo.destinationdatetime + "','" + data[i].charteredVo.licenseplate + "','"
												+ data[i].charteredVo.drivername + "','" + data[i].charteredVo.charteredcompany + "','"
												+ data[i].charteredVo.companyleader + "','" + data[i].charteredVo.leaderidnumber + "','"
												+ data[i].charteredVo.leaderphone + "','" + data[i].charteredVo.passenger + "','"
												+ data[i].charteredVo.orderpassenger + "','" + data[i].charteredVo.checkstatus + "','"
												+ data[i].charteredVo.charteredprice + "','" + data[i].carSDrivers + "');\" title='包车编辑'></a></td>");
									} else {
										var param = JSON.stringify(data[i]);
										trData
												.push("<td class='edit'><a href='javascript:void(0);' hidefocus=\"hidefocus\" onclick='createWin.createCharered("
														+ param + ");' title='包车添加'");
									}
									trData.push("</tr>");
								}
								//$(".data-more").show();
							} else {
								trData.push("<tr>");
								trData.push("<td colspan='8'>暂无班次信息</td>");
								trData.push("</tr>");
							}
							$(".data-list").html(trData.join("") + "</table>");
						}
					});
		},
		showTickets : function(classlinename, ticketsCnt, frequencyId, flag) {
			$.ajax({
				url : "Frequency/ShowTickets",
				dataType : 'json',
				data : {
					frequencyId : frequencyId
				},
				type : 'POST',
				success : function(resultData) {
					var data = resultData.rows;
					if (data.length > 0) {
						kyWin("<div class='ticketsDetails'>数据获取中...</div>", 1000, 0, "<label>" + classlinename + "</label><label>总票数：" + ticketsCnt
								+ "</label><label id='yishou' name='yishou'>已售：0</label>", true, true);
						$("#yishou").html("已售：" + data.length);
						var result_str = "<table cellpadding='0' cellspacing='0'>";
						var outerStr;
						for (var i = 1; i <= data.length; i++) {
							if (i % 2 == 0 && i > 0) {
								outerStr += "<td><table><tr><td><span></span>" + data[i - 1]["username"] + "</td><td>购票码 "
										+ data[i - 1]["ticketnumber"] + "</td><td>"
										+ (data[i - 1]["checkingstatus"] ? "<b class='ticket-checked'>已检票</b>" : "未检票") + "</td></tr></table></td>";
								outerStr += "</tr>";
								result_str += outerStr;
								outerStr = "";
							} else {
								outerStr = "<tr>";
								outerStr += "<td><table><tr><td><span></span>" + data[i - 1]["username"] + "</td><td>购票码 "
										+ data[i - 1]["ticketnumber"] + "</td><td>"
										+ (data[i - 1]["checkingstatus"] ? "<b class='ticket-checked'>已检票</b>" : "未检票") + "</td></tr></table></td>";
								if (i == data.length) {
									if (data.length == 1) {
										outerStr += "<td><table><tr><td></td><td></td><td></td></tr></table></td>";
									}
									outerStr += "</tr>";
									result_str += outerStr;
									outerStr = "";
								}
							}
						}
						$(".ticketsDetails").html(result_str + "</table>");
						ymPrompt.resizeWin(1000, $(".ticketsDetails").height() + 70);
					} else {
						alert("不存在检票详情！");
					}
				}
			});
		},
		showSkipFrequency : function() {
			$
					.ajax({
						url : "./GetSkipFrequency",
						dataType : 'json',
						data : {},
						type : 'POST',
						success : function(data) {
							if (data.length > 0) {
								trData = new Array();
								kyWin(
										"<div class='skipFrequency'>数据获取中...</div><div class='bottom'><input type='button' id='skipOK' name='skipOK' value='知道了' onclick='Tools.closeWin(window.location.href)' hidefocus='hidefocus' /></div>",
										1000, 0, "已发布班次", true, true);
								trData.push("<table cellpadding='0' cellspacing='0'>");
								trData.push("<tr class='list-header'>");
								trData.push("<td class=\"width140\">线路</td>");
								trData.push("<td class=\"width140\">班线</td>");
								trData.push("<td class=\"width160\">日期</td>");
								trData.push("<td class=\"width200\">发车时间</td>");
								trData.push("<td class=\"width120\">司机</td>");
								trData.push("<td>车辆</td>");
								trData.push("</tr>");
								for (var i = 0; i < data.length; i++) {
									trData.push("<tr>");
									trData.push("<td>" + data[i].DEPARTURENAME + "—" + data[i].DESTINATIONNAME + "</td>");
									trData.push("<td>" + data[i].CLASSLINE_NAME + "</td>");
									trData.push("<td>" + data[i].DEPARTUREDATE + "</td>");
									trData.push("<td>" + data[i].DEPARTURETIME + "</td>");
									trData.push("<td>" + data[i].FULLNAME + "</td>");
									trData.push("<td>" + data[i].LICENSEPLATE + "</td>");
									trData.push("</tr>");
								}
								$(".skipFrequency").html(trData.join("") + "</table>");
								ymPrompt.resizeWin(1000, $(".skipFrequency").height() + 124);
								skip = 1;
							}
						}
					});
		},
		releaseFrequency : function(flag) {
			var winStr;
			releaseOne = true;
			ticketcnt = "";
			if (flag == 0) {
				setTimeout(function() {
					createWin.bindSpanClickEvent();
					//createWin.searchVehiclesAndDrivers(0);
					Tools.initControls("departure,destination", 300);
					Tools.clearInputBox($("#departure"), $("#destination"));
					Tools.clearInputBox($("#vehicles"), $("#drivers"));
				}, 600);
				winStr = "<div class='release-frequency'><div class='columns'><div class='inputs-containers'><input type='text' id='departure' name='departure' placeholder='起点（拼音支持首字母输入）' style='cursor:text;' code='0' /></div><div class='inputs-containers'><input type='text' id='destination' name='destination' placeholder='终点（拼音支持首字母输入）' style='cursor:text;' code='0' /></div><div class='inputs-containers' id='classline_option' name='classline_option' onclick=\"createWin.customerSelect($('.classlines-list'));\"><input type='text' id='classline' name='classline' placeholder='选择班线' readonly=\"readonly\" class='clve' /><div class='classlines-list'><ul id='classLinesList'></ul></div></div></div><div class='columns'><div class='inputs-containers sites'><textarea id='siteListData' name='siteListData' placeholder='途径站点:' readonly='readonly' style='color:#333;width:900px;background-image:none;cursor:text;border:1px solid #DCDDDF;resize:none;border-radius:3px;background-color:#FAF9F3;height:50px;'></textarea></div></div><div class='columns'><div class='inputs-containers' id='releaseOne'><input type='text' id='departureDate' name='departureDate' placeholder='发车日期' readonly=\"readonly\" onclick=\"WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-%M-{%d+7}',isShowToday:false,isShowOK:false, readOnly: true,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\" /><label onclick=\"WdatePicker({el:'departureDate',skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-%M-{%d+7}',isShowToday:false,isShowOK:false,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\"></label></div><div class='inputs-containers' id='releaseMore' style='display:none;'><input type='text' id='departureStartDate' name='departureStartDate' placeholder='发车起始日期' readonly=\"readonly\" style='width:135px;' onclick=\"checkingDate('start');\" /><p class='zhi'>至</p><input type='text' id='departureEndDate' name='departureEndDate' placeholder='发车结束日期' readonly=\"readonly\" style='width:135px;' onclick=\"checkingDate('end');\" /></div><div class='inputs-containers' id='one_departureTime'><input type='text' id='departureTime' name='departureTime' placeholder='选择时间' readonly=\"readonly\" onclick=\"WdatePicker({skin: 'twoer', dateFmt: 'HH:mm', minDate: '%H:%m:%d', isShowToday: false, isShowOK: false, readOnly: true})\" /><label class=\"timeIcon\" onclick=\"WdatePicker({el:'departureTime',skin: 'twoer', dateFmt: 'HH:mm', minDate: '%H:%m', isShowToday: false, isShowOK: false})\"></label></div><div class='inputs-containers' id='more_departureTime' style='display:none;'><input type='text' id='departureTime1' name='departureTime1' placeholder='选择时间' readonly=\"readonly\" onclick=\"WdatePicker({ skin: 'twoer', dateFmt: 'HH:mm', isShowToday: false, isShowOK: false, readOnly: true });\" /><label class=\"timeIcon\" onclick=\"WdatePicker({ el:'departureTime1',skin: 'twoer', dateFmt: 'HH:mm', isShowToday: false, isShowOK: false });\"></label></div><div class='inputs-containers'><input type='text' id='passengers' name='passengers' placeholder='售票数' maxlength='7' autocomplete='off' style='width:258px;cursor:text;' code='0' /><span >座</span></div></div><div class='columns' style='height:64px;'><div class='inputs-containers'><input type='text' id='ticketprice'  name='ticketprice' placeholder='0' style='width:258px;cursor:text;' maxlength='4' /><span>元</span></div></div><div class='columns' style='height:42px;'><div class='inputs-containers' style='width:935px;'><div class=\"right\"><span></span><input type=\"button\" id=\"release\" name=\"release\" value=\"发布\" class=\"release\" onclick=\"createWin.release();\" hidefocus=\"hidefocus\" /></div></div></div></div>";
			} else {
				winStr = "<div class='edit-frequency'><div class='columns'><div class='inputs-containers'><input type='text' id='edit_deptdate' name='edit_deptdate' readonly=\"readonly\" /></div><div class='inputs-containers'><input type='text' id='edit_depttime' name='edit_depttime' readonly=\"readonly\" /></div><div class='inputs-containers'><input type='text' id='vehicles' name='vehicles' placeholder='车牌号' maxlength='7' autocomplete='off' style='width:258px;cursor:text;border:1px solid #DCDDDF;' /><span id='passengers' name='passengers'>0座</span></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='edit_classline' name='edit_classline' readonly=\"readonly\" /></div><div class='inputs-containers'><input type='text' id='drivers' name='drivers' maxlength='10' autocomplete='off' class='clve' placeholder='司机名称' style='background-image:none;cursor:text;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' /></div><div class='inputs-containers'><input type='text' id='edit_price' name='edit_price' placeholder='0.00' readonly=\"readonly\" style='width:258px;' /><span>元</span></div></div><div class='columns'><div class='inputs-containers sites'><div class='arrow-up'></div><p>班线站点：</p><p id='edit_sites' name='edit_sites' style='color:#333;'></p></div></div><div class='columns' style='height:42px;'><div class='inputs-containers' style='width:935px;'><div class=\"right\"><span></span><input type=\"button\" id=\"savefrequency\" name=\"savefrequency\" value=\"保存\" class=\"release\" onclick=\"createWin.updateFrequency($(this).attr('fid').split('_')[1]);\" hidefocus=\"hidefocus\" /></div></div></div></div>"; //createWin.release();
			}
			return winStr;
		},
		bindSpanClickEvent : function() {
			var _span = $(".ym-header-text span");
			$(_span[0]).bind("click", function(e) {
				$("#releaseMore").hide();
				$("#releaseOne").show();
				$(_span[1]).html("发布多次");
				createWin.clearInputValue();
				releaseOne = true;
				$("#one_departureTime").show();
				$("#more_departureTime").hide();
			});
			$(_span[1]).bind("click", function(e) {
				$("#releaseOne").hide();
				$("#releaseMore").show();
				$(this).html("发布多次<b>（最多发布7日）</b>");
				createWin.clearInputValue();
				releaseOne = false;
				$("#one_departureTime").hide();
				$("#more_departureTime").show();
			});
		},
		clearInputValue : function() {
			$(".ym-body").find("input").each(function() {
				if ($(this).attr("type") == "text") {
					$(this).val("");
					$("#siteListData").html("");
				}
			});
			Tools.supportPlaceholder();
			$(".inputs-containers .right span").html(error_result);
		},
		customerSelect : function(list) {
			if ($("#departure").val() == "" || $("#destination").val() == "") {
				alert("请先填写线路起点和终点，支持拼音检索！");
				return true;
			}
			if (list.css("display") != "none") {
				list.hide();
			} else {
				list.show();
			}
			createWin.searchClassLine($("#departure").attr("code"), $("#destination").attr("code"), list);
		},
		searchVehiclesAndDrivers : function(tag) {
			if (tag == 0) {
				$('#vehicles').autocomplete(autocompleteVehicles, {
					delay : 1,
					selectFirst : true,
					scroll : false,
					max : 5,
					minChars : 1,
					width : 258,
					matchContains : true,
					autoFill : false,
					formatItem : function(data) {
						return data.licenseplate;
					},
					formatMatch : function(data) {
						return data.licenseplate;
					},
					formatResult : function(data) {
						return data.licenseplate + data.carId + data.passengers;
					}
				}).result(function(event, row, formatted) {
					$(this).val(row.licenseplate);
					ticketcnt = row.passengers;
					$("#edit_v").val(row.licenseplate);
					$("#passengers").html(ticketcnt + "座");
					$(this).attr("code", row.car_id);
					$(this).unbind("blur");
				});
				createWin.searchVehiclesAndDrivers(1);
			} else {
				$('#drivers').autocomplete(autocompleteDrivers, {
					delay : 1,
					selectFirst : true,
					scroll : false,
					max : 5,
					minChars : 1,
					width : 300,
					matchContains : true,
					autoFill : false,
					formatItem : function(data) {
						return data.fullname;
					},
					formatMatch : function(data) {
						return data.fullname;
					},
					formatResult : function(data) {
						return data.fullname + data.driverId;
					}
				}).result(function(event, row, formatted) {
					$(this).val(row.fullname);
					$("#edit_d").val(row.fullname);
					$(this).attr("code", row.driverId);
					$(this).unbind("blur");
				});
			}
		},
		searchClassLine : function(deptid, destid, list) {
			$.ajax({
				url : "Frequency/SearchClassLineByCompany",
				dataType : 'json',
				data : {
					departure : deptid,
					destination : destid
				},
				type : 'POST',
				success : function(resultData, textStatus, XMLHttpRequest) {
					var data = resultData.rows;
					classlineData = data.length;
					if (classlineData > 0) {
						$("#classLinesList").html("");
						for (var j = 0; j < classlineData; j++) {
							$(
									"<li><a href='javascript:void(0);' id='classLineID_" + data[j]["classlineId"] + "' sitelist='"
											+ data[j]["siteName"] + "' tp=" + data[j]["ticketprice"] + ">" + data[j]["classlineName"] + "</a></li>")
									.appendTo($("#classLinesList"));
						}
						$(document).click(function(event) {
							if ($(event.target).attr("id") != "classline_option" && $(event.target).attr("id") != "classline") {
								list.hide();
							}
						});
						$(".classlines-list li a").click(function() {
							$("#classline").val($(this).text());
							$("#siteListData").html($(this).attr("sitelist")==''?'无':$(this).attr("sitelist"));
							$("#ticketprice").val($(this).attr("tp"));
							classline = $(this).attr("id").split("_")[1];
						});
					} else {
						list.hide();
						alert("暂无此线路或此线路下没有班线！");
					}
				}
			});
		},
		release : function() {
			var _departureDate = $("#departureDate");
			var _departureStartDate = $("#departureStartDate");
			var _departureEndDate = $("#departureEndDate");
			var _departureTime = ((releaseOne) ? ($("#departureDate").val() == $("#today").val() ? $("#departureTime") : $("#departureTime1"))
					: $("#departureTime1"));
			var _vehicles = $("#vehicles");
			var _classline = $("#classline");
			var _drivers = $("#drivers");
			var _ticketprice = $("#ticketprice");
			error_result = "";

			if (Tools.CheckInputBox($("#departure")) == 0 || Tools.CheckInputBox($("#destination")) == 0) {
				error_result = "请输入并选择线路起点和终点！";
			} else if (Tools.CheckInputBox(_classline) == 0) {
				error_result = "请选择班线！";
			} else if (isNaN($("#passengers").val()) ||$("#passengers").val()==''  || parseInt($("#passengers").val()) <= 0) {
				error_result = "请输入可售票数";
			} else if (releaseOne && (Tools.CheckInputBox(_departureDate) == 0)) {
				error_result = "请选择发车日期！";
				$(".inputs-containers .right span").html(error_result);
				return false;
			} else if (releaseOne == false && (Tools.CheckInputBox(_departureStartDate) == 0) || releaseOne == false
					&& (Tools.CheckInputBox(_departureEndDate) == 0)) {
				error_result = "请选择发车日期段！";
				$(".inputs-containers .right span").html(error_result);
				return false;
			} else if (Tools.CheckInputBox(_departureTime) == 0) {
				error_result = "请选择发车时间！";
			} /* else if (Tools.CheckInputBox(_vehicles) == 0) {
								error_result = "请选择车辆！";
							} else if (Tools.CheckInputBox(_drivers) == 0) {
								error_result = "请选择司机！";
							} */else if (Tools.CheckInputBox(_ticketprice) == 0) {
				error_result = "请输入票价！";
			} else {
				
				
				if (!Tools.CheckDigit(_ticketprice.val()) || _ticketprice.val() < 1 || _ticketprice.val() > 1000) {
					error_result = "班次价格只能为大于0且小于1000的阿拉伯数字！";
				} else {
					$
							.ajax({
								url : "Frequency/ReleaseFrequency",
								dataType : 'json',
								data : {
									classlineId : classline,
									/* CARS_ID : $('#vehicles').attr("code"),
									DRIVER_ID : $('#drivers').attr("code"), */
									ticketcount : $("#passengers").val(),
									ticketfacevalue : _ticketprice.val(),
									departuredate : ((releaseOne) ? _departureDate.val() : _departureStartDate.val() + "*" + _departureEndDate.val()),
									departuretime : _departureTime.val(),
									sitename : $("#siteListData").html()=='无'?'':$("#siteListData").html(),
									//默认开启
									status : 1
								},
								type : 'POST',
								success : function(data, textStatus, XMLHttpRequest) {
									if (data.msg.indexOf("@@") > 0) {
										Tools.closeWin("");
										kyWin(
												"<div class='existsFrequency'><div class='inner'><div class='left-icon'></div><div class='right-text'>"
														+ data.msg.split("@@")[0]
														+ "</div></div><div class='inner1'><input type='button' value='确定' onclick='Tools.closeWin(window.location.href);' hidefocus=\"hidefocus\" /></div></div>",
												450, 200, '提示', false, true);
										return;
									}
									alert(data.msg);
									if (data.success) {
										Tools.closeWin(window.location.href);
									}
								}
							});
				}
			}
			$(".inputs-containers .right span").html(error_result);
		},
		deleteFrequency : function(fid) {
			alert(fid);
		},
		updateFrequency : function(fid) {
			error_result = "";
			var _vehicles = $("#vehicles");
			var _drivers = $("#drivers");
			if (_vehicles.val() == "") {
				error_result = "请选择车辆！";
			} else if (_drivers.val() == "") {
				error_result = "请选择司机！";
			} else {
				$.ajax({
					url : "/Frequency/EditFrequency",
					dataType : 'json',
					data : {
						FREQUENCY_ID : fid,
						CARS_ID : $('#vehicles').attr("code"),
						DRIVER_ID : $('#drivers').attr("code"),
						TICKETCOUNT : ticketcnt
					},
					type : 'POST',
					success : function(data, textStatus, XMLHttpRequest) {
						alert(data.Content);
						if (data.isSuccess) {
							Tools.closeWin(window.location.href);
						}
					}
				});
			}
			$(".inputs-containers .right span").html(error_result);
		},
		changeFrequencyStatus : function(fid, state) {
			if (confirm((state == 1) ? "确定关闭该班次吗？" : "确定开启该班次吗？")) {
				if (state == 1) {
					state = -1;//关闭
				} else {
					state = 1;//开启
				}
				$.ajax({
					url : "Frequency/ChangeFrequencyStatus",
					dataType : 'json',
					data : {
						frequencyId : fid,
						status : state
					},
					type : 'POST',
					success : function(data, textStatus, XMLHttpRequest) {
						alert(data.msg);
						if (data.success) {
							Tools.closeWin(window.location.href);
						}
					}
				});
			}
		},
		//班次编辑
		/* createEditFrequency : function(fid, carid, driverid, sites, classline, deptdate, depttime, fullname, licenseplat, ticketprice, ticketcount) {
			kyWin(createWin.releaseFrequency(1), 1000, 322, '班次编辑', true, true);
			createWin.searchVehiclesAndDrivers(0);
			$("#edit_d").val(fullname);
			$("#edit_v").val(licenseplat);
			$("#edit_deptdate").val(deptdate);
			$("#edit_depttime").val(depttime);
			$("#vehicles").val(licenseplat);
			$("#edit_classline").val(classline);
			$("#drivers").val(fullname);
			$("#edit_price").val(ticketprice);
			$("#passengers").html(ticketcount + "座");
			$("#edit_sites").html(sites);
			ticketcnt = ticketcount;
			$("#vehicles").attr("code", carid);
			$("#drivers").attr("code", driverid);
			$("#savefrequency").attr("fid", fid);
			$("#vehicles").bind("click blur", function() {
				if ($(this).val() != $("#edit_v").val()) {
					$(this).val("");
					$(this).attr("code", "");
					$("#passengers").html("0座");
				}
			});
			$("#drivers").bind("click blur", function() {
				if ($(this).val() != $("#edit_d").val()) {
					$(this).val("");
					$(this).attr("code", "");
				}
			});
		} */
		//包车的添加与编辑
		releaseCharered : function() {
			var _departure = $("#departure");
			var _destination = $("#destination");
			var _shiji_no = $("#shiji_no");
			var _baoche_tujing = $("#baoche_tujing");
			var _vehicles = $("#vehicles");
			var _drivers = $("#drivers");
			var _baoche_company = $("#baoche_company");
			var _baoche_contactor = $("#baoche_contactor");
			var _contactor_idcard = $("#contactor_idcard");
			var _contact_phone = $("#contact_phone");
			var _departureDate = $("#departureDate");
			var _destinationDate = $("#destinationDate");
			var _ticketprice = $("#ticketprice");
			error_result = "";
			var data = null;
			if ($("#savefrequency").attr('charteredid') == null) {
				if (Tools.CheckInputBox(_departure) == 0 || Tools.CheckInputBox(_destination) == 0) {
					error_result = "请输入并选择线路起点和终点！";
				} else if (Tools.CheckInputBox(_shiji_no) == 0) {
					error_result = "请填写预约载客人数！";
				} else if (Tools.CheckInputBox(_baoche_tujing) == 0) {
					error_result = "请填写途径线路！";
				} else if (Tools.CheckInputBox(_vehicles) == 0) {
					error_result = "请选择车辆！";
				} else if (Tools.CheckInputBox(_drivers) == 0) {
					error_result = "请选择驾驶员！";
				}
				data = {
					charteredId : $("#savefrequency").attr('charteredid'),
					frequencyId : $("#frequencyId").val(),
					departure : _departure.val(),
					destination : _destination.val(),
					wayline : _baoche_tujing.val()=='无'?'':_baoche_tujing.val(),
					departuredatetime : _departureDate.val(),
					destinationdatetime : _destinationDate.val(),
					licenseplate : _vehicles.val(),
					drivername : _drivers.val(),
					charteredcompany : _baoche_company.val(),
					companyleader : _baoche_contactor.val(),
					leaderidnumber : _contactor_idcard.val(),
					leaderphone : _contact_phone.val(),
					checkstatus : 1,//根据车辆确定，而车辆是继承班次的派车是的车辆，所以一定为1，已通过。
					orderpassenger : _shiji_no.val(),
					charteredprice : _ticketprice.val()
				}
			}else{
				data = {
						charteredId : $("#savefrequency").attr('charteredid'),
						destinationdatetime : _destinationDate.val(),
						charteredcompany : _baoche_company.val(),
						companyleader : _baoche_contactor.val(),
						leaderidnumber : _contactor_idcard.val(),
						leaderphone : _contact_phone.val()
					}
			}
			if (Tools.CheckInputBox(_departureDate) == 0) {
				error_result = "请选择发车时间！";
			} else if (Tools.CheckInputBox(_destinationDate) == 0) {
				error_result = "请选择收车时间！";
			}else if (Tools.CheckInputBox(_baoche_company) == 0) {
				error_result = "包车单位不能为空！";
			}else if (Tools.CheckInputBox(_baoche_contactor) == 0) {
				error_result = "包车联系人不能为空！";
			} else if (_contact_phone.val().length != 11||Tools.validateMP(_contact_phone.val()) == 0) {
				error_result = "电话号码不符合规则！";
			} else if (_contactor_idcard.val().length > 18 || _contactor_idcard.val().length < 8 || ! (/(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/).test(_contactor_idcard.val())) {
				error_result = "请输入正确的身份证号！";
			} else {
				if (_ticketprice.val().toString() != "") {
					if (!Tools.CheckDigit(_ticketprice.val()) || _ticketprice.val() < 1) {
						error_result = "包车价格填写错误，格式仅限输入阿拉伯数字！";
						$(".inputs-containers .right span").html(error_result);
						_ticketprice.focus();
						return false;
					}
				}
				if (typeof ($("#savefrequency").attr('charteredid')) == 'undefined') {
					url = "Frequency/CreateChartered";
				} else {
					url = "Frequency/EditChartered";
				}
				$.ajax({
					url : url,
					dataType : 'json',
					data : data,
					type : 'POST',
					success : function(data, textStatus, XMLHttpRequest) {
						alert(data.msg);
						if (data.success) {
							Tools.closeWin(window.location.href);
							if(url=='Frequency/CreateChartered'){
								//window.clearInterval(interval);
							}
						}
					}
				});
			}
			$(".inputs-containers .right span").html(error_result);
		},
		//包车的添加界面
		createCharered : function(param) {
			if (param.carSDrivers == null || param.carSDrivers == "") {
				alert("请先派车，在添加包车单！");
				return;
			}
			kyWin(createWin.releaseChartered(0), 1000, 460, '包车管理', true, true);
			Tools.supportPlaceholder();
			$("#frequencyId").val(param.frequencyId);
			$("#departure").val(param.departurename);
			$("#destination").val(param.destinationname);
			$("#shiji_no").val(param.ticketcount);
			$("#baoche_tujing").val(param.sitename==''?'无':param.sitename);
			$("#departureDate").val(param.departuredate);
			$("#ticketprice").val(param.ticketfacevalue);
			createWin.getCarsDrivers(param.carSDrivers);
			interval = setInterval(function(){
				$.ajax({
					url:'Frequency/getCarsDrivers',
					type:'post',
					data:{frequencyId:param.frequencyId},
					dataType : "json",
					success:function(resultData){//carSDrivers字符串格式 ：_车牌号,司机id，司机id__车牌号,司机id，司机id_
						var carsDrivers = resultData.data;
						createWin.getCarsDrivers(carsDrivers);
						
					}
				});
				
			}, 3000);
			
		},
		getCarsDrivers:function (carsDrivers){
			//截取车牌号与所有的司机
			var vehicleString = "";
			var driversString = "";
			var carDrivers = carsDrivers.split("_");
			for (var i = 0; i < carDrivers.length; i++) {
				var carToDrivers = carDrivers[i].split(",");
				if (carToDrivers[0] != "0") {
					vehicleString += carToDrivers[0] + ",";
					for (var j = 1; j < carToDrivers.length; j++) {
						for (var z = 0; z < autocompleteDrivers.length; z++) {
							if (autocompleteDrivers[z].driverId == carToDrivers[j]) {
								driversString += autocompleteDrivers[z].fullname + ",";
							}
						}
					}
				}
			}
			if (vehicleString == "" || driversString == "") {
				alert("请先正确派车，在添加包车单！");
				return;
			}
			$("#vehicles").val(vehicleString.substring(0, vehicleString.length - 1));
			$("#drivers").val(driversString.substring(0, driversString.length - 1));
		},
		//包车的修改界面
		createEditCharered : function(FREQUENCY_ID, CHARTEREDID, DEPARTURE, DESTINATION, WAYLINE, DEPARTUREDATETIME, DESTINATIONDATETIME,
				LICENSEPLATE, DRIVERNAME, CHARTEREDCOMPANY, COMPANYLEADER, LEADERIDNUMBER, LEADERPHONE, PASSENGER, ORDERPASSENGER, CHECKSTATUS_NAME,
				CHARTEREDPRICE, carSDrivers) {
			if (carSDrivers == null || carSDrivers == "") {
				alert("请先派车，在添加包车单！");
				return;
			}
			kyWin(createWin.releaseChartered(1), 1000, 460, '包车单编辑', true, true);
			//PASSENGER,CHECKSTATUS_NAME
			$("#frequencyId").val(FREQUENCY_ID);
			$("#departure").val('起点：' + DEPARTURE);
			$("#destination").val('终点：' + DESTINATION);
			$("#shiji_no").val('预载人数：' + ORDERPASSENGER);
			$("#baoche_tujing").val('途径：' + (WAYLINE==''?'无':WAYLINE));
			$("#vehicles").val('车辆：' + LICENSEPLATE);

			var platArr = LICENSEPLATE.split(",");
			var passengersView = 0;
			for (var i = 0; i < platArr.length; i++) {
				for (var j = 0; j < autocompleteVehicles.length; j++) {
					if (autocompleteVehicles[j].licenseplate == platArr[i]) {
						var selVal = autocompleteVehicles[j].carId + "&" + autocompleteVehicles[j].licenseplate + "&"
								+ autocompleteVehicles[j].passengers;
						if (!carsLink.contains(selVal)) {
							carsLink.addLast(selVal);
							passengersView += parseInt(autocompleteVehicles[j].passengers);
							$("#v_" + autocompleteVehicles[j].carId).addClass("active");
						}
						break;
					}
				}
			}
			$("#passengers").html(passengersView + "座");

			$("#edit_v").val(LICENSEPLATE);
			$("#drivers").val('司机：' + DRIVERNAME);

			var driverArr = DRIVERNAME.split(",");
			for (var i = 0; i < driverArr.length; i++) {
				for (var j = 0; j < autocompleteDrivers.length; j++) {
					if (autocompleteDrivers[j].FULLNAME == driverArr[i]) {
						var selVal = autocompleteDrivers[j].DRIVER_ID + "&" + autocompleteDrivers[j].FULLNAME;
						if (!driverLink.contains(selVal)) {
							driverLink.addLast(selVal);
							$("#v_" + autocompleteDrivers[j].DRIVER_ID).addClass("active");
						}
						break;
					}
				}
			}

			$("#edit_d").val(DRIVERNAME);
			$("#passengers").html(PASSENGER + "座");
			$("#baoche_company").val(CHARTEREDCOMPANY);

			$("#baoche_contactor").val(COMPANYLEADER);
			$("#contactor_idcard").val(LEADERIDNUMBER);

			$("#contact_phone").val(LEADERPHONE);
			$("#departureDate").val(DEPARTUREDATETIME);
			$("#destinationDate").val(DESTINATIONDATETIME);
			$("#ticketprice").val(CHARTEREDPRICE);

			$("#savefrequency").attr("charteredid", CHARTEREDID);
			$("#drivers").bind("click blur", function() {
				if ($(this).val() != $("#edit_d").val()) {
					$(this).val("");
					$(this).attr("code", "");
				}
			});
		},
		releaseChartered : function(flag) {
			var winStr;
			releaseOne = true;
			ticketcnt = "";
			if (flag == 0) {
				//setTimeout(function () { Tools.initControls("departure,destination", 300); Tools.clearInputBox($("#departure"), $("#destination")); Tools.clearInputBox($("#drivers")); }, 600);
				winStr = "<div class='release-frequency'><div class='columns'><div class='inputs-containers'><input type='hidden' id='frequencyId' name='frequencyId' /><input type='text' id='departure' name='departure' placeholder='起点' style='cursor:text;' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='destination' name='destination' placeholder='终点' style='cursor:text;' readonly='readonly'/></div><div class='inputs-containers'><input type='text' id='shiji_no' name='shiji_no' placeholder='预约装载人数' style='cursor:text;' readonly='readonly' /></div></div><div class='columns'><div class='inputs-containers'><textarea id='baoche_tujing' name='baoche_tujing' placeholder='途径线路' style='width:900px;background-image:none;cursor:text;resize:none;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;height:50px;' readonly='readonly' ></textarea></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='vehicles' name='vehicles' placeholder='车牌号'  style='width:260px;cursor:default;' readonly='readonly' code='0' /></div><div class='inputs-containers'><input type='text' id='drivers' name='drivers' placeholder='驾驶员' class='clve' code='0' style='background-image:none;cursor:default;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='baoche_company' name='baoche_company' placeholder='包车单位' style='cursor:text;' max-length='100' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='baoche_contactor' name='baoche_contactor' placeholder='包车单位联系人' style='cursor:text;' maxlength='25' /></div><div class='inputs-containers'><input type='text' id='contactor_idcard' name='contactor_idcard' placeholder='身份证号码' style='cursor:text;' /></div><div class='inputs-containers'><input type='text' id='contact_phone' name='contact_phone' placeholder='联系电话' style='cursor:text;' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='departureDate' name='departureDate' placeholder='发车时间' readonly=\"readonly\"  /></div><div class='inputs-containers'><input type='text' id='destinationDate' name='destinationDate' style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;z-index:10;filter:alpha(opacity:70);opacity: 0.7;' placeholder='收车时间' readonly=\"readonly\" onclick=\"WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(departureDate)}',maxDate:'%y-%M-{%d+60}',isShowToday:false,isShowOK:false, readOnly: true,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\" /><label></label></div><div class='inputs-containers'><input type='text' id='ticketprice' name='ticketprice' placeholder='0.00' style='width:275px;cursor:text;' maxlength='20' readonly='readonly' /><span>元</span></div></div><div class='columns' style='height:42px;margin-top:10px;'><div class='inputs-containers' style='width:935px;'><div class=\"right\"><span></span><input type=\"button\" id=\"release\" name=\"release\" value=\"发布\" class=\"release\" onclick=\"createWin.releaseCharered();\" hidefocus=\"hidefocus\" /></div></div></div></div>";
			} else {
				winStr = "<div class='edit-frequency'><div class='columns'><div class='inputs-containers'><input type='hidden' id='frequencyId' name='frequencyId' /><input type='text' id='departure' name='departure' placeholder='起点' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='destination' name='destination' placeholder='终点' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='shiji_no' name='shiji_no' placeholder='预约装载人数' readonly='readonly' /></div></div><div class='columns'><div class='inputs-containers'><textarea id='baoche_tujing' name='baoche_tujing' placeholder='途径线路' style='width:900px;background-image:none;cursor:text;resize:none;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;height:50px;' readonly='readonly' ></textarea></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='vehicles' name='vehicles' placeholder='车牌号' maxlength='7' autocomplete='off' readonly='readonly' style='width:255px;' code='0' /></div><div class='inputs-containers'><input type='text' id='drivers' name='drivers' placeholder='驾驶员' maxlength='10' code='0' autocomplete='off' disabled='disabled' /></div><div class='inputs-containers'><input type='text' id='baoche_company' name='baoche_company' placeholder='包车单位' style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' maxlength='100'/></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='baoche_contactor' name='baoche_contactor' placeholder='包车单位联系人' maxlength='25' style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;'/></div><div class='inputs-containers'><input type='text' id='contactor_idcard' name='contactor_idcard' placeholder='身份证号码' maxlength='18' style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;'/></div><div class='inputs-containers'><input type='text' id='contact_phone' name='contact_phone' placeholder='联系电话'  style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;'/></div></div><div class='columns'><div class='inputs-containers' style='width:70px'><span style='color:#000;font-size:12px;'>发车日期:</span></div><div class='inputs-containers' style='width:100px'><input type='text' id='departureDate' name='departureDate' placeholder='发车时间' readonly=\"readonly\"/></div><div class='inputs-containers' style='width:70px'><span style='color:#000;font-size:12px;'>收车日期:</span></div><div class='inputs-containers'><input type='text' id='destinationDate' name='destinationDate' placeholder='收车时间' readonly=\"readonly\" style='border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;z-index:10;filter:alpha(opacity:70);opacity: 0.7;' onclick=\"WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(departureDate)}',maxDate:'%y-%M-{%d+60}',isShowToday:false,isShowOK:false, readOnly: true,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\" /><label></label></div><div class='inputs-containers' style='width:50px'><span style='color:#000;width:50px'>单价：</span></div><div class='inputs-containers' style='width:200px'><input type='text' id='ticketprice' name='ticketprice' placeholder='0.00' style='width:150px;' maxlength='20' readonly='readonly'/><span>元</span></div></div><div class='columns' style='height:42px;margin-top:10px;'><div class='inputs-containers' style='width:935px;'><div class=\"right\"><span></span><input type=\"button\" id=\"savefrequency\" name=\"savefrequency\" value=\"保存\" class=\"release\" onclick=\"createWin.releaseCharered($(this).attr('charteredId'));\" hidefocus=\"hidefocus\" /></div></div></div></div>";
			}
			return winStr;
		}
	}

	function checkingDate(dp) {
		if (dp == 'start') {
			_minDate = '%y-%M-{%d+1}';
			_maxDate = '#F{$dp.$D(\'departureEndDate\')||\'%y-{%M+2}-%d\'}';
		} else {
			_minDate = '#F{$dp.$D(\'departureStartDate\')||\'%y-%M-{%d+1}\'}';
			_maxDate = '%y-{%M+2}-%d';
		}
		WdatePicker({
			skin : 'twoer',
			dateFmt : 'yyyy-MM-dd',
			minDate : _minDate,
			maxDate : _maxDate,
			isShowToday : false,
			isShowOK : false,
			doubleCalendar : true,
			readOnly : true
		});
	}
	//派车功能的界面
	function assignCarAndDriver(frequencyId,carsDrivers,ticketcount,charteredId) {
		autocompleteVehicles = $.parseJSON('${cars}');
		carsLink = new LinkedList();
		driverLink = new LinkedList();
		var html= "<div id='addCarDiv' class='release-frequency' style='height:310px;overflow-y:auto'>";
		if(carsDrivers == null || carsDrivers=="null"){carsDrivers="";}
		var carLicenseplates = "";
		var carDrivers = carsDrivers.split("_");
		carCount = carDrivers.length;//当前车的总数
		for(var i = 0;i<carCount;i++){
			var carToDrivers = carDrivers[i].split(",");
			var vehicleString = carToDrivers[0]!="0"?carToDrivers[0]:'';
			carLicenseplates +=carToDrivers[0]+",";
			var driversString = "";
			var driverIds = "";
			for(var j = 1;j<carToDrivers.length;j++){
				driverIds+=carToDrivers[j]+",";
				for (var z = 0; z < autocompleteDrivers.length; z++) {
					if (autocompleteDrivers[z].driverId == carToDrivers[j]) {
						driversString += autocompleteDrivers[z].fullname+",";
					}
				}
			}
			html+="<div class='columns'>"
				+"<div class='inputs-containers'>"
				+"<input type='text' id='vehicles"+i+"' class='allCars'  placeholder='车牌号' autocomplete='off' value='"+vehicleString+"'"
				+"style='width: 260px; cursor: default;' readonly='readonly' /> <span id='plat_listData'"
				+"name='plat_listData' code="+i+" onclick='carAndDriverSelect(0,this);'"
				+"style='display: block; background: url(resources/images/icons.png) no-repeat -357px -1309px; position:relative;top:1px; left: -45px; width: 40px; height: 40px; cursor: pointer;'></span>"
				+"<div class='cars-list'>"
				+"<ul id='carsList"+i+"'></ul>"
				+"</div>"
				+"</div>"
				+"<div class='inputs-containers'>"
				+"<input type='text' id='drivers"+i+"' class='allDrivers' driverIds='"+driverIds.substring(0,driverIds.length-1)+"'  placeholder='驾驶员' class='clve' code='0' autocomplete='off' value='"+driversString.substring(0,driversString.length-1)+"'"
				+"style='width: 260px; cursor: default;' readonly='readonly'/> <span id='driver_listData'" 
				+"name='driver_listData' code="+i+" onclick='carAndDriverSelect(1,this);'"
				+"style='display: block; background: url(resources/images/icons.png) no-repeat -357px -1309px; position:relative;top:1px; left: -45px;width: 40px; height: 40px; cursor: pointer;'></span>"
				+"<div class='drivers-list'>"
				+"<ul id='driversList"+i+"'></ul>"
				+"</div>"
				+"</div>"
				+"</div>";
		}
		html+="</div><div class='release-frequency' style='height:40px'>"
		+"<div class='columns'><div class='inputs-containers' style='width:650px;'><div class='release'><span>总共座位数:</span><span id='counts' count='0'></span></div><div class='right'><span></span>"
		+"<input type='button' value='加车' class='release' style='margin-right:100px; width:60px;height:30px;' onclick=\"addCar();\" hidefocus='hidefocus'>"
		+"<input type='button' value='减车' class='release' style='margin-right:100px; width:60px;height:30px;' onclick=\"deleteCar();\" hidefocus='hidefocus'>"
		+"<input type='button' id='release' name='release' value='确定' class='release' onclick=\"assginCar('"+frequencyId+"',"+charteredId+");\" hidefocus='hidefocus'></div></div></div>"
		+"</div>";
		kyWin(html, 700, 460, '派车单 预载人数：'+ticketcount, true, true);
		createWin.searchVehiclesAndDrivers(0);
		passengerCount(carLicenseplates);

	}
	function selectPlat(selVal, e, tag) {
		var $input = $(e).parent().parent().parent().parent().find('input[type=text]');
		if($(e).hasClass('active')&&$input.val().indexOf($(e).html()) == -1){
			alert("该项已被选择！请重新选择。");
			return;
		}
		
		if (tag == 0) {
			var lichildren = $(e).parent().parent().children();
			var elementid = $(lichildren[0]).children().attr("id");
			for (var i = 0; i < lichildren.length; i++) {
				if ($(lichildren[i]).children().attr("id") == "v_" + selVal.split("&")[0]) {
					$(e).addClass("active");
				} else {
					$(lichildren[i]).children().removeClass("active");
				}
			}

			//车辆多选
			//                if (!carsLink.contains(selVal)) {
			//                    carsLink.addLast(selVal);
			//                    $(e).addClass("active");
			//                }
			//                else {
			//                    carsLink.remove(selVal);
			//                    $(e).removeClass("active");
			//                }
			//                var vehiclesView = "", passengersView = 0;
			//                for (var i = 0; i < carsLink.size(); i++) {
			//                    vehiclesView += carsLink.get(i).split("&")[1] + ",";
			//                    passengersView += parseInt(carsLink.get(i).split("&")[2]);
			//                }
			//                $("#vehicles").val(vehiclesView.substring(0, vehiclesView.length - 1));
			//                $("#passengers").html(passengersView + "座");
			//                ticketcnt = passengersView;

			//车辆单选
			$input.val(selVal.split("&")[1]);
			$input.attr("passengers", selVal.split("&")[2]);
			//$("#passengers").html(selVal.split("&")[2]+"座");
			ticketcnt = selVal.split("&")[2];
			if (selVal.split("&")[3] == 'null') {
				checkstatus = 0;
			} else {
				checkstatus = selVal.split("&")[3];
			}
			if (selVal.split("&")[4] != 'null') {
				inspector = selVal.split("&")[4];
			}
			passengerCount(getCarLicenseplates());
		} else {
			if (driverLink.size()>=3 && !driverLink.contains(selVal)){
				alert('最多3名司机！');
				return;
			}
			if (!driverLink.contains(selVal)) {
				driverLink.addLast(selVal);
				$(e).addClass("active");
			} else {
				driverLink.remove(selVal);
				$(e).removeClass("active");
			}
			var driversView = "";
			var driverIds = "";
			for (var i = 0; i < driverLink.size(); i++) {
				driverIds += driverLink.get(i).split("&")[0] + ",";
				driversView += driverLink.get(i).split("&")[1] + ",";
			}
			$input.attr("driverIds", driverIds.substring(0, driverIds.length - 1));
			$input.val(driversView.substring(0, driversView.length - 1));
		}
// 		e.preventDefault();
	}
	//当选中下拉框弹出车辆与司机的信息
	function carAndDriverSelect(tag, e) {
		var $input = $(e).parent().find("input[type='text']");
		var code = $(e).attr("code");
		if (tag == 0) {
			var html = ""
			for (var j = 0; j < autocompleteVehicles.length; j++) {
				html += "<li><a href='javascript:void(0);' id='v_"+code+'_' + autocompleteVehicles[j].carId + "' onclick=\"selectPlat('"
						+ autocompleteVehicles[j].carId + "&" + autocompleteVehicles[j].licenseplate + "&" + autocompleteVehicles[j].passengers + "&"
						+ autocompleteVehicles[j].checkstatus + "&" + autocompleteVehicles[j].inspector + "',this,0);\">"
						+ autocompleteVehicles[j].licenseplate + "</a></li>";
			}
			$("#carsList" + code).html(html);
			carsLink = new LinkedList();
			//var carArr = $input.val().split(",");
			
			var carStrings = "";
			var inputs = $(".allCars");
			$.each(inputs,function(i,input){
				if(input.value != ''){
					carStrings += ','+input.value;
				}
			});
			var carArr = carStrings.substring(1,carStrings.length).split(',');
			for (var i = 0; i < carArr.length; i++) {
				for (var j = 0; j < autocompleteVehicles.length; j++) {
					if (autocompleteVehicles[j].licenseplate == carArr[i]) {
						var sel = autocompleteVehicles[j].carId + "&" + autocompleteVehicles[j].licenseplate;
						if (!carsLink.contains(sel)) {
							carsLink.addLast(sel);
						}
						break;
					}
				}
			}
			for (var i = 0; i < carsLink.size(); i++) {
				var _selector = $("#v_" +code+'_'+ carsLink.get(i).split("&")[0]);
				if (typeof (_selector) == "object") {
					_selector.addClass("active");
				}
			}
			var lis = $("#carsList" + code+" li");
			for(var i=0;i<lis.length;i++){
				for(var j=i;j<lis.length;j++){
		            if($($(lis[i]).children()[0]).hasClass('active')){
		                //交换两个元素的位置
		                var temp=lis[i];
		                lis[i]=lis[j];
		                lis[j]=temp;
		            }
		        }
			}
			var newHtml ="";
			for(var i=0;i<lis.length;i++){
				newHtml += "<li>"+lis[i].innerHTML+"</li>";
			}
			$("#carsList" + code).html(newHtml);
		} else {
			$("#driversList" + code).html("");
			for (var j = 0; j < autocompleteDrivers.length; j++) {
				$(
						"<li><a href='javascript:void(0);' id='d_"+code+'_' + autocompleteDrivers[j].driverId + "' onclick=\"selectPlat('"
								+ autocompleteDrivers[j].driverId + "&" + autocompleteDrivers[j].fullname + "',this,1);\">"
								+ autocompleteDrivers[j].fullname + "</a></li>").appendTo($("#driversList" + code));
			}
			//所有下框下的司机
			driversLink = new LinkedList();
			var driverStrings = "";
			var inputs = $(".allDrivers");
			$.each(inputs,function(i,input){
				if(input.value != ''){
					driverStrings += ','+input.value;
				}
			});
			var driverArr = driverStrings.substring(1,driverStrings.length).split(',');
			for (var i = 0; i < driverArr.length; i++) {
				for (var j = 0; j < autocompleteDrivers.length; j++) {
					if (autocompleteDrivers[j].fullname == driverArr[i]) {
						var sel = autocompleteDrivers[j].driverId + "&" + autocompleteDrivers[j].fullname;
						if (!driversLink.contains(sel)) {
							driversLink.addLast(sel);
						}
						break;
					}
				}
			}
			for (var i = 0; i < driversLink.size(); i++) {
				var _selector = $("#d_"+code+'_' + driversLink.get(i).split("&")[0]);
				if (typeof (_selector) == "object") {
					_selector.addClass("active");
				}
			}
			//该下拉框下的所选司机
			driverLink = new LinkedList();
			var driverArr = $input.val().split(",");
			for (var i = 0; i < driverArr.length; i++) {
				for (var j = 0; j < autocompleteDrivers.length; j++) {
					if (autocompleteDrivers[j].fullname == driverArr[i]) {
						var sel = autocompleteDrivers[j].driverId + "&" + autocompleteDrivers[j].fullname;
						if (!driverLink.contains(sel)) {
							driverLink.addLast(sel);
						}
						break;
					}
				}
			}
			var lis = $("#driversList" + code+" li");
			for(var i=0;i<lis.length;i++){
				for(var j=i;j<lis.length;j++){
		            if($($(lis[i]).children()[0]).hasClass('active')){
		                //交换两个元素的位置
		                var temp=lis[i];
		                lis[i]=lis[j];
		                lis[j]=temp;
		            }
		        }
			}
			var newHtml ="";
			for(var i=0;i<lis.length;i++){
				newHtml += "<li>"+lis[i].innerHTML+"</li>";
			}
			$("#driversList" + code).html(newHtml);
		}
		$(document).click(function(event) {
			var code = $(event.target).attr("code");
			if ($(event.target).attr("id") == "plat_listData" || $(event.target).parent().parent().attr("id") == "carsList") {
				$('#carsList' + code).parent().show();
				$('#driversList' + code).parent().hide();
			} else if ($(event.target).attr("id") == "driver_listData" || $(event.target).parent().parent().attr("id") == "driversList") {
				$('#carsList' + code).parent().hide();
				$('#driversList' + code).parent().show();
			} else {
				$('.cars-list').hide();
				$('.drivers-list').hide();
			}
		});
	}
	//新增一个车辆
	function addCar(){
		if($("#addCarDiv").children().length>=4){
			alert("最多添加4辆汽车！");
			return;
		}
		
		carCount++;
		var html="<div class='columns'>"
			+"<div class='inputs-containers'>"
			+"<input type='text' id='vehicles"+carCount+"' class='allCars' placeholder='车牌号' autocomplete='off'"
			+"style='width: 260px; cursor: default;' readonly='readonly' /> <span id='plat_listData'"
			+"name='plat_listData' code="+carCount+" onclick='carAndDriverSelect(0,this);'"
			+"style='display: block; background: url(resources/images/icons.png) no-repeat -357px -1309px; position:relative;top:1px; left: -45px; width: 40px; height: 44px; cursor: pointer;'></span>"
			+"<div class='cars-list'>"
			+"<ul id='carsList"+carCount+"'></ul>"
			+"</div>"
			+"</div>"
			+"<div class='inputs-containers'>"
			+"<input type='text' id='drivers"+carCount+"' class='allDrivers' placeholder='驾驶员' class='clve' code='0' autocomplete='off'"
			+"style='width: 260px; cursor: default;' readonly='readonly'/> <span id='driver_listData'" 
			+"name='driver_listData' code="+carCount+" onclick='carAndDriverSelect(1,this);'"
			+"style='display: block; background: url(resources/images/icons.png) no-repeat -357px -1309px; position:relative;top:1px; left: -45px;width: 40px; height: 44px; cursor: pointer;'></span>"
			+"<div class='drivers-list'>"
			+"<ul id='driversList"+carCount+"'></ul>"
			+"</div>"
			+"</div>"
			+"</div>";
		$("#addCarDiv").append(html);
		passengerCount(getCarLicenseplates());
	}
	//减少车辆
	function deleteCar() {
		if ($("#addCarDiv").children().length <= 1) {
			alert("至少选择1辆车！");
			return;
		}
		var childrens = $("#addCarDiv").children();
		document.getElementById("addCarDiv").removeChild(childrens[childrens.length - 1]);
		passengerCount(getCarLicenseplates());
	}
	//为班次分配车辆
	function assginCar(frequencyId, charteredId) {
		$.ajax({
			url:'Frequency/GetFrequency',
			type:'post',
			data:{frequencyId:frequencyId},
			dataType : "json",
			success:function(result){//carSDrivers字符串格式 ：_车牌号,司机id，司机id__车牌号,司机id，司机id_
				var rows = result.rows;
				if(rows[0].charteredVo.charteredId !=null){
					alert('该班次已经由其他管理员发布了包车单，不能派车！');
					Tools.closeWin(window.location.href);
				}else{
					var allCars = $(".allCars");
					var allDrivers = $(".allDrivers");
					var isGo = true;
					for (var i = 0; i < allCars.length; i++) {
						if ($(allCars[i]).val() == null || $(allCars[i]).val() == '' || $(allDrivers[i]).attr("driverIds") == 'undefined' || $(allDrivers[i]).val() == "") {
							alert("请正确选择司机与车辆,每个选择框不能为空！");
							isGo = false;
							break;
						}
					}
					if (!isGo) {
						return;
					}
					var param = "";
					$.each(allCars, function(i, car) {
						param += $(car).val() + ",";
						param += $(allDrivers[i]).attr("driverIds") + "_";
					});
					var carsDrivers = param.substring(0, param.length - 1);
					$.ajax({
						url : "Frequency/assignCar",
						dataType : 'json',
						data : {
							frequencyId : frequencyId,
							carSDrivers : carsDrivers
						},
						type : 'POST',
						success : function(data, textStatus, XMLHttpRequest) {
							alert(data.msg);
							if (data.success) {
								Tools.closeWin(window.location.href);
								/* if (charteredId != null) {
									var vehicleString = "";
									var driversString = "";
									var carDrivers = carsDrivers.split("_");
									for (var i = 0; i < carDrivers.length; i++) {
										var carToDrivers = carDrivers[i].split(",");
										vehicleString += carToDrivers[0] + ",";
										for (var j = 1; j < carToDrivers.length; j++) {
											for (var z = 0; z < autocompleteDrivers.length; z++) {
												if (autocompleteDrivers[z].driverId == carToDrivers[j]) {
													driversString += autocompleteDrivers[z].fullname + ",";
												}
											}
										}
									}
									$.ajax({
										url : "Frequency/EditChartered",
										dataType : 'json',
										data : {
											charteredId : charteredId,
											licenseplate : vehicleString.substring(0, vehicleString.length - 1),
											drivername : driversString.substring(0, driversString.length - 1)
										},
										type : 'POST',
										success : function(data, textStatus, XMLHttpRequest) {
										}
									});
								} */
							}
						}
					});
				}
			}
		});
		
	}
	function getCarLicenseplates() {
		var carLicenseplates = ""
		$.each($(".allCars"), function(i, car) {
			carLicenseplates += $(car).val() + ",";
		});
		return carLicenseplates;
	}
	function passengerCount(carLicenseplates) {
		var passengersView = 0;
		var platArr = carLicenseplates.substring(0, carLicenseplates.length - 1).split(",");
		for (var i = 0; i < platArr.length; i++) {
			for (var j = 0; j < autocompleteVehicles.length; j++) {
				if (autocompleteVehicles[j].licenseplate == platArr[i]) {
					passengersView += parseInt(autocompleteVehicles[j].passengers);
				}
			}
		}
		$("#counts").html(passengersView);
	}
	$(function() {
		createWin.initFrequency("", "");
		$("#lineSel").change(function() {
			var line_name = $(this).children('option:selected').val();
			trData = new Array();
			line_name != "全部" ? createWin.initFrequency(line_name.split(",")[0], line_name.split(",")[1]) : createWin.initFrequency("", "");
		});
	});
</script>
</head>
<body>
	<div id="container">
		<div style="height: 136px;">
			<jsp:include page="../common/head.jsp" />
		</div>
		<div id="content">
			<div id="main">
				<input type="hidden" id="edit_d" name="edit_d" /> <input type="hidden" id="edit_v" name="edit_v" /> <input
					type="hidden" id="today" name="today" value="${curDate}" />
				<div class="data-containers">
					<div class="data-search">
						<div class="inner">
							<div class="left">
								<span class="name">全部</span> <span class="number"></span> <span class="select"> <select id="lineSel"
									name="lineSel"><option>全部</option>
										<c:forEach items="${lines}" var="line">
											<option value="${line.departure},${line.destination}">${line.departurename}-${line.destinationname}</option>
										</c:forEach>
								</select>
								</span>
							</div>
							<div class="right">
								<input type="button" id="releaseBC" name="releaseBC" value="发布班次" class="release"
									onclick="kyWin(createWin.releaseFrequency(0),1000,388,'<span tag=1>发布班次</span>', true, true);Tools.supportPlaceholder();"
									hidefocus="hidefocus" />
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