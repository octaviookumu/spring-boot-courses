package com.octaviookumu.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    // controller method to read form data
    // add data to the model
//    @RequestMapping("/processFormVersionTwo")
//    public String letsShoutDude(HttpServletRequest request, Model model) {
//
//        // read req param from html form
//        String theName = request.getParameter("studentName");
//
//        // convert data to uppercase
//        String shoutedName = theName.toUpperCase();
//
//        // create message
//        String result = "Yo! " + shoutedName;
//
//        // add message to model
//        model.addAttribute("message", result);
//
//        return "helloworld";
//    }

    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {

        // convert data to uppercase
        String shoutedName = theName.toUpperCase();

        // create message
        String result = "Hey My Friend from v3! " + shoutedName;

        // add message to model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
