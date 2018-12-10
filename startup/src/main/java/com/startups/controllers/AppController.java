package com.startups.controllers;


import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.startups.dao.ProjectDao;
import com.startups.dao.UserDao;
import com.startups.domain.Project;
import com.startups.domain.User;
import com.startups.services.ProjectService;

// "APP" refers to pages/functionality intended for authenticated users.

@Controller
public class AppController {
	
	@Autowired
	ProjectDao projectDao;
	
	@Autowired
	UserDao userDao;

	@Autowired
	HttpSession session;
	
	@GetMapping(value = "/dashboard")
	public String login() {
		return "dashboard";
	}
	
	@GetMapping("/addproject")
	public String addNewProjectForm(Model model)
	{
		model.addAttribute("project", new Project());
		return "addproject";
	}
	
	@PostMapping("/addproject")
	public String addNewProjectSave(Project project, @RequestParam int userId)
	{
		User user = userDao.getOne(userId);
		project.setUser(user);
		Date date = new Date();
		project.setDoc(date);
		
		return "redirect:myprojects";
	}
	
}
