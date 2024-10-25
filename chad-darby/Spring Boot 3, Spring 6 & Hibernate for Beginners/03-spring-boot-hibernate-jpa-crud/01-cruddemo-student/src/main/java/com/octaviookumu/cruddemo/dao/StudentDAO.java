package com.octaviookumu.cruddemo.dao;

import com.octaviookumu.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    public void save(Student theStudent);

    public Student findById(Integer id);

    public List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();

}
