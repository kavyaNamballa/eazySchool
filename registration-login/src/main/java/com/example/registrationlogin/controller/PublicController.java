package com.example.registrationlogin.controller;

import com.example.registrationlogin.model.Person;
import com.example.registrationlogin.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
public class PublicController {

    @Autowired
    private PersonService personService;

    @GetMapping(value = "/register")
    public String registrationForm(@RequestParam(value = "notRegister", required = false) String notRegister, Model model){
        if(notRegister!=null){
            model.addAttribute("errorMessage","Registration Unsuccessfull");
        }
        model.addAttribute("person",new Person());
        return "register.html";
    }

    @RequestMapping(value ="/register/createUser",method = { RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {
        if(errors.hasErrors()){
            return "register.html";
        }
        boolean isSaved = personService.createNewUser(person);
        if(isSaved){
            return "redirect:/login?register=true";
        }else {
            return "redirect:/register?notRegister=true";
        }
    }
}
