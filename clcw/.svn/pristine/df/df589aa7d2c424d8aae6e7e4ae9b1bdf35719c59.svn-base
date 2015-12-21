var curTo = 0;
var inside = 0;

function x(ob) { return document.getElementById(ob); }

function checkInput(o) {
    if (o.id == "pwd") {
        if (o.value.length > 0) {
            var b = CheckDigit(o.value);
            if (parseInt(o.value.length) > 6) {
                if (parseInt(o.value.length) > 10 && b || parseInt(o.value.length) > 8 && !b) {
                    $("#pwdClass").attr("class", "pwdClass_strong");
                }
                else if (parseInt(o.value.length) > 8 && b || parseInt(o.value.length) > 5 && parseInt(o.value.length) < 8 && !b) {
                    inside++;
                    $("#pwdClass").attr("class", "pwdClass_middle");
                }
                else {
                    if (inside == 0) {
                        $("#pwdClass").attr("class", "pwdClass_simple");
                    }
                }
            }
            else {
                $("#pwdClass").attr("class", "pwdClass_simple");
            }
        }
        else {
            $("#pwdClass").attr("class", "pwdClass");
        }
    }
    else if (o.type == "button") {
        var _loginName = document.getElementById("loginName");
        var _enterprise = document.getElementById("enterprise");
        var _mobileNo = document.getElementById("mobileNo");
        var _pwd = document.getElementById("pwd");
        var _re_pwd = document.getElementById("re_pwd");
        if (_loginName.getAttribute("t") > -1 && _enterprise.getAttribute("t") > -1 && _mobileNo.getAttribute("t") > -1 && _pwd.getAttribute("t") > -1 && _re_pwd.getAttribute("t") > -1) {
            $.ajax({
                type: 'POST',
                url: '/Register/Create?o=' + Math.random(),
                data: { USER_NAME: $("#loginName").val(), USER_PASSWORD: $("#pwd").val(), Enterprise: $("#enterprise").val(),
                    RoleID: $("#ROLE_ID").val(), CTel: $("#mobileNo").val()
                },
                dataType: "json",
                success: function (msg) {
                    if (parseInt(msg) > 0) {
                        data = { "USER_NAME": _loginName.value, "USER_PASSWORD": _pwd.value };
                        $.ajax({
                            url: "/Login/LogOn",
                            dataType: 'json',
                            type: 'POST',
                            data: data,
                            success: function (data, textStatus, XMLHttpRequest) {
                                if (data.code == 1) {
                                    document.location.href = data.url; // "../Goods/Index?1.ok";
                                }
                                else {
                                    alert("登录失败！");
                                }
                            },
                            error: function (XMLHttpRequest, textStatus, errorThrown) {

                            }
                        });
                    }
                    else if (msg == -1) {
                        alert("注册失败，数据库已存在该企业！建议修改企业名称后重新提交。");
                        document.location.href = window.document.location;
                    }
                    else {
                        alert("系统内部出错，注册失败！");
                    }
                }
            });
        }
        else {
            alert("带*号为必填项，请认真填写！");
        }
    }
}

function foreachTag() {
    var o = document.getElementsByTagName("input");
    for (var i = 0; i < o.length; i++) {
        if (o[i].type == "text" || o[i].type == "password") {
            var oo = o[i];
            oo.onclick = function () {
                if (this.id == "loginName") {
                    $("#" + this.id + "_info span").html("* 用户名为汉字、英文不超过12个字符");
                }
                else if (this.id == "enterprise") {
                    $("#" + this.id + "_info span").html("* 请填写完整的企业名称");
                }
                else if (this.id == "mobileNo") {
                    $("#" + this.id + "_info span").html("* 号码为11位数字");
                }
                else if (this.id == "pwd" || this.id == "cur_pwd") {
                    $("#" + this.id + "_info span").html("* 6-16位数字、字符");
                }
                else if (this.id == "re_pwd") {
                    $("#" + this.id + "_info span").html("* 请重复输入密码");
                }
            }
            oo.onblur = function () {
                validated(this);
            }
        }
    }
}

var reg = /[^\u4e00-\u9fa5]/;
var inpwd = 0;
var inputCk = false;
function validated(obj) {
    obj.setAttribute("t", -1);
    if (obj.id == "loginName") {
        if (obj.value == "") {
            $("#" + obj.id + "_info span").css("color", "#FF0000");
        }
        else {
            $.ajax({
                type: 'POST',
                url: '/Register/CUN?o=' + Math.random(),
                data: { USER_NAME: obj.value
                },
                dataType: "json",
                success: function (msg) {
                    if (parseInt(msg) > 0) {
                        $("#" + obj.id + "_info span").html("* 该用户名已存在，请更换！").css("color", "#FF0000");
                        obj.select();
                    }
                    else {
                        $("#" + obj.id + "_info span").html("*").css("color", "#009966");
                        obj.setAttribute("t", 0);
                    }
                }
            });
        }
    }
    else if (obj.id == "enterprise") {
        if (obj.value == "") {
            $("#" + obj.id + "_info span").css("color", "#FF0000");
        }
        else if (obj.value.length < 2) {
            $("#" + obj.id + "_info span").html("* 请填写完整的企业名称").css("color", "#FF0000");
        }
        else if (reg.test(obj.value)) {
            $("#" + obj.id + "_info span").html("* 企业名称只允许输入中文汉字").css("color", "#FF0000");
        }
        else {
            $("#" + obj.id + "_info span").html("*").css("color", "#009966");
            obj.setAttribute("t", 0);
        }
    }
    else if (obj.id == "mobileNo") {
        if (obj.value == "") {
            $("#" + obj.id + "_info span").css("color", "#FF0000");
        }
        else if (phck(obj.value) == 0) {
            $("#" + obj.id + "_info span").html("* 手机号不符合规则，请重新输入").css("color", "#FF0000");
        }
        else {
            $("#" + obj.id + "_info span").html("*").css("color", "#009966");
            obj.setAttribute("t", 0);
        }
    }
    else if (obj.id == "pwd" || obj.id == "cur_pwd") {
        if (obj.value == "") {
            $("#" + obj.id + "_info span").css("color", "#FF0000");
        }
        else if (obj.value.length < 6) {
            $("#" + obj.id + "_info span").html("* 6-16位数字、字符").css("color", "#FF0000");
        }
        else {
            $("#" + obj.id + "_info span").html("*").css("color", "#009966");
            inpwd = obj.value;
            obj.setAttribute("t", 0);
        }
        if (obj.getAttribute("t") == -1) {
            checkInput(obj);
        }
        if (inpwd != 0 && obj.value != $("#re_pwd").val() && $("#pwd").val() != "") {
            $("#re_pwd_info span").html("* 两次输入的密码不一致，请重新输入").css("color", "#FF0000");
        }
        else {
            $("#re_pwd_info span").html("*").css("color", "#009966");
        }
    }
    else if (obj.id == "re_pwd") {
        if (obj.value == "" || obj.value != inpwd) {
            $("#" + obj.id + "_info span").html("* 两次输入的密码不一致，请重新输入").css("color", "#FF0000");
        }
        else {
            $("#" + obj.id + "_info span").html("*").css("color", "#009966");
            obj.setAttribute("t", 0);
        }
    }
}

/*判定手机号输入是否正确*/
function phck(str) {
    /*移动号段16个（2011年版）
    134、135、136、137、138、139、147、150、151、152、157、158、159、182、187、188  
    规则：可以以0开头+三位固定号段+8为数字*/
    var pattern1 = new RegExp(/^0{0,1}(13[4-9]|147|15[0-2]|15[7-9]|18[278])[0-9]{8}$/);
    /*联通号段7个  
    130、131、132、155、156、185、186  
    */
    var pattern2 = new RegExp(/^0{0,1}(13[0-2]|15[56]|18[56])[0-9]{8}$/);
    /*电信号段4个  
    133、153、180、189   
    */
    var pattern3 = new RegExp(/^0{0,1}(133|153|180|189)[0-9]{8}$/);

    /*座机号码
    */
    var pattern4 = /^[+]{0,1}(\d){1,4}[ ]{0,1}([-]{0,1}((\d)|[ ]){1,12})+$/;
    if (str != "") {
        if (pattern1.test(str)) {
            //"移动";
            return 1;
        }
        else if (pattern2.test(str)) {
            //"联通";
            return 1;
        }
        else if (pattern3.test(str)) {
            //"电信";
            return 1;
        }
        //        else if (pattern4.test(str)) {
        //            return 1;
        //        }
        else {
            //"非手机号";
            return 0;
        }
    }
    else {
        return -1;
    }
}

function CheckDigit(str) {
    var regExp = /^\d+(\.\d+)?$/;
    if (regExp.test(str)) {
        return true;
    }
    else {
        return false;
    }
}

function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

function GetRequest(num) {
    var url = location.search;
    var theRequest = new Object();
    if (url.indexOf("?") != -1)
    {
        var str = url.substr(1);
        return str.split(".")[num];
    }
    return null;
}

function getParameter(parName) {
    var str = parName.toLowerCase() + "=";
    var gvalue = "";
    var HREF = location.href;
    var upperHREF = location.href.toLowerCase();
    if (upperHREF.indexOf(str) > 0) {
        gvalue = HREF.substring(upperHREF.indexOf(str) + str.length, upperHREF.length);
        if (gvalue.indexOf('&') > 0) gvalue = gvalue.substring(0, gvalue.indexOf('&'));
        if (gvalue.indexOf("#") > 0) gvalue = gvalue.split("#")[0];
    }
    return gvalue;
}

function GetRandomNum() {
    return Math.floor(Math.random() * 3);
}