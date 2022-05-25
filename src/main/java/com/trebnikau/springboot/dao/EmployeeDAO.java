package com.trebnikau.springboot.dao;

import com.trebnikau.springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    void saveEmployee(Employee employee);

    List<Employee> readAllEmployees();

    Employee readEmployee(int employeeId);

    void deleteEmployee(int employeeId);
}
