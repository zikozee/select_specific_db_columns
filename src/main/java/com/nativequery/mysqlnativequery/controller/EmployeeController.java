package com.nativequery.mysqlnativequery.controller;

import com.nativequery.mysqlnativequery.model.Employee;
import com.nativequery.mysqlnativequery.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/mapper/employees")
    public List<Employee> list(){
        return employeeService.getRowMapperList();
    }

    @GetMapping("/extractor/employees")
    public List<Employee> employeeList(){
        return employeeService.getResultExtractorList();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getSingleEntity(id);
    }
}
