package com.octaviookumu.cruddemo.rest;

import com.octaviookumu.cruddemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private final List<Student> theStudents = new ArrayList<>();

    // define @PostContruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {
        theStudents.add(new Student("Rodrigo", "Junior"));
        theStudents.add(new Student("Lamine", "Yamal"));
        theStudents.add(new Student("Wangari", "Stewart"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint or '/students/{studentId}' return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return theStudents.get(studentId);
    }

}
