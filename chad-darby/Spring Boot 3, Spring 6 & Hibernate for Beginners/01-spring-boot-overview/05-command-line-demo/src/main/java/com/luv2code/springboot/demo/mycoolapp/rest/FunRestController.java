package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // expose endpoint "/" that returns "Hello"

    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/workout")
    public String getDailyWorkout(){
        return "Great workout!";
    }

    @GetMapping("/fortune")
    public String getFortune(){
        return "Today is your lucky day!";
    }

}
