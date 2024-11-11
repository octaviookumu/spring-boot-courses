package com.octaviookumu.cruddemo.service;

import com.octaviookumu.cruddemo.dao.EmployeeDAO;
import com.octaviookumu.cruddemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Transactional // since we are modifying the database - used in service layer, not DAO layer
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional // since we are modifying the database - used in service layer, not DAO layer
    @Override
    public void deleteById(int theId) {
        employeeDAO.deleteById(theId);
    }
}
