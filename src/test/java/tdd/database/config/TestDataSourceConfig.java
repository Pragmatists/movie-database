package tdd.database.config;

import java.util.Properties;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.h2.Driver;
import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestDataSourceConfig {

    @Bean(destroyMethod = "close")
    DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(Driver.class.getName());
        basicDataSource.setUrl("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");
        return basicDataSource;
    }

    @Bean
    Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", H2Dialect.class.getName());
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.transaction.auto_close_session", "true");
        properties.setProperty("hibernate.hibernate.connection.release_mode", "auto");
        return properties;
    }

}
