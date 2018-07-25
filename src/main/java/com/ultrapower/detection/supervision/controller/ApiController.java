package com.ultrapower.detection.supervision.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
	
	@RequestMapping("/api/test")
    public String testApi(){
        return "test Spring Boot api";
    }
	
	@RequestMapping("/")
    public String index(){
        return "Hello Spring Boot";
    }

}
