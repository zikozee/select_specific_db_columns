package com.nativequery.mysqlnativequery.service;

import com.nativequery.mysqlnativequery.globalHandling.UserNotFoundException;
import com.nativequery.mysqlnativequery.model.Employee;
import com.nativequery.mysqlnativequery.repo.EmployeeExtractor;
import com.nativequery.mysqlnativequery.repo.EmployeeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    //Extractor is the better preferred

    @Resource(name = "mysql_db")
    private DataSource dataSource;


    private final String QUERY_FOR_EMPLOYEES = "select first_name, last_name from employee";

    @Override
    public Employee getSingleEntity(Integer id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Employee employee =  (Employee) jdbcTemplate
                .queryForObject(QUERY_FOR_EMPLOYEES + " where id=?", new Object[] {id}, new EmployeeRowMapper());
        if(employee == null){
            throw new UserNotFoundException("Employee with id: " + id + " does not exist");
        }

        return employee;
    }

    @Override
    public List<Employee> getRowMapperList() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate.query(QUERY_FOR_EMPLOYEES, new EmployeeRowMapper());
    }

    @Override
    public List<Employee> getResultExtractorList() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return (List<Employee>)jdbcTemplate.query(QUERY_FOR_EMPLOYEES, new EmployeeExtractor());
    }
}
