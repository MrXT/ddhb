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
	background-position: -796px -1554px;
}

.containers .top a.right {
	float: right;
	background-position: -97px -1705px;
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

.data-containers .data-list table tr td.edit {
	position: relative;
	float: left;
	left: 1px;
	left: 3px\9;
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

.add-drivers, .update-drivers {
	width: 98%;
	height: 170px;
	margin: 20px auto;
	color: #7E7E7E;
}

.add-drivers .first-column, .add-drivers .second-column, .update-drivers .first-column,
	.update-drivers .second-column {
	height: 60px;
	width: 100%;
}

.add-drivers .first-column input, .add-drivers .second-column input,
	.update-drivers .first-column input, .update-drivers .second-column input
	{
	width: 300px;
	height: 42px;
	line-height: 43px\9;
	margin-left: 19px;
	text-indent: 6px;
	background: url(resources/images/icons.png) no-repeat -97px -1236px;
	border: 0;
	font-family: simsun;
}

.update-drivers .first-column input, .update-drivers .second-column input
	{
	margin-left: 0;
	text-indent: 45px;
	text-indent: 43px\9;
}

.update-drivers .first-column div.inner, .update-drivers .second-column div.inner
	{
	width: 300px;
	float: left;
	display: block;
	margin-left: 19px;
}

.update-drivers .first-column div.inner .label-name, .update-drivers .second-column div.inner .label-name
	{
	float: left;
	position: absolute;
	left: 30px;
	display: block;
	width: auto;
	height: 38px;
	line-height: 38px;
	padding-left: 5px;
	margin-top: 3px;
	color: #959593;
	font-family: simsun;
}

.add-drivers .second-column .jialing-tishi, .update-drivers .second-column .jialing-tishi
	{
	position: absolute;
	top: 123px;
	left: 32px;
	width: 295px;
	height: auto;
	background-color: #FD7100;
	color: #fff;
	display: none;
}

.add-drivers .second-column .jialing-tishi ul, .update-drivers .second-column .jialing-tishi ul
	{
	padding: 0;
	margin: 0;
}

.add-drivers .second-column .jialing-tishi ul li, .update-drivers .second-column .jialing-tishi ul li
	{
	height: 16px;
	line-height: 16px;
	list-style: none;
	padding: 3px 3px 3px 5px;
}

.add-drivers .third-column, .update-drivers .third-column {
	height: 45px;
	width: 97.8%;
	text-align: right;
}

.add-drivers .third-column input, .update-drivers .third-column input {
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat -573px -317px;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
}

.add-drivers .third-column span, .update-drivers .third-column span {
	margin-right: 15px;
	color: #FD7100;
}
</style>
<script type="text/javascript">
    var error_result, trData = new Array(); ;
    var createWin = {
        initDrivers: function () {
            $.ajax({
                url: "Frequency/SearchDrivers",
                dataType: 'json',
                data: '',
                type: 'POST',
                success: function (resultData) {
                	var data = resultData.rows;
                    $("#lblDriversCount").html("(" + data.length + "人)");
                    trData.push("<tr class='list-header'>");
                    trData.push("<td></td>");
                    trData.push("<td class='width140'>姓名</td>");
                    trData.push("<td class='width160'>性别</td>");
                    //trData.push("<td class='width200'>身份证号</td>");
                    trData.push("<td class='width160'>手机号码</td>");
                    trData.push("<td class='width120'>从业资格证号</td>");
                    trData.push("<td class='width260'>准驾类型</td>");
                    trData.push("<td></td>");
                    trData.push("</tr>");
                    for (var i = 0; i < data.length; i++) {
                        trData.push("<tr>");
                        trData.push("<td class='xl-left-td'><a  href='javascript:void(0);' id='add_" + data[i].driverId + "' onclick='createWin.deleteDriver(this.id);' title='删除司机'></a></td>");
                        trData.push("<td>" + data[i].fullname + "</td>");
                        trData.push("<td>" + data[i].sex + "</td>");
                        //trData.push("<td>" + data[i].idcardno + "</td>");
                        trData.push("<td>" + data[i].phone + "</td>");
                        trData.push("<td>" + data[i].certificatenumber + "</td>");
                        trData.push("<td>" + data[i].drivingtype + "</td>");
                        trData.push("<td class='edit'><a href='javascript:void(0);' id='update_" + data[i].driverId + "' onclick=\"createWin.updateDriver(this.id,'" + data[i].fullname + "','" + data[i].sex + "','" + data[i].idcardno + "','" + data[i].phone + "','" + data[i].drivingtype + "','" + data[i].certificatenumber + "');\" title='司机编辑'></a></td>");
                        trData.push("</tr>");
                    }
                    $("#tbDriversData").append(trData.join(""));
                }
            });
        },
        addDriver: function (flag) {
            if (flag == 0) {
                return "<div class='add-drivers'><div class='first-column'><input type='text' id='driver_name' name='driver_name' placeholder='姓名' maxlength='6' /><input type='text' id='driver_sex' name='driver_sex' placeholder='性别' maxlength='1' /><input type='text' id='driver_phone' name='driver_phone' placeholder='手机号码' maxlength='11' /></div><div class='second-column'><input type='text' id='driver_certificateNo' name='driver_certificateNo' placeholder='从业资格证号' maxlength='18' /><input type='text' id='driver_drivingGrade' name='driver_drivingGrade' placeholder='准驾类型' maxlength='18' /></div><div class='third-column'><span></span><input type='button' id='saveDriver' name='saveDriver' value='保存' flag='0' onclick='createWin.saveDriver();' /></div></div>";
            }
            else {
                return "<div class='update-drivers'><div class='first-column'><div class='inner'><label class='label-name'>姓名：</label><input type='text' id='driver_name' name='driver_name' maxlength='6' /></div><div class='inner'><label class='label-name' style='left:350px;'>性别：</label><input type='text' id='driver_sex' name='driver_sex' maxlength='1' /></div><div class='inner'><label class='label-name' style='left:670px;'>手机号码：</label><input type='text' id='driver_phone' name='driver_phone' maxlength='11' style='text-indent:73px;text-indent:67px\\9;' /></div></div><div class='second-column'><div class='inner'><label class='label-name'>从业资格证号：</label><input type='text' id='driver_certificateNo' name='driver_certificateNo' maxlength='25' style='text-indent:100px;text-indent:90px\\9;' /></div><div class='inner'><label class='label-name' style='left:350px;'>准驾类型：</label><input type='text' id='driver_drivingGrade' name='driver_drivingGrade' maxlength='18' style='text-indent:73px;text-indent:67px\\9;' /></div></div><div class='third-column'><span></span><input type='button' id='saveDriver' name='saveDriver' value='保存' flag='0' onclick='createWin.saveDriver();' /></div></div>";
            }
        },
        updateDriver: function (driverId, fullname, drivingSex, driveridno, phone, drivingGrade, certificateNo) {
            kyWin(createWin.addDriver(1), 1000, 255, '编辑司机', true, true);
            $('#saveDriver').attr('flag', driverId.split("_")[1]);
            $("#driver_name").val(fullname);
            $("#driver_sex").val(drivingSex);
            $("#driver_phone").val(phone);
            $("#driver_drivingGrade").val(drivingGrade);
            $("#driver_certificateNo").val(certificateNo);
        },
        saveDriver: function () {
            var name = $("#driver_name");
            var drivingSex = $("#driver_sex");
            var phone = $("#driver_phone");
            var drivingGrade = $("#driver_drivingGrade");
            var certificateNo = $("#driver_certificateNo");
            error_result = "";
            if (Tools.CheckInputBox(name) == 0) {
                error_result = "请输入司机姓名！";
            }
            else if (Tools.CheckInputBox(drivingSex) == 0) {
                error_result = "请填写司机性别！";
            }
            else if (Tools.CheckInputBox(phone) == 0) {
                error_result = "驾驶员联系方式不能为空！";
            }
            else if (Tools.CheckInputBox(drivingGrade) == 0 || drivingGrade.val().trim().length == 0) {
                error_result = "请正确填写驾驶员准驾类型！";
            }
            else if (Tools.CheckInputBox(certificateNo) == 0 ) {
                error_result = "请输入驾驶员从业资格证号！";
            }
            else {
                if (name.val().length < 2 || name.val().match(/[^\u4e00-\u9fa5]/)) {
                    error_result = "驾驶员姓名应该为2~6位中文字符！";
                }
                else if (drivingSex.val().match(/[^\u4e00-\u9fa5]/)) {
                    error_result = "性别只能为中文字符！";
                }
                else if (Tools.validateMP(phone.val()) == 0) {
                    error_result = "电话号码不符合规则！";
                }
//                else if (drivingGrade.val().match(/[^\u4e00-\u9fa5]/)) {
//                    error_result = "准驾类型只能为中文字符";
//                }
                else if (specialPattern.test(drivingGrade.val())){
                  error_result = "准驾类型不能填写特殊字符！";
              	}
                else if (certificateNo.val().length >18 ||certificateNo.val().length <8 || certificateNo.val().match(/[^\w\.\/]/ig)) {
                    error_result = "从业资格证号只能为8~18位数字或字母！";
                }
                else {
                    $.ajax({
                        url: "Management/saveDriver",
                        dataType: 'json',
                        data: { fullname: name.val(), sex: drivingSex.val(), idcardno: certificateNo.val(), phone: phone.val(), drivingtype: drivingGrade.val(), certificatenumber: certificateNo.val(), driverId: $('#saveDriver').attr('flag')},
                        type: 'POST',
                        success: function (resultData) {
                        	alert(resultData.msg);
                        	if(resultData.success){
                        		Tools.closeWin(window.location.href);
                        	}else{
                        		if(confirm("该司机已被冻结,是否解冻?")){
                        			$.ajax({
                                        url: "Management/Activation",
                                        dataType: 'json',
                                        data: { driverId: resultData.data, freeze: "0"},//0表示为冻结，1表示冻结
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
        deleteDriver: function (driverId) {
            if (confirm("您正在做驾驶员删除操作，是否继续？")) {
                $.ajax({
                    url: "Management/DeleteDriver",
                    dataType: 'json',
                    data: 'driverId=' + driverId.split("_")[1],
                    type: 'POST',
                    success: function (data) {
                        alert(data.msg);
                        if (data.success) { Tools.closeWin(window.location.href); }
                    }
                });
            }
        }
    }
    $(function () { createWin.initDrivers(); });
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
						<a href="javascript:void(0);" class="left" onclick="Tools.jump('${basePath}/Management/Vehicles');">车辆管理<label id="lblcarManage"></label></a>
						<a href="javascript:void(0);" class="right">驾驶员管理<label id="lblDriversCount"></label></a>
					</div>
					<div class="data-containers">
						<div class="data-search">
							<div class="inner">
								<div class="left">
									<input type="button" id="addSJ" name="addSJ" value="新增驾驶员" class="addData"
										onclick="kyWin(createWin.addDriver(0),1000,255,'新增驾驶员', true, true);Tools.supportPlaceholder();$('#saveDriver').attr('flag', 0);" />
								</div>
							</div>
						</div>
						<div class="data-list">
							<table cellpadding='0' cellspacing='0' id="tbDriversData">
							</table>
							<table cellpadding='0' cellspacing='0' style="display: none;">
								<tr class='list-header'>
									<td></td>
									<td class="width140">姓名</td>
									<td class="width160">年龄</td>
									<td class="width200">驾龄</td>
									<td class="width160">电话</td>
									<td class="width260">驾驶证号</td>
									<td class="width120">从业资格证号</td>
									<td></td>
								</tr>
								<tr>
									<td class="xl-left-td"><a href="javascript:void(0);"></a></td>
									<td>张三丰</td>
									<td>36</td>
									<td>12</td>
									<td>13800138000</td>
									<td>123456789987654321</td>
									<td>987654321321654789</td>
									<td class="edit"><a href="javascript:void(0);"></a></td>
								</tr>
								<tr>
									<td class="xl-left-td"><a href="javascript:void(0);"></a></td>
									<td>三丰张</td>
									<td>36</td>
									<td>12</td>
									<td>13800138000</td>
									<td>xx8974521oo123456</td>
									<td>oo8974521xx123456</td>
									<td class="edit"><a href="javascript:void(0);"></a></td>
								</tr>
							</table>
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