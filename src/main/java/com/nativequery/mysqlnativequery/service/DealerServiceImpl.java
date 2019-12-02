package com.nativequery.mysqlnativequery.service;

import com.nativequery.mysqlnativequery.globalHandling.UserNotFoundException;
import com.nativequery.mysqlnativequery.model.Dealer;
import com.nativequery.mysqlnativequery.repo.DealerExtractor;
import com.nativequery.mysqlnativequery.repo.DealerRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Service
public class DealerServiceImpl implements DealerService {

    @Resource(name = "mssqlServer_db")
    private DataSource dataSource;

    private final String QUERY_FOR_DEALERS = "SELECT [deal_code], [biz_unit],[state]" +
            "  FROM [dealerdb].[dbo].[dealer_new]";

    @Override
    public Dealer getSingleEntity(String dealCode) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Dealer dealer =  (Dealer) jdbcTemplate
                .queryForObject(QUERY_FOR_DEALERS + " where deal_code=?", new Object[] {dealCode}, new DealerRowMapper());
        if(dealer == null){
            throw new UserNotFoundException("Dealer with code: " + dealCode + " does not exist");
        }

        return dealer;
    }

    @Override
    public List<Dealer> getRowMapperList() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(QUERY_FOR_DEALERS, new DealerRowMapper());
    }

    @Override
    public List<Dealer> getResultExtractorList() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return (List<Dealer>)jdbcTemplate.query(QUERY_FOR_DEALERS, new DealerExtractor());
    }
}
