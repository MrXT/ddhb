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

.data-containers .data-search .inner .right, .release-frequency .inputs-containers .right,
	.edit-frequency .inputs-containers .right {
	float: right;
}

.data-containers .data-search .inner .right input.release,
	.release-frequency .inputs-containers .right input.release,
	.edit-frequency .inputs-containers .right input.release {
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

.data-containers .info {
	height: auto;
	width: 100%;
	background: #fff;
}

.data-containers .info table, .data-containers .info table.innerTable,
	.data-containers .info table.innerTable tr {
	border: 0;
}

.data-containers .info table.innerTable tr td a {
	background: url(resources/images/icons.png) no-repeat;
	display: inline-block;
	width: 50px;
	height: 50px;
	margin-top: 5px;
}

.data-containers .info table.innerTable tr td a.edit {
	background-position: -134px -630px;
}

.data-containers .info table.innerTable tr td a.edit:hover {
	background-position: -78px -632px;
}

.data-containers .info table.innerTable tr td a.delete {
	background-position: -201px -685px;
}

.data-containers .info table.innerTable tr td a.delete:hover {
	background-position: -137px -687px;
}

.data-containers .info table tr {
	height: 60px;
	text-align: center;
	border-top: 1px solid #E0DFD9;
}

.data-containers .info table tr td {
	font-size: 14px;
	color: #454545;
	font-family: 宋体;
}

.data-containers .info table tr .xl-middle-td {
	position: relative;
	float: left;
	width: 50%;
}

.width {
	width: 200px;
	text-align: left;
}

.create-account {
	width: 98%;
	height: 110px;
	margin: 25px auto;
}

.create-account .first-column {
	height: 76px;
	width: 100%;
}

.create-account .first-column input {
	width: 300px;
	height: 42px;
	line-height: 42px\9;
	margin-left: 19px;
	text-indent: 6px;
	background: url(resources/images/icons.png) no-repeat -97px -1236px;
	border: 0;
}

.create-account .first-column input.typing {
	background-position: -97px -1236px;
	cursor: text;
}

.create-account .second-column {
	height: 45px;
	width: 97.8%;
	text-align: right;
}

.create-account .second-column input {
	width: 100px;
	height: 42px;
	background: url(resources/images/icons.png) no-repeat -573px -317px;
	border: 0;
	color: #fff;
	font-size: 14px;
	letter-spacing: 2px;
	cursor: pointer;
}

.create-account .second-column span {
	margin-right: 15px;
	color: #FD7100;
}

.selectContainer {
	position: relative;
	margin-left: 19px;
	top: -1px;
	width: 300px;
	height: 42px;
	display: inline-block;
	_display: inline;
	_zoom: 1;
	z-index: 1000;
	background: url(resources/images/icons.png) no-repeat -97px -1307px;
	border: 0;
	cursor: pointer;
}

.selectContainer .selectOption {
	min-width: 180px;
	padding: 0 5px;
	line-height: 40px;
	height: 40px;
	white-space: nowrap;
	overflow: hidden;
	border: none;
	width: 290px;
	z-index: 1000;
}

.selectContainer .shows {
	width: 20px;
	height: 20px;
	position: absolute;
	right: 2px;
	top: 2px;
	background: url(resources/images/select-ico.gif) no-repeat center center;
}

.selectContainer ul {
	position: absolute;
	width: 290px;
	top: 42px;
	left: 0px;
	display: none;
	height: 92px;
	overflow: auto;
}

.selectContainer ul li {
	padding: 0 5px;
	border: 1px solid #CCC;
	border-top: none;
	height: 35px;
	line-height: 35px;
	width: 250px;
	background: #FFF;
	cursor: pointer;
}

.selectContainer ul li:hover {
	background: #D2E9FF;
}

.selectContainer ul.dis {
	display: block !important;
}

.selectContainer ul.undis {
	display: none !important;
}

.zIndex {
	z-index: 10000 !important;
}

.selectContainer .gray {
	color: #DDD;
}

.selectContainer .black {
	color: #000;
}
</style>
<script type="text/javascript">
	var error_result, userId = null;
	var createWin = {
		initAccount : function() {
			$
					.ajax({
						type : 'POST',
						url : 'Management/SearchAccount?o=' + Math.random(),
						data : {},
						dataType : "json",
						success : function(resultData) {
							var data = resultData.data;
							var result_str = "<table cellpadding='0' cellspacing='0' width=\"100%\" border=\"0\">";
							$(".data-search .inner .left .number").html("(" + data.length + ")");
							for (var i = 0; i < data.length; i++) {
								result_str += "<tr><td style='width:28px;'></td><td class=\"xl-middle-td\"><table cellpadding='0' cellspacing='0' width=\"100%\" class=\"innerTable\"><tr><td class='width'>"
										+ (i + 1)
										+ "."
										+ data[i]["roleName"]
										+ "</td><td class='width'>帐号："
										+ data[i]["userName"]
										+ "</td></tr></table></td><td align=\"right\"><table cellpadding='0' cellspacing='0' width=\"32%\" class=\"innerTable\"><tr><td><a id='edit_"
										+ data[i]["userId"]
										+ "' href=\"javascript:void(0);\" onclick=\"kyWin(createWin.createAccount(1,'"
										+ data[i]["roleName"]
										+ ","
										+ data[i]["userName"]
										+ ","
										+ data[i]["userPassword"]
										+ ","
										+ data[i]["userId"]
										+ ","
										+ data[i]["roleId"]
										+ "'),1000,210,'修改', true, true);\" class=\"edit\" title='编辑'></a></td><td><a id='delete_"
										+ data[i]["userId"]
										+ "' href=\"javascript:void(0);\" onclick=\"createWin.deleteAccount($(this).attr('id').split('_')[1]);\" class=\"delete\" title='删除'></a></td></tr></table></td></tr>";
							}
							$(".info").html(result_str + "</table>");
						}
					});
		},
		createAccount : function(flag, values) {
			jQuery.fn.select = function(options) {
				return this.each(function() {
					var $this = $(this);
					var $shows = $this.find(".shows");
					var $selectOption = $this.find(".selectOption");
					var $el = $this.find("ul > li");

					$this.click(function(e) {
						$(this).toggleClass("zIndex");
						$(this).children("ul").toggleClass("dis");
						e.stopPropagation();
					});
					$el.bind("click", function() {
						var $this_ = $(this);
						$this.find("span").removeClass("gray");
						$this_.parent().parent().find(".selectOption").text($this_.text());
						$this_.parent().parent().find(".selectOption").attr("rid", $this_.attr("id"));
					});
					$("body").bind("click", function() {
						$this.removeClass("zIndex");
						$this.find("ul").removeClass("dis");
					});
				});
			}
			setTimeout(function() {
				$(".selectContainer").select();
			}, 500);
			var selectMenu = "";
			$.ajax({
				async : false,
				type : 'POST',
				url : 'Management/SearchRole',
				data : {},
				dataType : "json",
				success : function(resultData) {
					$.each(resultData.rows, function(i, row) {
						selectMenu += "<li id='"+row.roleId+"'>" + row.roleName + "</li>";
					});
				}
			});
			return "<div class='create-account'><div class='first-column'><div class=\"selectContainer zIndex\"><span class=\"selectOption "
					+ (flag == 0 ? 'gray' : 'black')
					+ "\" rid='"
					+ (flag == 0 ? 0 : values.split(",")[4])
					+ "'>"
					+ (flag == 0 ? "选择类型" : values.split(",")[0])
					+ "</span><ul class=\"selectMenu\">"
					+ selectMenu
					+ "</ul><span class=\"shows\"></span></div><input type='hidden' id='u_id' value='"
					+ (flag == 0 ? "" : values.split(",")[3])
					+ "'><input type='text' id='account' name='account' value='"
					+ (flag == 0 ? "" : values.split(",")[1])
					+ "' placeholder='帐号名' class='typing' maxlength='16' "
					+ (flag == 0 ? "onblur='validUsername(this.value)'" : "")
					+ " /><input type='password' id='account_code' name='account_code' value='"
					+ (flag == 0 ? "" : values.split(",")[2])
					+ "' placeholder='密码' class='typing' style='cursor:text;' maxlength='16' /></div><div class='second-column'><span></span><input type='button' id='saveLine' name='saveLine' value='保存' onclick=\"createWin.saveAccount('"
					+ (flag == 0 ? "0" : values.split(",")[3]) + "');\" /></div></div>";
		},
		saveAccount : function(flag) {
			if ($(".selectOption").text() == "选择类型") {
				error_result = "请选择角色！";
			} else if (Tools.CheckInputBox($("#account")) == 0) {
				error_result = "请正确填写帐号！";
			} else if (Tools.CheckInputBox($("#account_code")) == 0) {
				error_result = "请正确为该帐号设置一个初始密码！";
			} else {
				if ($("#account").val().length < 4 || $("#account").val().length > 16) {
					error_result = "用户名长度必须在4~16位字符！";
				} else if ($("#account_code").val().length < 6 || $("#account_code").val().length > 16) {
					error_result = "密码长度为6~16位！";
				}else if ( specialPatternHaveSpace.test($("#account").val())||  specialPatternHaveSpace.test($("#account_code").val())) {
					error_result = "不能输入特殊字符(包含空格)！";
				} else {
					$.ajax({
						type : 'POST',
						url : 'Management/CreateAccount?o=' + Math.random(),
						data : {
							userName : $("#account").val(),
							userId : $("#u_id").val(),
							userPassword : $("#account_code").val(),
							roleId : $(".selectOption").attr("rid"),
							flag : flag
						},
						dataType : "json",
						success : function(resultData) {
							if (resultData.data == 1) {
								alert(resultData.msg);
							}
							if (resultData.success) {
								Tools.closeWin(window.location.href);
							}
						}
					});
				}
			}
			$(".second-column span").html(error_result);
		},
		deleteAccount : function(userid) {
			if (confirm("您正在执行删除用户操作，是否继续？")) {
				$.ajax({
					type : 'POST',
					url : 'Management/DeleteAccount?o=' + Math.random(),
					data : {
						userId : userid
					},
					dataType : "json",
					success : function(resultData) {
						if (resultData.data == 1) {
							alert(resultData.msg);
						}
						if (resultData.success) {
							Tools.closeWin(window.location.href);
						}
					}
				});
			}
		}
	}
	$(function() {
		createWin.initAccount();
	});
	function validUsername(username) {
		if (username.trim().length == 0) {
			return;
		}
		$.ajax({
			type : 'POST',
			url : 'Management/ValidUserName',
			data : {
				"userName" : username
			},
			dataType : "json",
			success : function(resultData) {
				if (!resultData.success) {
					alert(resultData.msg);
					$("#account").val("");
				}
			}
		});
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
								<span class="name">帐号管理</span> <span class="number"></span> <span class="select"> <select id="roleSel"
									name="roleSel"><option>全部</option></select>
								</span>
							</div>
							<div class="right">
								<input type="button" id="createAccount" name="createAccount" value="创建帐号" class="release"
									onclick="kyWin(createWin.createAccount(0,0),1000,210,'创建帐号', true, true);Tools.supportPlaceholder();" />
							</div>
						</div>
					</div>
					<div class="info"></div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>