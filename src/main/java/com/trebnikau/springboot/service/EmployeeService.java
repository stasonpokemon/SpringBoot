package com.trebnikau.springboot.service;

import com.trebnikau.springboot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(Employee employee);

    List<Employee> readAllEmployees();
//
//    Employee readEmployee(int employeeId);
//
//    void deleteEmployee(int employeeId);
}
