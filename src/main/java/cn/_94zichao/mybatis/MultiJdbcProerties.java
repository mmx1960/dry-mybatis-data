

package cn._94zichao.mybatis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;


@Data
@ConfigurationProperties(prefix = MultiJdbcProerties.JDBC_PREFIX)
public class MultiJdbcProerties {

	public static final String JDBC_PREFIX = "jdbc";
	
	private JdbcProperties app;
	private JdbcProperties wechat;
	private JdbcProperties center;



	public JdbcProperties getApp() {
		return app;
	}

	public void setApp(JdbcProperties app) {
		this.app = app;
	}

	public JdbcProperties getWechat() {
		return wechat;
	}

	public void setWechat(JdbcProperties wechat) {
		this.wechat = wechat;
	}

	public JdbcProperties getCenter() {
		return center;
	}

	public void setCenter(JdbcProperties center) {
		this.center = center;
	}
}

