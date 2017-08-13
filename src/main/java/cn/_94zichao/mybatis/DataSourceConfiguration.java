
package cn._94zichao.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
@Configuration
@EnableConfigurationProperties(MultiJdbcProerties.class)
@AutoConfigureBefore(MybatisAutoConfiguration.class)
public class DataSourceConfiguration {

	private static Log log = LogFactory.getLog(DataSourceConfiguration.class);

	@Autowired
	private MultiJdbcProerties multiJdbcProerties;


	@Bean(initMethod="init",destroyMethod="close")
	public DataSource dataSource() {
		
		log.debug("starter config DataSource");
		JdbcProperties app=multiJdbcProerties.getApp();
		JdbcProperties wechat=multiJdbcProerties.getWechat();
		JdbcProperties center=multiJdbcProerties.getCenter();

		RoutingDataSource dataSource=new RoutingDataSource();
		//设置主库
		DataSource masterDataSource=createDataSource(center);
		dataSource.setDefaultTargetDataSource(masterDataSource);
		Map<Object,Object> sourceMap=new HashMap<Object, Object>();
		//放入其他source
		sourceMap.put("wechat", createDataSource(wechat));
		sourceMap.put("app", createDataSource(app));
		dataSource.setTargetDataSources(sourceMap);
		log.debug("end config DataSource");	
		return dataSource;

	}
	
	private DataSource createDataSource(JdbcProperties jdbcProperties){
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setUrl(jdbcProperties.getUrl());
		dataSource.setUsername(jdbcProperties.getUsername());
		dataSource.setPassword(jdbcProperties.getPassword());
		// 连接池属性
		dataSource.setInitialSize(jdbcProperties.getInitialSize());
		dataSource.setMaxActive(jdbcProperties.getMaxActive());
		dataSource.setMinIdle(jdbcProperties.getMinIdle());
		dataSource.setMaxWait(jdbcProperties.getMaxWait());
		dataSource.setPoolPreparedStatements(jdbcProperties.isPoolPreparedStatements());
		dataSource.setMaxPoolPreparedStatementPerConnectionSize(jdbcProperties.getMaxPoolPreparedStatementPerConnectionSize());
		// 测试属性
		dataSource.setValidationQuery(jdbcProperties.getValidationQuery());
		dataSource.setTestOnBorrow(jdbcProperties.isTestOnBorrow());
		dataSource.setTestOnReturn(jdbcProperties.isTestOnReturn());
		dataSource.setTestWhileIdle(jdbcProperties.isTestWhileIdle());
		// 配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
		dataSource.setTimeBetweenEvictionRunsMillis(jdbcProperties.getTimeBetweenEvictionRunsMillis());
		// 配置一个连接在池中最小生存的时间，单位是毫秒
		dataSource.setMinEvictableIdleTimeMillis(jdbcProperties.getMinEvictableIdleTimeMillis());
		// 打开removeAbandoned功能
		dataSource.setRemoveAbandoned(jdbcProperties.isRemoveAbandoned());
		// 1800秒，也就是30分钟
		dataSource.setRemoveAbandonedTimeout(jdbcProperties.getRemoveAbandonedTimeout());
		// 关闭abanded连接时输出错误日志
		dataSource.setLogAbandoned(jdbcProperties.isLogAbandoned());
		// 监控数据库
//		try {
//			dataSource.setFilters("mergeStat");
//		} catch (SQLException e) {
//			log.error(e.getMessage());
//		}
		
		return dataSource; 
	}

	

}
