package com.nativequery.mysqlnativequery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
public class MysqlnativequeryApplication implements CommandLineRunner {

    @Resource(name = "mysql_db")
    private  DataSource dataSource;

    @Resource(name = "mssqlServer_db")
    private DataSource anotherDatasource;

//    @Autowired
//    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(MysqlnativequeryApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        Integer count = jdbcTemplate.queryForObject("select count(id) from employee", Integer.class);

        List<Integer> ids = jdbcTemplate.queryForList("select id from employee", Integer.class);

        System.out.println("Count: " + count);

        System.out.println("ids: " + ids);

        System.out.println("************SECOND DATABASE*************");

        JdbcTemplate sqlServerJdbc = new JdbcTemplate(anotherDatasource);
        Integer countMssql = sqlServerJdbc.queryForObject("select count(deal_code) from dealer_new", Integer.class);

        List<String> mssqlIds = sqlServerJdbc.queryForList("select top 100 deal_code from dealer_new", String.class);

        System.out.println("Count mssql server: " + countMssql);

        System.out.println("mssql server ids: " + mssqlIds);
    }
}
