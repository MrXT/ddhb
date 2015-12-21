<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	border-bottom: 1px solid #e0dfd9;
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
	text-align:left
}

.data-containers .data-search .inner .left span {
	font-size: 18px;
	display: inline-block;
	min-width: 180px;
	font-family: SimSun, Verdana, Geneva, sans-serif;
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

.data-containers .data-search .inner .right input.banxian-add {
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat -746px -317px;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
	margin-top: 10px;
	display: none;
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
	left: -52px\9;
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
	float: left;
	width: 30%;
}

.data-containers .data-list table tr td.edit {
	position: relative;
	float: left;
	left: -2px;
	left: 3px\9;
	border: 0;
	width: 1px;
	border-top: 1px solid #E0DFD9;
}

.data-containers .data-list table tr td.edit a {
	background: url(resources/images/icons.png) no-repeat -144px -632px;
	float: left;
	margin-left: 8px;
	margin-top: 4px;
	display: inline-block;
	width: 50px;
	height: 50px;
	top: 0px;
	position: absolute;
}

.data-containers .data-list table tr td.edit a:hover {
	background-position: -88px -632px;
	background-color: #FDEEDF;
}

.data-containers .setZD {
	background: #fff;
	width: 100%;
	font-size: 14px;
	font-family: 宋体;
	color: #454545;
}

.data-containers .setZD .zhandian-column {
	height:100%;
	width: 95%;
	margin:0 auto;
	line-height: 65px;
	text-align: left;
}

.data-containers .setZD .city-name {
	float: left;
	width: 6%;
	height: 40px;
	line-height: 40px;
	margin: 15px 10px 0 10px;
	text-align: right;
	display: inline-block;
}
.data-containers .setZD .zhandian-box {
	display:inline-block;
}

.data-containers .setZD .zhandian-box input {
	height: 40px;
	line-height: 40px\9;
	width: 65px;
	text-indent: 3px;
	margin-right: 20px;
	background: #FAF9F3;
	border: 1px solid #DCDDDF;
	cursor: pointer;
}
.data-containers .setZD .zhandian-box .addTJ {
	display: inline-block;
	width: 40px;
	height: 40px;
	position: relative;
	top: 17px;
	background: url(resources/images/icons.png) no-repeat -621px -451px;
	cursor: pointer;
}
.data-containers .setZD .zhandian-box .close-icons {
	position: relative;
	left: -30px;
	top: -13px;
	width: 16px;
	height: 16px;
	background: url(resources/images/icons.png) no-repeat -793px -774px;
	cursor: pointer;
	display: inline-block;
}
.data-containers .setZD .zhandian-box .close-icons:HOVER{
	background-position: -725px -774px;
}

.data-containers .setZD .zhandian-box input.setBorder {
	border: 1px solid #FD7100;
}

.data-containers .setZD div a {
	display: inline-block;
	width: 30px;
	height: 30px;
	position: relative;
	top: 12px;
	background: url(resources/images/icons.png) no-repeat -621px -451px;
}

.addClassLine {
	width: 95%;
	height: 205px;
	margin: 15px auto;
	color: #7E7E7E;
}

.addClassLine .name {
	height: 25px;
	line-height: 25px;
	margin-top: 10px;
	width: 60px;
	display: inline-block;
	float: left;
}

.addClassLine .first-column{
	height: 60px;
	width: 100%;
}
 .addClassLine .second-column {
	height: 90px;
	width: 100%;
	overflow-y:auto;
	margin-bottom: 10px;
}

.addClassLine .first-column input, .addClassLine .second-column input {
	width: 300px;
	height: 42px;
	line-height: 42px\9;
	text-indent: 6px;
	background: url(resources/images/icons.png) no-repeat -97px -1236px;
	border: 0;
}

.addClassLine .second-column .zdSelect {
	float:left;
	width: 800px;
	height: 100%;	
}

.addClassLine .second-column .zdSelect .zhandian-columns {
	width: 88px;
	float: left;
}

.addClassLine .second-column .zdSelect .zhandian-columns a {
	width: 69px;
	height: 42px;
	line-height: 42px;
	display: inline-block;
	float: left;
	background: url(resources/images/icons.png) no-repeat -186px -1390px;
	margin-right: 0px;
	text-indent: 5px;
	color: #000;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap;
}

.addClassLine .second-column .zdSelect .zhandian-columns a:hover {
	background-position: -99px -1390px;
}

.addClassLine .second-column .zdSelect .zhandian-columns a.select {
	background-position: -99px -1390px;
}

.addClassLine .second-column .zdSelect .zhandian-columns span.close-icons
	{
	float: left;
	position: relative;
	left: -10px;
	display: inline-block;
	width: 16px;
	height: 16px;
	background: url(resources/images/icons.png) no-repeat -793px -774px;
	cursor: pointer;
}

.addClassLine .second-column .zdSelect .zhandian-columns span.close-icons:hover
	{
	background-position: -725px -774px;
}

.addClassLine .second-column .zdSelect span.addTJ {
	display: inline-block;
	width: 30px;
	height: 30px;
	position: relative;
	top: 5px;
	background: url(resources/images/icons.png) no-repeat -621px -451px;
	cursor: pointer;
}

.addClassLine .zdList {
	border: 1px solid #DCDDDF;
	width: 91%;
	height: 100px;
	margin: 0 auto;
	padding: 10px;
	background-color: #FAF9F3;
	color: #000;
	position: relative;
	left: 24px;
}

.addClassLine .zdList .start, .addClassLine .zdList .end {
	height: 100%;
	line-height: 35px;
	width: 100%;
	overflow-y: auto;
}

.addClassLine .zdList .zd-title {
	width: auto;
	height: 35px;
	float: left;
	display: inline;
}

.addClassLine .zdList a {
	width: auto;
	float: left;
	display: inline-block;
	height: 30px;
	line-height: 30px;
	position: relative;
	top: 2px;
	margin-right: 10px;
	padding: 0 6px 0 6px;
	color: #000;
}

.addClassLine .zdList a:hover {
	background: #FD7100;
	color: #FFF;
}

.addClassLine .third-column {
	width: 100%;
	height: 45px;
	text-align: right;
	position: relative;
	top: 20px;
}

.addClassLine .third-column input {
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat -573px -317px;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
}

.addClassLine .third-column span {
	margin-right: 15px;
	color: #FD7100;
}
</style>
<script type="text/javascript">
	var lineId, lineName, departure, destination;
	$(function() {
		lineId = $("#line_id").val();
		departure = $("#line_startcode").val();
		destination = $("#line_endcode").val();
		lineName = $("#line_name").val();
		$("#startAdd").bind("click", function() {
			$(this).append('<input type="text" id="start11" name="start11" />');
		});
		$("#saveZD").bind(
				"click",
				function() {
					var start = $(".data-containers .setZD div#start input");
					var end = $(".data-containers .setZD div#end input");
					var startPoint = "", endPoint = "";
					var starts = "", ends = "";
					for (var i = 0; i < start.length; i++) {
						if ($(start[i]).val() != "" || $(start[i]).val() == "" && $(start[i]).attr("tag") != "") {
							startPoint += $(start[i]).val() + "*" + $(start[i]).attr("tag") + ","
							if (starts == "") {
								starts = $(start[i]).val();
							}
						}
					}
					for (var i = 0; i < end.length; i++) {
						if ($(end[i]).val() != "" || $(end[i]).val() == "" && $(end[i]).attr("tag") != "") {
							endPoint += $(end[i]).val() + "*" + $(end[i]).attr("tag") + ","
							if (ends == "") {
								ends = $(end[i]).val();
							}
						}
					}
					/* if (startPoint.length == 0 || starts == "") {
						alert("至少给" + $("#line_start").val() + "设置一个途径站点哦！");
						$(start[0]).focus();
						return true;
					} else if (endPoint.length == 0 || ends == "") {
						alert("至少给" + $("#line_end").val() + "设置一个途径站点哦！");
						$(end[0]).focus();
						return true;
					} */
					$.ajax({
						type : 'post',
						url : '/Lines/CreateViaSite',
						data : {
							LINE_ID : $("#line_id").val(),
							LINE_NAME : $("#line_name").val(),
							LINES : startPoint.substr(0, startPoint.length - 1) + "|" + $("#line_startcode").val() + "$"
									+ endPoint.substr(0, endPoint.length - 1) + "|" + $("#line_endcode").val(),
							ISNEW : (($("#ssite").val() != "" && $("#esite").val() != "") ? false : true)
						},
						dataType : "json",
						success : function(data) {
							alert(data.Content);
							if (data.isSuccess) {
								Tools.closeWin(window.location.href);
							}
						}
					});
				});
		if ($("#ssite").val() != "" || $("#esite").val() != "") {
			var _start = $("#ssite").val().split("||")[0].split("|");
			var _end = $("#esite").val().split("||")[0].split("|");
			if(_start.length == 1 && _start[0] ==''){
				_start =[];
			}
			for (var i = 0; i < _end.length; i++) {
				_start.push( _end[i]);
			}
			for (var i = 0; i < _start.length; i++) {
				createInputBox(i, $("#end"), "text", _start[i].split(",")[0]);
				$("#end" + i).val(_start[i].split(",")[1]);
			}
		} else {
			createInputBox(0, $("#end"), "text", "");
		}
		$("#addBX").show();
		var html = "<span title='点击增加站点' class='addTJ' onclick='addSite();'></span>";
		$(html).appendTo($("#end"));
		$(".data-containers .setZD div input").bind("focus", function() {
			$(this).addClass("setBorder");
		}).bind("blur", function() {
			$(this).removeClass("setBorder");
		});
		createWin.searchClassLine();
		//zhandianList = Tools.initLinkeList();
	});

	function createInputBox(id, obj, type, tag) {
		var elements;
		if (type == "text") {
			elements = "<input type='text' id='" + obj.attr("id") + id + "' name='" + obj.attr("id") + id + "' tag='" + tag
					+ "' onmouseout='checkValue(this);' onblur='checkValue(this);'  title='点击设置途径站'><span class='close-icons' title='移除' onclick='removeSite(this);' ></span>";
		} else {
			elements = "<a id='" + id + "Add' name='" + id + "Add' href=\"javascript:void(0);\" style=\"display:none;\"></a>";
		}
		$(elements).appendTo(obj);
	}

	function setSite(tag) {
		kyWin(createWin.setSite(tag), 400, (tag == 0 ? 260 : 320), '设置途径站', true, true);
	}

	var error_result, zhandianList, tu_jing = 2;
	var createWin = {
		setSite : function(id) {
			return "<div class='addClassLine' style='height:"
					+ (id == 0 ? "180px" : "202px")
					+ ";'><div class='first-column'><div class='name'>途径站点：</div><input type='text' id='site_mc' name='site_mc' placeholder='例如“红牌楼”' /></div>"
					+ (id == 0 ? ""
							: "<div class='first-column'><div class='name'>站点价格：</div><input type='text' id='site_price' name='site_price' placeholder='0.00' style='width:285px;border:1px solid #DCDDDF;border-radius:3px;background-image:none;background-color:#FAF9F3;' /><span id='site_price_unit' name='site_price_unit' style='margin-left:5px;color:#DE5438;'>元</span></div>")
					+ "<div class='second-column'><div class='name'>是否接送：</div><input type='checkbox' id='is_jiesong' name='is_jiesong' style='float:left;width:20px;height:20px;display:block;position:relative;top:12px;' onclick=\"if($(this).attr('checked')=='checked'){$('#jiesong_price').show();$('#jiesong_price_unit').show();}else{$('#jiesong_price').val('');$('#jiesong_price').hide();$('#jiesong_price_unit').hide();}\" /><input type='text' id='jiesong_price' name='jiesong_price' placeholder='0.00' style='width:255px;border:1px solid #DCDDDF;border-radius:3px;background-image:none;background-color:#FAF9F3;margin-left:10px;display:none;' /><span id='jiesong_price_unit' name='jiesong_price_unit' style='display:none;margin-left:5px;color:#DE5438;'>元</span></div><div class='third-column'><span></span><input type='button' id='setTuJingZhan' name='setTuJingZhan' value='保存' flag='0' onclick='createWin.setTuJingZhan(($(\"#is_jiesong\").attr(\"checked\")==\"checked\"?true:false),"
					+ id + ");' hidefocus=\"hidefocus\" /></div></div>";
		},
		setTuJingZhan : function(isjiesong, id) {
			var error_result = "";
			error_result = "";
			if (Tools.CheckInputBox($("#site_mc")) == 0) {
				error_result = "请输入途径站点名！";
			} else if (id != 0 && Tools.CheckInputBox($("#site_price")) == 0) {
				error_result = "请设置站点价格！";
			} else if (isjiesong && Tools.CheckInputBox($("#jiesong_price")) == 0) {
				error_result = "请设置接送价格！";
			} else {
				alert("线路ID：" + $("#line_id").val() + "\n线路名称：" + $("#line_name").val() + "\n线路起始ID：" + $("#line_startcode").val() + "\n线路终点ID："
						+ $("#line_endcode").val() + "\n途径站名：" + $("#site_mc").val() + "\n途径站名价格：" + $("#site_price").val() + "\n是否接送：" + isjiesong
						+ "\n接送费用：" + $("#jiesong_price").val());
			}
			$(".third-column span").html(error_result);
			return;
			$.ajax({
				type : 'post',
				url : '/Lines/CreateViaSite',
				data : {
					LINE_ID : $("#line_id").val(),
					LINE_NAME : $("#line_name").val(),
					LINES : startPoint.substr(0, startPoint.length - 1) + "|" + $("#line_startcode").val() + "$"
							+ endPoint.substr(0, endPoint.length - 1) + "|" + $("#line_endcode").val(),
					ISNEW : (($("#ssite").val() != "" && $("#esite").val() != "") ? false : true)
				},
				dataType : "json",
				success : function(data) {
					alert(data.Content);
					if (data.isSuccess) {
						Tools.closeWin(window.location.href);
					}
				}
			});
		},
		addClassLine : function() {
			setTimeout(function() {
				if($("#ssite").val() !=''){
					createWin.initZhanDian($("#ssite"), "start");
				}
				if($("#esite").val() !=''){
					createWin.initZhanDian($("#esite"), "start");
				}
				
			}, 200);
			return "<div class='addClassLine'><div class='first-column'><div class='name'>班线名：</div><input type='text' id='clname' name='clname' placeholder='例如“成乐1号线”' /></div><div class='second-column'><div class='name'>　途径：</div><div class='zdSelect'><div id='zdian' name='zdian'></div><span title='点击增加站点' class='addTJ' onclick='createWin.createTuJing()'></span></div></div><div class='zdList'><div class='start'><div class='zd-title'></div></div><div class='end' style='display:none;'><div class='zd-title'></div></div></div><div class='third-column'><span></span><input type='button' id='saveClassLine' name='saveClassLine' value='保存' flag='0' onclick='createWin.saveClassLine($(this).attr(\"flag\"));' hidefocus=\"hidefocus\" /></div></div>";
		},
		initTuJing : function(content) {
			if (content == 0) {
				for (var i = 0; i < 1; i++) {
					$(
							"<div class='zhandian-columns'><a href=\"javascript:void(0);\" id='tj_" + i
									+ "' hidefocus=\"hidefocus\"></a><span class='close-icons' title='移除' style='display:none;'></span></div>")
							.appendTo($("#zdian"));
				}
			} else {
				for (var i = 0; i < content.length; i++) {
					if (content[i].split("&")[0] == "") {
						continue;
					}
					$(
							"<div class='zhandian-columns'><a href=\"javascript:void(0);\" id='tj_" + i + "' siteNumber=" + content[i].split("&")[0]
									+ " title='" + content[i].split("&")[1] + "' hidefocus=\"hidefocus\">" + content[i].split("&")[1]
									+ "</a><span class='close-icons' title='移除' style='display:none;'></span></div>").appendTo($("#zdian"));
				}
			}
			var tujing_a = $(".zdSelect a");
			tujing_a.bind("click", function() {
				createWin.bindTuJingEvent($(this).attr("id"));
			});

			createWin.bindTuJingEvent("tj_0");
		},
		initZhanDian : function(obj, to) {
			var starts_site = obj.val().split("||")[0].split("|");
			for (var i = 0; i < starts_site.length; i++) {
				var number = starts_site[i].split(",")[4];
				var name = starts_site[i].split(",")[1];
				$("<a href=\"javascript:void(0);\" number=" + number + " hidefocus=\"hidefocus\">" + name + "</a>").bind("click", function() {
					createWin.addZhanDian($(this).html(), $(this).attr("number"));
				}).appendTo($('.zdList .' + to + ''));
			}
		},
		createTuJing : function() {
			var tujing_a = $(".zdSelect a");
			var id = $(".zdSelect a:last").attr("id");
			//id = id.substr(id.length - 1, 1);
			if(id == undefined){
				id = 0;
			}else{
				id = id.split("_")[1];
			}
				$html = $("<div class='zhandian-columns'><a href=\"javascript:void(0);\" id='tj_" + (parseInt(id) + 1)
						+ "' hidefocus=\"hidefocus\"></a><span class='close-icons' title='移除' style='display:none;'></span></div>");
				$html.bind("click", function(event) {
					createWin.bindTuJingEvent($(event.target).attr("id"));
				})
				$html.appendTo($("#zdian"));
				createWin.bindTuJingEvent("tj_" + (parseInt(id) + 1));
		},
		bindTuJingEvent : function(id) {
			var tujing_zd_columns = $(".zdSelect .zhandian-columns");
			for (var i = 0; i < tujing_zd_columns.length; i++) {
				var tujing_a = $(tujing_zd_columns[i]).children("a");
				var tujing_closer_element = $(tujing_zd_columns[i]).children("span.close-icons");
				if (tujing_a.attr("id") == id) {
					$("#" + id).addClass("select");
					$("#tujing_record").val(id);
				} else {
					tujing_a.removeClass("select");
				}

				tujing_closer_element.bind("click", function() {
					$(this).parent().remove();
					createWin.hideOrshow($(".zdSelect .zhandian-columns"));
				});
			}
			createWin.hideOrshow($(".zdSelect .zhandian-columns"));
		},
		hideOrshow : function(obj) {
			var tujing_closer = obj.children("span.close-icons");
			for (var j = 0; j < tujing_closer.length; j++) {
				$(tujing_closer[j]).show();
				/* if (tujing_closer.length > 1) {
					$(tujing_closer[j]).show();
				} else {
					$(tujing_closer[j]).hide();
				} */
			}
		},
		addZhanDian : function(txt, number) {
			var record = $("#" + $("#tujing_record").val());
			var zdian = $("#zdian a");
			for (var i = 0; i < zdian.length; i++) {
				if ($(zdian[i]).attr("siteNumber") == number) {
					alert("不能重复添加相同站点！");
					return;
				}
			}
			record.html(txt);
			record.attr("title", txt);
			record.attr("siteNumber", number);
		},
		searchClassLine : function() {
			$.ajax({
				type : 'post',
				url : 'Lines/SearchClassLine',
				data : {
					lineId : $("#line_id").val()
				},
				dataType : "json",
				success : function(resultData) {
					var data = resultData.rows;
					$(".data-search .inner .left #classLine").html("班线（" + data.length + "）");
					var result_str = "<table cellpadding='0' cellspacing='0' width=\"100%\" border=\"0\">";
					for (var i = 0; i < data.length; i++) {
						var siteName = data[i]["siteName"];
						var lastStr = siteName.substr(siteName.length - 2, siteName.length);
						if (lastStr.replace(/[ ]/g, "") == "—") {
							siteName = siteName.substr(0, siteName.length - 2);
						}
						result_str += "<tr><td class=\"xl-left-td\"><a href=\"javascript:void(0);\" classid='" + data[i]["classlineId"]
								+ "' onclick=\"createWin.delClassLine($(this).attr('classid'));\" hidefocus=\"hidefocus\"style='display:"
								+ ((data[i]["frequencytotal"] > 0) ? "none" : "inline-block")
								+ "' title='删除班线'></a></td><td style='width:10%;color:#000;font-weight:bold;text-align:left;padding-left:20px;' id='cline_" + data[i]["classlineId"]
								+ "'>" + data[i]["classlineName"]
								+ "</td><td id='sn_" + data[i]["classlineId"] + "' style='text-align:left;' classline=" + data[i]["siteName1"] + ">"
								+$("#line_start").val()+"-"+ siteName +"-"+$("#line_end").val()+ "</td><td class=\"edit\"><a href=\"javascript:void(0);\" onclick=\"createWin.editClassLine($('#sn_"
								+ data[i]["classlineId"] + "'),$('#cline_" + data[i]["classlineId"]
								+ "').html());\" hidefocus=\"hidefocus\" title='班线编辑' style='display:"+((data[i]["frequencytotal"] > 0)?"none":"display")+"'></a></td></tr>"; //$(\"#sn_" + data[i]["CLASSLINE_ID"] + "\");
					}
					$(".data-list").html(result_str + "</table>");
				}
			});
		},
		editClassLine : function(classLine, classLineName) {
			kyWin(createWin.addClassLine(), 1000, 420, '编辑班线', true, true);
			$("#saveClassLine").attr("flag", classLine.attr("id").split("_")[1]);
			$('#clname').val(classLineName);
			/* $('.zdList .start .zd-title').text($('#line_start').val() + '站点：');
			$('.zdList .end .zd-title').text($('#line_end').val() + '站点：'); */
			var _classLine = classLine.attr('classline').split("%");
			createWin.initTuJing(_classLine);
		},
		saveClassLine : function(flag) {
			error_result = "";
			var zhandian_select = $("#zdian a");
			var zhandian_result = "";
			var j = 0;
			for (var i = 0; i < zhandian_select.length; i++) {
				if ($(zhandian_select[i]).html() != "") {
					j++;
					zhandian_result += $(zhandian_select[i]).attr("siteNumber") + ",";
				}
			}
			//if (j >= 2) {
			if (true) {
				var startAs = $(".start a");
				var endAs = $(".end a");
				var isStartPass = false;
				var isEndPass = false;
				var isFirstStartPass = false;
				$.each(startAs, function(i, startA) {
					$.each($("#zdian .zhandian-columns a"), function(j, selectA) {
						if ($(selectA).attr('sitenumber') == $(startA).attr('number')) {
							isStartPass = true;
						}
					});
					if ($($("#zdian .zhandian-columns a")[0]).attr('sitenumber') == $(startA).attr('number')) {
						isFirstStartPass = true;
					}
				});
				$.each(endAs, function(i, endA) {
					$.each($("#zdian .zhandian-columns a"), function(j, selectA) {
						if ($(selectA).attr('sitenumber') == $(endA).attr('number')) {
							isEndPass = true;
						}
					});
				});
				//if (isStartPass && isEndPass && isFirstStartPass) {
				if (true) {
					var pattern = new RegExp("[`~!@#$^&*()=|{}':;'\"\",\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]"); 
					if (Tools.CheckInputBox($("#clname")) == 0 || $("#clname").val().trim().length == 0) {
						error_result = "请正确输入班线名！";
					}else if (pattern.test($("#clname").val()) ) {
						error_result = "不能输入特殊字符！";
					}
					/* else if (zhandian_result == "") {
						error_result = "请为该班线选择途径站点！";
					} */
					else {
						$.ajax({
							type : 'POST',
							url : 'Lines/AddClassLine?o=' + Math.random(),
							data : {
								classlineName : $("#clname").val(),
								siteList : zhandian_result.substr(0, zhandian_result.length - 1),
								lineId : $("#line_id").val(),
								classlineId : flag
							},
							dataType : "json",
							success : function(data) {
								alert(data.msg);
								if (data.success) {
									window.location.href = window.location.href;
								}
							}
						});
					}
				} else {
					error_result = "请至少选择两个站点！其中第一个为始发站城市的站点，另一个为终点站城市的站点！";
				}
			} else {
				error_result = "请至少选择两个站点！";
			}
			$(".third-column span").html(error_result);
		},
		delClassLine : function(classlineid) {
			if (confirm("您正在执行删除班线操作，是否继续？")) {
				$.ajax({
					type : 'POST',
					url : 'Lines/DeleteClassLine?o=' + Math.random(),
					data : {
						classlineId : classlineid
					},
					dataType : "json",
					success : function(data) {
						alert(data.msg);
						if (data.success) {
							window.location.href = window.location.href;
						}
					}
				});
			}
		}
	};
	function saveSite() {
		var startInputs = $("#start").find("input[type='text']");
		var endInputs = $("#end").find("input[type='text']");
		/* if ($(startInputs[0]).val() == '' || $(endInputs[0]).val() == '') {
			alert("请确保开始于终点与起点第一个输入框不为空！");
			window.location.href = window.location.href;
			return;
		} */
		var param = "lineId=" + lineId + "&lineName=" + lineName + "&departure=" + departure + "&";
		$.each(startInputs, function(i, startInput) {
			if ($(startInput).val() != '') {
				param += "ssiteNames=" + $(startInput).val() + "&";
			}
		});
		param += "destination=" + destination + "&";
		$.each(endInputs, function(i, endInput) {
			if ($(endInput).val() != '') {
				param += "esiteNames=" + $(endInput).val() + "&";
			}
		});
		$.ajax({
			type : 'POST',
			url : 'Lines/UpdateLineSites',
			data : param.substring(0, param.length - 1),
			dataType : "json",
			success : function(data) {
				alert(data.msg);
				window.location.href = window.location.href;
			}
		});
	}
	function checkValue(ob) {
		var inputs = $(ob).parent().parent().parent().find("input[type='text']");
		var pass = true;
		$.each(inputs, function(i, input) {
			if (ob != input && $(input).val() != '' && ob.value == $(input).val() || ob.value == $("#line_start").val() || ob.value==$("#line_end").val()) {
				pass = false;
			}
		});
		if (!pass) {
			$(ob).val("");
			alert("站点名不能一样！");
		}
	}
	function addSite() {
		if($("#end").children().length > 0){
			$("#end .addTJ").remove();
		}
		var html = "<input type='text' onmouseout='checkValue(this);' onblur='checkValue(this);' title='点击设置途径站'><span class='close-icons' title='移除' onclick='removeSite(this);'></span><span title='点击增加站点' class='addTJ' onclick='addSite();'>"
		$(html).appendTo($("#end"));
	}
	function removeSite(element){
		$(element.previousElementSibling).remove();
		$(element).remove();
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
				<input type="hidden" id="line_id" name="line_id" value="${line.lineId}" /> <input type="hidden" id="line_start"
					name="line_start" value="${line.departurename}" /> <input type="hidden" id="line_end" name="line_end"
					value="${line.destinationname}" /> <input type="hidden" id="line_name" name="line_name"
					value="${fn:substring(line.departurename, 0, 1)}${fn:substring(line.destinationname, 0, 1)}" /> <input
					type="hidden" id="line_startcode" name="line_startcode" value="${line.departure}" /> <input type="hidden"
					id="line_endcode" name="line_endcode" value="${line.destination}" /> <input type="hidden" id="tujing_record"
					name="tujing_record" value="tj_0" /> <input type="hidden" id="ssite" name="ssite" value="${line.ssite}" /> <input
					type="hidden" id="esite" name="esite" value="${line.esite}" />
				<div class="data-containers">
					<div class="data-search">
						<div class="inner">
							<div class="left">
								<span class="name">线路>&nbsp;${line.departurename}—${line.destinationname}</span> <span class="name">途径站点</span>
							</div>
							<div class="right">
								<input type="button" id="saveZD" name="saveZD" value="保存" onclick="saveSite();" class="release"
									hidefocus="hidefocus" />
							</div>
						</div>
					</div>
					<div class="setZD">
						<div class="zhandian-column">
							<div class="zhandian-box" id="start" style="display: none;"></div>
							<div class="zhandian-box" id="end"></div>
						</div>
					</div>
				</div>
				<div class="data-containers" style="margin-top: 10px;">
					<div class="data-search">
						<div class="inner">
							<div class="left">
								<span class="name" id="classLine" style="text-align:left;"></span>
							</div>
							<div class="right">
								<input type="button" id="addBX" name="addBX" value="添加班线" class="banxian-add"
									onclick="kyWin(createWin.addClassLine(),1000,420,'添加班线', true, true);$('#clname').attr('placeholder','例如：“'+$('#line_name').val()+'1号线”');Tools.supportPlaceholder();$('#saveClassLine').attr('flag', 0);createWin.initTuJing(0);"
									hidefocus="hidefocus" />
							</div>
						</div>
					</div>
					<div class="data-list"></div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>