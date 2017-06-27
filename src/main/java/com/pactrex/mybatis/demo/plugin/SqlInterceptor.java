package com.pactrex.mybatis.demo.plugin;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.pactrex.mybatis.demo.model.SqlLog;

@Intercepts({@org.apache.ibatis.plugin.Signature(
    type=Executor.class, 
    method="update", 
    args={MappedStatement.class, Object.class}),@org.apache.ibatis.plugin.Signature(
    	    type=Executor.class, 
    	    method="query", 
    	    args={MappedStatement.class, Object.class,RowBounds.class,ResultHandler.class})
	})
public class SqlInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		System.out.println("intercept");
		
		long start = System.currentTimeMillis();
		Object result =  invocation.proceed();
		long cost = System.currentTimeMillis() - start;
		SqlLog log = new SqlLog();
		
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		Object parameter = args[1];
		StatementHandler handler = ms.getConfiguration().newStatementHandler((Executor)invocation.getTarget(), ms, parameter, RowBounds.DEFAULT, null, null);
		
		log.setCaluse(handler.getBoundSql().getSql());
		log.setCreated(new Date());
		log.setCost(cost);
		String methodName = invocation.getMethod().getName();
		if("query".equals(methodName)){
			
		}else if("update".equals(methodName)){
			log.setUpdatedRows(Integer.valueOf(Integer.parseInt(result.toString())));
		}
		try{
		//获取insertSqlLog方法
	    ms = ms.getConfiguration().getMappedStatement("insertSqlLog");
	    //替换当前的参数为新的ms
	    args[0] = ms;
	    //insertSqlLog 方法的参数为 log
	    args[1] = log;
	    //执行insertSqlLog方法
	    invocation.proceed();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		Iterator<Entry<Object, Object>> iterator = properties.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<Object, Object> entry = iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
	
}