package com.manzz.framework.core.mybatis.jdbc.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.CallableStatementHandler;
import org.apache.ibatis.executor.statement.PreparedStatementHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.RowBounds;

import com.manzz.framework.core.mybatis.jdbc.dialect.Dialect;
import com.manzz.framework.core.mybatis.jdbc.dialect.OracleDialect;
import com.manzz.framework.core.util.ReflectUtils;

/**
 * Mybatis实现Oracle物理分页
 * @author WJK
 * @version 2014-09
 */
@Intercepts( { @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class OracleStatementHandlerInterceptor implements Interceptor {

    private static final String DIALECT = "com.manzz.framework.core.mybatis.jdbc.dialect.OracleDialect";

    public Object intercept(Invocation invocation) throws Throwable {
        RoutingStatementHandler statement = (RoutingStatementHandler) invocation.getTarget();
        Object delegate = ReflectUtils.getFieldValue(statement, "delegate");
        if(delegate instanceof CallableStatementHandler){//对于调用存储过程则不进行处理 @version 2011-11
            return invocation.proceed();
        }
        PreparedStatementHandler handler = (PreparedStatementHandler)delegate;
        RowBounds rowBounds = (RowBounds) ReflectUtils.getFieldValue(handler,"rowBounds");
        //针对不同的数据库采用方言的形式进行物理分页(这里采用oracle进行分页)
        if (rowBounds.getLimit() > 0
                && rowBounds.getLimit() < RowBounds.NO_ROW_LIMIT) {
            BoundSql boundSql = statement.getBoundSql();
            String sql = boundSql.getSql();
            Dialect dialect = (OracleDialect) Class.forName(DIALECT).newInstance();
            sql = dialect.getLimitString(sql, rowBounds.getOffset(), rowBounds.getLimit());
            ReflectUtils.setFieldValue(boundSql, "sql", sql);
        }
        return invocation.proceed();
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }
}
