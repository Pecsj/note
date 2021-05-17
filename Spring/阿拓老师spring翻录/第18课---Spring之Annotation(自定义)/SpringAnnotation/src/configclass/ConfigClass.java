package configclass;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 这个类的目的是用来替代原有spring核心文件背后的目的
 * 原来:核心文件---加载文件中的类名字---反射创建对象
 * 现在:通过这个自定义类 创建对象
 *      通过这个类中自定义方法 实现创建对象
 */

@PropertySource("classpath:jdbc.properties")
public class ConfigClass {

    @Value("${driverClassName}")
    private String driverClassName;
    @Value("${url}")
    private String url;
    @Value("${user}")
    private String user;
    @Value("${password}")
    private String password;

    //定义一个方法 目的是获取一个对象 JdbcTemplate类型
    //  肯定有返回值
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    //再定义一个方法 目的是获取一个DataSource类型的对象
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        System.out.println(driverClassName);
        System.out.println(url);
        System.out.println(user);
        System.out.println(password);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
}
