package com.nativequery.mysqlnativequery.repo;

import com.nativequery.mysqlnativequery.model.Dealer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DealerRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Dealer dealer = new Dealer();

        dealer.setDealerCode(resultSet.getString("deal_code"));
        dealer.setBusinessUnit(resultSet.getString("biz_unit"));
        dealer.setState(resultSet.getString("state"));
        return dealer;
    }
}
