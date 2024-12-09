package com.octaviookumu.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    // method to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // method to process HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

}