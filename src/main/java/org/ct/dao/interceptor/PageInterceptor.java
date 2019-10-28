package org.ct.dao.interceptor;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.ct.bean.BaseBean;
import org.ct.bean.Page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

@Intercepts(@Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class}))
public class PageInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");
        String id = mappedStatement.getId();
        if (id.endsWith("ByPage")) {
            BoundSql boundSql = statementHandler.getBoundSql();
            String sql = boundSql.getSql();
            Connection conn = (Connection) invocation.getArgs()[0];
            PreparedStatement preparedStatement = conn.prepareStatement("select count(*) from (" + sql + ") t");
            ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
            parameterHandler.setParameters(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            BaseBean bean = (BaseBean) boundSql.getParameterObject();
            Page page = bean.getPage();
            while (resultSet.next()) {
                page.setTotalCount(resultSet.getInt(1));
            }
            //System.out.println("拦截器使用的的当前页"+page.getPageCurrent());
            String limitSql = sql + " limit " + page.getPageCurrent() * page.getPageNumber() + "," + page.getPageNumber();
            metaObject.setValue("delegate.boundSql.sql", limitSql);
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
