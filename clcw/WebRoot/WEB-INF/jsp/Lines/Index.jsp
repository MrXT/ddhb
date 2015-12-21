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

.data-containers .data-search .inner .left span.number {
	color: #b6b6b6;
	margin-left: 5px;
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

.data-containers .data-search .inner .right input.release {
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

.data-containers .data-list table, .data-containers .data-list table.innerTable,
	.data-containers .data-list table.innerTable tr {
	border: 0;
}

.data-containers .data-list table tr {
	height: 60px;
	text-align: center;
	border-top: 1px solid #E0DFD9;
}

.data-containers .data-list table tr td {
	font-size: 14px;
	color: #454545;
	font-family: 宋体;
}

.data-containers .data-list table tr .xl-left-td {
	position: relative;
	float: left;
	left: -52px;
	width: 1px;
}

.data-containers .data-list table tr .xl-left-td a {
	background: url(resources/images/icons.png) no-repeat -201px -685px;
	display: inline-block;
	width: 50px;
	height: 50px;
	margin-top: 5px;
	top: 0px;
	position: absolute;
}

.data-containers .data-list table tr .xl-left-td a:hover {
	background-position: -137px -685px;
	background-color: #FDEEDF;
}

.data-containers .data-list table tr .xl-middle-td {
	position: relative;
	width: 80%;
	float: left;
}

.data-containers .data-list table tr .xl-middle-td .innerTable tr td {
	width: 15%;
	text-align: center;
	padding-left: 25px;
}

.data-containers .data-list table tr td.right-chakan {
	padding-right: 40px;
	text-align: right;
}

.addLine {
	width: 98%;
	height: 110px;
	margin: 25px auto;
}

.addLine .first-column {
	height: 76px;
	width: 100%;
}

.addLine .first-column input {
	width: 300px;
	height: 42px;
	line-height: 42px\9;
	margin-left: 19px;
	text-indent: 6px;
	background: url(resources/images/icons.png) no-repeat -97px -1236px;
	border: 0;
	cursor: text;
} /* 1307px */
.addLine .first-column input.price {
	background-position: -97px -1236px;
	cursor: text;
}

.addLine .second-column {
	width: 97.8%;
	text-align: right;
}

.addLine .second-column input {
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat -573px -317px;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
}

.addLine .second-column span {
	margin-right: 15px;
	color: #FD7100;
	font-size: 13px;
}

.addLine .city-div {
	width: 400px;
	height: 300px;
	margin: 0 auto;
	border: 1px solid #000;
	position: absolute;
	top: 0;
	display: none;
}
</style>
<script type="text/javascript">
	var error_result;
	var createWin = {
		addLine : function() {
			/* setTimeout(function() {
				Tools.clearInputBox($("#departure"), $("#destination"));
				Tools.initControls("departure,destination", 298);
			}, 600); */
			return "<div class='addLine'><div class='first-column'><input type='text' id='departure' name='departure' placeholder='起始地' code='0' /><input type='text' id='destination' name='destination' placeholder='目的地' code='0' /><input type='text' id='tprice' name='tprice' placeholder='票价（元）' class='price' maxlength='4' /></div><div class='second-column'><span></span><input type='button' id='saveLine' name='saveLine' value='保存' onclick='createWin.saveLine();' /></div><div class='city-div'></div></div>";
		},
		saveLine : function() {
			if (Tools.CheckInputBox($("#departure")) == 0 || $("#departure").val().trim().length == 0) {
				error_result = "请正确输入线路起始地！";
			} else if (Tools.CheckInputBox($("#destination")) == 0 ||$("#destination").val().trim().length == 0) {
				error_result = "请正确输入线路目的地！";
			}else if (specialPattern.test($("#departure").val()) || specialPattern.test($("#destination").val()) ) {
				error_result = "不能输入特殊字符！";
			}else if (Tools.CheckInputBox($("#tprice")) == 0) {
				error_result = "请为该条线路设定一个基础票价！";
			} else if($("#departure").val()==$("#destination").val()){
				error_result = "起始地与目的地不能一样！";
			}else {
				if (!Tools.CheckDigit($("#tprice").val()) || $("#tprice").val() < 1 || $("#tprice").val() > 1000) {
					error_result = "线路票价只能为大于0且小于1000的阿拉伯数字！";
				} else {
					$.ajax({
						type : 'POST',
						url : 'Lines/CreateLine?o=' + Math.random(),
						data : {
							departurename : $("#departure").val(),
							destinationname : $("#destination").val(),
							ticketprice : $("#tprice").val()
						},
						dataType : "json",
						success : function(data) {
							alert(data.msg);
							if (data.success) {
								Tools.closeWin(window.location.href);
							}
						}
					});
				}
			}
			$(".second-column span").html(error_result);
		},
		deleteLine : function(lineid) {
			if (confirm("删除线路同时会导致线路下站点、班线同步删除，是否继续？")) {
				$.ajax({
					type : 'POST',
					url : 'Lines/DeleteLine?o=' + Math.random(),
					data : {
						lineId : lineid
					},
					dataType : "json",
					success : function(data) {
						alert(data.msg);
						if (data.success) {
							Tools.closeWin(window.location.href);
						}
					}
				});
			}
		}
	};
	function bindLines() {
		$
				.ajax({
					type : 'post',
					url : 'Lines/GetLines',
					data : {},
					dataType : "json",
					success : function(resultData) {
						var data = resultData.rows;
						$(".data-search .inner .left .name").html("线路（" + data.length + "）");
						var result_str = "<table cellpadding='0' cellspacing='0' width=\"100%\" border=\"0\">";
						for (var i = 0; i < data.length; i++) {
							result_str += "<tr><td class=\"xl-left-td\"><a href=\"javascript:void(0);\" lineid_a='"
									+ data[i]["lineId"]
									+ "' onclick='createWin.deleteLine($(this).attr(\"lineid_a\"));' hidefocus=\"hidefocus\" style='display:"
									+ ((data[i]["frequencytotal"] > 0) ? "none" : "block")
									+ "' title='删除线路'></a></td><td class=\"xl-middle-td\"><table cellpadding='0' cellspacing='0' width=\"100%\" class=\"innerTable\"><tr><td style='width:450px;text-align:left;'><div style='display:inline-block;vertical-align: middle;min-width:30px;height:25px;width:auto;max-width:215px;overflow:hidden;'>" 
									+ (data[i].departurename.length >15? data[i].departurename.substring(0,13)+"<span onmouseover='openTip(\""+data[i].departurename+"\");' onmouseout='closeTip();' style='display:inline-block;vertical-align: middle;color:#aaa;'>‥‥</span>":data[i].departurename)
									+ "</div><div style='display:inline-block;vertical-align: middle;width:10px;text-align:center;'>-</div><div style='display:inline-block;height:25px;vertical-align: middle;min-width:30px;width:auto;max-width:215px;overflow:hidden;'>" 
									+ (data[i].destinationname.length >15? (data[i].destinationname.substring(0,13)+"<span onmouseover='openTip(\""+data[i].destinationname+"\");' onmouseout='closeTip();' style='display:inline-block;vertical-align: middle;color:#aaa;'>‥‥</span>"):data[i].destinationname) + "</div></td><td >班线："
									+ data[i]["classlinetotal"]
									+ "</td><td>站点："
									+ data[i]["sitetotal"]
									+ "</td><td>班次："
									+ data[i]["frequencytotal"]
									+ "</td></tr></table></td><td class=\"right-chakan\"><a href=\"javascript:void(0);\" onclick=\"window.location.href='"
									+ "${basePath}/Lines/ToViaSite?lineId=" + data[i]["lineId"] + "&departure=" + data[i]["departure"]
									+ "&destination=" + data[i]["destination"] + "&departurename=" + data[i]["departurename"] + "&destinationname="
									+ data[i]["destinationname"] + "'\" hidefocus=\"hidefocus\">点击查看</a></td></tr>";
						}
						$(".data-list").html(result_str + "</table>");
					}
				});
	}
	$(function() {
		bindLines();
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
				<div class="data-containers">
					<div class="data-search">
						<div class="inner">
							<div class="left">
								<span class="name"></span>
							</div>
							<div class="right">
								<input type="button" id="addXL" name="addXL" value="添加线路" class="release"
									onclick="kyWin(createWin.addLine(),1000,210,'添加线路', true, true);Tools.supportPlaceholder();" />
							</div>
						</div>
					</div>
					<div class="data-list">
						<table cellpadding='0' cellspacing='0' width="100%" border="0" style="display: none;">
							<tr>
								<td class="xl-left-td"><a href="javascript:void(0);"></a></td>
								<td class="xl-middle-td">
									<table cellpadding='0' cellspacing='0' width="100%" class="innerTable">
										<tr>
											<td>成都—乐山</td>
											<td>站点：6</td>
											<td>班次：15</td>
										</tr>
									</table>
								</td>
								<td class="right-chakan"><a href="javascript:void(0);" onclick="Tools.jump('../Lines/ViaSite');">点击查看</a></td>
							</tr>
							<tr>
								<td class="xl-left-td"><a href="javascript:void(0);"></a></td>
								<td class="xl-middle-td">
									<table cellpadding='0' cellspacing='0' width="100%" class="innerTable">
										<tr>
											<td>成都—绵阳</td>
											<td>站点：6</td>
											<td>班次：15</td>
										</tr>
									</table>
								</td>
								<td class="right-chakan"><a href="javascript:void(0);" onclick="Tools.jump('../Lines/ViaSite');">点击查看</a></td>
							</tr>
							<tr>
								<td class="xl-left-td"><a href="javascript:void(0);"></a></td>
								<td class="xl-middle-td">
									<table cellpadding='0' cellspacing='0' width="100%" class="innerTable">
										<tr>
											<td>成都—彭州</td>
											<td>站点：6</td>
											<td>班次：15</td>
										</tr>
									</table>
								</td>
								<td class="right-chakan"><a href="javascript:void(0);" onclick="Tools.jump('../Lines/ViaSite');">点击查看</a></td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>