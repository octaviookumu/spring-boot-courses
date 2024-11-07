package com.octaviookumu.cruddemo.rest;

import com.octaviookumu.cruddemo.entity.Student;
import com.octaviookumu.cruddemo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

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

        // check the studentId against list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
