package com.startups.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.startups.dao.ProjectDao;
import com.startups.domain.Pledge;
import com.startups.domain.Project;

public class ProjectServiceImplementation implements ProjectService{

	@Autowired 
	ProjectDao projectDao;
	
	
	@Override
	public List<Project> findActiveProjects(boolean active){
		return projectDao.findActiveProjects(active);
	}
	
	
	@Override
	public List<Pledge> findPledgesByProjectId(int projectId) {
		return projectDao.findPledgesByProjId(projectId);
	};
	
	
	@Override
	public String editDesc(String description, int projectId) {
		return projectDao.editDesc(description, projectId);
	};
}
