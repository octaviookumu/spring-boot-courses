package com.octaviookumu.thymeleafdemo.controller;

import com.octaviookumu.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showStudentForm")
    public String showForm(Model theModel) {

        // create student object
        Student theStudent = new Student();

        // add student object to model
        theModel.addAttribute("student", theStudent);


        return "student-form";
    }


    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.println("theStudent " + theStudent.getFirstName() + " " + theStudent.getLastName());

        return "student-confirmation";
    }

}
