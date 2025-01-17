package com.luv2code.springboot.thymeleafdemo.dao;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

    // add a method to sort by last name
    public List<Employee> findAllByOrderByLastNameAsc();

    // Spring Data JPA will parse the method name
    // Looks for a specific format and pattern
    // Creates appropriate query ... behind the scenes (i.e 'from Employee order by lastName asc')
    // see (www.luv2code.com/query-methods)
}
