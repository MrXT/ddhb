<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:formatDate value="${r'${curDate}'}" pattern="yyyy-MM-dd" var="curDate"/> 
<center>
<form id="${simpleEntityName}Form" method="post" style="margin:5">
	<div class="easyui-panel">
		<table style="width:95%;height: 150px">
			<colgroup>
				<col width="25%"><col width="25%">
				<col width="25%"><col width="25%">
			</colgroup>
			<#list fieldsList as rows>
			<#if rows_index==0>
			<tr style="display:none">
				<th align="right"><font style="color:red">*</font>${simpleEntityName}Id:</th>
				<td>
					<input id="${rows}" name="${rows}" style="width:120px" >
				</td>
			</tr>
			<tr>
			<#elseif (rows_index)%2==0>
				<th align="right">${rows}:<font style="color:red">*</font></th>
				<td>
				  <input name="${rows}" required="required" class="easyui-validatebox" style="width:120px"  maxlength="10">
				</td>
			</tr>
			<tr>
			<#else>
				<th align="right">${rows}:<font style="color:red">*</font></th>
				<td>
				  <input name="${rows}" required="required" class="easyui-validatebox" style="width:120px"  maxlength="10">
				</td>
			</#if>
			</#list>
			</tr>
		</table>
	</div>
	<table width="90%" style="height:40">
		<tr>
			<td width="100%" align="center" colspan="2">
				<a href="javascript:void(0)" onclick="save${simpleEntityName?cap_first}();" class="easyui-linkbutton" iconCls="icon-save">保存</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="javascript:void(0)" onclick="closeWindow($('#popWindow'));" class="easyui-linkbutton" iconCls="icon-back">返回</a>
			</td>
		</tr>
	</table>
</form>
</center>
<script type="text/javascript">
	var $${simpleEntityName}Form = $("#${simpleEntityName}Form");
	var $popWindow = $("#popWindow");
	
	function save${simpleEntityName?cap_first}(){
		if($${simpleEntityName}Form.form("validate")) {//表单验证
			doPost({
				url:"${moduleName}/${simpleEntityName}/save",
				data:$${simpleEntityName}Form.serializeArray(),
				success:function(result){
					closeWindow($popWindow);
					getObjectFromCurFrame("${simpleEntityName}Table").datagrid("reload");//刷新用户列表
				}
			});
		}
	}
</script>
<c:if test="${r'${'}${simpleEntityName}Bean != null}">
	<script type="text/javascript">
		jQuery(function($){
			var data = jQuery.parseJSON('${r'${'}${simpleEntityName}Bean}');
			$${simpleEntityName}Form.form("load", data);
			});
	</script>	
</c:if>