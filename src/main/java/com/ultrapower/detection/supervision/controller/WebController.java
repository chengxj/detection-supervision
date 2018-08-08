package com.ultrapower.detection.supervision.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ultrapower.detection.supervision.entity.User;
import com.ultrapower.detection.supervision.service.auth.AuthException;
import com.ultrapower.detection.supervision.service.auth.AuthService;
import com.ultrapower.detection.supervision.service.auth.LoginVO;

@Controller
public class WebController {
	
	@Autowired
	AuthService authService;
	
	@RequestMapping("/{path}")
	public String path(@PathVariable String path) {
		return path;
	}
	
	@RequestMapping("/index")
	public String home() {
		return "index";
	}
		
	@RequestMapping("/warn")
	public String warn() {
		return "warn";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request) throws Exception {
		if (SecurityUtils.getSubject().isAuthenticated()) {
			return "redirect:/";
		}
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User loginUser, HttpServletRequest request) {
		LoginVO vo = new LoginVO();
		vo.name = loginUser.getUserName();
		vo.pwd = loginUser.getPwd();
		vo.rememberme = request.getParameter("rememberme");
		try {
			authService.login(vo);
			return "redirect:/";
		} catch (AuthException e) {
			return "login";
		}
	}

}
