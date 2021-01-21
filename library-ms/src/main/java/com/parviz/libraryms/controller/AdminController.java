package com.parviz.libraryms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.parviz.libraryms.model.Admin;
import com.parviz.libraryms.service.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/verify-admin")
	public RedirectView verifyAdmin(@RequestParam("email") String email,
									@RequestParam("password") String password) {
		
		List<Admin> admins = adminService.findByEmailAndPassword(email, password);
		
		if(admins.size() > 0) {
			String username = admins.get(0).getUsername();
			session.setAttribute("username", username);
			return new RedirectView("/books-admin");
		}
		return new RedirectView("/admin-login");
	}
	
	@GetMapping("/logout-admin")
	public RedirectView logoutAdmin() {
		session.removeAttribute("username");
		session.invalidate();
		return new RedirectView("/login");
	}

}
