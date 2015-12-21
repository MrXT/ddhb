<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="../common/libs.jsp"%>
<base href="${basePath}">
<title>车来车往后台系统管理平台</title>
<style type="text/css">
    .containers{width:100%;height:auto;}
    .containers .top{height:115px;width:100%;}
    .containers .top a{display:inline-block;background:url(resources/images/icons.png) no-repeat;width:590px;height:115px;line-height:102px;text-align:center;color:#FFF;font-size:22px;font-family:宋体;}
    .containers .top a.left{float:left;background-position:-97px -1554px;}
    .containers .top a.right{float:right;background-position:-796px -1705px;}
    
    .data-containers{border-radius:4px;border:1px solid #e0dfd9;}
    .data-containers .data-search,.data-more{width:100%;height:62px;}
    .data-containers .data-search{background:#f6f6f6;}
    .data-containers .data-search .inner{margin:0 auto;width:96%;height:60px;}
    .data-containers .data-search .inner .left,.data-containers .data-search .inner .right{display:inline-block;height:62px;line-height:62px;}
    .data-containers .data-search .inner .left{float:left;}
    .data-containers .data-search .inner .left a{float:left;display:inline-block;width:auto;height:45px;line-height:45px;margin-right:10px;margin-top:10px;font-size:15px;color:#7E7E7E;font-family:宋体;}
    .data-containers .data-search .inner .left a.active{color:#454545;}
    .data-containers .data-search .inner .left .spacing{display:inline-block;background:url(resources/images/icons.png) no-repeat -415px -441px;width:5px;height:43px;float:left;}
    .data-containers .data-search .inner .left input.addData{width:100px;height:42px;background:url(resources/images/icons.png) no-repeat -573px -317px;border:0;color:#fff;font-size:14px;letter-spacing:2px;cursor:pointer;}
    
    .data-containers .info{height:auto;width:100%;background:#fff;border-top:1px solid #e0dfd9;}
    .data-containers .info .first{height:140px;}
    .data-containers .info .first .input-box,.data-containers .info .second .input-box{width:420px;height:50px;margin:0 auto;margin-top:50px;font-size:15px;color:#454545;font-family:宋体;}
    .data-containers .info .first .input-box .title,.data-containers .info .second .input-box .title{height:27px;line-height:27px;width:auto;margin-top:10px;float:left;margin-right:10px;}
    .data-containers .info .first .input-box input,.data-containers .info .second .input-box input{width:300px;height:42px;line-height:42px\9;text-indent:10px;background:url(resources/images/icons.png) no-repeat -97px -1238px;border:0;}
    .data-containers .info .first .button-box,.data-containers .info .second .button-box{width:420px;height:50px;margin:0 auto;margin-top:25px;}
    .data-containers .info .second .button-box{margin-top:145px;}
    .data-containers .info .first .button-box div,.data-containers .info .second .button-box div{margin:0 auto;width:110px;}
    .data-containers .info .first .button-box div input,.data-containers .info .second .button-box div input{width:100px;height:42px;background:url(resources/images/icons.png) no-repeat -573px -317px;border:0;color:#fff;font-size:14px;letter-spacing:2px;cursor:pointer;}
    .data-containers .info .second{height:265px;}
    .data-containers .info .second .input-box div{height:60px;}
    
</style>
<script type="text/javascript">
    var company;
    var createWin = {
        initHtml: function (flag) {
            return (flag == 0 ? "<div class=\"first\"><div class=\"input-box\"><div class=\"title\">公司名称</div><div><input type=\"text\" id=\"company_name\" name=\"company_name\" maxlength='50' /></div></div><div class=\"button-box\"><div><input type=\"button\" id=\"saveInfo\" name=\"saveInfo\" onclick=\"createWin.saveInfo(0,{ companyName: $('#company_name').val(),flag:'0' });\" value=\"保存\" /></div></div></div>" : "<div class=\"second\"><div class=\"input-box\"><div class=\"title\">　旧密码</div><div><input type=\"password\" id=\"old_pwd\" name=\"old_pwd\" maxlength='16' /></div><div class=\"title\">　新密码</div><div><input type=\"password\" id=\"new_pwd\" name=\"new_pwd\" maxlength='16' /></div><div class=\"title\">确认密码</div><div><input type=\"password\" id=\"new_pwd1\" name=\"new_pwd1\" maxlength='16' /></div></div><div class=\"button-box\"><div><input type=\"button\" id=\"savePass\" name=\"savePass\" onclick=\"createWin.saveInfo(1,{ oldPassword: $('#old_pwd').val(),newPassword: $('#new_pwd').val(),newPassword1: $('#new_pwd1').val(),flag:'1' });\" value=\"保存\" /></div></div></div>");
        },
        saveInfo: function (flag, data) {
            if (flag == 0) {
                if (Tools.CheckInputBox($("#company_name")) == 0) {
                    alert("请输入公司名！"); return;
                }
                else if ($("#company_name").val().length < 4 || $("#company_name").val().match(/[^\a-\z\A-\Z0-9\u4E00-\u9FA5]/g)) {
                    alert("请正确填写4~50位由数字、字母、汉字组合的公司名！"); return;
                }
            }
            else {
                if (Tools.CheckInputBox($("#old_pwd")) == 0) { alert("请输入旧密码！"); return; }
                else if (Tools.CheckInputBox($("#new_pwd")) == 0) { alert("请输入新密码！"); return; }
                else if ($("#new_pwd").val().length < 6 || $("#new_pwd").val().match(/[^\a-\z\A-\Z0-9]/g)) { alert("请输入6~16位字母数字的新密码！"); return; }
                else if (Tools.CheckInputBox($("#new_pwd1")) == 0) { alert("请确认新密码！"); return; }
                else if ($("#new_pwd").val() != $("#new_pwd1").val()) { alert("两次密码输入不一致！"); return; }
            }
            $.ajax({
                url: "Management/Update",
                dataType: 'json',
                type: 'POST',
                data: data,
                success: function (data) {
                    alert(data.msg); $("#old_pwd").val("");
                    if (data.success) { Tools.closeWin(window.location.href); }
                }
            });
        }
    };

    $(function () {
        var tabs = $(".data-search .inner .left a");
        $(tabs[0]).click(function () {
            $(this).addClass("active");
            $(tabs[2]).removeClass("active");
            $(".info").html(createWin.initHtml(0));
            $("#company_name").val(company);
        });
        $(tabs[2]).click(function () {
            $(this).addClass("active");
            $(tabs[0]).removeClass("active");
            $(".info").html(createWin.initHtml(1));
        });
        $(".info").html(createWin.initHtml(0));
        company = $("#header .top .left").html();
        $("#company_name").val(company);
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
				    <div class="data-containers">
				        <div class="data-search">
				            <div class="inner">
				                <div class="left">
				                    <a href="javascript:void(0);" class="active">修改公司名</a>
				                    <a class="spacing"></a>
				                    <a href="javascript:void(0);">修改密码</a>
				                </div>
				            </div>
				        </div>
				        <div class="info"></div>
				    </div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>