package com.nativequery.mysqlnativequery.service;

import com.nativequery.mysqlnativequery.model.Employee;

import java.util.List;


public interface EmployeeService extends GenericService<Employee, Integer>{

    @Override
    Employee getSingleEntity(Integer id);

    @Override
    List<Employee> getRowMapperList();

    @Override
    List<Employee> getResultExtractorList();
}
