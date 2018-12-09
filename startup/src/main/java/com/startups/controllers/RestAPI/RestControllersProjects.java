package com.startups.controllers.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startups.dao.ProjectDao;
import com.startups.domain.Project;

@RestController
@RequestMapping("/v1")
public class RestControllersProjects {

	@Autowired
	ProjectDao projectDao;
	
	@GetMapping("/projects")
	List<Project> myRestProjects()
	{
		return projectDao.findActiveProjects(true);
	}
	
}
