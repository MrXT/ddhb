var regUT = false;
var _data;
var pwdField, pwdVal, pwdPlaceholder;
$(document).ready(function () {
    $("#account").focus(function () {
        $(this).addClass("active");
    });
    $("#account").focusout(function () {
        if ($(this).val().replace(/(^\s*)|(\s*$)/, "") == '') {
            $(this).val('');
            $(this).removeClass("active");
        }
    });

    $("#password").focus(function () {
        $(this).addClass("active");
    });
    $("#password").focusout(function () {
        if ($(this).val().replace(/(^\s*)|(\s*$)/, "") == '') {
            $(this).val('');
            $(this).removeClass("active");
        }
    });

    document.onkeydown = function (event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) {
            postLogin();
        }
    };

    $("#login").click(function () {
        postLogin();
    });
});

function postLogin() {
    if ($("#account").val() == "" || $("#account").val() == "登录帐号") {
        $("#account").focus();
    }
    else if ($("#password").val() == "") {
        $("#password").focus();
        if (typeof (pwdField) != "undefined") { pwdPlaceholder.focus(); }
    }
    else {
        $("#login").attr("disabled", true);
        $("#login").val("登录中...");
        data = { "USER_NAME": $("#account").val(), "USER_PASSWORD": $("#password").val() };
        $.ajax({
            url: "Login/LogOn",
            dataType: 'json',
            type: 'POST',
            data: data,
            success: function (data, textStatus, XMLHttpRequest) {
                if (data.code == 1) {
                    Tools.jump(data.url);
                }else {
                    alert(data.msg);
                    $("#login").val("登录");
                    $("#login").attr("disabled", false);
                    $("#password").val("");
                    setTimeout(function () { if (typeof (pwdField) != "undefined") { pwdPlaceholder.focus(); } }, 10);
                }
            },
            error: function () {
                alert("系统出错，请稍后访问！");
                Tools.jump("index");
            }
        });
    }
}