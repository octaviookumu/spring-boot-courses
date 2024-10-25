package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    // inject properties
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

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

    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: " + coachName + ", Team name: " + teamName;
    }

}
