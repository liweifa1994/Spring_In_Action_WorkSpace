package cn.liweifa.spittr.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by josli on 17/10/16.
 */
@Configuration
public class DataConfig {
    Logger logger = LoggerFactory.getLogger(DataConfig.class);
    @Bean
    public DataSource dataSource(){
        logger.info("开始加载 MySQL");
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3308/spittr?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=TRUE");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        logger.info(" MySQL 连接成功");
        return dataSource;
    }

    @Bean
    public JdbcOperations jdbcOperations(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
