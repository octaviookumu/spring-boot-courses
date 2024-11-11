package com.octaviookumu.cruddemo.rest;

import com.octaviookumu.cruddemo.entity.Employee;
import com.octaviookumu.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // Instead of the controller using the DAO directly we'll have it use the service EmployeeServiceImpl
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // just in case they pass an id in JSON, set id to 0
        // to force a save of new item instead of update

        theEmployee.setId(0);
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee id - " + employeeId;
    }


}

// The reason for using EmployeeDAO employeeDAO instead of EmployeeDAOJpaImpl employeeDAOJpaImpl
// in your controller is to take advantage of the interface-based programming approach.
// Here’s why it’s beneficial:
// Dependency Injection:
// When Spring Boot sees EmployeeDAO in your controller, it will look for a bean that implements EmployeeDAO.
// Since EmployeeDAOJpaImpl is marked with @Repository, Spring Boot will automatically inject it because it’s the only bean that implements EmployeeDAO.
