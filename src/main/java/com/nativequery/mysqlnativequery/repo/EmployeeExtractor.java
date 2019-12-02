package com.nativequery.mysqlnativequery.repo;

import com.nativequery.mysqlnativequery.model.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeExtractor implements ResultSetExtractor {
    @Override
    public Object extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Employee> employees = new ArrayList<>();

        while(resultSet.next()){
            Employee employee = new Employee();

            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));

            employees.add(employee);
        }
        return employees;
    }
}
