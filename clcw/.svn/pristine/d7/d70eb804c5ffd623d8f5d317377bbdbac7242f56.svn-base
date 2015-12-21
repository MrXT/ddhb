/**
Project: BoneGrid jQuery Plugin
Version: 2.0
Project Website: 
Author: bone,navy
    
License:
The BoneGrid jQuery plugin is currently available for use in all personal or 
commercial projects under both MIT and GPL licenses. This means that you can choose 
the license that best suits your project, and use it accordingly.
*/
(function (jQuery) {
    jQuery.fn.bonegrid = function (settings) {
        settings = jQuery.extend({
            url: null,
            parameter: null,
            method: 'post',
            pagable: true,
            pageSize: 15,
            checkable: false,
            deletecomfirm: true,
            // isdebug (console.log() show info)			
            isdebug: true,
            tableframe: "<table class=\"uiTable\" ><thead></thead><tbody></tbody></table>",
            pageframe: "<ul class=\"paginator\"></ul>"
        }, settings);

        var grid = $(this);
        var curPage = 1;
        var jsondata = null;
        var headbody = null;
        var tablebody = null;
        var pagedbody = null;
        function debug($obj) {
            if (settings.isdebug && window.console && window.console.log)
                window.console.log($obj);
        }

        function initframe() {
            grid.html(settings.tableframe);
            headbody = grid.find("thead");
            tablebody = grid.find("tbody");
            curPage = jsondata.CurrentPage;
            var tablehtml = "<tr>";
            for (var i in jsondata.GridColumnsDef) {
                tablehtml = tablehtml + "<th><h3>" + jsondata.GridColumnsDef[i].caption + "</h3></th>";
            }
            tablehtml += "</tr>";
            //debug(tablehtml);
            headbody.append(tablehtml);
            //grid = $("#tablecontent");
        }

        function showmsg($data) {
            grid.html($data);
        }

        function showdata() {
            var rowhtml = "";
            for (var item in jsondata.rows) {
                var row = jsondata.rows[item];
                rowhtml += "<tr>";
                for (var c in row) {
                    rowhtml = rowhtml + "<td>" + row[c] + "</td>";
                }
                rowhtml += "</tr>";
            }
            tablebody.append(rowhtml);
        }

        function showPaged() {
            grid.html(grid.html() + settings.pageframe);
            pagedbody = grid.find("ul");
            if (curPage > 1) { //第一页无前一页
                pagedbody.append("<li><a href=\"#\" page=\"" + (curPage - 1).toString() + "\">前一页</a></li>");
            }
            //debug(curPage);
            //中间页码
            if (jsondata.TotalPagesCount < 20) {
                for (var i = 1; i <= jsondata.TotalPagesCount; i++) {
                    if (i == curPage) {
                        pagedbody.append("<li class=\"current\"><a href=\"#\">" + i + "</a></li>");
                    }
                    else {
                        pagedbody.append("<li><a href=\"#\">" + i + "</a></li>");
                    }
                }
            }
            else {
                var beginPage = curPage - 5 < 0 ? 1 : curPage - 5;
                var endPage = beginPage + 10 > jsondata.TotalPagesCount ? jsondata.TotalPagesCount : beginPage + 10;
                for (i = beginPage; i <= endPage; i++) {
                    if (i == curPage) {
                        pagedbody.append("<li class=\"current\"><a href=\"#\">" + i + "</a></li>");
                    }
                    else {
                        pagedbody.append("<li><a href=\"#\">" + i + "</a></li>");
                    }
                }
                //debug("start:" + beginPage + "end:" + endPage);
            }

            //最后页无后一页
            if (curPage != jsondata.TotalPagesCount) {
                pagedbody.append("<li><a href=\"#\"  page=\"" + (curPage + 1).toString() + "\">后一页</a></li>");
            }
            pagedbody.find("li a").bind("click", function () {
                var pagetext = $(this).text();
                if (pagetext == "前一页" || pagetext == "后一页") {
                    curPage = $(this).attr("page");
                }
                else {
                    curPage = pagetext;
                }
                loaddata();
            });
        }

        function loaddata() {
            var requestArg = settings.parameter == null ? "para=nopara" : settings.parameter;
            if (settings.pagable) {
                requestArg += "&PageIndex=" + curPage + "&pageSize=" + settings.pageSize;
            }

            //请求数据			
            $.ajax({
                type: settings.method,
                url: settings.url + "?" + requestArg,
                dataType: "json",
                beforeSend: function () {
                    showmsg("<span>&nbsp&nbsp&nbsp&nbsp数据加载中........</span>");
                },
                success: function (result) {
                    jsondata = result;

                    initframe();
                    showdata();
                    if (settings.pagable) {
                        showPaged();
                    }
                    if (settings.deletecomfirm) {
                        ShowDelectComfirm();
                    }
                },
                error: function (result) {
                    showmsg("<span>&nbsp&nbsp&nbsp&nbsp数据加载失败........</span>");
                }
            });
        }

        function init() {
            loaddata();
        }

        function ShowDelectComfirm() {
            $(".uiTable a").click(function () {
                //console.log($(this).html());
                if ($(this).html() == "删除" && !confirm("确定需要删除这条信息吗？")) {
                    return false;
                }
            })

        }


        init();

        return grid;
    };
})(jQuery);
