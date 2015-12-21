package com.manzz.framework.core.mybatis.jdbc.interceptor;

import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.resultset.ResultSetHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

import com.manzz.framework.core.util.ReflectUtils;

/**
 * 取消Mybatis逻辑分页
 * @author WJK
 * @version 2015-02
 */
@Intercepts( { @Signature(type = ResultSetHandler.class, method = "handleResultSets", args = { Statement.class }) })
public class ResultSetHandlerInterceptor implements Interceptor {

	public Object intercept(Invocation invocation) throws Throwable {
		ResultSetHandler resultSet = (ResultSetHandler) invocation.getTarget();
		RowBounds rowBounds = (RowBounds) ReflectUtils.getFieldValue(resultSet,	"rowBounds");
		//取消Mybatis原有逻辑分页
		if (rowBounds.getLimit() > 0 && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
			ReflectUtils.setFieldValue(resultSet, "rowBounds", new RowBounds());
		}
		return invocation.proceed();
	}

	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
	}
}
