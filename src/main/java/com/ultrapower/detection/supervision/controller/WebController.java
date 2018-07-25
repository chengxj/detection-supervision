package com.ultrapower.detection.supervision.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}

}
