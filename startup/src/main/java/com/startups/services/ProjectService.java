package com.startups.services;

import java.util.List;

import com.startups.domain.Pledge;
import com.startups.domain.Project;

public interface ProjectService {
	
	//Functions executable on Projects
	List<Project> findActiveProjects(boolean active);
	List<Pledge> findPledgesByProjId(int id);
	String editDesc(String description, int projId);
	Project save(Project p1);
}
