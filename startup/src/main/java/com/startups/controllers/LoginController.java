package com.startups.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@Autowired
	HttpSession session;
	
	@GetMapping(value = {"/login", "/register"})
	public String login() {
		return "login";
	}
	
	@GetMapping(value = "/logout")
	public String logout() {
		session.removeAttribute("loggedin");
		return "index";
	}
	
	@GetMapping(value = "/403")
	public String accessDenied() {
		return "403";
	}

}
