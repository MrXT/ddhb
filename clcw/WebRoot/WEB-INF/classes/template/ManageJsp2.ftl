<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/libs.jsp"%>
<html>
<head>
<base href="${r'${basePath}'}">
<title>${simpleEntityName}Table</title>
<script type="text/javascript">
	jQuery(function($) {
		$${simpleEntityName}Table = $("#${simpleEntityName}Table");//双击编辑
		
		//信息列表
		$${simpleEntityName}Edg = $${simpleEntityName}Table.edatagrid({
			url : "${moduleName}/${simpleEntityName}/list",
			method : "post",
			fit : true, //高宽自适应
			singleSelect : true, //单选（默认为多选）
			pageSize : 15, //改变页面显示条数
			pagination : true, //显示分页栏
			fitColumns : true, //设为true则columns里设置width是百分比，false则width是像素
			rownumbers : true, //显示序号
			loadMsg : "", //指定加载时显示的文字，如果为空则不显示加载画面
			columns : [ [
				<#list fieldsList as rows>
				<#if rows_index==0>
				{field:"${rows}", title:"${rows}",  width:20,align:"center",hidden:"true"},
				<#else>
				{field:"${rows}", title:"${rows}",  width:20,align:"center",editor : {type : "validatebox"}},
				</#if>
				</#list>
				
				<#list fieldsList as rows>
				<#if rows_index == 0>
				{
					field : "opt",
					title : "操作",
					width : 20,
					align : "center",
					formatter : function(value, row, index) {
						var mod = "<a class='linkFont' onclick='update${simpleEntityName?cap_first}(\"" + index+ "\")'><img title='修改' src='resources/images/button/update.png' class='cell-img'/>修改</a>";
						var space = "&nbsp;&nbsp;&nbsp;&nbsp;";
						var del = "<a class='linkFont' onclick='del${simpleEntityName?cap_first}(\"" + row.${rows}+ "\")'><img title='删除' src='resources/images/button/rubbish.gif' class='cell-img'/>删除</a>";
						return mod+space+del;
					}
				} 
					] ],
			onSelect : function(rowIndex, rowData) {
			},
				</#if>
     			</#list>
			saveUrl : "${moduleName}/${simpleEntityName}/save",
			updateUrl : "${moduleName}/${simpleEntityName}/save"
		});
		$${simpleEntityName}Edg.datagrid("getPager").pagination({
			displayMsg : ""
		});

	});
	
	//更新
	function update${simpleEntityName?cap_first}(index) {
		$${simpleEntityName}Edg.edatagrid("editRow", index);
	}

	<#list fieldsList as rows>
	<#if rows_index == 0>
	//删除并刷新页面
	function del${simpleEntityName?cap_first}(${rows}){
		confirmAndPost({
			msg : "是否要删除该记录?",
			url : "${moduleName}/${simpleEntityName}/del",
			data : {
				"${rows}" : ${rows}
			},
			success : function(result) {
				$${simpleEntityName}Table.edatagrid("reload");
			}
		});
	}
	</#if>
    </#list>
</script>
</head>
<body class="easyui-layout" fit="true">
	<div region="center" split="false" style="overflow-x: hidden; border="false">
		<div class="easyui-layout" fit="true">
			<div region="center" border="false">
				<div class="easyui-layout" fit="true" border="false">
					<div region="center" style="width: 260px" border="false">
						<div class="easyui-panel" fit="true" title="${simpleEntityName}Table" iconCls="icon-assign" border="false">
							<div class="easyui-layout" fit="true" border="false">
								<div region="north" style="height: 35px" border="false">
									<div class="toolbar" id="toolbar">
										<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-add" plain="true"
											onclick="$${simpleEntityName}Edg.edatagrid('addRow')">新增</a> 
										<a href="javascript:void(0);" class="easyui-linkbutton"
											iconCls="icon-save" plain="true" onclick="$${simpleEntityName}Edg.edatagrid('saveRow')">保存</a> 
										<a href="javascript:void(0);" class="easyui-linkbutton" iconCls="icon-undo"
											plain="true" onclick="$${simpleEntityName}Edg.edatagrid('cancelRow')">取消</a>
									</div>
								</div>
								<div region="center" border="false">
									<table id="${simpleEntityName}Table" border="false"></table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>