package com.example.registrationlogin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    @RequestMapping(value={"", "/", "home"})
    public String home(){
        return "home.html";
    }
}
