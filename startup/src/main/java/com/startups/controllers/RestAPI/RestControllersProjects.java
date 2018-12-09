package com.startups.controllers.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startups.dao.ProjectDao;
import com.startups.domain.Project;

@RestController
@RequestMapping("/api")
public class RestControllersProjects {

	@Autowired
	ProjectDao projectDao;
	
	@GetMapping("/projects")
	List<Project> myRestProjects()
	{
		return projectDao.findActiveProjects(true);
	}
	
	@PostMapping("/projects")
	List<Project> myRestProjectsAsOrdered()
	{
		return projectDao.findAll();
	}
	
	@DeleteMapping("/project/{projectName}")
	ResponseEntity<Project> deleteProjectByName(@PathVariable(name="projectName") String projectName)
	{
		Project project = (Project) projectDao.findByProjectName(projectName);
		if ( project == null )
		{
			return new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
		}
        projectDao.delete(project);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
}
