package ${modulePackage}.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ${domainPackage}.${entityName};
import ${modulePackage}.service.${entityName}Service;
import com.manzz.framework.core.util.DateUtils;
import com.manzz.framework.core.util.JacksonUtils;

/**
 * 功能：TODO
 * @author ${authName}
 * @version:${.now?date}
 */
@Controller
@RequestMapping("/${moduleName}/${simpleEntityName}")
public class ${entityName}Controller {

	@Autowired
	private ${entityName}Service ${entityName?uncap_first}Service;
	
    /**
     * 功能：进入管理页面
     * @param  resMap
     */
	@RequestMapping("/manage")
	public String show${entityName}List(Model resMap) {
		return "${moduleName}/${simpleEntityName}_manage";
	}

    /**
     * 功能:分页查询
     * @param condition
     * @param page
     * @param rows
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object query${entityName}List(${entityName} condition, int page, int rows) {
		return ${entityName?uncap_first}Service.queryPaginationVO(condition, page, rows);
	}
	
	@RequestMapping("/new")
	public String doAdd${entityName}(Model resMap){
		resMap.addAttribute("curDate",DateUtils.getUTCTime());
		return "${moduleName}/${simpleEntityName}_edit";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSave${entityName}(${entityName} ${entityName?uncap_first}){
		return ${entityName?uncap_first}Service.doSave(${entityName?uncap_first});
	}
<#list fieldsList as field>
  <#if field_index == 0> <#-- 默认第一个属性为主键 -->
	@RequestMapping("/edit/{${field}}")
	public String doEdit${entityName}(@PathVariable Integer ${field},Model resMap){
		resMap.addAttribute("${simpleEntityName}Bean", JacksonUtils.beanToJson(${entityName?uncap_first}Service.queryByPrimaryKey(${field})));
		return "${moduleName}/${simpleEntityName}_edit";
	}
	
	@RequestMapping(value="/invalidate",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidate${entityName}(Integer ${field}){
		return ${entityName?uncap_first}Service.doInvalidate(${field});
	}
	
	@RequestMapping(value="/revalidate",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidate${entityName}(Integer ${field}){
		return ${entityName?uncap_first}Service.doRevalidate(${field});
	}
  </#if>
</#list>

}