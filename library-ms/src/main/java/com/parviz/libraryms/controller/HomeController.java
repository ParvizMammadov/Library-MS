package com.parviz.libraryms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "home.jsp";
	}
	
	@RequestMapping("/signup")
	public String signup() {
		return "signup.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/admin-login")
	public String adminLogin() {
		return "admin-login.jsp";
	}
}
