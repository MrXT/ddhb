<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/libs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	display: none;
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
	text-decoration: underline;
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

.data-containers .data-list table tr .xl-left-td {
	position: relative;
	float: left;
	left: -66px;
	width: 1px;
	top: 2px;
}

.data-containers .data-list table tr .xl-left-td a {
	background: url(resources/images/icons.png) no-repeat -201px -685px;
	display: inline-block;
	width: 50px;
	height: 50px;
	margin-top: 5px;
}

.data-containers .data-list table tr .xl-left-td a:hover {
	background-position: -137px -685px;
	background-color: #FDEEDF;
}

.data-containers .data-list table tr td.edit {
	position: relative;
	float: left;
	left: -1px;
	left: 1px\9;
	border: 0;
	width: 1px;
	top: -7px;
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
	width: 313px;
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

.cars-list, .drivers-list {
	position: absolute;
	top: 191px;
	left: 23px;
	width: 260px;
	height: auto;
	max-height: 200px;
	overflow: auto;
	border: 1px solid #DCDDDF;
	border-top: 0;
	background-color: #fff;
	display: none;
}

.drivers-list {
	left: 349px;
	width: 300px;
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

.drivers-list ul li a.active {
	background-position: -270px -570px;
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
	background: url(resources/skin/simple_gray/images/right.gif)
		no-repeat 0 35px;
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
</style>
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
								<span class="name">包车信息</span> <span class="number"></span> <span class="select"> <select id="lineSel"
									name="lineSel"><option>全部</option></select>
								</span>
							</div>
							<div class="right">
								<input type="button" id="releaseBC" name="releaseBC" value="新增包车" class="release"
									onclick="kyWin(createWin.releaseFrequency(0),1000,460,'包车管理', true, true);Tools.supportPlaceholder();"
									hidefocus="hidefocus" />
							</div>
						</div>
					</div>
					<div class="data-list"></div>
					<div class="data-more">
						<a href="javascript:void(0);">查看更多 ▼</a>
					</div>
				</div>
				<script src="resources/js/LinkedList-0.1.js" type="text/javascript"></script>
				<script type="text/javascript">
					var releaseOne = true, error_result,checkstatus,inspector, ticketcnt, classline = 0, car, driver, trData = new Array(), states, actualTickets, classlineData = 0, carsLink = new LinkedList(), driverLink = new LinkedList();
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
												line_name != "全部" ? createWin.initFrequency(line_name.split(",")[0], line_name.split(",")[1])
														: createWin.initFrequency("", "");
											});
									createWin.initFrequency("", "");
								}
							});
						},
						initFrequency : function(dept, dest) {
							$
									.ajax({
										url : "Frequency/WebSearchChartered",
										dataType : 'json',
										data : {},
										type : 'POST',
										success : function(resultData) {
											var data = resultData.rows;
											trData.push("<table cellpadding='0' cellspacing='0'>");
											trData.push("<tr class='list-header'>");
											trData.push("<td></td>");
											trData.push("<td class=\"width160\">签订日期</td>");
											trData.push("<td class=\"width200\">行程日期</td>");
											trData.push("<td class=\"width160\">起点</td>");
											trData.push("<td class=\"width160\">终点</td>");
											trData.push("<td class=\"width160\">预约人数</td>");
											trData.push("<td class=\"width200\">经办人</td>");
											trData.push("<td class=\"width120\">安检状态</td>");
											trData.push("<td></td>");
											trData.push("</tr>");
											$(".data-search .inner .left .number").html("(" + data.length + ")");
											if (data.length > 0) {
												for (var i = 0; i < data.length; i++) {
													trData.push("<tr>");
													trData.push("<td class='xl-left-td'><a href='javascript:void(0);' id='" + data[i].charteredId
															+ "' onclick='createWin.deleteChartered(this.id);'></a></td>");

													trData.push("<td>" + data[i].releasedatetime + "</td>");
													trData.push("<td>发车：" + data[i].departuredatetime + "&nbsp;&nbsp;&nbsp;收车："
															+ data[i].destinationdatetime + "</td>");
													trData.push("<td>" + data[i].departure + "</td>");
													trData.push("<td>" + data[i].destination + "</td>");
													trData.push("<td>" + data[i].orderpassenger + "</td>");
													trData.push("<td>" + (data[i].inspector == null ? "--" : data[i].inspector) + "</td>");
													trData.push("<td>" + data[i].checkstatusName + "</td>");

													trData
															.push("<td class='edit'><a href='javascript:void(0);' hidefocus=\"hidefocus\" onclick=\"createWin.createEditFrequency("
																	+ data[i].charteredId
																	+ ",'"
																	+ data[i].departure
																	+ "','"
																	+ data[i].destination
																	+ "','"
																	+ data[i].wayline
																	+ "','"
																	+ data[i].departuredatetime
																	+ "','"
																	+ data[i].destinationdatetime
																	+ "','"
																	+ data[i].licenseplate
																	+ "','"
																	+ data[i].drivername
																	+ "','"
																	+ data[i].charteredcompany
																	+ "','"
																	+ data[i].companyleader
																	+ "','"
																	+ data[i].leaderidnumber
																	+ "','"
																	+ data[i].leaderphone
																	+ "','"
																	+ data[i].passenger
																	+ "','"
																	+ data[i].orderpassenger
																	+ "','"
																	+ data[i].checkstatus
																	+ "','"
																	+ data[i].charteredprice + "');\" title='编辑包车单'></a></td>");
													trData.push("</tr>");
												}
											} else {
												trData.push("<tr>");
												trData.push("<td colspan='8'>暂无包车信息</td>");
												trData.push("</tr>");
											}
											$(".data-list").html(trData.join("") + "</table>");
										},
										error : function(XMLHttpRequest, textStatus, errorThrown) {
											alert(XMLHttpRequest.status);
											alert(XMLHttpRequest.readyState);
											alert(textStatus);
										}
									});
						},
						showTickets : function(classlinename, ticketsCnt, frequencyId, flag) {
							$.ajax({
								url : "./ShowTickets",
								dataType : 'json',
								data : {
									FREQUENCY_ID : frequencyId
								},
								type : 'POST',
								success : function(data) {
									if (data.length > 0) {
										kyWin("<div class='ticketsDetails'>数据获取中...</div>", 1000, 0, "<label>" + classlinename
												+ "</label><label>总票数：" + ticketsCnt + "</label><label id='yishou' name='yishou'>已售：0</label>", true,
												true);
										$("#yishou").html("已售：" + data.length);
										var result_str = "<table cellpadding='0' cellspacing='0'>";
										var outerStr;
										for (var i = 1; i <= data.length; i++) {
											if (i % 2 == 0 && i > 0) {
												outerStr += "<td><table><tr><td><span></span>" + data[i - 1]["USERNAME"] + "</td><td>购票码 "
														+ data[i - 1]["TICKETCODE"] + "</td><td>"
														+ (data[i - 1]["CHECKINGSTATUS"] > 0 ? "<b class='ticket-checked'>已检票</b>" : "未检票")
														+ "</td></tr></table></td>";
												outerStr += "</tr>";
												result_str += outerStr;
												outerStr = "";
											} else {
												outerStr = "<tr>";
												outerStr += "<td><table><tr><td><span></span>" + data[i - 1]["USERNAME"] + "</td><td>购票码 "
														+ data[i - 1]["TICKETCODE"] + "</td><td>"
														+ (data[i - 1]["CHECKINGSTATUS"] > 0 ? "<b class='ticket-checked'>已检票</b>" : "未检票")
														+ "</td></tr></table></td>";
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
								//setTimeout(function () { Tools.initControls("departure,destination", 300); Tools.clearInputBox($("#departure"), $("#destination")); Tools.clearInputBox($("#drivers")); }, 600);
								winStr = "<div class='release-frequency'><div class='columns'><div class='inputs-containers'><input type='text' id='departure' name='departure' placeholder='起点' style='cursor:text;' /></div><div class='inputs-containers'><input type='text' id='destination' name='destination' placeholder='终点' style='cursor:text;' /></div><div class='inputs-containers'><input type='text' id='shiji_no' name='shiji_no' placeholder='预约装载人数' style='cursor:text;' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='baoche_tujing' name='baoche_tujing' placeholder='途径线路' style='width:951px;background-image:none;cursor:text;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='vehicles' name='vehicles' placeholder='车牌号' autocomplete='off' style='width:260px;cursor:default;' readonly='readonly' code='0' /><span id='plat_listData' name='plat_listData' onclick=\"createWin.customerSelect(0);\" style='display:block;background:url(resources/images/icons.png) no-repeat -357px -1309px;position:absolute;top:150px;left:238px;width:40px;height:40px;cursor:pointer;'></span><div class='cars-list'><ul id='carsList'></ul></div><span id='passengers' name='passengers'>0座</span></div><div class='inputs-containers'><input type='text' id='drivers' name='drivers' placeholder='驾驶员' class='clve' code='0' autocomplete='off' style='background-image:none;cursor:default;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' readonly='readonly' /><span id='driver_listData' name='driver_listData' onclick=\"createWin.customerSelect(1);\" style='display:block;background:url(resources/images/icons.png) no-repeat -357px -1309px;position:absolute;top:150px;left:604px;width:40px;height:40px;cursor:pointer;'></span><div class='drivers-list'><ul id='driversList'></ul></div></div><div class='inputs-containers'><input type='text' id='baoche_company' name='baoche_company' placeholder='包车单位' style='cursor:text;' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='baoche_contactor' name='baoche_contactor' placeholder='包车单位联系人' style='cursor:text;' /></div><div class='inputs-containers'><input type='text' id='contactor_idcard' name='contactor_idcard' placeholder='身份证号码' style='cursor:text;' /></div><div class='inputs-containers'><input type='text' id='contact_phone' name='contact_phone' placeholder='联系电话' style='cursor:text;' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='departureDate' name='departureDate' placeholder='发车时间' readonly=\"readonly\" onclick=\"WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-%M-{%d+60}',isShowToday:false,isShowOK:false, readOnly: true,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\" /><label onclick=\"WdatePicker({el:'departureDate',skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-%M-{%d+60}',isShowToday:false,isShowOK:false,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\"></label></div><div class='inputs-containers'><input type='text' id='destinationDate' name='destinationDate' placeholder='收车时间' readonly=\"readonly\" onclick=\"WdatePicker({skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-%M-{%d+60}',isShowToday:false,isShowOK:false, readOnly: true,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\" /><label onclick=\"WdatePicker({el:'departureDate',skin:'twoer',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'%y-%M-{%d+60}',isShowToday:false,isShowOK:false,onpicked:function(){if($('#departureDate').val()!=$('#today').val()){$('#departureTime').val('');$('#more_departureTime').show();$('#one_departureTime').hide();}else{$('#departureTime1').val('');$('#more_departureTime').hide();$('#one_departureTime').show();}}});\"></label></div><div class='inputs-containers'><input type='text' id='ticketprice' name='ticketprice' placeholder='0.00' style='width:275px;cursor:text;' maxlength='20' /><span>元</span></div></div><div class='columns' style='height:42px;margin-top:10px;'><div class='inputs-containers' style='width:935px;'><div class=\"right\"><span></span><input type=\"button\" id=\"release\" name=\"release\" value=\"发布\" class=\"release\" onclick=\"createWin.release();\" hidefocus=\"hidefocus\" /></div></div></div></div>";
							} else {
								winStr = "<div class='edit-frequency'><div class='columns'><div class='inputs-containers'><input type='text' id='departure' name='departure' placeholder='起点' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='destination' name='destination' placeholder='终点' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='shiji_no' name='shiji_no' placeholder='预约装载人数' readonly='readonly' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='baoche_tujing' name='baoche_tujing' placeholder='途径线路' style='width:951px;background-image:none;border:0;' readonly='readonly' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='vehicles' name='vehicles' placeholder='车牌号' maxlength='7' autocomplete='off' readonly='readonly' style='width:255px;background-image:none;cursor:default;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' code='0' /><span id='plat_listData' name='plat_listData' onclick=\"createWin.customerSelect(0);\" style='display:block;background:url(resources/images/icons.png) no-repeat -357px -1309px;position:absolute;top:150px;left:233px;width:40px;height:40px;cursor:pointer;'></span><div class='cars-list' style='width:255px;'><ul id='carsList'></ul></div><span id='passengers' name='passengers'>0座</span></div><div class='inputs-containers'><input type='text' id='drivers' name='drivers' placeholder='驾驶员' maxlength='10' class='clve' code='0' autocomplete='off' style='background-image:none;cursor:default;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' readonly='readonly' /><span id='driver_listData' name='driver_listData' onclick=\"createWin.customerSelect(1);\" style='display:block;background:url(resources/images/icons.png) no-repeat -357px -1309px;position:absolute;top:150px;left:604px;width:40px;height:40px;cursor:pointer;'></span><div class='drivers-list'><ul id='driversList'></ul></div></div><div class='inputs-containers'><input type='text' id='baoche_company' name='baoche_company' placeholder='包车单位' readonly='readonly' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='baoche_contactor' name='baoche_contactor' placeholder='包车单位联系人' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='contactor_idcard' name='contactor_idcard' placeholder='身份证号码' readonly='readonly' /></div><div class='inputs-containers'><input type='text' id='contact_phone' name='contact_phone' placeholder='联系电话' readonly='readonly' /></div></div><div class='columns'><div class='inputs-containers'><input type='text' id='departureDate' name='departureDate' placeholder='发车时间' readonly=\"readonly\" /></div><div class='inputs-containers'><input type='text' id='destinationDate' name='destinationDate' placeholder='收车时间' readonly=\"readonly\"/></div><div class='inputs-containers'><input type='text' id='ticketprice' name='ticketprice' placeholder='0.00' style='width:275px;background-image:none;cursor:text;border:1px solid #DCDDDF;border-radius:3px;background-color:#FAF9F3;' maxlength='20' /><span>元</span></div></div><div class='columns' style='height:42px;margin-top:10px;'><div class='inputs-containers' style='width:935px;'><div class=\"right\"><span></span><input type=\"button\" id=\"savefrequency\" name=\"savefrequency\" value=\"保存\" class=\"release\" onclick=\"createWin.updateChartered($(this).attr('charteredId'));\" hidefocus=\"hidefocus\" /></div></div></div></div>";
							}
							carsLink = new LinkedList();
							driverLink = new LinkedList();
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
						customerSelect : function(tag) {
							if (tag == 0) {
								$("#carsList").html("");
								for (var j = 0; j < autocompleteVehicles.length; j++) {
									$(
											"<li><a href='javascript:void(0);' id='v_" + autocompleteVehicles[j].carId
													+ "' onclick=\"createWin.selectPlat('" + autocompleteVehicles[j].carId + "&"
													+ autocompleteVehicles[j].licenseplate + "&" + autocompleteVehicles[j].passengers+"&"
													+ autocompleteVehicles[j].checkstatus +"&" + autocompleteVehicles[j].inspector
													+ "',this,0);\">" + autocompleteVehicles[j].licenseplate + "</a></li>").appendTo($("#carsList"));
								}
								for (var i = 0; i < carsLink.size(); i++) {
									var _selector = $("#v_" + carsLink.get(i).split("&")[0]);
									if (typeof (_selector) == "object") {
										_selector.addClass("active");
									}
								}
							} else {
								$("#driversList").html("");
								for (var j = 0; j < autocompleteDrivers.length; j++) {
									$(
											"<li><a href='javascript:void(0);' id='d_" + autocompleteDrivers[j].driverId
													+ "' onclick=\"createWin.selectPlat('" + autocompleteDrivers[j].driverId + "&"
													+ autocompleteDrivers[j].fullname + "',this,1);\">" + autocompleteDrivers[j].fullname
													+ "</a></li>").appendTo($("#driversList"));
								}
								for (var i = 0; i < driverLink.size(); i++) {
									var _selector = $("#d_" + driverLink.get(i).split("&")[0]);
									if (typeof (_selector) == "object") {
										_selector.addClass("active");
									}
								}
							}

							$(document).click(
									function(event) {
										if ($(event.target).attr("id") == "plat_listData"
												|| $(event.target).parent().parent().attr("id") == "carsList") {
											$('.cars-list').show();
											$('.drivers-list').hide();
										} else if ($(event.target).attr("id") == "driver_listData"
												|| $(event.target).parent().parent().attr("id") == "driversList") {
											$('.drivers-list').show();
											$('.cars-list').hide();
										} else {
											$('.cars-list').hide();
											$('.drivers-list').hide();
										}
									});
						},
						selectPlat : function(selVal, e, tag) {
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
								$("#vehicles").val(selVal.split("&")[1]);
								$("#passengers").html(selVal.split("&")[2] + "座");
								ticketcnt = selVal.split("&")[2];
								if(selVal.split("&")[3] == 'null'){
									checkstatus = 0;
								}else{
									checkstatus = selVal.split("&")[3];
								}
								if(selVal.split("&")[4] != 'null'){
									inspector =selVal.split("&")[4];
								}
							} else {
								if (!driverLink.contains(selVal)) {
									driverLink.addLast(selVal);
									$(e).addClass("active");
								} else {
									driverLink.remove(selVal);
									$(e).removeClass("active");
								}
								var driversView = "";
								for (var i = 0; i < driverLink.size(); i++) {
									driversView += driverLink.get(i).split("&")[1] + ",";
								}
								$("#drivers").val(driversView.substring(0, driversView.length - 1));
							}
							e.preventDefault();
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
									$(this).attr("code", row.carId);
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
								url : "/Frequency/SearchClassLineByCompany",
								dataType : 'json',
								data : {
									DEPTID : deptid,
									DESTID : destid
								},
								type : 'POST',
								success : function(data, textStatus, XMLHttpRequest) {
									classlineData = data.length;
									if (classlineData > 0) {
										$("#classLinesList").html("");
										for (var j = 0; j < classlineData; j++) {
											$(
													"<li><a href='javascript:void(0);' id='classLineID_" + data[j]["CLASSLINE_ID"] + "' sitelist='"
															+ data[j]["SITE_NAME"] + "' tp=" + data[j]["TICKETPRICE"] + ">"
															+ data[j]["CLASSLINE_NAME"] + "</a></li>").appendTo($("#classLinesList"));
										}
										$(document).click(function(event) {
											if ($(event.target).attr("id") != "classline_option" && $(event.target).attr("id") != "classline") {
												list.hide();
											}
										});
										$(".classlines-list li a").click(function() {
											$("#classline").val($(this).text());
											$("#siteListData").html($(this).attr("sitelist"));
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
							} else if (Tools.CheckInputBox(_departureDate) == 0) {
								error_result = "请选择发车时间！";
							} else if (Tools.CheckInputBox(_destinationDate) == 0) {
								error_result = "请选择收车时间！";
							} else {
								if (_ticketprice.val().toString() != "") {
									if (!Tools.CheckDigit(_ticketprice.val()) || _ticketprice.val() < 1) {
										error_result = "包车价格填写错误，格式仅限输入阿拉伯数字！";
										$(".inputs-containers .right span").html(error_result);
										_ticketprice.focus();
										return false;
									}
								}

								$.ajax({
									url : "Frequency/CreateChartered",
									dataType : 'json',
									data : {
										departure : _departure.val(),
										destination : _destination.val(),
										wayline : _baoche_tujing.val(),
										departuredatetime : _departureDate.val(),
										destinationdatetime : _destinationDate.val(),
										licenseplate : _vehicles.val(),
										drivername : _drivers.val(),
										charteredcompany : _baoche_company.val(),
										companyleader : _baoche_contactor.val(),
										leaderidnumber : _contactor_idcard.val(),
										leaderphone : _contact_phone.val(),
										passenger : ticketcnt,
										inspector: inspector,
										checkstatus:checkstatus,
										orderpassenger : _shiji_no.val(),
										charteredprice : _ticketprice.val()
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

							$(".inputs-containers .right span").html(error_result);
						},
						deleteChartered : function(charteredid) {
							if (confirm("您正在执行包车单删除操作，删除后不可恢复，是否继续？")) {
								$.ajax({
									url : "Frequency/DeleteChartered",
									dataType : 'json',
									data : 'charteredId=' + charteredid,
									type : 'POST',
									success : function(data) {
										alert(data.msg);
										if (data.success) {
											Tools.closeWin(window.location.href);
										}
									}
								});
							}
						},
						updateChartered : function(charteredid) {
							error_result = "";
							var _vehicles = $("#vehicles");
							var _drivers = $("#drivers");
							var _ticketprice = $("#ticketprice");
							var _departuredatetime = $("#departureDate");
							var _passenger = $("#passengers").html().replace(/[^0-9]/ig, "");
							if (_vehicles.val() == "") {
								error_result = "请选择车辆！";
							} else if (_drivers.val() == "") {
								error_result = "请选择驾驶员！";
							} else {
								$.ajax({
									url : "Frequency/EditChartered",
									dataType : 'json',
									data : {
										charteredId : charteredid,
										licenseplate : _vehicles.val(),
										drivername : _drivers.val(),
										charteredprice : _ticketprice.val(),
										passenger : _passenger,
										departuredatetime : _departuredatetime.val(),
										checkstatus:checkstatus,
										inspector:inspector
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
							$(".inputs-containers .right span").html(error_result);
						},
						changeFrequencyStatus : function(fid, state) {
							if (confirm((state == 1) ? "确定关闭该班次吗？" : "确定开启该班次吗？")) {
								$.ajax({
									url : "/Frequency/ChangeFrequencyStatus",
									dataType : 'json',
									data : {
										FREQUENCY_ID : fid,
										STATUS : state
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
						},
						//'" + data[i].LEADERIDNUMBER + "','" + data[i].LEADERPHONE + "','" + data[i].PASSENGER + "','" + data[i].ORDERPASSENGER + "','" + data[i].CHECKSTATUS_NAME + "','" + data[i].CHARTEREDPRICE + "'
						createEditFrequency : function(CHARTEREDID, DEPARTURE, DESTINATION, WAYLINE, DEPARTUREDATETIME, DESTINATIONDATETIME,
								LICENSEPLATE, DRIVERNAME, CHARTEREDCOMPANY, COMPANYLEADER, LEADERIDNUMBER, LEADERPHONE, PASSENGER, ORDERPASSENGER,
								CHECKSTATUS_NAME, CHARTEREDPRICE) {
							kyWin(createWin.releaseFrequency(1), 1000, 460, '包车单编辑', true, true);
							//createWin.searchVehiclesAndDrivers(0);

							//PASSENGER,CHECKSTATUS_NAME

							$("#departure").val(DEPARTURE);
							$("#destination").val(DESTINATION);
							$("#shiji_no").val(ORDERPASSENGER);
							$("#baoche_tujing").val(WAYLINE);
							$("#vehicles").val(LICENSEPLATE);

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
							$("#drivers").val(DRIVERNAME);

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
						}
					}
					$(function() {
						//加载线路
						//createWin.initLines(0);
						//加载包车信息
						createWin.initFrequency("", "");
					});

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
				</script>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>