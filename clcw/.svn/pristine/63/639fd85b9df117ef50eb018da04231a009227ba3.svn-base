<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/libs.jsp" %> 
<html>
	<head>
		<base href="${r'${basePath}'}">
		<title>${simpleEntityName}Table</title>
		<script type="text/javascript">
			var $parent = self.parent.$; //父类窗体$
			jQuery(function($){
				$query${simpleEntityName?cap_first}Form = $("#query${simpleEntityName?cap_first}Form");
				$${simpleEntityName}Table = $("#${simpleEntityName}Table");
				$popWindow = $parent("#popWindow");
				$invalidTable = $("#invalidTable");
				
				//信息列表
				$${simpleEntityName}Table.datagrid({
					url:"${moduleName}/${simpleEntityName}/list",
					method:"post",
					iconCls:"icon-user",
					fit:true,          //高宽自适应
					singleSelect:true, //单选（默认为多选）
					fitColumns  :true, //设为true则columns里设置width是百分比，false则width是像素
					pageSize:15,       //改变页面显示条数
					pagination  :true, //显示分页栏
					rownumbers  :true, //显示序号
					loadMsg:"",        //指定加载时显示的文字，如果为空则不显示加载画面
					remoteSort  :false,//前台排序
					columns:[[
						<#list fieldsList as rows>
						<#if rows_index==0>
						{field:"${rows}", title:"${rows}",  width:20,align:"center",hidden:"true"},
					  	<#else>
						{field:"${rows}", title:"${rows}",  width:20,align:"center"},
					    </#if>
					    </#list>
						<#list fieldsList as rows>
						<#if rows_index == 0>
						{field:"opt",      title:"操作",    width:20,align:"center",
							formatter:function(value,row,index){
								var mod = "<a class='linkFont' onclick='show${simpleEntityName?cap_first}Win(\""+row.${rows}+"\")'><img title='修改' src='resources/images/button/update.png' class='cell-img'/>修改</a>";
								var def = "<a class='linkFont' onclick='invalid${simpleEntityName?cap_first}(\""+row.${rows}+"\")'><img title='失效' src='resources/images/button/rubbish.gif' class='cell-img'/>失效</a>";
								var space = "&nbsp;&nbsp;&nbsp;&nbsp;";
								return mod+space+def;
							}
						}
						
					]],
					toolbar:[{
						text:"新增${simpleEntityName}",
						iconCls:"icon-add",
						handler:addRow
					},"-"],
					onDblClickRow:function(index,data){
						showDriverWin(data.id);
					}
					</#if>
     				</#list>
					
				});
				
				//失效信息列表
				$invalidTable.datagrid({
					url:"${moduleName}/${simpleEntityName}/invalidlist",
					method:"post",
					fit:true,          //高宽自适应
					singleSelect:true, //单选（默认为多选）
					fitColumns  :true, //设为true则columns里设置width是百分比，false则width是像素
					pageSize:15,       //改变页面显示条数
					pagination  :true, //显示分页栏
					rownumbers  :true, //显示序号
					loadMsg:"",        //指定加载时显示的文字，如果为空则不显示加载画面
					columns:[[
						<#list fieldsList as rows>
						<#if rows_index==0>
						{field:"${rows}", title:"${rows}",  width:20,align:"center",hidden:"true"},
					  	<#else>
						{field:"${rows}", title:"${rows}",  width:20,align:"center"},
					    </#if>
					    </#list>
						{field:"opt",      title:"操作"   ,width:20,align:"center",
							formatter:function(value,row,index){
								<#list fieldsList as rows>
								<#if rows_index == 0>
								return "<a class='linkFont' onclick='revalidate(\""+row.${rows}+"\")'><img title='恢复' src='resources/images/button/undo.png' class='cell-img'/>恢复</a>";
     							</#if>
     							</#list>
							}
						}
					]]
				});
			});
			//信息查询
			function query${simpleEntityName?cap_first}List() {
				var fields = $query${simpleEntityName?cap_first}Form.serializeArray(); //自动序列化表单元素为JSON数据结构
				reloadDataGridByOptions($${simpleEntityName}Table,fields);
				reloadDataGridByOptions($invalidTable,fields);
			}
			//新增
			function addRow(){
				showWindow($popWindow,
			    {
					iconCls:"icon-save",
					title: "新增${simpleEntityName?cap_first}信息",
					href:"${moduleName}/${simpleEntityName}/new",
					width:580,
					height:240
			  	});
			}
			
			<#list fieldsList as rows>
			<#if rows_index == 0>
			//显示编辑窗口
			function show${simpleEntityName?cap_first}Win(${rows}){
			    showWindow($popWindow,{
					iconCls:"icon-save",
					title: "${simpleEntityName}信息维护",
					href:"${moduleName}/${simpleEntityName}/edit/"+${rows},
					width:580,
					height:240
				});
			}
			//设置为失效
			function invalid${simpleEntityName?cap_first}(${rows}){
		        confirmAndPost({
		        	msg:"是否要拉黑"+${rows}+"?",
					url:"${moduleName}/${simpleEntityName}/invalidate",
					data:{"${rows}":${rows}},
					success:function(result){
						$${simpleEntityName}Table.datagrid("reload");
						$invalidTable.datagrid("reload");
					}
		        });
			}
			//将失效信息从回收站中恢复
			function revalidate(${rows}){
		        confirmAndPost({
		        	msg:"是否要恢复该记录?",
					url:"${moduleName}/${simpleEntityName}/revalidate",
					data:{"${rows}":${rows}},
					success:function(result){
						$${simpleEntityName}Table.datagrid("reload");
						$invalidTable.datagrid("reload");
					}
		        });
			}
			</#if>
			</#list>
		</script>
	<head>
	<body class="easyui-layout" fit="true" >
		<div region="north" split="false" style="height:150px;overflow:hidden;" border="false">
			<fieldset style="width:99%;">
				<legend><img src='resources/images/button/query.png' class='cell-img'/>query${simpleEntityName?cap_first}Form:</legend>
				<center>
				<form id="query${simpleEntityName?cap_first}Form">
					<table width="800px" border="0" cellspacing="2" >
						<colgroup>
							<col width="16%"><col width="17%">
							<col width="16%"><col width="17%">
							<col width="16%"><col width="17%">
						</colgroup>
					  <tr>
					  	<#list fieldsList as rows>
					  	<#if rows_index==0>
					  	<#elseif (rows_index)%3==0>
					  	<th align="right">${rows}:</th>
					    <td>
					    	<input name="${rows}" style="width:100%;">
					    </td>
					  </tr>
					  <tr>
					  	<#else>
					  	<th align="right">${rows}:</th>
					    <td>
					    	<input name="${rows}" style="width:100%;">
					    </td>
					    </#if>
					    </#list>
					  </tr>
					  <tr>
					  	<td colspan=8 align="center">
							<a href="javascript:void(0)" class="easyui-linkbutton" onclick="query${simpleEntityName?cap_first}List();" iconCls="icon-search">查询</a>
							&nbsp;&nbsp;
							<a href="javascript:void(0)" class="easyui-linkbutton" onclick="query${simpleEntityName?cap_first}Form.reset();" iconCls="icon-undo">重置</a>
					  	</td>
					  </tr>
					</table>
				</form>
				</center>
			</fieldset>
		</div>
		<div region="center" split="false" style="overflow-x:hidden;" border="false">
			<div class="easyui-tabs" fit="true" border="false">
				<div title="${simpleEntityName}Table" iconCls="icon-user"> 
					<table id="driverTable" border="false"></table>
				</div>
				<div title="回收站" iconCls="icon-rubbish" >
					<table id="invalidTable" border="false"></table>
				</div>
			</div>
		</div>
	</body>
</html>
