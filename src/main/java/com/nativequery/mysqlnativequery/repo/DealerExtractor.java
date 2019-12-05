package com.nativequery.mysqlnativequery.repo;

import com.nativequery.mysqlnativequery.model.Dealer;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DealerExtractor implements ResultSetExtractor<List<Dealer>> {

    @Override
    public List<Dealer> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Dealer> dealers = new ArrayList<>();

        while(resultSet.next()){
            Dealer dealer = new Dealer();

            dealer.setDealerCode(resultSet.getString("deal_code"));
            dealer.setBusinessUnit(resultSet.getString("biz_unit"));
            dealer.setState(resultSet.getString("state"));

            dealers.add(dealer);
        }
        return dealers;
    }
}
