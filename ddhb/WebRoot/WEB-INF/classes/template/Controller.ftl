package ${modulePackage}.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ${domainPackage}.${entityName};
import ${modulePackage}.service.${entityName}Service;

/**
 * 功能：TODO
 * @author XT
 * @version:${.now?date}
 */
@Controller
@RequestMapping("/${moduleName}/${simpleEntityName}")
public class ${entityName}Controller {

	@Autowired
	private ${entityName}Service ${entityName?uncap_first}Service;

    /**
     * 功能:查询
     * @param condition
     * @return
     */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Object query${entityName}List(@RequestBody ${entityName} condition) {
		return ${entityName?uncap_first}Service.queryByCondition(condition);
	}	
    /**
     * 功能:分页查询
     * @param condition
     * @param page
     * @param rows
     * @return
     */
	@RequestMapping(value = "/pageList", method = RequestMethod.POST)
	@ResponseBody
	public Object query${entityName}List(@RequestBody ${entityName} condition, int page, int rows) {
		return ${entityName?uncap_first}Service.queryPaginationVO(condition, page, rows);
	}

	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Object doSave${entityName}(@RequestBody ${entityName} ${entityName?uncap_first}){
		return ${entityName?uncap_first}Service.doSave(${entityName?uncap_first});
	}
	/**
     * 功能:无效
     * @param id
     * @return
     */
	@RequestMapping(value="/invalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doInvalidate${entityName}(@PathVariable String id){
		return ${entityName?uncap_first}Service.doInvalidate(id);
	}
	/**
     * 功能:有效
     * @param id
     * @return
     */
	@RequestMapping(value="/revalidate/{id}",method=RequestMethod.POST)
	@ResponseBody
	public Object doRevalidate${entityName}(@PathVariable String id){
		return ${entityName?uncap_first}Service.doRevalidate(id);
	}


}