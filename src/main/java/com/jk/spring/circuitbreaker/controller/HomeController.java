package com.jk.spring.circuitbreaker.controller;

import com.jk.spring.circuitbreaker.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private CommonService service;

    @GetMapping("/sayToBreaker")
    public String sayToBreaker() {
        return service.say();
    }

    @GetMapping("/sayhello")
    public String sayHello() {
        try {
            if(Math.random() > 0.5) {
                throw new RuntimeException("Service not available");
            }
            return "Hello Jitendra";
        } catch (Exception ex) {
            throw ex;
        }
    }
}
