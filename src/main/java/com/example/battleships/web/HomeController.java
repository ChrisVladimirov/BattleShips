package com.example.battleships.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String loggedInHome() {
        return "home";
    }

    @GetMapping("/")
    public String loggedOutIndex() {
        return "index";
    }
}
