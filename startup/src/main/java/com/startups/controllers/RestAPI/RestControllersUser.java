package com.startups.controllers.RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startups.dao.ProjectDao;
import com.startups.domain.Project;

@RestController
@RequestMapping("/v1")
public class RestControllersUser {

	@Autowired
	ProjectDao projectDao;

	
// QUERY NOT WORKING	
//	@GetMapping(value="/userprojects/{id}")
//	List<Project> showDataProvided(@PathVariable("id") int id)
//	{
//		return projectDao.findByUserId(id);
//	}	
}
