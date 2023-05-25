package com.web.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.web.model.UserDtls;
import com.web.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@GetMapping("/signin")
	public String login() {
		return "login";
	}

	@PostMapping("/createUser")
	public String createUser(@ModelAttribute UserDtls user,HttpSession session) {
		boolean f = userService.checkEmail(user.getEmail());
		if (f) {
			session.setAttribute("msg", "Email Id Already Exists");
		} else {
			userService.createUser(user);
			if (user != null) {
				session.setAttribute("msg", "Register Sucessfully");
			} else {
				session.setAttribute("msg", "Something Wrong on Server");
			}
		}
		return "redirect:/register";
	}
}
