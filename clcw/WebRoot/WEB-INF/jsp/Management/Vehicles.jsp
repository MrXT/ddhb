<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/libs.jsp"%>
<base href="${basePath}">
<title>车来车往后台系统管理平台</title>
<style type="text/css">
.containers {
	width: 100%;
	height: auto;
}

.containers .top {
	height: 115px;
	width: 100%;
}

.containers .top a {
	display: inline-block;
	background: url(resources/images/icons.png) no-repeat;
	width: 590px;
	height: 115px;
	line-height: 102px;
	text-align: center;
	color: #FFF;
	font-size: 22px;
	font-family: 宋体;
}

.containers .top a.left {
	float: left;
	background-position: -97px -1554px;
}

.containers .top a.right {
	float: right;
	background-position: -796px -1705px;
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

.data-containers .data-search .inner .left input.addData {
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

.data-containers .data-list table tr td.width140 {
	width: 140px;
}

.data-containers .data-list table tr td.width118 {
	width: 118px;
}

.data-containers .data-list table tr td.width160 {
	width: 160px;
}

.data-containers .data-list table tr td.width200 {
	width: 200px;
}

.data-containers .data-list table tr td.edit {
	position: relative;
	float: left;
	left: -2px;
	left: 0px\9;
	border: 0;
	width: 1px;
	top: -7px;
}

.data-containers .data-list table tr td.edit a {
	background: url(resources/images/icons.png) no-repeat -144px -632px;
	float: left;
	margin-right: -40px;
	margin-top: 10px;
	display: inline-block;
	width: 50px;
	height: 50px;
}

.data-containers .data-list table tr td.edit a:hover {
	background-position: -88px -632px;
	background-color: #FDEEDF;
}

.data-containers .data-list table tr .xl-left-td {
	position: relative;
	float: left;
	left: -52px;
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

.data-containers .data-list table tr td a.xl-inner {
	display: block;
	width: 50px;
	height: 50px;
	background: url(resources/images/icons.png) no-repeat -254px -632px;
}

.data-containers .data-list table tr td a.xl-inner:hover {
	background-position: -198px -632px;
}

.add-vehicles, .update-vehicles {
	width: 98%;
	height: 170px;
	margin: 20px auto;
	color: #7E7E7E;
}

.add-vehicles .first-column, .add-vehicles .second-column,
	.update-vehicles .first-column, .update-vehicles .second-column {
	height: 60px;
	width: 100%;
}

.add-vehicles .first-column input, .add-vehicles .second-column input,
	.update-vehicles .first-column input, .update-vehicles .second-column input
	{
	width: 300px;
	height: 42px;
	line-height: 42px\9;
	margin-left: 19px;
	text-indent: 6px;
	background: url(resources/images/icons.png) no-repeat -97px -1236px;
	border: 0;
	font-family: simsun;
}

.update-vehicles .first-column input, .update-vehicles .second-column input
	{
	margin-left: 0;
	text-indent: 0;
}

.update-vehicles .first-column div.inner, .update-vehicles .second-column div.inner
	{
	width: 300px;
	float: left;
	display: block;
	margin-left: 19px;
}

.update-vehicles .first-column div.inner .label-name, .update-vehicles .second-column div.inner .label-name
	{
	display: inline-block;
	width: auto;
	height: 42px;
	line-height: 42px;
	padding-left: 5px;
	float: left;
	position: absolute;
	left: 30px;
	color: #959593;
	font-family: simsun;
}

.add-vehicles .third-column, .update-vehicles .third-column {
	height: 45px;
	width: 97.8%;
	text-align: right;
}

.add-vehicles .third-column input, .update-vehicles .third-column input
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

.add-vehicles .third-column span, .update-vehicles .third-column span {
	margin-right: 15px;
	color: #FD7100;
}

.vehicles-anjian {
	width: 100%;
	height: auto;
}

.vehicles-anjian table {
	width: 100%;
}

.vehicles-anjian table tr {
	height: 60px;
	text-align: center;
	border-bottom: 1px solid #E8E7E4;
}

.vehicles-anjian table tr.list-header {
	background: #F6F6F6;
	height: 40px;
	box-shadow: 0 2px 0 #d2d2d1;
}

.vehicles-anjian table tr.list-header td {
	font-family: 微软雅黑;
	font-size: 16px;
}

.vehicles-anjian table tr td span {
	background-position: -975px -451px;
	display: block;
	width: 60px;
	height: 30px;
	line-height: 29px;
	padding-left: 22px;
	background: url(resources/images/icons.png) no-repeat;
}

.vehicles-anjian table tr td span.pass {
	background-position: -1003px -451px;
}

.vehicles-anjian table tr td span.no-pass {
	background-position: -1120px -451px;
}
</style>
<script type="text/javascript">
	var error_result, trData = new Array();
	var createWin = {
		initCars : function() {
			$
					.ajax({
						url : "Frequency/SearchCars",
						dataType : 'json',
						data : '',
						type : 'POST',
						success : function(resultData) {
							var data = resultData.rows;
							$("#lblcarManage").html("(" + data.length + "辆)");
							trData.push("<tr class='list-header'>");
							trData.push("<td></td>");
							trData.push("<td class='width160'>车牌号</td>");
							trData.push("<td class='width160'>类型等级</td>");
							trData.push("<td class='width118'>技术等级</td>");
							trData.push("<td class='width118'>座位数</td>");
							trData.push("<td class='width200'>行驶证档案编号</td>");
							trData.push("<td class='width200'>道路运输证号</td>");
							trData.push("<td class='width118'>状态</td>");
							trData.push("<td class='width118'>安检员</td>");
							trData.push("<td width='100px'>操作</td>");
							trData.push("<td></td>");
							trData.push("</tr>");
							for (var i = 0; i < data.length; i++) {
								trData.push("<tr>");
								trData.push("<td class='xl-left-td'><a  href='javascript:void(0);' id='add_" + data[i].carId
										+ "' onclick='createWin.deleteCar(this.id);' title='删除车辆'></a></td>");
								trData.push("<td>" + data[i].licenseplate + "</td>");
								trData.push("<td>" + data[i].models + "</td>");
								trData.push("<td>" + data[i].technicalgrade + "</td>");
								trData.push("<td>" + data[i].passengers + "</td>");
								trData.push("<td>" + data[i].licensenumber + "</td>");
								trData.push("<td>" + data[i].transportpermits + "</td>");
								trData.push("<td>" + data[i].checkstatusName + "</td>");
								trData.push("<td>" + (data[i].inspector == null ? "--" : data[i].inspector) + "</td>");
								trData
										.push("<td align='center'><a class='xl-inner' href='javascript:void(0);' title='安检详情' onclick=\"createWin.getAnJianDetails('"
												+ data[i].licenseplate + "');\"></a></td>");
								trData.push("<td class='edit'><a href='javascript:void(0);' id='update_" + data[i].carId
										+ "' onclick=\"createWin.updateCar(this.id,'" + data[i].licenseplate + "','" + data[i].models + "','"
										+ data[i].passengers + "','" + data[i].licensenumber + "','" + data[i].transportpermits + "','"
										+ data[i].technicalgrade + "');\" title='车辆编辑'></a></td>");
								trData.push("</tr>");
							}
							$("#tbVehiclesData").append(trData.join(""));
						}
					});
		},
		addCars : function(flag) {
			if (flag == 0) {
				return "<div class='add-vehicles'><div class='first-column'><input type='text' id='vehicles_plate' name='vehicles_plate' placeholder='车牌号' maxlength='10' /><input type='text' id='vehicles_type' name='vehicles_type' placeholder='类型等级' maxlength='20' /><input type='text' id='technical_grade' name='technical_grade' placeholder='技术等级' maxlength='20' /></div><div class='second-column'><input type='text' id='vehicles_passengers' name='vehicles_passengers' placeholder='座位数' maxlength='2' /><input type='text' id='vehicles_licensenumber' name='vehicles_licensenumber' placeholder='行驶证号档案编号' maxlength='20' /><input type='text' id='vehicles_transportpermits' name='vehicles_transportpermits' placeholder='道路运输许可证' maxlength='25' /></div><div class='third-column'><span></span><input type='button' id='saveCar' name='saveCar' value='保存' flag='0' onclick='createWin.saveCar();' /></div></div>";
			} else {
				return "<div class='update-vehicles'><div class='first-column'><div class='inner'><label class='label-name'>车牌号：</label><input type='text' id='vehicles_plate' name='vehicles_plate' maxlength='10' style='text-indent:60px;text-indent:53px\\9;' /></div><div class='inner'><label class='label-name' style='left:350px;'>类型等级：</label><input type='text' id='vehicles_type' name='vehicles_type' maxlength='20' style='text-indent:77px;text-indent:67px\\9;' /></div><div class='inner'><label class='label-name' style='left:670px;'>技术等级：</label><input type='text' id='technical_grade' name='technical_grade' maxlength='20' style='text-indent:77px;text-indent:68px\\9;' /></div></div><div class='second-column'><div class='inner'><label class='label-name'>座位数：</label><input type='text' id='vehicles_passengers' name='vehicles_passengers' maxlength='2' style='text-indent:60px;text-indent:53px\\9;' /></div><div class='inner'><label class='label-name' style='left:350px;'>行驶证号档案编号：</label><input type='text' id='vehicles_licensenumber' name='vehicles_licensenumber' maxlength='20' style='text-indent:120px;text-indent:110px\\9;' /></div><div class='inner'><label class='label-name' style='left:670px;'>道路运输许可证：</label><input type='text' id='vehicles_transportpermits' name='vehicles_transportpermits' maxlength='25' style='text-indent:116px;text-indent:104px\\9;' /></div></div><div class='third-column'><span></span><input type='button' id='saveCar' name='saveCar' value='保存' flag='0' onclick='createWin.saveCar();' /></div></div>";
			}
		},
		updateCar : function(carId, plat, model, passengers, licenseNo, transportNo, technicalGrade) {
			kyWin(createWin.addCars(1), 1000, 255, '编辑车辆', true, true);
			$('#saveCar').attr('flag', carId.split("_")[1]);
			$("#vehicles_plate").val(plat);
			$("#vehicles_plate").attr('readonly','readonly');
			$("#vehicles_type").val(model);
			$("#vehicles_passengers").val(passengers);
			$("#vehicles_licensenumber").val(licenseNo);
			$("#vehicles_transportpermits").val(transportNo);
			$("#technical_grade").val(technicalGrade);
		},
		saveCar : function() {
			var cp = $("#vehicles_plate");
			var cx = $("#vehicles_type");
			var tg = $("#technical_grade");
			var zk = $("#vehicles_passengers");
			var xs = $("#vehicles_licensenumber");
			var dl = $("#vehicles_transportpermits");
			error_result = "";
			if (Tools.CheckInputBox(cp) == 0) {
				error_result = "请输入车牌号！";
			} else if (Tools.CheckInputBox(cx) == 0) {
				error_result = "车辆类型等级不能为空！";
			} else if (Tools.CheckInputBox(tg) == 0) {
				error_result = "请填写车辆技术等级！";
			} else if (Tools.CheckInputBox(zk) == 0) {
				error_result = "请填写车辆载客人数！";
			} else if (Tools.CheckInputBox(xs) == 0) {
				error_result = "请填写车辆行驶证档案编号！";
			} else if (Tools.CheckInputBox(dl) == 0) {
				error_result = "道路运输证号不能为空！";
			} else {
				var reg = /^(\w|[\u4E00-\u9FA5])*$/;
				var re=/^[\u4e00-\u9fa5]{1}[A-Z]{1}[A-Z_0-9]{5}$/;
				if (cp.val().length != 7) {
					error_result = "确保车牌号长度7位！";
				} else if (cp.val().search(re)==-1) {
					error_result = "请输入合法的车牌号！";
				} else if (!cx.val().match(reg)) {
					error_result = "车辆类型包含非法字符，请检查！";
				} else if (tg.val().match(/[^\u4e00-\u9fa5]/)) {
					error_result = "车辆技术等级只能输入中文字符！";
				} else if (!Tools.CheckDigit(zk.val()) || zk.val() < 1) {
					error_result = "载客人数只能为大于0的阿拉伯数字！";
				}
				else if (xs.val().match(/[^\w\.\/]/ig)) {
					error_result = "行驶证号只能为数字或字母！";
				}
				else if (!Tools.CheckDigit(dl.val()) || dl.val().length < 1) {
					error_result = "道路许可证只能为1~25位数字！";
				} else {
					$.ajax({
						url : "Management/saveCar",
						dataType : 'json',
						data : {
							licenseplate : cp.val(),
							models : cx.val(),
							technicalgrade : tg.val(),
							passengers : zk.val(),
							licensenumber : xs.val(),
							transportpermits : dl.val(),
							carId : $('#saveCar').attr('flag')
						},
						type : 'POST',
						success : function(resultData) {
							alert(resultData.msg);
                        	if(resultData.success){
                        		Tools.closeWin(window.location.href);
                        	}else{
                        		if(confirm("该车辆已被冻结,是否解冻?")){
                        			$.ajax({
                                        url: "Management/Activation",
                                        dataType: 'json',
                                        data: { carId: resultData.data, freeze: "0"},//0表示为冻结，1表示冻结
                                        type: 'POST',
                                        success: function (data) {
                                            alert(data.msg);
                                            if (data.success) { Tools.closeWin(window.location.href); }
                                        }
                                    });
                        		}
                        	}
						}
					});
				}
			}
			$(".third-column span").html(error_result);
		},
		deleteCar : function(carId) {
			if (confirm("您正在做车辆删除操作，是否继续？")) {
				$.ajax({
					url : "Management/DeleteCar",
					dataType : 'json',
					data : 'carId=' + carId.split("_")[1],
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
		getAnJianDetails : function(licenseplat) {
			kyWin(
					"<div class=\"vehicles-anjian\"><table cellpadding=\"0\" cellspacing=\"0\"><tbody><tr class=\"list-header\"><td>安检时间</td><td>安检人员</td><td>安检状态</td></tr><tr><td colspan=\"3\">数据加载中，请稍候...</td></tr></tbody></table></div>",
					1000, 500, '安检记录', true, true);
			var t = setTimeout(function() {
				$.ajax({
					url : "Frequency/SearchCars",
					dataType : 'json',
					data : 'licenseplate=' + licenseplat,
					type : 'POST',
					success : function(resultData) {
						var data = resultData.rows;
						trData = new Array();
						trData.push("<div class=\"vehicles-anjian\"><table cellpadding=\"0\" cellspacing=\"0\">");
						trData.push("<tr class='list-header'>");
						trData.push("<td width='30%'>安检时间</td>");
						trData.push("<td width='30%'>安检人员</td>");
						trData.push("<td width='30%'>安检状态</td>");
						trData.push("</tr>");
						if (data.length > 0 ) {
							for (var i = 0; i < data.length; i++) {
								var isShow = true;
								if(data[i].inspector != null){
									trData.push("<tr>");
									trData.push("<td>" + data[i].checkdatetime + "</td>");
									trData.push("<td>" + data[i].inspector + "</td>");
									trData.push("<td align='center'><span class='" + (data[i].checkstatusName == "已通过" ? "pass" : "no-pass") + "'>"
											+ data[i].checkstatusName + "</span></td>");
									trData.push("</tr>");
								}else{
									if(isShow){
										trData.push("<tr><td colspan='3'>暂无安检详情</td></tr>");
										isShow = false;
									}
								}
							}
						}
						$(".vehicles-anjian").html(trData.join("") + "</table></div>");
						clearTimeout(t);
					}
				});
			}, 300);
		}
	}
	$(function() {
		createWin.initCars();
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
				<div class="containers">
					<div class="top">
						<a href="javascript:void(0);" class="left">车辆管理<label id="lblcarManage"></label></a> <a href="javascript:void(0);"
							class="right" onclick="Tools.jump('${basePath}/Management/Drivers');">驾驶员管理<label id="lblDriversCount"></label></a>
					</div>
					<div class="data-containers">
						<div class="data-search">
							<div class="inner">
								<div class="left">
									<input type="button" id="addCL" name="addCL" value="新增车辆" class="addData"
										onclick="kyWin(createWin.addCars(0),1000,255,'新增车辆', true, true);Tools.supportPlaceholder();$('#saveCar').attr('flag', 0);" />
								</div>
							</div>
						</div>
						<div class="data-list">
							<table cellpadding='0' cellspacing='0' id="tbVehiclesData"></table>
						</div>
						<div class="data-more">
							<a href="javascript:void(0);">查看更多 ▼</a>
						</div>
					</div>
				</div>

			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>