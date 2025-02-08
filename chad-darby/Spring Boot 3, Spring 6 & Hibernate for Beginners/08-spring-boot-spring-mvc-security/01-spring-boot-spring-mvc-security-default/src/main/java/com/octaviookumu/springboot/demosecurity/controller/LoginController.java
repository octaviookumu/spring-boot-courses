package com.octaviookumu.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showMyLoginPage") // based on the information from our spring security config file
    public String showMyLoginPage() {
        return "plain-login";
    }
}
