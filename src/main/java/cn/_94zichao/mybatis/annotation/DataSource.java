package cn._94zichao.mybatis.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Administrator on 2017/8/13.
 */
@Target({ ElementType.TYPE })//注解作用在方法域
@Retention(RetentionPolicy.RUNTIME)//VM将在运行期也保留注释
@Component
public @interface DataSource {
    String value();
}
