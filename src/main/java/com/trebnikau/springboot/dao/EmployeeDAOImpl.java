package com.trebnikau.springboot.dao;

import com.trebnikau.springboot.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> readAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }



    @Override
    public void saveEmployee(Employee employee){
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }
//    @Override
//    public Employee readEmployee(int employeeId) {
//        return null;
//    }
//
//    @Override
//    public void deleteEmployee(int employeeId) {
//
//    }
}
