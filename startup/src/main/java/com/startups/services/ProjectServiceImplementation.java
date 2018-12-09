package com.startups.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startups.dao.ProjectDao;
import com.startups.domain.Pledge;
import com.startups.domain.Project;

@Service
public class ProjectServiceImplementation implements ProjectService{

	@Autowired 
	ProjectDao projDao;
	
	
	@Override
	public List<Project> findActiveProjects(boolean active){
		return projDao.findActiveProjects(active);
	}
	
	
	@Override
	public List<Pledge> findPledgesByProjId(int projId) {
		return projDao.findPledgesByProjId(projId);
	};
	
	
	@Override
	public String editDesc(String description, int projId) {
		return projDao.editDesc(description, projId);
	}


	@Override
	public Project save(Project p1) {
		if (projDao.existsByProjectName(p1.getProjName()))
			return null;
		return projDao.save(p1);
	};
}
