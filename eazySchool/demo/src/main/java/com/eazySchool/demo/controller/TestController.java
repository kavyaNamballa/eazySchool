package com.eazySchool.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Slf4j
@Controller
public class TestController {
//    @RequestMapping("/test")
    public String displayExam(){
        return "test.html";
    }
    @RequestMapping("/test")
    public RedirectView redirectToExternalSite() {
        String externalUrl = "https://leetcode.com/problems/subarrays-with-k-different-integers/?envType=daily-question&envId=2024-03-30";
        return new RedirectView(externalUrl);
    }
}
