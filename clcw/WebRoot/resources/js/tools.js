var reg = /[^\u4e00-\u9fa5]/;
var specialPattern = new RegExp("[`·~!@#$^&*()=|{}':;'\"\",\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]"); 
var specialPatternHaveSpace = new RegExp("[`·~!@#$^&*()=|{}':;'\"\",\\[\\].<>/?~！@#￥……&* （）——|{}【】‘；：”“'。，、？]"); 
var autocompleteCities, autocompleteDrivers, autocompleteVehicles, inpwd = 0, inputCk = false, inside = 0, fromPage, cnt = 0, skip = 0, _settimeout = 0;
var _myUrl = window.location.href.split(":");
var Tools = {
    x: function (obj) {
        return document.getElementById(obj);
    },
    mark: function () {
        return "★";
    },
    initSkiper: function () {
        return _myUrl[0] + ":" + _myUrl[1] + ":8009/";
    },
    validateMP: function (str) {
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
    },
    getRequest: function (parameter) {
        var str = parameter.toLowerCase() + "=";
        var gvalue = "";
        var HREF = location.href;
        var upperHREF = location.href.toLowerCase();
        if (upperHREF.indexOf(str) > 0) {
            gvalue = HREF.substring(upperHREF.indexOf(str) + str.length, upperHREF.length);
            if (gvalue.indexOf('&') > 0) gvalue = gvalue.substring(0, gvalue.indexOf('&'));
            if (gvalue.indexOf("#") > 0) gvalue = gvalue.split("#")[0];
        }
        return gvalue;
    },
    jump: function (url) {
        if (url.indexOf("ToViaSite") > 0) {
            $.ajax({ url: url, dataType: 'json', type: 'POST', data: {}, success: function (data) { parent.window.location.replace(data.Content); } });
        }
        else {
            window.location.href=url;
        }
    },
    CheckDigit: function (str) {
        var regExp = /(^\d+$)/;
        if (regExp.test(str)) {
            return true;
        }
        else {
            return false;
        }
    },
    setCookie: function (info, value, seconds) {
        seconds = seconds || 0;   //seconds有值就直接赋值，没有为0
        var expires = "";
        if (seconds != 0) {      //设置cookie生存时间
            var date = new Date();
            date.setTime(date.getTime() + (seconds * 1000));
            expires = "; expires=" + date.toGMTString();
        }
        value = value + "|" + date.getTime();
        var cookies = info + "=" + value + expires + "; path=/";
        document.cookie = cookies; //转码并赋值
    },
    searchCookie: function (val) {
        var cookieVal = getCookie("" + escape(val) + "");
        if (cookieVal != false) {
            valArray = new Array();
            valArray = cookieVal.split('|')
        }
        return cookieVal;
    },
    getCookie: function (name) {
        var nameEQ = name + "=";
        var ca = document.cookie.split(';');    //把cookie分割成组
        for (var i = 0; i < ca.length; i++) {
            var c = ca[i];                      //取得字符串
            while (c.charAt(0) == ' ') {          //判断一下字符串有没有前导空格
                c = c.substring(1, c.length);      //有的话，从第二位开始取
            }
            if (c.indexOf(nameEQ) == 0) {       //如果含有我们要的name
                return unescape(c.substring(nameEQ.length, c.length));    //解码并截取我们要值
            }
        }
        return false;
    },
    clearCookie: function (name) {
        Tools.setCookie(name, "", -1);
    },
    customHide: function (obj) {
        if (obj.indexOf(",") > -1) {
            var o = obj.split(",");
            for (var i = 0; i < o.length; i++) {
                $("#" + o[i]).css("display", "none");
            }
        }
        else {
            $("#" + obj).css("display", "none");
        }
    },
    mouseDownHandler: function () {
        if (event.srcElement.tagName == "INPUT") {
            if (event.srcElement.type == "text"
              || event.srcElement.type == "textarea"
              || event.srcElement.type == "file"
              || event.srcElement.type == "password") {
                return true;
            }
        }
        if (event.srcElement.tagName == "TEXTAREA") {
            return true;
        }
        return false;
    },
    pollingCheck: function () {
        $.ajax({
            type: 'POST',
            url: 'System/CheckSession?o=' + Math.random(),
            data: {},
            dataType: "json",
            success: function (msg) {
                if (parseInt(msg) > 0) {
                    _settimeout = setTimeout(function () { Tools.pollingCheck(); }, 2000);
                }
                else if (parseInt(msg) == -1) {
                    if (_settimeout != 0) { clearTimeout(_settimeout); }
                    alert("您的帐号在另一地点登录，您被迫下线。\n\n如果这不是您本人的操作，那么您的密码\n很可能已泄漏。建议您尽快联系管理员协助解决！");
                    Tools.jump("/");
                }
                else {
                    Tools.jump("../System/Index");
                }
            }
        });
    },
    windowIntercept: function (t) {
        if (t) {
            window.onbeforeunload = function () {
                //$.ajax({ type: 'POST', url: '/System/ClearViaSite?o=' + Math.random(), data: {}, dataType: "json", success: function (msg) { } });
                window.unloadTimer = setInterval("clearInterval(window.unloadTimer);", 500);
                window.onunload = function () { clearInterval(window.unloadTimer); }
                return '执行此次操作将会终止所有操作，确认继续？';
            };
        }
        else {
            window.onbeforeunload = null;
        }
    },
    closeWin: function (url) {
        setTimeout(function () { if (typeof (ymPrompt) != "undefined") { ymPrompt.close(); } }, 200);
        if (url != "") { Tools.jump(url); }
        $(document).unbind(((/Firefox/i.test(navigator.userAgent)) ? "DOMMouseScroll" : "mousewheel"));
    },
    initLinkeList: function () {
        return new LinkedList();
    },
    dynamicLoad: function () {
        var script = document.createElement("script");
        script.type = "text/javascript";
        script.src = "http://api.map.baidu.com/api?v=2.0&ak=bqvCmIoE8UAGlCuqW8Dz6SC1&callback=loadMap";
        document.body.appendChild(script);
    },
    pagestyle: function (middle, value) {
        var winHeight = $(window).height();
        var headerHeight = "136";
        var footerHeight = $("#footer").height();
        conHeight = winHeight - headerHeight - footerHeight;
        middle.height(conHeight - 62 - value);
    },
    bindSelect: function (selectObj, data, tag) {
        for (var i = 0; i < data.length; i++) {
            if (tag == 0) {
                selectObj.options.add(new Option(data[i]["DEPARTURENAME"] + "—" + data[i]["DESTINATIONNAME"], data[i]["DEPARTURE"] + "," + data[i]["DESTINATION"]));
            }
            else if (tag == 1) {
                selectObj.options.add(new Option(data[i]["CLASSLINE_NAME"], data[i]["CLASSLINE_NAME"]));
            }
            else if (tag == 2) {
                selectObj.options.add(new Option(data[i]["LICENSEPLATE"], data[i]["LICENSEPLATE"]));
            }
            else {
                selectObj.options.add(new Option(data[i]["FULLNAME"], data[i]["FULLNAME"]));
            }
        }
    },
    ExitSystem: function (basePath) {
        var _curUser = parent.Tools.x("cur_user").value;
        if (_settimeout != 0) { clearTimeout(_settimeout); }
        $.ajax({
            url: "System/Logout",
            dataType: 'json',
            type: 'POST',
            data: { CURUSER: _curUser },
            success: function (data) {
            	Tools.jump(basePath+data.url);
            }
        });
    },
    isPlaceholder: function () {
        var input = document.createElement('input');
        return 'placeholder' in input;
    },
    supportPlaceholder: function () {
        if (!Tools.isPlaceholder()) {
            $("input").not("input[type='password']").each(//把input绑定事件 排除password框
	            function () {
	                if ($(this).val() == "" && $(this).attr("placeholder") != "") {
	                    $(this).val($(this).attr("placeholder"));
	                    $(this).css("color", "#A9A9A9");
	                    $(this).css("font-family", "SimSun");
	                    $(this).focus(function () {
	                        if ($(this).val() == $(this).attr("placeholder")) $(this).val(""); $(this).css("color", "#000");
	                    });
	                    $(this).blur(function () {
	                        if ($(this).val() == "") {
	                            $(this).val($(this).attr("placeholder"));
	                            $(this).css("color", "#A9A9A9");
	                        }
	                    });
	                }
	            });
            var pwdField = $("input[type=password]");
            var pwdVal = pwdField.attr('placeholder');
            pwdField.after('<input id="pwdPlaceholder" type="text" value=' + pwdVal + ' autocomplete="off" />');
            var pwdPlaceholder = $('#pwdPlaceholder');
            pwdPlaceholder.css("color", "#A9A9A9");
            pwdPlaceholder.css("font-family", "SimSun");
            pwdPlaceholder.show();
            pwdField.hide();

            pwdPlaceholder.focus(function () {
                pwdPlaceholder.css("color", "#000");
                pwdPlaceholder.hide();
                pwdField.show();
                pwdField.focus();
            });

            pwdField.blur(function () {
                if (pwdField.val() == '') {
                    pwdPlaceholder.show();
                    pwdField.hide();
                    pwdPlaceholder.css("color", "#A9A9A9");
                }
            });
        }
    },
    CheckInputBox: function (controls) {
        var _controls = controls;
        if (_controls.val() == "" || (_controls.val() == _controls.attr("placeholder"))) {
            _controls.focus();
            return 0;
        }
        return 1;
    },
    clearInputBox: function (obj, obj1) {
        obj.bind("click", function () { $(".ac_results").hide(); if ($(this).attr("id") == "departure") { $("#siteListData").html(""); classline = 0; $("#classline").val(""); } if ($(this).attr("id") == "vehicles") { $("#passengers").html("0座"); } $(this).val(""); $(this).attr("code", "0"); }).bind("blur", function () { $(this).val(""); $(this).attr("code", "0"); });
        obj1.bind("click", function () { $(".ac_results").hide(); if ($(this).attr("id") == "destination") { $("#siteListData").html(""); classline = 0; $("#classline").val(""); } $(this).val(""); $(this).attr("code", "0"); }).bind("blur", function () { $(this).val(""); $(this).attr("code", "0"); });
    },
    showCustomerWin: function (msg) {
        if (msg == "alert") {
            ymPrompt.alert("Hello");
        }
        else if (msg == "loading") {
            return "<div class='loading'><div class='left-icon'></div><div class='right-txt'>数据加载中，请稍后...</div></div>";
        }
    },
    initControls: function (controls, width) {
        var _controls;
        if (controls.indexOf(",") > 0) {
            _controls = controls.split(",");
            for (var i = 0; i < _controls.length; i++) {
                Tools.initAutocomplete(_controls[i], width);
            }
        }
        else {
            _controls = controls;
            Tools.initAutocomplete(_controls, width);
        }
    },
    initAutocomplete: function (_c, _w) {
        $(function () {
            $('#' + _c).autocomplete(autocompleteCities, {
                delay: 1,
                selectFirst: true,
                scroll: false,
                max: 10,
                minChars: 1,
                width: _w,
                matchContains: true,
                autoFill: false,
                formatItem: function (data) {
                    return data.regionRegionname;
                },
                formatMatch: function (data) {
                    return data.regionFirstletter + data.regionRegionname + data.regionPinyin;
                },
                formatResult: function (data) {
                    return data.regionRegionname + data.regionCode;
                }
            }).result(function (event, row, formatted) {
                $(this).val(row.regionRegionname);
                $(this).attr("code", row.regionCode);
                $(this).unbind("blur");
            });
        });
    },
    bindAutocomplete: function (flag) {
        var _urls;
        if (flag == 2) { _urls = 'Lines/GetRegion'; } else if (flag == 0) { _urls = 'Frequency/SearchCars'; } else { _urls = 'Frequency/SearchDrivers'; }
        $.ajax({
        	async:false, 
            type: 'post',
            url: _urls,
            data: { letters: 'c' },
            dataType: "json",
            success: function (resultData) {
            	//返回的为json
            	var data = resultData.rows;
                if (flag == 2) {
                    autocompleteCities = new Array();
                    autocompleteCities = data;
                    Tools.bindAutocomplete(0);
                }
                else if (flag == 0) {
                    autocompleteVehicles = new Array();
                    autocompleteVehicles = data;
                    Tools.bindAutocomplete(1);
                }
                else {
                    autocompleteDrivers = new Array();
                    autocompleteDrivers = data;
                }
            }
        });
    }
}
function openTip(str){
	var $tipDiv = $("#tipDiv");
	var mouseX = event.clientX;
	var mouseY = event.clientY;
	var scrollTop = $(document).scrollTop();
	$tipDiv.css({
		'left':mouseX,
		'top':mouseY+scrollTop
	});
	$tipDiv.find(".tooltip-inner").html(str);
	$tipDiv.show();
}
function closeTip(){
	$("#tipDiv").hide();
}
