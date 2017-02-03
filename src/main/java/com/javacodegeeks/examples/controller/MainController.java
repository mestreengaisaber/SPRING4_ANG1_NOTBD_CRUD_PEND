package com.javacodegeeks.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    //@RequestMapping("/test")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(){
        //constantTest,index,seguro
        return "index";
    }
}
