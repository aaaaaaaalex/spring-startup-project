package com.startups.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.startups.dao.RoleDao;
import com.startups.dao.UserDao;
import com.startups.domain.Role;
import com.startups.domain.User;


@Controller
@Validated
public class RegistrationController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping(value="/register")
	public String registerUser(User user) {
		
		Role role = new Role(user.getEmail(), "ROLE_USER");
		roleDao.save(role);
		
		user.setUserRole(role);
		user.setPassword( passwordEncoder.encode( user.getPassword() ));
		user.setUserEnabled(true);
		
		userDao.save(user);
		
		return "redirect:login?signedUp";
	}
}
