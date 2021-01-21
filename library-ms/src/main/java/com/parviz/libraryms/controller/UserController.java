package com.parviz.libraryms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.parviz.libraryms.model.User;
import com.parviz.libraryms.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	@PostMapping(path="/add-user")
	public RedirectView addUser(@RequestParam("email") String email,
							@RequestParam("password") String password,
							@RequestParam("confirmPassword") String confirmPassword,
							@RequestParam("username") String username) {
		
		if(!password.equals(confirmPassword)) {
			return new RedirectView("/signup");
		}
		
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		
		userService.save(user);
		
		session.setAttribute("username", username);
		int id = userService.findByEmailAndPassword(email, password).get(0).getId();
		session.setAttribute("userId", id);
		return new RedirectView("/books");
	}
	
	@GetMapping("/verify-user")
	public RedirectView verifyUser(@RequestParam("email") String email,
									@RequestParam("password") String password) {
		
		List<User> users = userService.findByEmailAndPassword(email, password);
		
		if(users.size() > 0) {
			String username = users.get(0).getUsername();
			int id = users.get(0).getId();
			session.setAttribute("username", username);
			session.setAttribute("userId", id);
			return new RedirectView("/books");
		}
		
		return new RedirectView("/login");
	}
	
	@GetMapping("/logout")
	public RedirectView logout() {
		session.removeAttribute("username");
		session.removeAttribute("userId");
		session.invalidate();
		return new RedirectView("/");
	}
}
