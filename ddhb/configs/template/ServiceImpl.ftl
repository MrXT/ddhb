package ${modulePackage}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import ${domainPackage}.${entityName};
import ${modulePackage}.dao.${entityName}DAO;
import ${modulePackage}.service.${entityName}Service;
import com.cht.framework.core.service.PaginationServiceImpl;
/**
 * @author ${authName}
 * @version:${.now?date}
 */
public class ${entityName}ServiceImpl extends PaginationServiceImpl<${entityName}> implements ${entityName}Service{
	@Autowired
	private ${entityName}DAO dao;
}
