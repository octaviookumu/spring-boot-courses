package com.octaviookumu.springcoredemo.rest;

import com.octaviookumu.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependancy
    private final Coach myCoach;

    @Autowired
    // tells spring to inject dependency - if you only have one constructor the Autowired on construction is optional
    public DemoController(Coach theCoach) {
        this.myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();
    }

}
