package com.startups.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// "APP" refers to pages/functionality intended for authenticated users.

@Controller
public class AppController {

	@Autowired
	HttpSession session;
	
	@GetMapping(value = "/dashboard")
	public String login() {
		return "dashboard";
	}
	
}
