

package cn._94zichao.mybatis;

import cn._94zichao.mybatis.annotation.DataSource;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
@Intercepts({ @Signature(type = Executor.class, method = "update",
		args = {MappedStatement.class, Object.class}),
		@Signature(method = "query", type = Executor.class,
args = { MappedStatement.class, Object.class , RowBounds.class , ResultHandler.class}),
			@Signature(method = "query", type = Executor.class,
args = { MappedStatement.class, Object.class , RowBounds.class , ResultHandler.class,
				CacheKey.class, BoundSql.class}),
			@Signature(method = "queryCursor", type = Executor.class,
					args = { MappedStatement.class, Object.class, RowBounds.class})
})
public class RoutingDataSourcePlguns implements Interceptor {
	
	private Properties properties ;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
		Class clazz = ReflectUtils.getClassFromMethodString(mappedStatement.getId());
		DataSource source = (DataSource) clazz.getAnnotation(DataSource.class);
		if (source!=null){
			DataSourceContextHolder.setSource(source.value());
		}
		Object obj=invocation.proceed();
		DataSourceContextHolder.setMaster();
		return obj;
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {

		this.properties=properties;

	}

}

