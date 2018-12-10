package com.startups.controllers;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.startups.dao.ProjectDao;
import com.startups.domain.*;

@Controller
public class MainController {
	
	@Autowired
	ProjectDao projectDao;
	
	@GetMapping(value= {"/", "/index"})
	public String handleIndexRequest(Locale locale, Model model)
	{
		List<Project> projects = projectDao.findActiveProjects(true);
		model.addAttribute("projects", projects);
		return "index";
	}
	
	@GetMapping(value="/projects")
	public String handleIndexRequest(Model model)
	{
		List<Project> projects = projectDao.findActiveProjects(true);
		model.addAttribute("projects", projects);
		return "projects";
	}
	
}
