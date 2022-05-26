package com.trebnikau.springboot.dao;

import com.trebnikau.springboot.entity.Employee;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> readAllEmployees() {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Employee> query = session.createQuery("from Employee", Employee.class);
//        List<Employee> employees = query.getResultList();
        Query query = entityManager.createQuery("from Employee");
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    public Employee readEmployee(int employeeId) {
//        Session session = entityManager.unwrap(Session.class);
//        Employee employee = session.get(Employee.class, employeeId);
        Employee employee = entityManager.find(Employee.class, employeeId);
        return employee;
    }


    @Override
    public void saveEmployee(Employee employee){
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(employee);
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());

    }


    @Override
    public void deleteEmployee(int employeeId) {
//        Session session = entityManager.unwrap(Session.class);
//
//        session.delete(readEmployee(employeeId));
        Query query = entityManager.createQuery("delete from Employee where id = :employeeId");
        query.setParameter("employeeId",employeeId);
        query.executeUpdate();
    }
}
