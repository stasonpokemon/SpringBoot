package com.trebnikau.springboot.service;

import com.trebnikau.springboot.dao.EmployeeDAO;
import com.trebnikau.springboot.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> readAllEmployees() {
        List<Employee> employees = employeeDAO.readAllEmployees();
        return employees;
    }

    @Override
    @Transactional
    public Employee readEmployee(int employeeId) {
        Employee employee = employeeDAO.readEmployee(employeeId);
        return employee;
    }

    @Override
    @Transactional
    public void deleteEmployee(int employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee){
        employeeDAO.saveEmployee(employee);
    }
}
